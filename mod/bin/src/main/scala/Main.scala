package scala_highlight.bin

import scala_highlight.lib.Lib

import mainargs.{main, arg, ParserForMethods, Flag}
import java.nio.file.Path
import scala_highlight.lib.Lib.highlight_markdown_file
import java.nio.file.Paths
import ts_highlight.themes.Theme

object Main:
  @main
  def markdown(
      @arg(doc = "Input markdown file")
      in: String,
      @arg(doc = "Output markdown file")
      out: Option[String] = None,
      @arg(doc = "Theme")
      theme: Option[String] = None
  ) = highlight_markdown_file(
    Paths.get(in),
    out.map(Paths.get(_)),
    theme.flatMap(Theme.fromString)
  )
    .foreach(println)
  end markdown

  def main(args: Array[String]): Unit = ParserForMethods(this).runOrExit(args)
end Main
