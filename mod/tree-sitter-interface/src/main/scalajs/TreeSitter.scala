package ts_highlight

import scalajs.js
import js.annotation.*
import js.Array as Arr

class TreeSitter(p: Parser.type) extends TreeSitterInterface:
  override opaque type Tree = p.Tree
  override opaque type Point = p.Point
  override opaque type Language = p.Language
  override opaque type Node = p.Node
  override opaque type Match = p.Match
  override opaque type Capture = p.Capture
  override opaque type Query = p.Query

  override inline def getLanguage = p.getLanguage()
  override inline def parse(source: String) = p.parse(source)

  extension (t: Tree) override inline def rootNode = t.rootNode

  extension (q: Query)
    override inline def matches(node: Node): Iterable[Match] =
      q.matches(node).toArray

  extension (m: Match)
    override inline def captures =
      m.captures

  extension (t: Capture)
    @annotation.targetName("capture_name")
    override inline def name(q: Query): String = t.name
    override inline def node = t.node


  extension (t: Node)
    override inline def children: Iterable[Node] = t.children.toArray
    override inline def startPoint = t.startPosition
    override inline def endPoint = t.endPosition
    override inline def text(source: String) = t.text

  extension (p: Point)
    override inline def column: Int = p.column
    override inline def row: Int = p.row

  extension (q: Language)
    override inline def query(source: String): Query = q.query(source)

end TreeSitter

@js.native
@JSImport("/tree-sitter.js", JSImport.Default)
private object Parser extends js.Any:
  def parse(path: String): Tree = js.native

  def getLanguage(): Language = js.native

  @js.native
  trait Language extends js.Any:
    def query(source: String): Query = js.native

  @js.native
  trait Query extends js.Any:
    def matches(node: Node): Arr[Match] = js.native

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
    val captures: Arr[Capture] = js.native

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
