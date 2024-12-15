package ts_highlight

case class HighlightToken(start: Int, finish: Int, kind: Option[String])
class HighlightTokenizer[TS <: TreeSitterInterface & Singleton](
    source: String,
    highlightQueries: String,
    treesitter: TS
):
  private lazy val tree = treesitter.parse(source)
  private lazy val index = Index(source, treesitter)
  private lazy val lang = treesitter.getLanguage
  private lazy val query = lang.query(highlightQueries)
  private lazy val matches = query.matches(tree.rootNode)

  private lazy val switches: List[(Int, Int, String)] = matches.toList
    .flatMap: m =>
      m.captures.map: capture =>
        (
          index.resolve(capture.node.startPoint),
          index.resolve(capture.node.endPoint),
          capture.name(query).replace('.', '-')
        )
    .sortBy(x => x._2)

  println(switches)

  lazy val tokens: Array[HighlightToken] =
    val builder = Array.newBuilder[HighlightToken]

    var idx = 0
    switches
      .foreach:
        case (start, end, what) =>
          if idx <= start then
            val textLength = start - idx
            if textLength != 0 then
              builder.addOne(HighlightToken(idx, start, None))
            builder.addOne(
              HighlightToken(start, end, Some(what))
            )
            idx = end
          end if
    builder.result()
  end tokens
end HighlightTokenizer

private class Index[T <: TreeSitterInterface & Singleton](
    text: String,
    val ts: T
):
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

  def resolve(point: ts.Point): Int =
    mapping(point.row) match
      case (curOffset, _) =>
        curOffset + point.column

end Index
