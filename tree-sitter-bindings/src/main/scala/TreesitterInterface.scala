package ts_highlight

import scala.annotation.*

trait TreeSitterInterface:
  type Tree
  extension (t: Tree) def rootNode: Node

  def parse(source: String): Tree

  def getLanguage: Language

  type Point
  extension (p: Point)
    def row: Int
    def column: Int

  type Language
  extension (t: Language) def query(source: String): Query

  type Node
  extension (t: Node)
    def children: Iterable[Node]
    def startPoint: Point
    def endPoint: Point
    def text(source: String): String

  type Capture
  extension (t: Capture) 
    @targetName("capture_name")
    def name(q: Query): String
    def node: Node

  type Match
  extension (t: Match)
    def captures: Iterable[Capture]

  type Query
  extension (q: Query) def matches(node: Node): Iterable[Match]
end TreeSitterInterface
