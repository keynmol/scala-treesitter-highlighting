package ts_highlight.themes

import ts_highlight.*

import Theme.Container

trait Theme extends PartialFunction[CaptureGroup | Container, Style]

enum Decorator:
  case Underline, Bold

  def toCSS: String = this match
    case Underline => "text-decoration: underline"
    case Bold      => "font-weight: bold"

case class Style(
    background: Option[Color] = None,
    text: Option[Color] = None,
    decoration: Set[Decorator] = Set.empty
):
  def underline = copy(decoration = decoration + Decorator.Underline)

  def toCSS: String =
    inline def color(c: Color) = s"rgb(${c.r}, ${c.g}, ${c.b})"
    (background.map(c => s"background: ${color(c)}").toSeq ++
      text.map(c => s"color: ${color(c)}").toSeq ++
      decoration.toSeq.map(_.toCSS)).mkString("; ")
end Style

extension (c: Color)
  inline def background = Style(background = Some(c))
  inline def text = Style(text = Some(c))

object Theme:
  def apply(f: PartialFunction[CaptureGroup | Container, Style]): Theme =
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

  import CaptureGroup.*

  val LightVSCode: Theme = apply:
    case Container =>
      rgb"255,255,255".background.copy(text = Some(rgb"0,0,0"))
    case Function => rgb"121,94,38".text
    case Keyword | KeywordFunction | Repeat | Conditional | KeywordOperator |
        KeywordReturn =>
      rgb"0,0,255".text
    case Storageclass =>
      rgb"0,0,255".text.underline
    case TypeQualifier =>
      rgb"0,0,255".text.underline
    case PunctuationBracket        => rgb"0,0,0".text
    case PunctuationSpecial        => rgb"0,0,0".text
    case Type                      => rgb"38,127,153".text
    case String                    => rgb"163,21,21".text
    case FunctionCall | MethodCall => rgb"121,94,38".text
    case Number                    => rgb"9,134,88".text
    case Operator                  => rgb"0,0,0".text
    case Parameter                 => rgb"0,16,128".text
    case Include                   => rgb"0,0,255".text
    case Namespace                 => rgb"38,127,153".text
    case Property                  => rgb"0,16,128".text
    case Spell                     => rgb"96,139,78".text
    case Variable                  => rgb"0,16,128".text
    case Method                    => rgb"121,94,38".text
    case Boolean                   => rgb"9,134,88".text
    case TypeDefinition            => rgb"38,127,153".text
    case Float                     => rgb"9,134,88".text

  val VSCode: Theme = apply:
    case Container =>
      rgb"30,30,30".background.copy(text = Some(rgb"212,212,212"))
    case Function => rgb"220,220,170".text
    case Keyword | KeywordFunction | Repeat | Conditional | KeywordOperator |
        KeywordReturn =>
      rgb"197,134,192".text
    case Storageclass =>
      rgb"86,156,214".text.underline
    case TypeQualifier =>
      rgb"86,156,214".text.underline
    case PunctuationBracket        => rgb"212,212,212".text
    case PunctuationSpecial        => rgb"212,212,212".text
    case Type                      => rgb"78,201,176".text
    case String                    => rgb"206,145,120".text
    case FunctionCall | MethodCall => rgb"220,220,170".text
    case Number                    => rgb"181,206,168".text
    case Operator                  => rgb"212,212,212".text
    case Parameter                 => rgb"156,220,254".text
    case Include                   => rgb"197,134,192".text
    case Namespace                 => rgb"78,201,176".text
    case Property                  => rgb"156,220,254".text
    case Spell                     => rgb"106,153,85".text
    case Variable                  => rgb"156,220,254".text
    case Method                    => rgb"220,220,170".text
    case Boolean                   => rgb"181,206,168".text
    case TypeDefinition            => rgb"78,201,176".text
    case Float                     => rgb"181,206,168".text

  val Gruvbox: Theme = apply:
    case Container =>
      rgb"40,40,40".background.copy(text = Some(rgb"213,196,161"))
    case Function => rgb"184,187,38".text
    case Keyword | KeywordFunction | Repeat | Conditional | KeywordOperator |
        KeywordReturn =>
      rgb"251,73,52".text
    case Storageclass =>
      rgb"251,73,52".text.underline
    case TypeQualifier =>
      rgb"251,73,52".text.underline
    case PunctuationBracket =>
      rgb"168,153,132".text // "color: rgb(168,153,132);"
    case PunctuationSpecial        => rgb"254,128,25".text
    case Type                      => rgb"250,189,47".text
    case String                    => rgb"184,187,38".text
    case FunctionCall | MethodCall => rgb"184,187,38".text
    case Number                    => rgb"211,134,155".text
    case Operator                  => rgb"251,73,52".text
    case Parameter                 => rgb"213,196,161".text
    case Include                   => rgb"254,128,25".text
    case Namespace                 => rgb"250,189,47".text
    case Property                  => rgb"254,128,25".text
    case Spell                     => rgb"146,131,116".text
    case Variable                  => rgb"213,196,161".text
    case Method                    => rgb"184,187,38".text
    case Boolean                   => rgb"184,187,38".text

  val Kanagawa: Theme = apply:
    case Container =>
      rgb"31,31,40".background.copy(text = Some(rgb"255,255,255"))
    case Function => rgb"121,158,218".text
    case Keyword | KeywordFunction | Repeat | Conditional | KeywordOperator |
        KeywordReturn =>
      rgb"151,128,186".text
    case Storageclass =>
      rgb"151,128,186".text.underline
    case TypeQualifier =>
      rgb"151,128,186".text.underline
    case PunctuationBracket        => rgb"154, 172, 203".text
    case PunctuationSpecial        => rgb"127, 180, 202".text
    case Type | TypeDefinition     => rgb"114, 169, 159".text
    case String                    => rgb"152, 187, 108".text
    case FunctionCall | MethodCall => rgb"126, 156, 216".text
    case Number | Float            => rgb"255, 192, 203".text
    case Operator                  => rgb"196, 161, 107".text
    case Parameter                 => rgb"184, 181, 209".text
    case Include                   => rgb"228, 104, 118".text
    case Namespace                 => rgb"122, 168, 159".text
    case Property                  => rgb"234, 193, 128".text
    case Spell                     => rgb"85, 94, 136".text
    case Variable                  => rgb"192, 202, 245".text
    case Method                    => rgb"122, 162, 247".text
    case Boolean                   => rgb"258, 158, 100".text

  val x = true

  def buildCSS(theme: Theme, mentioned: Set[CaptureGroup]) =
    val sb = new StringBuilder
    val f = theme.lift

    f(Container).foreach: block =>
      sb ++= s"pre.ts-hl { \n${block.toCSS}\n}\n"

    mentioned.toList
      .sortBy(_.name)
      .foreach: cg =>
        f(cg).foreach: block =>
          sb ++= s".ts-hl-${cg.name.replace('.', '-')} {\n"
          sb ++= block.toCSS
          sb ++= "\n}\n"

    sb.result()
  end buildCSS
end Theme
