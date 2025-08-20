import bindgen.interface.Binding
import bindgen.interface.LogLevel
import bindgen.plugin.BindgenMode
import com.indoorvivants.detective.Platform, Platform.OS.*
import org.scalajs.linker.interface.ModuleSplitStyle
import sbt.nio.file.FileTreeView
import java.nio.file.StandardCopyOption
import java.nio.file.CopyOption
import java.nio.file.Files

import scala.scalanative.build.LTO
import scala.scalanative.build.SourceLevelDebuggingConfig

Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val BINARY_NAME = "scala-highlight"

inThisBuild(
  List(
    organization := "com.indoorvivants.ts_highlight",
    organizationName := "Anton Sviridov",
    homepage := Some(
      url("https://github.com/indoorvivants/scala-treesitter-highlighting")
    ),
    startYear := Some(2024),
    licenses := List(
      "Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")
    ),
    developers := List(
      Developer(
        "keynmol",
        "Anton Sviridov",
        "keynmol@gmail.com",
        url("https://blog.indoorvivants.com")
      )
    ),
    semanticdbEnabled := !sys.env.contains("CI")
  )
)

val Versions =
  new {
    val Scala3_LTS = "3.3.6"
    val Scala3_Next = "3.7.2"
    val Laminar = "17.2.0"
    val Munit = "1.0.3"
  }

lazy val root =
  project
    .in(file("."))
    .aggregate(webapp)
    .aggregate(treesitterInterface.projectRefs*)
    .aggregate(treesitterBindings)
    .aggregate(cmark)
    .aggregate(lib, bin)
    .settings(publish / skip := true, publishLocal / skip := true)

lazy val webapp =
  project
    .in(file("webapp"))
    .enablePlugins(ScalaJSPlugin) // Enable the Scala.js plugin in this project
    .dependsOn(treesitterInterface.js(true), themes.js(true))
    .settings(publish / skip := true, publishLocal / skip := true)
    .settings(
      scalaVersion := Versions.Scala3_Next,
      scalaJSUseMainModuleInitializer := true,
      scalaJSLinkerConfig ~= {
        _.withModuleKind(ModuleKind.ESModule)
          .withModuleSplitStyle(
            ModuleSplitStyle.SmallModulesFor(List("ts_highlight.webapp"))
          )
      },
      libraryDependencies += "com.raquo" %%% "laminar" % Versions.Laminar
    )

lazy val treesitterInterface =
  projectMatrix
    .in(file("mod/tree-sitter-interface"))
    .dependsOn(treesitterBindings)
    .jsPlatform(Seq(Versions.Scala3_LTS))
    .nativePlatform(
      Seq(Versions.Scala3_LTS),
      Seq.empty,
      _.enablePlugins(VcpkgNativePlugin)
    )
    .jvmPlatform(
      Seq(Versions.Scala3_LTS),
      Seq.empty,
      proj =>
        proj.settings(
          libraryDependencies += "io.github.tree-sitter" % "jtreesitter" % "0.25.4",
          Test / envVars += "TREESITTER_SCALA_DYLIB" -> (buildScalaGrammar.value._2.toString),
          Test / envVars += "TREESITTER_DYLIB" -> buildTreeSitterLib.value._2.toString,
          Test / fork := true,
          run / fork := true
        )
    )
    .settings(moduleName := "treesitter-interface")
    .settings(
      libraryDependencies += "org.scalameta" %%% "munit" % Versions.Munit,
      vcpkgDependencies := VcpkgDependencies("tree-sitter"),
      Test / nativeConfig :=
        nativeConfig.value
          .withLinkingOptions(_ :+ buildScalaGrammar.value._1.toString)
          .withEmbedResources(true)
          .withLTO(if (Platform.os != Platform.OS.MacOS) LTO.thin else LTO.none)
          // .withResourceIncludePatterns(Seq("**.scm"))
          .withIncrementalCompilation(true)
          .withSourceLevelDebuggingConfig(SourceLevelDebuggingConfig.enabled),
      Test / resourceGenerators += Def.task {
        val highlight =
          (ThisBuild / baseDirectory).value / "tree-sitter-scala" / "queries" / "highlights.scm"

        val highlightDest =
          (Compile / managedResourceDirectories).value.head / "highlights.scm"

        val t =
          FileFunction.cached(streams.value.cacheDirectory / "bin-resources") {
            (files: Set[File]) =>
              IO.copyFile(highlight, highlightDest)
              Set(highlightDest)
          }

        t(Set(highlight)).toSeq
      }
    )

