sbtPlugin := true

organization := "com.github.stonexx.sbt"

name := "sbt-babeljs"

scalaVersion := "2.10.6"

resolvers += Resolver.typesafeRepo("maven-releases")

libraryDependencies += "org.webjars" % "npm" % "4.2.0"
libraryDependencies += "com.typesafe" % "jstranspiler" % "1.0.0"

addSbtPlugin("com.typesafe.sbt" %% "sbt-js-engine" % "1.2.0")

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
