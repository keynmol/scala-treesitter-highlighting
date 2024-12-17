package ts_highlight.webapp

import com.raquo.laminar.api.L.*
import org.scalajs.dom.*

import scalajs.js
import js.annotation.*
import js.Array as Arr

import ts_highlight.*
import ts_highlight.themes.Theme
import ts_highlight.themes.CaptureGroup
import com.raquo.airstream.web.WebStorageVar

@js.native @JSImport("/tree-sitter-scala.wasm?init&url", JSImport.Default)
val imgUrl: String = js.native

@js.native @JSImport("/highlights.scm?raw", JSImport.Default)
val highlightQueries: String = js.native

@js.native @JSImport(
  "web-tree-sitter/tree-sitter.wasm?init&url",
  JSImport.Default
)
val wasmInit: String = js.native

def show(n: Parser.Node) =
  import n.*
  s"Node[${startPosition.row},${startPosition.column} -> ${endPosition.row},${endPosition.column}]"

extension [T <: js.Any](t: T) def dump() = console.log(t)

def codeMirrorTextArea(target: Var[String]) =
  textArea(
    cls := "h-full",
    onInput.mapToValue --> target,
    value <-- target,
    onMountCallback(el =>
      CodeMirror
        .fromTextArea(
          el.thisNode.ref,
          js.Dictionary(
            "value" -> target.now(),
            "lineNumbers" -> true,
            "mode" -> "text/x-scala"
          )
        )
        .on("change", value => target.set(value.getValue()))
    )
  )

def app(treesitter: TreeSitter) =
  val lang = treesitter.getLanguage
  val codeVar = WebStorageVar
    .localStorage("syntax-highlighter-code", None)
    .text(SAMPLE_CODE)
  val annotatedCodeVar = Var("")
  val debugToggled = Var(false)
  val injectCSS = document.getElementById("inject")
  val theme = WebStorageVar.localStorage("theme", None).text("kanagawa")
  val showHLJS =
    WebStorageVar.localStorage("show-highlightjs", None).bool(false)

  def opt(v: String, label: String) =
    option(value := v, label, selected <-- theme.signal.map(_ == v))

  val basicLink =
    cls := "text-indigo-600 hover:no-underline underline"

  val header = div(
    cls := "flex flex-col gap-4",
    h1("Scala code highlighter", cls := "text-4xl"),
    p(
      cls := "text-md",
      "This highlighter uses the Tree Sitter parser for Scala, compiled to WASM. It is much more accurate than any regex-based engines such as Highlight.js or Textmate grammars"
    ),
    p(
      a(
        "Github",
        href := "https://github.com/keynmol/scala-treesitter-highlighting",
        basicLink
      ),
      " | ",
      a(
        "Author",
        href := "https://blog.indoorvivants.com",
        basicLink
      ),
      " | ",
      a(
        "Tree Sitter Scala grammar",
        href := "https://github.com/tree-sitter/tree-sitter-scala/pulls",
        basicLink
      )
    )
  )

  val themeSelector =
    div(
      cls := "flex flex-row gap-4 items-center",
      h2("Theme:", cls := "text-2xl"),
      select(
        cls := "text-2xl bg-white border-2 border-sky-700 p-2 text-black bg-sky-100 borde",
        opt("kanagawa", "Kanagawa"),
        opt("gruvbox", "Gruvbox"),
        opt("vscode", "VS Code (dark)"),
        opt("vscode-light", "VS Code (light)"),
        onChange.mapToValue --> theme
      )
    )

  val scalaCode = div(
    cls := "2xl:w-6/12 h-full overflow-auto",
    h2("Scala code:", cls := "text-2xl"),
    codeMirrorTextArea(codeVar)
  )

  val highlightJSExample = div(
    cls("hidden") <-- showHLJS.signal.map(!_),
    child <-- codeVar.signal.map(code => codeBlock("scala", code))
  )

  val highlightedCode = div(
    cls := "2xl:w-6/12 flex flex-col gap-2",
    themeSelector,
    h3(cls := "text-2xl", "Tree Sitter highlighting:"),
    pre(
      cls := "ts-hl w-full",
      code(children <-- codeVar.signal.combineWith(theme.signal).map {
        (sourceCode, themeName) =>
          val highlight =
            HighlightTokenizer(
              sourceCode,
              highlightQueries,
              treesitter
            ).tokens.toList

          val elements = List.newBuilder[HtmlElement]
          val theme = Theme.fromString(themeName).get
          val groups = scala.collection.mutable.Set.empty[CaptureGroup]

          highlight.foreach: token =>
            token.kind.foreach: k =>
              CaptureGroup.fromString(k).foreach(groups += _)
            elements.addOne(
              span(
                sourceCode.slice(token.start, token.finish),
                token.kind.map(c => cls := "ts-hl-" + c.replace('.', '-'))
              )
            )

          console.log(groups)

          injectCSS.textContent = Theme.buildCSS(theme, groups.toSet)

          elements.result()
      })
    ),
    h3(
      cls := "text-2xl",
      child.text <-- showHLJS.signal.map(if _ then "➖" else "➕"),
      " HighlightJS highlighting:",
      cls := "cursor-pointer",
      onClick.mapToValue --> { _ => showHLJS.update(!_) }
    ),
    highlightJSExample
  )

  div(
    cls := "content mx-auto w-10/12 bg-white/70 p-6 rounded-xl flex flex-col gap-4",
    header,
    div(
      cls := "flex lg:flex-col 2xl:flex-row gap-4 w-full",
      scalaCode,
      highlightedCode
    )

    // code(
    //   styleAttr := "background: black; color: white",
    //   display <-- debugToggled.signal.map(
    //     if _ then display.block.value else display.none.value
    //   ),
    //   pre(
    //     child.text <-- annotatedCodeVar
    //   )
    // )
  )