lazy val lib =
  project
    .in(file("mod/lib"))
    .enablePlugins(ScalaNativePlugin)
    .dependsOn(
      treesitterInterface.native(true),
      cmark,
      themes.native(true),
      cairo
    )
    .settings(
      publish / skip := true,
      publishLocal / skip := true,
      scalaVersion := Versions.Scala3_Next
    )

lazy val themes = projectMatrix
  .in(file("mod/themes"))
  .jsPlatform(Seq(Versions.Scala3_LTS))
  .nativePlatform(Seq(Versions.Scala3_LTS))
  .settings(
    libraryDependencies += "org.typelevel" %%% "literally" % "1.2.0",
    // This source generator extracts all the highlight capture groups
    // and generats a Scala enum
    Compile / sourceGenerators += Def.task {
      val highlight =
        (ThisBuild / baseDirectory).value / "tree-sitter-scala" / "queries" / "highlights.scm"

      val contents =
        IO.read(highlight)
          .linesIterator
          .toList
          .filterNot(_.trim.startsWith(";"))
          .mkString(System.lineSeparator())

      val rgx =
        raw"@(\w[\.\w]*)".r
      val captureGroups =
        rgx
          .findAllIn(contents)
          .toList
          .distinct
          .map(_.stripPrefix("@"))
          .map { n =>
            val sane =
              n.split('.').map(_.capitalize).mkString
            sane -> n
          }

      val matches =
        captureGroups
          .map { case (sane, n) =>
            val sane =
              n.split('.').map(_.capitalize).mkString
            s"""  case $sane extends CaptureGroup("$n")"""
          }
          .mkString("enum CaptureGroup(val name: String) {\n", "\n", "\n}")

      val fromString =
        List.newBuilder[String]
      fromString += "object CaptureGroup:"
      fromString += "  def fromString(name: String): Option[CaptureGroup] = CaptureGroup.values.find(_.name == name)"

      val fileContents =
        s"package ts_highlight.themes\n\n$matches\n\n${fromString.result().mkString(System.lineSeparator())}"

      val dest =
        (Compile / managedSourceDirectories).value.head / "CaptureGroup.scala"

      IO.write(dest, fileContents)

      Seq(dest)
    }
  )

lazy val bin =
  project
    .in(file("mod/bin"))
    .enablePlugins(ScalaNativePlugin, VcpkgNativePlugin)
    .dependsOn(lib)
    .settings(
      publish / skip := true,
      publishLocal / skip := true,
      scalaVersion := Versions.Scala3_Next,
      libraryDependencies += "com.indoorvivants" %%% "decline-derive" % "0.3.1",
      libraryDependencies += "com.indoorvivants" %%% "mcp" % "0.0.8",
      vcpkgDependencies := VcpkgDependencies("tree-sitter", "cmark", "cairo"),
      vcpkgNativeConfig ~= { _.addRenamedLibrary("cmark", "libcmark") },
      nativeConfig :=
        nativeConfig.value
          .withLinkingOptions(_ :+ buildScalaGrammar.value._1.toString)
          .withEmbedResources(true)
          // .withLTO(if (Platform.os != Platform.OS.MacOS) LTO.thin else LTO.none)
          .withResourceIncludePatterns(Seq("**.scm", "**.ttf"))
          .withIncrementalCompilation(true)
          .withSourceLevelDebuggingConfig(SourceLevelDebuggingConfig.enabled),
      Compile / resourceGenerators += Def.task {
        val highlight =
          (ThisBuild / baseDirectory).value / "tree-sitter-scala" / "queries" / "highlights.scm"

        val font = (webapp / baseDirectory).value / "FiraCode-Regular.ttf"

        val highlightDest =
          (Compile / managedResourceDirectories).value.head / "highlights.scm"

        val fontDest =
          (Compile / managedResourceDirectories).value.head / "cairo.ttf"

        val t =
          FileFunction.cached(streams.value.cacheDirectory / "bin-resources") {
            (files: Set[File]) =>
              IO.copyFile(highlight, highlightDest)
              IO.copyFile(font, fontDest)
              Set(highlightDest, fontDest)
          }

        t(Set(highlight, font)).toSeq
      }
    )
    .settings(configurePlatform())

