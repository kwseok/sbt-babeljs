# sbt-babeljs [![Build Status](https://travis-ci.org/stonexx/sbt-babeljs.svg?branch=master)](https://travis-ci.org/stonexx/sbt-babeljs)

Provides an `sbt-web` source task for the [babeljs.io](http://babeljs.io) transpiler.

Installation
------------

To use this plugin use the addSbtPlugin command within your project's `plugins.sbt` file:

```scala
resolvers += Resolver.sbtPluginRepo("releases")

addSbtPlugin("io.teamscala.sbt" % "sbt-babeljs" % "1.0.0")
```

Your project's build file also needs to enable sbt-web plugins. For example with `build.sbt`:

```scala
lazy val root = (project in file(".")).enablePlugins(SbtWeb)

JsEngineKeys.engineType := JsEngineKeys.EngineType.Node
```

Install babel-core, either globally with npm:

```shell
npm install babel-core -g
```

Or locally in your project with a `package.json` file:

```json
{
  "devDependencies": {
    "babel-core": "^5.6.15"
  }
}
```
