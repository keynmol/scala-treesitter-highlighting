package ts_highlight

import scalanative.unsafe.*
import tree_sitter.structs.TSLanguage

object Bootstrap:
  def forScala(f: TreeSitterInterface => Unit) =
    Zone:
      val parser = tree_sitter.all.ts_parser_new()
      val lang = tree_sitter_scala()

      val ts = TreeSitter(parser, lang)
      f(ts)

  lazy val QUERIES = io.Source
    .fromInputStream(getClass().getResourceAsStream("/highlights.scm"))
    .getLines()
    .mkString(System.lineSeparator())
end Bootstrap

def tree_sitter_scala(): Ptr[TSLanguage] = extern
