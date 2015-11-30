package io.teamscala.sbt.babeljs

import com.typesafe.sbt.jse.SbtJsTask
import com.typesafe.sbt.web.Import.WebJs.JS
import com.typesafe.sbt.web._
import sbt.Keys._
import sbt._

object Import {

  object BabelJSKeys {
    val babeljs = TaskKey[Seq[File]]("babeljs", "Invoke the babel compiler.")
    val options = SettingKey[JS.Object]("babeljs-options", "Options for babel transpiling.")
  }

}

object SbtBabelJS extends AutoPlugin {

  override def requires = SbtJsTask

  override def trigger = AllRequirements

  val autoImport = Import

  import SbtJsTask.autoImport.JsTaskKeys._
  import SbtWeb.autoImport._
  import WebKeys._
  import autoImport.BabelJSKeys._

  val babeljsUnscopedSettings = Seq(
    includeFilter := "*.es6.js" || "*.es6" || "*.jsx.js" || "*.jsx",
    jsOptions := options.value.js
  )

  private val NodeModules = "node_modules"

  override def projectSettings = Seq(options := JS.Object.empty) ++ inTask(babeljs)(
    SbtJsTask.jsTaskSpecificUnscopedSettings ++
    inConfig(Assets)(babeljsUnscopedSettings) ++
    inConfig(TestAssets)(babeljsUnscopedSettings) ++
    Seq(
      moduleName := "babeljs",
      shellFile := getClass.getClassLoader.getResource("babel-shell.js"),
      taskMessage in Assets := "BabelJS compiling",
      taskMessage in TestAssets := "BabelJS test compiling"
    )
  ) ++ SbtJsTask.addJsSourceFileTasks(babeljs) ++ Seq(
    babeljs in Assets := (babeljs in Assets).dependsOn(nodeModules in Assets).value,
    babeljs in TestAssets := (babeljs in TestAssets).dependsOn(nodeModules in TestAssets).value,
    nodeModuleDirectories in Plugin += baseDirectory.value / NodeModules //for sub-projects
  )

}
