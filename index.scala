//> using platform scala-js
//> using dep org.scala-js::scalajs-dom::2.8.0
//> using dep com.olvind::scalablytyped-runtime::2.4.2
//> using dep com.raquo::laminar::17.0.0
//> using scala 3.5.0-RC1
//> using option -Wunused:all

import com.raquo.laminar.api.L.*
import org.scalajs.dom.*

import scalajs.js
import js.annotation.*
import js.Array as Arr

@js.native @JSImport("/tree-sitter-scala.wasm?init&url", JSImport.Default)
val imgUrl: String = js.native

@js.native @JSImport("/highlights.scm?raw", JSImport.Default)
val highlightQueries: String = js.native

@js.native @JSImport(
  "web-tree-sitter/tree-sitter.wasm?init&url",
  JSImport.Default
)
val wasmInit: String = js.native

@js.native
@JSImport("/tree-sitter.js", JSImport.Default)
object Parser extends js.Any:
  def parse(path: String): Tree = js.native

  def getLanguage(): Language = js.native

  @js.native
  trait Language extends js.Any:
    def query(source: String): Query = js.native

  @js.native
  trait Query extends js.Any:
    def matches(node: Node): Arr[Match] = js.native
    def captures(node: Node): Arr[Capture] = js.native

  @js.native
  trait Tree extends js.Any:
    val rootNode: Node = js.native

  @js.native
  trait Node extends js.Any:
    val id: Int = js.native
    val children: Arr[Node] = js.native
    val text: String = js.native
    val startPosition: Point = js.native
    val endPosition: Point = js.native

  @js.native
  trait Match extends js.Any:
    val name: String = js.native

  @js.native
  trait Capture extends js.Any:
    val name: String = js.native
    val node: Node = js.native
    val text: js.UndefOr[String] = js.native

  @js.native
  trait TreeCursor extends js.Any:
    val nodeId: Int = js.native
    val nodeText: String = js.native

  @js.native
  trait Point extends js.Any:
    val row: Int = js.native
    val column: Int = js.native
end Parser

def show(n: Parser.Node) =
  import n.*
  s"Node[${startPosition.row},${startPosition.column} -> ${endPosition.row},${endPosition.column}]"

extension [T <: js.Any](t: T) def dump() = console.log(t)

enum Switch:
  case On(cls: String)
  case Off(cls: String)

def app(lang: Parser.Language) =
  val key = "syntax-highlighter-code"
  val codeVar = Var(
    org.scalajs.dom.window.localStorage.getItem(key) match
      case s: String =>
        s
      case null =>
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
  )
  val annotatedCodeVar = Var("")
  val query = lang.query(highlightQueries)
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
          children <-- codeVar.signal.map { value =>
            val tree = Parser.parse(value)
            val index = Index(value)
            val matches = query.captures(tree.rootNode)

            val switches = matches
              .map: capture =>
                (
                  index.resolve(capture.node.startPosition),
                  index.resolve(capture.node.endPosition),
                  capture.name.replace('.', '-')
                )
              .sortBy(x => x._2)

            val elements = List.newBuilder[HtmlElement]

            def annotate(text: String, captures: Arr[Parser.Capture]): String =
              val lines = text.linesIterator.toList.zipWithIndex
              val annots = captures.groupMap(_.node.startPosition.row)(identity)
              val allLines = List.newBuilder[String]

              def newMethod(capture: Parser.Capture): String =
                " ".*(
                  capture.node.startPosition.column
                )

              def newMethod0(capture: Parser.Capture): String =
                "^".*(
                  capture.node.text.length
                )

              lines.foreach:
                case (line, idx) =>
                  allLines += line
                  annots
                    .get(idx)
                    .foreach: matches =>
                      matches.foreach: capture =>
                        allLines += newMethod(capture) + newMethod0(
                          capture
                        ) + " " + capture.name.replace('.', '-')
              allLines.result().mkString("\n")
            end annotate

            annotatedCodeVar.set(
              annotate(value, matches) ++ "\n\n--\n\n" + switches.mkString("\n")
            )

            var idx = 0

            switches
              .foreach:
                case (start, end, what) =>
                  if idx <= start then
                    val textLength = start - idx
                    if textLength != 0 then
                      elements.addOne(span(value.slice(idx, start)))
                    elements.addOne(
                      span(
                        cls := "hlts-" + what,
                        value.slice(start, end)
                      )
                    )
                    idx = end
                  end if

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

class Index(text: String):
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

  def resolve(point: Parser.Point): Int =
    mapping(point.row) match
      case (curOffset, _) =>
        curOffset + point.column

end Index

@main def hello =
  val parser = Parser.getLanguage()
  render(document.getElementById("content"), app(parser))
end hello
