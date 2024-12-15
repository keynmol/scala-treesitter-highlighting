package ts_highlight.webapp

import com.raquo.laminar.api.L.*
import org.scalajs.dom.*

import scalajs.js
import js.annotation.*
import js.Array as Arr

import ts_highlight.*

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

def app(treesitter: TreeSitter) =
  val lang = treesitter.getLanguage
  val key = "syntax-highlighter-code"
  val codeVar = Var(
    org.scalajs.dom.window.localStorage.getItem(key) match
      case s: String =>
        s
      case null => SAMPLE_CODE
  )
  val annotatedCodeVar = Var("")
  val debugToggled = Var(false)
  div(
    codeVar.signal --> { value =>
      org.scalajs.dom.window.localStorage.setItem(key, value)
    },
    styleAttr := "width: 80%; margin:auto",
    h1("Scala syntax highlighter based on TreeSitter"),
    p(
      i(
        "This project is very much a work-in-progress - there are quite obvious bugs and missing niceties."
      )
    ),
    p(
      a(
        "Github",
        href := "https://github.com/keynmol/scala-treesitter-highlighting"
      )
    ),
    h2("Scala code:"),
    textArea(
      rows := 10,
      styleAttr := "width: 100%",
      onInput.mapToValue --> codeVar,
      value <-- codeVar
    ),
    input(tpe := "checkbox", onClick.mapToChecked --> debugToggled),
    "Debug?",
    div(
      styleAttr := "display: flex",
      code(
        styleAttr := "flex: 1",
        pre(
          cls := "hlts-container",
          children <-- codeVar.signal.map { sourceCode =>
            val highlight =
              HighlightTokenizer(
                sourceCode,
                highlightQueries,
                treesitter
              ).tokens.toList

            val elements = List.newBuilder[HtmlElement]

            highlight.foreach: token =>
              elements.addOne(
                span(
                  sourceCode.slice(token.start, token.finish),
                  token.kind.map(c => cls := "hlts-" + c.replace('.', '-'))
                )
              )

            elements.result()
          }
        )
      ),
      code(
        styleAttr := "background: black; color: white",
        display <-- debugToggled.signal.map(
          if _ then display.block.value else display.none.value
        ),
        pre(
          child.text <-- annotatedCodeVar
        )
      )
    ),
    ackn
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
  // val annots = captures.groupMap(_.node.startPoint.row)(identity)
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

val ackn =
  div(
    h2("Acknowledgements", idAttr := "acknowledgements"),
    p(
      "Thanks to the current and past contributors to ",
      a(
        "Tree Sitter Scala grammar",
        href := "https://github.com/tree-sitter/tree-sitter-scala"
      ),
      ", authors of Tree Sitter itself",
      ", the author of ",
      a(
        "Kanagawa Neovim theme",
        href := "https://github.com/rebelot/kanagawa.nvim/"
      ),
      ", and countless authors and contributors to Scala and JavaSript tooling, without whom this work wouldn't be posislbe"
    )
  )

class Index[T <: TreeSitter & Singleton](text: String, val ts: T):
  val mapping: Map[Int, (Int, String)] =
    var curOffset = 0
    val spl = text.split("\n")
    val result = List.newBuilder[(Int, (Int, String))]
    for i <- 0 until spl.length
    do
      result.addOne(i -> (curOffset, spl(i)))
      curOffset += spl(i).length() + 1

    result.result().toMap
  end mapping

  def resolve(point: ts.Point): Int =
    mapping(point.row) match
      case (curOffset, _) =>
        curOffset + point.column

end Index

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
