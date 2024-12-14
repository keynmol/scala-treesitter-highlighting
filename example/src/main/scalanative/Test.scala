import scalanative.unsafe.*
import ts_highlight.*
import treesitter_native.structs.TSLanguage

def tree_sitter_scala(): Ptr[TSLanguage] = extern

@main def hello_tree_sitter =
  Zone:
    val parser = treesitter_native.all.ts_parser_new()
    val lang = tree_sitter_scala()

    val ts = TreeSitter(parser, lang)

    val source =
      """
object Hello:
  def main(args: Array[String]) = 
    for 
      x <- 1 to 20
    do 
      println("yo!")
"""

    val tree = ts.parse(source)

    // println(tree.rootNode)

    val q = ts.getLanguage.query("(type_identifier) @my.type")

    println(q.captures(tree.rootNode).flatMap(_.nodes).map(_.text(source)))
    println(q.captures(tree.rootNode).map(_.name(q)))

    // println(ts.captures())
