package scala_highlight.lib

import scala.quoted.*
import scalanative.unsafe.fromCString
import cairo.aliases.FT_Error
import cairo.functions.FT_Error_String

inline def check(inline expr: => FT_Error): FT_Error = ${ checkImpl('expr) }

private def checkImpl(expr: Expr[FT_Error])(using Quotes): Expr[FT_Error] =
  import quotes.*
  val e = Expr(s"${expr.show.take(500)} failed: ")

  '{
    val code = $expr
    assert(
      code.value == 0,
      $e + "[" + fromCString(FT_Error_String(code)) + "]"
    )
    code
  }
end checkImpl
