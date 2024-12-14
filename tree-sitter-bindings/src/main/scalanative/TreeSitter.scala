package ts_highlight

import scalanative.unsafe.*
import treesitter_native.all.*
import scala.scalanative.unsigned.*

class TreeSitter(parser: Ptr[TSParser], language: Ptr[TSLanguage])(using
    z: Zone
) extends TreesitterInterface:
  override opaque type Tree = Ptr[TSTree]
  override opaque type Point = Ptr[TSPoint]
  override opaque type Language = Ptr[TSLanguage]
  override opaque type Node = Ptr[TSNode]
  override opaque type Capture = Ptr[TSQueryMatch]
  override opaque type Query = Ptr[TSQuery]

  extension [A: Tag](p: Ptr[A]) inline def DEREF: A = !p

  override inline def getLanguage = language

  @volatile private var langSet = false

  override inline def parse(source: String) =
    val str = toCString(source)
    if !langSet then 
      ts_parser_set_language(parser, language)
      langSet = true
    ts_parser_parse_string(
      parser,
      null,
      str,
      scalanative.libc.string.strlen(str).toUInt
    )

  extension (t: Tree)
    override inline def rootNode =
      val newValue = alloc[TSNode]()
      ts_tree_root_node(t)(newValue)
      newValue

  extension (q: Query)
    override inline def captures(node: Node): Iterable[Capture] =
      val builder = List.newBuilder[Capture]
      val cursor = ts_query_cursor_new()
      ts_query_cursor_exec(cursor, q, node.DEREF);

      val mtch = stackalloc[TSQueryMatch]()
      var hasNext = true
      while { hasNext = ts_query_cursor_next_match(cursor, mtch); hasNext } do
        val deref = !mtch

        builder += treesitter_native.structs.TSQueryMatch.apply(
          deref.id,
          deref.pattern_index,
          deref.capture_count,
          deref.captures
        )(using z)
      builder.result()
    end captures
  end extension

  extension (t: Capture)
    @annotation.targetName("capture_name")
    override inline def name(q: Query): String =
      val str = ts_query_capture_name_for_id(q, t.DEREF.id, stackalloc[UInt]())
      fromCString(str)
    override inline def node: Node =
      val n = alloc[TSNode]()
      !n = t.DEREF.captures.DEREF.node
      n
    override inline def text(source: String): Option[String] =
      Some(node.text(source))
  end extension

  extension (t: Node)
    override inline def children: Iterable[Node] =
      val children = Array.newBuilder[Node]
      val cnt = treesitter_native.functions.ts_node_child_count(t)
      for childId <- 0 until cnt.toInt do
        val node = alloc[TSNode]()
        treesitter_native.functions.ts_node_child(t, childId.toUInt)(node)
        children += node

      children.result()

    override inline def startPoint =
      val sp = alloc[TSPoint]()
      ts_node_start_point(t)(sp)
      sp

    override inline def endPoint =
      val sp = alloc[TSPoint]()
      ts_node_end_point(t)(sp)
      sp

    override inline def text(s: String) =
      val start = ts_node_start_byte(t).toInt
      val finish = ts_node_end_byte(t).toInt

      new String(s.getBytes().slice(start, finish))
  end extension

  extension (p: Point)
    override inline def column: Int = p.DEREF.column.toInt
    override inline def row: Int = p.DEREF.row.toInt

  extension (q: Language)
    override inline def query(source: String): Query =
      Zone:
        val erroffset = stackalloc[UInt]()
        val err = stackalloc[TSQueryError]()
        val querySource = toCString(source)

        val query =
          ts_query_new(
            language,
            querySource,
            scalanative.libc.string.strlen(querySource).toUInt,
            erroffset,
            err
          )
        assert((!erroffset).toInt == 0)

        query

end TreeSitter
