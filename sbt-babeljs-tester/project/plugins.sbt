lazy val root = Project("plugins", file(".")).dependsOn(plugin)

lazy val plugin = file("../").getCanonicalFile.toURI

resolvers ++= Seq(
  Resolver.mavenLocal,
  Resolver.typesafeRepo("snapshots"),
  Resolver.sonatypeRepo("snapshots"),
  Resolver.sbtPluginRepo("snapshots")
)
