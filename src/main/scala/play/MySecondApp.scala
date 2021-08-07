package play

import org.scalajs.dom
import org.scalajs.dom.{document, html}

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

object MySecondApp {
  def mainX(args: Array[String]): Unit = {
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

    appendPar(document.body, "Hello World from MySecondApp")

    val child = dom.document.createElement("div")
    child.textContent = "Hello in a div, so what?"
    document.body.appendChild(child)

    // do the canvas directly, mmh it does not work
    // val cv = dom.document.createElement("<canvas style=\"display: block\" id=\"helloFromScala.js\" width=\"255\" height=\"255\"/>")
    val cv = dom.document.createElement("div")
    cv.textContent = "<canvas style=\"display: block\" id=\"helloFromScala.js\" width=\"255\" height=\"255\"/>"
    document.body.appendChild(cv)
    val c = cv.asInstanceOf[dom.CanvasRenderingContext2D]

    c.fillStyle = "rgb(0, 200, 30)"
    c.fillRect(0, 0, 50, 50)

  }

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    parNode.textContent = text
    targetNode.appendChild(parNode)
  }

  def addClickedMessage(): Unit = {
    appendPar(document.body, "You clicked the button!")
  }
}
