import org.scalajs.linker.interface.ModuleSplitStyle

inThisBuild(
  List(
    organization := "com.indoorvivants",
    organizationName := "Anton Sviridov",
    homepage := Some(
      url("https://github.com/indoorvivants/scala-library-template")
    ),
    startYear := Some(2020),
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

val Versions = new {
  val Scala3_LTS = "3.3.4"
  val Scala3_Next = "3.6.2"
  val Laminar = "17.2.0"
  val munit = "1.0.2"
}

lazy val webapp = project
  .in(file("webapp"))
  .enablePlugins(ScalaJSPlugin) // Enable the Scala.js plugin in this project
  .dependsOn(bindings.js(Versions.Scala3_LTS))
  .settings(
    scalaVersion := Versions.Scala3_Next,

    // Tell Scala.js that this is an application with a main method
    scalaJSUseMainModuleInitializer := true,

    /* Configure Scala.js to emit modules in the optimal way to
     * connect to Vite's incremental reload.
     * - emit ECMAScript modules
     * - emit as many small modules as possible for classes in the "livechart" package
     * - emit as few (large) modules as possible for all other classes
     *   (in particular, for the standard library)
     */
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(
          ModuleSplitStyle.SmallModulesFor(List("ts_highlight.webapp"))
        )
    },
    libraryDependencies += "com.raquo" %%% "laminar" % Versions.Laminar
  )

lazy val bindings = projectMatrix
  .in(file("tree-sitter-bindings"))
  .jsPlatform(Seq(Versions.Scala3_LTS))
  .nativePlatform(Seq(Versions.Scala3_LTS))

lazy val example = projectMatrix
  .in(file("example"))
  .nativePlatform(
    Seq(Versions.Scala3_LTS),
    Seq.empty,
    configure = proj =>
      proj
        .enablePlugins(VcpkgNativePlugin)
        .settings(vcpkgDependencies := VcpkgDependencies("tree-sitter"))
  )
  .dependsOn(bindings)
  .settings(
    nativeConfig ~= { config =>
      config.withLinkingOptions(
        _ :+ "/Users/velvetbaldmime/projects/tree-sitter/tree-sitter-scala/src/libtreesitter-scala.a"
      )
    }
  )
