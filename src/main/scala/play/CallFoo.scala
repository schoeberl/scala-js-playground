package play

import org.scalajs.dom
import org.scalajs.dom.{document, html}

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("CallFoo")
object CallFoo {

  // Not needed, but make build.sbt happy
  def main(args: Array[String]): Unit = {
  }

  @JSExport
  def foo(): Unit = {
    val button = document.createElement("button")
    button.textContent = "Click me again!"
    button.addEventListener("click", { (e: dom.MouseEvent) =>
      appendPar(document.body, "You clicked the button!")
    })
    document.body.appendChild(button)
  }

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    parNode.textContent = text
    targetNode.appendChild(parNode)
  }
}
