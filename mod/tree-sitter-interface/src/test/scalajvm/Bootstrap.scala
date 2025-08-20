package ts_highlight

import io.github.treesitter.jtreesitter as JTS
import java.lang.foreign.SymbolLookup
import java.lang.foreign.Arena
import java.nio.file.Paths

object Bootstrap:
  def forScala(f: TreeSitterInterface => Unit) =
    val libPath = sys.env.getOrElse(
      "TREESITTER_DYLIB",
      sys.error("Dynamic library with tree sitter core not found")
    )

    val scalaPath = sys.env.getOrElse(
      "TREESITTER_SCALA_DYLIB",
      sys.error("Dynamic library with tree sitter grtammar not found")
    )

    val scalaLookup = SymbolLookup.libraryLookup(Paths.get(scalaPath), Arena.global())
    val libLookup = SymbolLookup.libraryLookup(Paths.get(libPath), Arena.global())
    val sl = libLookup.or(scalaLookup)

    ScalaTSLibraryLookup.lookup = Some(sl)

    val lang = JTS.Language.load(sl, "tree_sitter_scala")
    val ts = new TreeSitter(lang) 

    println(ts.parse("@main def hello = 25"))
    f(ts)
  end forScala

  lazy val QUERIES = scala.io.Source
    .fromInputStream(getClass().getResourceAsStream("/highlights.scm"))
    .getLines()
    .mkString(System.lineSeparator())
end Bootstrap