lazy val cmark =
  project
    .in(file("mod/cmark-bindings"))
    .enablePlugins(ScalaNativePlugin, BindgenPlugin, VcpkgNativePlugin)
    .settings(
      publish / skip := true,
      publishLocal / skip := true,
      scalaVersion := Versions.Scala3_LTS,
      vcpkgDependencies := VcpkgDependencies("cmark"),
      vcpkgNativeConfig ~= { _.addRenamedLibrary("cmark", "libcmark") },
      bindgenBindings += {
        Binding(vcpkgConfigurator.value.includes("cmark") / "cmark.h", "cmark")
          .withCImports(List("cmark.h"))
          .withClangFlags(
            vcpkgConfigurator.value.pkgConfig
              .updateCompilationFlags(
                List("-DCMARK_STATIC_DEFINE="),
                "libcmark"
              )
              .toList
          )
      }
    )
    .settings(bindgenSettings)
    .settings(configurePlatform())

lazy val cairo =
  project
    .in(file("mod/cairo-bindings"))
    .enablePlugins(ScalaNativePlugin, BindgenPlugin, VcpkgNativePlugin)
    .settings(
      publish / skip := true,
      publishLocal / skip := true,
      scalaVersion := Versions.Scala3_LTS,
      vcpkgDependencies := VcpkgDependencies("cairo"),
      bindgenBindings += {
        Binding(baseDirectory.value / "amalgam.h", "cairo")
          .withCImports(List("cairo.h", "cairo-ft.h"))
          .withClangFlags(
            vcpkgConfigurator.value.pkgConfig.compilationFlags("cairo")
          )
          .withOpaqueStructs(Set("FT_ListNodeRec_", "FT_GlyphSlotRec_"))
      }
    )
    .settings(bindgenSettings)
    .settings(configurePlatform())

lazy val treesitterBindings =
  project
    .in(file("mod/treesitter-bindings"))
    .enablePlugins(ScalaNativePlugin, BindgenPlugin, VcpkgNativePlugin)
    .settings(
      moduleName := "treesitter-bindings",
      scalaVersion := Versions.Scala3_LTS,
      vcpkgDependencies := VcpkgDependencies("tree-sitter"),
      bindgenBindings += {
        Binding(
          vcpkgConfigurator.value.includes(
            "tree-sitter"
          ) / "tree_sitter" / "api.h",
          "tree_sitter"
        )
          .withCImports(List("tree_sitter/api.h"))
          .withClangFlags(
            vcpkgConfigurator.value.pkgConfig
              .updateCompilationFlags(
                List("-DCMARK_STATIC_DEFINE="),
                "tree-sitter"
              )
              .toList
          )
      }
    )
    .settings(bindgenSettings)
    .settings(configurePlatform())

lazy val httpServer =
  project
    .in(file("mod/http-server"))
    .dependsOn(httpShared.jvm(true))
    .enablePlugins(JavaAppPackaging)
    .settings(
      libraryDependencies += "org.http4s" %% "http4s-ember-server" % "0.23.30",
      libraryDependencies += "org.http4s" %% "http4s-dsl" % "0.23.30",
      libraryDependencies += "com.outr" %% "scribe-cats" % "3.15.2",
      libraryDependencies += "co.fs2" %% "fs2-io" % "3.12.0",
      libraryDependencies += "software.amazon.awssdk" % "s3" % "2.20.30",
      run / fork := true,
      run / envVars += "HIGHLIGHTER_CLI_PATH" -> (bin / Compile / nativeLink).value.toString,
      reStart / envVars += "HIGHLIGHTER_CLI_PATH" -> (bin / Compile / nativeLink).value.toString,
      scalaVersion := Versions.Scala3_Next
    )

