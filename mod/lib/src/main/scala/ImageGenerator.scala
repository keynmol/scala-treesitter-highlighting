package scala_highlight.lib

import ts_highlight.HighlightToken

import cairo.all.*
import scalanative.unsafe.*, scalanative.unsigned.*
import ts_highlight.themes.*
import ts_highlight.themes.Theme.Container

extension (c: Ptr[cairo_t])
  def setColor(col: Color) =
    cairo_set_source_rgb(
      c,
      col.r.toDouble / 255d,
      col.g.toDouble / 255d,
      col.b.toDouble / 255d
    )

def generate_image(
    contents: String,
    tokens: List[HighlightToken],
    FONT_SIZE: Int = 50,
    PADDING: Int = 50
) =
  val freetypeLibrary = stackalloc[FT_Library]()
  assert(FT_Init_FreeType(freetypeLibrary).value == 0)

  val freetypeFace = stackalloc[FT_Face]()
  check(
    FT_New_Memory_Face(
      !freetypeLibrary,
      Resources.FONT.at(0).asInstanceOf[Ptr[FT_Byte]],
      FT_Long(Resources.FONT.length.toSize),
      FT_Long(0L.toSize),
      freetypeFace
    )
  )

  check(
    FT_Set_Pixel_Sizes(
      !freetypeFace,
      FT_UInt(FONT_SIZE.toUInt),
      FT_UInt(FONT_SIZE.toUInt)
    )
  )

  val surface =
    cairo_image_surface_create(_cairo_format.CAIRO_FORMAT_ARGB32, 4096, 4096)

  val cairo = cairo_create(surface)
  val cairoFreetypeFace =
    cairo_ft_font_face_create_for_ft_face(!freetypeFace, 0)

  cairo_set_font_face(cairo, cairoFreetypeFace)
  cairo_set_font_size(cairo, FONT_SIZE)

  // Background
  // cairo_set_source_rgb(cairo, 31.c, 31.c, 40.c)
  cairo.setColor(rgb"#1f1f28")
  cairo_paint(cairo)

  val summary = size_text(cairo, contents, tokens, 20f, Theme.Kanagawa)

  // cairo.setColor(rgb"#ffffff")
  // cairo_rectangle(cairo, PADDING, PADDING, summary.width, summary.height)
  // cairo_stroke(cairo)

  println(summary.width)
  println(summary.height)

  Zone:
    summary.tokens.foreach: token =>
      println(token)
      cairo.setColor(token.color)
      cairo_move_to(cairo, PADDING + token.x, PADDING + token.y)
      cairo_show_text(cairo, toCString(token.str))

  val newSurface =
    cairo_image_surface_create(
      _cairo_format.CAIRO_FORMAT_ARGB32,
      PADDING.toInt + summary.width.toInt + PADDING.toInt,
      PADDING.toInt + summary.height.toInt + PADDING.toInt
    )

  val newCairo = cairo_create(newSurface)

  cairo_set_source_surface(newCairo, surface, 0, 0)
  cairo_paint(newCairo)

  cairo_surface_write_to_png(newSurface, c"colored_scala_output.png")

end generate_image

case class Summary(
    width: Double,
    height: Double,
    tokens: List[PositionedToken]
)
case class PositionedToken(str: String, x: Double, y: Double, color: Color):
  override def toString(): String = s"[`$str` at x=$x, y=$y]"

def size_text(
    cairo: Ptr[cairo_t],
    str: String,
    tokens: List[HighlightToken],
    lineSpacing: Float,
    theme: Theme
): Summary =
  val extents = stackalloc[cairo_text_extents_t]()
  val baseExtents = stackalloc[cairo_text_extents_t]()

  var width = 0.0
  var height = 0.0

  val positionedTokens = List.newBuilder[PositionedToken]

  val lineBreaks =
    val b = Array.newBuilder[Int]
    var i = 0
    str.foreach: c =>
      if c == '\n' then b += i
      i += 1
    b.result()

  var curLineBreak = 0

  val baseLine = c"P"

  val fallbackColor = theme(Container).text.getOrElse(rgb"#ffffff")
  var lineWidth = 0.0

  cairo_text_extents(
    cairo,
    baseLine,
    baseExtents
  )

  println(lineBreaks.toList)

  Zone:
    tokens.foreach: token =>
      val cg = token.kind.flatMap(CaptureGroup.fromString)
      val color = cg.map(theme.apply).flatMap(_.text).getOrElse(fallbackColor)
      val text = str.slice(token.start, token.finish)

      cairo_text_extents(cairo, toCString(text.replace(' ', '@')), extents)

      if lineBreaks.nonEmpty && curLineBreak < lineBreaks.length then
        if token.start > lineBreaks(curLineBreak) then
          curLineBreak += 1
          width = width.max(lineWidth)
          height += (!baseExtents).height + lineSpacing
          lineWidth = 0
      end if


      if text.trim.nonEmpty then
        positionedTokens += PositionedToken(
          text,
          x = lineWidth,
          y = height,
          color = color
        )
        lineWidth += ((!extents).width).max((!baseExtents).width * text.length)
      else lineWidth += text.count(_.isWhitespace) * (!baseExtents).width


    width = width.max(lineWidth)
    height += (!baseExtents).height + lineSpacing

    Summary(width, height, positionedTokens.result())
end size_text
