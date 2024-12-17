package ts_highlight.themes

import ts_highlight.*

import Theme.Container

trait Theme extends PartialFunction[CaptureGroup | Container, Theme.CSSBlock]

object Theme:
  def apply(f: PartialFunction[CaptureGroup | Container, CSSBlock]): Theme =
    new Theme:
      export f.{apply, isDefinedAt}

  opaque type Container = Unit
  val Container: Container = ()

  def fromString(s: String): Option[Theme] = s.trim.toLowerCase() match
    case "kanagawa"     => Some(Kanagawa)
    case "gruvbox"      => Some(Gruvbox)
    case "vscode"       => Some(VSCode)
    case "vscode-light" => Some(LightVSCode)
    case _              => Option.empty

  opaque type CSSBlock <: String = String
  object CSSBlock:
    def apply(s: String): CSSBlock = s

  import CaptureGroup.*

  val LightVSCode: Theme = apply:
    case Container =>
      """background: rgb(255,255,255); color: rgb(0,0,0); padding: 15px;"""
    case Function => "color: rgb(121,94,38)"
    case Keyword | KeywordFunction | Repeat | Conditional | KeywordOperator |
        KeywordReturn =>
      "color: rgb(0,0,255)"
    case Storageclass =>
      "color: rgb(0,0,255); text-decoration: underline;"
    case TypeQualifier =>
      "color: rgb(0,0,255); text-decoration: underline;"
    case PunctuationBracket        => "color: rgb(0,0,0);"
    case PunctuationSpecial        => "color: rgb(0,0,0);"
    case Type                      => "color: rgb(38,127,153);"
    case String                    => "color: rgb(163,21,21);"
    case FunctionCall | MethodCall => "color: rgb(121,94,38);"
    case Number                    => "color: rgb(9,134,88);"
    case Operator                  => "color: rgb(0,0,0);"
    case Parameter                 => "color: rgb(0,16,128);"
    case Include                   => "color: rgb(0,0,255);"
    case Namespace                 => "color: rgb(38,127,153);"
    case Property                  => "color: rgb(0,16,128);"
    case Spell                     => "color: rgb(96,139,78);"
    case Variable                  => "color: rgb(0,16,128);"

  val VSCode: Theme = apply:
    case Container =>
      """background: rgb(30,30,30); color: rgb(212,212,212); padding: 15px;"""
    case Function => "color: rgb(220,220,170)"
    case Keyword | KeywordFunction | Repeat | Conditional | KeywordOperator |
        KeywordReturn =>
      "color: rgb(197,134,192)"
    case Storageclass =>
      "color: rgb(86,156,214); text-decoration: underline;"
    case TypeQualifier =>
      "color: rgb(86,156,214); text-decoration: underline;"
    case PunctuationBracket        => "color: rgb(212,212,212);"
    case PunctuationSpecial        => "color: rgb(212,212,212);"
    case Type                      => "color: rgb(78,201,176);"
    case String                    => "color: rgb(206,145,120);"
    case FunctionCall | MethodCall => "color: rgb(220,220,170);"
    case Number                    => "color: rgb(181,206,168);"
    case Operator                  => "color: rgb(212,212,212);"
    case Parameter                 => "color: rgb(156,220,254);"
    case Include                   => "color: rgb(197,134,192);"
    case Namespace                 => "color: rgb(78,201,176);"
    case Property                  => "color: rgb(156,220,254);"
    case Spell                     => "color: rgb(106,153,85);"
    case Variable                  => "color: rgb(156,220,254);"

  val Gruvbox: Theme = apply:
    case Container =>
      """background: rgb(40,40,40); color: rgb(213,196,161); padding: 15px;"""
    case Function => "color: rgb(184,187,38)"
    case Keyword | KeywordFunction | Repeat | Conditional | KeywordOperator |
        KeywordReturn =>
      "color: rgb(251,73,52)"
    case Storageclass =>
      "color: rgb(251,73,52); text-decoration: underline;"
    case TypeQualifier =>
      "color: rgb(251,73,52); text-decoration: underline;"
    case PunctuationBracket        => "color: rgb(168,153,132);"
    case PunctuationSpecial        => "color: rgb(254,128,25);"
    case Type                      => "color: rgb(250,189,47);"
    case String                    => "color: rgb(184,187,38);"
    case FunctionCall | MethodCall => "color: rgb(184,187,38);"
    case Number                    => "color: rgb(211,134,155);"
    case Operator                  => "color: rgb(251,73,52);"
    case Parameter                 => "color: rgb(213,196,161);"
    case Include                   => "color: rgb(254,128,25);"
    case Namespace                 => "color: rgb(250,189,47);"
    case Property                  => "color: rgb(254,128,25);"
    case Spell                     => "color: rgb(146,131,116);"
    case Variable                  => "color: rgb(213,196,161);"

  val Kanagawa: Theme = apply:
    case Container =>
      """background: rgb(31,31,40); color: white; padding: 15px;"""
    case Function => "color: rgb(121, 158, 218)"
    case Keyword | KeywordFunction | Repeat | Conditional | KeywordOperator |
        KeywordReturn =>
      "color: rgb(151,128,186)"
    case Storageclass =>
      "color: rgb(151,128,186); text-decoration: underline;"
    case TypeQualifier =>
      "color: rgb(151,128,186); text-decoration: underline;"
    case PunctuationBracket        => "color: rgb(154, 172, 203);"
    case PunctuationSpecial        => "color: rgb(127, 180, 202);"
    case Type                      => "color: rgb(114,169,159);"
    case String                    => "color: rgb(152,187, 108);"
    case FunctionCall | MethodCall => "color: rgb(126, 156, 216)"
    case Number                    => "color: pink;"
    case Operator                  => "color: rgb(196, 161, 107);"
    case Parameter                 => "color: rgb(184, 181, 209)"
    case Include                   => "color: rgb(228, 104, 118);"
    case Namespace                 => "color: rgb(122, 168, 159);"
    case Property                  => "color: rgb(234, 193, 128)"
    case Spell                     => "color: rgb(85,  94, 136)"
    case Variable                  => "color: rgb(192, 202, 245)"

  def buildCSS(theme: Theme, mentioned: Set[CaptureGroup]) =
    val sb = new StringBuilder
    val f = theme.lift

    f(Container).foreach: block =>
      sb ++= s"pre.ts-hl { \n$block\n}\n"

    mentioned.toList
      .sortBy(_.name)
      .foreach: cg =>
        f(cg).foreach: block =>
          sb ++= s".ts-hl-${cg.name.replace('.', '-')} {\n"
          sb ++= block
          sb ++= "\n}\n"

    sb.result()
  end buildCSS
end Theme
