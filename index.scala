//> using platform scala-js
//> using dep org.scala-js::scalajs-dom::2.8.0
//> using dep com.olvind::scalablytyped-runtime::2.4.2
//> using scala 3.5.0-RC1

import org.scalajs.dom.*
import scalajs.js, js.annotation.*, js.Dynamic.literal as J, js.Array as A
import scala.scalajs.js.Promise

@js.native @JSImport("/tree-sitter-scala.wasm?init&url", JSImport.Default)
val imgUrl: String = js.native

@js.native @JSImport(
  "web-tree-sitter/tree-sitter.wasm?init&url",
  JSImport.Default
)
val wasmInit: String = js.native

@js.native
@JSImport("/tree-sitter.js", JSImport.Default)
object Parser extends js.Any:
  def parse(path: String): js.Any = js.native

// @js.native
// @JSImport("web-tree-sitter", JSImport.Default)
// object Parser extends js.Any:
//   def init(opts: js.Any): js.Any = js.native

//   // def init(opts: js.Any): Promise[Unit] = js.native

@main def hello =
  // ???
  println(js.JSON.stringify(Parser.parse("object Test")))
  // Parser.init(wasmInit)
  // val parser = Parser()
  // Parser.init(J()).`then`(_ => println("ok"), _ => println("nok"))
  // println(js.JSON.stringify(Parser.^))
  // val _ = ^
  // println(Parser.^.init().`then`(_ => println("initialised")))
  // println(Language.load(imgUrl))
end hello
