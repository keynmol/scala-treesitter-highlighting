package ts_highlight

import io.github.treesitter.jtreesitter as JTS
import scala.annotation.targetName
import scala.jdk.CollectionConverters.*
import java.util.stream.Collector
import java.util.stream.Collectors

class TreeSitter(language: JTS.Language) extends TreeSitterInterface:

  val parser = JTS.Parser(language)

  extension (t: Tree) override def rootNode: Node = t.getRootNode

  override def parse(source: String): Tree =
    parser.parse(source).orElseThrow()

  extension (p: Point)
    override def row: Int = p.row()
    override def column: Int = p.column()

  extension (t: Language)
    override def query(source: String): Query = JTS.Query(t, source)

  extension (t: Node)
    override def children: Iterable[Node] = t.getChildren().asScala
    override def startPoint: Point = t.getStartPoint()
    override def endPoint: Point = t.getEndPoint()
    override def text(source: String): String = t.getText()

  extension (t: Capture)
    @targetName("capture_name")
    override def name(q: Query): String = captureName(t)
    override def node: Node = captureNode(t)

  extension (t: Match)
    override def captures: Iterable[Capture] = matchCaptures(t)


  extension (q: Query)
    override def matches(node: Node): Iterable[Match] =
      val cur = JTS.QueryCursor(q)
      cur.findMatches(node).collect(Collectors.toList()).asScala

  override opaque type Language = JTS.Language
  override opaque type Point = JTS.Point
  override opaque type Node = JTS.Node
  override opaque type Capture = JTS.QueryCapture
  override opaque type Match = JTS.QueryMatch
  override opaque type Tree = JTS.Tree
  override opaque type Query = JTS.Query

  override def getLanguage: Language = language
end TreeSitter

private def captureNode(t: JTS.QueryCapture) = t.node()
private def matchCaptures(t: JTS.QueryMatch) = t.captures().asScala
private def captureName(t: JTS.QueryCapture) = t.name()
