package scala_highlight.bin

import mainargs.{main, arg, ParserForMethods, Flag}
import java.nio.file.Path
import java.nio.file.Paths
import ts_highlight.themes.Theme
import scala_highlight.lib.*

object Main:
  @main
  def markdown(
      @arg(doc = "Input markdown file")
      in: String,
      @arg(doc = "Output markdown file (when not provided, print to stdout)")
      out: Option[String] = None,
      @arg(doc = "Theme")
      theme: String = "kanagawa"
  ) =
    val contents =
      if in == "-" then
        scala.io.Source
          .fromInputStream(System.in)
          .getLines()
          .mkString(System.lineSeparator())
      else
        scala.io.Source
          .fromFile(Paths.get(in).toFile)
          .getLines()
          .mkString(System.lineSeparator())

    highlight_markdown_file(
      contents,
      out.map(Paths.get(_)),
      Theme.fromString(theme)
    ).foreach(println)
  end markdown

  @main
  def image(
      @arg(doc = "Scala snippet")
      in: String,
      @arg(doc = "Output PNG file location")
      out: String,
      @arg(doc = "Theme")
      theme: String = "kanagawa",
      @arg()
      fontSize: Int = 50
  ) =
    val contents =
      if in == "-" then
        scala.io.Source
          .fromInputStream(System.in)
          .getLines()
          .mkString(System.lineSeparator())
      else
        scala.io.Source
          .fromFile(Paths.get(in).toFile())
          .getLines()
          .mkString(System.lineSeparator())
    val tokens = highlight_scala_snippet(contents).toList
    val th =
      Theme.fromString(theme).getOrElse(sys.error(s"Unknown theme `$theme`"))

    generate_image(
      contents = contents,
      tokens = tokens,
      theme = th,
      out = out,
      FONT_SIZE = fontSize
    )
  end image

  def main(args: Array[String]): Unit = ParserForMethods(this).runOrExit(args)
end Main
