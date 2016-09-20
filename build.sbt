sbtPlugin := true

organization := "com.github.stonexx.sbt"

name := "sbt-babeljs"

scalaVersion := "2.10.6"

resolvers += Resolver.typesafeRepo("maven-releases")

libraryDependencies += "com.typesafe" % "jstranspiler" % "1.0.0"

addSbtPlugin("com.typesafe.sbt" %% "sbt-js-engine" % "1.1.4")

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
