resolvers += Resolver.typesafeRepo("maven-releases")

addSbtPlugin("com.github.stonexx.sbt" % "sbt-babeljs" % sys.props("project.version"))