lazy val httpShared =
  projectMatrix
    .jsPlatform(Seq(Versions.Scala3_Next))
    .jvmPlatform(
      Seq(Versions.Scala3_Next)
    )
    .in(file("mod/http-shared"))
    .settings(
      libraryDependencies += "com.lihaoyi" %%% "upickle" % "4.2.1"
    )

val bindgenSettings =
  Seq(
    bindgenMode := BindgenMode.Manual(
      scalaDir = (Compile / sourceDirectory).value / "scala" / "generated",
      cDir = (Compile / resourceDirectory).value / "scala-native" / "generated"
    ),
    bindgenBindings := {
      bindgenBindings.value.map(_.withNoLocation(true))
    }
  )

def configurePlatform(
    rename: String => String = identity
) =
  Seq(
    nativeConfig := {
      val conf =
        nativeConfig.value
      val arch64 =
        if (
          Platform.os == MacOS && Platform.arch == Platform.Arch.Arm && Platform.bits == Platform.Bits.x64
        )
          List("-arch", "arm64")
        else Nil

      conf
        .withLinkingOptions(
          conf.linkingOptions ++ arch64
        )
        .withCompileOptions(
          conf.compileOptions ++ arch64
        )
    }
  )

lazy val buildDebugBinary =
  taskKey[File]("")

buildDebugBinary := {
  writeBinary(
    source = (bin / Compile / nativeLink).value,
    destinationDir = (ThisBuild / baseDirectory).value / "out" / "debug",
    log = sLog.value,
    platform = None
  )
}

lazy val buildReleaseBinary =
  taskKey[File]("")

buildReleaseBinary := {
  writeBinary(
    source = (bin / Compile / nativeLinkReleaseFast).value,
    destinationDir = (ThisBuild / baseDirectory).value / "out" / "release",
    log = sLog.value,
    platform = None
  )
}

lazy val buildPlatformBinary =
  taskKey[File]("")

ThisBuild / buildPlatformBinary := {
  writeBinary(
    source = (bin / Compile / nativeLinkReleaseFast).value,
    destinationDir = (ThisBuild / baseDirectory).value / "out" / "release",
    log = sLog.value,
    platform = Some(Platform.target)
  )
}

lazy val buildTreeSitterLib =
  taskKey[(File, File)]("")

lazy val buildScalaGrammar =
  taskKey[(File, File)]("")

Global / buildScalaGrammar := {
  val tg =
    crossTarget.value / "tree-sitter-scala-build"
  val src =
    (baseDirectory.value) / "tree-sitter-scala" / "src"
  val cSources =
    src.toGlob / ** / "*.c"
  val hSources =
    src.toGlob / ** / "*.h"
  val s =
    streams.value

  val files =
    (fileTreeView.value.list(cSources) ++ fileTreeView.value.list(hSources))
      .map(_._1.toFile)

  val cachedFun =
    FileFunction.cached(
      s.cacheDirectory / "tree-sitter-scala-build"
    ) { (in: Set[File]) =>
      buildScalaGrammarImpl(files, tg, s.log).toSet
    }
  val static :: dynamic :: Nil = cachedFun(files.toSet).toList

  (static, dynamic)

}

Global / buildTreeSitterLib := {
  val tg =
    crossTarget.value / "tree-sitter-scala-build"
  val src =
    (baseDirectory.value) / "tree-sitter"
  val cSources =
    src.toGlob / ** / "*.c"
  val hSources =
    src.toGlob / ** / "*.h"
  val s =
    streams.value

  val files =
    (fileTreeView.value.list(cSources) ++ fileTreeView.value.list(hSources))
      .map(_._1.toFile)

  val cachedFun =
    FileFunction.cached(
      s.cacheDirectory / "tree-sitter-build"
    ) { (in: Set[File]) =>
      buildTreeSitterLibImpl(files, src, s.log).toSet
    }
  cachedFun(files.toSet).headOption.get

  val static :: dynamic :: Nil = cachedFun(files.toSet).toList

  (static, dynamic)
}

lazy val buildScalaWASM =
  taskKey[File]("")

