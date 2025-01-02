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

  lazy val switches: List[(Int, Int, String)] = matches.toList
    .flatMap: m =>
      m.captures.map: capture =>
        (
          index.resolve(capture.node.startPoint),
          index.resolve(capture.node.endPoint),
          capture.name(query)
        )

  lazy val tokens: Array[HighlightToken] =
    val sortedSwitches =
      switches.zipWithIndex.sortBy(sw => sw._1._1 -> sw._2).map(_._1)

    val breakpoints = Vector.newBuilder[Int]

    sortedSwitches.headOption.foreach: (start, _, _) =>
      if start != 0 then breakpoints += 0

    sortedSwitches.foreach: (start, _end, group) =>
      breakpoints += start
      breakpoints += _end

    sortedSwitches.lastOption.foreach: (__, end, _) =>
      if end != source.length - 1 then breakpoints += source.length - 1

    val points = breakpoints.result().distinct.sorted

    if points.length < 2 then Array.empty
    else
      /** WARNING: this is very slow.
        *
        * It performs a linear search for each interval. It's probably just fast
        * enough for most snippets, but it won't be winning any benchmark
        * prizes. We need something like an interval tree (a self balancing one,
        * and not sensitive to overlaps).
        */
      points
        .sliding(2)
        .toVector
        .map:
          case Vector(start, end) =>
            val g = sortedSwitches
              .filter((groupStart, groupEnd, group) =>
                groupStart <= start && groupEnd >= end
              )
              .sortBy((groupStart, groupEnd, _) =>
                (start - groupStart, groupEnd - end)
              )
              .headOption
            HighlightToken(start, end, g.map(_._3))
        .toArray
    end if
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
