import WebJs.JS

lazy val root = (project in file(".")).enablePlugins(SbtWeb)

JsEngineKeys.engineType := JsEngineKeys.EngineType.Node

BabelJSKeys.options := JS.Object(
  "modules" -> "amd"
)
