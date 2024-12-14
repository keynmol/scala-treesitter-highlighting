package ts_highlight

import scala.annotation.*

trait TreesitterInterface:
  type Tree
  extension (t: Tree)  def rootNode: Node

   def parse(source: String): Tree

   def getLanguage: Language

  type Point
  extension (p: Point)
     def row: Int
     def column: Int

  type Language
  extension (t: Language)  def query(source: String): Query

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
     def nodes: Iterable[Node]

  type Query
  extension (q: Query)  def captures(node: Node): Iterable[Capture]
end TreesitterInterface
