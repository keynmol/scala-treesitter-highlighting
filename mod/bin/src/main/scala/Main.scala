package scala_highlight.bin

import java.nio.file.Path
import java.nio.file.Paths
import ts_highlight.themes.Theme
import scala_highlight.lib.*

import decline_derive.*
import java.nio.file.Files
import java.io.FileReader

@Name("scala-highlight")
enum CLI derives CommandApplication:
  case Markdown(
      @Help("Input markdown file")
      in: String,
      @Help("Output markdown file (when not provided, print to stdout)")
      out: Option[String] = None,
      @Help("Theme")
      theme: String = "kanagawa"
  )
  case Image(
      @Help("Scala snippet")
      in: String,
      @Help("Output PNG file location")
      out: String,
      @Help("Theme")
      theme: String = "kanagawa",
      fontSize: Int = 50
  )
  case MCP
end CLI

@main def scalaHighlight(args: String*) =
  CommandApplication.parseOrExit[CLI](args) match
    case cli: CLI.Markdown => commandMarkdown(cli)
    case cli: CLI.Image    => commandImage(cli)
    case CLI.MCP           => commandMCP()

def commandMCP() =
  import mcp.*
  MCPBuilder
    .create()
    .handle(initialize): req =>
      InitializeResult(
        capabilities =
          ServerCapabilities(tools = Some(ServerCapabilities.Tools())),
        protocolVersion = req.params.protocolVersion,
        serverInfo = Implementation("scala-highlight-mcp", "0.0.1")
      )
    .handle(tools.list): req =>
      ListToolsResult(
        Seq(
          Tool(
            name = "create_image",
            description = Some(
              "Creates a PNG image with a properly highlighted Scala snippet"
            ),
            inputSchema = Tool.InputSchema(
              properties = Some(
                ujson.Obj(
                  "code" -> ujson.Obj(
                    "type" -> ujson.Str("string"),
                    "desription" -> ujson.Str("Scala code to highlight")
                  )
                )
              ),
              required = Some(Seq("code"))
            )
          )
        )
      )
    .handle(tools.call): req =>
      req.params.name match
        case "create_image" =>
          val code = req.params.arguments.get.obj("code").str
          val tokens = highlight_scala_snippet(code).toList
          val th = Theme.Kanagawa

          val tmp = Files.createTempFile("scala-highlight-mcp", ".png")

          generate_image(
            contents = code,
            tokens = tokens,
            theme = th,
            out = tmp.toAbsolutePath().toString,
            FONT_SIZE = 20
          )

          val b64 = java.util.Base64.getEncoder()

          val bytes = Files.readAllBytes(tmp)
          val b64chars = b64.encodeToString(bytes)

          CallToolResult(
            Seq(ImageContent(b64chars, mimeType = "image/png"))
          )
    .run(SyncTransport.default.verbose)

end commandMCP

def commandMarkdown(cli: CLI.Markdown) =
  import cli.*
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
end commandMarkdown

def commandImage(cli: CLI.Image) =
  import cli.*
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
end commandImage
