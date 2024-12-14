package ts_highlight

import scala.annotation.*

trait TreesitterInterface:
  type Tree
  extension (t: Tree) inline def rootNode: Node

  inline def parse(source: String): Tree

  inline def getLanguage: Language

  type Point
  extension (p: Point)
    inline def row: Int
    inline def column: Int

  type Language
  extension (t: Language) inline def query(source: String): Query

  type Node
  extension (t: Node)
   inline def children: Iterable[Node]
   inline def startPoint: Point
   inline def endPoint: Point
   inline def text: String

  type Match
  extension (t: Match) inline def name: String

  type Capture
  extension (t: Capture)
    @targetName("capture_name")
    inline def name: String
    inline def node: Node
    inline def text: Option[String]

  type Query
  extension (q: Query)
    inline def matches(node: Node): Iterable[Match]
    inline def captures(node: Node): Iterable[Capture]
end TreesitterInterface
