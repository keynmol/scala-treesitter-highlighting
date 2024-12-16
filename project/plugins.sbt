addSbtPlugin("com.github.sbt" % "sbt-ci-release" % "1.5.12")

addSbtPlugin("com.eed3si9n" % "sbt-projectmatrix" % "0.10.0")

addSbtPlugin("com.github.cb372" % "sbt-explicit-dependencies" % "0.3.1")

addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.2")

addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.13.0")

addSbtPlugin("de.heikoseeberger" % "sbt-header" % "5.10.0")

// Scala.js and Scala Native
addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.17.0")

addSbtPlugin("org.scala-native" % "sbt-scala-native" % "0.5.6")

addSbtPlugin("com.indoorvivants.vcpkg" % "sbt-vcpkg-native" % "0.0.21")

addSbtPlugin("com.indoorvivants" % "bindgen-sbt-plugin" % "0.1.4")

libraryDependencies += "com.indoorvivants.detective" %% "platform" % "0.0.2"
