package ts_highlight.http

import upickle.default.*

object Msg:
  case class Persist(code: String, theme: String) derives ReadWriter