Global / buildScalaWASM := {
  val TS = baseDirectory.value / "tree-sitter-scala"
  val dest = (webapp / baseDirectory).value / "tree-sitter-scala.wasm"
  val src = TS / "src"
  val sources = src.toGlob / ** / "*.{c,h}"
  val pkg = TS.toGlob / "package.json"
  val packageLock = TS.toGlob / "package-lock.json"
  val s = streams.value
  val ftv = fileTreeView.value.list(_: Glob)

  val files = (ftv(sources) ++ ftv(pkg) ++ ftv(packageLock)).map(_._1.toFile)

  val cachedFun =
    FileFunction.cached(
      s.cacheDirectory / "tree-sitter-scala-wasm-build",
      FileInfo.full
    ) { (in: Set[File]) =>
      Set(buildScalaWASMImpl(dest, TS, s.log))
    }
  cachedFun(files.toSet).headOption
    .getOrElse(sys.error("No WASM file produced"))
}

def buildScalaWASMImpl(dest: File, cwd: File, log: sbt.Logger): File = {
  import scala.sys.process.*
  Process(Seq("npm", "install"), cwd = cwd) ! log
  val cmd = Seq("npm", "exec", "-c", s"tree-sitter build --wasm -o $dest")
  Process(cmd, cwd = cwd) ! log
  dest
}

def buildTreeSitterLibImpl(
    files: Seq[File],
    src: File,
    log: sbt.Logger
) = {
  val outStatic =
    src / "libtree-sitter.a"

  val outDynamic =
    src / (if (Platform.os == MacOS) "libtree-sitter.dylib"
           else "libtree-sitter.so")
  import scala.sys.process.*

  val compileToObjectFiles =
    List.newBuilder[String]
  compileToObjectFiles += "make"

  Process(
    command = compileToObjectFiles.result(),
    cwd = src
  ).!(log)

  List(outStatic, outDynamic)
}

def buildScalaGrammarImpl(
    files: Seq[File],
    outDir: File,
    log: sbt.Logger
) = {
  val outStatic =
    outDir / "libtree-sitter-scala.a"
  val outDynamic =
    outDir / (if (Platform.os == MacOS) "libtree-sitter-scala.dylib"
              else "libtree-sitter-scala.so")
  val stage =
    outDir / "stage"
  IO.delete(stage)
  import scala.sys.process.*
  try {
    val compileToObjectFiles =
      List.newBuilder[String]
    compileToObjectFiles += "clang"
    compileToObjectFiles ++= files.toSeq.map(_.toString)
    compileToObjectFiles += "-fPIC"
    compileToObjectFiles += "-c"

    IO.createDirectory(stage)
    Process(
      command = compileToObjectFiles.result(),
      cwd = stage
    ).!(log)

    val objectFiles =
      FileTreeView.nio
        .list(stage.toGlob / ** / "*.o")
        .map(_._1.toAbsolutePath.toString())

    val createStaticLibrary =
      List.newBuilder[String]
    createStaticLibrary += "ar"
    createStaticLibrary += "r"
    createStaticLibrary += outStatic.name
    createStaticLibrary ++= objectFiles

    val createSharedLibrary =
      List.newBuilder[String]
    createSharedLibrary += "clang"
    createSharedLibrary += "-shared"
    createSharedLibrary += "-o"
    createSharedLibrary += outDynamic.name
    createSharedLibrary ++= objectFiles

    Process(
      createStaticLibrary.result(),
      cwd = outDir
    ).!(log)

    Process(
      createSharedLibrary.result(),
      cwd = outDir
    ).!(log)

    List(outStatic, outDynamic)
  } finally {
    IO.delete(stage)
  }
}

def writeBinary(
    source: File,
    destinationDir: File,
    log: sbt.Logger,
    platform: Option[Platform.Target]
): File = {

  val name =
    platform match {
      case None => BINARY_NAME
      case Some(target) =>
        val ext =
          target.os match {
            case Platform.OS.Windows => ".exe"
            case _                   => ""
          }

        BINARY_NAME + "-" + ArtifactNames.coursierString(target) + ext
    }

  val dest =
    destinationDir / name

  IO.createDirectory(destinationDir)

  Files.copy(
    source.toPath(),
    dest.toPath(),
    StandardCopyOption.COPY_ATTRIBUTES,
    StandardCopyOption.REPLACE_EXISTING
  )

  log.info(s"Binary [$name] built in ${dest}")

  dest
}
