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
  val code = Var(
    """
object Parser extends js.Any:
  def hello = 1
""".trim
  )
  val query = lang.query(highlightQueries)
  div(
    textArea(
      rows := 5,
      cols := 50,
      onInput.mapToValue --> code,
      value <-- code
    ),
    pre(children <-- code.signal.map { value =>
      val tree = Parser.parse(value)
      val index = Index(value)
      val matches = query.captures(tree.rootNode)

      val switches = matches
        .flatMap: capture =>
          List(
            (
              index.resolve(capture.node.startPosition),
              index.resolve(capture.node.endPosition),
              capture.name
            )
          )

      val elements = List.newBuilder[HtmlElement]

      // var current: String | Null = null
      var idx = 0
      // var textLength = 0 

      println(index.mapping)


      switches.distinctBy(x => (x._1, x._2)).foreach:
        case (start, end, what) =>
          // if what != current then 
            val textLength = start - idx
            if textLength != 0 then 
              elements.addOne(span(value.slice(idx, start)))
            elements.addOne(span(cls := what, styleAttr := "font-weight:bold", value.slice(start, end)))
            idx = end
          // elements.addOne(p(start, " ", end, " ", what))

      elements.result()

    })
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

    // text.split("\n").zipWithIndex.foldLeft(0 -> ):
    //   case (curOffset, (line, idx)) =>
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
