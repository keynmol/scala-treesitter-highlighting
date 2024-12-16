package ts_highlight.webapp

import org.scalajs.dom
import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.annotation.JSGlobal

@js.native
trait CodeMirrorValue extends js.Object:
  def getValue(): String

@js.native
trait CodeMirrorInstance extends js.Object:
  def on(
      eventName: String,
      listener: js.Function1[CodeMirrorValue, Unit]
  ): this.type = js.native
end CodeMirrorInstance

@js.native
@JSGlobal
object CodeMirror extends js.Object:
  def fromTextArea(
      element: dom.HTMLElement,
      options: js.Any
  ): CodeMirrorInstance =
    js.native
end CodeMirror
