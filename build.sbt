enablePlugins(ScalaJSPlugin)

name := "Scala.js Playground"
scalaVersion := "2.13.5"

// This is an application with a main method
scalaJSUseMainModuleInitializer := true
// Select which one to use, if there are more than one
// BUT, it does not work :-( => need to modify main function names
// Compile/mainClass := Some("play.MyApp")


libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "1.1.0"

// Add support for the DOM in `run` and `test`
jsEnv := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv()

// uTest settings
libraryDependencies += "com.lihaoyi" %%% "utest" % "0.7.9" % "test"
testFrameworks += new TestFramework("utest.runner.Framework")