end app

def annotate[TS <: TreeSitter & Singleton](
    text: String,
    ts: TS,
    query: ts.Query,
    captures: Iterable[ts.Capture]
): String =
  case class CaptureGroup(label: String, node: ts.Node)
  val lines = text.linesIterator.toList.zipWithIndex
  val annots = captures
    .map(c => CaptureGroup(c.name(query), c.node))
    .groupMap(_.node.startPoint.row)(identity)

  val allLines = List.newBuilder[String]

  def indent(capture: CaptureGroup): String =
    " ".*(
      capture.node.startPoint.column
    )

  def mark(capture: CaptureGroup): String =
    "^".*(
      capture.node.text(text).length
    )

  lines.foreach:
    case (line, idx) =>
      allLines += line
      annots
        .get(idx)
        .foreach: matches =>
          matches.foreach: capture =>
            allLines += indent(capture) + mark(
              capture
            ) + " " + capture.label.replace('.', '-')
  allLines.result().mkString("\n")
end annotate

inline def codeBlock(language: String, value: String) =
  pre(
    code(
      cls := s"language-$language",
      onMountCallback(mnt => hljs.highlightElement(mnt.thisNode.ref)),
      value
    )
  )

@main def hello =
  val interface = TreeSitter(Parser)
  render(document.getElementById("content"), app(interface))
end hello

val SAMPLE_CODE =
  """
def grammar(year: Int) =
  inline def token(str: String) =
    atomic(string(str.toLowerCase())) <~ whitespaces.void

  val PLANET_OF_THE_APES = token("Planet of the Apes")
  val FOR = token("for")
  val FROM = token("from")
  val THE = token("the")
  val OF = token("of")
  val BENEATH = token("Beneath")
  val ESCAPE = token("Escape")
  val CONQUEST = token("Conquest")
  val BATTLE = token("Battle")
  val RISE = token("Rise")
  val DAWN = token("Dawn")
  val WAR = token("War")
  val KINGDOM = token("Kingdom")
  val RETURN = token("Return")
  val TO = token("to")

  extension (p: Parsley[Outcome])
    def releasedIn(releaseYear: Int) =
      Option.when(year >= releaseYear)(p)
""".trim
