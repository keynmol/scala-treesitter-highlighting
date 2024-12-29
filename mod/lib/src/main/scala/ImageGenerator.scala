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
  def setColor(col: Color, alpha: Double) =
    cairo_set_source_rgba(
      c,
      col.r.toDouble / 255d,
      col.g.toDouble / 255d,
      col.b.toDouble / 255d,
      alpha
    )
end extension

def generate_image(
    contents: String,
    tokens: List[HighlightToken],
    theme: Theme,
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

  val summary = size_text(cairo, contents, tokens, 20f, theme)

  Zone:
    summary.tokens.foreach: token =>
      cairo.setColor(token.color)
      cairo_move_to(cairo, PADDING + token.x, PADDING + token.y)
      cairo_show_text(cairo, toCString(token.str))

  val width = PADDING + summary.width + PADDING
  val height = PADDING + summary.height + PADDING

  val newSurface =
    cairo_image_surface_create(
      _cairo_format.CAIRO_FORMAT_ARGB32,
      width.toInt,
      height.toInt
    )

  val newCairo = cairo_create(newSurface)

  newCairo.setColor(rgb"#000000", 0.0)
  cairo_rectangle(newCairo, 0, 0, width, height)
  cairo_fill(newCairo)

  val bgColor = theme
    .lift(Container)
    .flatMap(_.background)
  rounded_rectangle(0, 0, width, height, 25.0, bgColor, newCairo)

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

def rounded_rectangle(
    x: Double,
    y: Double,
    width: Double,
    height: Double,
    corner_radius: Double,
    color: Option[Color],
    cr: Ptr[cairo_t]
) =

  val aspect = 1.0
  val radius = corner_radius / aspect
  val degrees = Math.PI / 180.0

  cairo_new_sub_path(cr);
  cairo_arc(
    cr,
    x + width - radius,
    y + radius,
    radius,
    -90 * degrees,
    0 * degrees
  );
  cairo_arc(
    cr,
    x + width - radius,
    y + height - radius,
    radius,
    0 * degrees,
    90 * degrees
  );
  cairo_arc(
    cr,
    x + radius,
    y + height - radius,
    radius,
    90 * degrees,
    180 * degrees
  );
  cairo_arc(cr, x + radius, y + radius, radius, 180 * degrees, 270 * degrees);
  cairo_close_path(cr);

  // cairo_set_source_rgb(cr, 0.5, 0.5, 1);
  color.foreach: color =>
    cr.setColor(color)
  cairo_fill(cr)
  // cairo_set_source_rgba(cr, 0.5, 0, 0, 0.5);
  // cairo_set_line_width(cr, 10.0);
  // cairo_stroke(cr)
end rounded_rectangle

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

  val baseLine = c"P"

  val fallbackColor = theme(Container).text.getOrElse(rgb"#ffffff")
  var lineWidth = 0.0

  cairo_text_extents(
    cairo,
    baseLine,
    baseExtents
  )

  inline def handleToken(text: String, color: Color)(using Zone) =
    cairo_text_extents(cairo, toCString(text.replace(' ', '@')), extents)

    if text.trim.nonEmpty then
      positionedTokens += PositionedToken(
        text,
        x = lineWidth,
        y = height,
        color = color
      )
      lineWidth += ((!extents).width).max((!baseExtents).width * text.length)
    else lineWidth += text.count(_.isWhitespace) * (!baseExtents).width
  end handleToken

  extension (d: String)
    def splitWithDelimiters(s: Char) =
      val sb = new StringBuilder
      val segments = List.newBuilder[String]
      val ds = s.toString
      d.foreach: c =>
        if c == s then
          if sb.length != 0 then
            segments += sb.result
            sb.clear()
          end if
          segments += ds
        else sb.addOne(c)

      if sb.length > 0 then segments += sb.result

      segments.result

  Zone:
    tokens.foreach: token =>
      val cg = token.kind.flatMap(CaptureGroup.fromString)
      val color =
        cg.flatMap(theme.lift.apply).flatMap(_.text).getOrElse(fallbackColor)
      val text = str.slice(token.start, token.finish)

      text
        .splitWithDelimiters('\n')
        .foreach:
          case "\n" =>
            width = width.max(lineWidth)
            height += (!baseExtents).height + lineSpacing
            lineWidth = 0
          case other =>
            handleToken(other, color)

    Summary(width, height, positionedTokens.result())
end size_text
