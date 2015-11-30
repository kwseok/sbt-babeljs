sbtPlugin := true

organization := "io.teamscala.sbt"

name := "sbt-babeljs"

scalaVersion := "2.10.5"

resolvers += Resolver.typesafeRepo("releases")

libraryDependencies ++= Seq(
  "com.typesafe" % "jstranspiler" % "1.0.0"
  //"org.webjars.npm" % "babel-core" % "6.2.4",
  //"org.webjars.npm" % "babel-plugin-transform-react-jsx" % "6.2.4",
  //"org.webjars.npm" % "mkdirp" % "0.5.1",
  //"org.webjars.npm" % "when" % "3.7.5"
)

addSbtPlugin("com.typesafe.sbt" %% "sbt-js-engine" % "1.1.3")

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))