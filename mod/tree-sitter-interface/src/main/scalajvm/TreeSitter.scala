package ts_highlight

import io.github.treesitter.jtreesitter as JTS
import scala.annotation.targetName

class TreeSitter(language: JTS.Language) extends TreeSitterInterface:

  val parser = JTS.Parser(language)

  extension (t: Tree) override def rootNode: Node = ???

  override def parse(source: String): Tree = 
    parser.parse(source).orElseThrow()

  extension (p: Point) override def row: Int = ???

  extension (p: Point) override def column: Int = ???

  extension (t: Language) override def query(source: String): Query = ???

  extension (t: Node) override def children: Iterable[Node] = ???

  extension (t: Node) override def startPoint: Point = ???

  extension (t: Node) override def endPoint: Point = ???

  extension (t: Node) override def text(source: String): String = ???

  extension (t: Capture) 
    @targetName("capture_name")
    override def name(q: Query): String = ???

  extension (t: Capture) override def node: Node = ???

  extension (t: Match) override def captures: Iterable[Capture] = ???

  extension (q: Query) override def matches(node: Node): Iterable[Match] = ???

  override opaque type Language = JTS.Language
  override opaque type Point = JTS.Point
  override opaque type Node = JTS.Node
  override opaque type Capture = JTS.QueryCapture
  override opaque type Match = JTS.QueryMatch
  override opaque type Tree = JTS.Tree

  override def getLanguage: Language = ???
