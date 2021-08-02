package play

import org.scalajs.dom
import org.scalajs.dom.{document, html}

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

// Only for draw needed, not for main
// For whatever reason main is called implicitly

@JSExportTopLevel("HelloWorld")
object MyApp {
  def main(args: Array[String]): Unit = {
    document.addEventListener("DOMContentLoaded", { (e: dom.Event) =>
      setupUI()
    })
  }

  def setupUI(): Unit = {
    val button = document.createElement("button")
    button.textContent = "Click me!"
    button.addEventListener("click", { (e: dom.MouseEvent) =>
      addClickedMessage()
    })
    document.body.appendChild(button)

    appendPar(document.body, "Hello World")

    val child = dom.document.createElement("div")
    child.textContent = "Hello in a div, so what?"
    document.body.appendChild(child)
  }

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    parNode.textContent = text
    targetNode.appendChild(parNode)
  }

  def addClickedMessage(): Unit = {
    appendPar(document.body, "You clicked the button!")
  }

  @JSExport
  def drawMe(cv: html.Canvas): Unit = {
    val c = cv.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]

    c.fillStyle = "rgb(120, 10, 30)"
    c.fillRect(0, 0, 100, 100)
  }
}
