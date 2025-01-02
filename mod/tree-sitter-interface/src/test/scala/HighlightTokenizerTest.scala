package ts_highlight

class HighlightTokenizerTest extends munit.FunSuite:
  test("basics"):
    Bootstrap.forScala: ts =>
      val highlight =
        HighlightTokenizer(CODE, Bootstrap.QUERIES, ts).switches.toVector

end HighlightTokenizerTest

val CODE = """
val _ = s"test ${code + "hello"} bla"
""".trim
