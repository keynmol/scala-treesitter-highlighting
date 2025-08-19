package ts_highlight.http

import org.http4s.implicits.*
import org.http4s.dsl.io.*
import cats.effect.*
import cats.syntax.all.*
import org.http4s.HttpRoutes
import org.http4s.ember.server.EmberServerBuilder
import com.comcast.ip4s.*
import scribe.cats.io as Log
import cats.data.Kleisli
import fs2.io as FIO

extension (ioa: IO.type)
  def runtimeError(msg: String) = IO.raiseError(new RuntimeException(msg))

case class Config(
    highlighterCLIPath: FIO.file.Path,
    tmpDir: FIO.file.Path
)
object Config:
  def bootstrapFromEnv =
    (
      IO.envForIO
        .get("HIGHLIGHTER_CLI_PATH")
        .flatMap(
          _.map(p => IO.pure(FIO.file.Path(p)))
            .getOrElse(
              IO.runtimeError(
                "HIGHLIGHTER_CLI_PATH env variable not set"
              )
            )
        ),
      FIO.file.Files.forIO.createTempDirectory
    )
      .mapN(Config.apply)
end Config

object HighlighterApp extends ResourceApp.Forever:
  def routes(config: Config) =
    HttpRoutes.of[IO]:
      case request @ PUT -> Root / "api" / "persist" =>
        val id = 25
        request
          .as[String]
          .flatMap: code =>
            val persist = upickle.default.read[Msg.Persist](code)
            val outputPath =
              (config.tmpDir / (id.toString() + ".png")).toString
            val process = FIO.process
              .ProcessBuilder(
                config.highlighterCLIPath.toString,
                "image",
                "--in",
                "-",
                "--out",
                outputPath,
                "--theme",
                persist.theme
              )
              .spawn[IO]
              .use: process =>
                val in = fs2.Stream
                  .emit(persist.code)
                  .through(fs2.text.utf8.encode)
                  .through(process.stdin)
                val err = process.stderr
                  .through(fs2.text.utf8Decode)
                  .through(fs2.text.lines)
                  .evalTap(s => Log.info("ERR " + s))
                val out = process.stdout
                  .through(fs2.text.utf8Decode)
                  .through(fs2.text.lines)
                  .evalTap(s => Log.info("OUT " + s))

                err
                  .concurrently(in)
                  .concurrently(out)
                  .compile
                  .drain

            end process

            process *> Ok(outputPath)
  end routes

  override def run(args: List[String]): Resource[IO, Unit] =
    Config.bootstrapFromEnv.toResource.flatMap: config =>
      EmberServerBuilder
        .default[IO]
        .withHost(host"0.0.0.0")
        .withPort(
          args.headOption
            .flatMap(_.toIntOption)
            .flatMap(Port.fromInt)
            .getOrElse(port"8080")
        )
        .withHttpApp(
          routes(config).orNotFound.handleErrorWith(err =>
            Kleisli(req =>
              Log
                .error(req.toString, err)
                .flatMap(_ => InternalServerError("Server failure"))
            )
          )
        )
        .build
        .evalMap(serv =>
          IO.consoleForIO.errorln(s"Server started on ${serv.baseUri}")
        )
end HighlighterApp
