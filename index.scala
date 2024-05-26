//> using platform scala-js
//> using dep org.scala-js::scalajs-dom::2.8.0
//> using dep com.olvind::scalablytyped-runtime::2.4.2
//> using dep com.raquo::laminar::17.0.0
//> using scala 3.5.0-RC1

import org.scalajs.dom.*
import scalajs.js, js.annotation.*, js.Dynamic.literal as J, js.Array as A
import scala.scalajs.js.Promise
import com.raquo.laminar.api.L.*

@js.native @JSImport("/tree-sitter-scala.wasm?init&url", JSImport.Default)
val imgUrl: String = js.native

@js.native @JSImport("/highlights.scm?raw", JSImport.Default)
val highlightQueries: String = js.native

@js.native @JSImport("/index.scala?raw", JSImport.Default)
val indexScala: String = js.native

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
    def matches(node: Node): A[Match] = js.native
    def captures(node: Node): A[Capture] = js.native

  @js.native
  trait Tree extends js.Any:
    val rootNode: Node = js.native

  @js.native
  trait Node extends js.Any:
    val id: Int = js.native
    val children: A[Node] = js.native
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
  val codeVar = Var(
    indexScala.trim().linesWithSeparators.mkString
  )
  val annotatedCodeVar = Var("")
  val query = lang.query(highlightQueries)
  val debugToggled = Var(false)
  div(
    textArea(
      rows := 10,
      styleAttr := "width: 100%",
      onInput.mapToValue --> codeVar,
      value <-- codeVar
    ),
    div(
      styleAttr := "display: grid",
      code(
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

            def annotate(text: String, captures: A[Parser.Capture]): String =
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
        display <-- debugToggled.signal.map(
          if _ then display.block.value else display.none.value
        ),
        pre(
          child.text <-- annotatedCodeVar
        )
      )
    )
  )
end app

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
