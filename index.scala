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
  def parse(path: String): Tree = js.native

  def getLanguage(): Language = js.native

  @js.native
  trait Language extends js.Any:
    def query(source: String): Query = js.native

  @js.native
  trait Query extends js.Any:
    def matches(node: Node): A[js.Any] = js.native

  @js.native
  trait Tree extends js.Any:
    val rootNode: Node = js.native

  @js.native
  trait Node extends js.Any
end Parser

extension [T <: js.Any](t: T) def dump() = console.log(t)

// @js.native
// @JSImport("web-tree-sitter", JSImport.Default)
// object Parser extends js.Any:
//   def init(opts: js.Any): js.Any = js.native

//   // def in(opts: js.Any): Promise[Unit] = js.native

@main def hello =
  println("lang")
  
  val lang = Parser.getLanguage()
  val query = lang.query("(object_definition name: (identifier) @name)")
  val tree = Parser.parse("object hello; object Test;")
  tree.dump()
  query.dump()

  query.matches(tree.rootNode).dump()
  // println(js.JSON.stringify(Parser.getLanguage()))
  // Parser.init(wasmInit)
  // val parser = Parser()
  // Parser.init(J()).`then`(_ => println("ok"), _ => println("nok"))
  // println(js.JSON.stringify(Parser.^))
  // val _ = ^
  // println(Parser.^.init().`then`(_ => println("initialised")))
  // println(Language.load(imgUrl))
end hello
