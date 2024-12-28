package ts_highlight.themes

import org.typelevel.literally.*

extension (inline ctx: StringContext)
  inline def rgb(inline args: Any*): Color =
    ${ ColorLiteral('ctx, 'args) }

case class Color(r: Int, g: Int, b: Int)
object Color:
  def fromString(
      str: String
  ): Either[String, Color] =
    if str.startsWith("#") then
      val code = str.stripPrefix("#")
      if code.length != 6 then
        Left(
          "hex color needs to be exactly 6 hex characters long and start with # (total 7 characters)"
        )
      else
        try
          Right(code.grouped(2).map(Integer.parseInt(_, 16)).toArray).map: it =>
            Color(it(0), it(1), it(2))
        catch
          case exc: NumberFormatException =>
            Left("Failed to parse part of the color: " + exc.getMessage())
      end if
    else
      str.split(",").map(_.trim).toList match
        case r :: g :: b :: Nil =>
          try Right(Color(r.toInt, g.toInt, b.toInt))
          catch
            case exc: NumberFormatException =>
              Left("Failed to parse part of the color: " + exc.getMessage())
        case _ =>
          Left(
            "color should either be a comma separated triplet of decimal RGB values (example: `127,240,11`) or a hex code (example: `#00ff99`)"
          )
end Color

object ColorLiteral extends Literally[Color]:
  def validate(s: String)(using Quotes) =
    Color.fromString(s) match
      case Left(err) => Left(err)
      case Right(_)  => Right('{ Color.fromString(${ Expr(s) }).right.get })
