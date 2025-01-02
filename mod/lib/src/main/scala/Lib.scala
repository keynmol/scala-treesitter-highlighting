package scala_highlight.lib

import scalanative.unsafe.*
import ts_highlight.*
import tree_sitter.structs.TSLanguage
import scala.util.Using
import java.io.FileWriter
import java.io.File
import java.nio.file.Path
import ts_highlight.themes.CaptureGroup
import ts_highlight.themes.{Theme, CaptureGroup}, Theme.*
import java.io.ByteArrayOutputStream
import scala_highlight.lib.Resources.QUERIES

def tree_sitter_scala(): Ptr[TSLanguage] = extern

def highlight_markdown_file(
    code: String,
    out: Option[Path],
    theme: Option[Theme] = None
) =
  import cmark.all.*, scalanative.libc
  Zone:
    val str = toCString(code)

    val node = cmark_parse_document(str, libc.string.strlen(str), 0)

    val lines = code.linesIterator.toList

    val parser = tree_sitter.all.ts_parser_new()
    val lang = tree_sitter_scala()

    val ts = TreeSitter(parser, lang)

    val mentionedGroups = collection.mutable.Set.empty[CaptureGroup]

    def iterateNodes(node: Ptr[cmark_node]) =
      val cuts = List.newBuilder[(Int, Int, Array[String])]
      def go(nd: Ptr[cmark_node]): Unit =
        val iter = cmark_iter_new(nd)
        var ev_type: cmark_event_type = cmark_event_type.CMARK_EVENT_NONE

        while {
            ev_type = cmark_iter_next(iter); ev_type
          } != cmark_event_type.CMARK_EVENT_DONE
        do
          val cur = cmark_iter_get_node(iter)
          val tpe =
            cmark_node_get_type(cur) == cmark_node_type.CMARK_NODE_CODE_BLOCK

          if tpe then
            val fence =
              fromCString(cmark_node_get_fence_info(cur)).split(" ").toList
            val code =
              fromCString(cmark_node_get_literal(cur))

            val shouldReplace =
              fence match
                case List("scala")                          => true
                case List("scala", "mdoc")                  => true
                case List("scala", "mdoc:compile-only")     => true
                case List("scala", "mdoc:reset")            => true
                case List("scala", "mdoc:passthrough")      => false
                case List("scala", "mdoc:nest:passthrough") => false
                case _                                      => false

            if shouldReplace then
              val lineStart = cmark_node_get_start_line(cur) - 1
              val columnStart = cmark_node_get_start_column(cur) - 1
              val lineEnd = cmark_node_get_end_line(cur) - 1
              val highlight = HighlightTokenizer(code, Resources.QUERIES, ts)

              val indent = " " * (columnStart + 1)

              val builder = new StringBuilder
              builder.addAll("\n\n" + indent + "<pre class='ts-hl'><code>")

              highlight.tokens.foreach: tok =>
                tok.kind.foreach: k =>
                  CaptureGroup.fromString(k).foreach(mentionedGroups += _)

                builder.addAll(
                  s"<span class='${tok.kind.map(k => "ts-hl-" + k.replace('.', '-')).getOrElse("")}'>${code
                      .slice(tok.start, tok.finish)}</span>"
                )

              builder.addAll(s"</pre></code>\n\n")

              cuts.addOne(
                lineStart,
                lineEnd,
                builder.result().linesIterator.toArray
              )
            end if
          end if

        end while

      end go

      go(node)
      cuts.result()
    end iterateNodes

    val cuts = iterateNodes(node).sortBy(_._1).toArray
    var currentCutIdx = 0
    inline def currentCut = cuts(currentCutIdx)
    val content = List.newBuilder[String]
    lines.zipWithIndex.foreach: (line, idx) =>
      if currentCutIdx <= cuts.length - 1 then
        if idx < currentCut._1 then content += line
        else if idx == currentCut._1 then content.addAll(currentCut._3)
        else if idx == currentCut._2 then currentCutIdx += 1
      else content += line

    val result =
      content.result().mkString(System.lineSeparator()) + theme
        .map(t => "\n\n" + Theme.buildCSS(t, mentionedGroups.toSet))
        .map(s =>
          s"\n\n<style type = 'text/css'>pre.ts-hl{padding: 15px}\n$s</style>\n\n"
        )
        .getOrElse("")

    out match
      case None => Some(result)
      case Some(path) =>
        Using.resource(FileWriter(path.toFile())): f =>
          f.write(result)
          None
end highlight_markdown_file

def highlight_scala_snippet(snippet: String) =
  Zone:
    val parser = tree_sitter.all.ts_parser_new()
    val lang = tree_sitter_scala()
    val ts = TreeSitter(parser, lang)
    val highlight = HighlightTokenizer(snippet, QUERIES, ts)

    highlight.tokens

object Resources:
  lazy val QUERIES = io.Source
    .fromInputStream(getClass().getResourceAsStream("/highlights.scm"))
    .getLines()
    .mkString(System.lineSeparator())

  lazy val FONT: Array[Byte] =
    val is = getClass().getResourceAsStream("/cairo.ttf")
    val boas = new ByteArrayOutputStream
    try
      val buffer = Array.ofDim[Byte](1024)
      var bytesRead: Int = 0

      while { bytesRead = is.read(buffer); bytesRead != -1 } do
        boas.write(buffer, 0, bytesRead);

      boas.toByteArray()
    finally is.close()
    end try
  end FONT
end Resources
