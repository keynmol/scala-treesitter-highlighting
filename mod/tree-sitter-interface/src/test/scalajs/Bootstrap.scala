package ts_highlight


object Bootstrap:
  def forScala(f: TreeSitterInterface => Unit) =
    f(TreeSitter(Parser))

  lazy val QUERIES = "" // TODO
