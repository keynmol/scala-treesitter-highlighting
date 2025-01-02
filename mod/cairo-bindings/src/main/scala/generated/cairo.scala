package cairo

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

object predef:
  private[cairo] trait CEnum[T](using eq: T =:= Int):
    given Tag[T] = Tag.Int.asInstanceOf[Tag[T]]
    extension (inline t: T) 
      inline def int: CInt = eq.apply(t)
      inline def value: CInt = eq.apply(t)
  private[cairo] trait CEnumU[T](using eq: T =:= UInt):
    given Tag[T] = Tag.UInt.asInstanceOf[Tag[T]]
    extension (inline t: T)
     inline def int: CInt = eq.apply(t).toInt
     inline def uint: CUnsignedInt = eq.apply(t)
     inline def value: CUnsignedInt = eq.apply(t)


object enumerations:
  import predef.*
  /**
   * ************************************************************************
  */
  opaque type FT_Encoding_ = CUnsignedInt
  object FT_Encoding_ extends CEnumU[FT_Encoding_]:
    given _tag: Tag[FT_Encoding_] = Tag.UInt
    inline def define(inline a: Long): FT_Encoding_ = a.toUInt
    val FT_ENCODING_NONE = define(0)
    val FT_ENCODING_MS_SYMBOL = define(1937337698)
    val FT_ENCODING_UNICODE = define(1970170211)
    val FT_ENCODING_SJIS = define(1936353651)
    val FT_ENCODING_PRC = define(1734484000)
    val FT_ENCODING_BIG5 = define(1651074869)
    val FT_ENCODING_WANSUNG = define(2002873971)
    val FT_ENCODING_JOHAB = define(1785686113)
    val FT_ENCODING_GB2312 = define(1734484000)
    val FT_ENCODING_MS_SJIS = define(1936353651)
    val FT_ENCODING_MS_GB2312 = define(1734484000)
    val FT_ENCODING_MS_BIG5 = define(1651074869)
    val FT_ENCODING_MS_WANSUNG = define(2002873971)
    val FT_ENCODING_MS_JOHAB = define(1785686113)
    val FT_ENCODING_ADOBE_STANDARD = define(1094995778)
    val FT_ENCODING_ADOBE_EXPERT = define(1094992453)
    val FT_ENCODING_ADOBE_CUSTOM = define(1094992451)
    val FT_ENCODING_ADOBE_LATIN_1 = define(1818326065)
    val FT_ENCODING_OLD_LATIN_2 = define(1818326066)
    val FT_ENCODING_APPLE_ROMAN = define(1634889070)
    inline def getName(inline value: FT_Encoding_): Option[String] =
      inline value match
        case FT_ENCODING_NONE => Some("FT_ENCODING_NONE")
        case FT_ENCODING_MS_SYMBOL => Some("FT_ENCODING_MS_SYMBOL")
        case FT_ENCODING_UNICODE => Some("FT_ENCODING_UNICODE")
        case FT_ENCODING_SJIS => Some("FT_ENCODING_SJIS")
        case FT_ENCODING_PRC => Some("FT_ENCODING_PRC")
        case FT_ENCODING_BIG5 => Some("FT_ENCODING_BIG5")
        case FT_ENCODING_WANSUNG => Some("FT_ENCODING_WANSUNG")
        case FT_ENCODING_JOHAB => Some("FT_ENCODING_JOHAB")
        case FT_ENCODING_GB2312 => Some("FT_ENCODING_GB2312")
        case FT_ENCODING_MS_SJIS => Some("FT_ENCODING_MS_SJIS")
        case FT_ENCODING_MS_GB2312 => Some("FT_ENCODING_MS_GB2312")
        case FT_ENCODING_MS_BIG5 => Some("FT_ENCODING_MS_BIG5")
        case FT_ENCODING_MS_WANSUNG => Some("FT_ENCODING_MS_WANSUNG")
        case FT_ENCODING_MS_JOHAB => Some("FT_ENCODING_MS_JOHAB")
        case FT_ENCODING_ADOBE_STANDARD => Some("FT_ENCODING_ADOBE_STANDARD")
        case FT_ENCODING_ADOBE_EXPERT => Some("FT_ENCODING_ADOBE_EXPERT")
        case FT_ENCODING_ADOBE_CUSTOM => Some("FT_ENCODING_ADOBE_CUSTOM")
        case FT_ENCODING_ADOBE_LATIN_1 => Some("FT_ENCODING_ADOBE_LATIN_1")
        case FT_ENCODING_OLD_LATIN_2 => Some("FT_ENCODING_OLD_LATIN_2")
        case FT_ENCODING_APPLE_ROMAN => Some("FT_ENCODING_APPLE_ROMAN")
        case _ => _root_.scala.None
    extension (a: FT_Encoding_)
      inline def &(b: FT_Encoding_): FT_Encoding_ = a & b
      inline def |(b: FT_Encoding_): FT_Encoding_ = a | b
      inline def is(b: FT_Encoding_): Boolean = (a & b) == b

  /**
   * ************************************************************************
  */
  opaque type FT_Glyph_Format_ = CUnsignedInt
  object FT_Glyph_Format_ extends CEnumU[FT_Glyph_Format_]:
    given _tag: Tag[FT_Glyph_Format_] = Tag.UInt
    inline def define(inline a: Long): FT_Glyph_Format_ = a.toUInt
    val FT_GLYPH_FORMAT_NONE = define(0)
    val FT_GLYPH_FORMAT_COMPOSITE = define(1668246896)
    val FT_GLYPH_FORMAT_BITMAP = define(1651078259)
    val FT_GLYPH_FORMAT_OUTLINE = define(1869968492)
    val FT_GLYPH_FORMAT_PLOTTER = define(1886154612)
    val FT_GLYPH_FORMAT_SVG = define(1398163232)
    inline def getName(inline value: FT_Glyph_Format_): Option[String] =
      inline value match
        case FT_GLYPH_FORMAT_NONE => Some("FT_GLYPH_FORMAT_NONE")
        case FT_GLYPH_FORMAT_COMPOSITE => Some("FT_GLYPH_FORMAT_COMPOSITE")
        case FT_GLYPH_FORMAT_BITMAP => Some("FT_GLYPH_FORMAT_BITMAP")
        case FT_GLYPH_FORMAT_OUTLINE => Some("FT_GLYPH_FORMAT_OUTLINE")
        case FT_GLYPH_FORMAT_PLOTTER => Some("FT_GLYPH_FORMAT_PLOTTER")
        case FT_GLYPH_FORMAT_SVG => Some("FT_GLYPH_FORMAT_SVG")
        case _ => _root_.scala.None
    extension (a: FT_Glyph_Format_)
      inline def &(b: FT_Glyph_Format_): FT_Glyph_Format_ = a & b
      inline def |(b: FT_Glyph_Format_): FT_Glyph_Format_ = a | b
      inline def is(b: FT_Glyph_Format_): Boolean = (a & b) == b

  /**
   * ************************************************************************
  */
  opaque type FT_Kerning_Mode_ = CUnsignedInt
  object FT_Kerning_Mode_ extends CEnumU[FT_Kerning_Mode_]:
    given _tag: Tag[FT_Kerning_Mode_] = Tag.UInt
    inline def define(inline a: Long): FT_Kerning_Mode_ = a.toUInt
    val FT_KERNING_DEFAULT = define(0)
    val FT_KERNING_UNFITTED = define(1)
    val FT_KERNING_UNSCALED = define(2)
    inline def getName(inline value: FT_Kerning_Mode_): Option[String] =
      inline value match
        case FT_KERNING_DEFAULT => Some("FT_KERNING_DEFAULT")
        case FT_KERNING_UNFITTED => Some("FT_KERNING_UNFITTED")
        case FT_KERNING_UNSCALED => Some("FT_KERNING_UNSCALED")
        case _ => _root_.scala.None
    extension (a: FT_Kerning_Mode_)
      inline def &(b: FT_Kerning_Mode_): FT_Kerning_Mode_ = a & b
      inline def |(b: FT_Kerning_Mode_): FT_Kerning_Mode_ = a | b
      inline def is(b: FT_Kerning_Mode_): Boolean = (a & b) == b

  /**
   * ************************************************************************
  */
  opaque type FT_Pixel_Mode_ = CUnsignedInt
  object FT_Pixel_Mode_ extends CEnumU[FT_Pixel_Mode_]:
    given _tag: Tag[FT_Pixel_Mode_] = Tag.UInt
    inline def define(inline a: Long): FT_Pixel_Mode_ = a.toUInt
    val FT_PIXEL_MODE_NONE = define(0)
    val FT_PIXEL_MODE_MONO = define(1)
    val FT_PIXEL_MODE_GRAY = define(2)
    val FT_PIXEL_MODE_GRAY2 = define(3)
    val FT_PIXEL_MODE_GRAY4 = define(4)
    val FT_PIXEL_MODE_LCD = define(5)
    val FT_PIXEL_MODE_LCD_V = define(6)
    val FT_PIXEL_MODE_BGRA = define(7)
    val FT_PIXEL_MODE_MAX = define(8)
    inline def getName(inline value: FT_Pixel_Mode_): Option[String] =
      inline value match
        case FT_PIXEL_MODE_NONE => Some("FT_PIXEL_MODE_NONE")
        case FT_PIXEL_MODE_MONO => Some("FT_PIXEL_MODE_MONO")
        case FT_PIXEL_MODE_GRAY => Some("FT_PIXEL_MODE_GRAY")
        case FT_PIXEL_MODE_GRAY2 => Some("FT_PIXEL_MODE_GRAY2")
        case FT_PIXEL_MODE_GRAY4 => Some("FT_PIXEL_MODE_GRAY4")
        case FT_PIXEL_MODE_LCD => Some("FT_PIXEL_MODE_LCD")
        case FT_PIXEL_MODE_LCD_V => Some("FT_PIXEL_MODE_LCD_V")
        case FT_PIXEL_MODE_BGRA => Some("FT_PIXEL_MODE_BGRA")
        case FT_PIXEL_MODE_MAX => Some("FT_PIXEL_MODE_MAX")
        case _ => _root_.scala.None
    extension (a: FT_Pixel_Mode_)
      inline def &(b: FT_Pixel_Mode_): FT_Pixel_Mode_ = a & b
      inline def |(b: FT_Pixel_Mode_): FT_Pixel_Mode_ = a | b
      inline def is(b: FT_Pixel_Mode_): Boolean = (a & b) == b

  /**
   * ************************************************************************
  */
  opaque type FT_Render_Mode_ = CUnsignedInt
  object FT_Render_Mode_ extends CEnumU[FT_Render_Mode_]:
    given _tag: Tag[FT_Render_Mode_] = Tag.UInt
    inline def define(inline a: Long): FT_Render_Mode_ = a.toUInt
    val FT_RENDER_MODE_NORMAL = define(0)
    val FT_RENDER_MODE_LIGHT = define(1)
    val FT_RENDER_MODE_MONO = define(2)
    val FT_RENDER_MODE_LCD = define(3)
    val FT_RENDER_MODE_LCD_V = define(4)
    val FT_RENDER_MODE_SDF = define(5)
    val FT_RENDER_MODE_MAX = define(6)
    inline def getName(inline value: FT_Render_Mode_): Option[String] =
      inline value match
        case FT_RENDER_MODE_NORMAL => Some("FT_RENDER_MODE_NORMAL")
        case FT_RENDER_MODE_LIGHT => Some("FT_RENDER_MODE_LIGHT")
        case FT_RENDER_MODE_MONO => Some("FT_RENDER_MODE_MONO")
        case FT_RENDER_MODE_LCD => Some("FT_RENDER_MODE_LCD")
        case FT_RENDER_MODE_LCD_V => Some("FT_RENDER_MODE_LCD_V")
        case FT_RENDER_MODE_SDF => Some("FT_RENDER_MODE_SDF")
        case FT_RENDER_MODE_MAX => Some("FT_RENDER_MODE_MAX")
        case _ => _root_.scala.None
    extension (a: FT_Render_Mode_)
      inline def &(b: FT_Render_Mode_): FT_Render_Mode_ = a & b
      inline def |(b: FT_Render_Mode_): FT_Render_Mode_ = a | b
      inline def is(b: FT_Render_Mode_): Boolean = (a & b) == b

  /**
   * ************************************************************************
  */
  opaque type FT_Size_Request_Type_ = CUnsignedInt
  object FT_Size_Request_Type_ extends CEnumU[FT_Size_Request_Type_]:
    given _tag: Tag[FT_Size_Request_Type_] = Tag.UInt
    inline def define(inline a: Long): FT_Size_Request_Type_ = a.toUInt
    val FT_SIZE_REQUEST_TYPE_NOMINAL = define(0)
    val FT_SIZE_REQUEST_TYPE_REAL_DIM = define(1)
    val FT_SIZE_REQUEST_TYPE_BBOX = define(2)
    val FT_SIZE_REQUEST_TYPE_CELL = define(3)
    val FT_SIZE_REQUEST_TYPE_SCALES = define(4)
    val FT_SIZE_REQUEST_TYPE_MAX = define(5)
    inline def getName(inline value: FT_Size_Request_Type_): Option[String] =
      inline value match
        case FT_SIZE_REQUEST_TYPE_NOMINAL => Some("FT_SIZE_REQUEST_TYPE_NOMINAL")
        case FT_SIZE_REQUEST_TYPE_REAL_DIM => Some("FT_SIZE_REQUEST_TYPE_REAL_DIM")
        case FT_SIZE_REQUEST_TYPE_BBOX => Some("FT_SIZE_REQUEST_TYPE_BBOX")
        case FT_SIZE_REQUEST_TYPE_CELL => Some("FT_SIZE_REQUEST_TYPE_CELL")
        case FT_SIZE_REQUEST_TYPE_SCALES => Some("FT_SIZE_REQUEST_TYPE_SCALES")
        case FT_SIZE_REQUEST_TYPE_MAX => Some("FT_SIZE_REQUEST_TYPE_MAX")
        case _ => _root_.scala.None
    extension (a: FT_Size_Request_Type_)
      inline def &(b: FT_Size_Request_Type_): FT_Size_Request_Type_ = a & b
      inline def |(b: FT_Size_Request_Type_): FT_Size_Request_Type_ = a | b
      inline def is(b: FT_Size_Request_Type_): Boolean = (a & b) == b

  opaque type FcEndian = CUnsignedInt
  object FcEndian extends CEnumU[FcEndian]:
    given _tag: Tag[FcEndian] = Tag.UInt
    inline def define(inline a: Long): FcEndian = a.toUInt
    val FcEndianBig = define(0)
    val FcEndianLittle = define(1)
    inline def getName(inline value: FcEndian): Option[String] =
      inline value match
        case FcEndianBig => Some("FcEndianBig")
        case FcEndianLittle => Some("FcEndianLittle")
        case _ => _root_.scala.None
    extension (a: FcEndian)
      inline def &(b: FcEndian): FcEndian = a & b
      inline def |(b: FcEndian): FcEndian = a | b
      inline def is(b: FcEndian): Boolean = (a & b) == b

  opaque type _FcLangResult = CUnsignedInt
  object _FcLangResult extends CEnumU[_FcLangResult]:
    given _tag: Tag[_FcLangResult] = Tag.UInt
    inline def define(inline a: Long): _FcLangResult = a.toUInt
    val FcLangEqual = define(0)
    val FcLangDifferentCountry = define(1)
    val FcLangDifferentTerritory = define(1)
    val FcLangDifferentLang = define(2)
    inline def getName(inline value: _FcLangResult): Option[String] =
      inline value match
        case FcLangEqual => Some("FcLangEqual")
        case FcLangDifferentCountry => Some("FcLangDifferentCountry")
        case FcLangDifferentTerritory => Some("FcLangDifferentTerritory")
        case FcLangDifferentLang => Some("FcLangDifferentLang")
        case _ => _root_.scala.None
    extension (a: _FcLangResult)
      inline def &(b: _FcLangResult): _FcLangResult = a & b
      inline def |(b: _FcLangResult): _FcLangResult = a | b
      inline def is(b: _FcLangResult): Boolean = (a & b) == b

  opaque type _FcMatchKind = CUnsignedInt
  object _FcMatchKind extends CEnumU[_FcMatchKind]:
    given _tag: Tag[_FcMatchKind] = Tag.UInt
    inline def define(inline a: Long): _FcMatchKind = a.toUInt
    val FcMatchPattern = define(0)
    val FcMatchFont = define(1)
    val FcMatchScan = define(2)
    val FcMatchKindEnd = define(3)
    val FcMatchKindBegin = define(0)
    inline def getName(inline value: _FcMatchKind): Option[String] =
      inline value match
        case FcMatchPattern => Some("FcMatchPattern")
        case FcMatchFont => Some("FcMatchFont")
        case FcMatchScan => Some("FcMatchScan")
        case FcMatchKindEnd => Some("FcMatchKindEnd")
        case FcMatchKindBegin => Some("FcMatchKindBegin")
        case _ => _root_.scala.None
    extension (a: _FcMatchKind)
      inline def &(b: _FcMatchKind): _FcMatchKind = a & b
      inline def |(b: _FcMatchKind): _FcMatchKind = a | b
      inline def is(b: _FcMatchKind): Boolean = (a & b) == b

  opaque type _FcResult = CUnsignedInt
  object _FcResult extends CEnumU[_FcResult]:
    given _tag: Tag[_FcResult] = Tag.UInt
    inline def define(inline a: Long): _FcResult = a.toUInt
    val FcResultMatch = define(0)
    val FcResultNoMatch = define(1)
    val FcResultTypeMismatch = define(2)
    val FcResultNoId = define(3)
    val FcResultOutOfMemory = define(4)
    inline def getName(inline value: _FcResult): Option[String] =
      inline value match
        case FcResultMatch => Some("FcResultMatch")
        case FcResultNoMatch => Some("FcResultNoMatch")
        case FcResultTypeMismatch => Some("FcResultTypeMismatch")
        case FcResultNoId => Some("FcResultNoId")
        case FcResultOutOfMemory => Some("FcResultOutOfMemory")
        case _ => _root_.scala.None
    extension (a: _FcResult)
      inline def &(b: _FcResult): _FcResult = a & b
      inline def |(b: _FcResult): _FcResult = a | b
      inline def is(b: _FcResult): Boolean = (a & b) == b

  opaque type _FcSetName = CUnsignedInt
  object _FcSetName extends CEnumU[_FcSetName]:
    given _tag: Tag[_FcSetName] = Tag.UInt
    inline def define(inline a: Long): _FcSetName = a.toUInt
    val FcSetSystem = define(0)
    val FcSetApplication = define(1)
    inline def getName(inline value: _FcSetName): Option[String] =
      inline value match
        case FcSetSystem => Some("FcSetSystem")
        case FcSetApplication => Some("FcSetApplication")
        case _ => _root_.scala.None
    extension (a: _FcSetName)
      inline def &(b: _FcSetName): _FcSetName = a & b
      inline def |(b: _FcSetName): _FcSetName = a | b
      inline def is(b: _FcSetName): Boolean = (a & b) == b

  opaque type _FcType = CInt
  object _FcType extends CEnum[_FcType]:
    given _tag: Tag[_FcType] = Tag.Int
    inline def define(inline a: CInt): _FcType = a
    val FcTypeUnknown = define(-1)
    val FcTypeVoid = define(0)
    val FcTypeInteger = define(1)
    val FcTypeDouble = define(2)
    val FcTypeString = define(3)
    val FcTypeBool = define(4)
    val FcTypeMatrix = define(5)
    val FcTypeCharSet = define(6)
    val FcTypeFTFace = define(7)
    val FcTypeLangSet = define(8)
    val FcTypeRange = define(9)
    inline def getName(inline value: _FcType): Option[String] =
      inline value match
        case FcTypeUnknown => Some("FcTypeUnknown")
        case FcTypeVoid => Some("FcTypeVoid")
        case FcTypeInteger => Some("FcTypeInteger")
        case FcTypeDouble => Some("FcTypeDouble")
        case FcTypeString => Some("FcTypeString")
        case FcTypeBool => Some("FcTypeBool")
        case FcTypeMatrix => Some("FcTypeMatrix")
        case FcTypeCharSet => Some("FcTypeCharSet")
        case FcTypeFTFace => Some("FcTypeFTFace")
        case FcTypeLangSet => Some("FcTypeLangSet")
        case FcTypeRange => Some("FcTypeRange")
        case _ => _root_.scala.None
    extension (a: _FcType)
      inline def &(b: _FcType): _FcType = a & b
      inline def |(b: _FcType): _FcType = a | b
      inline def is(b: _FcType): Boolean = (a & b) == b

  opaque type _FcValueBinding = CUnsignedInt
  object _FcValueBinding extends CEnumU[_FcValueBinding]:
    given _tag: Tag[_FcValueBinding] = Tag.UInt
    inline def define(inline a: Long): _FcValueBinding = a.toUInt
    val FcValueBindingWeak = define(0)
    val FcValueBindingStrong = define(1)
    val FcValueBindingSame = define(2)
    val FcValueBindingEnd = define(2147483647)
    inline def getName(inline value: _FcValueBinding): Option[String] =
      inline value match
        case FcValueBindingWeak => Some("FcValueBindingWeak")
        case FcValueBindingStrong => Some("FcValueBindingStrong")
        case FcValueBindingSame => Some("FcValueBindingSame")
        case FcValueBindingEnd => Some("FcValueBindingEnd")
        case _ => _root_.scala.None
    extension (a: _FcValueBinding)
      inline def &(b: _FcValueBinding): _FcValueBinding = a & b
      inline def |(b: _FcValueBinding): _FcValueBinding = a | b
      inline def is(b: _FcValueBinding): Boolean = (a & b) == b

  /**
   * cairo_antialias_t: _ANTIALIAS_DEFAULT: Use the default antialiasing for the subsystem and target device, since 1.0 _ANTIALIAS_NONE: Use a bilevel alpha mask, since 1.0 _ANTIALIAS_GRAY: Perform single-color antialiasing (using shades of gray for black text on a white background, for example), since 1.0 _ANTIALIAS_SUBPIXEL: Perform antialiasing by taking advantage of the order of subpixel elements on devices such as LCD panels, since 1.0 _ANTIALIAS_FAST: Hint that the backend should perform some antialiasing but prefer speed over quality, since 1.12 _ANTIALIAS_GOOD: The backend should balance quality against performance, since 1.12 _ANTIALIAS_BEST: Hint that the backend should render at the highest quality, sacrificing speed if necessary, since 1.12
  */
  opaque type _cairo_antialias = CUnsignedInt
  object _cairo_antialias extends CEnumU[_cairo_antialias]:
    given _tag: Tag[_cairo_antialias] = Tag.UInt
    inline def define(inline a: Long): _cairo_antialias = a.toUInt
    val CAIRO_ANTIALIAS_DEFAULT = define(0)
    val CAIRO_ANTIALIAS_NONE = define(1)
    val CAIRO_ANTIALIAS_GRAY = define(2)
    val CAIRO_ANTIALIAS_SUBPIXEL = define(3)
    val CAIRO_ANTIALIAS_FAST = define(4)
    val CAIRO_ANTIALIAS_GOOD = define(5)
    val CAIRO_ANTIALIAS_BEST = define(6)
    inline def getName(inline value: _cairo_antialias): Option[String] =
      inline value match
        case CAIRO_ANTIALIAS_DEFAULT => Some("CAIRO_ANTIALIAS_DEFAULT")
        case CAIRO_ANTIALIAS_NONE => Some("CAIRO_ANTIALIAS_NONE")
        case CAIRO_ANTIALIAS_GRAY => Some("CAIRO_ANTIALIAS_GRAY")
        case CAIRO_ANTIALIAS_SUBPIXEL => Some("CAIRO_ANTIALIAS_SUBPIXEL")
        case CAIRO_ANTIALIAS_FAST => Some("CAIRO_ANTIALIAS_FAST")
        case CAIRO_ANTIALIAS_GOOD => Some("CAIRO_ANTIALIAS_GOOD")
        case CAIRO_ANTIALIAS_BEST => Some("CAIRO_ANTIALIAS_BEST")
        case _ => _root_.scala.None
    extension (a: _cairo_antialias)
      inline def &(b: _cairo_antialias): _cairo_antialias = a & b
      inline def |(b: _cairo_antialias): _cairo_antialias = a | b
      inline def is(b: _cairo_antialias): Boolean = (a & b) == b

  /**
   * cairo_color_mode_t: _COLOR_MODE_DEFAULT: Use the default color mode for font backend and target device, since 1.18. _COLOR_MODE_NO_COLOR: Disable rendering color glyphs. Glyphs are always rendered as outline glyphs, since 1.18. _COLOR_MODE_COLOR: Enable rendering color glyphs. If the font contains a color presentation for a glyph, and when supported by the font backend, the glyph will be rendered in color, since 1.18.
  */
  opaque type _cairo_color_mode = CUnsignedInt
  object _cairo_color_mode extends CEnumU[_cairo_color_mode]:
    given _tag: Tag[_cairo_color_mode] = Tag.UInt
    inline def define(inline a: Long): _cairo_color_mode = a.toUInt
    val CAIRO_COLOR_MODE_DEFAULT = define(0)
    val CAIRO_COLOR_MODE_NO_COLOR = define(1)
    val CAIRO_COLOR_MODE_COLOR = define(2)
    inline def getName(inline value: _cairo_color_mode): Option[String] =
      inline value match
        case CAIRO_COLOR_MODE_DEFAULT => Some("CAIRO_COLOR_MODE_DEFAULT")
        case CAIRO_COLOR_MODE_NO_COLOR => Some("CAIRO_COLOR_MODE_NO_COLOR")
        case CAIRO_COLOR_MODE_COLOR => Some("CAIRO_COLOR_MODE_COLOR")
        case _ => _root_.scala.None
    extension (a: _cairo_color_mode)
      inline def &(b: _cairo_color_mode): _cairo_color_mode = a & b
      inline def |(b: _cairo_color_mode): _cairo_color_mode = a | b
      inline def is(b: _cairo_color_mode): Boolean = (a & b) == b

  /**
   * cairo_content_t: _CONTENT_COLOR: The surface will hold color content only. (Since 1.0) _CONTENT_ALPHA: The surface will hold alpha content only. (Since 1.0) _CONTENT_COLOR_ALPHA: The surface will hold color and alpha content. (Since 1.0)
  */
  opaque type _cairo_content = CUnsignedInt
  object _cairo_content extends CEnumU[_cairo_content]:
    given _tag: Tag[_cairo_content] = Tag.UInt
    inline def define(inline a: Long): _cairo_content = a.toUInt
    val CAIRO_CONTENT_COLOR = define(4096)
    val CAIRO_CONTENT_ALPHA = define(8192)
    val CAIRO_CONTENT_COLOR_ALPHA = define(12288)
    inline def getName(inline value: _cairo_content): Option[String] =
      inline value match
        case CAIRO_CONTENT_COLOR => Some("CAIRO_CONTENT_COLOR")
        case CAIRO_CONTENT_ALPHA => Some("CAIRO_CONTENT_ALPHA")
        case CAIRO_CONTENT_COLOR_ALPHA => Some("CAIRO_CONTENT_COLOR_ALPHA")
        case _ => _root_.scala.None
    extension (a: _cairo_content)
      inline def &(b: _cairo_content): _cairo_content = a & b
      inline def |(b: _cairo_content): _cairo_content = a | b
      inline def is(b: _cairo_content): Boolean = (a & b) == b

  /**
   * cairo_device_type_t: _DEVICE_TYPE_DRM: The device is of type Direct Render Manager, since 1.10 _DEVICE_TYPE_GL: The device is of type OpenGL, since 1.10 _DEVICE_TYPE_SCRIPT: The device is of type script, since 1.10 _DEVICE_TYPE_XCB: The device is of type xcb, since 1.10 _DEVICE_TYPE_XLIB: The device is of type xlib, since 1.10 _DEVICE_TYPE_XML: The device is of type XML, since 1.10 _DEVICE_TYPE_COGL: The device is of type cogl, since 1.12 _DEVICE_TYPE_WIN32: The device is of type win32, since 1.12 _DEVICE_TYPE_INVALID: The device is invalid, since 1.10
  */
  opaque type _cairo_device_type = CInt
  object _cairo_device_type extends CEnum[_cairo_device_type]:
    given _tag: Tag[_cairo_device_type] = Tag.Int
    inline def define(inline a: CInt): _cairo_device_type = a
    val CAIRO_DEVICE_TYPE_DRM = define(0)
    val CAIRO_DEVICE_TYPE_GL = define(1)
    val CAIRO_DEVICE_TYPE_SCRIPT = define(2)
    val CAIRO_DEVICE_TYPE_XCB = define(3)
    val CAIRO_DEVICE_TYPE_XLIB = define(4)
    val CAIRO_DEVICE_TYPE_XML = define(5)
    val CAIRO_DEVICE_TYPE_COGL = define(6)
    val CAIRO_DEVICE_TYPE_WIN32 = define(7)
    val CAIRO_DEVICE_TYPE_INVALID = define(-1)
    inline def getName(inline value: _cairo_device_type): Option[String] =
      inline value match
        case CAIRO_DEVICE_TYPE_DRM => Some("CAIRO_DEVICE_TYPE_DRM")
        case CAIRO_DEVICE_TYPE_GL => Some("CAIRO_DEVICE_TYPE_GL")
        case CAIRO_DEVICE_TYPE_SCRIPT => Some("CAIRO_DEVICE_TYPE_SCRIPT")
        case CAIRO_DEVICE_TYPE_XCB => Some("CAIRO_DEVICE_TYPE_XCB")
        case CAIRO_DEVICE_TYPE_XLIB => Some("CAIRO_DEVICE_TYPE_XLIB")
        case CAIRO_DEVICE_TYPE_XML => Some("CAIRO_DEVICE_TYPE_XML")
        case CAIRO_DEVICE_TYPE_COGL => Some("CAIRO_DEVICE_TYPE_COGL")
        case CAIRO_DEVICE_TYPE_WIN32 => Some("CAIRO_DEVICE_TYPE_WIN32")
        case CAIRO_DEVICE_TYPE_INVALID => Some("CAIRO_DEVICE_TYPE_INVALID")
        case _ => _root_.scala.None
    extension (a: _cairo_device_type)
      inline def &(b: _cairo_device_type): _cairo_device_type = a & b
      inline def |(b: _cairo_device_type): _cairo_device_type = a | b
      inline def is(b: _cairo_device_type): Boolean = (a & b) == b

  /**
   * cairo_dither_t: _DITHER_NONE: No dithering. _DITHER_DEFAULT: Default choice at cairo compile time. Currently NONE. _DITHER_FAST: Fastest dithering algorithm supported by the backend _DITHER_GOOD: An algorithm with smoother dithering than FAST _DITHER_BEST: Best algorithm available in the backend
  */
  opaque type _cairo_dither = CUnsignedInt
  object _cairo_dither extends CEnumU[_cairo_dither]:
    given _tag: Tag[_cairo_dither] = Tag.UInt
    inline def define(inline a: Long): _cairo_dither = a.toUInt
    val CAIRO_DITHER_NONE = define(0)
    val CAIRO_DITHER_DEFAULT = define(1)
    val CAIRO_DITHER_FAST = define(2)
    val CAIRO_DITHER_GOOD = define(3)
    val CAIRO_DITHER_BEST = define(4)
    inline def getName(inline value: _cairo_dither): Option[String] =
      inline value match
        case CAIRO_DITHER_NONE => Some("CAIRO_DITHER_NONE")
        case CAIRO_DITHER_DEFAULT => Some("CAIRO_DITHER_DEFAULT")
        case CAIRO_DITHER_FAST => Some("CAIRO_DITHER_FAST")
        case CAIRO_DITHER_GOOD => Some("CAIRO_DITHER_GOOD")
        case CAIRO_DITHER_BEST => Some("CAIRO_DITHER_BEST")
        case _ => _root_.scala.None
    extension (a: _cairo_dither)
      inline def &(b: _cairo_dither): _cairo_dither = a & b
      inline def |(b: _cairo_dither): _cairo_dither = a | b
      inline def is(b: _cairo_dither): Boolean = (a & b) == b

  /**
   * cairo_extend_t: _EXTEND_NONE: pixels outside of the source pattern are fully transparent (Since 1.0) _EXTEND_REPEAT: the pattern is tiled by repeating (Since 1.0) _EXTEND_REFLECT: the pattern is tiled by reflecting at the edges (Since 1.0; but only implemented for surface patterns since 1.6) _EXTEND_PAD: pixels outside of the pattern copy the closest pixel from the source (Since 1.2; but only implemented for surface patterns since 1.6)
  */
  opaque type _cairo_extend = CUnsignedInt
  object _cairo_extend extends CEnumU[_cairo_extend]:
    given _tag: Tag[_cairo_extend] = Tag.UInt
    inline def define(inline a: Long): _cairo_extend = a.toUInt
    val CAIRO_EXTEND_NONE = define(0)
    val CAIRO_EXTEND_REPEAT = define(1)
    val CAIRO_EXTEND_REFLECT = define(2)
    val CAIRO_EXTEND_PAD = define(3)
    inline def getName(inline value: _cairo_extend): Option[String] =
      inline value match
        case CAIRO_EXTEND_NONE => Some("CAIRO_EXTEND_NONE")
        case CAIRO_EXTEND_REPEAT => Some("CAIRO_EXTEND_REPEAT")
        case CAIRO_EXTEND_REFLECT => Some("CAIRO_EXTEND_REFLECT")
        case CAIRO_EXTEND_PAD => Some("CAIRO_EXTEND_PAD")
        case _ => _root_.scala.None
    extension (a: _cairo_extend)
      inline def &(b: _cairo_extend): _cairo_extend = a & b
      inline def |(b: _cairo_extend): _cairo_extend = a | b
      inline def is(b: _cairo_extend): Boolean = (a & b) == b

  /**
   * cairo_fill_rule_t: _FILL_RULE_WINDING: If the path crosses the ray from left-to-right, counts +1. If the path crosses the ray from right to left, counts -1. (Left and right are determined from the perspective of looking along the ray from the starting point.) If the total count is non-zero, the point will be filled. (Since 1.0) _FILL_RULE_EVEN_ODD: Counts the total number of intersections, without regard to the orientation of the contour. If the total number of intersections is odd, the point will be filled. (Since 1.0)
  */
  opaque type _cairo_fill_rule = CUnsignedInt
  object _cairo_fill_rule extends CEnumU[_cairo_fill_rule]:
    given _tag: Tag[_cairo_fill_rule] = Tag.UInt
    inline def define(inline a: Long): _cairo_fill_rule = a.toUInt
    val CAIRO_FILL_RULE_WINDING = define(0)
    val CAIRO_FILL_RULE_EVEN_ODD = define(1)
    inline def getName(inline value: _cairo_fill_rule): Option[String] =
      inline value match
        case CAIRO_FILL_RULE_WINDING => Some("CAIRO_FILL_RULE_WINDING")
        case CAIRO_FILL_RULE_EVEN_ODD => Some("CAIRO_FILL_RULE_EVEN_ODD")
        case _ => _root_.scala.None
    extension (a: _cairo_fill_rule)
      inline def &(b: _cairo_fill_rule): _cairo_fill_rule = a & b
      inline def |(b: _cairo_fill_rule): _cairo_fill_rule = a | b
      inline def is(b: _cairo_fill_rule): Boolean = (a & b) == b

  /**
   * cairo_filter_t: _FILTER_FAST: A high-performance filter, with quality similar to %CAIRO_FILTER_NEAREST (Since 1.0) _FILTER_GOOD: A reasonable-performance filter, with quality similar to %CAIRO_FILTER_BILINEAR (Since 1.0) _FILTER_BEST: The highest-quality available, performance may not be suitable for interactive use. (Since 1.0) _FILTER_NEAREST: Nearest-neighbor filtering (Since 1.0) _FILTER_BILINEAR: Linear interpolation in two dimensions (Since 1.0) _FILTER_GAUSSIAN: This filter value is currently unimplemented, and should not be used in current code. (Since 1.0)
  */
  opaque type _cairo_filter = CUnsignedInt
  object _cairo_filter extends CEnumU[_cairo_filter]:
    given _tag: Tag[_cairo_filter] = Tag.UInt
    inline def define(inline a: Long): _cairo_filter = a.toUInt
    val CAIRO_FILTER_FAST = define(0)
    val CAIRO_FILTER_GOOD = define(1)
    val CAIRO_FILTER_BEST = define(2)
    val CAIRO_FILTER_NEAREST = define(3)
    val CAIRO_FILTER_BILINEAR = define(4)
    val CAIRO_FILTER_GAUSSIAN = define(5)
    inline def getName(inline value: _cairo_filter): Option[String] =
      inline value match
        case CAIRO_FILTER_FAST => Some("CAIRO_FILTER_FAST")
        case CAIRO_FILTER_GOOD => Some("CAIRO_FILTER_GOOD")
        case CAIRO_FILTER_BEST => Some("CAIRO_FILTER_BEST")
        case CAIRO_FILTER_NEAREST => Some("CAIRO_FILTER_NEAREST")
        case CAIRO_FILTER_BILINEAR => Some("CAIRO_FILTER_BILINEAR")
        case CAIRO_FILTER_GAUSSIAN => Some("CAIRO_FILTER_GAUSSIAN")
        case _ => _root_.scala.None
    extension (a: _cairo_filter)
      inline def &(b: _cairo_filter): _cairo_filter = a & b
      inline def |(b: _cairo_filter): _cairo_filter = a | b
      inline def is(b: _cairo_filter): Boolean = (a & b) == b

  /**
   * cairo_font_slant_t: _FONT_SLANT_NORMAL: Upright font style, since 1.0 _FONT_SLANT_ITALIC: Italic font style, since 1.0 _FONT_SLANT_OBLIQUE: Oblique font style, since 1.0
  */
  opaque type _cairo_font_slant = CUnsignedInt
  object _cairo_font_slant extends CEnumU[_cairo_font_slant]:
    given _tag: Tag[_cairo_font_slant] = Tag.UInt
    inline def define(inline a: Long): _cairo_font_slant = a.toUInt
    val CAIRO_FONT_SLANT_NORMAL = define(0)
    val CAIRO_FONT_SLANT_ITALIC = define(1)
    val CAIRO_FONT_SLANT_OBLIQUE = define(2)
    inline def getName(inline value: _cairo_font_slant): Option[String] =
      inline value match
        case CAIRO_FONT_SLANT_NORMAL => Some("CAIRO_FONT_SLANT_NORMAL")
        case CAIRO_FONT_SLANT_ITALIC => Some("CAIRO_FONT_SLANT_ITALIC")
        case CAIRO_FONT_SLANT_OBLIQUE => Some("CAIRO_FONT_SLANT_OBLIQUE")
        case _ => _root_.scala.None
    extension (a: _cairo_font_slant)
      inline def &(b: _cairo_font_slant): _cairo_font_slant = a & b
      inline def |(b: _cairo_font_slant): _cairo_font_slant = a | b
      inline def is(b: _cairo_font_slant): Boolean = (a & b) == b

  /**
   * cairo_font_type_t: _FONT_TYPE_TOY: The font was created using cairo's toy font api (Since: 1.2) _FONT_TYPE_FT: The font is of type FreeType (Since: 1.2) _FONT_TYPE_WIN32: The font is of type Win32 (Since: 1.2) _FONT_TYPE_QUARTZ: The font is of type Quartz (Since: 1.6, in 1.2 and 1.4 it was named CAIRO_FONT_TYPE_ATSUI) _FONT_TYPE_USER: The font was create using cairo's user font api (Since: 1.8) _FONT_TYPE_DWRITE: The font is of type Win32 DWrite (Since: 1.18)
  */
  opaque type _cairo_font_type = CUnsignedInt
  object _cairo_font_type extends CEnumU[_cairo_font_type]:
    given _tag: Tag[_cairo_font_type] = Tag.UInt
    inline def define(inline a: Long): _cairo_font_type = a.toUInt
    val CAIRO_FONT_TYPE_TOY = define(0)
    val CAIRO_FONT_TYPE_FT = define(1)
    val CAIRO_FONT_TYPE_WIN32 = define(2)
    val CAIRO_FONT_TYPE_QUARTZ = define(3)
    val CAIRO_FONT_TYPE_USER = define(4)
    val CAIRO_FONT_TYPE_DWRITE = define(5)
    inline def getName(inline value: _cairo_font_type): Option[String] =
      inline value match
        case CAIRO_FONT_TYPE_TOY => Some("CAIRO_FONT_TYPE_TOY")
        case CAIRO_FONT_TYPE_FT => Some("CAIRO_FONT_TYPE_FT")
        case CAIRO_FONT_TYPE_WIN32 => Some("CAIRO_FONT_TYPE_WIN32")
        case CAIRO_FONT_TYPE_QUARTZ => Some("CAIRO_FONT_TYPE_QUARTZ")
        case CAIRO_FONT_TYPE_USER => Some("CAIRO_FONT_TYPE_USER")
        case CAIRO_FONT_TYPE_DWRITE => Some("CAIRO_FONT_TYPE_DWRITE")
        case _ => _root_.scala.None
    extension (a: _cairo_font_type)
      inline def &(b: _cairo_font_type): _cairo_font_type = a & b
      inline def |(b: _cairo_font_type): _cairo_font_type = a | b
      inline def is(b: _cairo_font_type): Boolean = (a & b) == b

  /**
   * cairo_font_weight_t: _FONT_WEIGHT_NORMAL: Normal font weight, since 1.0 _FONT_WEIGHT_BOLD: Bold font weight, since 1.0
  */
  opaque type _cairo_font_weight = CUnsignedInt
  object _cairo_font_weight extends CEnumU[_cairo_font_weight]:
    given _tag: Tag[_cairo_font_weight] = Tag.UInt
    inline def define(inline a: Long): _cairo_font_weight = a.toUInt
    val CAIRO_FONT_WEIGHT_NORMAL = define(0)
    val CAIRO_FONT_WEIGHT_BOLD = define(1)
    inline def getName(inline value: _cairo_font_weight): Option[String] =
      inline value match
        case CAIRO_FONT_WEIGHT_NORMAL => Some("CAIRO_FONT_WEIGHT_NORMAL")
        case CAIRO_FONT_WEIGHT_BOLD => Some("CAIRO_FONT_WEIGHT_BOLD")
        case _ => _root_.scala.None
    extension (a: _cairo_font_weight)
      inline def &(b: _cairo_font_weight): _cairo_font_weight = a & b
      inline def |(b: _cairo_font_weight): _cairo_font_weight = a | b
      inline def is(b: _cairo_font_weight): Boolean = (a & b) == b

  /**
   * cairo_format_t: _FORMAT_INVALID: no such format exists or is supported. _FORMAT_ARGB32: each pixel is a 32-bit quantity, with alpha in the upper 8 bits, then red, then green, then blue. The 32-bit quantities are stored native-endian. Pre-multiplied alpha is used. (That is, 50% transparent red is 0x80800000, not 0x80ff0000.) (Since 1.0) _FORMAT_RGB24: each pixel is a 32-bit quantity, with the upper 8 bits unused. Red, Green, and Blue are stored in the remaining 24 bits in that order. (Since 1.0) _FORMAT_A8: each pixel is a 8-bit quantity holding an alpha value. (Since 1.0) _FORMAT_A1: each pixel is a 1-bit quantity holding an alpha value. Pixels are packed together into 32-bit quantities. The ordering of the bits matches the endianness of the platform. On a big-endian machine, the first pixel is in the uppermost bit, on a little-endian machine the first pixel is in the least-significant bit. (Since 1.0) _FORMAT_RGB16_565: each pixel is a 16-bit quantity with red in the upper 5 bits, then green in the middle 6 bits, and blue in the lower 5 bits. (Since 1.2) _FORMAT_RGB30: like RGB24 but with 10bpc. (Since 1.12) _FORMAT_RGB96F: 3 floats, R, G, B. (Since 1.17.2) _FORMAT_RGBA128F: 4 floats, R, G, B, A. (Since 1.17.2)
  */
  opaque type _cairo_format = CInt
  object _cairo_format extends CEnum[_cairo_format]:
    given _tag: Tag[_cairo_format] = Tag.Int
    inline def define(inline a: CInt): _cairo_format = a
    val CAIRO_FORMAT_INVALID = define(-1)
    val CAIRO_FORMAT_ARGB32 = define(0)
    val CAIRO_FORMAT_RGB24 = define(1)
    val CAIRO_FORMAT_A8 = define(2)
    val CAIRO_FORMAT_A1 = define(3)
    val CAIRO_FORMAT_RGB16_565 = define(4)
    val CAIRO_FORMAT_RGB30 = define(5)
    val CAIRO_FORMAT_RGB96F = define(6)
    val CAIRO_FORMAT_RGBA128F = define(7)
    inline def getName(inline value: _cairo_format): Option[String] =
      inline value match
        case CAIRO_FORMAT_INVALID => Some("CAIRO_FORMAT_INVALID")
        case CAIRO_FORMAT_ARGB32 => Some("CAIRO_FORMAT_ARGB32")
        case CAIRO_FORMAT_RGB24 => Some("CAIRO_FORMAT_RGB24")
        case CAIRO_FORMAT_A8 => Some("CAIRO_FORMAT_A8")
        case CAIRO_FORMAT_A1 => Some("CAIRO_FORMAT_A1")
        case CAIRO_FORMAT_RGB16_565 => Some("CAIRO_FORMAT_RGB16_565")
        case CAIRO_FORMAT_RGB30 => Some("CAIRO_FORMAT_RGB30")
        case CAIRO_FORMAT_RGB96F => Some("CAIRO_FORMAT_RGB96F")
        case CAIRO_FORMAT_RGBA128F => Some("CAIRO_FORMAT_RGBA128F")
        case _ => _root_.scala.None
    extension (a: _cairo_format)
      inline def &(b: _cairo_format): _cairo_format = a & b
      inline def |(b: _cairo_format): _cairo_format = a | b
      inline def is(b: _cairo_format): Boolean = (a & b) == b

  /**
   * cairo_hint_metrics_t: _HINT_METRICS_DEFAULT: Hint metrics in the default manner for the font backend and target device, since 1.0 _HINT_METRICS_OFF: Do not hint font metrics, since 1.0 _HINT_METRICS_ON: Hint font metrics, since 1.0
  */
  opaque type _cairo_hint_metrics = CUnsignedInt
  object _cairo_hint_metrics extends CEnumU[_cairo_hint_metrics]:
    given _tag: Tag[_cairo_hint_metrics] = Tag.UInt
    inline def define(inline a: Long): _cairo_hint_metrics = a.toUInt
    val CAIRO_HINT_METRICS_DEFAULT = define(0)
    val CAIRO_HINT_METRICS_OFF = define(1)
    val CAIRO_HINT_METRICS_ON = define(2)
    inline def getName(inline value: _cairo_hint_metrics): Option[String] =
      inline value match
        case CAIRO_HINT_METRICS_DEFAULT => Some("CAIRO_HINT_METRICS_DEFAULT")
        case CAIRO_HINT_METRICS_OFF => Some("CAIRO_HINT_METRICS_OFF")
        case CAIRO_HINT_METRICS_ON => Some("CAIRO_HINT_METRICS_ON")
        case _ => _root_.scala.None
    extension (a: _cairo_hint_metrics)
      inline def &(b: _cairo_hint_metrics): _cairo_hint_metrics = a & b
      inline def |(b: _cairo_hint_metrics): _cairo_hint_metrics = a | b
      inline def is(b: _cairo_hint_metrics): Boolean = (a & b) == b

  /**
   * cairo_hint_style_t: _HINT_STYLE_DEFAULT: Use the default hint style for font backend and target device, since 1.0 _HINT_STYLE_NONE: Do not hint outlines, since 1.0 _HINT_STYLE_SLIGHT: Hint outlines slightly to improve contrast while retaining good fidelity to the original shapes, since 1.0 _HINT_STYLE_MEDIUM: Hint outlines with medium strength giving a compromise between fidelity to the original shapes and contrast, since 1.0 _HINT_STYLE_FULL: Hint outlines to maximize contrast, since 1.0
  */
  opaque type _cairo_hint_style = CUnsignedInt
  object _cairo_hint_style extends CEnumU[_cairo_hint_style]:
    given _tag: Tag[_cairo_hint_style] = Tag.UInt
    inline def define(inline a: Long): _cairo_hint_style = a.toUInt
    val CAIRO_HINT_STYLE_DEFAULT = define(0)
    val CAIRO_HINT_STYLE_NONE = define(1)
    val CAIRO_HINT_STYLE_SLIGHT = define(2)
    val CAIRO_HINT_STYLE_MEDIUM = define(3)
    val CAIRO_HINT_STYLE_FULL = define(4)
    inline def getName(inline value: _cairo_hint_style): Option[String] =
      inline value match
        case CAIRO_HINT_STYLE_DEFAULT => Some("CAIRO_HINT_STYLE_DEFAULT")
        case CAIRO_HINT_STYLE_NONE => Some("CAIRO_HINT_STYLE_NONE")
        case CAIRO_HINT_STYLE_SLIGHT => Some("CAIRO_HINT_STYLE_SLIGHT")
        case CAIRO_HINT_STYLE_MEDIUM => Some("CAIRO_HINT_STYLE_MEDIUM")
        case CAIRO_HINT_STYLE_FULL => Some("CAIRO_HINT_STYLE_FULL")
        case _ => _root_.scala.None
    extension (a: _cairo_hint_style)
      inline def &(b: _cairo_hint_style): _cairo_hint_style = a & b
      inline def |(b: _cairo_hint_style): _cairo_hint_style = a | b
      inline def is(b: _cairo_hint_style): Boolean = (a & b) == b

  /**
   * cairo_line_cap_t: _LINE_CAP_BUTT: start(stop) the line exactly at the start(end) point (Since 1.0) _LINE_CAP_ROUND: use a round ending, the center of the circle is the end point (Since 1.0) _LINE_CAP_SQUARE: use squared ending, the center of the square is the end point (Since 1.0)
  */
  opaque type _cairo_line_cap = CUnsignedInt
  object _cairo_line_cap extends CEnumU[_cairo_line_cap]:
    given _tag: Tag[_cairo_line_cap] = Tag.UInt
    inline def define(inline a: Long): _cairo_line_cap = a.toUInt
    val CAIRO_LINE_CAP_BUTT = define(0)
    val CAIRO_LINE_CAP_ROUND = define(1)
    val CAIRO_LINE_CAP_SQUARE = define(2)
    inline def getName(inline value: _cairo_line_cap): Option[String] =
      inline value match
        case CAIRO_LINE_CAP_BUTT => Some("CAIRO_LINE_CAP_BUTT")
        case CAIRO_LINE_CAP_ROUND => Some("CAIRO_LINE_CAP_ROUND")
        case CAIRO_LINE_CAP_SQUARE => Some("CAIRO_LINE_CAP_SQUARE")
        case _ => _root_.scala.None
    extension (a: _cairo_line_cap)
      inline def &(b: _cairo_line_cap): _cairo_line_cap = a & b
      inline def |(b: _cairo_line_cap): _cairo_line_cap = a | b
      inline def is(b: _cairo_line_cap): Boolean = (a & b) == b

  /**
   * cairo_line_join_t: _LINE_JOIN_MITER: use a sharp (angled) corner, see cairo_set_miter_limit() (Since 1.0) _LINE_JOIN_ROUND: use a rounded join, the center of the circle is the joint point (Since 1.0) _LINE_JOIN_BEVEL: use a cut-off join, the join is cut off at half the line width from the joint point (Since 1.0)
  */
  opaque type _cairo_line_join = CUnsignedInt
  object _cairo_line_join extends CEnumU[_cairo_line_join]:
    given _tag: Tag[_cairo_line_join] = Tag.UInt
    inline def define(inline a: Long): _cairo_line_join = a.toUInt
    val CAIRO_LINE_JOIN_MITER = define(0)
    val CAIRO_LINE_JOIN_ROUND = define(1)
    val CAIRO_LINE_JOIN_BEVEL = define(2)
    inline def getName(inline value: _cairo_line_join): Option[String] =
      inline value match
        case CAIRO_LINE_JOIN_MITER => Some("CAIRO_LINE_JOIN_MITER")
        case CAIRO_LINE_JOIN_ROUND => Some("CAIRO_LINE_JOIN_ROUND")
        case CAIRO_LINE_JOIN_BEVEL => Some("CAIRO_LINE_JOIN_BEVEL")
        case _ => _root_.scala.None
    extension (a: _cairo_line_join)
      inline def &(b: _cairo_line_join): _cairo_line_join = a & b
      inline def |(b: _cairo_line_join): _cairo_line_join = a | b
      inline def is(b: _cairo_line_join): Boolean = (a & b) == b

  /**
   * cairo_operator_t: _OPERATOR_CLEAR: clear destination layer (bounded) (Since 1.0) _OPERATOR_SOURCE: replace destination layer (bounded) (Since 1.0) _OPERATOR_OVER: draw source layer on top of destination layer (bounded) (Since 1.0) _OPERATOR_IN: draw source where there was destination content (unbounded) (Since 1.0) _OPERATOR_OUT: draw source where there was no destination content (unbounded) (Since 1.0) _OPERATOR_ATOP: draw source on top of destination content and only there (Since 1.0) _OPERATOR_DEST: ignore the source (Since 1.0) _OPERATOR_DEST_OVER: draw destination on top of source (Since 1.0) _OPERATOR_DEST_IN: leave destination only where there was source content (unbounded) (Since 1.0) _OPERATOR_DEST_OUT: leave destination only where there was no source content (Since 1.0) _OPERATOR_DEST_ATOP: leave destination on top of source content and only there (unbounded) (Since 1.0) _OPERATOR_XOR: source and destination are shown where there is only one of them (Since 1.0) _OPERATOR_ADD: source and destination layers are accumulated (Since 1.0) _OPERATOR_SATURATE: like over, but assuming source and dest are disjoint geometries (Since 1.0) _OPERATOR_MULTIPLY: source and destination layers are multiplied. This causes the result to be at least as dark as the darker inputs. (Since 1.10) _OPERATOR_SCREEN: source and destination are complemented and multiplied. This causes the result to be at least as light as the lighter inputs. (Since 1.10) _OPERATOR_OVERLAY: multiplies or screens, depending on the lightness of the destination color. (Since 1.10) _OPERATOR_DARKEN: replaces the destination with the source if it is darker, otherwise keeps the source. (Since 1.10) _OPERATOR_LIGHTEN: replaces the destination with the source if it is lighter, otherwise keeps the source. (Since 1.10) _OPERATOR_COLOR_DODGE: brightens the destination color to reflect the source color. (Since 1.10) _OPERATOR_COLOR_BURN: darkens the destination color to reflect the source color. (Since 1.10) _OPERATOR_HARD_LIGHT: Multiplies or screens, dependent on source color. (Since 1.10) _OPERATOR_SOFT_LIGHT: Darkens or lightens, dependent on source color. (Since 1.10) _OPERATOR_DIFFERENCE: Takes the difference of the source and destination color. (Since 1.10) _OPERATOR_EXCLUSION: Produces an effect similar to difference, but with lower contrast. (Since 1.10) _OPERATOR_HSL_HUE: Creates a color with the hue of the source and the saturation and luminosity of the target. (Since 1.10) _OPERATOR_HSL_SATURATION: Creates a color with the saturation of the source and the hue and luminosity of the target. Painting with this mode onto a gray area produces no change. (Since 1.10) _OPERATOR_HSL_COLOR: Creates a color with the hue and saturation of the source and the luminosity of the target. This preserves the gray levels of the target and is useful for coloring monochrome images or tinting color images. (Since 1.10) _OPERATOR_HSL_LUMINOSITY: Creates a color with the luminosity of the source and the hue and saturation of the target. This produces an inverse effect to _OPERATOR_HSL_COLOR. (Since 1.10)
  */
  opaque type _cairo_operator = CUnsignedInt
  object _cairo_operator extends CEnumU[_cairo_operator]:
    given _tag: Tag[_cairo_operator] = Tag.UInt
    inline def define(inline a: Long): _cairo_operator = a.toUInt
    val CAIRO_OPERATOR_CLEAR = define(0)
    val CAIRO_OPERATOR_SOURCE = define(1)
    val CAIRO_OPERATOR_OVER = define(2)
    val CAIRO_OPERATOR_IN = define(3)
    val CAIRO_OPERATOR_OUT = define(4)
    val CAIRO_OPERATOR_ATOP = define(5)
    val CAIRO_OPERATOR_DEST = define(6)
    val CAIRO_OPERATOR_DEST_OVER = define(7)
    val CAIRO_OPERATOR_DEST_IN = define(8)
    val CAIRO_OPERATOR_DEST_OUT = define(9)
    val CAIRO_OPERATOR_DEST_ATOP = define(10)
    val CAIRO_OPERATOR_XOR = define(11)
    val CAIRO_OPERATOR_ADD = define(12)
    val CAIRO_OPERATOR_SATURATE = define(13)
    val CAIRO_OPERATOR_MULTIPLY = define(14)
    val CAIRO_OPERATOR_SCREEN = define(15)
    val CAIRO_OPERATOR_OVERLAY = define(16)
    val CAIRO_OPERATOR_DARKEN = define(17)
    val CAIRO_OPERATOR_LIGHTEN = define(18)
    val CAIRO_OPERATOR_COLOR_DODGE = define(19)
    val CAIRO_OPERATOR_COLOR_BURN = define(20)
    val CAIRO_OPERATOR_HARD_LIGHT = define(21)
    val CAIRO_OPERATOR_SOFT_LIGHT = define(22)
    val CAIRO_OPERATOR_DIFFERENCE = define(23)
    val CAIRO_OPERATOR_EXCLUSION = define(24)
    val CAIRO_OPERATOR_HSL_HUE = define(25)
    val CAIRO_OPERATOR_HSL_SATURATION = define(26)
    val CAIRO_OPERATOR_HSL_COLOR = define(27)
    val CAIRO_OPERATOR_HSL_LUMINOSITY = define(28)
    inline def getName(inline value: _cairo_operator): Option[String] =
      inline value match
        case CAIRO_OPERATOR_CLEAR => Some("CAIRO_OPERATOR_CLEAR")
        case CAIRO_OPERATOR_SOURCE => Some("CAIRO_OPERATOR_SOURCE")
        case CAIRO_OPERATOR_OVER => Some("CAIRO_OPERATOR_OVER")
        case CAIRO_OPERATOR_IN => Some("CAIRO_OPERATOR_IN")
        case CAIRO_OPERATOR_OUT => Some("CAIRO_OPERATOR_OUT")
        case CAIRO_OPERATOR_ATOP => Some("CAIRO_OPERATOR_ATOP")
        case CAIRO_OPERATOR_DEST => Some("CAIRO_OPERATOR_DEST")
        case CAIRO_OPERATOR_DEST_OVER => Some("CAIRO_OPERATOR_DEST_OVER")
        case CAIRO_OPERATOR_DEST_IN => Some("CAIRO_OPERATOR_DEST_IN")
        case CAIRO_OPERATOR_DEST_OUT => Some("CAIRO_OPERATOR_DEST_OUT")
        case CAIRO_OPERATOR_DEST_ATOP => Some("CAIRO_OPERATOR_DEST_ATOP")
        case CAIRO_OPERATOR_XOR => Some("CAIRO_OPERATOR_XOR")
        case CAIRO_OPERATOR_ADD => Some("CAIRO_OPERATOR_ADD")
        case CAIRO_OPERATOR_SATURATE => Some("CAIRO_OPERATOR_SATURATE")
        case CAIRO_OPERATOR_MULTIPLY => Some("CAIRO_OPERATOR_MULTIPLY")
        case CAIRO_OPERATOR_SCREEN => Some("CAIRO_OPERATOR_SCREEN")
        case CAIRO_OPERATOR_OVERLAY => Some("CAIRO_OPERATOR_OVERLAY")
        case CAIRO_OPERATOR_DARKEN => Some("CAIRO_OPERATOR_DARKEN")
        case CAIRO_OPERATOR_LIGHTEN => Some("CAIRO_OPERATOR_LIGHTEN")
        case CAIRO_OPERATOR_COLOR_DODGE => Some("CAIRO_OPERATOR_COLOR_DODGE")
        case CAIRO_OPERATOR_COLOR_BURN => Some("CAIRO_OPERATOR_COLOR_BURN")
        case CAIRO_OPERATOR_HARD_LIGHT => Some("CAIRO_OPERATOR_HARD_LIGHT")
        case CAIRO_OPERATOR_SOFT_LIGHT => Some("CAIRO_OPERATOR_SOFT_LIGHT")
        case CAIRO_OPERATOR_DIFFERENCE => Some("CAIRO_OPERATOR_DIFFERENCE")
        case CAIRO_OPERATOR_EXCLUSION => Some("CAIRO_OPERATOR_EXCLUSION")
        case CAIRO_OPERATOR_HSL_HUE => Some("CAIRO_OPERATOR_HSL_HUE")
        case CAIRO_OPERATOR_HSL_SATURATION => Some("CAIRO_OPERATOR_HSL_SATURATION")
        case CAIRO_OPERATOR_HSL_COLOR => Some("CAIRO_OPERATOR_HSL_COLOR")
        case CAIRO_OPERATOR_HSL_LUMINOSITY => Some("CAIRO_OPERATOR_HSL_LUMINOSITY")
        case _ => _root_.scala.None
    extension (a: _cairo_operator)
      inline def &(b: _cairo_operator): _cairo_operator = a & b
      inline def |(b: _cairo_operator): _cairo_operator = a | b
      inline def is(b: _cairo_operator): Boolean = (a & b) == b

  /**
   * cairo_path_data_type_t: _PATH_MOVE_TO: A move-to operation, since 1.0 _PATH_LINE_TO: A line-to operation, since 1.0 _PATH_CURVE_TO: A curve-to operation, since 1.0 _PATH_CLOSE_PATH: A close-path operation, since 1.0
  */
  opaque type _cairo_path_data_type = CUnsignedInt
  object _cairo_path_data_type extends CEnumU[_cairo_path_data_type]:
    given _tag: Tag[_cairo_path_data_type] = Tag.UInt
    inline def define(inline a: Long): _cairo_path_data_type = a.toUInt
    val CAIRO_PATH_MOVE_TO = define(0)
    val CAIRO_PATH_LINE_TO = define(1)
    val CAIRO_PATH_CURVE_TO = define(2)
    val CAIRO_PATH_CLOSE_PATH = define(3)
    inline def getName(inline value: _cairo_path_data_type): Option[String] =
      inline value match
        case CAIRO_PATH_MOVE_TO => Some("CAIRO_PATH_MOVE_TO")
        case CAIRO_PATH_LINE_TO => Some("CAIRO_PATH_LINE_TO")
        case CAIRO_PATH_CURVE_TO => Some("CAIRO_PATH_CURVE_TO")
        case CAIRO_PATH_CLOSE_PATH => Some("CAIRO_PATH_CLOSE_PATH")
        case _ => _root_.scala.None
    extension (a: _cairo_path_data_type)
      inline def &(b: _cairo_path_data_type): _cairo_path_data_type = a & b
      inline def |(b: _cairo_path_data_type): _cairo_path_data_type = a | b
      inline def is(b: _cairo_path_data_type): Boolean = (a & b) == b

  /**
   * cairo_pattern_type_t: _PATTERN_TYPE_SOLID: The pattern is a solid (uniform) color. It may be opaque or translucent, since 1.2. _PATTERN_TYPE_SURFACE: The pattern is a based on a surface (an image), since 1.2. _PATTERN_TYPE_LINEAR: The pattern is a linear gradient, since 1.2. _PATTERN_TYPE_RADIAL: The pattern is a radial gradient, since 1.2. _PATTERN_TYPE_MESH: The pattern is a mesh, since 1.12. _PATTERN_TYPE_RASTER_SOURCE: The pattern is a user pattern providing raster data, since 1.12.
  */
  opaque type _cairo_pattern_type = CUnsignedInt
  object _cairo_pattern_type extends CEnumU[_cairo_pattern_type]:
    given _tag: Tag[_cairo_pattern_type] = Tag.UInt
    inline def define(inline a: Long): _cairo_pattern_type = a.toUInt
    val CAIRO_PATTERN_TYPE_SOLID = define(0)
    val CAIRO_PATTERN_TYPE_SURFACE = define(1)
    val CAIRO_PATTERN_TYPE_LINEAR = define(2)
    val CAIRO_PATTERN_TYPE_RADIAL = define(3)
    val CAIRO_PATTERN_TYPE_MESH = define(4)
    val CAIRO_PATTERN_TYPE_RASTER_SOURCE = define(5)
    inline def getName(inline value: _cairo_pattern_type): Option[String] =
      inline value match
        case CAIRO_PATTERN_TYPE_SOLID => Some("CAIRO_PATTERN_TYPE_SOLID")
        case CAIRO_PATTERN_TYPE_SURFACE => Some("CAIRO_PATTERN_TYPE_SURFACE")
        case CAIRO_PATTERN_TYPE_LINEAR => Some("CAIRO_PATTERN_TYPE_LINEAR")
        case CAIRO_PATTERN_TYPE_RADIAL => Some("CAIRO_PATTERN_TYPE_RADIAL")
        case CAIRO_PATTERN_TYPE_MESH => Some("CAIRO_PATTERN_TYPE_MESH")
        case CAIRO_PATTERN_TYPE_RASTER_SOURCE => Some("CAIRO_PATTERN_TYPE_RASTER_SOURCE")
        case _ => _root_.scala.None
    extension (a: _cairo_pattern_type)
      inline def &(b: _cairo_pattern_type): _cairo_pattern_type = a & b
      inline def |(b: _cairo_pattern_type): _cairo_pattern_type = a | b
      inline def is(b: _cairo_pattern_type): Boolean = (a & b) == b

  /**
   * cairo_region_overlap_t: _REGION_OVERLAP_IN: The contents are entirely inside the region. (Since 1.10) _REGION_OVERLAP_OUT: The contents are entirely outside the region. (Since 1.10) _REGION_OVERLAP_PART: The contents are partially inside and partially outside the region. (Since 1.10)
  */
  opaque type _cairo_region_overlap = CUnsignedInt
  object _cairo_region_overlap extends CEnumU[_cairo_region_overlap]:
    given _tag: Tag[_cairo_region_overlap] = Tag.UInt
    inline def define(inline a: Long): _cairo_region_overlap = a.toUInt
    val CAIRO_REGION_OVERLAP_IN = define(0)
    val CAIRO_REGION_OVERLAP_OUT = define(1)
    val CAIRO_REGION_OVERLAP_PART = define(2)
    inline def getName(inline value: _cairo_region_overlap): Option[String] =
      inline value match
        case CAIRO_REGION_OVERLAP_IN => Some("CAIRO_REGION_OVERLAP_IN")
        case CAIRO_REGION_OVERLAP_OUT => Some("CAIRO_REGION_OVERLAP_OUT")
        case CAIRO_REGION_OVERLAP_PART => Some("CAIRO_REGION_OVERLAP_PART")
        case _ => _root_.scala.None
    extension (a: _cairo_region_overlap)
      inline def &(b: _cairo_region_overlap): _cairo_region_overlap = a & b
      inline def |(b: _cairo_region_overlap): _cairo_region_overlap = a | b
      inline def is(b: _cairo_region_overlap): Boolean = (a & b) == b

  /**
   * cairo_status_t: _STATUS_SUCCESS: no error has occurred (Since 1.0) _STATUS_NO_MEMORY: out of memory (Since 1.0) _STATUS_INVALID_RESTORE: cairo_restore() called without matching cairo_save() (Since 1.0) _STATUS_INVALID_POP_GROUP: no saved group to pop, i.e. cairo_pop_group() without matching cairo_push_group() (Since 1.0) _STATUS_NO_CURRENT_POINT: no current point defined (Since 1.0) _STATUS_INVALID_MATRIX: invalid matrix (not invertible) (Since 1.0) _STATUS_INVALID_STATUS: invalid value for an input #cairo_status_t (Since 1.0) _STATUS_NULL_POINTER: %NULL pointer (Since 1.0) _STATUS_INVALID_STRING: input string not valid UTF-8 (Since 1.0) _STATUS_INVALID_PATH_DATA: input path data not valid (Since 1.0) _STATUS_READ_ERROR: error while reading from input stream (Since 1.0) _STATUS_WRITE_ERROR: error while writing to output stream (Since 1.0) _STATUS_SURFACE_FINISHED: target surface has been finished (Since 1.0) _STATUS_SURFACE_TYPE_MISMATCH: the surface type is not appropriate for the operation (Since 1.0) _STATUS_PATTERN_TYPE_MISMATCH: the pattern type is not appropriate for the operation (Since 1.0) _STATUS_INVALID_CONTENT: invalid value for an input #cairo_content_t (Since 1.0) _STATUS_INVALID_FORMAT: invalid value for an input #cairo_format_t (Since 1.0) _STATUS_INVALID_VISUAL: invalid value for an input Visual* (Since 1.0) _STATUS_FILE_NOT_FOUND: file not found (Since 1.0) _STATUS_INVALID_DASH: invalid value for a dash setting (Since 1.0) _STATUS_INVALID_DSC_COMMENT: invalid value for a DSC comment (Since 1.2) _STATUS_INVALID_INDEX: invalid index passed to getter (Since 1.4) _STATUS_CLIP_NOT_REPRESENTABLE: clip region not representable in desired format (Since 1.4) _STATUS_TEMP_FILE_ERROR: error creating or writing to a temporary file (Since 1.6) _STATUS_INVALID_STRIDE: invalid value for stride (Since 1.6) _STATUS_FONT_TYPE_MISMATCH: the font type is not appropriate for the operation (Since 1.8) _STATUS_USER_FONT_IMMUTABLE: the user-font is immutable (Since 1.8) _STATUS_USER_FONT_ERROR: error occurred in a user-font callback function (Since 1.8) _STATUS_NEGATIVE_COUNT: negative number used where it is not allowed (Since 1.8) _STATUS_INVALID_CLUSTERS: input clusters do not represent the accompanying text and glyph array (Since 1.8) _STATUS_INVALID_SLANT: invalid value for an input #cairo_font_slant_t (Since 1.8) _STATUS_INVALID_WEIGHT: invalid value for an input #cairo_font_weight_t (Since 1.8) _STATUS_INVALID_SIZE: invalid value (typically too big) for the size of the input (surface, pattern, etc.) (Since 1.10) _STATUS_USER_FONT_NOT_IMPLEMENTED: user-font method not implemented (Since 1.10) _STATUS_DEVICE_TYPE_MISMATCH: the device type is not appropriate for the operation (Since 1.10) _STATUS_DEVICE_ERROR: an operation to the device caused an unspecified error (Since 1.10) _STATUS_INVALID_MESH_CONSTRUCTION: a mesh pattern construction operation was used outside of a cairo_mesh_pattern_begin_patch()/cairo_mesh_pattern_end_patch() pair (Since 1.12) _STATUS_DEVICE_FINISHED: target device has been finished (Since 1.12) _STATUS_JBIG2_GLOBAL_MISSING: %CAIRO_MIME_TYPE_JBIG2_GLOBAL_ID has been used on at least one image but no image provided %CAIRO_MIME_TYPE_JBIG2_GLOBAL (Since 1.14) _STATUS_PNG_ERROR: error occurred in libpng while reading from or writing to a PNG file (Since 1.16) _STATUS_FREETYPE_ERROR: error occurred in libfreetype (Since 1.16) _STATUS_WIN32_GDI_ERROR: error occurred in the Windows Graphics Device Interface (Since 1.16) _STATUS_TAG_ERROR: invalid tag name, attributes, or nesting (Since 1.16) _STATUS_DWRITE_ERROR: error occurred in the Windows Direct Write API (Since 1.18) _STATUS_SVG_FONT_ERROR: error occurred in OpenType-SVG font rendering (Since 1.18) _STATUS_LAST_STATUS: this is a special value indicating the number of status values defined in this enumeration. When using this value, note that the version of cairo at run-time may have additional status values defined than the value of this symbol at compile-time. (Since 1.10)
  */
  opaque type _cairo_status = CUnsignedInt
  object _cairo_status extends CEnumU[_cairo_status]:
    given _tag: Tag[_cairo_status] = Tag.UInt
    inline def define(inline a: Long): _cairo_status = a.toUInt
    val CAIRO_STATUS_SUCCESS = define(0)
    val CAIRO_STATUS_NO_MEMORY = define(1)
    val CAIRO_STATUS_INVALID_RESTORE = define(2)
    val CAIRO_STATUS_INVALID_POP_GROUP = define(3)
    val CAIRO_STATUS_NO_CURRENT_POINT = define(4)
    val CAIRO_STATUS_INVALID_MATRIX = define(5)
    val CAIRO_STATUS_INVALID_STATUS = define(6)
    val CAIRO_STATUS_NULL_POINTER = define(7)
    val CAIRO_STATUS_INVALID_STRING = define(8)
    val CAIRO_STATUS_INVALID_PATH_DATA = define(9)
    val CAIRO_STATUS_READ_ERROR = define(10)
    val CAIRO_STATUS_WRITE_ERROR = define(11)
    val CAIRO_STATUS_SURFACE_FINISHED = define(12)
    val CAIRO_STATUS_SURFACE_TYPE_MISMATCH = define(13)
    val CAIRO_STATUS_PATTERN_TYPE_MISMATCH = define(14)
    val CAIRO_STATUS_INVALID_CONTENT = define(15)
    val CAIRO_STATUS_INVALID_FORMAT = define(16)
    val CAIRO_STATUS_INVALID_VISUAL = define(17)
    val CAIRO_STATUS_FILE_NOT_FOUND = define(18)
    val CAIRO_STATUS_INVALID_DASH = define(19)
    val CAIRO_STATUS_INVALID_DSC_COMMENT = define(20)
    val CAIRO_STATUS_INVALID_INDEX = define(21)
    val CAIRO_STATUS_CLIP_NOT_REPRESENTABLE = define(22)
    val CAIRO_STATUS_TEMP_FILE_ERROR = define(23)
    val CAIRO_STATUS_INVALID_STRIDE = define(24)
    val CAIRO_STATUS_FONT_TYPE_MISMATCH = define(25)
    val CAIRO_STATUS_USER_FONT_IMMUTABLE = define(26)
    val CAIRO_STATUS_USER_FONT_ERROR = define(27)
    val CAIRO_STATUS_NEGATIVE_COUNT = define(28)
    val CAIRO_STATUS_INVALID_CLUSTERS = define(29)
    val CAIRO_STATUS_INVALID_SLANT = define(30)
    val CAIRO_STATUS_INVALID_WEIGHT = define(31)
    val CAIRO_STATUS_INVALID_SIZE = define(32)
    val CAIRO_STATUS_USER_FONT_NOT_IMPLEMENTED = define(33)
    val CAIRO_STATUS_DEVICE_TYPE_MISMATCH = define(34)
    val CAIRO_STATUS_DEVICE_ERROR = define(35)
    val CAIRO_STATUS_INVALID_MESH_CONSTRUCTION = define(36)
    val CAIRO_STATUS_DEVICE_FINISHED = define(37)
    val CAIRO_STATUS_JBIG2_GLOBAL_MISSING = define(38)
    val CAIRO_STATUS_PNG_ERROR = define(39)
    val CAIRO_STATUS_FREETYPE_ERROR = define(40)
    val CAIRO_STATUS_WIN32_GDI_ERROR = define(41)
    val CAIRO_STATUS_TAG_ERROR = define(42)
    val CAIRO_STATUS_DWRITE_ERROR = define(43)
    val CAIRO_STATUS_SVG_FONT_ERROR = define(44)
    val CAIRO_STATUS_LAST_STATUS = define(45)
    inline def getName(inline value: _cairo_status): Option[String] =
      inline value match
        case CAIRO_STATUS_SUCCESS => Some("CAIRO_STATUS_SUCCESS")
        case CAIRO_STATUS_NO_MEMORY => Some("CAIRO_STATUS_NO_MEMORY")
        case CAIRO_STATUS_INVALID_RESTORE => Some("CAIRO_STATUS_INVALID_RESTORE")
        case CAIRO_STATUS_INVALID_POP_GROUP => Some("CAIRO_STATUS_INVALID_POP_GROUP")
        case CAIRO_STATUS_NO_CURRENT_POINT => Some("CAIRO_STATUS_NO_CURRENT_POINT")
        case CAIRO_STATUS_INVALID_MATRIX => Some("CAIRO_STATUS_INVALID_MATRIX")
        case CAIRO_STATUS_INVALID_STATUS => Some("CAIRO_STATUS_INVALID_STATUS")
        case CAIRO_STATUS_NULL_POINTER => Some("CAIRO_STATUS_NULL_POINTER")
        case CAIRO_STATUS_INVALID_STRING => Some("CAIRO_STATUS_INVALID_STRING")
        case CAIRO_STATUS_INVALID_PATH_DATA => Some("CAIRO_STATUS_INVALID_PATH_DATA")
        case CAIRO_STATUS_READ_ERROR => Some("CAIRO_STATUS_READ_ERROR")
        case CAIRO_STATUS_WRITE_ERROR => Some("CAIRO_STATUS_WRITE_ERROR")
        case CAIRO_STATUS_SURFACE_FINISHED => Some("CAIRO_STATUS_SURFACE_FINISHED")
        case CAIRO_STATUS_SURFACE_TYPE_MISMATCH => Some("CAIRO_STATUS_SURFACE_TYPE_MISMATCH")
        case CAIRO_STATUS_PATTERN_TYPE_MISMATCH => Some("CAIRO_STATUS_PATTERN_TYPE_MISMATCH")
        case CAIRO_STATUS_INVALID_CONTENT => Some("CAIRO_STATUS_INVALID_CONTENT")
        case CAIRO_STATUS_INVALID_FORMAT => Some("CAIRO_STATUS_INVALID_FORMAT")
        case CAIRO_STATUS_INVALID_VISUAL => Some("CAIRO_STATUS_INVALID_VISUAL")
        case CAIRO_STATUS_FILE_NOT_FOUND => Some("CAIRO_STATUS_FILE_NOT_FOUND")
        case CAIRO_STATUS_INVALID_DASH => Some("CAIRO_STATUS_INVALID_DASH")
        case CAIRO_STATUS_INVALID_DSC_COMMENT => Some("CAIRO_STATUS_INVALID_DSC_COMMENT")
        case CAIRO_STATUS_INVALID_INDEX => Some("CAIRO_STATUS_INVALID_INDEX")
        case CAIRO_STATUS_CLIP_NOT_REPRESENTABLE => Some("CAIRO_STATUS_CLIP_NOT_REPRESENTABLE")
        case CAIRO_STATUS_TEMP_FILE_ERROR => Some("CAIRO_STATUS_TEMP_FILE_ERROR")
        case CAIRO_STATUS_INVALID_STRIDE => Some("CAIRO_STATUS_INVALID_STRIDE")
        case CAIRO_STATUS_FONT_TYPE_MISMATCH => Some("CAIRO_STATUS_FONT_TYPE_MISMATCH")
        case CAIRO_STATUS_USER_FONT_IMMUTABLE => Some("CAIRO_STATUS_USER_FONT_IMMUTABLE")
        case CAIRO_STATUS_USER_FONT_ERROR => Some("CAIRO_STATUS_USER_FONT_ERROR")
        case CAIRO_STATUS_NEGATIVE_COUNT => Some("CAIRO_STATUS_NEGATIVE_COUNT")
        case CAIRO_STATUS_INVALID_CLUSTERS => Some("CAIRO_STATUS_INVALID_CLUSTERS")
        case CAIRO_STATUS_INVALID_SLANT => Some("CAIRO_STATUS_INVALID_SLANT")
        case CAIRO_STATUS_INVALID_WEIGHT => Some("CAIRO_STATUS_INVALID_WEIGHT")
        case CAIRO_STATUS_INVALID_SIZE => Some("CAIRO_STATUS_INVALID_SIZE")
        case CAIRO_STATUS_USER_FONT_NOT_IMPLEMENTED => Some("CAIRO_STATUS_USER_FONT_NOT_IMPLEMENTED")
        case CAIRO_STATUS_DEVICE_TYPE_MISMATCH => Some("CAIRO_STATUS_DEVICE_TYPE_MISMATCH")
        case CAIRO_STATUS_DEVICE_ERROR => Some("CAIRO_STATUS_DEVICE_ERROR")
        case CAIRO_STATUS_INVALID_MESH_CONSTRUCTION => Some("CAIRO_STATUS_INVALID_MESH_CONSTRUCTION")
        case CAIRO_STATUS_DEVICE_FINISHED => Some("CAIRO_STATUS_DEVICE_FINISHED")
        case CAIRO_STATUS_JBIG2_GLOBAL_MISSING => Some("CAIRO_STATUS_JBIG2_GLOBAL_MISSING")
        case CAIRO_STATUS_PNG_ERROR => Some("CAIRO_STATUS_PNG_ERROR")
        case CAIRO_STATUS_FREETYPE_ERROR => Some("CAIRO_STATUS_FREETYPE_ERROR")
        case CAIRO_STATUS_WIN32_GDI_ERROR => Some("CAIRO_STATUS_WIN32_GDI_ERROR")
        case CAIRO_STATUS_TAG_ERROR => Some("CAIRO_STATUS_TAG_ERROR")
        case CAIRO_STATUS_DWRITE_ERROR => Some("CAIRO_STATUS_DWRITE_ERROR")
        case CAIRO_STATUS_SVG_FONT_ERROR => Some("CAIRO_STATUS_SVG_FONT_ERROR")
        case CAIRO_STATUS_LAST_STATUS => Some("CAIRO_STATUS_LAST_STATUS")
        case _ => _root_.scala.None
    extension (a: _cairo_status)
      inline def &(b: _cairo_status): _cairo_status = a & b
      inline def |(b: _cairo_status): _cairo_status = a | b
      inline def is(b: _cairo_status): Boolean = (a & b) == b

  /**
   * cairo_subpixel_order_t: _SUBPIXEL_ORDER_DEFAULT: Use the default subpixel order for for the target device, since 1.0 _SUBPIXEL_ORDER_RGB: Subpixel elements are arranged horizontally with red at the left, since 1.0 _SUBPIXEL_ORDER_BGR: Subpixel elements are arranged horizontally with blue at the left, since 1.0 _SUBPIXEL_ORDER_VRGB: Subpixel elements are arranged vertically with red at the top, since 1.0 _SUBPIXEL_ORDER_VBGR: Subpixel elements are arranged vertically with blue at the top, since 1.0
  */
  opaque type _cairo_subpixel_order = CUnsignedInt
  object _cairo_subpixel_order extends CEnumU[_cairo_subpixel_order]:
    given _tag: Tag[_cairo_subpixel_order] = Tag.UInt
    inline def define(inline a: Long): _cairo_subpixel_order = a.toUInt
    val CAIRO_SUBPIXEL_ORDER_DEFAULT = define(0)
    val CAIRO_SUBPIXEL_ORDER_RGB = define(1)
    val CAIRO_SUBPIXEL_ORDER_BGR = define(2)
    val CAIRO_SUBPIXEL_ORDER_VRGB = define(3)
    val CAIRO_SUBPIXEL_ORDER_VBGR = define(4)
    inline def getName(inline value: _cairo_subpixel_order): Option[String] =
      inline value match
        case CAIRO_SUBPIXEL_ORDER_DEFAULT => Some("CAIRO_SUBPIXEL_ORDER_DEFAULT")
        case CAIRO_SUBPIXEL_ORDER_RGB => Some("CAIRO_SUBPIXEL_ORDER_RGB")
        case CAIRO_SUBPIXEL_ORDER_BGR => Some("CAIRO_SUBPIXEL_ORDER_BGR")
        case CAIRO_SUBPIXEL_ORDER_VRGB => Some("CAIRO_SUBPIXEL_ORDER_VRGB")
        case CAIRO_SUBPIXEL_ORDER_VBGR => Some("CAIRO_SUBPIXEL_ORDER_VBGR")
        case _ => _root_.scala.None
    extension (a: _cairo_subpixel_order)
      inline def &(b: _cairo_subpixel_order): _cairo_subpixel_order = a & b
      inline def |(b: _cairo_subpixel_order): _cairo_subpixel_order = a | b
      inline def is(b: _cairo_subpixel_order): Boolean = (a & b) == b

  /**
   * cairo_surface_type_t: _SURFACE_TYPE_IMAGE: The surface is of type image, since 1.2 _SURFACE_TYPE_PDF: The surface is of type pdf, since 1.2 _SURFACE_TYPE_PS: The surface is of type ps, since 1.2 _SURFACE_TYPE_XLIB: The surface is of type xlib, since 1.2 _SURFACE_TYPE_XCB: The surface is of type xcb, since 1.2 _SURFACE_TYPE_GLITZ: The surface is of type glitz, since 1.2, deprecated 1.18 (glitz support have been removed, this surface type will never be set by cairo) _SURFACE_TYPE_QUARTZ: The surface is of type quartz, since 1.2 _SURFACE_TYPE_WIN32: The surface is of type win32, since 1.2 _SURFACE_TYPE_BEOS: The surface is of type beos, since 1.2, deprecated 1.18 (beos support have been removed, this surface type will never be set by cairo) _SURFACE_TYPE_DIRECTFB: The surface is of type directfb, since 1.2, deprecated 1.18 (directfb support have been removed, this surface type will never be set by cairo) _SURFACE_TYPE_SVG: The surface is of type svg, since 1.2 _SURFACE_TYPE_OS2: The surface is of type os2, since 1.4, deprecated 1.18 (os2 support have been removed, this surface type will never be set by cairo) _SURFACE_TYPE_WIN32_PRINTING: The surface is a win32 printing surface, since 1.6 _SURFACE_TYPE_QUARTZ_IMAGE: The surface is of type quartz_image, since 1.6 _SURFACE_TYPE_SCRIPT: The surface is of type script, since 1.10 _SURFACE_TYPE_QT: The surface is of type Qt, since 1.10, deprecated 1.18 (Ot support have been removed, this surface type will never be set by cairo) _SURFACE_TYPE_RECORDING: The surface is of type recording, since 1.10 _SURFACE_TYPE_VG: The surface is a OpenVG surface, since 1.10, deprecated 1.18 (OpenVG support have been removed, this surface type will never be set by cairo) _SURFACE_TYPE_GL: The surface is of type OpenGL, since 1.10, deprecated 1.18 (OpenGL support have been removed, this surface type will never be set by cairo) _SURFACE_TYPE_DRM: The surface is of type Direct Render Manager, since 1.10, deprecated 1.18 (DRM support have been removed, this surface type will never be set by cairo) _SURFACE_TYPE_TEE: The surface is of type 'tee' (a multiplexing surface), since 1.10 _SURFACE_TYPE_XML: The surface is of type XML (for debugging), since 1.10 _SURFACE_TYPE_SKIA: The surface is of type Skia, since 1.10, deprecated 1.18 (Skia support have been removed, this surface type will never be set by cairo) _SURFACE_TYPE_SUBSURFACE: The surface is a subsurface created with cairo_surface_create_for_rectangle(), since 1.10 _SURFACE_TYPE_COGL: This surface is of type Cogl, since 1.12, deprecated 1.18 (Cogl support have been removed, this surface type will never be set by cairo)
  */
  opaque type _cairo_surface_type = CUnsignedInt
  object _cairo_surface_type extends CEnumU[_cairo_surface_type]:
    given _tag: Tag[_cairo_surface_type] = Tag.UInt
    inline def define(inline a: Long): _cairo_surface_type = a.toUInt
    val CAIRO_SURFACE_TYPE_IMAGE = define(0)
    val CAIRO_SURFACE_TYPE_PDF = define(1)
    val CAIRO_SURFACE_TYPE_PS = define(2)
    val CAIRO_SURFACE_TYPE_XLIB = define(3)
    val CAIRO_SURFACE_TYPE_XCB = define(4)
    val CAIRO_SURFACE_TYPE_GLITZ = define(5)
    val CAIRO_SURFACE_TYPE_QUARTZ = define(6)
    val CAIRO_SURFACE_TYPE_WIN32 = define(7)
    val CAIRO_SURFACE_TYPE_BEOS = define(8)
    val CAIRO_SURFACE_TYPE_DIRECTFB = define(9)
    val CAIRO_SURFACE_TYPE_SVG = define(10)
    val CAIRO_SURFACE_TYPE_OS2 = define(11)
    val CAIRO_SURFACE_TYPE_WIN32_PRINTING = define(12)
    val CAIRO_SURFACE_TYPE_QUARTZ_IMAGE = define(13)
    val CAIRO_SURFACE_TYPE_SCRIPT = define(14)
    val CAIRO_SURFACE_TYPE_QT = define(15)
    val CAIRO_SURFACE_TYPE_RECORDING = define(16)
    val CAIRO_SURFACE_TYPE_VG = define(17)
    val CAIRO_SURFACE_TYPE_GL = define(18)
    val CAIRO_SURFACE_TYPE_DRM = define(19)
    val CAIRO_SURFACE_TYPE_TEE = define(20)
    val CAIRO_SURFACE_TYPE_XML = define(21)
    val CAIRO_SURFACE_TYPE_SKIA = define(22)
    val CAIRO_SURFACE_TYPE_SUBSURFACE = define(23)
    val CAIRO_SURFACE_TYPE_COGL = define(24)
    inline def getName(inline value: _cairo_surface_type): Option[String] =
      inline value match
        case CAIRO_SURFACE_TYPE_IMAGE => Some("CAIRO_SURFACE_TYPE_IMAGE")
        case CAIRO_SURFACE_TYPE_PDF => Some("CAIRO_SURFACE_TYPE_PDF")
        case CAIRO_SURFACE_TYPE_PS => Some("CAIRO_SURFACE_TYPE_PS")
        case CAIRO_SURFACE_TYPE_XLIB => Some("CAIRO_SURFACE_TYPE_XLIB")
        case CAIRO_SURFACE_TYPE_XCB => Some("CAIRO_SURFACE_TYPE_XCB")
        case CAIRO_SURFACE_TYPE_GLITZ => Some("CAIRO_SURFACE_TYPE_GLITZ")
        case CAIRO_SURFACE_TYPE_QUARTZ => Some("CAIRO_SURFACE_TYPE_QUARTZ")
        case CAIRO_SURFACE_TYPE_WIN32 => Some("CAIRO_SURFACE_TYPE_WIN32")
        case CAIRO_SURFACE_TYPE_BEOS => Some("CAIRO_SURFACE_TYPE_BEOS")
        case CAIRO_SURFACE_TYPE_DIRECTFB => Some("CAIRO_SURFACE_TYPE_DIRECTFB")
        case CAIRO_SURFACE_TYPE_SVG => Some("CAIRO_SURFACE_TYPE_SVG")
        case CAIRO_SURFACE_TYPE_OS2 => Some("CAIRO_SURFACE_TYPE_OS2")
        case CAIRO_SURFACE_TYPE_WIN32_PRINTING => Some("CAIRO_SURFACE_TYPE_WIN32_PRINTING")
        case CAIRO_SURFACE_TYPE_QUARTZ_IMAGE => Some("CAIRO_SURFACE_TYPE_QUARTZ_IMAGE")
        case CAIRO_SURFACE_TYPE_SCRIPT => Some("CAIRO_SURFACE_TYPE_SCRIPT")
        case CAIRO_SURFACE_TYPE_QT => Some("CAIRO_SURFACE_TYPE_QT")
        case CAIRO_SURFACE_TYPE_RECORDING => Some("CAIRO_SURFACE_TYPE_RECORDING")
        case CAIRO_SURFACE_TYPE_VG => Some("CAIRO_SURFACE_TYPE_VG")
        case CAIRO_SURFACE_TYPE_GL => Some("CAIRO_SURFACE_TYPE_GL")
        case CAIRO_SURFACE_TYPE_DRM => Some("CAIRO_SURFACE_TYPE_DRM")
        case CAIRO_SURFACE_TYPE_TEE => Some("CAIRO_SURFACE_TYPE_TEE")
        case CAIRO_SURFACE_TYPE_XML => Some("CAIRO_SURFACE_TYPE_XML")
        case CAIRO_SURFACE_TYPE_SKIA => Some("CAIRO_SURFACE_TYPE_SKIA")
        case CAIRO_SURFACE_TYPE_SUBSURFACE => Some("CAIRO_SURFACE_TYPE_SUBSURFACE")
        case CAIRO_SURFACE_TYPE_COGL => Some("CAIRO_SURFACE_TYPE_COGL")
        case _ => _root_.scala.None
    extension (a: _cairo_surface_type)
      inline def &(b: _cairo_surface_type): _cairo_surface_type = a & b
      inline def |(b: _cairo_surface_type): _cairo_surface_type = a | b
      inline def is(b: _cairo_surface_type): Boolean = (a & b) == b

  /**
   * cairo_text_cluster_flags_t: _TEXT_CLUSTER_FLAG_BACKWARD: The clusters in the cluster array map to glyphs in the glyph array from end to start. (Since 1.8)
  */
  opaque type _cairo_text_cluster_flags = CUnsignedInt
  object _cairo_text_cluster_flags extends CEnumU[_cairo_text_cluster_flags]:
    given _tag: Tag[_cairo_text_cluster_flags] = Tag.UInt
    inline def define(inline a: Long): _cairo_text_cluster_flags = a.toUInt
    val CAIRO_TEXT_CLUSTER_FLAG_BACKWARD = define(1)
    inline def getName(inline value: _cairo_text_cluster_flags): Option[String] =
      inline value match
        case CAIRO_TEXT_CLUSTER_FLAG_BACKWARD => Some("CAIRO_TEXT_CLUSTER_FLAG_BACKWARD")
        case _ => _root_.scala.None
    extension (a: _cairo_text_cluster_flags)
      inline def &(b: _cairo_text_cluster_flags): _cairo_text_cluster_flags = a & b
      inline def |(b: _cairo_text_cluster_flags): _cairo_text_cluster_flags = a | b
      inline def is(b: _cairo_text_cluster_flags): Boolean = (a & b) == b

  /**
   * cairo_ft_synthesize_t: _FT_SYNTHESIZE_BOLD: Embolden the glyphs (redraw with a pixel offset) _FT_SYNTHESIZE_OBLIQUE: Slant the glyph outline by 12 degrees to the right.
  */
  opaque type cairo_ft_synthesize_t = CUnsignedInt
  object cairo_ft_synthesize_t extends CEnumU[cairo_ft_synthesize_t]:
    given _tag: Tag[cairo_ft_synthesize_t] = Tag.UInt
    inline def define(inline a: Long): cairo_ft_synthesize_t = a.toUInt
    val CAIRO_FT_SYNTHESIZE_BOLD = define(1)
    val CAIRO_FT_SYNTHESIZE_OBLIQUE = define(2)
    inline def getName(inline value: cairo_ft_synthesize_t): Option[String] =
      inline value match
        case CAIRO_FT_SYNTHESIZE_BOLD => Some("CAIRO_FT_SYNTHESIZE_BOLD")
        case CAIRO_FT_SYNTHESIZE_OBLIQUE => Some("CAIRO_FT_SYNTHESIZE_OBLIQUE")
        case _ => _root_.scala.None
    extension (a: cairo_ft_synthesize_t)
      inline def &(b: cairo_ft_synthesize_t): cairo_ft_synthesize_t = a & b
      inline def |(b: cairo_ft_synthesize_t): cairo_ft_synthesize_t = a | b
      inline def is(b: cairo_ft_synthesize_t): Boolean = (a & b) == b

  /**
   * cairo_surface_observer_mode_t: _SURFACE_OBSERVER_NORMAL: no recording is done _SURFACE_OBSERVER_RECORD_OPERATIONS: operations are recorded
  */
  opaque type cairo_surface_observer_mode_t = CUnsignedInt
  object cairo_surface_observer_mode_t extends CEnumU[cairo_surface_observer_mode_t]:
    given _tag: Tag[cairo_surface_observer_mode_t] = Tag.UInt
    inline def define(inline a: Long): cairo_surface_observer_mode_t = a.toUInt
    val CAIRO_SURFACE_OBSERVER_NORMAL = define(0)
    val CAIRO_SURFACE_OBSERVER_RECORD_OPERATIONS = define(1)
    inline def getName(inline value: cairo_surface_observer_mode_t): Option[String] =
      inline value match
        case CAIRO_SURFACE_OBSERVER_NORMAL => Some("CAIRO_SURFACE_OBSERVER_NORMAL")
        case CAIRO_SURFACE_OBSERVER_RECORD_OPERATIONS => Some("CAIRO_SURFACE_OBSERVER_RECORD_OPERATIONS")
        case _ => _root_.scala.None
    extension (a: cairo_surface_observer_mode_t)
      inline def &(b: cairo_surface_observer_mode_t): cairo_surface_observer_mode_t = a & b
      inline def |(b: cairo_surface_observer_mode_t): cairo_surface_observer_mode_t = a | b
      inline def is(b: cairo_surface_observer_mode_t): Boolean = (a & b) == b

object aliases:
  import _root_.cairo.enumerations.*
  import _root_.cairo.predef.*
  import _root_.cairo.aliases.*
  import _root_.cairo.structs.*
  import _root_.cairo.unions.*
  /**
   * ************************************************************************
  */
  opaque type FT_Alloc_Func = CFuncPtr2[FT_Memory, CLongInt, Ptr[Byte]]
  object FT_Alloc_Func: 
    given _tag: Tag[FT_Alloc_Func] = Tag.materializeCFuncPtr2[FT_Memory, CLongInt, Ptr[Byte]]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): FT_Alloc_Func = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr2[FT_Memory, CLongInt, Ptr[Byte]]): FT_Alloc_Func = o
    extension (v: FT_Alloc_Func)
      inline def value: CFuncPtr2[FT_Memory, CLongInt, Ptr[Byte]] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * ************************************************************************
  */
  opaque type FT_Bool = CUnsignedChar
  object FT_Bool: 
    given _tag: Tag[FT_Bool] = Tag.UByte
    inline def apply(inline o: CUnsignedChar): FT_Bool = o
    extension (v: FT_Bool)
      inline def value: CUnsignedChar = v

  /**
   * ************************************************************************
  */
  opaque type FT_Byte = CUnsignedChar
  object FT_Byte: 
    given _tag: Tag[FT_Byte] = Tag.UByte
    inline def apply(inline o: CUnsignedChar): FT_Byte = o
    extension (v: FT_Byte)
      inline def value: CUnsignedChar = v

  /**
   * ************************************************************************
  */
  opaque type FT_Bytes = Ptr[FT_Byte]
  object FT_Bytes: 
    given _tag: Tag[FT_Bytes] = Tag.Ptr[FT_Byte](FT_Byte._tag)
    inline def apply(inline o: Ptr[FT_Byte]): FT_Bytes = o
    extension (v: FT_Bytes)
      inline def value: Ptr[FT_Byte] = v

  /**
   * ************************************************************************
  */
  opaque type FT_Char = CChar
  object FT_Char: 
    given _tag: Tag[FT_Char] = Tag.Byte
    inline def apply(inline o: CChar): FT_Char = o
    extension (v: FT_Char)
      inline def value: CChar = v

  /**
   * ************************************************************************
  */
  opaque type FT_CharMap = Ptr[FT_CharMapRec_]
  object FT_CharMap: 
    given _tag: Tag[FT_CharMap] = Tag.Ptr[FT_CharMapRec_](FT_CharMapRec_._tag)
    inline def apply(inline o: Ptr[FT_CharMapRec_]): FT_CharMap = o
    extension (v: FT_CharMap)
      inline def value: Ptr[FT_CharMapRec_] = v

  /**
   * ************************************************************************
  */
  opaque type FT_Driver = Ptr[FT_DriverRec_]
  object FT_Driver: 
    given _tag: Tag[FT_Driver] = Tag.Ptr[FT_DriverRec_](FT_DriverRec_._tag)
    inline def apply(inline o: Ptr[FT_DriverRec_]): FT_Driver = o
    extension (v: FT_Driver)
      inline def value: Ptr[FT_DriverRec_] = v

  /**
   * ************************************************************************
  */
  type FT_Encoding = FT_Encoding_
  object FT_Encoding: 
    given _tag: Tag[FT_Encoding] = FT_Encoding_._tag
    inline def apply(inline o: FT_Encoding_): FT_Encoding = o
    extension (v: FT_Encoding)
      inline def value: FT_Encoding_ = v

  /**
   * ************************************************************************
  */
  opaque type FT_Error = CInt
  object FT_Error: 
    given _tag: Tag[FT_Error] = Tag.Int
    inline def apply(inline o: CInt): FT_Error = o
    extension (v: FT_Error)
      inline def value: CInt = v

  /**
   * ************************************************************************
  */
  opaque type FT_F26Dot6 = CLongInt
  object FT_F26Dot6: 
    given _tag: Tag[FT_F26Dot6] = Tag.Size
    inline def apply(inline o: CLongInt): FT_F26Dot6 = o
    extension (v: FT_F26Dot6)
      inline def value: CLongInt = v

  /**
   * ************************************************************************
  */
  opaque type FT_F2Dot14 = CShort
  object FT_F2Dot14: 
    given _tag: Tag[FT_F2Dot14] = Tag.Short
    inline def apply(inline o: CShort): FT_F2Dot14 = o
    extension (v: FT_F2Dot14)
      inline def value: CShort = v

  /**
   * ************************************************************************
  */
  opaque type FT_FWord = CShort
  object FT_FWord: 
    given _tag: Tag[FT_FWord] = Tag.Short
    inline def apply(inline o: CShort): FT_FWord = o
    extension (v: FT_FWord)
      inline def value: CShort = v

  /**
   * ************************************************************************
  */
  opaque type FT_Face = Ptr[FT_FaceRec_]
  object FT_Face: 
    given _tag: Tag[FT_Face] = Tag.Ptr[FT_FaceRec_](FT_FaceRec_._tag)
    inline def apply(inline o: Ptr[FT_FaceRec_]): FT_Face = o
    extension (v: FT_Face)
      inline def value: Ptr[FT_FaceRec_] = v

  /**
   * ************************************************************************
  */
  opaque type FT_Face_Internal = Ptr[FT_Face_InternalRec_]
  object FT_Face_Internal: 
    given _tag: Tag[FT_Face_Internal] = Tag.Ptr[FT_Face_InternalRec_](FT_Face_InternalRec_._tag)
    inline def apply(inline o: Ptr[FT_Face_InternalRec_]): FT_Face_Internal = o
    extension (v: FT_Face_Internal)
      inline def value: Ptr[FT_Face_InternalRec_] = v

  opaque type FT_Fast = CInt
  object FT_Fast: 
    given _tag: Tag[FT_Fast] = Tag.Int
    inline def apply(inline o: CInt): FT_Fast = o
    extension (v: FT_Fast)
      inline def value: CInt = v

  /**
   * ************************************************************************
  */
  opaque type FT_Fixed = CLongInt
  object FT_Fixed: 
    given _tag: Tag[FT_Fixed] = Tag.Size
    inline def apply(inline o: CLongInt): FT_Fixed = o
    extension (v: FT_Fixed)
      inline def value: CLongInt = v

  /**
   * ************************************************************************
  */
  opaque type FT_Free_Func = CFuncPtr2[FT_Memory, Ptr[Byte], Unit]
  object FT_Free_Func: 
    given _tag: Tag[FT_Free_Func] = Tag.materializeCFuncPtr2[FT_Memory, Ptr[Byte], Unit]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): FT_Free_Func = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr2[FT_Memory, Ptr[Byte], Unit]): FT_Free_Func = o
    extension (v: FT_Free_Func)
      inline def value: CFuncPtr2[FT_Memory, Ptr[Byte], Unit] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * ************************************************************************
  */
  opaque type FT_Generic_Finalizer = CFuncPtr1[Ptr[Byte], Unit]
  object FT_Generic_Finalizer: 
    given _tag: Tag[FT_Generic_Finalizer] = Tag.materializeCFuncPtr1[Ptr[Byte], Unit]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): FT_Generic_Finalizer = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr1[Ptr[Byte], Unit]): FT_Generic_Finalizer = o
    extension (v: FT_Generic_Finalizer)
      inline def value: CFuncPtr1[Ptr[Byte], Unit] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * ************************************************************************
  */
  opaque type FT_GlyphSlot = Ptr[FT_GlyphSlotRec_]
  object FT_GlyphSlot: 
    given _tag: Tag[FT_GlyphSlot] = Tag.Ptr[FT_GlyphSlotRec_](FT_GlyphSlotRec_._tag)
    inline def apply(inline o: Ptr[FT_GlyphSlotRec_]): FT_GlyphSlot = o
    extension (v: FT_GlyphSlot)
      inline def value: Ptr[FT_GlyphSlotRec_] = v

  /**
   * ************************************************************************
  */
  type FT_Glyph_Format = FT_Glyph_Format_
  object FT_Glyph_Format: 
    given _tag: Tag[FT_Glyph_Format] = FT_Glyph_Format_._tag
    inline def apply(inline o: FT_Glyph_Format_): FT_Glyph_Format = o
    extension (v: FT_Glyph_Format)
      inline def value: FT_Glyph_Format_ = v

  /**
   * ************************************************************************
  */
  opaque type FT_Int = CInt
  object FT_Int: 
    given _tag: Tag[FT_Int] = Tag.Int
    inline def apply(inline o: CInt): FT_Int = o
    extension (v: FT_Int)
      inline def value: CInt = v

  /**
   * ************************************************************************
  */
  opaque type FT_Int16 = CShort
  object FT_Int16: 
    given _tag: Tag[FT_Int16] = Tag.Short
    inline def apply(inline o: CShort): FT_Int16 = o
    extension (v: FT_Int16)
      inline def value: CShort = v

  opaque type FT_Int32 = CInt
  object FT_Int32: 
    given _tag: Tag[FT_Int32] = Tag.Int
    inline def apply(inline o: CInt): FT_Int32 = o
    extension (v: FT_Int32)
      inline def value: CInt = v

  opaque type FT_Int64 = CLongInt
  object FT_Int64: 
    given _tag: Tag[FT_Int64] = Tag.Size
    inline def apply(inline o: CLongInt): FT_Int64 = o
    extension (v: FT_Int64)
      inline def value: CLongInt = v

  /**
   * ************************************************************************
  */
  type FT_Kerning_Mode = FT_Kerning_Mode_
  object FT_Kerning_Mode: 
    given _tag: Tag[FT_Kerning_Mode] = FT_Kerning_Mode_._tag
    inline def apply(inline o: FT_Kerning_Mode_): FT_Kerning_Mode = o
    extension (v: FT_Kerning_Mode)
      inline def value: FT_Kerning_Mode_ = v

  /**
   * ************************************************************************
  */
  opaque type FT_Library = Ptr[FT_LibraryRec_]
  object FT_Library: 
    given _tag: Tag[FT_Library] = Tag.Ptr[FT_LibraryRec_](FT_LibraryRec_._tag)
    inline def apply(inline o: Ptr[FT_LibraryRec_]): FT_Library = o
    extension (v: FT_Library)
      inline def value: Ptr[FT_LibraryRec_] = v

  /**
   * ************************************************************************
  */
  opaque type FT_List = Ptr[FT_ListRec_]
  object FT_List: 
    given _tag: Tag[FT_List] = Tag.Ptr[FT_ListRec_](FT_ListRec_._tag)
    inline def apply(inline o: Ptr[FT_ListRec_]): FT_List = o
    extension (v: FT_List)
      inline def value: Ptr[FT_ListRec_] = v

  /**
   * ************************************************************************
  */
  opaque type FT_ListNode = Ptr[FT_ListNodeRec_]
  object FT_ListNode: 
    given _tag: Tag[FT_ListNode] = Tag.Ptr[FT_ListNodeRec_](FT_ListNodeRec_._tag)
    inline def apply(inline o: Ptr[FT_ListNodeRec_]): FT_ListNode = o
    extension (v: FT_ListNode)
      inline def value: Ptr[FT_ListNodeRec_] = v

  /**
   * ************************************************************************
  */
  opaque type FT_Long = CLongInt
  object FT_Long: 
    given _tag: Tag[FT_Long] = Tag.Size
    inline def apply(inline o: CLongInt): FT_Long = o
    extension (v: FT_Long)
      inline def value: CLongInt = v

  /**
   * ************************************************************************
  */
  opaque type FT_Memory = Ptr[FT_MemoryRec_]
  object FT_Memory: 
    given _tag: Tag[FT_Memory] = Tag.Ptr[FT_MemoryRec_](FT_MemoryRec_._tag)
    inline def apply(inline o: Ptr[FT_MemoryRec_]): FT_Memory = o
    extension (v: FT_Memory)
      inline def value: Ptr[FT_MemoryRec_] = v

  /**
   * ************************************************************************
  */
  opaque type FT_Module = Ptr[FT_ModuleRec_]
  object FT_Module: 
    given _tag: Tag[FT_Module] = Tag.Ptr[FT_ModuleRec_](FT_ModuleRec_._tag)
    inline def apply(inline o: Ptr[FT_ModuleRec_]): FT_Module = o
    extension (v: FT_Module)
      inline def value: Ptr[FT_ModuleRec_] = v

  /**
   * ************************************************************************
  */
  type FT_Offset = size_t
  object FT_Offset: 
    given _tag: Tag[FT_Offset] = size_t._tag
    inline def apply(inline o: size_t): FT_Offset = o
    extension (v: FT_Offset)
      inline def value: size_t = v

  /**
   * ************************************************************************
  */
  opaque type FT_Outline_ConicToFunc = CFuncPtr3[Ptr[FT_Vector], Ptr[FT_Vector], Ptr[Byte], CInt]
  object FT_Outline_ConicToFunc: 
    given _tag: Tag[FT_Outline_ConicToFunc] = Tag.materializeCFuncPtr3[Ptr[FT_Vector], Ptr[FT_Vector], Ptr[Byte], CInt]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): FT_Outline_ConicToFunc = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr3[Ptr[FT_Vector], Ptr[FT_Vector], Ptr[Byte], CInt]): FT_Outline_ConicToFunc = o
    extension (v: FT_Outline_ConicToFunc)
      inline def value: CFuncPtr3[Ptr[FT_Vector], Ptr[FT_Vector], Ptr[Byte], CInt] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * ************************************************************************
  */
  opaque type FT_Outline_CubicToFunc = CFuncPtr4[Ptr[FT_Vector], Ptr[FT_Vector], Ptr[FT_Vector], Ptr[Byte], CInt]
  object FT_Outline_CubicToFunc: 
    given _tag: Tag[FT_Outline_CubicToFunc] = Tag.materializeCFuncPtr4[Ptr[FT_Vector], Ptr[FT_Vector], Ptr[FT_Vector], Ptr[Byte], CInt]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): FT_Outline_CubicToFunc = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr4[Ptr[FT_Vector], Ptr[FT_Vector], Ptr[FT_Vector], Ptr[Byte], CInt]): FT_Outline_CubicToFunc = o
    extension (v: FT_Outline_CubicToFunc)
      inline def value: CFuncPtr4[Ptr[FT_Vector], Ptr[FT_Vector], Ptr[FT_Vector], Ptr[Byte], CInt] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * ************************************************************************
  */
  opaque type FT_Outline_LineToFunc = CFuncPtr2[Ptr[FT_Vector], Ptr[Byte], CInt]
  object FT_Outline_LineToFunc: 
    given _tag: Tag[FT_Outline_LineToFunc] = Tag.materializeCFuncPtr2[Ptr[FT_Vector], Ptr[Byte], CInt]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): FT_Outline_LineToFunc = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr2[Ptr[FT_Vector], Ptr[Byte], CInt]): FT_Outline_LineToFunc = o
    extension (v: FT_Outline_LineToFunc)
      inline def value: CFuncPtr2[Ptr[FT_Vector], Ptr[Byte], CInt] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * ************************************************************************
  */
  opaque type FT_Outline_MoveToFunc = CFuncPtr2[Ptr[FT_Vector], Ptr[Byte], CInt]
  object FT_Outline_MoveToFunc: 
    given _tag: Tag[FT_Outline_MoveToFunc] = Tag.materializeCFuncPtr2[Ptr[FT_Vector], Ptr[Byte], CInt]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): FT_Outline_MoveToFunc = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr2[Ptr[FT_Vector], Ptr[Byte], CInt]): FT_Outline_MoveToFunc = o
    extension (v: FT_Outline_MoveToFunc)
      inline def value: CFuncPtr2[Ptr[FT_Vector], Ptr[Byte], CInt] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * ************************************************************************
  */
  type FT_Pixel_Mode = FT_Pixel_Mode_
  object FT_Pixel_Mode: 
    given _tag: Tag[FT_Pixel_Mode] = FT_Pixel_Mode_._tag
    inline def apply(inline o: FT_Pixel_Mode_): FT_Pixel_Mode = o
    extension (v: FT_Pixel_Mode)
      inline def value: FT_Pixel_Mode_ = v

  /**
   * ************************************************************************
  */
  opaque type FT_Pointer = Ptr[Byte]
  object FT_Pointer: 
    given _tag: Tag[FT_Pointer] = Tag.Ptr(Tag.Byte)
    inline def apply(inline o: Ptr[Byte]): FT_Pointer = o
    extension (v: FT_Pointer)
      inline def value: Ptr[Byte] = v

  /**
   * ************************************************************************
  */
  opaque type FT_Pos = CLongInt
  object FT_Pos: 
    given _tag: Tag[FT_Pos] = Tag.Size
    inline def apply(inline o: CLongInt): FT_Pos = o
    extension (v: FT_Pos)
      inline def value: CLongInt = v

  /**
   * ************************************************************************
  */
  type FT_PtrDist = ptrdiff_t
  object FT_PtrDist: 
    given _tag: Tag[FT_PtrDist] = ptrdiff_t._tag
    inline def apply(inline o: ptrdiff_t): FT_PtrDist = o
    extension (v: FT_PtrDist)
      inline def value: ptrdiff_t = v

  /**
   * ************************************************************************
  */
  opaque type FT_Raster = Ptr[FT_RasterRec_]
  object FT_Raster: 
    given _tag: Tag[FT_Raster] = Tag.Ptr[FT_RasterRec_](FT_RasterRec_._tag)
    inline def apply(inline o: Ptr[FT_RasterRec_]): FT_Raster = o
    extension (v: FT_Raster)
      inline def value: Ptr[FT_RasterRec_] = v

  /**
   * ************************************************************************
  */
  opaque type FT_Raster_BitSet_Func = CFuncPtr3[CInt, CInt, Ptr[Byte], Unit]
  object FT_Raster_BitSet_Func: 
    given _tag: Tag[FT_Raster_BitSet_Func] = Tag.materializeCFuncPtr3[CInt, CInt, Ptr[Byte], Unit]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): FT_Raster_BitSet_Func = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr3[CInt, CInt, Ptr[Byte], Unit]): FT_Raster_BitSet_Func = o
    extension (v: FT_Raster_BitSet_Func)
      inline def value: CFuncPtr3[CInt, CInt, Ptr[Byte], Unit] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * ************************************************************************
  */
  opaque type FT_Raster_BitTest_Func = CFuncPtr3[CInt, CInt, Ptr[Byte], CInt]
  object FT_Raster_BitTest_Func: 
    given _tag: Tag[FT_Raster_BitTest_Func] = Tag.materializeCFuncPtr3[CInt, CInt, Ptr[Byte], CInt]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): FT_Raster_BitTest_Func = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr3[CInt, CInt, Ptr[Byte], CInt]): FT_Raster_BitTest_Func = o
    extension (v: FT_Raster_BitTest_Func)
      inline def value: CFuncPtr3[CInt, CInt, Ptr[Byte], CInt] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * ************************************************************************
  */
  opaque type FT_Raster_DoneFunc = CFuncPtr1[FT_Raster, Unit]
  object FT_Raster_DoneFunc: 
    given _tag: Tag[FT_Raster_DoneFunc] = Tag.materializeCFuncPtr1[FT_Raster, Unit]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): FT_Raster_DoneFunc = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr1[FT_Raster, Unit]): FT_Raster_DoneFunc = o
    extension (v: FT_Raster_DoneFunc)
      inline def value: CFuncPtr1[FT_Raster, Unit] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * ************************************************************************
  */
  opaque type FT_Raster_NewFunc = CFuncPtr2[Ptr[Byte], Ptr[FT_Raster], CInt]
  object FT_Raster_NewFunc: 
    given _tag: Tag[FT_Raster_NewFunc] = Tag.materializeCFuncPtr2[Ptr[Byte], Ptr[FT_Raster], CInt]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): FT_Raster_NewFunc = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr2[Ptr[Byte], Ptr[FT_Raster], CInt]): FT_Raster_NewFunc = o
    extension (v: FT_Raster_NewFunc)
      inline def value: CFuncPtr2[Ptr[Byte], Ptr[FT_Raster], CInt] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * ************************************************************************
  */
  opaque type FT_Raster_RenderFunc = CFuncPtr2[FT_Raster, Ptr[FT_Raster_Params], CInt]
  object FT_Raster_RenderFunc: 
    given _tag: Tag[FT_Raster_RenderFunc] = Tag.materializeCFuncPtr2[FT_Raster, Ptr[FT_Raster_Params], CInt]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): FT_Raster_RenderFunc = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr2[FT_Raster, Ptr[FT_Raster_Params], CInt]): FT_Raster_RenderFunc = o
    extension (v: FT_Raster_RenderFunc)
      inline def value: CFuncPtr2[FT_Raster, Ptr[FT_Raster_Params], CInt] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * ************************************************************************
  */
  opaque type FT_Raster_ResetFunc = CFuncPtr3[FT_Raster, Ptr[CUnsignedChar], CUnsignedLongInt, Unit]
  object FT_Raster_ResetFunc: 
    given _tag: Tag[FT_Raster_ResetFunc] = Tag.materializeCFuncPtr3[FT_Raster, Ptr[CUnsignedChar], CUnsignedLongInt, Unit]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): FT_Raster_ResetFunc = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr3[FT_Raster, Ptr[CUnsignedChar], CUnsignedLongInt, Unit]): FT_Raster_ResetFunc = o
    extension (v: FT_Raster_ResetFunc)
      inline def value: CFuncPtr3[FT_Raster, Ptr[CUnsignedChar], CUnsignedLongInt, Unit] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * ************************************************************************
  */
  opaque type FT_Raster_SetModeFunc = CFuncPtr3[FT_Raster, CUnsignedLongInt, Ptr[Byte], CInt]
  object FT_Raster_SetModeFunc: 
    given _tag: Tag[FT_Raster_SetModeFunc] = Tag.materializeCFuncPtr3[FT_Raster, CUnsignedLongInt, Ptr[Byte], CInt]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): FT_Raster_SetModeFunc = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr3[FT_Raster, CUnsignedLongInt, Ptr[Byte], CInt]): FT_Raster_SetModeFunc = o
    extension (v: FT_Raster_SetModeFunc)
      inline def value: CFuncPtr3[FT_Raster, CUnsignedLongInt, Ptr[Byte], CInt] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * ************************************************************************
  */
  opaque type FT_Realloc_Func = CFuncPtr4[FT_Memory, CLongInt, CLongInt, Ptr[Byte], Ptr[Byte]]
  object FT_Realloc_Func: 
    given _tag: Tag[FT_Realloc_Func] = Tag.materializeCFuncPtr4[FT_Memory, CLongInt, CLongInt, Ptr[Byte], Ptr[Byte]]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): FT_Realloc_Func = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr4[FT_Memory, CLongInt, CLongInt, Ptr[Byte], Ptr[Byte]]): FT_Realloc_Func = o
    extension (v: FT_Realloc_Func)
      inline def value: CFuncPtr4[FT_Memory, CLongInt, CLongInt, Ptr[Byte], Ptr[Byte]] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * ************************************************************************
  */
  type FT_Render_Mode = FT_Render_Mode_
  object FT_Render_Mode: 
    given _tag: Tag[FT_Render_Mode] = FT_Render_Mode_._tag
    inline def apply(inline o: FT_Render_Mode_): FT_Render_Mode = o
    extension (v: FT_Render_Mode)
      inline def value: FT_Render_Mode_ = v

  /**
   * ************************************************************************
  */
  opaque type FT_Renderer = Ptr[FT_RendererRec_]
  object FT_Renderer: 
    given _tag: Tag[FT_Renderer] = Tag.Ptr[FT_RendererRec_](FT_RendererRec_._tag)
    inline def apply(inline o: Ptr[FT_RendererRec_]): FT_Renderer = o
    extension (v: FT_Renderer)
      inline def value: Ptr[FT_RendererRec_] = v

  /**
   * ************************************************************************
  */
  opaque type FT_Short = CShort
  object FT_Short: 
    given _tag: Tag[FT_Short] = Tag.Short
    inline def apply(inline o: CShort): FT_Short = o
    extension (v: FT_Short)
      inline def value: CShort = v

  /**
   * ************************************************************************
  */
  opaque type FT_Size = Ptr[FT_SizeRec_]
  object FT_Size: 
    given _tag: Tag[FT_Size] = Tag.Ptr[FT_SizeRec_](FT_SizeRec_._tag)
    inline def apply(inline o: Ptr[FT_SizeRec_]): FT_Size = o
    extension (v: FT_Size)
      inline def value: Ptr[FT_SizeRec_] = v

  /**
   * ************************************************************************
  */
  opaque type FT_Size_Internal = Ptr[FT_Size_InternalRec_]
  object FT_Size_Internal: 
    given _tag: Tag[FT_Size_Internal] = Tag.Ptr[FT_Size_InternalRec_](FT_Size_InternalRec_._tag)
    inline def apply(inline o: Ptr[FT_Size_InternalRec_]): FT_Size_Internal = o
    extension (v: FT_Size_Internal)
      inline def value: Ptr[FT_Size_InternalRec_] = v

  /**
   * ************************************************************************
  */
  opaque type FT_Size_Request = Ptr[FT_Size_RequestRec_]
  object FT_Size_Request: 
    given _tag: Tag[FT_Size_Request] = Tag.Ptr[FT_Size_RequestRec_](FT_Size_RequestRec_._tag)
    inline def apply(inline o: Ptr[FT_Size_RequestRec_]): FT_Size_Request = o
    extension (v: FT_Size_Request)
      inline def value: Ptr[FT_Size_RequestRec_] = v

  /**
   * ************************************************************************
  */
  type FT_Size_Request_Type = FT_Size_Request_Type_
  object FT_Size_Request_Type: 
    given _tag: Tag[FT_Size_Request_Type] = FT_Size_Request_Type_._tag
    inline def apply(inline o: FT_Size_Request_Type_): FT_Size_Request_Type = o
    extension (v: FT_Size_Request_Type)
      inline def value: FT_Size_Request_Type_ = v

  /**
   * ************************************************************************
  */
  opaque type FT_Slot_Internal = Ptr[FT_Slot_InternalRec_]
  object FT_Slot_Internal: 
    given _tag: Tag[FT_Slot_Internal] = Tag.Ptr[FT_Slot_InternalRec_](FT_Slot_InternalRec_._tag)
    inline def apply(inline o: Ptr[FT_Slot_InternalRec_]): FT_Slot_Internal = o
    extension (v: FT_Slot_Internal)
      inline def value: Ptr[FT_Slot_InternalRec_] = v

  /**
   * ************************************************************************
  */
  opaque type FT_SpanFunc = CFuncPtr4[CInt, CInt, Ptr[FT_Span], Ptr[Byte], Unit]
  object FT_SpanFunc: 
    given _tag: Tag[FT_SpanFunc] = Tag.materializeCFuncPtr4[CInt, CInt, Ptr[FT_Span], Ptr[Byte], Unit]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): FT_SpanFunc = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr4[CInt, CInt, Ptr[FT_Span], Ptr[Byte], Unit]): FT_SpanFunc = o
    extension (v: FT_SpanFunc)
      inline def value: CFuncPtr4[CInt, CInt, Ptr[FT_Span], Ptr[Byte], Unit] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * ************************************************************************
  */
  opaque type FT_Stream = Ptr[FT_StreamRec_]
  object FT_Stream: 
    given _tag: Tag[FT_Stream] = Tag.Ptr[FT_StreamRec_](FT_StreamRec_._tag)
    inline def apply(inline o: Ptr[FT_StreamRec_]): FT_Stream = o
    extension (v: FT_Stream)
      inline def value: Ptr[FT_StreamRec_] = v

  /**
   * ************************************************************************
  */
  opaque type FT_Stream_CloseFunc = CFuncPtr1[FT_Stream, Unit]
  object FT_Stream_CloseFunc: 
    given _tag: Tag[FT_Stream_CloseFunc] = Tag.materializeCFuncPtr1[FT_Stream, Unit]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): FT_Stream_CloseFunc = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr1[FT_Stream, Unit]): FT_Stream_CloseFunc = o
    extension (v: FT_Stream_CloseFunc)
      inline def value: CFuncPtr1[FT_Stream, Unit] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * ************************************************************************
  */
  opaque type FT_Stream_IoFunc = CFuncPtr4[FT_Stream, CUnsignedLongInt, Ptr[CUnsignedChar], CUnsignedLongInt, CUnsignedLongInt]
  object FT_Stream_IoFunc: 
    given _tag: Tag[FT_Stream_IoFunc] = Tag.materializeCFuncPtr4[FT_Stream, CUnsignedLongInt, Ptr[CUnsignedChar], CUnsignedLongInt, CUnsignedLongInt]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): FT_Stream_IoFunc = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr4[FT_Stream, CUnsignedLongInt, Ptr[CUnsignedChar], CUnsignedLongInt, CUnsignedLongInt]): FT_Stream_IoFunc = o
    extension (v: FT_Stream_IoFunc)
      inline def value: CFuncPtr4[FT_Stream, CUnsignedLongInt, Ptr[CUnsignedChar], CUnsignedLongInt, CUnsignedLongInt] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * ************************************************************************
  */
  opaque type FT_String = CChar
  object FT_String: 
    given _tag: Tag[FT_String] = Tag.Byte
    inline def apply(inline o: CChar): FT_String = o
    extension (v: FT_String)
      inline def value: CChar = v

  /**
   * ************************************************************************
  */
  opaque type FT_SubGlyph = Ptr[FT_SubGlyphRec_]
  object FT_SubGlyph: 
    given _tag: Tag[FT_SubGlyph] = Tag.Ptr[FT_SubGlyphRec_](FT_SubGlyphRec_._tag)
    inline def apply(inline o: Ptr[FT_SubGlyphRec_]): FT_SubGlyph = o
    extension (v: FT_SubGlyph)
      inline def value: Ptr[FT_SubGlyphRec_] = v

  /**
   * ************************************************************************
  */
  type FT_Tag = FT_UInt32
  object FT_Tag: 
    given _tag: Tag[FT_Tag] = FT_UInt32._tag
    inline def apply(inline o: FT_UInt32): FT_Tag = o
    extension (v: FT_Tag)
      inline def value: FT_UInt32 = v

  /**
   * ************************************************************************
  */
  opaque type FT_UFWord = CUnsignedShort
  object FT_UFWord: 
    given _tag: Tag[FT_UFWord] = Tag.UShort
    inline def apply(inline o: CUnsignedShort): FT_UFWord = o
    extension (v: FT_UFWord)
      inline def value: CUnsignedShort = v

  opaque type FT_UFast = CUnsignedInt
  object FT_UFast: 
    given _tag: Tag[FT_UFast] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): FT_UFast = o
    extension (v: FT_UFast)
      inline def value: CUnsignedInt = v

  /**
   * ************************************************************************
  */
  opaque type FT_UInt = CUnsignedInt
  object FT_UInt: 
    given _tag: Tag[FT_UInt] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): FT_UInt = o
    extension (v: FT_UInt)
      inline def value: CUnsignedInt = v

  /**
   * ************************************************************************
  */
  opaque type FT_UInt16 = CUnsignedShort
  object FT_UInt16: 
    given _tag: Tag[FT_UInt16] = Tag.UShort
    inline def apply(inline o: CUnsignedShort): FT_UInt16 = o
    extension (v: FT_UInt16)
      inline def value: CUnsignedShort = v

  opaque type FT_UInt32 = CUnsignedInt
  object FT_UInt32: 
    given _tag: Tag[FT_UInt32] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): FT_UInt32 = o
    extension (v: FT_UInt32)
      inline def value: CUnsignedInt = v

  opaque type FT_UInt64 = CUnsignedLongInt
  object FT_UInt64: 
    given _tag: Tag[FT_UInt64] = Tag.USize
    inline def apply(inline o: CUnsignedLongInt): FT_UInt64 = o
    extension (v: FT_UInt64)
      inline def value: CUnsignedLongInt = v

  /**
   * ************************************************************************
  */
  opaque type FT_ULong = CUnsignedLongInt
  object FT_ULong: 
    given _tag: Tag[FT_ULong] = Tag.USize
    inline def apply(inline o: CUnsignedLongInt): FT_ULong = o
    extension (v: FT_ULong)
      inline def value: CUnsignedLongInt = v

  /**
   * ************************************************************************
  */
  opaque type FT_UShort = CUnsignedShort
  object FT_UShort: 
    given _tag: Tag[FT_UShort] = Tag.UShort
    inline def apply(inline o: CUnsignedShort): FT_UShort = o
    extension (v: FT_UShort)
      inline def value: CUnsignedShort = v

  opaque type FcBool = CInt
  object FcBool: 
    given _tag: Tag[FcBool] = Tag.Int
    inline def apply(inline o: CInt): FcBool = o
    extension (v: FcBool)
      inline def value: CInt = v

  opaque type FcChar16 = CUnsignedShort
  object FcChar16: 
    given _tag: Tag[FcChar16] = Tag.UShort
    inline def apply(inline o: CUnsignedShort): FcChar16 = o
    extension (v: FcChar16)
      inline def value: CUnsignedShort = v

  opaque type FcChar32 = CUnsignedInt
  object FcChar32: 
    given _tag: Tag[FcChar32] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): FcChar32 = o
    extension (v: FcChar32)
      inline def value: CUnsignedInt = v

  opaque type FcChar8 = CUnsignedChar
  object FcChar8: 
    given _tag: Tag[FcChar8] = Tag.UByte
    inline def apply(inline o: CUnsignedChar): FcChar8 = o
    extension (v: FcChar8)
      inline def value: CUnsignedChar = v

  type FcLangResult = _FcLangResult
  object FcLangResult: 
    given _tag: Tag[FcLangResult] = _FcLangResult._tag
    inline def apply(inline o: _FcLangResult): FcLangResult = o
    extension (v: FcLangResult)
      inline def value: _FcLangResult = v

  type FcMatchKind = _FcMatchKind
  object FcMatchKind: 
    given _tag: Tag[FcMatchKind] = _FcMatchKind._tag
    inline def apply(inline o: _FcMatchKind): FcMatchKind = o
    extension (v: FcMatchKind)
      inline def value: _FcMatchKind = v

  type FcResult = _FcResult
  object FcResult: 
    given _tag: Tag[FcResult] = _FcResult._tag
    inline def apply(inline o: _FcResult): FcResult = o
    extension (v: FcResult)
      inline def value: _FcResult = v

  type FcSetName = _FcSetName
  object FcSetName: 
    given _tag: Tag[FcSetName] = _FcSetName._tag
    inline def apply(inline o: _FcSetName): FcSetName = o
    extension (v: FcSetName)
      inline def value: _FcSetName = v

  type FcType = _FcType
  object FcType: 
    given _tag: Tag[FcType] = _FcType._tag
    inline def apply(inline o: _FcType): FcType = o
    extension (v: FcType)
      inline def value: _FcType = v

  type FcValueBinding = _FcValueBinding
  object FcValueBinding: 
    given _tag: Tag[FcValueBinding] = _FcValueBinding._tag
    inline def apply(inline o: _FcValueBinding): FcValueBinding = o
    extension (v: FcValueBinding)
      inline def value: _FcValueBinding = v

  /**
   * cairo_antialias_t: _ANTIALIAS_DEFAULT: Use the default antialiasing for the subsystem and target device, since 1.0 _ANTIALIAS_NONE: Use a bilevel alpha mask, since 1.0 _ANTIALIAS_GRAY: Perform single-color antialiasing (using shades of gray for black text on a white background, for example), since 1.0 _ANTIALIAS_SUBPIXEL: Perform antialiasing by taking advantage of the order of subpixel elements on devices such as LCD panels, since 1.0 _ANTIALIAS_FAST: Hint that the backend should perform some antialiasing but prefer speed over quality, since 1.12 _ANTIALIAS_GOOD: The backend should balance quality against performance, since 1.12 _ANTIALIAS_BEST: Hint that the backend should render at the highest quality, sacrificing speed if necessary, since 1.12
  */
  type cairo_antialias_t = _cairo_antialias
  object cairo_antialias_t: 
    given _tag: Tag[cairo_antialias_t] = _cairo_antialias._tag
    inline def apply(inline o: _cairo_antialias): cairo_antialias_t = o
    extension (v: cairo_antialias_t)
      inline def value: _cairo_antialias = v

  /**
   * cairo_bool_t:
  */
  opaque type cairo_bool_t = CInt
  object cairo_bool_t: 
    given _tag: Tag[cairo_bool_t] = Tag.Int
    inline def apply(inline o: CInt): cairo_bool_t = o
    extension (v: cairo_bool_t)
      inline def value: CInt = v

  /**
   * cairo_color_mode_t: _COLOR_MODE_DEFAULT: Use the default color mode for font backend and target device, since 1.18. _COLOR_MODE_NO_COLOR: Disable rendering color glyphs. Glyphs are always rendered as outline glyphs, since 1.18. _COLOR_MODE_COLOR: Enable rendering color glyphs. If the font contains a color presentation for a glyph, and when supported by the font backend, the glyph will be rendered in color, since 1.18.
  */
  type cairo_color_mode_t = _cairo_color_mode
  object cairo_color_mode_t: 
    given _tag: Tag[cairo_color_mode_t] = _cairo_color_mode._tag
    inline def apply(inline o: _cairo_color_mode): cairo_color_mode_t = o
    extension (v: cairo_color_mode_t)
      inline def value: _cairo_color_mode = v

  /**
   * cairo_content_t: _CONTENT_COLOR: The surface will hold color content only. (Since 1.0) _CONTENT_ALPHA: The surface will hold alpha content only. (Since 1.0) _CONTENT_COLOR_ALPHA: The surface will hold color and alpha content. (Since 1.0)
  */
  type cairo_content_t = _cairo_content
  object cairo_content_t: 
    given _tag: Tag[cairo_content_t] = _cairo_content._tag
    inline def apply(inline o: _cairo_content): cairo_content_t = o
    extension (v: cairo_content_t)
      inline def value: _cairo_content = v

  /**
   * cairo_destroy_func_t:
  */
  opaque type cairo_destroy_func_t = CFuncPtr1[Ptr[Byte], Unit]
  object cairo_destroy_func_t: 
    given _tag: Tag[cairo_destroy_func_t] = Tag.materializeCFuncPtr1[Ptr[Byte], Unit]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): cairo_destroy_func_t = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr1[Ptr[Byte], Unit]): cairo_destroy_func_t = o
    extension (v: cairo_destroy_func_t)
      inline def value: CFuncPtr1[Ptr[Byte], Unit] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * cairo_device_type_t: _DEVICE_TYPE_DRM: The device is of type Direct Render Manager, since 1.10 _DEVICE_TYPE_GL: The device is of type OpenGL, since 1.10 _DEVICE_TYPE_SCRIPT: The device is of type script, since 1.10 _DEVICE_TYPE_XCB: The device is of type xcb, since 1.10 _DEVICE_TYPE_XLIB: The device is of type xlib, since 1.10 _DEVICE_TYPE_XML: The device is of type XML, since 1.10 _DEVICE_TYPE_COGL: The device is of type cogl, since 1.12 _DEVICE_TYPE_WIN32: The device is of type win32, since 1.12 _DEVICE_TYPE_INVALID: The device is invalid, since 1.10
  */
  type cairo_device_type_t = _cairo_device_type
  object cairo_device_type_t: 
    given _tag: Tag[cairo_device_type_t] = _cairo_device_type._tag
    inline def apply(inline o: _cairo_device_type): cairo_device_type_t = o
    extension (v: cairo_device_type_t)
      inline def value: _cairo_device_type = v

  /**
   * cairo_dither_t: _DITHER_NONE: No dithering. _DITHER_DEFAULT: Default choice at cairo compile time. Currently NONE. _DITHER_FAST: Fastest dithering algorithm supported by the backend _DITHER_GOOD: An algorithm with smoother dithering than FAST _DITHER_BEST: Best algorithm available in the backend
  */
  type cairo_dither_t = _cairo_dither
  object cairo_dither_t: 
    given _tag: Tag[cairo_dither_t] = _cairo_dither._tag
    inline def apply(inline o: _cairo_dither): cairo_dither_t = o
    extension (v: cairo_dither_t)
      inline def value: _cairo_dither = v

  /**
   * cairo_extend_t: _EXTEND_NONE: pixels outside of the source pattern are fully transparent (Since 1.0) _EXTEND_REPEAT: the pattern is tiled by repeating (Since 1.0) _EXTEND_REFLECT: the pattern is tiled by reflecting at the edges (Since 1.0; but only implemented for surface patterns since 1.6) _EXTEND_PAD: pixels outside of the pattern copy the closest pixel from the source (Since 1.2; but only implemented for surface patterns since 1.6)
  */
  type cairo_extend_t = _cairo_extend
  object cairo_extend_t: 
    given _tag: Tag[cairo_extend_t] = _cairo_extend._tag
    inline def apply(inline o: _cairo_extend): cairo_extend_t = o
    extension (v: cairo_extend_t)
      inline def value: _cairo_extend = v

  /**
   * cairo_fill_rule_t: _FILL_RULE_WINDING: If the path crosses the ray from left-to-right, counts +1. If the path crosses the ray from right to left, counts -1. (Left and right are determined from the perspective of looking along the ray from the starting point.) If the total count is non-zero, the point will be filled. (Since 1.0) _FILL_RULE_EVEN_ODD: Counts the total number of intersections, without regard to the orientation of the contour. If the total number of intersections is odd, the point will be filled. (Since 1.0)
  */
  type cairo_fill_rule_t = _cairo_fill_rule
  object cairo_fill_rule_t: 
    given _tag: Tag[cairo_fill_rule_t] = _cairo_fill_rule._tag
    inline def apply(inline o: _cairo_fill_rule): cairo_fill_rule_t = o
    extension (v: cairo_fill_rule_t)
      inline def value: _cairo_fill_rule = v

  /**
   * cairo_filter_t: _FILTER_FAST: A high-performance filter, with quality similar to %CAIRO_FILTER_NEAREST (Since 1.0) _FILTER_GOOD: A reasonable-performance filter, with quality similar to %CAIRO_FILTER_BILINEAR (Since 1.0) _FILTER_BEST: The highest-quality available, performance may not be suitable for interactive use. (Since 1.0) _FILTER_NEAREST: Nearest-neighbor filtering (Since 1.0) _FILTER_BILINEAR: Linear interpolation in two dimensions (Since 1.0) _FILTER_GAUSSIAN: This filter value is currently unimplemented, and should not be used in current code. (Since 1.0)
  */
  type cairo_filter_t = _cairo_filter
  object cairo_filter_t: 
    given _tag: Tag[cairo_filter_t] = _cairo_filter._tag
    inline def apply(inline o: _cairo_filter): cairo_filter_t = o
    extension (v: cairo_filter_t)
      inline def value: _cairo_filter = v

  /**
   * cairo_font_slant_t: _FONT_SLANT_NORMAL: Upright font style, since 1.0 _FONT_SLANT_ITALIC: Italic font style, since 1.0 _FONT_SLANT_OBLIQUE: Oblique font style, since 1.0
  */
  type cairo_font_slant_t = _cairo_font_slant
  object cairo_font_slant_t: 
    given _tag: Tag[cairo_font_slant_t] = _cairo_font_slant._tag
    inline def apply(inline o: _cairo_font_slant): cairo_font_slant_t = o
    extension (v: cairo_font_slant_t)
      inline def value: _cairo_font_slant = v

  /**
   * cairo_font_type_t: _FONT_TYPE_TOY: The font was created using cairo's toy font api (Since: 1.2) _FONT_TYPE_FT: The font is of type FreeType (Since: 1.2) _FONT_TYPE_WIN32: The font is of type Win32 (Since: 1.2) _FONT_TYPE_QUARTZ: The font is of type Quartz (Since: 1.6, in 1.2 and 1.4 it was named CAIRO_FONT_TYPE_ATSUI) _FONT_TYPE_USER: The font was create using cairo's user font api (Since: 1.8) _FONT_TYPE_DWRITE: The font is of type Win32 DWrite (Since: 1.18)
  */
  type cairo_font_type_t = _cairo_font_type
  object cairo_font_type_t: 
    given _tag: Tag[cairo_font_type_t] = _cairo_font_type._tag
    inline def apply(inline o: _cairo_font_type): cairo_font_type_t = o
    extension (v: cairo_font_type_t)
      inline def value: _cairo_font_type = v

  /**
   * cairo_font_weight_t: _FONT_WEIGHT_NORMAL: Normal font weight, since 1.0 _FONT_WEIGHT_BOLD: Bold font weight, since 1.0
  */
  type cairo_font_weight_t = _cairo_font_weight
  object cairo_font_weight_t: 
    given _tag: Tag[cairo_font_weight_t] = _cairo_font_weight._tag
    inline def apply(inline o: _cairo_font_weight): cairo_font_weight_t = o
    extension (v: cairo_font_weight_t)
      inline def value: _cairo_font_weight = v

  /**
   * cairo_format_t: _FORMAT_INVALID: no such format exists or is supported. _FORMAT_ARGB32: each pixel is a 32-bit quantity, with alpha in the upper 8 bits, then red, then green, then blue. The 32-bit quantities are stored native-endian. Pre-multiplied alpha is used. (That is, 50% transparent red is 0x80800000, not 0x80ff0000.) (Since 1.0) _FORMAT_RGB24: each pixel is a 32-bit quantity, with the upper 8 bits unused. Red, Green, and Blue are stored in the remaining 24 bits in that order. (Since 1.0) _FORMAT_A8: each pixel is a 8-bit quantity holding an alpha value. (Since 1.0) _FORMAT_A1: each pixel is a 1-bit quantity holding an alpha value. Pixels are packed together into 32-bit quantities. The ordering of the bits matches the endianness of the platform. On a big-endian machine, the first pixel is in the uppermost bit, on a little-endian machine the first pixel is in the least-significant bit. (Since 1.0) _FORMAT_RGB16_565: each pixel is a 16-bit quantity with red in the upper 5 bits, then green in the middle 6 bits, and blue in the lower 5 bits. (Since 1.2) _FORMAT_RGB30: like RGB24 but with 10bpc. (Since 1.12) _FORMAT_RGB96F: 3 floats, R, G, B. (Since 1.17.2) _FORMAT_RGBA128F: 4 floats, R, G, B, A. (Since 1.17.2)
  */
  type cairo_format_t = _cairo_format
  object cairo_format_t: 
    given _tag: Tag[cairo_format_t] = _cairo_format._tag
    inline def apply(inline o: _cairo_format): cairo_format_t = o
    extension (v: cairo_format_t)
      inline def value: _cairo_format = v

  /**
   * cairo_hint_metrics_t: _HINT_METRICS_DEFAULT: Hint metrics in the default manner for the font backend and target device, since 1.0 _HINT_METRICS_OFF: Do not hint font metrics, since 1.0 _HINT_METRICS_ON: Hint font metrics, since 1.0
  */
  type cairo_hint_metrics_t = _cairo_hint_metrics
  object cairo_hint_metrics_t: 
    given _tag: Tag[cairo_hint_metrics_t] = _cairo_hint_metrics._tag
    inline def apply(inline o: _cairo_hint_metrics): cairo_hint_metrics_t = o
    extension (v: cairo_hint_metrics_t)
      inline def value: _cairo_hint_metrics = v

  /**
   * cairo_hint_style_t: _HINT_STYLE_DEFAULT: Use the default hint style for font backend and target device, since 1.0 _HINT_STYLE_NONE: Do not hint outlines, since 1.0 _HINT_STYLE_SLIGHT: Hint outlines slightly to improve contrast while retaining good fidelity to the original shapes, since 1.0 _HINT_STYLE_MEDIUM: Hint outlines with medium strength giving a compromise between fidelity to the original shapes and contrast, since 1.0 _HINT_STYLE_FULL: Hint outlines to maximize contrast, since 1.0
  */
  type cairo_hint_style_t = _cairo_hint_style
  object cairo_hint_style_t: 
    given _tag: Tag[cairo_hint_style_t] = _cairo_hint_style._tag
    inline def apply(inline o: _cairo_hint_style): cairo_hint_style_t = o
    extension (v: cairo_hint_style_t)
      inline def value: _cairo_hint_style = v

  /**
   * cairo_line_cap_t: _LINE_CAP_BUTT: start(stop) the line exactly at the start(end) point (Since 1.0) _LINE_CAP_ROUND: use a round ending, the center of the circle is the end point (Since 1.0) _LINE_CAP_SQUARE: use squared ending, the center of the square is the end point (Since 1.0)
  */
  type cairo_line_cap_t = _cairo_line_cap
  object cairo_line_cap_t: 
    given _tag: Tag[cairo_line_cap_t] = _cairo_line_cap._tag
    inline def apply(inline o: _cairo_line_cap): cairo_line_cap_t = o
    extension (v: cairo_line_cap_t)
      inline def value: _cairo_line_cap = v

  /**
   * cairo_line_join_t: _LINE_JOIN_MITER: use a sharp (angled) corner, see cairo_set_miter_limit() (Since 1.0) _LINE_JOIN_ROUND: use a rounded join, the center of the circle is the joint point (Since 1.0) _LINE_JOIN_BEVEL: use a cut-off join, the join is cut off at half the line width from the joint point (Since 1.0)
  */
  type cairo_line_join_t = _cairo_line_join
  object cairo_line_join_t: 
    given _tag: Tag[cairo_line_join_t] = _cairo_line_join._tag
    inline def apply(inline o: _cairo_line_join): cairo_line_join_t = o
    extension (v: cairo_line_join_t)
      inline def value: _cairo_line_join = v

  /**
   * cairo_operator_t: _OPERATOR_CLEAR: clear destination layer (bounded) (Since 1.0) _OPERATOR_SOURCE: replace destination layer (bounded) (Since 1.0) _OPERATOR_OVER: draw source layer on top of destination layer (bounded) (Since 1.0) _OPERATOR_IN: draw source where there was destination content (unbounded) (Since 1.0) _OPERATOR_OUT: draw source where there was no destination content (unbounded) (Since 1.0) _OPERATOR_ATOP: draw source on top of destination content and only there (Since 1.0) _OPERATOR_DEST: ignore the source (Since 1.0) _OPERATOR_DEST_OVER: draw destination on top of source (Since 1.0) _OPERATOR_DEST_IN: leave destination only where there was source content (unbounded) (Since 1.0) _OPERATOR_DEST_OUT: leave destination only where there was no source content (Since 1.0) _OPERATOR_DEST_ATOP: leave destination on top of source content and only there (unbounded) (Since 1.0) _OPERATOR_XOR: source and destination are shown where there is only one of them (Since 1.0) _OPERATOR_ADD: source and destination layers are accumulated (Since 1.0) _OPERATOR_SATURATE: like over, but assuming source and dest are disjoint geometries (Since 1.0) _OPERATOR_MULTIPLY: source and destination layers are multiplied. This causes the result to be at least as dark as the darker inputs. (Since 1.10) _OPERATOR_SCREEN: source and destination are complemented and multiplied. This causes the result to be at least as light as the lighter inputs. (Since 1.10) _OPERATOR_OVERLAY: multiplies or screens, depending on the lightness of the destination color. (Since 1.10) _OPERATOR_DARKEN: replaces the destination with the source if it is darker, otherwise keeps the source. (Since 1.10) _OPERATOR_LIGHTEN: replaces the destination with the source if it is lighter, otherwise keeps the source. (Since 1.10) _OPERATOR_COLOR_DODGE: brightens the destination color to reflect the source color. (Since 1.10) _OPERATOR_COLOR_BURN: darkens the destination color to reflect the source color. (Since 1.10) _OPERATOR_HARD_LIGHT: Multiplies or screens, dependent on source color. (Since 1.10) _OPERATOR_SOFT_LIGHT: Darkens or lightens, dependent on source color. (Since 1.10) _OPERATOR_DIFFERENCE: Takes the difference of the source and destination color. (Since 1.10) _OPERATOR_EXCLUSION: Produces an effect similar to difference, but with lower contrast. (Since 1.10) _OPERATOR_HSL_HUE: Creates a color with the hue of the source and the saturation and luminosity of the target. (Since 1.10) _OPERATOR_HSL_SATURATION: Creates a color with the saturation of the source and the hue and luminosity of the target. Painting with this mode onto a gray area produces no change. (Since 1.10) _OPERATOR_HSL_COLOR: Creates a color with the hue and saturation of the source and the luminosity of the target. This preserves the gray levels of the target and is useful for coloring monochrome images or tinting color images. (Since 1.10) _OPERATOR_HSL_LUMINOSITY: Creates a color with the luminosity of the source and the hue and saturation of the target. This produces an inverse effect to _OPERATOR_HSL_COLOR. (Since 1.10)
  */
  type cairo_operator_t = _cairo_operator
  object cairo_operator_t: 
    given _tag: Tag[cairo_operator_t] = _cairo_operator._tag
    inline def apply(inline o: _cairo_operator): cairo_operator_t = o
    extension (v: cairo_operator_t)
      inline def value: _cairo_operator = v

  /**
   * cairo_path_data_type_t: _PATH_MOVE_TO: A move-to operation, since 1.0 _PATH_LINE_TO: A line-to operation, since 1.0 _PATH_CURVE_TO: A curve-to operation, since 1.0 _PATH_CLOSE_PATH: A close-path operation, since 1.0
  */
  type cairo_path_data_type_t = _cairo_path_data_type
  object cairo_path_data_type_t: 
    given _tag: Tag[cairo_path_data_type_t] = _cairo_path_data_type._tag
    inline def apply(inline o: _cairo_path_data_type): cairo_path_data_type_t = o
    extension (v: cairo_path_data_type_t)
      inline def value: _cairo_path_data_type = v

  /**
   * cairo_pattern_type_t: _PATTERN_TYPE_SOLID: The pattern is a solid (uniform) color. It may be opaque or translucent, since 1.2. _PATTERN_TYPE_SURFACE: The pattern is a based on a surface (an image), since 1.2. _PATTERN_TYPE_LINEAR: The pattern is a linear gradient, since 1.2. _PATTERN_TYPE_RADIAL: The pattern is a radial gradient, since 1.2. _PATTERN_TYPE_MESH: The pattern is a mesh, since 1.12. _PATTERN_TYPE_RASTER_SOURCE: The pattern is a user pattern providing raster data, since 1.12.
  */
  type cairo_pattern_type_t = _cairo_pattern_type
  object cairo_pattern_type_t: 
    given _tag: Tag[cairo_pattern_type_t] = _cairo_pattern_type._tag
    inline def apply(inline o: _cairo_pattern_type): cairo_pattern_type_t = o
    extension (v: cairo_pattern_type_t)
      inline def value: _cairo_pattern_type = v

  /**
   * cairo_raster_source_acquire_func_t: : the pattern being rendered from : the rendering target surface : rectangular region of interest in pixels in sample space
  */
  opaque type cairo_raster_source_acquire_func_t = CFuncPtr4[Ptr[cairo_pattern_t], Ptr[Byte], Ptr[cairo_surface_t], Ptr[cairo_rectangle_int_t], Ptr[cairo_surface_t]]
  object cairo_raster_source_acquire_func_t: 
    given _tag: Tag[cairo_raster_source_acquire_func_t] = Tag.materializeCFuncPtr4[Ptr[cairo_pattern_t], Ptr[Byte], Ptr[cairo_surface_t], Ptr[cairo_rectangle_int_t], Ptr[cairo_surface_t]]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): cairo_raster_source_acquire_func_t = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr4[Ptr[cairo_pattern_t], Ptr[Byte], Ptr[cairo_surface_t], Ptr[cairo_rectangle_int_t], Ptr[cairo_surface_t]]): cairo_raster_source_acquire_func_t = o
    extension (v: cairo_raster_source_acquire_func_t)
      inline def value: CFuncPtr4[Ptr[cairo_pattern_t], Ptr[Byte], Ptr[cairo_surface_t], Ptr[cairo_rectangle_int_t], Ptr[cairo_surface_t]] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * cairo_raster_source_copy_func_t: : the #cairo_pattern_t that was copied to : the #cairo_pattern_t being used as the source for the copy
  */
  opaque type cairo_raster_source_copy_func_t = CFuncPtr3[Ptr[cairo_pattern_t], Ptr[Byte], Ptr[cairo_pattern_t], cairo_status_t]
  object cairo_raster_source_copy_func_t: 
    given _tag: Tag[cairo_raster_source_copy_func_t] = Tag.materializeCFuncPtr3[Ptr[cairo_pattern_t], Ptr[Byte], Ptr[cairo_pattern_t], cairo_status_t]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): cairo_raster_source_copy_func_t = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr3[Ptr[cairo_pattern_t], Ptr[Byte], Ptr[cairo_pattern_t], cairo_status_t]): cairo_raster_source_copy_func_t = o
    extension (v: cairo_raster_source_copy_func_t)
      inline def value: CFuncPtr3[Ptr[cairo_pattern_t], Ptr[Byte], Ptr[cairo_pattern_t], cairo_status_t] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * cairo_raster_source_finish_func_t: : the pattern being rendered from
  */
  opaque type cairo_raster_source_finish_func_t = CFuncPtr2[Ptr[cairo_pattern_t], Ptr[Byte], Unit]
  object cairo_raster_source_finish_func_t: 
    given _tag: Tag[cairo_raster_source_finish_func_t] = Tag.materializeCFuncPtr2[Ptr[cairo_pattern_t], Ptr[Byte], Unit]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): cairo_raster_source_finish_func_t = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr2[Ptr[cairo_pattern_t], Ptr[Byte], Unit]): cairo_raster_source_finish_func_t = o
    extension (v: cairo_raster_source_finish_func_t)
      inline def value: CFuncPtr2[Ptr[cairo_pattern_t], Ptr[Byte], Unit] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * cairo_raster_source_release_func_t: : the pattern being rendered from : the surface created during acquire
  */
  opaque type cairo_raster_source_release_func_t = CFuncPtr3[Ptr[cairo_pattern_t], Ptr[Byte], Ptr[cairo_surface_t], Unit]
  object cairo_raster_source_release_func_t: 
    given _tag: Tag[cairo_raster_source_release_func_t] = Tag.materializeCFuncPtr3[Ptr[cairo_pattern_t], Ptr[Byte], Ptr[cairo_surface_t], Unit]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): cairo_raster_source_release_func_t = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr3[Ptr[cairo_pattern_t], Ptr[Byte], Ptr[cairo_surface_t], Unit]): cairo_raster_source_release_func_t = o
    extension (v: cairo_raster_source_release_func_t)
      inline def value: CFuncPtr3[Ptr[cairo_pattern_t], Ptr[Byte], Ptr[cairo_surface_t], Unit] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * cairo_raster_source_snapshot_func_t: : the pattern being rendered from
  */
  opaque type cairo_raster_source_snapshot_func_t = CFuncPtr2[Ptr[cairo_pattern_t], Ptr[Byte], cairo_status_t]
  object cairo_raster_source_snapshot_func_t: 
    given _tag: Tag[cairo_raster_source_snapshot_func_t] = Tag.materializeCFuncPtr2[Ptr[cairo_pattern_t], Ptr[Byte], cairo_status_t]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): cairo_raster_source_snapshot_func_t = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr2[Ptr[cairo_pattern_t], Ptr[Byte], cairo_status_t]): cairo_raster_source_snapshot_func_t = o
    extension (v: cairo_raster_source_snapshot_func_t)
      inline def value: CFuncPtr2[Ptr[cairo_pattern_t], Ptr[Byte], cairo_status_t] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * cairo_read_func_t: : the input closure
  */
  opaque type cairo_read_func_t = CFuncPtr3[Ptr[Byte], Ptr[CUnsignedChar], CUnsignedInt, cairo_status_t]
  object cairo_read_func_t: 
    given _tag: Tag[cairo_read_func_t] = Tag.materializeCFuncPtr3[Ptr[Byte], Ptr[CUnsignedChar], CUnsignedInt, cairo_status_t]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): cairo_read_func_t = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr3[Ptr[Byte], Ptr[CUnsignedChar], CUnsignedInt, cairo_status_t]): cairo_read_func_t = o
    extension (v: cairo_read_func_t)
      inline def value: CFuncPtr3[Ptr[Byte], Ptr[CUnsignedChar], CUnsignedInt, cairo_status_t] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * cairo_region_overlap_t: _REGION_OVERLAP_IN: The contents are entirely inside the region. (Since 1.10) _REGION_OVERLAP_OUT: The contents are entirely outside the region. (Since 1.10) _REGION_OVERLAP_PART: The contents are partially inside and partially outside the region. (Since 1.10)
  */
  type cairo_region_overlap_t = _cairo_region_overlap
  object cairo_region_overlap_t: 
    given _tag: Tag[cairo_region_overlap_t] = _cairo_region_overlap._tag
    inline def apply(inline o: _cairo_region_overlap): cairo_region_overlap_t = o
    extension (v: cairo_region_overlap_t)
      inline def value: _cairo_region_overlap = v

  /**
   * cairo_status_t: _STATUS_SUCCESS: no error has occurred (Since 1.0) _STATUS_NO_MEMORY: out of memory (Since 1.0) _STATUS_INVALID_RESTORE: cairo_restore() called without matching cairo_save() (Since 1.0) _STATUS_INVALID_POP_GROUP: no saved group to pop, i.e. cairo_pop_group() without matching cairo_push_group() (Since 1.0) _STATUS_NO_CURRENT_POINT: no current point defined (Since 1.0) _STATUS_INVALID_MATRIX: invalid matrix (not invertible) (Since 1.0) _STATUS_INVALID_STATUS: invalid value for an input #cairo_status_t (Since 1.0) _STATUS_NULL_POINTER: %NULL pointer (Since 1.0) _STATUS_INVALID_STRING: input string not valid UTF-8 (Since 1.0) _STATUS_INVALID_PATH_DATA: input path data not valid (Since 1.0) _STATUS_READ_ERROR: error while reading from input stream (Since 1.0) _STATUS_WRITE_ERROR: error while writing to output stream (Since 1.0) _STATUS_SURFACE_FINISHED: target surface has been finished (Since 1.0) _STATUS_SURFACE_TYPE_MISMATCH: the surface type is not appropriate for the operation (Since 1.0) _STATUS_PATTERN_TYPE_MISMATCH: the pattern type is not appropriate for the operation (Since 1.0) _STATUS_INVALID_CONTENT: invalid value for an input #cairo_content_t (Since 1.0) _STATUS_INVALID_FORMAT: invalid value for an input #cairo_format_t (Since 1.0) _STATUS_INVALID_VISUAL: invalid value for an input Visual* (Since 1.0) _STATUS_FILE_NOT_FOUND: file not found (Since 1.0) _STATUS_INVALID_DASH: invalid value for a dash setting (Since 1.0) _STATUS_INVALID_DSC_COMMENT: invalid value for a DSC comment (Since 1.2) _STATUS_INVALID_INDEX: invalid index passed to getter (Since 1.4) _STATUS_CLIP_NOT_REPRESENTABLE: clip region not representable in desired format (Since 1.4) _STATUS_TEMP_FILE_ERROR: error creating or writing to a temporary file (Since 1.6) _STATUS_INVALID_STRIDE: invalid value for stride (Since 1.6) _STATUS_FONT_TYPE_MISMATCH: the font type is not appropriate for the operation (Since 1.8) _STATUS_USER_FONT_IMMUTABLE: the user-font is immutable (Since 1.8) _STATUS_USER_FONT_ERROR: error occurred in a user-font callback function (Since 1.8) _STATUS_NEGATIVE_COUNT: negative number used where it is not allowed (Since 1.8) _STATUS_INVALID_CLUSTERS: input clusters do not represent the accompanying text and glyph array (Since 1.8) _STATUS_INVALID_SLANT: invalid value for an input #cairo_font_slant_t (Since 1.8) _STATUS_INVALID_WEIGHT: invalid value for an input #cairo_font_weight_t (Since 1.8) _STATUS_INVALID_SIZE: invalid value (typically too big) for the size of the input (surface, pattern, etc.) (Since 1.10) _STATUS_USER_FONT_NOT_IMPLEMENTED: user-font method not implemented (Since 1.10) _STATUS_DEVICE_TYPE_MISMATCH: the device type is not appropriate for the operation (Since 1.10) _STATUS_DEVICE_ERROR: an operation to the device caused an unspecified error (Since 1.10) _STATUS_INVALID_MESH_CONSTRUCTION: a mesh pattern construction operation was used outside of a cairo_mesh_pattern_begin_patch()/cairo_mesh_pattern_end_patch() pair (Since 1.12) _STATUS_DEVICE_FINISHED: target device has been finished (Since 1.12) _STATUS_JBIG2_GLOBAL_MISSING: %CAIRO_MIME_TYPE_JBIG2_GLOBAL_ID has been used on at least one image but no image provided %CAIRO_MIME_TYPE_JBIG2_GLOBAL (Since 1.14) _STATUS_PNG_ERROR: error occurred in libpng while reading from or writing to a PNG file (Since 1.16) _STATUS_FREETYPE_ERROR: error occurred in libfreetype (Since 1.16) _STATUS_WIN32_GDI_ERROR: error occurred in the Windows Graphics Device Interface (Since 1.16) _STATUS_TAG_ERROR: invalid tag name, attributes, or nesting (Since 1.16) _STATUS_DWRITE_ERROR: error occurred in the Windows Direct Write API (Since 1.18) _STATUS_SVG_FONT_ERROR: error occurred in OpenType-SVG font rendering (Since 1.18) _STATUS_LAST_STATUS: this is a special value indicating the number of status values defined in this enumeration. When using this value, note that the version of cairo at run-time may have additional status values defined than the value of this symbol at compile-time. (Since 1.10)
  */
  type cairo_status_t = _cairo_status
  object cairo_status_t: 
    given _tag: Tag[cairo_status_t] = _cairo_status._tag
    inline def apply(inline o: _cairo_status): cairo_status_t = o
    extension (v: cairo_status_t)
      inline def value: _cairo_status = v

  /**
   * cairo_subpixel_order_t: _SUBPIXEL_ORDER_DEFAULT: Use the default subpixel order for for the target device, since 1.0 _SUBPIXEL_ORDER_RGB: Subpixel elements are arranged horizontally with red at the left, since 1.0 _SUBPIXEL_ORDER_BGR: Subpixel elements are arranged horizontally with blue at the left, since 1.0 _SUBPIXEL_ORDER_VRGB: Subpixel elements are arranged vertically with red at the top, since 1.0 _SUBPIXEL_ORDER_VBGR: Subpixel elements are arranged vertically with blue at the top, since 1.0
  */
  type cairo_subpixel_order_t = _cairo_subpixel_order
  object cairo_subpixel_order_t: 
    given _tag: Tag[cairo_subpixel_order_t] = _cairo_subpixel_order._tag
    inline def apply(inline o: _cairo_subpixel_order): cairo_subpixel_order_t = o
    extension (v: cairo_subpixel_order_t)
      inline def value: _cairo_subpixel_order = v

  /**
   * cairo_surface_observer_callback_t: : the #cairo_surface_observer_t : the observed surface
  */
  opaque type cairo_surface_observer_callback_t = CFuncPtr3[Ptr[cairo_surface_t], Ptr[cairo_surface_t], Ptr[Byte], Unit]
  object cairo_surface_observer_callback_t: 
    given _tag: Tag[cairo_surface_observer_callback_t] = Tag.materializeCFuncPtr3[Ptr[cairo_surface_t], Ptr[cairo_surface_t], Ptr[Byte], Unit]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): cairo_surface_observer_callback_t = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr3[Ptr[cairo_surface_t], Ptr[cairo_surface_t], Ptr[Byte], Unit]): cairo_surface_observer_callback_t = o
    extension (v: cairo_surface_observer_callback_t)
      inline def value: CFuncPtr3[Ptr[cairo_surface_t], Ptr[cairo_surface_t], Ptr[Byte], Unit] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * cairo_surface_type_t: _SURFACE_TYPE_IMAGE: The surface is of type image, since 1.2 _SURFACE_TYPE_PDF: The surface is of type pdf, since 1.2 _SURFACE_TYPE_PS: The surface is of type ps, since 1.2 _SURFACE_TYPE_XLIB: The surface is of type xlib, since 1.2 _SURFACE_TYPE_XCB: The surface is of type xcb, since 1.2 _SURFACE_TYPE_GLITZ: The surface is of type glitz, since 1.2, deprecated 1.18 (glitz support have been removed, this surface type will never be set by cairo) _SURFACE_TYPE_QUARTZ: The surface is of type quartz, since 1.2 _SURFACE_TYPE_WIN32: The surface is of type win32, since 1.2 _SURFACE_TYPE_BEOS: The surface is of type beos, since 1.2, deprecated 1.18 (beos support have been removed, this surface type will never be set by cairo) _SURFACE_TYPE_DIRECTFB: The surface is of type directfb, since 1.2, deprecated 1.18 (directfb support have been removed, this surface type will never be set by cairo) _SURFACE_TYPE_SVG: The surface is of type svg, since 1.2 _SURFACE_TYPE_OS2: The surface is of type os2, since 1.4, deprecated 1.18 (os2 support have been removed, this surface type will never be set by cairo) _SURFACE_TYPE_WIN32_PRINTING: The surface is a win32 printing surface, since 1.6 _SURFACE_TYPE_QUARTZ_IMAGE: The surface is of type quartz_image, since 1.6 _SURFACE_TYPE_SCRIPT: The surface is of type script, since 1.10 _SURFACE_TYPE_QT: The surface is of type Qt, since 1.10, deprecated 1.18 (Ot support have been removed, this surface type will never be set by cairo) _SURFACE_TYPE_RECORDING: The surface is of type recording, since 1.10 _SURFACE_TYPE_VG: The surface is a OpenVG surface, since 1.10, deprecated 1.18 (OpenVG support have been removed, this surface type will never be set by cairo) _SURFACE_TYPE_GL: The surface is of type OpenGL, since 1.10, deprecated 1.18 (OpenGL support have been removed, this surface type will never be set by cairo) _SURFACE_TYPE_DRM: The surface is of type Direct Render Manager, since 1.10, deprecated 1.18 (DRM support have been removed, this surface type will never be set by cairo) _SURFACE_TYPE_TEE: The surface is of type 'tee' (a multiplexing surface), since 1.10 _SURFACE_TYPE_XML: The surface is of type XML (for debugging), since 1.10 _SURFACE_TYPE_SKIA: The surface is of type Skia, since 1.10, deprecated 1.18 (Skia support have been removed, this surface type will never be set by cairo) _SURFACE_TYPE_SUBSURFACE: The surface is a subsurface created with cairo_surface_create_for_rectangle(), since 1.10 _SURFACE_TYPE_COGL: This surface is of type Cogl, since 1.12, deprecated 1.18 (Cogl support have been removed, this surface type will never be set by cairo)
  */
  type cairo_surface_type_t = _cairo_surface_type
  object cairo_surface_type_t: 
    given _tag: Tag[cairo_surface_type_t] = _cairo_surface_type._tag
    inline def apply(inline o: _cairo_surface_type): cairo_surface_type_t = o
    extension (v: cairo_surface_type_t)
      inline def value: _cairo_surface_type = v

  /**
   * cairo_text_cluster_flags_t: _TEXT_CLUSTER_FLAG_BACKWARD: The clusters in the cluster array map to glyphs in the glyph array from end to start. (Since 1.8)
  */
  type cairo_text_cluster_flags_t = _cairo_text_cluster_flags
  object cairo_text_cluster_flags_t: 
    given _tag: Tag[cairo_text_cluster_flags_t] = _cairo_text_cluster_flags._tag
    inline def apply(inline o: _cairo_text_cluster_flags): cairo_text_cluster_flags_t = o
    extension (v: cairo_text_cluster_flags_t)
      inline def value: _cairo_text_cluster_flags = v

  /**
   * cairo_user_scaled_font_init_func_t: _font: the scaled-font being created : a cairo context, in font space : font extents to fill in, in font space
  */
  opaque type cairo_user_scaled_font_init_func_t = CFuncPtr3[Ptr[cairo_scaled_font_t], Ptr[cairo_t], Ptr[cairo_font_extents_t], cairo_status_t]
  object cairo_user_scaled_font_init_func_t: 
    given _tag: Tag[cairo_user_scaled_font_init_func_t] = Tag.materializeCFuncPtr3[Ptr[cairo_scaled_font_t], Ptr[cairo_t], Ptr[cairo_font_extents_t], cairo_status_t]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): cairo_user_scaled_font_init_func_t = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr3[Ptr[cairo_scaled_font_t], Ptr[cairo_t], Ptr[cairo_font_extents_t], cairo_status_t]): cairo_user_scaled_font_init_func_t = o
    extension (v: cairo_user_scaled_font_init_func_t)
      inline def value: CFuncPtr3[Ptr[cairo_scaled_font_t], Ptr[cairo_t], Ptr[cairo_font_extents_t], cairo_status_t] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * cairo_user_scaled_font_render_glyph_func_t: _font: user scaled-font : glyph code to render : cairo context to draw to, in font space : glyph extents to fill in, in font space
  */
  opaque type cairo_user_scaled_font_render_glyph_func_t = CFuncPtr4[Ptr[cairo_scaled_font_t], CUnsignedLongInt, Ptr[cairo_t], Ptr[cairo_text_extents_t], cairo_status_t]
  object cairo_user_scaled_font_render_glyph_func_t: 
    given _tag: Tag[cairo_user_scaled_font_render_glyph_func_t] = Tag.materializeCFuncPtr4[Ptr[cairo_scaled_font_t], CUnsignedLongInt, Ptr[cairo_t], Ptr[cairo_text_extents_t], cairo_status_t]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): cairo_user_scaled_font_render_glyph_func_t = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr4[Ptr[cairo_scaled_font_t], CUnsignedLongInt, Ptr[cairo_t], Ptr[cairo_text_extents_t], cairo_status_t]): cairo_user_scaled_font_render_glyph_func_t = o
    extension (v: cairo_user_scaled_font_render_glyph_func_t)
      inline def value: CFuncPtr4[Ptr[cairo_scaled_font_t], CUnsignedLongInt, Ptr[cairo_t], Ptr[cairo_text_extents_t], cairo_status_t] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * cairo_user_scaled_font_text_to_glyphs_func_t: _font: the scaled-font being created : a string of text encoded in UTF-8 _len: length of in bytes : pointer to array of glyphs to fill, in font space : pointer to array of cluster mapping information to fill, or %NULL _flags: pointer to location to store cluster flags corresponding to the output
  */
  opaque type cairo_user_scaled_font_text_to_glyphs_func_t = CFuncPtr8[Ptr[cairo_scaled_font_t], CString, CInt, Ptr[Ptr[cairo_glyph_t]], Ptr[CInt], Ptr[Ptr[cairo_text_cluster_t]], Ptr[CInt], Ptr[cairo_text_cluster_flags_t], cairo_status_t]
  object cairo_user_scaled_font_text_to_glyphs_func_t: 
    given _tag: Tag[cairo_user_scaled_font_text_to_glyphs_func_t] = Tag.materializeCFuncPtr8[Ptr[cairo_scaled_font_t], CString, CInt, Ptr[Ptr[cairo_glyph_t]], Ptr[CInt], Ptr[Ptr[cairo_text_cluster_t]], Ptr[CInt], Ptr[cairo_text_cluster_flags_t], cairo_status_t]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): cairo_user_scaled_font_text_to_glyphs_func_t = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr8[Ptr[cairo_scaled_font_t], CString, CInt, Ptr[Ptr[cairo_glyph_t]], Ptr[CInt], Ptr[Ptr[cairo_text_cluster_t]], Ptr[CInt], Ptr[cairo_text_cluster_flags_t], cairo_status_t]): cairo_user_scaled_font_text_to_glyphs_func_t = o
    extension (v: cairo_user_scaled_font_text_to_glyphs_func_t)
      inline def value: CFuncPtr8[Ptr[cairo_scaled_font_t], CString, CInt, Ptr[Ptr[cairo_glyph_t]], Ptr[CInt], Ptr[Ptr[cairo_text_cluster_t]], Ptr[CInt], Ptr[cairo_text_cluster_flags_t], cairo_status_t] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * cairo_user_scaled_font_unicode_to_glyph_func_t: _font: the scaled-font being created : input unicode character code-point _index: output glyph index
  */
  opaque type cairo_user_scaled_font_unicode_to_glyph_func_t = CFuncPtr3[Ptr[cairo_scaled_font_t], CUnsignedLongInt, Ptr[CUnsignedLongInt], cairo_status_t]
  object cairo_user_scaled_font_unicode_to_glyph_func_t: 
    given _tag: Tag[cairo_user_scaled_font_unicode_to_glyph_func_t] = Tag.materializeCFuncPtr3[Ptr[cairo_scaled_font_t], CUnsignedLongInt, Ptr[CUnsignedLongInt], cairo_status_t]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): cairo_user_scaled_font_unicode_to_glyph_func_t = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr3[Ptr[cairo_scaled_font_t], CUnsignedLongInt, Ptr[CUnsignedLongInt], cairo_status_t]): cairo_user_scaled_font_unicode_to_glyph_func_t = o
    extension (v: cairo_user_scaled_font_unicode_to_glyph_func_t)
      inline def value: CFuncPtr3[Ptr[cairo_scaled_font_t], CUnsignedLongInt, Ptr[CUnsignedLongInt], cairo_status_t] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  /**
   * cairo_write_func_t: : the output closure
  */
  opaque type cairo_write_func_t = CFuncPtr3[Ptr[Byte], Ptr[CUnsignedChar], CUnsignedInt, cairo_status_t]
  object cairo_write_func_t: 
    given _tag: Tag[cairo_write_func_t] = Tag.materializeCFuncPtr3[Ptr[Byte], Ptr[CUnsignedChar], CUnsignedInt, cairo_status_t]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): cairo_write_func_t = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr3[Ptr[Byte], Ptr[CUnsignedChar], CUnsignedInt, cairo_status_t]): cairo_write_func_t = o
    extension (v: cairo_write_func_t)
      inline def value: CFuncPtr3[Ptr[Byte], Ptr[CUnsignedChar], CUnsignedInt, cairo_status_t] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  type ptrdiff_t = libc.stddef.ptrdiff_t
  object ptrdiff_t: 
    val _tag: Tag[ptrdiff_t] = summon[Tag[libc.stddef.ptrdiff_t]]
    inline def apply(inline o: libc.stddef.ptrdiff_t): ptrdiff_t = o
    extension (v: ptrdiff_t)
      inline def value: libc.stddef.ptrdiff_t = v

  type size_t = libc.stddef.size_t
  object size_t: 
    val _tag: Tag[size_t] = summon[Tag[libc.stddef.size_t]]
    inline def apply(inline o: libc.stddef.size_t): size_t = o
    extension (v: size_t)
      inline def value: libc.stddef.size_t = v

  type stat = posix.sys.stat.stat
  object stat: 
    val _tag: Tag[stat] = summon[Tag[posix.sys.stat.stat]]
    inline def apply(inline o: posix.sys.stat.stat): stat = o
    extension (v: stat)
      inline def value: posix.sys.stat.stat = v

  type va_list = unsafe.CVarArgList
  object va_list: 
    val _tag: Tag[va_list] = summon[Tag[unsafe.CVarArgList]]
    inline def apply(inline o: unsafe.CVarArgList): va_list = o
    extension (v: va_list)
      inline def value: unsafe.CVarArgList = v

object structs:
  import _root_.cairo.enumerations.*
  import _root_.cairo.predef.*
  import _root_.cairo.aliases.*
  import _root_.cairo.structs.*
  import _root_.cairo.unions.*
  /**
   * ************************************************************************
  */
  opaque type FT_BBox = CStruct4[FT_Pos, FT_Pos, FT_Pos, FT_Pos]
  object FT_BBox:
    given _tag: Tag[FT_BBox] = Tag.materializeCStruct4Tag[FT_Pos, FT_Pos, FT_Pos, FT_Pos]
    def apply()(using Zone): Ptr[FT_BBox] = scala.scalanative.unsafe.alloc[FT_BBox](1)
    def apply(xMin : FT_Pos, yMin : FT_Pos, xMax : FT_Pos, yMax : FT_Pos)(using Zone): Ptr[FT_BBox] = 
      val ____ptr = apply()
      (!____ptr).xMin = xMin
      (!____ptr).yMin = yMin
      (!____ptr).xMax = xMax
      (!____ptr).yMax = yMax
      ____ptr
    extension (struct: FT_BBox)
      def xMin : FT_Pos = struct._1
      def xMin_=(value: FT_Pos): Unit = !struct.at1 = value
      def yMin : FT_Pos = struct._2
      def yMin_=(value: FT_Pos): Unit = !struct.at2 = value
      def xMax : FT_Pos = struct._3
      def xMax_=(value: FT_Pos): Unit = !struct.at3 = value
      def yMax : FT_Pos = struct._4
      def yMax_=(value: FT_Pos): Unit = !struct.at4 = value

  /**
   * ************************************************************************
  */
  opaque type FT_BBox_ = CStruct4[FT_Pos, FT_Pos, FT_Pos, FT_Pos]
  object FT_BBox_ :
    given _tag: Tag[FT_BBox_] = Tag.materializeCStruct4Tag[FT_Pos, FT_Pos, FT_Pos, FT_Pos]
    def apply()(using Zone): Ptr[FT_BBox_] = scala.scalanative.unsafe.alloc[FT_BBox_](1)
    def apply(xMin : FT_Pos, yMin : FT_Pos, xMax : FT_Pos, yMax : FT_Pos)(using Zone): Ptr[FT_BBox_] = 
      val ____ptr = apply()
      (!____ptr).xMin = xMin
      (!____ptr).yMin = yMin
      (!____ptr).xMax = xMax
      (!____ptr).yMax = yMax
      ____ptr
    extension (struct: FT_BBox_)
      def xMin : FT_Pos = struct._1
      def xMin_=(value: FT_Pos): Unit = !struct.at1 = value
      def yMin : FT_Pos = struct._2
      def yMin_=(value: FT_Pos): Unit = !struct.at2 = value
      def xMax : FT_Pos = struct._3
      def xMax_=(value: FT_Pos): Unit = !struct.at3 = value
      def yMax : FT_Pos = struct._4
      def yMax_=(value: FT_Pos): Unit = !struct.at4 = value

  /**
   * ************************************************************************
  */
  opaque type FT_Bitmap = CStruct8[CUnsignedInt, CUnsignedInt, CInt, Ptr[CUnsignedChar], CUnsignedShort, CUnsignedChar, CUnsignedChar, Ptr[Byte]]
  object FT_Bitmap:
    given _tag: Tag[FT_Bitmap] = Tag.materializeCStruct8Tag[CUnsignedInt, CUnsignedInt, CInt, Ptr[CUnsignedChar], CUnsignedShort, CUnsignedChar, CUnsignedChar, Ptr[Byte]]
    def apply()(using Zone): Ptr[FT_Bitmap] = scala.scalanative.unsafe.alloc[FT_Bitmap](1)
    def apply(rows : CUnsignedInt, width : CUnsignedInt, pitch : CInt, buffer : Ptr[CUnsignedChar], num_grays : CUnsignedShort, pixel_mode : CUnsignedChar, palette_mode : CUnsignedChar, palette : Ptr[Byte])(using Zone): Ptr[FT_Bitmap] = 
      val ____ptr = apply()
      (!____ptr).rows = rows
      (!____ptr).width = width
      (!____ptr).pitch = pitch
      (!____ptr).buffer = buffer
      (!____ptr).num_grays = num_grays
      (!____ptr).pixel_mode = pixel_mode
      (!____ptr).palette_mode = palette_mode
      (!____ptr).palette = palette
      ____ptr
    extension (struct: FT_Bitmap)
      def rows : CUnsignedInt = struct._1
      def rows_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def width : CUnsignedInt = struct._2
      def width_=(value: CUnsignedInt): Unit = !struct.at2 = value
      def pitch : CInt = struct._3
      def pitch_=(value: CInt): Unit = !struct.at3 = value
      def buffer : Ptr[CUnsignedChar] = struct._4
      def buffer_=(value: Ptr[CUnsignedChar]): Unit = !struct.at4 = value
      def num_grays : CUnsignedShort = struct._5
      def num_grays_=(value: CUnsignedShort): Unit = !struct.at5 = value
      def pixel_mode : CUnsignedChar = struct._6
      def pixel_mode_=(value: CUnsignedChar): Unit = !struct.at6 = value
      def palette_mode : CUnsignedChar = struct._7
      def palette_mode_=(value: CUnsignedChar): Unit = !struct.at7 = value
      def palette : Ptr[Byte] = struct._8
      def palette_=(value: Ptr[Byte]): Unit = !struct.at8 = value

  /**
   * ************************************************************************
  */
  opaque type FT_Bitmap_ = CStruct8[CUnsignedInt, CUnsignedInt, CInt, Ptr[CUnsignedChar], CUnsignedShort, CUnsignedChar, CUnsignedChar, Ptr[Byte]]
  object FT_Bitmap_ :
    given _tag: Tag[FT_Bitmap_] = Tag.materializeCStruct8Tag[CUnsignedInt, CUnsignedInt, CInt, Ptr[CUnsignedChar], CUnsignedShort, CUnsignedChar, CUnsignedChar, Ptr[Byte]]
    def apply()(using Zone): Ptr[FT_Bitmap_] = scala.scalanative.unsafe.alloc[FT_Bitmap_](1)
    def apply(rows : CUnsignedInt, width : CUnsignedInt, pitch : CInt, buffer : Ptr[CUnsignedChar], num_grays : CUnsignedShort, pixel_mode : CUnsignedChar, palette_mode : CUnsignedChar, palette : Ptr[Byte])(using Zone): Ptr[FT_Bitmap_] = 
      val ____ptr = apply()
      (!____ptr).rows = rows
      (!____ptr).width = width
      (!____ptr).pitch = pitch
      (!____ptr).buffer = buffer
      (!____ptr).num_grays = num_grays
      (!____ptr).pixel_mode = pixel_mode
      (!____ptr).palette_mode = palette_mode
      (!____ptr).palette = palette
      ____ptr
    extension (struct: FT_Bitmap_)
      def rows : CUnsignedInt = struct._1
      def rows_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def width : CUnsignedInt = struct._2
      def width_=(value: CUnsignedInt): Unit = !struct.at2 = value
      def pitch : CInt = struct._3
      def pitch_=(value: CInt): Unit = !struct.at3 = value
      def buffer : Ptr[CUnsignedChar] = struct._4
      def buffer_=(value: Ptr[CUnsignedChar]): Unit = !struct.at4 = value
      def num_grays : CUnsignedShort = struct._5
      def num_grays_=(value: CUnsignedShort): Unit = !struct.at5 = value
      def pixel_mode : CUnsignedChar = struct._6
      def pixel_mode_=(value: CUnsignedChar): Unit = !struct.at6 = value
      def palette_mode : CUnsignedChar = struct._7
      def palette_mode_=(value: CUnsignedChar): Unit = !struct.at7 = value
      def palette : Ptr[Byte] = struct._8
      def palette_=(value: Ptr[Byte]): Unit = !struct.at8 = value

  /**
   * ************************************************************************
  */
  opaque type FT_Bitmap_Size = CStruct5[FT_Short, FT_Short, FT_Pos, FT_Pos, FT_Pos]
  object FT_Bitmap_Size:
    given _tag: Tag[FT_Bitmap_Size] = Tag.materializeCStruct5Tag[FT_Short, FT_Short, FT_Pos, FT_Pos, FT_Pos]
    def apply()(using Zone): Ptr[FT_Bitmap_Size] = scala.scalanative.unsafe.alloc[FT_Bitmap_Size](1)
    def apply(height : FT_Short, width : FT_Short, size : FT_Pos, x_ppem : FT_Pos, y_ppem : FT_Pos)(using Zone): Ptr[FT_Bitmap_Size] = 
      val ____ptr = apply()
      (!____ptr).height = height
      (!____ptr).width = width
      (!____ptr).size = size
      (!____ptr).x_ppem = x_ppem
      (!____ptr).y_ppem = y_ppem
      ____ptr
    extension (struct: FT_Bitmap_Size)
      def height : FT_Short = struct._1
      def height_=(value: FT_Short): Unit = !struct.at1 = value
      def width : FT_Short = struct._2
      def width_=(value: FT_Short): Unit = !struct.at2 = value
      def size : FT_Pos = struct._3
      def size_=(value: FT_Pos): Unit = !struct.at3 = value
      def x_ppem : FT_Pos = struct._4
      def x_ppem_=(value: FT_Pos): Unit = !struct.at4 = value
      def y_ppem : FT_Pos = struct._5
      def y_ppem_=(value: FT_Pos): Unit = !struct.at5 = value

  /**
   * ************************************************************************
  */
  opaque type FT_Bitmap_Size_ = CStruct5[FT_Short, FT_Short, FT_Pos, FT_Pos, FT_Pos]
  object FT_Bitmap_Size_ :
    given _tag: Tag[FT_Bitmap_Size_] = Tag.materializeCStruct5Tag[FT_Short, FT_Short, FT_Pos, FT_Pos, FT_Pos]
    def apply()(using Zone): Ptr[FT_Bitmap_Size_] = scala.scalanative.unsafe.alloc[FT_Bitmap_Size_](1)
    def apply(height : FT_Short, width : FT_Short, size : FT_Pos, x_ppem : FT_Pos, y_ppem : FT_Pos)(using Zone): Ptr[FT_Bitmap_Size_] = 
      val ____ptr = apply()
      (!____ptr).height = height
      (!____ptr).width = width
      (!____ptr).size = size
      (!____ptr).x_ppem = x_ppem
      (!____ptr).y_ppem = y_ppem
      ____ptr
    extension (struct: FT_Bitmap_Size_)
      def height : FT_Short = struct._1
      def height_=(value: FT_Short): Unit = !struct.at1 = value
      def width : FT_Short = struct._2
      def width_=(value: FT_Short): Unit = !struct.at2 = value
      def size : FT_Pos = struct._3
      def size_=(value: FT_Pos): Unit = !struct.at3 = value
      def x_ppem : FT_Pos = struct._4
      def x_ppem_=(value: FT_Pos): Unit = !struct.at4 = value
      def y_ppem : FT_Pos = struct._5
      def y_ppem_=(value: FT_Pos): Unit = !struct.at5 = value

  /**
   * ************************************************************************
  */
  opaque type FT_CharMapRec = CStruct4[FT_Face, FT_Encoding, FT_UShort, FT_UShort]
  object FT_CharMapRec:
    given _tag: Tag[FT_CharMapRec] = Tag.materializeCStruct4Tag[FT_Face, FT_Encoding, FT_UShort, FT_UShort]
    def apply()(using Zone): Ptr[FT_CharMapRec] = scala.scalanative.unsafe.alloc[FT_CharMapRec](1)
    def apply(face : FT_Face, encoding : FT_Encoding, platform_id : FT_UShort, encoding_id : FT_UShort)(using Zone): Ptr[FT_CharMapRec] = 
      val ____ptr = apply()
      (!____ptr).face = face
      (!____ptr).encoding = encoding
      (!____ptr).platform_id = platform_id
      (!____ptr).encoding_id = encoding_id
      ____ptr
    extension (struct: FT_CharMapRec)
      def face : FT_Face = struct._1
      def face_=(value: FT_Face): Unit = !struct.at1 = value
      def encoding : FT_Encoding = struct._2
      def encoding_=(value: FT_Encoding): Unit = !struct.at2 = value
      def platform_id : FT_UShort = struct._3
      def platform_id_=(value: FT_UShort): Unit = !struct.at3 = value
      def encoding_id : FT_UShort = struct._4
      def encoding_id_=(value: FT_UShort): Unit = !struct.at4 = value

  /**
   * ************************************************************************
  */
  opaque type FT_CharMapRec_ = CStruct4[FT_Face, FT_Encoding, FT_UShort, FT_UShort]
  object FT_CharMapRec_ :
    given _tag: Tag[FT_CharMapRec_] = Tag.materializeCStruct4Tag[FT_Face, FT_Encoding, FT_UShort, FT_UShort]
    def apply()(using Zone): Ptr[FT_CharMapRec_] = scala.scalanative.unsafe.alloc[FT_CharMapRec_](1)
    def apply(face : FT_Face, encoding : FT_Encoding, platform_id : FT_UShort, encoding_id : FT_UShort)(using Zone): Ptr[FT_CharMapRec_] = 
      val ____ptr = apply()
      (!____ptr).face = face
      (!____ptr).encoding = encoding
      (!____ptr).platform_id = platform_id
      (!____ptr).encoding_id = encoding_id
      ____ptr
    extension (struct: FT_CharMapRec_)
      def face : FT_Face = struct._1
      def face_=(value: FT_Face): Unit = !struct.at1 = value
      def encoding : FT_Encoding = struct._2
      def encoding_=(value: FT_Encoding): Unit = !struct.at2 = value
      def platform_id : FT_UShort = struct._3
      def platform_id_=(value: FT_UShort): Unit = !struct.at3 = value
      def encoding_id : FT_UShort = struct._4
      def encoding_id_=(value: FT_UShort): Unit = !struct.at4 = value

  /**
   * ************************************************************************
  */
  opaque type FT_Data = CStruct2[Ptr[FT_Byte], FT_UInt]
  object FT_Data:
    given _tag: Tag[FT_Data] = Tag.materializeCStruct2Tag[Ptr[FT_Byte], FT_UInt]
    def apply()(using Zone): Ptr[FT_Data] = scala.scalanative.unsafe.alloc[FT_Data](1)
    def apply(pointer : Ptr[FT_Byte], length : FT_UInt)(using Zone): Ptr[FT_Data] = 
      val ____ptr = apply()
      (!____ptr).pointer = pointer
      (!____ptr).length = length
      ____ptr
    extension (struct: FT_Data)
      def pointer : Ptr[FT_Byte] = struct._1
      def pointer_=(value: Ptr[FT_Byte]): Unit = !struct.at1 = value
      def length : FT_UInt = struct._2
      def length_=(value: FT_UInt): Unit = !struct.at2 = value

  /**
   * ************************************************************************
  */
  opaque type FT_Data_ = CStruct2[Ptr[FT_Byte], FT_UInt]
  object FT_Data_ :
    given _tag: Tag[FT_Data_] = Tag.materializeCStruct2Tag[Ptr[FT_Byte], FT_UInt]
    def apply()(using Zone): Ptr[FT_Data_] = scala.scalanative.unsafe.alloc[FT_Data_](1)
    def apply(pointer : Ptr[FT_Byte], length : FT_UInt)(using Zone): Ptr[FT_Data_] = 
      val ____ptr = apply()
      (!____ptr).pointer = pointer
      (!____ptr).length = length
      ____ptr
    extension (struct: FT_Data_)
      def pointer : Ptr[FT_Byte] = struct._1
      def pointer_=(value: Ptr[FT_Byte]): Unit = !struct.at1 = value
      def length : FT_UInt = struct._2
      def length_=(value: FT_UInt): Unit = !struct.at2 = value

  opaque type FT_DriverRec_ = CStruct0
  object FT_DriverRec_ :
    given _tag: Tag[FT_DriverRec_] = Tag.materializeCStruct0Tag

  opaque type FT_FaceRec = CArray[CChar, Nat.Digit3[Nat._2, Nat._4, Nat._8]]
  object FT_FaceRec:
    given _tag: Tag[FT_FaceRec] = Tag.CArray[CChar, Nat.Digit3[Nat._2, Nat._4, Nat._8]](Tag.Byte, Tag.Digit3[Nat._2, Nat._4, Nat._8](Tag.Nat2, Tag.Nat4, Tag.Nat8))
    def apply()(using Zone): Ptr[FT_FaceRec] = scala.scalanative.unsafe.alloc[FT_FaceRec](1)
    def apply(num_faces : FT_Long, face_index : FT_Long, face_flags : FT_Long, style_flags : FT_Long, num_glyphs : FT_Long, family_name : Ptr[FT_String], style_name : Ptr[FT_String], num_fixed_sizes : FT_Int, available_sizes : Ptr[FT_Bitmap_Size], num_charmaps : FT_Int, charmaps : Ptr[FT_CharMap], generic : FT_Generic, bbox : FT_BBox, units_per_EM : FT_UShort, ascender : FT_Short, descender : FT_Short, height : FT_Short, max_advance_width : FT_Short, max_advance_height : FT_Short, underline_position : FT_Short, underline_thickness : FT_Short, glyph : FT_GlyphSlot, size : FT_Size, charmap : FT_CharMap, driver : FT_Driver, memory : FT_Memory, stream : FT_Stream, sizes_list : FT_ListRec, autohint : FT_Generic, extensions : Ptr[Byte], internal : FT_Face_Internal)(using Zone): Ptr[FT_FaceRec] = 
      val ____ptr = apply()
      (!____ptr).num_faces = num_faces
      (!____ptr).face_index = face_index
      (!____ptr).face_flags = face_flags
      (!____ptr).style_flags = style_flags
      (!____ptr).num_glyphs = num_glyphs
      (!____ptr).family_name = family_name
      (!____ptr).style_name = style_name
      (!____ptr).num_fixed_sizes = num_fixed_sizes
      (!____ptr).available_sizes = available_sizes
      (!____ptr).num_charmaps = num_charmaps
      (!____ptr).charmaps = charmaps
      (!____ptr).generic = generic
      (!____ptr).bbox = bbox
      (!____ptr).units_per_EM = units_per_EM
      (!____ptr).ascender = ascender
      (!____ptr).descender = descender
      (!____ptr).height = height
      (!____ptr).max_advance_width = max_advance_width
      (!____ptr).max_advance_height = max_advance_height
      (!____ptr).underline_position = underline_position
      (!____ptr).underline_thickness = underline_thickness
      (!____ptr).glyph = glyph
      (!____ptr).size = size
      (!____ptr).charmap = charmap
      (!____ptr).driver = driver
      (!____ptr).memory = memory
      (!____ptr).stream = stream
      (!____ptr).sizes_list = sizes_list
      (!____ptr).autohint = autohint
      (!____ptr).extensions = extensions
      (!____ptr).internal = internal
      ____ptr
    extension (struct: FT_FaceRec)
      def num_faces: FT_Long = !struct.at(offsets(0)).asInstanceOf[Ptr[FT_Long]]
      def num_faces_=(value: FT_Long): Unit = !struct.at(offsets(0)).asInstanceOf[Ptr[FT_Long]] = value
      def face_index: FT_Long = !struct.at(offsets(1)).asInstanceOf[Ptr[FT_Long]]
      def face_index_=(value: FT_Long): Unit = !struct.at(offsets(1)).asInstanceOf[Ptr[FT_Long]] = value
      def face_flags: FT_Long = !struct.at(offsets(2)).asInstanceOf[Ptr[FT_Long]]
      def face_flags_=(value: FT_Long): Unit = !struct.at(offsets(2)).asInstanceOf[Ptr[FT_Long]] = value
      def style_flags: FT_Long = !struct.at(offsets(3)).asInstanceOf[Ptr[FT_Long]]
      def style_flags_=(value: FT_Long): Unit = !struct.at(offsets(3)).asInstanceOf[Ptr[FT_Long]] = value
      def num_glyphs: FT_Long = !struct.at(offsets(4)).asInstanceOf[Ptr[FT_Long]]
      def num_glyphs_=(value: FT_Long): Unit = !struct.at(offsets(4)).asInstanceOf[Ptr[FT_Long]] = value
      def family_name: Ptr[FT_String] = !struct.at(offsets(5)).asInstanceOf[Ptr[Ptr[FT_String]]]
      def family_name_=(value: Ptr[FT_String]): Unit = !struct.at(offsets(5)).asInstanceOf[Ptr[Ptr[FT_String]]] = value
      def style_name: Ptr[FT_String] = !struct.at(offsets(6)).asInstanceOf[Ptr[Ptr[FT_String]]]
      def style_name_=(value: Ptr[FT_String]): Unit = !struct.at(offsets(6)).asInstanceOf[Ptr[Ptr[FT_String]]] = value
      def num_fixed_sizes: FT_Int = !struct.at(offsets(7)).asInstanceOf[Ptr[FT_Int]]
      def num_fixed_sizes_=(value: FT_Int): Unit = !struct.at(offsets(7)).asInstanceOf[Ptr[FT_Int]] = value
      def available_sizes: Ptr[FT_Bitmap_Size] = !struct.at(offsets(8)).asInstanceOf[Ptr[Ptr[FT_Bitmap_Size]]]
      def available_sizes_=(value: Ptr[FT_Bitmap_Size]): Unit = !struct.at(offsets(8)).asInstanceOf[Ptr[Ptr[FT_Bitmap_Size]]] = value
      def num_charmaps: FT_Int = !struct.at(offsets(9)).asInstanceOf[Ptr[FT_Int]]
      def num_charmaps_=(value: FT_Int): Unit = !struct.at(offsets(9)).asInstanceOf[Ptr[FT_Int]] = value
      def charmaps: Ptr[FT_CharMap] = !struct.at(offsets(10)).asInstanceOf[Ptr[Ptr[FT_CharMap]]]
      def charmaps_=(value: Ptr[FT_CharMap]): Unit = !struct.at(offsets(10)).asInstanceOf[Ptr[Ptr[FT_CharMap]]] = value
      def generic: FT_Generic = !struct.at(offsets(11)).asInstanceOf[Ptr[FT_Generic]]
      def generic_=(value: FT_Generic): Unit = !struct.at(offsets(11)).asInstanceOf[Ptr[FT_Generic]] = value
      def bbox: FT_BBox = !struct.at(offsets(12)).asInstanceOf[Ptr[FT_BBox]]
      def bbox_=(value: FT_BBox): Unit = !struct.at(offsets(12)).asInstanceOf[Ptr[FT_BBox]] = value
      def units_per_EM: FT_UShort = !struct.at(offsets(13)).asInstanceOf[Ptr[FT_UShort]]
      def units_per_EM_=(value: FT_UShort): Unit = !struct.at(offsets(13)).asInstanceOf[Ptr[FT_UShort]] = value
      def ascender: FT_Short = !struct.at(offsets(14)).asInstanceOf[Ptr[FT_Short]]
      def ascender_=(value: FT_Short): Unit = !struct.at(offsets(14)).asInstanceOf[Ptr[FT_Short]] = value
      def descender: FT_Short = !struct.at(offsets(15)).asInstanceOf[Ptr[FT_Short]]
      def descender_=(value: FT_Short): Unit = !struct.at(offsets(15)).asInstanceOf[Ptr[FT_Short]] = value
      def height: FT_Short = !struct.at(offsets(16)).asInstanceOf[Ptr[FT_Short]]
      def height_=(value: FT_Short): Unit = !struct.at(offsets(16)).asInstanceOf[Ptr[FT_Short]] = value
      def max_advance_width: FT_Short = !struct.at(offsets(17)).asInstanceOf[Ptr[FT_Short]]
      def max_advance_width_=(value: FT_Short): Unit = !struct.at(offsets(17)).asInstanceOf[Ptr[FT_Short]] = value
      def max_advance_height: FT_Short = !struct.at(offsets(18)).asInstanceOf[Ptr[FT_Short]]
      def max_advance_height_=(value: FT_Short): Unit = !struct.at(offsets(18)).asInstanceOf[Ptr[FT_Short]] = value
      def underline_position: FT_Short = !struct.at(offsets(19)).asInstanceOf[Ptr[FT_Short]]
      def underline_position_=(value: FT_Short): Unit = !struct.at(offsets(19)).asInstanceOf[Ptr[FT_Short]] = value
      def underline_thickness: FT_Short = !struct.at(offsets(20)).asInstanceOf[Ptr[FT_Short]]
      def underline_thickness_=(value: FT_Short): Unit = !struct.at(offsets(20)).asInstanceOf[Ptr[FT_Short]] = value
      def glyph: FT_GlyphSlot = !struct.at(offsets(21)).asInstanceOf[Ptr[FT_GlyphSlot]]
      def glyph_=(value: FT_GlyphSlot): Unit = !struct.at(offsets(21)).asInstanceOf[Ptr[FT_GlyphSlot]] = value
      def size: FT_Size = !struct.at(offsets(22)).asInstanceOf[Ptr[FT_Size]]
      def size_=(value: FT_Size): Unit = !struct.at(offsets(22)).asInstanceOf[Ptr[FT_Size]] = value
      def charmap: FT_CharMap = !struct.at(offsets(23)).asInstanceOf[Ptr[FT_CharMap]]
      def charmap_=(value: FT_CharMap): Unit = !struct.at(offsets(23)).asInstanceOf[Ptr[FT_CharMap]] = value
      def driver: FT_Driver = !struct.at(offsets(24)).asInstanceOf[Ptr[FT_Driver]]
      def driver_=(value: FT_Driver): Unit = !struct.at(offsets(24)).asInstanceOf[Ptr[FT_Driver]] = value
      def memory: FT_Memory = !struct.at(offsets(25)).asInstanceOf[Ptr[FT_Memory]]
      def memory_=(value: FT_Memory): Unit = !struct.at(offsets(25)).asInstanceOf[Ptr[FT_Memory]] = value
      def stream: FT_Stream = !struct.at(offsets(26)).asInstanceOf[Ptr[FT_Stream]]
      def stream_=(value: FT_Stream): Unit = !struct.at(offsets(26)).asInstanceOf[Ptr[FT_Stream]] = value
      def sizes_list: FT_ListRec = !struct.at(offsets(27)).asInstanceOf[Ptr[FT_ListRec]]
      def sizes_list_=(value: FT_ListRec): Unit = !struct.at(offsets(27)).asInstanceOf[Ptr[FT_ListRec]] = value
      def autohint: FT_Generic = !struct.at(offsets(28)).asInstanceOf[Ptr[FT_Generic]]
      def autohint_=(value: FT_Generic): Unit = !struct.at(offsets(28)).asInstanceOf[Ptr[FT_Generic]] = value
      def extensions: Ptr[Byte] = !struct.at(offsets(29)).asInstanceOf[Ptr[Ptr[Byte]]]
      def extensions_=(value: Ptr[Byte]): Unit = !struct.at(offsets(29)).asInstanceOf[Ptr[Ptr[Byte]]] = value
      def internal: FT_Face_Internal = !struct.at(offsets(30)).asInstanceOf[Ptr[FT_Face_Internal]]
      def internal_=(value: FT_Face_Internal): Unit = !struct.at(offsets(30)).asInstanceOf[Ptr[FT_Face_Internal]] = value
    val offsets: Array[Int] = 
      val res = Array.ofDim[Int](31)
      def align(offset: Int, alignment: Int) = {
        val alignmentMask = alignment - 1
        val padding =
          if ((offset & alignmentMask) == 0) 0
          else alignment - (offset & alignmentMask)
        offset + padding
      }
      
      res(0) = align(0, alignmentof[FT_Long].toInt)
      res(1) = align(res(0) + sizeof[FT_Long].toInt, alignmentof[FT_Long].toInt)
      res(2) = align(res(1) + sizeof[FT_Long].toInt, alignmentof[FT_Long].toInt)
      res(3) = align(res(2) + sizeof[FT_Long].toInt, alignmentof[FT_Long].toInt)
      res(4) = align(res(3) + sizeof[FT_Long].toInt, alignmentof[FT_Long].toInt)
      res(5) = align(res(4) + sizeof[FT_Long].toInt, alignmentof[Ptr[FT_String]].toInt)
      res(6) = align(res(5) + sizeof[Ptr[FT_String]].toInt, alignmentof[Ptr[FT_String]].toInt)
      res(7) = align(res(6) + sizeof[Ptr[FT_String]].toInt, alignmentof[FT_Int].toInt)
      res(8) = align(res(7) + sizeof[FT_Int].toInt, alignmentof[Ptr[FT_Bitmap_Size]].toInt)
      res(9) = align(res(8) + sizeof[Ptr[FT_Bitmap_Size]].toInt, alignmentof[FT_Int].toInt)
      res(10) = align(res(9) + sizeof[FT_Int].toInt, alignmentof[Ptr[FT_CharMap]].toInt)
      res(11) = align(res(10) + sizeof[Ptr[FT_CharMap]].toInt, alignmentof[FT_Generic].toInt)
      res(12) = align(res(11) + sizeof[FT_Generic].toInt, alignmentof[FT_BBox].toInt)
      res(13) = align(res(12) + sizeof[FT_BBox].toInt, alignmentof[FT_UShort].toInt)
      res(14) = align(res(13) + sizeof[FT_UShort].toInt, alignmentof[FT_Short].toInt)
      res(15) = align(res(14) + sizeof[FT_Short].toInt, alignmentof[FT_Short].toInt)
      res(16) = align(res(15) + sizeof[FT_Short].toInt, alignmentof[FT_Short].toInt)
      res(17) = align(res(16) + sizeof[FT_Short].toInt, alignmentof[FT_Short].toInt)
      res(18) = align(res(17) + sizeof[FT_Short].toInt, alignmentof[FT_Short].toInt)
      res(19) = align(res(18) + sizeof[FT_Short].toInt, alignmentof[FT_Short].toInt)
      res(20) = align(res(19) + sizeof[FT_Short].toInt, alignmentof[FT_Short].toInt)
      res(21) = align(res(20) + sizeof[FT_Short].toInt, alignmentof[FT_GlyphSlot].toInt)
      res(22) = align(res(21) + sizeof[FT_GlyphSlot].toInt, alignmentof[FT_Size].toInt)
      res(23) = align(res(22) + sizeof[FT_Size].toInt, alignmentof[FT_CharMap].toInt)
      res(24) = align(res(23) + sizeof[FT_CharMap].toInt, alignmentof[FT_Driver].toInt)
      res(25) = align(res(24) + sizeof[FT_Driver].toInt, alignmentof[FT_Memory].toInt)
      res(26) = align(res(25) + sizeof[FT_Memory].toInt, alignmentof[FT_Stream].toInt)
      res(27) = align(res(26) + sizeof[FT_Stream].toInt, alignmentof[FT_ListRec].toInt)
      res(28) = align(res(27) + sizeof[FT_ListRec].toInt, alignmentof[FT_Generic].toInt)
      res(29) = align(res(28) + sizeof[FT_Generic].toInt, alignmentof[Ptr[Byte]].toInt)
      res(30) = align(res(29) + sizeof[Ptr[Byte]].toInt, alignmentof[FT_Face_Internal].toInt)
      res
    end offsets

  opaque type FT_FaceRec_ = CArray[CChar, Nat.Digit3[Nat._2, Nat._4, Nat._8]]
  object FT_FaceRec_ :
    given _tag: Tag[FT_FaceRec_] = Tag.CArray[CChar, Nat.Digit3[Nat._2, Nat._4, Nat._8]](Tag.Byte, Tag.Digit3[Nat._2, Nat._4, Nat._8](Tag.Nat2, Tag.Nat4, Tag.Nat8))
    def apply()(using Zone): Ptr[FT_FaceRec_] = scala.scalanative.unsafe.alloc[FT_FaceRec_](1)
    def apply(num_faces : FT_Long, face_index : FT_Long, face_flags : FT_Long, style_flags : FT_Long, num_glyphs : FT_Long, family_name : Ptr[FT_String], style_name : Ptr[FT_String], num_fixed_sizes : FT_Int, available_sizes : Ptr[FT_Bitmap_Size], num_charmaps : FT_Int, charmaps : Ptr[FT_CharMap], generic : FT_Generic, bbox : FT_BBox, units_per_EM : FT_UShort, ascender : FT_Short, descender : FT_Short, height : FT_Short, max_advance_width : FT_Short, max_advance_height : FT_Short, underline_position : FT_Short, underline_thickness : FT_Short, glyph : FT_GlyphSlot, size : FT_Size, charmap : FT_CharMap, driver : FT_Driver, memory : FT_Memory, stream : FT_Stream, sizes_list : FT_ListRec, autohint : FT_Generic, extensions : Ptr[Byte], internal : FT_Face_Internal)(using Zone): Ptr[FT_FaceRec_] = 
      val ____ptr = apply()
      (!____ptr).num_faces = num_faces
      (!____ptr).face_index = face_index
      (!____ptr).face_flags = face_flags
      (!____ptr).style_flags = style_flags
      (!____ptr).num_glyphs = num_glyphs
      (!____ptr).family_name = family_name
      (!____ptr).style_name = style_name
      (!____ptr).num_fixed_sizes = num_fixed_sizes
      (!____ptr).available_sizes = available_sizes
      (!____ptr).num_charmaps = num_charmaps
      (!____ptr).charmaps = charmaps
      (!____ptr).generic = generic
      (!____ptr).bbox = bbox
      (!____ptr).units_per_EM = units_per_EM
      (!____ptr).ascender = ascender
      (!____ptr).descender = descender
      (!____ptr).height = height
      (!____ptr).max_advance_width = max_advance_width
      (!____ptr).max_advance_height = max_advance_height
      (!____ptr).underline_position = underline_position
      (!____ptr).underline_thickness = underline_thickness
      (!____ptr).glyph = glyph
      (!____ptr).size = size
      (!____ptr).charmap = charmap
      (!____ptr).driver = driver
      (!____ptr).memory = memory
      (!____ptr).stream = stream
      (!____ptr).sizes_list = sizes_list
      (!____ptr).autohint = autohint
      (!____ptr).extensions = extensions
      (!____ptr).internal = internal
      ____ptr
    extension (struct: FT_FaceRec_)
      def num_faces: FT_Long = !struct.at(offsets(0)).asInstanceOf[Ptr[FT_Long]]
      def num_faces_=(value: FT_Long): Unit = !struct.at(offsets(0)).asInstanceOf[Ptr[FT_Long]] = value
      def face_index: FT_Long = !struct.at(offsets(1)).asInstanceOf[Ptr[FT_Long]]
      def face_index_=(value: FT_Long): Unit = !struct.at(offsets(1)).asInstanceOf[Ptr[FT_Long]] = value
      def face_flags: FT_Long = !struct.at(offsets(2)).asInstanceOf[Ptr[FT_Long]]
      def face_flags_=(value: FT_Long): Unit = !struct.at(offsets(2)).asInstanceOf[Ptr[FT_Long]] = value
      def style_flags: FT_Long = !struct.at(offsets(3)).asInstanceOf[Ptr[FT_Long]]
      def style_flags_=(value: FT_Long): Unit = !struct.at(offsets(3)).asInstanceOf[Ptr[FT_Long]] = value
      def num_glyphs: FT_Long = !struct.at(offsets(4)).asInstanceOf[Ptr[FT_Long]]
      def num_glyphs_=(value: FT_Long): Unit = !struct.at(offsets(4)).asInstanceOf[Ptr[FT_Long]] = value
      def family_name: Ptr[FT_String] = !struct.at(offsets(5)).asInstanceOf[Ptr[Ptr[FT_String]]]
      def family_name_=(value: Ptr[FT_String]): Unit = !struct.at(offsets(5)).asInstanceOf[Ptr[Ptr[FT_String]]] = value
      def style_name: Ptr[FT_String] = !struct.at(offsets(6)).asInstanceOf[Ptr[Ptr[FT_String]]]
      def style_name_=(value: Ptr[FT_String]): Unit = !struct.at(offsets(6)).asInstanceOf[Ptr[Ptr[FT_String]]] = value
      def num_fixed_sizes: FT_Int = !struct.at(offsets(7)).asInstanceOf[Ptr[FT_Int]]
      def num_fixed_sizes_=(value: FT_Int): Unit = !struct.at(offsets(7)).asInstanceOf[Ptr[FT_Int]] = value
      def available_sizes: Ptr[FT_Bitmap_Size] = !struct.at(offsets(8)).asInstanceOf[Ptr[Ptr[FT_Bitmap_Size]]]
      def available_sizes_=(value: Ptr[FT_Bitmap_Size]): Unit = !struct.at(offsets(8)).asInstanceOf[Ptr[Ptr[FT_Bitmap_Size]]] = value
      def num_charmaps: FT_Int = !struct.at(offsets(9)).asInstanceOf[Ptr[FT_Int]]
      def num_charmaps_=(value: FT_Int): Unit = !struct.at(offsets(9)).asInstanceOf[Ptr[FT_Int]] = value
      def charmaps: Ptr[FT_CharMap] = !struct.at(offsets(10)).asInstanceOf[Ptr[Ptr[FT_CharMap]]]
      def charmaps_=(value: Ptr[FT_CharMap]): Unit = !struct.at(offsets(10)).asInstanceOf[Ptr[Ptr[FT_CharMap]]] = value
      def generic: FT_Generic = !struct.at(offsets(11)).asInstanceOf[Ptr[FT_Generic]]
      def generic_=(value: FT_Generic): Unit = !struct.at(offsets(11)).asInstanceOf[Ptr[FT_Generic]] = value
      def bbox: FT_BBox = !struct.at(offsets(12)).asInstanceOf[Ptr[FT_BBox]]
      def bbox_=(value: FT_BBox): Unit = !struct.at(offsets(12)).asInstanceOf[Ptr[FT_BBox]] = value
      def units_per_EM: FT_UShort = !struct.at(offsets(13)).asInstanceOf[Ptr[FT_UShort]]
      def units_per_EM_=(value: FT_UShort): Unit = !struct.at(offsets(13)).asInstanceOf[Ptr[FT_UShort]] = value
      def ascender: FT_Short = !struct.at(offsets(14)).asInstanceOf[Ptr[FT_Short]]
      def ascender_=(value: FT_Short): Unit = !struct.at(offsets(14)).asInstanceOf[Ptr[FT_Short]] = value
      def descender: FT_Short = !struct.at(offsets(15)).asInstanceOf[Ptr[FT_Short]]
      def descender_=(value: FT_Short): Unit = !struct.at(offsets(15)).asInstanceOf[Ptr[FT_Short]] = value
      def height: FT_Short = !struct.at(offsets(16)).asInstanceOf[Ptr[FT_Short]]
      def height_=(value: FT_Short): Unit = !struct.at(offsets(16)).asInstanceOf[Ptr[FT_Short]] = value
      def max_advance_width: FT_Short = !struct.at(offsets(17)).asInstanceOf[Ptr[FT_Short]]
      def max_advance_width_=(value: FT_Short): Unit = !struct.at(offsets(17)).asInstanceOf[Ptr[FT_Short]] = value
      def max_advance_height: FT_Short = !struct.at(offsets(18)).asInstanceOf[Ptr[FT_Short]]
      def max_advance_height_=(value: FT_Short): Unit = !struct.at(offsets(18)).asInstanceOf[Ptr[FT_Short]] = value
      def underline_position: FT_Short = !struct.at(offsets(19)).asInstanceOf[Ptr[FT_Short]]
      def underline_position_=(value: FT_Short): Unit = !struct.at(offsets(19)).asInstanceOf[Ptr[FT_Short]] = value
      def underline_thickness: FT_Short = !struct.at(offsets(20)).asInstanceOf[Ptr[FT_Short]]
      def underline_thickness_=(value: FT_Short): Unit = !struct.at(offsets(20)).asInstanceOf[Ptr[FT_Short]] = value
      def glyph: FT_GlyphSlot = !struct.at(offsets(21)).asInstanceOf[Ptr[FT_GlyphSlot]]
      def glyph_=(value: FT_GlyphSlot): Unit = !struct.at(offsets(21)).asInstanceOf[Ptr[FT_GlyphSlot]] = value
      def size: FT_Size = !struct.at(offsets(22)).asInstanceOf[Ptr[FT_Size]]
      def size_=(value: FT_Size): Unit = !struct.at(offsets(22)).asInstanceOf[Ptr[FT_Size]] = value
      def charmap: FT_CharMap = !struct.at(offsets(23)).asInstanceOf[Ptr[FT_CharMap]]
      def charmap_=(value: FT_CharMap): Unit = !struct.at(offsets(23)).asInstanceOf[Ptr[FT_CharMap]] = value
      def driver: FT_Driver = !struct.at(offsets(24)).asInstanceOf[Ptr[FT_Driver]]
      def driver_=(value: FT_Driver): Unit = !struct.at(offsets(24)).asInstanceOf[Ptr[FT_Driver]] = value
      def memory: FT_Memory = !struct.at(offsets(25)).asInstanceOf[Ptr[FT_Memory]]
      def memory_=(value: FT_Memory): Unit = !struct.at(offsets(25)).asInstanceOf[Ptr[FT_Memory]] = value
      def stream: FT_Stream = !struct.at(offsets(26)).asInstanceOf[Ptr[FT_Stream]]
      def stream_=(value: FT_Stream): Unit = !struct.at(offsets(26)).asInstanceOf[Ptr[FT_Stream]] = value
      def sizes_list: FT_ListRec = !struct.at(offsets(27)).asInstanceOf[Ptr[FT_ListRec]]
      def sizes_list_=(value: FT_ListRec): Unit = !struct.at(offsets(27)).asInstanceOf[Ptr[FT_ListRec]] = value
      def autohint: FT_Generic = !struct.at(offsets(28)).asInstanceOf[Ptr[FT_Generic]]
      def autohint_=(value: FT_Generic): Unit = !struct.at(offsets(28)).asInstanceOf[Ptr[FT_Generic]] = value
      def extensions: Ptr[Byte] = !struct.at(offsets(29)).asInstanceOf[Ptr[Ptr[Byte]]]
      def extensions_=(value: Ptr[Byte]): Unit = !struct.at(offsets(29)).asInstanceOf[Ptr[Ptr[Byte]]] = value
      def internal: FT_Face_Internal = !struct.at(offsets(30)).asInstanceOf[Ptr[FT_Face_Internal]]
      def internal_=(value: FT_Face_Internal): Unit = !struct.at(offsets(30)).asInstanceOf[Ptr[FT_Face_Internal]] = value
    val offsets: Array[Int] = 
      val res = Array.ofDim[Int](31)
      def align(offset: Int, alignment: Int) = {
        val alignmentMask = alignment - 1
        val padding =
          if ((offset & alignmentMask) == 0) 0
          else alignment - (offset & alignmentMask)
        offset + padding
      }
      
      res(0) = align(0, alignmentof[FT_Long].toInt)
      res(1) = align(res(0) + sizeof[FT_Long].toInt, alignmentof[FT_Long].toInt)
      res(2) = align(res(1) + sizeof[FT_Long].toInt, alignmentof[FT_Long].toInt)
      res(3) = align(res(2) + sizeof[FT_Long].toInt, alignmentof[FT_Long].toInt)
      res(4) = align(res(3) + sizeof[FT_Long].toInt, alignmentof[FT_Long].toInt)
      res(5) = align(res(4) + sizeof[FT_Long].toInt, alignmentof[Ptr[FT_String]].toInt)
      res(6) = align(res(5) + sizeof[Ptr[FT_String]].toInt, alignmentof[Ptr[FT_String]].toInt)
      res(7) = align(res(6) + sizeof[Ptr[FT_String]].toInt, alignmentof[FT_Int].toInt)
      res(8) = align(res(7) + sizeof[FT_Int].toInt, alignmentof[Ptr[FT_Bitmap_Size]].toInt)
      res(9) = align(res(8) + sizeof[Ptr[FT_Bitmap_Size]].toInt, alignmentof[FT_Int].toInt)
      res(10) = align(res(9) + sizeof[FT_Int].toInt, alignmentof[Ptr[FT_CharMap]].toInt)
      res(11) = align(res(10) + sizeof[Ptr[FT_CharMap]].toInt, alignmentof[FT_Generic].toInt)
      res(12) = align(res(11) + sizeof[FT_Generic].toInt, alignmentof[FT_BBox].toInt)
      res(13) = align(res(12) + sizeof[FT_BBox].toInt, alignmentof[FT_UShort].toInt)
      res(14) = align(res(13) + sizeof[FT_UShort].toInt, alignmentof[FT_Short].toInt)
      res(15) = align(res(14) + sizeof[FT_Short].toInt, alignmentof[FT_Short].toInt)
      res(16) = align(res(15) + sizeof[FT_Short].toInt, alignmentof[FT_Short].toInt)
      res(17) = align(res(16) + sizeof[FT_Short].toInt, alignmentof[FT_Short].toInt)
      res(18) = align(res(17) + sizeof[FT_Short].toInt, alignmentof[FT_Short].toInt)
      res(19) = align(res(18) + sizeof[FT_Short].toInt, alignmentof[FT_Short].toInt)
      res(20) = align(res(19) + sizeof[FT_Short].toInt, alignmentof[FT_Short].toInt)
      res(21) = align(res(20) + sizeof[FT_Short].toInt, alignmentof[FT_GlyphSlot].toInt)
      res(22) = align(res(21) + sizeof[FT_GlyphSlot].toInt, alignmentof[FT_Size].toInt)
      res(23) = align(res(22) + sizeof[FT_Size].toInt, alignmentof[FT_CharMap].toInt)
      res(24) = align(res(23) + sizeof[FT_CharMap].toInt, alignmentof[FT_Driver].toInt)
      res(25) = align(res(24) + sizeof[FT_Driver].toInt, alignmentof[FT_Memory].toInt)
      res(26) = align(res(25) + sizeof[FT_Memory].toInt, alignmentof[FT_Stream].toInt)
      res(27) = align(res(26) + sizeof[FT_Stream].toInt, alignmentof[FT_ListRec].toInt)
      res(28) = align(res(27) + sizeof[FT_ListRec].toInt, alignmentof[FT_Generic].toInt)
      res(29) = align(res(28) + sizeof[FT_Generic].toInt, alignmentof[Ptr[Byte]].toInt)
      res(30) = align(res(29) + sizeof[Ptr[Byte]].toInt, alignmentof[FT_Face_Internal].toInt)
      res
    end offsets

  opaque type FT_Face_InternalRec_ = CStruct0
  object FT_Face_InternalRec_ :
    given _tag: Tag[FT_Face_InternalRec_] = Tag.materializeCStruct0Tag

  /**
   * ************************************************************************
  */
  opaque type FT_Generic = CStruct2[Ptr[Byte], FT_Generic_Finalizer]
  object FT_Generic:
    given _tag: Tag[FT_Generic] = Tag.materializeCStruct2Tag[Ptr[Byte], FT_Generic_Finalizer]
    def apply()(using Zone): Ptr[FT_Generic] = scala.scalanative.unsafe.alloc[FT_Generic](1)
    def apply(data : Ptr[Byte], finalizer : FT_Generic_Finalizer)(using Zone): Ptr[FT_Generic] = 
      val ____ptr = apply()
      (!____ptr).data = data
      (!____ptr).finalizer = finalizer
      ____ptr
    extension (struct: FT_Generic)
      def data : Ptr[Byte] = struct._1
      def data_=(value: Ptr[Byte]): Unit = !struct.at1 = value
      def finalizer : FT_Generic_Finalizer = struct._2
      def finalizer_=(value: FT_Generic_Finalizer): Unit = !struct.at2 = value

  /**
   * ************************************************************************
  */
  opaque type FT_Generic_ = CStruct2[Ptr[Byte], FT_Generic_Finalizer]
  object FT_Generic_ :
    given _tag: Tag[FT_Generic_] = Tag.materializeCStruct2Tag[Ptr[Byte], FT_Generic_Finalizer]
    def apply()(using Zone): Ptr[FT_Generic_] = scala.scalanative.unsafe.alloc[FT_Generic_](1)
    def apply(data : Ptr[Byte], finalizer : FT_Generic_Finalizer)(using Zone): Ptr[FT_Generic_] = 
      val ____ptr = apply()
      (!____ptr).data = data
      (!____ptr).finalizer = finalizer
      ____ptr
    extension (struct: FT_Generic_)
      def data : Ptr[Byte] = struct._1
      def data_=(value: Ptr[Byte]): Unit = !struct.at1 = value
      def finalizer : FT_Generic_Finalizer = struct._2
      def finalizer_=(value: FT_Generic_Finalizer): Unit = !struct.at2 = value

  /**
   * ************************************************************************
  */
  opaque type FT_GlyphSlotRec = CStruct22[FT_Library, FT_Face, FT_GlyphSlot, FT_UInt, FT_Generic, FT_Glyph_Metrics, FT_Fixed, FT_Fixed, FT_Vector, FT_Glyph_Format, FT_Bitmap, FT_Int, FT_Int, FT_Outline, FT_UInt, FT_SubGlyph, Ptr[Byte], CLongInt, FT_Pos, FT_Pos, Ptr[Byte], FT_Slot_Internal]
  object FT_GlyphSlotRec:
    given _tag: Tag[FT_GlyphSlotRec] = Tag.materializeCStruct22Tag[FT_Library, FT_Face, FT_GlyphSlot, FT_UInt, FT_Generic, FT_Glyph_Metrics, FT_Fixed, FT_Fixed, FT_Vector, FT_Glyph_Format, FT_Bitmap, FT_Int, FT_Int, FT_Outline, FT_UInt, FT_SubGlyph, Ptr[Byte], CLongInt, FT_Pos, FT_Pos, Ptr[Byte], FT_Slot_Internal]
    def apply()(using Zone): Ptr[FT_GlyphSlotRec] = scala.scalanative.unsafe.alloc[FT_GlyphSlotRec](1)
    def apply(library : FT_Library, face : FT_Face, next : FT_GlyphSlot, glyph_index : FT_UInt, generic : FT_Generic, metrics : FT_Glyph_Metrics, linearHoriAdvance : FT_Fixed, linearVertAdvance : FT_Fixed, advance : FT_Vector, format : FT_Glyph_Format, bitmap : FT_Bitmap, bitmap_left : FT_Int, bitmap_top : FT_Int, outline : FT_Outline, num_subglyphs : FT_UInt, subglyphs : FT_SubGlyph, control_data : Ptr[Byte], control_len : CLongInt, lsb_delta : FT_Pos, rsb_delta : FT_Pos, other : Ptr[Byte], internal : FT_Slot_Internal)(using Zone): Ptr[FT_GlyphSlotRec] = 
      val ____ptr = apply()
      (!____ptr).library = library
      (!____ptr).face = face
      (!____ptr).next = next
      (!____ptr).glyph_index = glyph_index
      (!____ptr).generic = generic
      (!____ptr).metrics = metrics
      (!____ptr).linearHoriAdvance = linearHoriAdvance
      (!____ptr).linearVertAdvance = linearVertAdvance
      (!____ptr).advance = advance
      (!____ptr).format = format
      (!____ptr).bitmap = bitmap
      (!____ptr).bitmap_left = bitmap_left
      (!____ptr).bitmap_top = bitmap_top
      (!____ptr).outline = outline
      (!____ptr).num_subglyphs = num_subglyphs
      (!____ptr).subglyphs = subglyphs
      (!____ptr).control_data = control_data
      (!____ptr).control_len = control_len
      (!____ptr).lsb_delta = lsb_delta
      (!____ptr).rsb_delta = rsb_delta
      (!____ptr).other = other
      (!____ptr).internal = internal
      ____ptr
    extension (struct: FT_GlyphSlotRec)
      def library : FT_Library = struct._1
      def library_=(value: FT_Library): Unit = !struct.at1 = value
      def face : FT_Face = struct._2
      def face_=(value: FT_Face): Unit = !struct.at2 = value
      def next : FT_GlyphSlot = struct._3
      def next_=(value: FT_GlyphSlot): Unit = !struct.at3 = value
      def glyph_index : FT_UInt = struct._4
      def glyph_index_=(value: FT_UInt): Unit = !struct.at4 = value
      def generic : FT_Generic = struct._5
      def generic_=(value: FT_Generic): Unit = !struct.at5 = value
      def metrics : FT_Glyph_Metrics = struct._6
      def metrics_=(value: FT_Glyph_Metrics): Unit = !struct.at6 = value
      def linearHoriAdvance : FT_Fixed = struct._7
      def linearHoriAdvance_=(value: FT_Fixed): Unit = !struct.at7 = value
      def linearVertAdvance : FT_Fixed = struct._8
      def linearVertAdvance_=(value: FT_Fixed): Unit = !struct.at8 = value
      def advance : FT_Vector = struct._9
      def advance_=(value: FT_Vector): Unit = !struct.at9 = value
      def format : FT_Glyph_Format = struct._10
      def format_=(value: FT_Glyph_Format): Unit = !struct.at10 = value
      def bitmap : FT_Bitmap = struct._11
      def bitmap_=(value: FT_Bitmap): Unit = !struct.at11 = value
      def bitmap_left : FT_Int = struct._12
      def bitmap_left_=(value: FT_Int): Unit = !struct.at12 = value
      def bitmap_top : FT_Int = struct._13
      def bitmap_top_=(value: FT_Int): Unit = !struct.at13 = value
      def outline : FT_Outline = struct._14
      def outline_=(value: FT_Outline): Unit = !struct.at14 = value
      def num_subglyphs : FT_UInt = struct._15
      def num_subglyphs_=(value: FT_UInt): Unit = !struct.at15 = value
      def subglyphs : FT_SubGlyph = struct._16
      def subglyphs_=(value: FT_SubGlyph): Unit = !struct.at16 = value
      def control_data : Ptr[Byte] = struct._17
      def control_data_=(value: Ptr[Byte]): Unit = !struct.at17 = value
      def control_len : CLongInt = struct._18
      def control_len_=(value: CLongInt): Unit = !struct.at18 = value
      def lsb_delta : FT_Pos = struct._19
      def lsb_delta_=(value: FT_Pos): Unit = !struct.at19 = value
      def rsb_delta : FT_Pos = struct._20
      def rsb_delta_=(value: FT_Pos): Unit = !struct.at20 = value
      def other : Ptr[Byte] = struct._21
      def other_=(value: Ptr[Byte]): Unit = !struct.at21 = value
      def internal : FT_Slot_Internal = struct._22
      def internal_=(value: FT_Slot_Internal): Unit = !struct.at22 = value

  /**
   * ************************************************************************
  */
  opaque type FT_GlyphSlotRec_ = CArray[CChar, Nat.Digit3[Nat._3, Nat._0, Nat._4]]
  object FT_GlyphSlotRec_ :
    given _tag: Tag[FT_GlyphSlotRec_] = Tag.CArray[CChar, Nat.Digit3[Nat._3, Nat._0, Nat._4]](Tag.Byte, Tag.Digit3[Nat._3, Nat._0, Nat._4](Tag.Nat3, Tag.Nat0, Tag.Nat4))
    def apply()(using Zone): Ptr[FT_GlyphSlotRec_] = scala.scalanative.unsafe.alloc[FT_GlyphSlotRec_](1)
    def apply(library : FT_Library, face : FT_Face, next : FT_GlyphSlot, glyph_index : FT_UInt, generic : FT_Generic, metrics : FT_Glyph_Metrics, linearHoriAdvance : FT_Fixed, linearVertAdvance : FT_Fixed, advance : FT_Vector, format : FT_Glyph_Format, bitmap : FT_Bitmap, bitmap_left : FT_Int, bitmap_top : FT_Int, outline : FT_Outline, num_subglyphs : FT_UInt, subglyphs : FT_SubGlyph, control_data : Ptr[Byte], control_len : CLongInt, lsb_delta : FT_Pos, rsb_delta : FT_Pos, other : Ptr[Byte], internal : FT_Slot_Internal)(using Zone): Ptr[FT_GlyphSlotRec_] = 
      val ____ptr = apply()
      (!____ptr).library = library
      (!____ptr).face = face
      (!____ptr).next = next
      (!____ptr).glyph_index = glyph_index
      (!____ptr).generic = generic
      (!____ptr).metrics = metrics
      (!____ptr).linearHoriAdvance = linearHoriAdvance
      (!____ptr).linearVertAdvance = linearVertAdvance
      (!____ptr).advance = advance
      (!____ptr).format = format
      (!____ptr).bitmap = bitmap
      (!____ptr).bitmap_left = bitmap_left
      (!____ptr).bitmap_top = bitmap_top
      (!____ptr).outline = outline
      (!____ptr).num_subglyphs = num_subglyphs
      (!____ptr).subglyphs = subglyphs
      (!____ptr).control_data = control_data
      (!____ptr).control_len = control_len
      (!____ptr).lsb_delta = lsb_delta
      (!____ptr).rsb_delta = rsb_delta
      (!____ptr).other = other
      (!____ptr).internal = internal
      ____ptr
    extension (struct: FT_GlyphSlotRec_)
      def library: FT_Library = !struct.at(offsets(0)).asInstanceOf[Ptr[FT_Library]]
      def library_=(value: FT_Library): Unit = !struct.at(offsets(0)).asInstanceOf[Ptr[FT_Library]] = value
      def face: FT_Face = !struct.at(offsets(1)).asInstanceOf[Ptr[FT_Face]]
      def face_=(value: FT_Face): Unit = !struct.at(offsets(1)).asInstanceOf[Ptr[FT_Face]] = value
      def next: FT_GlyphSlot = !struct.at(offsets(2)).asInstanceOf[Ptr[FT_GlyphSlot]]
      def next_=(value: FT_GlyphSlot): Unit = !struct.at(offsets(2)).asInstanceOf[Ptr[FT_GlyphSlot]] = value
      def glyph_index: FT_UInt = !struct.at(offsets(3)).asInstanceOf[Ptr[FT_UInt]]
      def glyph_index_=(value: FT_UInt): Unit = !struct.at(offsets(3)).asInstanceOf[Ptr[FT_UInt]] = value
      def generic: FT_Generic = !struct.at(offsets(4)).asInstanceOf[Ptr[FT_Generic]]
      def generic_=(value: FT_Generic): Unit = !struct.at(offsets(4)).asInstanceOf[Ptr[FT_Generic]] = value
      def metrics: FT_Glyph_Metrics = !struct.at(offsets(5)).asInstanceOf[Ptr[FT_Glyph_Metrics]]
      def metrics_=(value: FT_Glyph_Metrics): Unit = !struct.at(offsets(5)).asInstanceOf[Ptr[FT_Glyph_Metrics]] = value
      def linearHoriAdvance: FT_Fixed = !struct.at(offsets(6)).asInstanceOf[Ptr[FT_Fixed]]
      def linearHoriAdvance_=(value: FT_Fixed): Unit = !struct.at(offsets(6)).asInstanceOf[Ptr[FT_Fixed]] = value
      def linearVertAdvance: FT_Fixed = !struct.at(offsets(7)).asInstanceOf[Ptr[FT_Fixed]]
      def linearVertAdvance_=(value: FT_Fixed): Unit = !struct.at(offsets(7)).asInstanceOf[Ptr[FT_Fixed]] = value
      def advance: FT_Vector = !struct.at(offsets(8)).asInstanceOf[Ptr[FT_Vector]]
      def advance_=(value: FT_Vector): Unit = !struct.at(offsets(8)).asInstanceOf[Ptr[FT_Vector]] = value
      def format: FT_Glyph_Format = !struct.at(offsets(9)).asInstanceOf[Ptr[FT_Glyph_Format]]
      def format_=(value: FT_Glyph_Format): Unit = !struct.at(offsets(9)).asInstanceOf[Ptr[FT_Glyph_Format]] = value
      def bitmap: FT_Bitmap = !struct.at(offsets(10)).asInstanceOf[Ptr[FT_Bitmap]]
      def bitmap_=(value: FT_Bitmap): Unit = !struct.at(offsets(10)).asInstanceOf[Ptr[FT_Bitmap]] = value
      def bitmap_left: FT_Int = !struct.at(offsets(11)).asInstanceOf[Ptr[FT_Int]]
      def bitmap_left_=(value: FT_Int): Unit = !struct.at(offsets(11)).asInstanceOf[Ptr[FT_Int]] = value
      def bitmap_top: FT_Int = !struct.at(offsets(12)).asInstanceOf[Ptr[FT_Int]]
      def bitmap_top_=(value: FT_Int): Unit = !struct.at(offsets(12)).asInstanceOf[Ptr[FT_Int]] = value
      def outline: FT_Outline = !struct.at(offsets(13)).asInstanceOf[Ptr[FT_Outline]]
      def outline_=(value: FT_Outline): Unit = !struct.at(offsets(13)).asInstanceOf[Ptr[FT_Outline]] = value
      def num_subglyphs: FT_UInt = !struct.at(offsets(14)).asInstanceOf[Ptr[FT_UInt]]
      def num_subglyphs_=(value: FT_UInt): Unit = !struct.at(offsets(14)).asInstanceOf[Ptr[FT_UInt]] = value
      def subglyphs: FT_SubGlyph = !struct.at(offsets(15)).asInstanceOf[Ptr[FT_SubGlyph]]
      def subglyphs_=(value: FT_SubGlyph): Unit = !struct.at(offsets(15)).asInstanceOf[Ptr[FT_SubGlyph]] = value
      def control_data: Ptr[Byte] = !struct.at(offsets(16)).asInstanceOf[Ptr[Ptr[Byte]]]
      def control_data_=(value: Ptr[Byte]): Unit = !struct.at(offsets(16)).asInstanceOf[Ptr[Ptr[Byte]]] = value
      def control_len: CLongInt = !struct.at(offsets(17)).asInstanceOf[Ptr[CLongInt]]
      def control_len_=(value: CLongInt): Unit = !struct.at(offsets(17)).asInstanceOf[Ptr[CLongInt]] = value
      def lsb_delta: FT_Pos = !struct.at(offsets(18)).asInstanceOf[Ptr[FT_Pos]]
      def lsb_delta_=(value: FT_Pos): Unit = !struct.at(offsets(18)).asInstanceOf[Ptr[FT_Pos]] = value
      def rsb_delta: FT_Pos = !struct.at(offsets(19)).asInstanceOf[Ptr[FT_Pos]]
      def rsb_delta_=(value: FT_Pos): Unit = !struct.at(offsets(19)).asInstanceOf[Ptr[FT_Pos]] = value
      def other: Ptr[Byte] = !struct.at(offsets(20)).asInstanceOf[Ptr[Ptr[Byte]]]
      def other_=(value: Ptr[Byte]): Unit = !struct.at(offsets(20)).asInstanceOf[Ptr[Ptr[Byte]]] = value
      def internal: FT_Slot_Internal = !struct.at(offsets(21)).asInstanceOf[Ptr[FT_Slot_Internal]]
      def internal_=(value: FT_Slot_Internal): Unit = !struct.at(offsets(21)).asInstanceOf[Ptr[FT_Slot_Internal]] = value
    val offsets: Array[Int] = 
      val res = Array.ofDim[Int](22)
      def align(offset: Int, alignment: Int) = {
        val alignmentMask = alignment - 1
        val padding =
          if ((offset & alignmentMask) == 0) 0
          else alignment - (offset & alignmentMask)
        offset + padding
      }
      
      res(0) = align(0, alignmentof[FT_Library].toInt)
      res(1) = align(res(0) + sizeof[FT_Library].toInt, alignmentof[FT_Face].toInt)
      res(2) = align(res(1) + sizeof[FT_Face].toInt, alignmentof[FT_GlyphSlot].toInt)
      res(3) = align(res(2) + sizeof[FT_GlyphSlot].toInt, alignmentof[FT_UInt].toInt)
      res(4) = align(res(3) + sizeof[FT_UInt].toInt, alignmentof[FT_Generic].toInt)
      res(5) = align(res(4) + sizeof[FT_Generic].toInt, alignmentof[FT_Glyph_Metrics].toInt)
      res(6) = align(res(5) + sizeof[FT_Glyph_Metrics].toInt, alignmentof[FT_Fixed].toInt)
      res(7) = align(res(6) + sizeof[FT_Fixed].toInt, alignmentof[FT_Fixed].toInt)
      res(8) = align(res(7) + sizeof[FT_Fixed].toInt, alignmentof[FT_Vector].toInt)
      res(9) = align(res(8) + sizeof[FT_Vector].toInt, alignmentof[FT_Glyph_Format].toInt)
      res(10) = align(res(9) + sizeof[FT_Glyph_Format].toInt, alignmentof[FT_Bitmap].toInt)
      res(11) = align(res(10) + sizeof[FT_Bitmap].toInt, alignmentof[FT_Int].toInt)
      res(12) = align(res(11) + sizeof[FT_Int].toInt, alignmentof[FT_Int].toInt)
      res(13) = align(res(12) + sizeof[FT_Int].toInt, alignmentof[FT_Outline].toInt)
      res(14) = align(res(13) + sizeof[FT_Outline].toInt, alignmentof[FT_UInt].toInt)
      res(15) = align(res(14) + sizeof[FT_UInt].toInt, alignmentof[FT_SubGlyph].toInt)
      res(16) = align(res(15) + sizeof[FT_SubGlyph].toInt, alignmentof[Ptr[Byte]].toInt)
      res(17) = align(res(16) + sizeof[Ptr[Byte]].toInt, alignmentof[CLongInt].toInt)
      res(18) = align(res(17) + sizeof[CLongInt].toInt, alignmentof[FT_Pos].toInt)
      res(19) = align(res(18) + sizeof[FT_Pos].toInt, alignmentof[FT_Pos].toInt)
      res(20) = align(res(19) + sizeof[FT_Pos].toInt, alignmentof[Ptr[Byte]].toInt)
      res(21) = align(res(20) + sizeof[Ptr[Byte]].toInt, alignmentof[FT_Slot_Internal].toInt)
      res
    end offsets

  /**
   * ************************************************************************
  */
  opaque type FT_Glyph_Metrics = CStruct8[FT_Pos, FT_Pos, FT_Pos, FT_Pos, FT_Pos, FT_Pos, FT_Pos, FT_Pos]
  object FT_Glyph_Metrics:
    given _tag: Tag[FT_Glyph_Metrics] = Tag.materializeCStruct8Tag[FT_Pos, FT_Pos, FT_Pos, FT_Pos, FT_Pos, FT_Pos, FT_Pos, FT_Pos]
    def apply()(using Zone): Ptr[FT_Glyph_Metrics] = scala.scalanative.unsafe.alloc[FT_Glyph_Metrics](1)
    def apply(width : FT_Pos, height : FT_Pos, horiBearingX : FT_Pos, horiBearingY : FT_Pos, horiAdvance : FT_Pos, vertBearingX : FT_Pos, vertBearingY : FT_Pos, vertAdvance : FT_Pos)(using Zone): Ptr[FT_Glyph_Metrics] = 
      val ____ptr = apply()
      (!____ptr).width = width
      (!____ptr).height = height
      (!____ptr).horiBearingX = horiBearingX
      (!____ptr).horiBearingY = horiBearingY
      (!____ptr).horiAdvance = horiAdvance
      (!____ptr).vertBearingX = vertBearingX
      (!____ptr).vertBearingY = vertBearingY
      (!____ptr).vertAdvance = vertAdvance
      ____ptr
    extension (struct: FT_Glyph_Metrics)
      def width : FT_Pos = struct._1
      def width_=(value: FT_Pos): Unit = !struct.at1 = value
      def height : FT_Pos = struct._2
      def height_=(value: FT_Pos): Unit = !struct.at2 = value
      def horiBearingX : FT_Pos = struct._3
      def horiBearingX_=(value: FT_Pos): Unit = !struct.at3 = value
      def horiBearingY : FT_Pos = struct._4
      def horiBearingY_=(value: FT_Pos): Unit = !struct.at4 = value
      def horiAdvance : FT_Pos = struct._5
      def horiAdvance_=(value: FT_Pos): Unit = !struct.at5 = value
      def vertBearingX : FT_Pos = struct._6
      def vertBearingX_=(value: FT_Pos): Unit = !struct.at6 = value
      def vertBearingY : FT_Pos = struct._7
      def vertBearingY_=(value: FT_Pos): Unit = !struct.at7 = value
      def vertAdvance : FT_Pos = struct._8
      def vertAdvance_=(value: FT_Pos): Unit = !struct.at8 = value

  /**
   * ************************************************************************
  */
  opaque type FT_Glyph_Metrics_ = CStruct8[FT_Pos, FT_Pos, FT_Pos, FT_Pos, FT_Pos, FT_Pos, FT_Pos, FT_Pos]
  object FT_Glyph_Metrics_ :
    given _tag: Tag[FT_Glyph_Metrics_] = Tag.materializeCStruct8Tag[FT_Pos, FT_Pos, FT_Pos, FT_Pos, FT_Pos, FT_Pos, FT_Pos, FT_Pos]
    def apply()(using Zone): Ptr[FT_Glyph_Metrics_] = scala.scalanative.unsafe.alloc[FT_Glyph_Metrics_](1)
    def apply(width : FT_Pos, height : FT_Pos, horiBearingX : FT_Pos, horiBearingY : FT_Pos, horiAdvance : FT_Pos, vertBearingX : FT_Pos, vertBearingY : FT_Pos, vertAdvance : FT_Pos)(using Zone): Ptr[FT_Glyph_Metrics_] = 
      val ____ptr = apply()
      (!____ptr).width = width
      (!____ptr).height = height
      (!____ptr).horiBearingX = horiBearingX
      (!____ptr).horiBearingY = horiBearingY
      (!____ptr).horiAdvance = horiAdvance
      (!____ptr).vertBearingX = vertBearingX
      (!____ptr).vertBearingY = vertBearingY
      (!____ptr).vertAdvance = vertAdvance
      ____ptr
    extension (struct: FT_Glyph_Metrics_)
      def width : FT_Pos = struct._1
      def width_=(value: FT_Pos): Unit = !struct.at1 = value
      def height : FT_Pos = struct._2
      def height_=(value: FT_Pos): Unit = !struct.at2 = value
      def horiBearingX : FT_Pos = struct._3
      def horiBearingX_=(value: FT_Pos): Unit = !struct.at3 = value
      def horiBearingY : FT_Pos = struct._4
      def horiBearingY_=(value: FT_Pos): Unit = !struct.at4 = value
      def horiAdvance : FT_Pos = struct._5
      def horiAdvance_=(value: FT_Pos): Unit = !struct.at5 = value
      def vertBearingX : FT_Pos = struct._6
      def vertBearingX_=(value: FT_Pos): Unit = !struct.at6 = value
      def vertBearingY : FT_Pos = struct._7
      def vertBearingY_=(value: FT_Pos): Unit = !struct.at7 = value
      def vertAdvance : FT_Pos = struct._8
      def vertAdvance_=(value: FT_Pos): Unit = !struct.at8 = value

  opaque type FT_LibraryRec_ = CStruct0
  object FT_LibraryRec_ :
    given _tag: Tag[FT_LibraryRec_] = Tag.materializeCStruct0Tag

  /**
   * ************************************************************************
  */
  opaque type FT_ListNodeRec = CStruct3[FT_ListNode, FT_ListNode, Ptr[Byte]]
  object FT_ListNodeRec:
    given _tag: Tag[FT_ListNodeRec] = Tag.materializeCStruct3Tag[FT_ListNode, FT_ListNode, Ptr[Byte]]
    def apply()(using Zone): Ptr[FT_ListNodeRec] = scala.scalanative.unsafe.alloc[FT_ListNodeRec](1)
    def apply(prev : FT_ListNode, next : FT_ListNode, data : Ptr[Byte])(using Zone): Ptr[FT_ListNodeRec] = 
      val ____ptr = apply()
      (!____ptr).prev = prev
      (!____ptr).next = next
      (!____ptr).data = data
      ____ptr
    extension (struct: FT_ListNodeRec)
      def prev : FT_ListNode = struct._1
      def prev_=(value: FT_ListNode): Unit = !struct.at1 = value
      def next : FT_ListNode = struct._2
      def next_=(value: FT_ListNode): Unit = !struct.at2 = value
      def data : Ptr[Byte] = struct._3
      def data_=(value: Ptr[Byte]): Unit = !struct.at3 = value

  /**
   * ************************************************************************
  */
  opaque type FT_ListNodeRec_ = CArray[CChar, Nat.Digit2[Nat._2, Nat._4]]
  object FT_ListNodeRec_ :
    given _tag: Tag[FT_ListNodeRec_] = Tag.CArray[CChar, Nat.Digit2[Nat._2, Nat._4]](Tag.Byte, Tag.Digit2[Nat._2, Nat._4](Tag.Nat2, Tag.Nat4))
    def apply()(using Zone): Ptr[FT_ListNodeRec_] = scala.scalanative.unsafe.alloc[FT_ListNodeRec_](1)
    def apply(prev : FT_ListNode, next : FT_ListNode, data : Ptr[Byte])(using Zone): Ptr[FT_ListNodeRec_] = 
      val ____ptr = apply()
      (!____ptr).prev = prev
      (!____ptr).next = next
      (!____ptr).data = data
      ____ptr
    extension (struct: FT_ListNodeRec_)
      def prev: FT_ListNode = !struct.at(offsets(0)).asInstanceOf[Ptr[FT_ListNode]]
      def prev_=(value: FT_ListNode): Unit = !struct.at(offsets(0)).asInstanceOf[Ptr[FT_ListNode]] = value
      def next: FT_ListNode = !struct.at(offsets(1)).asInstanceOf[Ptr[FT_ListNode]]
      def next_=(value: FT_ListNode): Unit = !struct.at(offsets(1)).asInstanceOf[Ptr[FT_ListNode]] = value
      def data: Ptr[Byte] = !struct.at(offsets(2)).asInstanceOf[Ptr[Ptr[Byte]]]
      def data_=(value: Ptr[Byte]): Unit = !struct.at(offsets(2)).asInstanceOf[Ptr[Ptr[Byte]]] = value
    val offsets: Array[Int] = 
      val res = Array.ofDim[Int](3)
      def align(offset: Int, alignment: Int) = {
        val alignmentMask = alignment - 1
        val padding =
          if ((offset & alignmentMask) == 0) 0
          else alignment - (offset & alignmentMask)
        offset + padding
      }
      
      res(0) = align(0, alignmentof[FT_ListNode].toInt)
      res(1) = align(res(0) + sizeof[FT_ListNode].toInt, alignmentof[FT_ListNode].toInt)
      res(2) = align(res(1) + sizeof[FT_ListNode].toInt, alignmentof[Ptr[Byte]].toInt)
      res
    end offsets

  /**
   * ************************************************************************
  */
  opaque type FT_ListRec = CStruct2[FT_ListNode, FT_ListNode]
  object FT_ListRec:
    given _tag: Tag[FT_ListRec] = Tag.materializeCStruct2Tag[FT_ListNode, FT_ListNode]
    def apply()(using Zone): Ptr[FT_ListRec] = scala.scalanative.unsafe.alloc[FT_ListRec](1)
    def apply(head : FT_ListNode, tail : FT_ListNode)(using Zone): Ptr[FT_ListRec] = 
      val ____ptr = apply()
      (!____ptr).head = head
      (!____ptr).tail = tail
      ____ptr
    extension (struct: FT_ListRec)
      def head : FT_ListNode = struct._1
      def head_=(value: FT_ListNode): Unit = !struct.at1 = value
      def tail : FT_ListNode = struct._2
      def tail_=(value: FT_ListNode): Unit = !struct.at2 = value

  /**
   * ************************************************************************
  */
  opaque type FT_ListRec_ = CStruct2[FT_ListNode, FT_ListNode]
  object FT_ListRec_ :
    given _tag: Tag[FT_ListRec_] = Tag.materializeCStruct2Tag[FT_ListNode, FT_ListNode]
    def apply()(using Zone): Ptr[FT_ListRec_] = scala.scalanative.unsafe.alloc[FT_ListRec_](1)
    def apply(head : FT_ListNode, tail : FT_ListNode)(using Zone): Ptr[FT_ListRec_] = 
      val ____ptr = apply()
      (!____ptr).head = head
      (!____ptr).tail = tail
      ____ptr
    extension (struct: FT_ListRec_)
      def head : FT_ListNode = struct._1
      def head_=(value: FT_ListNode): Unit = !struct.at1 = value
      def tail : FT_ListNode = struct._2
      def tail_=(value: FT_ListNode): Unit = !struct.at2 = value

  /**
   * ************************************************************************
  */
  opaque type FT_Matrix = CStruct4[FT_Fixed, FT_Fixed, FT_Fixed, FT_Fixed]
  object FT_Matrix:
    given _tag: Tag[FT_Matrix] = Tag.materializeCStruct4Tag[FT_Fixed, FT_Fixed, FT_Fixed, FT_Fixed]
    def apply()(using Zone): Ptr[FT_Matrix] = scala.scalanative.unsafe.alloc[FT_Matrix](1)
    def apply(xx : FT_Fixed, xy : FT_Fixed, yx : FT_Fixed, yy : FT_Fixed)(using Zone): Ptr[FT_Matrix] = 
      val ____ptr = apply()
      (!____ptr).xx = xx
      (!____ptr).xy = xy
      (!____ptr).yx = yx
      (!____ptr).yy = yy
      ____ptr
    extension (struct: FT_Matrix)
      def xx : FT_Fixed = struct._1
      def xx_=(value: FT_Fixed): Unit = !struct.at1 = value
      def xy : FT_Fixed = struct._2
      def xy_=(value: FT_Fixed): Unit = !struct.at2 = value
      def yx : FT_Fixed = struct._3
      def yx_=(value: FT_Fixed): Unit = !struct.at3 = value
      def yy : FT_Fixed = struct._4
      def yy_=(value: FT_Fixed): Unit = !struct.at4 = value

  /**
   * ************************************************************************
  */
  opaque type FT_Matrix_ = CStruct4[FT_Fixed, FT_Fixed, FT_Fixed, FT_Fixed]
  object FT_Matrix_ :
    given _tag: Tag[FT_Matrix_] = Tag.materializeCStruct4Tag[FT_Fixed, FT_Fixed, FT_Fixed, FT_Fixed]
    def apply()(using Zone): Ptr[FT_Matrix_] = scala.scalanative.unsafe.alloc[FT_Matrix_](1)
    def apply(xx : FT_Fixed, xy : FT_Fixed, yx : FT_Fixed, yy : FT_Fixed)(using Zone): Ptr[FT_Matrix_] = 
      val ____ptr = apply()
      (!____ptr).xx = xx
      (!____ptr).xy = xy
      (!____ptr).yx = yx
      (!____ptr).yy = yy
      ____ptr
    extension (struct: FT_Matrix_)
      def xx : FT_Fixed = struct._1
      def xx_=(value: FT_Fixed): Unit = !struct.at1 = value
      def xy : FT_Fixed = struct._2
      def xy_=(value: FT_Fixed): Unit = !struct.at2 = value
      def yx : FT_Fixed = struct._3
      def yx_=(value: FT_Fixed): Unit = !struct.at3 = value
      def yy : FT_Fixed = struct._4
      def yy_=(value: FT_Fixed): Unit = !struct.at4 = value

  /**
   * ************************************************************************
  */
  opaque type FT_MemoryRec_ = CStruct4[Ptr[Byte], Ptr[Byte], Ptr[Byte], Ptr[Byte]]
  object FT_MemoryRec_ :
    given _tag: Tag[FT_MemoryRec_] = Tag.materializeCStruct4Tag[Ptr[Byte], Ptr[Byte], Ptr[Byte], Ptr[Byte]]
    def apply()(using Zone): Ptr[FT_MemoryRec_] = scala.scalanative.unsafe.alloc[FT_MemoryRec_](1)
    def apply(user : Ptr[Byte], alloc : FT_Alloc_Func, free : FT_Free_Func, realloc : FT_Realloc_Func)(using Zone): Ptr[FT_MemoryRec_] = 
      val ____ptr = apply()
      (!____ptr).user = user
      (!____ptr).alloc = alloc
      (!____ptr).free = free
      (!____ptr).realloc = realloc
      ____ptr
    extension (struct: FT_MemoryRec_)
      def user : Ptr[Byte] = struct._1
      def user_=(value: Ptr[Byte]): Unit = !struct.at1 = value
      def alloc : FT_Alloc_Func = struct._2.asInstanceOf[FT_Alloc_Func]
      def alloc_=(value: FT_Alloc_Func): Unit = !struct.at2 = value.asInstanceOf[Ptr[Byte]]
      def free : FT_Free_Func = struct._3.asInstanceOf[FT_Free_Func]
      def free_=(value: FT_Free_Func): Unit = !struct.at3 = value.asInstanceOf[Ptr[Byte]]
      def realloc : FT_Realloc_Func = struct._4.asInstanceOf[FT_Realloc_Func]
      def realloc_=(value: FT_Realloc_Func): Unit = !struct.at4 = value.asInstanceOf[Ptr[Byte]]

  opaque type FT_ModuleRec_ = CStruct0
  object FT_ModuleRec_ :
    given _tag: Tag[FT_ModuleRec_] = Tag.materializeCStruct0Tag

  /**
   * ************************************************************************
  */
  opaque type FT_Open_Args = CStruct8[FT_UInt, Ptr[FT_Byte], FT_Long, Ptr[FT_String], FT_Stream, FT_Module, FT_Int, Ptr[FT_Parameter]]
  object FT_Open_Args:
    given _tag: Tag[FT_Open_Args] = Tag.materializeCStruct8Tag[FT_UInt, Ptr[FT_Byte], FT_Long, Ptr[FT_String], FT_Stream, FT_Module, FT_Int, Ptr[FT_Parameter]]
    def apply()(using Zone): Ptr[FT_Open_Args] = scala.scalanative.unsafe.alloc[FT_Open_Args](1)
    def apply(flags : FT_UInt, memory_base : Ptr[FT_Byte], memory_size : FT_Long, pathname : Ptr[FT_String], stream : FT_Stream, driver : FT_Module, num_params : FT_Int, params : Ptr[FT_Parameter])(using Zone): Ptr[FT_Open_Args] = 
      val ____ptr = apply()
      (!____ptr).flags = flags
      (!____ptr).memory_base = memory_base
      (!____ptr).memory_size = memory_size
      (!____ptr).pathname = pathname
      (!____ptr).stream = stream
      (!____ptr).driver = driver
      (!____ptr).num_params = num_params
      (!____ptr).params = params
      ____ptr
    extension (struct: FT_Open_Args)
      def flags : FT_UInt = struct._1
      def flags_=(value: FT_UInt): Unit = !struct.at1 = value
      def memory_base : Ptr[FT_Byte] = struct._2
      def memory_base_=(value: Ptr[FT_Byte]): Unit = !struct.at2 = value
      def memory_size : FT_Long = struct._3
      def memory_size_=(value: FT_Long): Unit = !struct.at3 = value
      def pathname : Ptr[FT_String] = struct._4
      def pathname_=(value: Ptr[FT_String]): Unit = !struct.at4 = value
      def stream : FT_Stream = struct._5
      def stream_=(value: FT_Stream): Unit = !struct.at5 = value
      def driver : FT_Module = struct._6
      def driver_=(value: FT_Module): Unit = !struct.at6 = value
      def num_params : FT_Int = struct._7
      def num_params_=(value: FT_Int): Unit = !struct.at7 = value
      def params : Ptr[FT_Parameter] = struct._8
      def params_=(value: Ptr[FT_Parameter]): Unit = !struct.at8 = value

  /**
   * ************************************************************************
  */
  opaque type FT_Open_Args_ = CStruct8[FT_UInt, Ptr[FT_Byte], FT_Long, Ptr[FT_String], FT_Stream, FT_Module, FT_Int, Ptr[FT_Parameter]]
  object FT_Open_Args_ :
    given _tag: Tag[FT_Open_Args_] = Tag.materializeCStruct8Tag[FT_UInt, Ptr[FT_Byte], FT_Long, Ptr[FT_String], FT_Stream, FT_Module, FT_Int, Ptr[FT_Parameter]]
    def apply()(using Zone): Ptr[FT_Open_Args_] = scala.scalanative.unsafe.alloc[FT_Open_Args_](1)
    def apply(flags : FT_UInt, memory_base : Ptr[FT_Byte], memory_size : FT_Long, pathname : Ptr[FT_String], stream : FT_Stream, driver : FT_Module, num_params : FT_Int, params : Ptr[FT_Parameter])(using Zone): Ptr[FT_Open_Args_] = 
      val ____ptr = apply()
      (!____ptr).flags = flags
      (!____ptr).memory_base = memory_base
      (!____ptr).memory_size = memory_size
      (!____ptr).pathname = pathname
      (!____ptr).stream = stream
      (!____ptr).driver = driver
      (!____ptr).num_params = num_params
      (!____ptr).params = params
      ____ptr
    extension (struct: FT_Open_Args_)
      def flags : FT_UInt = struct._1
      def flags_=(value: FT_UInt): Unit = !struct.at1 = value
      def memory_base : Ptr[FT_Byte] = struct._2
      def memory_base_=(value: Ptr[FT_Byte]): Unit = !struct.at2 = value
      def memory_size : FT_Long = struct._3
      def memory_size_=(value: FT_Long): Unit = !struct.at3 = value
      def pathname : Ptr[FT_String] = struct._4
      def pathname_=(value: Ptr[FT_String]): Unit = !struct.at4 = value
      def stream : FT_Stream = struct._5
      def stream_=(value: FT_Stream): Unit = !struct.at5 = value
      def driver : FT_Module = struct._6
      def driver_=(value: FT_Module): Unit = !struct.at6 = value
      def num_params : FT_Int = struct._7
      def num_params_=(value: FT_Int): Unit = !struct.at7 = value
      def params : Ptr[FT_Parameter] = struct._8
      def params_=(value: Ptr[FT_Parameter]): Unit = !struct.at8 = value

  /**
   * ************************************************************************
  */
  opaque type FT_Outline = CStruct6[CShort, CShort, Ptr[FT_Vector], CString, Ptr[CShort], CInt]
  object FT_Outline:
    given _tag: Tag[FT_Outline] = Tag.materializeCStruct6Tag[CShort, CShort, Ptr[FT_Vector], CString, Ptr[CShort], CInt]
    def apply()(using Zone): Ptr[FT_Outline] = scala.scalanative.unsafe.alloc[FT_Outline](1)
    def apply(n_contours : CShort, n_points : CShort, points : Ptr[FT_Vector], tags : CString, contours : Ptr[CShort], flags : CInt)(using Zone): Ptr[FT_Outline] = 
      val ____ptr = apply()
      (!____ptr).n_contours = n_contours
      (!____ptr).n_points = n_points
      (!____ptr).points = points
      (!____ptr).tags = tags
      (!____ptr).contours = contours
      (!____ptr).flags = flags
      ____ptr
    extension (struct: FT_Outline)
      def n_contours : CShort = struct._1
      def n_contours_=(value: CShort): Unit = !struct.at1 = value
      def n_points : CShort = struct._2
      def n_points_=(value: CShort): Unit = !struct.at2 = value
      def points : Ptr[FT_Vector] = struct._3
      def points_=(value: Ptr[FT_Vector]): Unit = !struct.at3 = value
      def tags : CString = struct._4
      def tags_=(value: CString): Unit = !struct.at4 = value
      def contours : Ptr[CShort] = struct._5
      def contours_=(value: Ptr[CShort]): Unit = !struct.at5 = value
      def flags : CInt = struct._6
      def flags_=(value: CInt): Unit = !struct.at6 = value

  /**
   * ************************************************************************
  */
  opaque type FT_Outline_ = CStruct6[CShort, CShort, Ptr[FT_Vector], CString, Ptr[CShort], CInt]
  object FT_Outline_ :
    given _tag: Tag[FT_Outline_] = Tag.materializeCStruct6Tag[CShort, CShort, Ptr[FT_Vector], CString, Ptr[CShort], CInt]
    def apply()(using Zone): Ptr[FT_Outline_] = scala.scalanative.unsafe.alloc[FT_Outline_](1)
    def apply(n_contours : CShort, n_points : CShort, points : Ptr[FT_Vector], tags : CString, contours : Ptr[CShort], flags : CInt)(using Zone): Ptr[FT_Outline_] = 
      val ____ptr = apply()
      (!____ptr).n_contours = n_contours
      (!____ptr).n_points = n_points
      (!____ptr).points = points
      (!____ptr).tags = tags
      (!____ptr).contours = contours
      (!____ptr).flags = flags
      ____ptr
    extension (struct: FT_Outline_)
      def n_contours : CShort = struct._1
      def n_contours_=(value: CShort): Unit = !struct.at1 = value
      def n_points : CShort = struct._2
      def n_points_=(value: CShort): Unit = !struct.at2 = value
      def points : Ptr[FT_Vector] = struct._3
      def points_=(value: Ptr[FT_Vector]): Unit = !struct.at3 = value
      def tags : CString = struct._4
      def tags_=(value: CString): Unit = !struct.at4 = value
      def contours : Ptr[CShort] = struct._5
      def contours_=(value: Ptr[CShort]): Unit = !struct.at5 = value
      def flags : CInt = struct._6
      def flags_=(value: CInt): Unit = !struct.at6 = value

  /**
   * ************************************************************************
  */
  opaque type FT_Outline_Funcs = CStruct6[FT_Outline_MoveToFunc, FT_Outline_LineToFunc, FT_Outline_ConicToFunc, FT_Outline_CubicToFunc, CInt, FT_Pos]
  object FT_Outline_Funcs:
    given _tag: Tag[FT_Outline_Funcs] = Tag.materializeCStruct6Tag[FT_Outline_MoveToFunc, FT_Outline_LineToFunc, FT_Outline_ConicToFunc, FT_Outline_CubicToFunc, CInt, FT_Pos]
    def apply()(using Zone): Ptr[FT_Outline_Funcs] = scala.scalanative.unsafe.alloc[FT_Outline_Funcs](1)
    def apply(move_to : FT_Outline_MoveToFunc, line_to : FT_Outline_LineToFunc, conic_to : FT_Outline_ConicToFunc, cubic_to : FT_Outline_CubicToFunc, shift : CInt, delta : FT_Pos)(using Zone): Ptr[FT_Outline_Funcs] = 
      val ____ptr = apply()
      (!____ptr).move_to = move_to
      (!____ptr).line_to = line_to
      (!____ptr).conic_to = conic_to
      (!____ptr).cubic_to = cubic_to
      (!____ptr).shift = shift
      (!____ptr).delta = delta
      ____ptr
    extension (struct: FT_Outline_Funcs)
      def move_to : FT_Outline_MoveToFunc = struct._1
      def move_to_=(value: FT_Outline_MoveToFunc): Unit = !struct.at1 = value
      def line_to : FT_Outline_LineToFunc = struct._2
      def line_to_=(value: FT_Outline_LineToFunc): Unit = !struct.at2 = value
      def conic_to : FT_Outline_ConicToFunc = struct._3
      def conic_to_=(value: FT_Outline_ConicToFunc): Unit = !struct.at3 = value
      def cubic_to : FT_Outline_CubicToFunc = struct._4
      def cubic_to_=(value: FT_Outline_CubicToFunc): Unit = !struct.at4 = value
      def shift : CInt = struct._5
      def shift_=(value: CInt): Unit = !struct.at5 = value
      def delta : FT_Pos = struct._6
      def delta_=(value: FT_Pos): Unit = !struct.at6 = value

  /**
   * ************************************************************************
  */
  opaque type FT_Outline_Funcs_ = CStruct6[FT_Outline_MoveToFunc, FT_Outline_LineToFunc, FT_Outline_ConicToFunc, FT_Outline_CubicToFunc, CInt, FT_Pos]
  object FT_Outline_Funcs_ :
    given _tag: Tag[FT_Outline_Funcs_] = Tag.materializeCStruct6Tag[FT_Outline_MoveToFunc, FT_Outline_LineToFunc, FT_Outline_ConicToFunc, FT_Outline_CubicToFunc, CInt, FT_Pos]
    def apply()(using Zone): Ptr[FT_Outline_Funcs_] = scala.scalanative.unsafe.alloc[FT_Outline_Funcs_](1)
    def apply(move_to : FT_Outline_MoveToFunc, line_to : FT_Outline_LineToFunc, conic_to : FT_Outline_ConicToFunc, cubic_to : FT_Outline_CubicToFunc, shift : CInt, delta : FT_Pos)(using Zone): Ptr[FT_Outline_Funcs_] = 
      val ____ptr = apply()
      (!____ptr).move_to = move_to
      (!____ptr).line_to = line_to
      (!____ptr).conic_to = conic_to
      (!____ptr).cubic_to = cubic_to
      (!____ptr).shift = shift
      (!____ptr).delta = delta
      ____ptr
    extension (struct: FT_Outline_Funcs_)
      def move_to : FT_Outline_MoveToFunc = struct._1
      def move_to_=(value: FT_Outline_MoveToFunc): Unit = !struct.at1 = value
      def line_to : FT_Outline_LineToFunc = struct._2
      def line_to_=(value: FT_Outline_LineToFunc): Unit = !struct.at2 = value
      def conic_to : FT_Outline_ConicToFunc = struct._3
      def conic_to_=(value: FT_Outline_ConicToFunc): Unit = !struct.at3 = value
      def cubic_to : FT_Outline_CubicToFunc = struct._4
      def cubic_to_=(value: FT_Outline_CubicToFunc): Unit = !struct.at4 = value
      def shift : CInt = struct._5
      def shift_=(value: CInt): Unit = !struct.at5 = value
      def delta : FT_Pos = struct._6
      def delta_=(value: FT_Pos): Unit = !struct.at6 = value

  /**
   * ************************************************************************
  */
  opaque type FT_Parameter = CStruct2[FT_ULong, FT_Pointer]
  object FT_Parameter:
    given _tag: Tag[FT_Parameter] = Tag.materializeCStruct2Tag[FT_ULong, FT_Pointer]
    def apply()(using Zone): Ptr[FT_Parameter] = scala.scalanative.unsafe.alloc[FT_Parameter](1)
    def apply(tag : FT_ULong, data : FT_Pointer)(using Zone): Ptr[FT_Parameter] = 
      val ____ptr = apply()
      (!____ptr).tag = tag
      (!____ptr).data = data
      ____ptr
    extension (struct: FT_Parameter)
      def tag : FT_ULong = struct._1
      def tag_=(value: FT_ULong): Unit = !struct.at1 = value
      def data : FT_Pointer = struct._2
      def data_=(value: FT_Pointer): Unit = !struct.at2 = value

  /**
   * ************************************************************************
  */
  opaque type FT_Parameter_ = CStruct2[FT_ULong, FT_Pointer]
  object FT_Parameter_ :
    given _tag: Tag[FT_Parameter_] = Tag.materializeCStruct2Tag[FT_ULong, FT_Pointer]
    def apply()(using Zone): Ptr[FT_Parameter_] = scala.scalanative.unsafe.alloc[FT_Parameter_](1)
    def apply(tag : FT_ULong, data : FT_Pointer)(using Zone): Ptr[FT_Parameter_] = 
      val ____ptr = apply()
      (!____ptr).tag = tag
      (!____ptr).data = data
      ____ptr
    extension (struct: FT_Parameter_)
      def tag : FT_ULong = struct._1
      def tag_=(value: FT_ULong): Unit = !struct.at1 = value
      def data : FT_Pointer = struct._2
      def data_=(value: FT_Pointer): Unit = !struct.at2 = value

  opaque type FT_RasterRec_ = CStruct0
  object FT_RasterRec_ :
    given _tag: Tag[FT_RasterRec_] = Tag.materializeCStruct0Tag

  /**
   * ************************************************************************
  */
  opaque type FT_Raster_Funcs = CStruct6[FT_Glyph_Format, FT_Raster_NewFunc, FT_Raster_ResetFunc, FT_Raster_SetModeFunc, FT_Raster_RenderFunc, FT_Raster_DoneFunc]
  object FT_Raster_Funcs:
    given _tag: Tag[FT_Raster_Funcs] = Tag.materializeCStruct6Tag[FT_Glyph_Format, FT_Raster_NewFunc, FT_Raster_ResetFunc, FT_Raster_SetModeFunc, FT_Raster_RenderFunc, FT_Raster_DoneFunc]
    def apply()(using Zone): Ptr[FT_Raster_Funcs] = scala.scalanative.unsafe.alloc[FT_Raster_Funcs](1)
    def apply(glyph_format : FT_Glyph_Format, raster_new : FT_Raster_NewFunc, raster_reset : FT_Raster_ResetFunc, raster_set_mode : FT_Raster_SetModeFunc, raster_render : FT_Raster_RenderFunc, raster_done : FT_Raster_DoneFunc)(using Zone): Ptr[FT_Raster_Funcs] = 
      val ____ptr = apply()
      (!____ptr).glyph_format = glyph_format
      (!____ptr).raster_new = raster_new
      (!____ptr).raster_reset = raster_reset
      (!____ptr).raster_set_mode = raster_set_mode
      (!____ptr).raster_render = raster_render
      (!____ptr).raster_done = raster_done
      ____ptr
    extension (struct: FT_Raster_Funcs)
      def glyph_format : FT_Glyph_Format = struct._1
      def glyph_format_=(value: FT_Glyph_Format): Unit = !struct.at1 = value
      def raster_new : FT_Raster_NewFunc = struct._2
      def raster_new_=(value: FT_Raster_NewFunc): Unit = !struct.at2 = value
      def raster_reset : FT_Raster_ResetFunc = struct._3
      def raster_reset_=(value: FT_Raster_ResetFunc): Unit = !struct.at3 = value
      def raster_set_mode : FT_Raster_SetModeFunc = struct._4
      def raster_set_mode_=(value: FT_Raster_SetModeFunc): Unit = !struct.at4 = value
      def raster_render : FT_Raster_RenderFunc = struct._5
      def raster_render_=(value: FT_Raster_RenderFunc): Unit = !struct.at5 = value
      def raster_done : FT_Raster_DoneFunc = struct._6
      def raster_done_=(value: FT_Raster_DoneFunc): Unit = !struct.at6 = value

  /**
   * ************************************************************************
  */
  opaque type FT_Raster_Funcs_ = CStruct6[FT_Glyph_Format, FT_Raster_NewFunc, FT_Raster_ResetFunc, FT_Raster_SetModeFunc, FT_Raster_RenderFunc, FT_Raster_DoneFunc]
  object FT_Raster_Funcs_ :
    given _tag: Tag[FT_Raster_Funcs_] = Tag.materializeCStruct6Tag[FT_Glyph_Format, FT_Raster_NewFunc, FT_Raster_ResetFunc, FT_Raster_SetModeFunc, FT_Raster_RenderFunc, FT_Raster_DoneFunc]
    def apply()(using Zone): Ptr[FT_Raster_Funcs_] = scala.scalanative.unsafe.alloc[FT_Raster_Funcs_](1)
    def apply(glyph_format : FT_Glyph_Format, raster_new : FT_Raster_NewFunc, raster_reset : FT_Raster_ResetFunc, raster_set_mode : FT_Raster_SetModeFunc, raster_render : FT_Raster_RenderFunc, raster_done : FT_Raster_DoneFunc)(using Zone): Ptr[FT_Raster_Funcs_] = 
      val ____ptr = apply()
      (!____ptr).glyph_format = glyph_format
      (!____ptr).raster_new = raster_new
      (!____ptr).raster_reset = raster_reset
      (!____ptr).raster_set_mode = raster_set_mode
      (!____ptr).raster_render = raster_render
      (!____ptr).raster_done = raster_done
      ____ptr
    extension (struct: FT_Raster_Funcs_)
      def glyph_format : FT_Glyph_Format = struct._1
      def glyph_format_=(value: FT_Glyph_Format): Unit = !struct.at1 = value
      def raster_new : FT_Raster_NewFunc = struct._2
      def raster_new_=(value: FT_Raster_NewFunc): Unit = !struct.at2 = value
      def raster_reset : FT_Raster_ResetFunc = struct._3
      def raster_reset_=(value: FT_Raster_ResetFunc): Unit = !struct.at3 = value
      def raster_set_mode : FT_Raster_SetModeFunc = struct._4
      def raster_set_mode_=(value: FT_Raster_SetModeFunc): Unit = !struct.at4 = value
      def raster_render : FT_Raster_RenderFunc = struct._5
      def raster_render_=(value: FT_Raster_RenderFunc): Unit = !struct.at5 = value
      def raster_done : FT_Raster_DoneFunc = struct._6
      def raster_done_=(value: FT_Raster_DoneFunc): Unit = !struct.at6 = value

  /**
   * ************************************************************************
  */
  opaque type FT_Raster_Params = CStruct9[Ptr[FT_Bitmap], Ptr[Byte], CInt, FT_SpanFunc, FT_SpanFunc, FT_Raster_BitTest_Func, FT_Raster_BitSet_Func, Ptr[Byte], FT_BBox]
  object FT_Raster_Params:
    given _tag: Tag[FT_Raster_Params] = Tag.materializeCStruct9Tag[Ptr[FT_Bitmap], Ptr[Byte], CInt, FT_SpanFunc, FT_SpanFunc, FT_Raster_BitTest_Func, FT_Raster_BitSet_Func, Ptr[Byte], FT_BBox]
    def apply()(using Zone): Ptr[FT_Raster_Params] = scala.scalanative.unsafe.alloc[FT_Raster_Params](1)
    def apply(target : Ptr[FT_Bitmap], source : Ptr[Byte], flags : CInt, gray_spans : FT_SpanFunc, black_spans : FT_SpanFunc, bit_test : FT_Raster_BitTest_Func, bit_set : FT_Raster_BitSet_Func, user : Ptr[Byte], clip_box : FT_BBox)(using Zone): Ptr[FT_Raster_Params] = 
      val ____ptr = apply()
      (!____ptr).target = target
      (!____ptr).source = source
      (!____ptr).flags = flags
      (!____ptr).gray_spans = gray_spans
      (!____ptr).black_spans = black_spans
      (!____ptr).bit_test = bit_test
      (!____ptr).bit_set = bit_set
      (!____ptr).user = user
      (!____ptr).clip_box = clip_box
      ____ptr
    extension (struct: FT_Raster_Params)
      def target : Ptr[FT_Bitmap] = struct._1
      def target_=(value: Ptr[FT_Bitmap]): Unit = !struct.at1 = value
      def source : Ptr[Byte] = struct._2
      def source_=(value: Ptr[Byte]): Unit = !struct.at2 = value
      def flags : CInt = struct._3
      def flags_=(value: CInt): Unit = !struct.at3 = value
      def gray_spans : FT_SpanFunc = struct._4
      def gray_spans_=(value: FT_SpanFunc): Unit = !struct.at4 = value
      def black_spans : FT_SpanFunc = struct._5
      def black_spans_=(value: FT_SpanFunc): Unit = !struct.at5 = value
      def bit_test : FT_Raster_BitTest_Func = struct._6
      def bit_test_=(value: FT_Raster_BitTest_Func): Unit = !struct.at6 = value
      def bit_set : FT_Raster_BitSet_Func = struct._7
      def bit_set_=(value: FT_Raster_BitSet_Func): Unit = !struct.at7 = value
      def user : Ptr[Byte] = struct._8
      def user_=(value: Ptr[Byte]): Unit = !struct.at8 = value
      def clip_box : FT_BBox = struct._9
      def clip_box_=(value: FT_BBox): Unit = !struct.at9 = value

  /**
   * ************************************************************************
  */
  opaque type FT_Raster_Params_ = CStruct9[Ptr[FT_Bitmap], Ptr[Byte], CInt, FT_SpanFunc, FT_SpanFunc, FT_Raster_BitTest_Func, FT_Raster_BitSet_Func, Ptr[Byte], FT_BBox]
  object FT_Raster_Params_ :
    given _tag: Tag[FT_Raster_Params_] = Tag.materializeCStruct9Tag[Ptr[FT_Bitmap], Ptr[Byte], CInt, FT_SpanFunc, FT_SpanFunc, FT_Raster_BitTest_Func, FT_Raster_BitSet_Func, Ptr[Byte], FT_BBox]
    def apply()(using Zone): Ptr[FT_Raster_Params_] = scala.scalanative.unsafe.alloc[FT_Raster_Params_](1)
    def apply(target : Ptr[FT_Bitmap], source : Ptr[Byte], flags : CInt, gray_spans : FT_SpanFunc, black_spans : FT_SpanFunc, bit_test : FT_Raster_BitTest_Func, bit_set : FT_Raster_BitSet_Func, user : Ptr[Byte], clip_box : FT_BBox)(using Zone): Ptr[FT_Raster_Params_] = 
      val ____ptr = apply()
      (!____ptr).target = target
      (!____ptr).source = source
      (!____ptr).flags = flags
      (!____ptr).gray_spans = gray_spans
      (!____ptr).black_spans = black_spans
      (!____ptr).bit_test = bit_test
      (!____ptr).bit_set = bit_set
      (!____ptr).user = user
      (!____ptr).clip_box = clip_box
      ____ptr
    extension (struct: FT_Raster_Params_)
      def target : Ptr[FT_Bitmap] = struct._1
      def target_=(value: Ptr[FT_Bitmap]): Unit = !struct.at1 = value
      def source : Ptr[Byte] = struct._2
      def source_=(value: Ptr[Byte]): Unit = !struct.at2 = value
      def flags : CInt = struct._3
      def flags_=(value: CInt): Unit = !struct.at3 = value
      def gray_spans : FT_SpanFunc = struct._4
      def gray_spans_=(value: FT_SpanFunc): Unit = !struct.at4 = value
      def black_spans : FT_SpanFunc = struct._5
      def black_spans_=(value: FT_SpanFunc): Unit = !struct.at5 = value
      def bit_test : FT_Raster_BitTest_Func = struct._6
      def bit_test_=(value: FT_Raster_BitTest_Func): Unit = !struct.at6 = value
      def bit_set : FT_Raster_BitSet_Func = struct._7
      def bit_set_=(value: FT_Raster_BitSet_Func): Unit = !struct.at7 = value
      def user : Ptr[Byte] = struct._8
      def user_=(value: Ptr[Byte]): Unit = !struct.at8 = value
      def clip_box : FT_BBox = struct._9
      def clip_box_=(value: FT_BBox): Unit = !struct.at9 = value

  opaque type FT_RendererRec_ = CStruct0
  object FT_RendererRec_ :
    given _tag: Tag[FT_RendererRec_] = Tag.materializeCStruct0Tag

  /**
   * ************************************************************************
  */
  opaque type FT_SizeRec = CStruct4[FT_Face, FT_Generic, FT_Size_Metrics, FT_Size_Internal]
  object FT_SizeRec:
    given _tag: Tag[FT_SizeRec] = Tag.materializeCStruct4Tag[FT_Face, FT_Generic, FT_Size_Metrics, FT_Size_Internal]
    def apply()(using Zone): Ptr[FT_SizeRec] = scala.scalanative.unsafe.alloc[FT_SizeRec](1)
    def apply(face : FT_Face, generic : FT_Generic, metrics : FT_Size_Metrics, internal : FT_Size_Internal)(using Zone): Ptr[FT_SizeRec] = 
      val ____ptr = apply()
      (!____ptr).face = face
      (!____ptr).generic = generic
      (!____ptr).metrics = metrics
      (!____ptr).internal = internal
      ____ptr
    extension (struct: FT_SizeRec)
      def face : FT_Face = struct._1
      def face_=(value: FT_Face): Unit = !struct.at1 = value
      def generic : FT_Generic = struct._2
      def generic_=(value: FT_Generic): Unit = !struct.at2 = value
      def metrics : FT_Size_Metrics = struct._3
      def metrics_=(value: FT_Size_Metrics): Unit = !struct.at3 = value
      def internal : FT_Size_Internal = struct._4
      def internal_=(value: FT_Size_Internal): Unit = !struct.at4 = value

  /**
   * ************************************************************************
  */
  opaque type FT_SizeRec_ = CStruct4[FT_Face, FT_Generic, FT_Size_Metrics, FT_Size_Internal]
  object FT_SizeRec_ :
    given _tag: Tag[FT_SizeRec_] = Tag.materializeCStruct4Tag[FT_Face, FT_Generic, FT_Size_Metrics, FT_Size_Internal]
    def apply()(using Zone): Ptr[FT_SizeRec_] = scala.scalanative.unsafe.alloc[FT_SizeRec_](1)
    def apply(face : FT_Face, generic : FT_Generic, metrics : FT_Size_Metrics, internal : FT_Size_Internal)(using Zone): Ptr[FT_SizeRec_] = 
      val ____ptr = apply()
      (!____ptr).face = face
      (!____ptr).generic = generic
      (!____ptr).metrics = metrics
      (!____ptr).internal = internal
      ____ptr
    extension (struct: FT_SizeRec_)
      def face : FT_Face = struct._1
      def face_=(value: FT_Face): Unit = !struct.at1 = value
      def generic : FT_Generic = struct._2
      def generic_=(value: FT_Generic): Unit = !struct.at2 = value
      def metrics : FT_Size_Metrics = struct._3
      def metrics_=(value: FT_Size_Metrics): Unit = !struct.at3 = value
      def internal : FT_Size_Internal = struct._4
      def internal_=(value: FT_Size_Internal): Unit = !struct.at4 = value

  opaque type FT_Size_InternalRec_ = CStruct0
  object FT_Size_InternalRec_ :
    given _tag: Tag[FT_Size_InternalRec_] = Tag.materializeCStruct0Tag

  /**
   * ************************************************************************
  */
  opaque type FT_Size_Metrics = CStruct8[FT_UShort, FT_UShort, FT_Fixed, FT_Fixed, FT_Pos, FT_Pos, FT_Pos, FT_Pos]
  object FT_Size_Metrics:
    given _tag: Tag[FT_Size_Metrics] = Tag.materializeCStruct8Tag[FT_UShort, FT_UShort, FT_Fixed, FT_Fixed, FT_Pos, FT_Pos, FT_Pos, FT_Pos]
    def apply()(using Zone): Ptr[FT_Size_Metrics] = scala.scalanative.unsafe.alloc[FT_Size_Metrics](1)
    def apply(x_ppem : FT_UShort, y_ppem : FT_UShort, x_scale : FT_Fixed, y_scale : FT_Fixed, ascender : FT_Pos, descender : FT_Pos, height : FT_Pos, max_advance : FT_Pos)(using Zone): Ptr[FT_Size_Metrics] = 
      val ____ptr = apply()
      (!____ptr).x_ppem = x_ppem
      (!____ptr).y_ppem = y_ppem
      (!____ptr).x_scale = x_scale
      (!____ptr).y_scale = y_scale
      (!____ptr).ascender = ascender
      (!____ptr).descender = descender
      (!____ptr).height = height
      (!____ptr).max_advance = max_advance
      ____ptr
    extension (struct: FT_Size_Metrics)
      def x_ppem : FT_UShort = struct._1
      def x_ppem_=(value: FT_UShort): Unit = !struct.at1 = value
      def y_ppem : FT_UShort = struct._2
      def y_ppem_=(value: FT_UShort): Unit = !struct.at2 = value
      def x_scale : FT_Fixed = struct._3
      def x_scale_=(value: FT_Fixed): Unit = !struct.at3 = value
      def y_scale : FT_Fixed = struct._4
      def y_scale_=(value: FT_Fixed): Unit = !struct.at4 = value
      def ascender : FT_Pos = struct._5
      def ascender_=(value: FT_Pos): Unit = !struct.at5 = value
      def descender : FT_Pos = struct._6
      def descender_=(value: FT_Pos): Unit = !struct.at6 = value
      def height : FT_Pos = struct._7
      def height_=(value: FT_Pos): Unit = !struct.at7 = value
      def max_advance : FT_Pos = struct._8
      def max_advance_=(value: FT_Pos): Unit = !struct.at8 = value

  /**
   * ************************************************************************
  */
  opaque type FT_Size_Metrics_ = CStruct8[FT_UShort, FT_UShort, FT_Fixed, FT_Fixed, FT_Pos, FT_Pos, FT_Pos, FT_Pos]
  object FT_Size_Metrics_ :
    given _tag: Tag[FT_Size_Metrics_] = Tag.materializeCStruct8Tag[FT_UShort, FT_UShort, FT_Fixed, FT_Fixed, FT_Pos, FT_Pos, FT_Pos, FT_Pos]
    def apply()(using Zone): Ptr[FT_Size_Metrics_] = scala.scalanative.unsafe.alloc[FT_Size_Metrics_](1)
    def apply(x_ppem : FT_UShort, y_ppem : FT_UShort, x_scale : FT_Fixed, y_scale : FT_Fixed, ascender : FT_Pos, descender : FT_Pos, height : FT_Pos, max_advance : FT_Pos)(using Zone): Ptr[FT_Size_Metrics_] = 
      val ____ptr = apply()
      (!____ptr).x_ppem = x_ppem
      (!____ptr).y_ppem = y_ppem
      (!____ptr).x_scale = x_scale
      (!____ptr).y_scale = y_scale
      (!____ptr).ascender = ascender
      (!____ptr).descender = descender
      (!____ptr).height = height
      (!____ptr).max_advance = max_advance
      ____ptr
    extension (struct: FT_Size_Metrics_)
      def x_ppem : FT_UShort = struct._1
      def x_ppem_=(value: FT_UShort): Unit = !struct.at1 = value
      def y_ppem : FT_UShort = struct._2
      def y_ppem_=(value: FT_UShort): Unit = !struct.at2 = value
      def x_scale : FT_Fixed = struct._3
      def x_scale_=(value: FT_Fixed): Unit = !struct.at3 = value
      def y_scale : FT_Fixed = struct._4
      def y_scale_=(value: FT_Fixed): Unit = !struct.at4 = value
      def ascender : FT_Pos = struct._5
      def ascender_=(value: FT_Pos): Unit = !struct.at5 = value
      def descender : FT_Pos = struct._6
      def descender_=(value: FT_Pos): Unit = !struct.at6 = value
      def height : FT_Pos = struct._7
      def height_=(value: FT_Pos): Unit = !struct.at7 = value
      def max_advance : FT_Pos = struct._8
      def max_advance_=(value: FT_Pos): Unit = !struct.at8 = value

  /**
   * ************************************************************************
  */
  opaque type FT_Size_RequestRec = CStruct5[FT_Size_Request_Type, FT_Long, FT_Long, FT_UInt, FT_UInt]
  object FT_Size_RequestRec:
    given _tag: Tag[FT_Size_RequestRec] = Tag.materializeCStruct5Tag[FT_Size_Request_Type, FT_Long, FT_Long, FT_UInt, FT_UInt]
    def apply()(using Zone): Ptr[FT_Size_RequestRec] = scala.scalanative.unsafe.alloc[FT_Size_RequestRec](1)
    def apply(`type` : FT_Size_Request_Type, width : FT_Long, height : FT_Long, horiResolution : FT_UInt, vertResolution : FT_UInt)(using Zone): Ptr[FT_Size_RequestRec] = 
      val ____ptr = apply()
      (!____ptr).`type` = `type`
      (!____ptr).width = width
      (!____ptr).height = height
      (!____ptr).horiResolution = horiResolution
      (!____ptr).vertResolution = vertResolution
      ____ptr
    extension (struct: FT_Size_RequestRec)
      def `type` : FT_Size_Request_Type = struct._1
      def type_=(value: FT_Size_Request_Type): Unit = !struct.at1 = value
      def width : FT_Long = struct._2
      def width_=(value: FT_Long): Unit = !struct.at2 = value
      def height : FT_Long = struct._3
      def height_=(value: FT_Long): Unit = !struct.at3 = value
      def horiResolution : FT_UInt = struct._4
      def horiResolution_=(value: FT_UInt): Unit = !struct.at4 = value
      def vertResolution : FT_UInt = struct._5
      def vertResolution_=(value: FT_UInt): Unit = !struct.at5 = value

  /**
   * ************************************************************************
  */
  opaque type FT_Size_RequestRec_ = CStruct5[FT_Size_Request_Type, FT_Long, FT_Long, FT_UInt, FT_UInt]
  object FT_Size_RequestRec_ :
    given _tag: Tag[FT_Size_RequestRec_] = Tag.materializeCStruct5Tag[FT_Size_Request_Type, FT_Long, FT_Long, FT_UInt, FT_UInt]
    def apply()(using Zone): Ptr[FT_Size_RequestRec_] = scala.scalanative.unsafe.alloc[FT_Size_RequestRec_](1)
    def apply(`type` : FT_Size_Request_Type, width : FT_Long, height : FT_Long, horiResolution : FT_UInt, vertResolution : FT_UInt)(using Zone): Ptr[FT_Size_RequestRec_] = 
      val ____ptr = apply()
      (!____ptr).`type` = `type`
      (!____ptr).width = width
      (!____ptr).height = height
      (!____ptr).horiResolution = horiResolution
      (!____ptr).vertResolution = vertResolution
      ____ptr
    extension (struct: FT_Size_RequestRec_)
      def `type` : FT_Size_Request_Type = struct._1
      def type_=(value: FT_Size_Request_Type): Unit = !struct.at1 = value
      def width : FT_Long = struct._2
      def width_=(value: FT_Long): Unit = !struct.at2 = value
      def height : FT_Long = struct._3
      def height_=(value: FT_Long): Unit = !struct.at3 = value
      def horiResolution : FT_UInt = struct._4
      def horiResolution_=(value: FT_UInt): Unit = !struct.at4 = value
      def vertResolution : FT_UInt = struct._5
      def vertResolution_=(value: FT_UInt): Unit = !struct.at5 = value

  opaque type FT_Slot_InternalRec_ = CStruct0
  object FT_Slot_InternalRec_ :
    given _tag: Tag[FT_Slot_InternalRec_] = Tag.materializeCStruct0Tag

  /**
   * ************************************************************************
  */
  opaque type FT_Span = CStruct3[CShort, CUnsignedShort, CUnsignedChar]
  object FT_Span:
    given _tag: Tag[FT_Span] = Tag.materializeCStruct3Tag[CShort, CUnsignedShort, CUnsignedChar]
    def apply()(using Zone): Ptr[FT_Span] = scala.scalanative.unsafe.alloc[FT_Span](1)
    def apply(x : CShort, len : CUnsignedShort, coverage : CUnsignedChar)(using Zone): Ptr[FT_Span] = 
      val ____ptr = apply()
      (!____ptr).x = x
      (!____ptr).len = len
      (!____ptr).coverage = coverage
      ____ptr
    extension (struct: FT_Span)
      def x : CShort = struct._1
      def x_=(value: CShort): Unit = !struct.at1 = value
      def len : CUnsignedShort = struct._2
      def len_=(value: CUnsignedShort): Unit = !struct.at2 = value
      def coverage : CUnsignedChar = struct._3
      def coverage_=(value: CUnsignedChar): Unit = !struct.at3 = value

  /**
   * ************************************************************************
  */
  opaque type FT_Span_ = CStruct3[CShort, CUnsignedShort, CUnsignedChar]
  object FT_Span_ :
    given _tag: Tag[FT_Span_] = Tag.materializeCStruct3Tag[CShort, CUnsignedShort, CUnsignedChar]
    def apply()(using Zone): Ptr[FT_Span_] = scala.scalanative.unsafe.alloc[FT_Span_](1)
    def apply(x : CShort, len : CUnsignedShort, coverage : CUnsignedChar)(using Zone): Ptr[FT_Span_] = 
      val ____ptr = apply()
      (!____ptr).x = x
      (!____ptr).len = len
      (!____ptr).coverage = coverage
      ____ptr
    extension (struct: FT_Span_)
      def x : CShort = struct._1
      def x_=(value: CShort): Unit = !struct.at1 = value
      def len : CUnsignedShort = struct._2
      def len_=(value: CUnsignedShort): Unit = !struct.at2 = value
      def coverage : CUnsignedChar = struct._3
      def coverage_=(value: CUnsignedChar): Unit = !struct.at3 = value

  /**
   * ************************************************************************
  */
  opaque type FT_StreamRec = CStruct10[Ptr[CUnsignedChar], CUnsignedLongInt, CUnsignedLongInt, FT_StreamDesc, FT_StreamDesc, Ptr[Byte], Ptr[Byte], FT_Memory, Ptr[CUnsignedChar], Ptr[CUnsignedChar]]
  object FT_StreamRec:
    given _tag: Tag[FT_StreamRec] = Tag.materializeCStruct10Tag[Ptr[CUnsignedChar], CUnsignedLongInt, CUnsignedLongInt, FT_StreamDesc, FT_StreamDesc, Ptr[Byte], Ptr[Byte], FT_Memory, Ptr[CUnsignedChar], Ptr[CUnsignedChar]]
    def apply()(using Zone): Ptr[FT_StreamRec] = scala.scalanative.unsafe.alloc[FT_StreamRec](1)
    def apply(base : Ptr[CUnsignedChar], size : CUnsignedLongInt, pos : CUnsignedLongInt, descriptor : FT_StreamDesc, pathname : FT_StreamDesc, read : FT_Stream_IoFunc, close : FT_Stream_CloseFunc, memory : FT_Memory, cursor : Ptr[CUnsignedChar], limit : Ptr[CUnsignedChar])(using Zone): Ptr[FT_StreamRec] = 
      val ____ptr = apply()
      (!____ptr).base = base
      (!____ptr).size = size
      (!____ptr).pos = pos
      (!____ptr).descriptor = descriptor
      (!____ptr).pathname = pathname
      (!____ptr).read = read
      (!____ptr).close = close
      (!____ptr).memory = memory
      (!____ptr).cursor = cursor
      (!____ptr).limit = limit
      ____ptr
    extension (struct: FT_StreamRec)
      def base : Ptr[CUnsignedChar] = struct._1
      def base_=(value: Ptr[CUnsignedChar]): Unit = !struct.at1 = value
      def size : CUnsignedLongInt = struct._2
      def size_=(value: CUnsignedLongInt): Unit = !struct.at2 = value
      def pos : CUnsignedLongInt = struct._3
      def pos_=(value: CUnsignedLongInt): Unit = !struct.at3 = value
      def descriptor : FT_StreamDesc = struct._4
      def descriptor_=(value: FT_StreamDesc): Unit = !struct.at4 = value
      def pathname : FT_StreamDesc = struct._5
      def pathname_=(value: FT_StreamDesc): Unit = !struct.at5 = value
      def read : FT_Stream_IoFunc = struct._6.asInstanceOf[FT_Stream_IoFunc]
      def read_=(value: FT_Stream_IoFunc): Unit = !struct.at6 = value.asInstanceOf[Ptr[Byte]]
      def close : FT_Stream_CloseFunc = struct._7.asInstanceOf[FT_Stream_CloseFunc]
      def close_=(value: FT_Stream_CloseFunc): Unit = !struct.at7 = value.asInstanceOf[Ptr[Byte]]
      def memory : FT_Memory = struct._8
      def memory_=(value: FT_Memory): Unit = !struct.at8 = value
      def cursor : Ptr[CUnsignedChar] = struct._9
      def cursor_=(value: Ptr[CUnsignedChar]): Unit = !struct.at9 = value
      def limit : Ptr[CUnsignedChar] = struct._10
      def limit_=(value: Ptr[CUnsignedChar]): Unit = !struct.at10 = value

  /**
   * ************************************************************************
  */
  opaque type FT_StreamRec_ = CStruct10[Ptr[CUnsignedChar], CUnsignedLongInt, CUnsignedLongInt, FT_StreamDesc, FT_StreamDesc, Ptr[Byte], Ptr[Byte], FT_Memory, Ptr[CUnsignedChar], Ptr[CUnsignedChar]]
  object FT_StreamRec_ :
    given _tag: Tag[FT_StreamRec_] = Tag.materializeCStruct10Tag[Ptr[CUnsignedChar], CUnsignedLongInt, CUnsignedLongInt, FT_StreamDesc, FT_StreamDesc, Ptr[Byte], Ptr[Byte], FT_Memory, Ptr[CUnsignedChar], Ptr[CUnsignedChar]]
    def apply()(using Zone): Ptr[FT_StreamRec_] = scala.scalanative.unsafe.alloc[FT_StreamRec_](1)
    def apply(base : Ptr[CUnsignedChar], size : CUnsignedLongInt, pos : CUnsignedLongInt, descriptor : FT_StreamDesc, pathname : FT_StreamDesc, read : FT_Stream_IoFunc, close : FT_Stream_CloseFunc, memory : FT_Memory, cursor : Ptr[CUnsignedChar], limit : Ptr[CUnsignedChar])(using Zone): Ptr[FT_StreamRec_] = 
      val ____ptr = apply()
      (!____ptr).base = base
      (!____ptr).size = size
      (!____ptr).pos = pos
      (!____ptr).descriptor = descriptor
      (!____ptr).pathname = pathname
      (!____ptr).read = read
      (!____ptr).close = close
      (!____ptr).memory = memory
      (!____ptr).cursor = cursor
      (!____ptr).limit = limit
      ____ptr
    extension (struct: FT_StreamRec_)
      def base : Ptr[CUnsignedChar] = struct._1
      def base_=(value: Ptr[CUnsignedChar]): Unit = !struct.at1 = value
      def size : CUnsignedLongInt = struct._2
      def size_=(value: CUnsignedLongInt): Unit = !struct.at2 = value
      def pos : CUnsignedLongInt = struct._3
      def pos_=(value: CUnsignedLongInt): Unit = !struct.at3 = value
      def descriptor : FT_StreamDesc = struct._4
      def descriptor_=(value: FT_StreamDesc): Unit = !struct.at4 = value
      def pathname : FT_StreamDesc = struct._5
      def pathname_=(value: FT_StreamDesc): Unit = !struct.at5 = value
      def read : FT_Stream_IoFunc = struct._6.asInstanceOf[FT_Stream_IoFunc]
      def read_=(value: FT_Stream_IoFunc): Unit = !struct.at6 = value.asInstanceOf[Ptr[Byte]]
      def close : FT_Stream_CloseFunc = struct._7.asInstanceOf[FT_Stream_CloseFunc]
      def close_=(value: FT_Stream_CloseFunc): Unit = !struct.at7 = value.asInstanceOf[Ptr[Byte]]
      def memory : FT_Memory = struct._8
      def memory_=(value: FT_Memory): Unit = !struct.at8 = value
      def cursor : Ptr[CUnsignedChar] = struct._9
      def cursor_=(value: Ptr[CUnsignedChar]): Unit = !struct.at9 = value
      def limit : Ptr[CUnsignedChar] = struct._10
      def limit_=(value: Ptr[CUnsignedChar]): Unit = !struct.at10 = value

  opaque type FT_SubGlyphRec_ = CStruct0
  object FT_SubGlyphRec_ :
    given _tag: Tag[FT_SubGlyphRec_] = Tag.materializeCStruct0Tag

  /**
   * ************************************************************************
  */
  opaque type FT_UnitVector = CStruct2[FT_F2Dot14, FT_F2Dot14]
  object FT_UnitVector:
    given _tag: Tag[FT_UnitVector] = Tag.materializeCStruct2Tag[FT_F2Dot14, FT_F2Dot14]
    def apply()(using Zone): Ptr[FT_UnitVector] = scala.scalanative.unsafe.alloc[FT_UnitVector](1)
    def apply(x : FT_F2Dot14, y : FT_F2Dot14)(using Zone): Ptr[FT_UnitVector] = 
      val ____ptr = apply()
      (!____ptr).x = x
      (!____ptr).y = y
      ____ptr
    extension (struct: FT_UnitVector)
      def x : FT_F2Dot14 = struct._1
      def x_=(value: FT_F2Dot14): Unit = !struct.at1 = value
      def y : FT_F2Dot14 = struct._2
      def y_=(value: FT_F2Dot14): Unit = !struct.at2 = value

  /**
   * ************************************************************************
  */
  opaque type FT_UnitVector_ = CStruct2[FT_F2Dot14, FT_F2Dot14]
  object FT_UnitVector_ :
    given _tag: Tag[FT_UnitVector_] = Tag.materializeCStruct2Tag[FT_F2Dot14, FT_F2Dot14]
    def apply()(using Zone): Ptr[FT_UnitVector_] = scala.scalanative.unsafe.alloc[FT_UnitVector_](1)
    def apply(x : FT_F2Dot14, y : FT_F2Dot14)(using Zone): Ptr[FT_UnitVector_] = 
      val ____ptr = apply()
      (!____ptr).x = x
      (!____ptr).y = y
      ____ptr
    extension (struct: FT_UnitVector_)
      def x : FT_F2Dot14 = struct._1
      def x_=(value: FT_F2Dot14): Unit = !struct.at1 = value
      def y : FT_F2Dot14 = struct._2
      def y_=(value: FT_F2Dot14): Unit = !struct.at2 = value

  /**
   * ************************************************************************
  */
  opaque type FT_Vector = CStruct2[FT_Pos, FT_Pos]
  object FT_Vector:
    given _tag: Tag[FT_Vector] = Tag.materializeCStruct2Tag[FT_Pos, FT_Pos]
    def apply()(using Zone): Ptr[FT_Vector] = scala.scalanative.unsafe.alloc[FT_Vector](1)
    def apply(x : FT_Pos, y : FT_Pos)(using Zone): Ptr[FT_Vector] = 
      val ____ptr = apply()
      (!____ptr).x = x
      (!____ptr).y = y
      ____ptr
    extension (struct: FT_Vector)
      def x : FT_Pos = struct._1
      def x_=(value: FT_Pos): Unit = !struct.at1 = value
      def y : FT_Pos = struct._2
      def y_=(value: FT_Pos): Unit = !struct.at2 = value

  /**
   * ************************************************************************
  */
  opaque type FT_Vector_ = CStruct2[FT_Pos, FT_Pos]
  object FT_Vector_ :
    given _tag: Tag[FT_Vector_] = Tag.materializeCStruct2Tag[FT_Pos, FT_Pos]
    def apply()(using Zone): Ptr[FT_Vector_] = scala.scalanative.unsafe.alloc[FT_Vector_](1)
    def apply(x : FT_Pos, y : FT_Pos)(using Zone): Ptr[FT_Vector_] = 
      val ____ptr = apply()
      (!____ptr).x = x
      (!____ptr).y = y
      ____ptr
    extension (struct: FT_Vector_)
      def x : FT_Pos = struct._1
      def x_=(value: FT_Pos): Unit = !struct.at1 = value
      def y : FT_Pos = struct._2
      def y_=(value: FT_Pos): Unit = !struct.at2 = value

  opaque type FcAtomic = CStruct0
  object FcAtomic:
    given _tag: Tag[FcAtomic] = Tag.materializeCStruct0Tag

  opaque type FcBlanks = CStruct0
  object FcBlanks:
    given _tag: Tag[FcBlanks] = Tag.materializeCStruct0Tag

  opaque type FcCache = CStruct0
  object FcCache:
    given _tag: Tag[FcCache] = Tag.materializeCStruct0Tag

  opaque type FcCharSet = CStruct0
  object FcCharSet:
    given _tag: Tag[FcCharSet] = Tag.materializeCStruct0Tag

  opaque type FcConfig = CStruct0
  object FcConfig:
    given _tag: Tag[FcConfig] = Tag.materializeCStruct0Tag

  opaque type FcConfigFileInfoIter = CStruct3[Ptr[Byte], Ptr[Byte], Ptr[Byte]]
  object FcConfigFileInfoIter:
    given _tag: Tag[FcConfigFileInfoIter] = Tag.materializeCStruct3Tag[Ptr[Byte], Ptr[Byte], Ptr[Byte]]
    def apply()(using Zone): Ptr[FcConfigFileInfoIter] = scala.scalanative.unsafe.alloc[FcConfigFileInfoIter](1)
    def apply(dummy1 : Ptr[Byte], dummy2 : Ptr[Byte], dummy3 : Ptr[Byte])(using Zone): Ptr[FcConfigFileInfoIter] = 
      val ____ptr = apply()
      (!____ptr).dummy1 = dummy1
      (!____ptr).dummy2 = dummy2
      (!____ptr).dummy3 = dummy3
      ____ptr
    extension (struct: FcConfigFileInfoIter)
      def dummy1 : Ptr[Byte] = struct._1
      def dummy1_=(value: Ptr[Byte]): Unit = !struct.at1 = value
      def dummy2 : Ptr[Byte] = struct._2
      def dummy2_=(value: Ptr[Byte]): Unit = !struct.at2 = value
      def dummy3 : Ptr[Byte] = struct._3
      def dummy3_=(value: Ptr[Byte]): Unit = !struct.at3 = value

  opaque type FcConstant = CStruct3[Ptr[FcChar8], CString, CInt]
  object FcConstant:
    given _tag: Tag[FcConstant] = Tag.materializeCStruct3Tag[Ptr[FcChar8], CString, CInt]
    def apply()(using Zone): Ptr[FcConstant] = scala.scalanative.unsafe.alloc[FcConstant](1)
    def apply(name : Ptr[FcChar8], `object` : CString, value : CInt)(using Zone): Ptr[FcConstant] = 
      val ____ptr = apply()
      (!____ptr).name = name
      (!____ptr).`object` = `object`
      (!____ptr).value = value
      ____ptr
    extension (struct: FcConstant)
      def name : Ptr[FcChar8] = struct._1
      def name_=(value: Ptr[FcChar8]): Unit = !struct.at1 = value
      def `object` : CString = struct._2
      def object_=(value: CString): Unit = !struct.at2 = value
      def value : CInt = struct._3
      def value_=(value: CInt): Unit = !struct.at3 = value

  opaque type FcFileCache = CStruct0
  object FcFileCache:
    given _tag: Tag[FcFileCache] = Tag.materializeCStruct0Tag

  opaque type FcFontSet = CStruct3[CInt, CInt, Ptr[Ptr[FcPattern]]]
  object FcFontSet:
    given _tag: Tag[FcFontSet] = Tag.materializeCStruct3Tag[CInt, CInt, Ptr[Ptr[FcPattern]]]
    def apply()(using Zone): Ptr[FcFontSet] = scala.scalanative.unsafe.alloc[FcFontSet](1)
    def apply(nfont : CInt, sfont : CInt, fonts : Ptr[Ptr[FcPattern]])(using Zone): Ptr[FcFontSet] = 
      val ____ptr = apply()
      (!____ptr).nfont = nfont
      (!____ptr).sfont = sfont
      (!____ptr).fonts = fonts
      ____ptr
    extension (struct: FcFontSet)
      def nfont : CInt = struct._1
      def nfont_=(value: CInt): Unit = !struct.at1 = value
      def sfont : CInt = struct._2
      def sfont_=(value: CInt): Unit = !struct.at2 = value
      def fonts : Ptr[Ptr[FcPattern]] = struct._3
      def fonts_=(value: Ptr[Ptr[FcPattern]]): Unit = !struct.at3 = value

  opaque type FcLangSet = CStruct0
  object FcLangSet:
    given _tag: Tag[FcLangSet] = Tag.materializeCStruct0Tag

  opaque type FcMatrix = CStruct4[Double, Double, Double, Double]
  object FcMatrix:
    given _tag: Tag[FcMatrix] = Tag.materializeCStruct4Tag[Double, Double, Double, Double]
    def apply()(using Zone): Ptr[FcMatrix] = scala.scalanative.unsafe.alloc[FcMatrix](1)
    def apply(xx : Double, xy : Double, yx : Double, yy : Double)(using Zone): Ptr[FcMatrix] = 
      val ____ptr = apply()
      (!____ptr).xx = xx
      (!____ptr).xy = xy
      (!____ptr).yx = yx
      (!____ptr).yy = yy
      ____ptr
    extension (struct: FcMatrix)
      def xx : Double = struct._1
      def xx_=(value: Double): Unit = !struct.at1 = value
      def xy : Double = struct._2
      def xy_=(value: Double): Unit = !struct.at2 = value
      def yx : Double = struct._3
      def yx_=(value: Double): Unit = !struct.at3 = value
      def yy : Double = struct._4
      def yy_=(value: Double): Unit = !struct.at4 = value

  opaque type FcObjectSet = CStruct3[CInt, CInt, Ptr[CString]]
  object FcObjectSet:
    given _tag: Tag[FcObjectSet] = Tag.materializeCStruct3Tag[CInt, CInt, Ptr[CString]]
    def apply()(using Zone): Ptr[FcObjectSet] = scala.scalanative.unsafe.alloc[FcObjectSet](1)
    def apply(nobject : CInt, sobject : CInt, objects : Ptr[CString])(using Zone): Ptr[FcObjectSet] = 
      val ____ptr = apply()
      (!____ptr).nobject = nobject
      (!____ptr).sobject = sobject
      (!____ptr).objects = objects
      ____ptr
    extension (struct: FcObjectSet)
      def nobject : CInt = struct._1
      def nobject_=(value: CInt): Unit = !struct.at1 = value
      def sobject : CInt = struct._2
      def sobject_=(value: CInt): Unit = !struct.at2 = value
      def objects : Ptr[CString] = struct._3
      def objects_=(value: Ptr[CString]): Unit = !struct.at3 = value

  opaque type FcObjectType = CStruct2[CString, FcType]
  object FcObjectType:
    given _tag: Tag[FcObjectType] = Tag.materializeCStruct2Tag[CString, FcType]
    def apply()(using Zone): Ptr[FcObjectType] = scala.scalanative.unsafe.alloc[FcObjectType](1)
    def apply(`object` : CString, `type` : FcType)(using Zone): Ptr[FcObjectType] = 
      val ____ptr = apply()
      (!____ptr).`object` = `object`
      (!____ptr).`type` = `type`
      ____ptr
    extension (struct: FcObjectType)
      def `object` : CString = struct._1
      def object_=(value: CString): Unit = !struct.at1 = value
      def `type` : FcType = struct._2
      def type_=(value: FcType): Unit = !struct.at2 = value

  opaque type FcPattern = CStruct0
  object FcPattern:
    given _tag: Tag[FcPattern] = Tag.materializeCStruct0Tag

  opaque type FcPatternIter = CStruct2[Ptr[Byte], Ptr[Byte]]
  object FcPatternIter:
    given _tag: Tag[FcPatternIter] = Tag.materializeCStruct2Tag[Ptr[Byte], Ptr[Byte]]
    def apply()(using Zone): Ptr[FcPatternIter] = scala.scalanative.unsafe.alloc[FcPatternIter](1)
    def apply(dummy1 : Ptr[Byte], dummy2 : Ptr[Byte])(using Zone): Ptr[FcPatternIter] = 
      val ____ptr = apply()
      (!____ptr).dummy1 = dummy1
      (!____ptr).dummy2 = dummy2
      ____ptr
    extension (struct: FcPatternIter)
      def dummy1 : Ptr[Byte] = struct._1
      def dummy1_=(value: Ptr[Byte]): Unit = !struct.at1 = value
      def dummy2 : Ptr[Byte] = struct._2
      def dummy2_=(value: Ptr[Byte]): Unit = !struct.at2 = value

  opaque type FcRange = CStruct0
  object FcRange:
    given _tag: Tag[FcRange] = Tag.materializeCStruct0Tag

  opaque type FcStrList = CStruct0
  object FcStrList:
    given _tag: Tag[FcStrList] = Tag.materializeCStruct0Tag

  opaque type FcStrSet = CStruct0
  object FcStrSet:
    given _tag: Tag[FcStrSet] = Tag.materializeCStruct0Tag

  opaque type FcValue = CStruct2[FcType, FcValue.Union0]
  object FcValue:
    opaque type Union0 = CArray[Byte, Nat._8]
    object Union0:
      given _tag: Tag[Union0] = Tag.CArray[CChar, Nat._8](Tag.Byte, Tag.Nat8)
      def apply()(using Zone): Ptr[Union0] = 
        val ___ptr = alloc[Union0](1)
        ___ptr
      @scala.annotation.targetName("apply_s")
      def apply(s: Ptr[FcChar8])(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[Ptr[FcChar8]]].update(0, s)
        ___ptr
      @scala.annotation.targetName("apply_i")
      def apply(i: CInt)(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[CInt]].update(0, i)
        ___ptr
      @scala.annotation.targetName("apply_b")
      def apply(b: FcBool)(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[FcBool]].update(0, b)
        ___ptr
      @scala.annotation.targetName("apply_d")
      def apply(d: Double)(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[Double]].update(0, d)
        ___ptr
      @scala.annotation.targetName("apply_m")
      def apply(m: Ptr[FcMatrix])(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[Ptr[FcMatrix]]].update(0, m)
        ___ptr
      @scala.annotation.targetName("apply_c")
      def apply(c: Ptr[FcCharSet])(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[Ptr[FcCharSet]]].update(0, c)
        ___ptr
      @scala.annotation.targetName("apply_f")
      def apply(f: Ptr[Byte])(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[Ptr[Byte]]].update(0, f)
        ___ptr
      @scala.annotation.targetName("apply_l")
      def apply(l: Ptr[FcLangSet])(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[Ptr[FcLangSet]]].update(0, l)
        ___ptr
      @scala.annotation.targetName("apply_r")
      def apply(r: Ptr[FcRange])(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[Ptr[FcRange]]].update(0, r)
        ___ptr
      extension (struct: Union0)
        def s : Ptr[FcChar8] = !struct.at(0).asInstanceOf[Ptr[Ptr[FcChar8]]]
        def s_=(value: Ptr[FcChar8]): Unit = !struct.at(0).asInstanceOf[Ptr[Ptr[FcChar8]]] = value
        def i : CInt = !struct.at(0).asInstanceOf[Ptr[CInt]]
        def i_=(value: CInt): Unit = !struct.at(0).asInstanceOf[Ptr[CInt]] = value
        def b : FcBool = !struct.at(0).asInstanceOf[Ptr[FcBool]]
        def b_=(value: FcBool): Unit = !struct.at(0).asInstanceOf[Ptr[FcBool]] = value
        def d : Double = !struct.at(0).asInstanceOf[Ptr[Double]]
        def d_=(value: Double): Unit = !struct.at(0).asInstanceOf[Ptr[Double]] = value
        def m : Ptr[FcMatrix] = !struct.at(0).asInstanceOf[Ptr[Ptr[FcMatrix]]]
        def m_=(value: Ptr[FcMatrix]): Unit = !struct.at(0).asInstanceOf[Ptr[Ptr[FcMatrix]]] = value
        def c : Ptr[FcCharSet] = !struct.at(0).asInstanceOf[Ptr[Ptr[FcCharSet]]]
        def c_=(value: Ptr[FcCharSet]): Unit = !struct.at(0).asInstanceOf[Ptr[Ptr[FcCharSet]]] = value
        def f : Ptr[Byte] = !struct.at(0).asInstanceOf[Ptr[Ptr[Byte]]]
        def f_=(value: Ptr[Byte]): Unit = !struct.at(0).asInstanceOf[Ptr[Ptr[Byte]]] = value
        def l : Ptr[FcLangSet] = !struct.at(0).asInstanceOf[Ptr[Ptr[FcLangSet]]]
        def l_=(value: Ptr[FcLangSet]): Unit = !struct.at(0).asInstanceOf[Ptr[Ptr[FcLangSet]]] = value
        def r : Ptr[FcRange] = !struct.at(0).asInstanceOf[Ptr[Ptr[FcRange]]]
        def r_=(value: Ptr[FcRange]): Unit = !struct.at(0).asInstanceOf[Ptr[Ptr[FcRange]]] = value
    given _tag: Tag[FcValue] = Tag.materializeCStruct2Tag[FcType, FcValue.Union0]
    def apply()(using Zone): Ptr[FcValue] = scala.scalanative.unsafe.alloc[FcValue](1)
    def apply(`type` : FcType, u : FcValue.Union0)(using Zone): Ptr[FcValue] = 
      val ____ptr = apply()
      (!____ptr).`type` = `type`
      (!____ptr).u = u
      ____ptr
    extension (struct: FcValue)
      def `type` : FcType = struct._1
      def type_=(value: FcType): Unit = !struct.at1 = value
      def u : FcValue.Union0 = struct._2
      def u_=(value: FcValue.Union0): Unit = !struct.at2 = value

  opaque type _FcAtomic = CStruct0
  object _FcAtomic:
    given _tag: Tag[_FcAtomic] = Tag.materializeCStruct0Tag

  opaque type _FcBlanks = CStruct0
  object _FcBlanks:
    given _tag: Tag[_FcBlanks] = Tag.materializeCStruct0Tag

  opaque type _FcCache = CStruct0
  object _FcCache:
    given _tag: Tag[_FcCache] = Tag.materializeCStruct0Tag

  opaque type _FcCharSet = CStruct0
  object _FcCharSet:
    given _tag: Tag[_FcCharSet] = Tag.materializeCStruct0Tag

  opaque type _FcConfig = CStruct0
  object _FcConfig:
    given _tag: Tag[_FcConfig] = Tag.materializeCStruct0Tag

  opaque type _FcConfigFileInfoIter = CStruct3[Ptr[Byte], Ptr[Byte], Ptr[Byte]]
  object _FcConfigFileInfoIter:
    given _tag: Tag[_FcConfigFileInfoIter] = Tag.materializeCStruct3Tag[Ptr[Byte], Ptr[Byte], Ptr[Byte]]
    def apply()(using Zone): Ptr[_FcConfigFileInfoIter] = scala.scalanative.unsafe.alloc[_FcConfigFileInfoIter](1)
    def apply(dummy1 : Ptr[Byte], dummy2 : Ptr[Byte], dummy3 : Ptr[Byte])(using Zone): Ptr[_FcConfigFileInfoIter] = 
      val ____ptr = apply()
      (!____ptr).dummy1 = dummy1
      (!____ptr).dummy2 = dummy2
      (!____ptr).dummy3 = dummy3
      ____ptr
    extension (struct: _FcConfigFileInfoIter)
      def dummy1 : Ptr[Byte] = struct._1
      def dummy1_=(value: Ptr[Byte]): Unit = !struct.at1 = value
      def dummy2 : Ptr[Byte] = struct._2
      def dummy2_=(value: Ptr[Byte]): Unit = !struct.at2 = value
      def dummy3 : Ptr[Byte] = struct._3
      def dummy3_=(value: Ptr[Byte]): Unit = !struct.at3 = value

  opaque type _FcConstant = CStruct3[Ptr[FcChar8], CString, CInt]
  object _FcConstant:
    given _tag: Tag[_FcConstant] = Tag.materializeCStruct3Tag[Ptr[FcChar8], CString, CInt]
    def apply()(using Zone): Ptr[_FcConstant] = scala.scalanative.unsafe.alloc[_FcConstant](1)
    def apply(name : Ptr[FcChar8], `object` : CString, value : CInt)(using Zone): Ptr[_FcConstant] = 
      val ____ptr = apply()
      (!____ptr).name = name
      (!____ptr).`object` = `object`
      (!____ptr).value = value
      ____ptr
    extension (struct: _FcConstant)
      def name : Ptr[FcChar8] = struct._1
      def name_=(value: Ptr[FcChar8]): Unit = !struct.at1 = value
      def `object` : CString = struct._2
      def object_=(value: CString): Unit = !struct.at2 = value
      def value : CInt = struct._3
      def value_=(value: CInt): Unit = !struct.at3 = value

  opaque type _FcFontSet = CStruct3[CInt, CInt, Ptr[Ptr[FcPattern]]]
  object _FcFontSet:
    given _tag: Tag[_FcFontSet] = Tag.materializeCStruct3Tag[CInt, CInt, Ptr[Ptr[FcPattern]]]
    def apply()(using Zone): Ptr[_FcFontSet] = scala.scalanative.unsafe.alloc[_FcFontSet](1)
    def apply(nfont : CInt, sfont : CInt, fonts : Ptr[Ptr[FcPattern]])(using Zone): Ptr[_FcFontSet] = 
      val ____ptr = apply()
      (!____ptr).nfont = nfont
      (!____ptr).sfont = sfont
      (!____ptr).fonts = fonts
      ____ptr
    extension (struct: _FcFontSet)
      def nfont : CInt = struct._1
      def nfont_=(value: CInt): Unit = !struct.at1 = value
      def sfont : CInt = struct._2
      def sfont_=(value: CInt): Unit = !struct.at2 = value
      def fonts : Ptr[Ptr[FcPattern]] = struct._3
      def fonts_=(value: Ptr[Ptr[FcPattern]]): Unit = !struct.at3 = value

  opaque type _FcGlobalCache = CStruct0
  object _FcGlobalCache:
    given _tag: Tag[_FcGlobalCache] = Tag.materializeCStruct0Tag

  opaque type _FcLangSet = CStruct0
  object _FcLangSet:
    given _tag: Tag[_FcLangSet] = Tag.materializeCStruct0Tag

  opaque type _FcMatrix = CStruct4[Double, Double, Double, Double]
  object _FcMatrix:
    given _tag: Tag[_FcMatrix] = Tag.materializeCStruct4Tag[Double, Double, Double, Double]
    def apply()(using Zone): Ptr[_FcMatrix] = scala.scalanative.unsafe.alloc[_FcMatrix](1)
    def apply(xx : Double, xy : Double, yx : Double, yy : Double)(using Zone): Ptr[_FcMatrix] = 
      val ____ptr = apply()
      (!____ptr).xx = xx
      (!____ptr).xy = xy
      (!____ptr).yx = yx
      (!____ptr).yy = yy
      ____ptr
    extension (struct: _FcMatrix)
      def xx : Double = struct._1
      def xx_=(value: Double): Unit = !struct.at1 = value
      def xy : Double = struct._2
      def xy_=(value: Double): Unit = !struct.at2 = value
      def yx : Double = struct._3
      def yx_=(value: Double): Unit = !struct.at3 = value
      def yy : Double = struct._4
      def yy_=(value: Double): Unit = !struct.at4 = value

  opaque type _FcObjectSet = CStruct3[CInt, CInt, Ptr[CString]]
  object _FcObjectSet:
    given _tag: Tag[_FcObjectSet] = Tag.materializeCStruct3Tag[CInt, CInt, Ptr[CString]]
    def apply()(using Zone): Ptr[_FcObjectSet] = scala.scalanative.unsafe.alloc[_FcObjectSet](1)
    def apply(nobject : CInt, sobject : CInt, objects : Ptr[CString])(using Zone): Ptr[_FcObjectSet] = 
      val ____ptr = apply()
      (!____ptr).nobject = nobject
      (!____ptr).sobject = sobject
      (!____ptr).objects = objects
      ____ptr
    extension (struct: _FcObjectSet)
      def nobject : CInt = struct._1
      def nobject_=(value: CInt): Unit = !struct.at1 = value
      def sobject : CInt = struct._2
      def sobject_=(value: CInt): Unit = !struct.at2 = value
      def objects : Ptr[CString] = struct._3
      def objects_=(value: Ptr[CString]): Unit = !struct.at3 = value

  opaque type _FcObjectType = CStruct2[CString, FcType]
  object _FcObjectType:
    given _tag: Tag[_FcObjectType] = Tag.materializeCStruct2Tag[CString, FcType]
    def apply()(using Zone): Ptr[_FcObjectType] = scala.scalanative.unsafe.alloc[_FcObjectType](1)
    def apply(`object` : CString, `type` : FcType)(using Zone): Ptr[_FcObjectType] = 
      val ____ptr = apply()
      (!____ptr).`object` = `object`
      (!____ptr).`type` = `type`
      ____ptr
    extension (struct: _FcObjectType)
      def `object` : CString = struct._1
      def object_=(value: CString): Unit = !struct.at1 = value
      def `type` : FcType = struct._2
      def type_=(value: FcType): Unit = !struct.at2 = value

  opaque type _FcPattern = CStruct0
  object _FcPattern:
    given _tag: Tag[_FcPattern] = Tag.materializeCStruct0Tag

  opaque type _FcPatternIter = CStruct2[Ptr[Byte], Ptr[Byte]]
  object _FcPatternIter:
    given _tag: Tag[_FcPatternIter] = Tag.materializeCStruct2Tag[Ptr[Byte], Ptr[Byte]]
    def apply()(using Zone): Ptr[_FcPatternIter] = scala.scalanative.unsafe.alloc[_FcPatternIter](1)
    def apply(dummy1 : Ptr[Byte], dummy2 : Ptr[Byte])(using Zone): Ptr[_FcPatternIter] = 
      val ____ptr = apply()
      (!____ptr).dummy1 = dummy1
      (!____ptr).dummy2 = dummy2
      ____ptr
    extension (struct: _FcPatternIter)
      def dummy1 : Ptr[Byte] = struct._1
      def dummy1_=(value: Ptr[Byte]): Unit = !struct.at1 = value
      def dummy2 : Ptr[Byte] = struct._2
      def dummy2_=(value: Ptr[Byte]): Unit = !struct.at2 = value

  opaque type _FcRange = CStruct0
  object _FcRange:
    given _tag: Tag[_FcRange] = Tag.materializeCStruct0Tag

  opaque type _FcStrList = CStruct0
  object _FcStrList:
    given _tag: Tag[_FcStrList] = Tag.materializeCStruct0Tag

  opaque type _FcStrSet = CStruct0
  object _FcStrSet:
    given _tag: Tag[_FcStrSet] = Tag.materializeCStruct0Tag

  opaque type _FcValue = CStruct2[FcType, _FcValue.Union0]
  object _FcValue:
    opaque type Union0 = CArray[Byte, Nat._8]
    object Union0:
      given _tag: Tag[Union0] = Tag.CArray[CChar, Nat._8](Tag.Byte, Tag.Nat8)
      def apply()(using Zone): Ptr[Union0] = 
        val ___ptr = alloc[Union0](1)
        ___ptr
      @scala.annotation.targetName("apply_s")
      def apply(s: Ptr[FcChar8])(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[Ptr[FcChar8]]].update(0, s)
        ___ptr
      @scala.annotation.targetName("apply_i")
      def apply(i: CInt)(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[CInt]].update(0, i)
        ___ptr
      @scala.annotation.targetName("apply_b")
      def apply(b: FcBool)(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[FcBool]].update(0, b)
        ___ptr
      @scala.annotation.targetName("apply_d")
      def apply(d: Double)(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[Double]].update(0, d)
        ___ptr
      @scala.annotation.targetName("apply_m")
      def apply(m: Ptr[FcMatrix])(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[Ptr[FcMatrix]]].update(0, m)
        ___ptr
      @scala.annotation.targetName("apply_c")
      def apply(c: Ptr[FcCharSet])(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[Ptr[FcCharSet]]].update(0, c)
        ___ptr
      @scala.annotation.targetName("apply_f")
      def apply(f: Ptr[Byte])(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[Ptr[Byte]]].update(0, f)
        ___ptr
      @scala.annotation.targetName("apply_l")
      def apply(l: Ptr[FcLangSet])(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[Ptr[FcLangSet]]].update(0, l)
        ___ptr
      @scala.annotation.targetName("apply_r")
      def apply(r: Ptr[FcRange])(using Zone): Ptr[Union0] =
        val ___ptr = alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[Ptr[FcRange]]].update(0, r)
        ___ptr
      extension (struct: Union0)
        def s : Ptr[FcChar8] = !struct.at(0).asInstanceOf[Ptr[Ptr[FcChar8]]]
        def s_=(value: Ptr[FcChar8]): Unit = !struct.at(0).asInstanceOf[Ptr[Ptr[FcChar8]]] = value
        def i : CInt = !struct.at(0).asInstanceOf[Ptr[CInt]]
        def i_=(value: CInt): Unit = !struct.at(0).asInstanceOf[Ptr[CInt]] = value
        def b : FcBool = !struct.at(0).asInstanceOf[Ptr[FcBool]]
        def b_=(value: FcBool): Unit = !struct.at(0).asInstanceOf[Ptr[FcBool]] = value
        def d : Double = !struct.at(0).asInstanceOf[Ptr[Double]]
        def d_=(value: Double): Unit = !struct.at(0).asInstanceOf[Ptr[Double]] = value
        def m : Ptr[FcMatrix] = !struct.at(0).asInstanceOf[Ptr[Ptr[FcMatrix]]]
        def m_=(value: Ptr[FcMatrix]): Unit = !struct.at(0).asInstanceOf[Ptr[Ptr[FcMatrix]]] = value
        def c : Ptr[FcCharSet] = !struct.at(0).asInstanceOf[Ptr[Ptr[FcCharSet]]]
        def c_=(value: Ptr[FcCharSet]): Unit = !struct.at(0).asInstanceOf[Ptr[Ptr[FcCharSet]]] = value
        def f : Ptr[Byte] = !struct.at(0).asInstanceOf[Ptr[Ptr[Byte]]]
        def f_=(value: Ptr[Byte]): Unit = !struct.at(0).asInstanceOf[Ptr[Ptr[Byte]]] = value
        def l : Ptr[FcLangSet] = !struct.at(0).asInstanceOf[Ptr[Ptr[FcLangSet]]]
        def l_=(value: Ptr[FcLangSet]): Unit = !struct.at(0).asInstanceOf[Ptr[Ptr[FcLangSet]]] = value
        def r : Ptr[FcRange] = !struct.at(0).asInstanceOf[Ptr[Ptr[FcRange]]]
        def r_=(value: Ptr[FcRange]): Unit = !struct.at(0).asInstanceOf[Ptr[Ptr[FcRange]]] = value
    given _tag: Tag[_FcValue] = Tag.materializeCStruct2Tag[FcType, _FcValue.Union0]
    def apply()(using Zone): Ptr[_FcValue] = scala.scalanative.unsafe.alloc[_FcValue](1)
    def apply(`type` : FcType, u : _FcValue.Union0)(using Zone): Ptr[_FcValue] = 
      val ____ptr = apply()
      (!____ptr).`type` = `type`
      (!____ptr).u = u
      ____ptr
    extension (struct: _FcValue)
      def `type` : FcType = struct._1
      def type_=(value: FcType): Unit = !struct.at1 = value
      def u : _FcValue.Union0 = struct._2
      def u_=(value: _FcValue.Union0): Unit = !struct.at2 = value

  opaque type _cairo = CStruct0
  object _cairo:
    given _tag: Tag[_cairo] = Tag.materializeCStruct0Tag

  opaque type _cairo_device = CStruct0
  object _cairo_device:
    given _tag: Tag[_cairo_device] = Tag.materializeCStruct0Tag

  opaque type _cairo_font_face = CStruct0
  object _cairo_font_face:
    given _tag: Tag[_cairo_font_face] = Tag.materializeCStruct0Tag

  opaque type _cairo_font_options = CStruct0
  object _cairo_font_options:
    given _tag: Tag[_cairo_font_options] = Tag.materializeCStruct0Tag

  /**
   * cairo_matrix_t: : xx component of the affine transformation : yx component of the affine transformation : xy component of the affine transformation : yy component of the affine transformation : X translation component of the affine transformation : Y translation component of the affine transformation
  */
  opaque type _cairo_matrix = CStruct6[Double, Double, Double, Double, Double, Double]
  object _cairo_matrix:
    given _tag: Tag[_cairo_matrix] = Tag.materializeCStruct6Tag[Double, Double, Double, Double, Double, Double]
    def apply()(using Zone): Ptr[_cairo_matrix] = scala.scalanative.unsafe.alloc[_cairo_matrix](1)
    def apply(xx : Double, yx : Double, xy : Double, yy : Double, x0 : Double, y0 : Double)(using Zone): Ptr[_cairo_matrix] = 
      val ____ptr = apply()
      (!____ptr).xx = xx
      (!____ptr).yx = yx
      (!____ptr).xy = xy
      (!____ptr).yy = yy
      (!____ptr).x0 = x0
      (!____ptr).y0 = y0
      ____ptr
    extension (struct: _cairo_matrix)
      def xx : Double = struct._1
      def xx_=(value: Double): Unit = !struct.at1 = value
      def yx : Double = struct._2
      def yx_=(value: Double): Unit = !struct.at2 = value
      def xy : Double = struct._3
      def xy_=(value: Double): Unit = !struct.at3 = value
      def yy : Double = struct._4
      def yy_=(value: Double): Unit = !struct.at4 = value
      def x0 : Double = struct._5
      def x0_=(value: Double): Unit = !struct.at5 = value
      def y0 : Double = struct._6
      def y0_=(value: Double): Unit = !struct.at6 = value

  opaque type _cairo_pattern = CStruct0
  object _cairo_pattern:
    given _tag: Tag[_cairo_pattern] = Tag.materializeCStruct0Tag

  /**
   * cairo_rectangle_t: : X coordinate of the left side of the rectangle : Y coordinate of the top side of the rectangle : width of the rectangle : height of the rectangle
  */
  opaque type _cairo_rectangle = CStruct4[Double, Double, Double, Double]
  object _cairo_rectangle:
    given _tag: Tag[_cairo_rectangle] = Tag.materializeCStruct4Tag[Double, Double, Double, Double]
    def apply()(using Zone): Ptr[_cairo_rectangle] = scala.scalanative.unsafe.alloc[_cairo_rectangle](1)
    def apply(x : Double, y : Double, width : Double, height : Double)(using Zone): Ptr[_cairo_rectangle] = 
      val ____ptr = apply()
      (!____ptr).x = x
      (!____ptr).y = y
      (!____ptr).width = width
      (!____ptr).height = height
      ____ptr
    extension (struct: _cairo_rectangle)
      def x : Double = struct._1
      def x_=(value: Double): Unit = !struct.at1 = value
      def y : Double = struct._2
      def y_=(value: Double): Unit = !struct.at2 = value
      def width : Double = struct._3
      def width_=(value: Double): Unit = !struct.at3 = value
      def height : Double = struct._4
      def height_=(value: Double): Unit = !struct.at4 = value

  /**
   * cairo_rectangle_int_t: : X coordinate of the left side of the rectangle : Y coordinate of the top side of the rectangle : width of the rectangle : height of the rectangle
  */
  opaque type _cairo_rectangle_int = CStruct4[CInt, CInt, CInt, CInt]
  object _cairo_rectangle_int:
    given _tag: Tag[_cairo_rectangle_int] = Tag.materializeCStruct4Tag[CInt, CInt, CInt, CInt]
    def apply()(using Zone): Ptr[_cairo_rectangle_int] = scala.scalanative.unsafe.alloc[_cairo_rectangle_int](1)
    def apply(x : CInt, y : CInt, width : CInt, height : CInt)(using Zone): Ptr[_cairo_rectangle_int] = 
      val ____ptr = apply()
      (!____ptr).x = x
      (!____ptr).y = y
      (!____ptr).width = width
      (!____ptr).height = height
      ____ptr
    extension (struct: _cairo_rectangle_int)
      def x : CInt = struct._1
      def x_=(value: CInt): Unit = !struct.at1 = value
      def y : CInt = struct._2
      def y_=(value: CInt): Unit = !struct.at2 = value
      def width : CInt = struct._3
      def width_=(value: CInt): Unit = !struct.at3 = value
      def height : CInt = struct._4
      def height_=(value: CInt): Unit = !struct.at4 = value

  /**
   * cairo_rectangle_list_t: : Error status of the rectangle list : Array containing the rectangles
  */
  opaque type _cairo_rectangle_list = CStruct3[cairo_status_t, Ptr[cairo_rectangle_t], CInt]
  object _cairo_rectangle_list:
    given _tag: Tag[_cairo_rectangle_list] = Tag.materializeCStruct3Tag[cairo_status_t, Ptr[cairo_rectangle_t], CInt]
    def apply()(using Zone): Ptr[_cairo_rectangle_list] = scala.scalanative.unsafe.alloc[_cairo_rectangle_list](1)
    def apply(status : cairo_status_t, rectangles : Ptr[cairo_rectangle_t], num_rectangles : CInt)(using Zone): Ptr[_cairo_rectangle_list] = 
      val ____ptr = apply()
      (!____ptr).status = status
      (!____ptr).rectangles = rectangles
      (!____ptr).num_rectangles = num_rectangles
      ____ptr
    extension (struct: _cairo_rectangle_list)
      def status : cairo_status_t = struct._1
      def status_=(value: cairo_status_t): Unit = !struct.at1 = value
      def rectangles : Ptr[cairo_rectangle_t] = struct._2
      def rectangles_=(value: Ptr[cairo_rectangle_t]): Unit = !struct.at2 = value
      def num_rectangles : CInt = struct._3
      def num_rectangles_=(value: CInt): Unit = !struct.at3 = value

  opaque type _cairo_region = CStruct0
  object _cairo_region:
    given _tag: Tag[_cairo_region] = Tag.materializeCStruct0Tag

  opaque type _cairo_scaled_font = CStruct0
  object _cairo_scaled_font:
    given _tag: Tag[_cairo_scaled_font] = Tag.materializeCStruct0Tag

  opaque type _cairo_surface = CStruct0
  object _cairo_surface:
    given _tag: Tag[_cairo_surface] = Tag.materializeCStruct0Tag

  /**
   * cairo_user_data_key_t: : not used; ignore.
  */
  opaque type _cairo_user_data_key = CStruct1[CInt]
  object _cairo_user_data_key:
    given _tag: Tag[_cairo_user_data_key] = Tag.materializeCStruct1Tag[CInt]
    def apply()(using Zone): Ptr[_cairo_user_data_key] = scala.scalanative.unsafe.alloc[_cairo_user_data_key](1)
    def apply(unused : CInt)(using Zone): Ptr[_cairo_user_data_key] = 
      val ____ptr = apply()
      (!____ptr).unused = unused
      ____ptr
    extension (struct: _cairo_user_data_key)
      def unused : CInt = struct._1
      def unused_=(value: CInt): Unit = !struct.at1 = value

  opaque type cairo_device_t = CStruct0
  object cairo_device_t:
    given _tag: Tag[cairo_device_t] = Tag.materializeCStruct0Tag

  /**
   * cairo_font_extents_t: : the distance that the font extends above the baseline. Note that this is not always exactly equal to the maximum of the extents of all the glyphs in the font, but rather is picked to express the font designer's intent as to how the font should align with elements above it. : the distance that the font extends below the baseline. This value is positive for typical fonts that include portions below the baseline. Note that this is not always exactly equal to the maximum of the extents of all the glyphs in the font, but rather is picked to express the font designer's intent as to how the font should align with elements below it. : the recommended vertical distance between baselines when setting consecutive lines of text with the font. This is greater than + by a quantity known as the <firstterm>line spacing</firstterm> or <firstterm>external leading</firstterm>. When space is at a premium, most fonts can be set with only a distance of + between lines. _x_advance: the maximum distance in the X direction that the origin is advanced for any glyph in the font. _y_advance: the maximum distance in the Y direction that the origin is advanced for any glyph in the font. This will be zero for normal fonts used for horizontal writing. (The scripts of East Asia are sometimes written vertically.)
  */
  opaque type cairo_font_extents_t = CStruct5[Double, Double, Double, Double, Double]
  object cairo_font_extents_t:
    given _tag: Tag[cairo_font_extents_t] = Tag.materializeCStruct5Tag[Double, Double, Double, Double, Double]
    def apply()(using Zone): Ptr[cairo_font_extents_t] = scala.scalanative.unsafe.alloc[cairo_font_extents_t](1)
    def apply(ascent : Double, descent : Double, height : Double, max_x_advance : Double, max_y_advance : Double)(using Zone): Ptr[cairo_font_extents_t] = 
      val ____ptr = apply()
      (!____ptr).ascent = ascent
      (!____ptr).descent = descent
      (!____ptr).height = height
      (!____ptr).max_x_advance = max_x_advance
      (!____ptr).max_y_advance = max_y_advance
      ____ptr
    extension (struct: cairo_font_extents_t)
      def ascent : Double = struct._1
      def ascent_=(value: Double): Unit = !struct.at1 = value
      def descent : Double = struct._2
      def descent_=(value: Double): Unit = !struct.at2 = value
      def height : Double = struct._3
      def height_=(value: Double): Unit = !struct.at3 = value
      def max_x_advance : Double = struct._4
      def max_x_advance_=(value: Double): Unit = !struct.at4 = value
      def max_y_advance : Double = struct._5
      def max_y_advance_=(value: Double): Unit = !struct.at5 = value

  opaque type cairo_font_face_t = CStruct0
  object cairo_font_face_t:
    given _tag: Tag[cairo_font_face_t] = Tag.materializeCStruct0Tag

  opaque type cairo_font_options_t = CStruct0
  object cairo_font_options_t:
    given _tag: Tag[cairo_font_options_t] = Tag.materializeCStruct0Tag

  /**
   * cairo_glyph_t: : glyph index in the font. The exact interpretation of the glyph index depends on the font technology being used. : the offset in the X direction between the origin used for drawing or measuring the string and the origin of this glyph. : the offset in the Y direction between the origin used for drawing or measuring the string and the origin of this glyph.
  */
  opaque type cairo_glyph_t = CStruct3[CUnsignedLongInt, Double, Double]
  object cairo_glyph_t:
    given _tag: Tag[cairo_glyph_t] = Tag.materializeCStruct3Tag[CUnsignedLongInt, Double, Double]
    def apply()(using Zone): Ptr[cairo_glyph_t] = scala.scalanative.unsafe.alloc[cairo_glyph_t](1)
    def apply(index : CUnsignedLongInt, x : Double, y : Double)(using Zone): Ptr[cairo_glyph_t] = 
      val ____ptr = apply()
      (!____ptr).index = index
      (!____ptr).x = x
      (!____ptr).y = y
      ____ptr
    extension (struct: cairo_glyph_t)
      def index : CUnsignedLongInt = struct._1
      def index_=(value: CUnsignedLongInt): Unit = !struct.at1 = value
      def x : Double = struct._2
      def x_=(value: Double): Unit = !struct.at2 = value
      def y : Double = struct._3
      def y_=(value: Double): Unit = !struct.at3 = value

  /**
   * cairo_matrix_t: : xx component of the affine transformation : yx component of the affine transformation : xy component of the affine transformation : yy component of the affine transformation : X translation component of the affine transformation : Y translation component of the affine transformation
  */
  opaque type cairo_matrix_t = CStruct6[Double, Double, Double, Double, Double, Double]
  object cairo_matrix_t:
    given _tag: Tag[cairo_matrix_t] = Tag.materializeCStruct6Tag[Double, Double, Double, Double, Double, Double]
    def apply()(using Zone): Ptr[cairo_matrix_t] = scala.scalanative.unsafe.alloc[cairo_matrix_t](1)
    def apply(xx : Double, yx : Double, xy : Double, yy : Double, x0 : Double, y0 : Double)(using Zone): Ptr[cairo_matrix_t] = 
      val ____ptr = apply()
      (!____ptr).xx = xx
      (!____ptr).yx = yx
      (!____ptr).xy = xy
      (!____ptr).yy = yy
      (!____ptr).x0 = x0
      (!____ptr).y0 = y0
      ____ptr
    extension (struct: cairo_matrix_t)
      def xx : Double = struct._1
      def xx_=(value: Double): Unit = !struct.at1 = value
      def yx : Double = struct._2
      def yx_=(value: Double): Unit = !struct.at2 = value
      def xy : Double = struct._3
      def xy_=(value: Double): Unit = !struct.at3 = value
      def yy : Double = struct._4
      def yy_=(value: Double): Unit = !struct.at4 = value
      def x0 : Double = struct._5
      def x0_=(value: Double): Unit = !struct.at5 = value
      def y0 : Double = struct._6
      def y0_=(value: Double): Unit = !struct.at6 = value

  /**
   * cairo_path_t: : the current error status
  */
  opaque type cairo_path = CStruct3[cairo_status_t, Ptr[cairo_path_data_t], CInt]
  object cairo_path:
    given _tag: Tag[cairo_path] = Tag.materializeCStruct3Tag[cairo_status_t, Ptr[cairo_path_data_t], CInt]
    def apply()(using Zone): Ptr[cairo_path] = scala.scalanative.unsafe.alloc[cairo_path](1)
    def apply(status : cairo_status_t, data : Ptr[cairo_path_data_t], num_data : CInt)(using Zone): Ptr[cairo_path] = 
      val ____ptr = apply()
      (!____ptr).status = status
      (!____ptr).data = data
      (!____ptr).num_data = num_data
      ____ptr
    extension (struct: cairo_path)
      def status : cairo_status_t = struct._1
      def status_=(value: cairo_status_t): Unit = !struct.at1 = value
      def data : Ptr[cairo_path_data_t] = struct._2
      def data_=(value: Ptr[cairo_path_data_t]): Unit = !struct.at2 = value
      def num_data : CInt = struct._3
      def num_data_=(value: CInt): Unit = !struct.at3 = value

  /**
   * cairo_path_t: : the current error status
  */
  opaque type cairo_path_t = CStruct3[cairo_status_t, Ptr[cairo_path_data_t], CInt]
  object cairo_path_t:
    given _tag: Tag[cairo_path_t] = Tag.materializeCStruct3Tag[cairo_status_t, Ptr[cairo_path_data_t], CInt]
    def apply()(using Zone): Ptr[cairo_path_t] = scala.scalanative.unsafe.alloc[cairo_path_t](1)
    def apply(status : cairo_status_t, data : Ptr[cairo_path_data_t], num_data : CInt)(using Zone): Ptr[cairo_path_t] = 
      val ____ptr = apply()
      (!____ptr).status = status
      (!____ptr).data = data
      (!____ptr).num_data = num_data
      ____ptr
    extension (struct: cairo_path_t)
      def status : cairo_status_t = struct._1
      def status_=(value: cairo_status_t): Unit = !struct.at1 = value
      def data : Ptr[cairo_path_data_t] = struct._2
      def data_=(value: Ptr[cairo_path_data_t]): Unit = !struct.at2 = value
      def num_data : CInt = struct._3
      def num_data_=(value: CInt): Unit = !struct.at3 = value

  opaque type cairo_pattern_t = CStruct0
  object cairo_pattern_t:
    given _tag: Tag[cairo_pattern_t] = Tag.materializeCStruct0Tag

  /**
   * cairo_rectangle_int_t: : X coordinate of the left side of the rectangle : Y coordinate of the top side of the rectangle : width of the rectangle : height of the rectangle
  */
  opaque type cairo_rectangle_int_t = CStruct4[CInt, CInt, CInt, CInt]
  object cairo_rectangle_int_t:
    given _tag: Tag[cairo_rectangle_int_t] = Tag.materializeCStruct4Tag[CInt, CInt, CInt, CInt]
    def apply()(using Zone): Ptr[cairo_rectangle_int_t] = scala.scalanative.unsafe.alloc[cairo_rectangle_int_t](1)
    def apply(x : CInt, y : CInt, width : CInt, height : CInt)(using Zone): Ptr[cairo_rectangle_int_t] = 
      val ____ptr = apply()
      (!____ptr).x = x
      (!____ptr).y = y
      (!____ptr).width = width
      (!____ptr).height = height
      ____ptr
    extension (struct: cairo_rectangle_int_t)
      def x : CInt = struct._1
      def x_=(value: CInt): Unit = !struct.at1 = value
      def y : CInt = struct._2
      def y_=(value: CInt): Unit = !struct.at2 = value
      def width : CInt = struct._3
      def width_=(value: CInt): Unit = !struct.at3 = value
      def height : CInt = struct._4
      def height_=(value: CInt): Unit = !struct.at4 = value

  /**
   * cairo_rectangle_list_t: : Error status of the rectangle list : Array containing the rectangles
  */
  opaque type cairo_rectangle_list_t = CStruct3[cairo_status_t, Ptr[cairo_rectangle_t], CInt]
  object cairo_rectangle_list_t:
    given _tag: Tag[cairo_rectangle_list_t] = Tag.materializeCStruct3Tag[cairo_status_t, Ptr[cairo_rectangle_t], CInt]
    def apply()(using Zone): Ptr[cairo_rectangle_list_t] = scala.scalanative.unsafe.alloc[cairo_rectangle_list_t](1)
    def apply(status : cairo_status_t, rectangles : Ptr[cairo_rectangle_t], num_rectangles : CInt)(using Zone): Ptr[cairo_rectangle_list_t] = 
      val ____ptr = apply()
      (!____ptr).status = status
      (!____ptr).rectangles = rectangles
      (!____ptr).num_rectangles = num_rectangles
      ____ptr
    extension (struct: cairo_rectangle_list_t)
      def status : cairo_status_t = struct._1
      def status_=(value: cairo_status_t): Unit = !struct.at1 = value
      def rectangles : Ptr[cairo_rectangle_t] = struct._2
      def rectangles_=(value: Ptr[cairo_rectangle_t]): Unit = !struct.at2 = value
      def num_rectangles : CInt = struct._3
      def num_rectangles_=(value: CInt): Unit = !struct.at3 = value

  /**
   * cairo_rectangle_t: : X coordinate of the left side of the rectangle : Y coordinate of the top side of the rectangle : width of the rectangle : height of the rectangle
  */
  opaque type cairo_rectangle_t = CStruct4[Double, Double, Double, Double]
  object cairo_rectangle_t:
    given _tag: Tag[cairo_rectangle_t] = Tag.materializeCStruct4Tag[Double, Double, Double, Double]
    def apply()(using Zone): Ptr[cairo_rectangle_t] = scala.scalanative.unsafe.alloc[cairo_rectangle_t](1)
    def apply(x : Double, y : Double, width : Double, height : Double)(using Zone): Ptr[cairo_rectangle_t] = 
      val ____ptr = apply()
      (!____ptr).x = x
      (!____ptr).y = y
      (!____ptr).width = width
      (!____ptr).height = height
      ____ptr
    extension (struct: cairo_rectangle_t)
      def x : Double = struct._1
      def x_=(value: Double): Unit = !struct.at1 = value
      def y : Double = struct._2
      def y_=(value: Double): Unit = !struct.at2 = value
      def width : Double = struct._3
      def width_=(value: Double): Unit = !struct.at3 = value
      def height : Double = struct._4
      def height_=(value: Double): Unit = !struct.at4 = value

  opaque type cairo_region_t = CStruct0
  object cairo_region_t:
    given _tag: Tag[cairo_region_t] = Tag.materializeCStruct0Tag

  opaque type cairo_scaled_font_t = CStruct0
  object cairo_scaled_font_t:
    given _tag: Tag[cairo_scaled_font_t] = Tag.materializeCStruct0Tag

  opaque type cairo_surface_t = CStruct0
  object cairo_surface_t:
    given _tag: Tag[cairo_surface_t] = Tag.materializeCStruct0Tag

  opaque type cairo_t = CStruct0
  object cairo_t:
    given _tag: Tag[cairo_t] = Tag.materializeCStruct0Tag

  /**
   * cairo_text_cluster_t:
  */
  opaque type cairo_text_cluster_t = CStruct2[CInt, CInt]
  object cairo_text_cluster_t:
    given _tag: Tag[cairo_text_cluster_t] = Tag.materializeCStruct2Tag[CInt, CInt]
    def apply()(using Zone): Ptr[cairo_text_cluster_t] = scala.scalanative.unsafe.alloc[cairo_text_cluster_t](1)
    def apply(num_bytes : CInt, num_glyphs : CInt)(using Zone): Ptr[cairo_text_cluster_t] = 
      val ____ptr = apply()
      (!____ptr).num_bytes = num_bytes
      (!____ptr).num_glyphs = num_glyphs
      ____ptr
    extension (struct: cairo_text_cluster_t)
      def num_bytes : CInt = struct._1
      def num_bytes_=(value: CInt): Unit = !struct.at1 = value
      def num_glyphs : CInt = struct._2
      def num_glyphs_=(value: CInt): Unit = !struct.at2 = value

  /**
   * cairo_text_extents_t: _bearing: the horizontal distance from the origin to the leftmost part of the glyphs as drawn. Positive if the glyphs lie entirely to the right of the origin. _bearing: the vertical distance from the origin to the topmost part of the glyphs as drawn. Positive only if the glyphs lie completely below the origin; will usually be negative. : width of the glyphs as drawn : height of the glyphs as drawn _advance:distance to advance in the X direction after drawing these glyphs _advance: distance to advance in the Y direction after drawing these glyphs. Will typically be zero except for vertical text layout as found in East-Asian languages.
  */
  opaque type cairo_text_extents_t = CStruct6[Double, Double, Double, Double, Double, Double]
  object cairo_text_extents_t:
    given _tag: Tag[cairo_text_extents_t] = Tag.materializeCStruct6Tag[Double, Double, Double, Double, Double, Double]
    def apply()(using Zone): Ptr[cairo_text_extents_t] = scala.scalanative.unsafe.alloc[cairo_text_extents_t](1)
    def apply(x_bearing : Double, y_bearing : Double, width : Double, height : Double, x_advance : Double, y_advance : Double)(using Zone): Ptr[cairo_text_extents_t] = 
      val ____ptr = apply()
      (!____ptr).x_bearing = x_bearing
      (!____ptr).y_bearing = y_bearing
      (!____ptr).width = width
      (!____ptr).height = height
      (!____ptr).x_advance = x_advance
      (!____ptr).y_advance = y_advance
      ____ptr
    extension (struct: cairo_text_extents_t)
      def x_bearing : Double = struct._1
      def x_bearing_=(value: Double): Unit = !struct.at1 = value
      def y_bearing : Double = struct._2
      def y_bearing_=(value: Double): Unit = !struct.at2 = value
      def width : Double = struct._3
      def width_=(value: Double): Unit = !struct.at3 = value
      def height : Double = struct._4
      def height_=(value: Double): Unit = !struct.at4 = value
      def x_advance : Double = struct._5
      def x_advance_=(value: Double): Unit = !struct.at5 = value
      def y_advance : Double = struct._6
      def y_advance_=(value: Double): Unit = !struct.at6 = value

  /**
   * cairo_user_data_key_t: : not used; ignore.
  */
  opaque type cairo_user_data_key_t = CStruct1[CInt]
  object cairo_user_data_key_t:
    given _tag: Tag[cairo_user_data_key_t] = Tag.materializeCStruct1Tag[CInt]
    def apply()(using Zone): Ptr[cairo_user_data_key_t] = scala.scalanative.unsafe.alloc[cairo_user_data_key_t](1)
    def apply(unused : CInt)(using Zone): Ptr[cairo_user_data_key_t] = 
      val ____ptr = apply()
      (!____ptr).unused = unused
      ____ptr
    extension (struct: cairo_user_data_key_t)
      def unused : CInt = struct._1
      def unused_=(value: CInt): Unit = !struct.at1 = value

object unions:
  import _root_.cairo.enumerations.*
  import _root_.cairo.predef.*
  import _root_.cairo.aliases.*
  import _root_.cairo.structs.*
  import _root_.cairo.unions.*
  /**
   * ************************************************************************
  */
  opaque type FT_StreamDesc = CArray[Byte, Nat._8]
  object FT_StreamDesc:
    given _tag: Tag[FT_StreamDesc] = Tag.CArray[CChar, Nat._8](Tag.Byte, Tag.Nat8)
    def apply()(using Zone): Ptr[FT_StreamDesc] = 
      val ___ptr = alloc[FT_StreamDesc](1)
      ___ptr
    @scala.annotation.targetName("apply_value")
    def apply(value: CLongInt)(using Zone): Ptr[FT_StreamDesc] =
      val ___ptr = alloc[FT_StreamDesc](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[CLongInt]].update(0, value)
      ___ptr
    @scala.annotation.targetName("apply_pointer")
    def apply(pointer: Ptr[Byte])(using Zone): Ptr[FT_StreamDesc] =
      val ___ptr = alloc[FT_StreamDesc](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[Ptr[Byte]]].update(0, pointer)
      ___ptr
    extension (struct: FT_StreamDesc)
      def value : CLongInt = !struct.at(0).asInstanceOf[Ptr[CLongInt]]
      def value_=(value: CLongInt): Unit = !struct.at(0).asInstanceOf[Ptr[CLongInt]] = value
      def pointer : Ptr[Byte] = !struct.at(0).asInstanceOf[Ptr[Ptr[Byte]]]
      def pointer_=(value: Ptr[Byte]): Unit = !struct.at(0).asInstanceOf[Ptr[Ptr[Byte]]] = value

  /**
   * ************************************************************************
  */
  opaque type FT_StreamDesc_ = CArray[Byte, Nat._8]
  object FT_StreamDesc_ :
    given _tag: Tag[FT_StreamDesc_] = Tag.CArray[CChar, Nat._8](Tag.Byte, Tag.Nat8)
    def apply()(using Zone): Ptr[FT_StreamDesc_] = 
      val ___ptr = alloc[FT_StreamDesc_](1)
      ___ptr
    @scala.annotation.targetName("apply_value")
    def apply(value: CLongInt)(using Zone): Ptr[FT_StreamDesc_] =
      val ___ptr = alloc[FT_StreamDesc_](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[CLongInt]].update(0, value)
      ___ptr
    @scala.annotation.targetName("apply_pointer")
    def apply(pointer: Ptr[Byte])(using Zone): Ptr[FT_StreamDesc_] =
      val ___ptr = alloc[FT_StreamDesc_](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[Ptr[Byte]]].update(0, pointer)
      ___ptr
    extension (struct: FT_StreamDesc_)
      def value : CLongInt = !struct.at(0).asInstanceOf[Ptr[CLongInt]]
      def value_=(value: CLongInt): Unit = !struct.at(0).asInstanceOf[Ptr[CLongInt]] = value
      def pointer : Ptr[Byte] = !struct.at(0).asInstanceOf[Ptr[Ptr[Byte]]]
      def pointer_=(value: Ptr[Byte]): Unit = !struct.at(0).asInstanceOf[Ptr[Ptr[Byte]]] = value

  opaque type _cairo_path_data_t = CArray[Byte, Nat.Digit2[Nat._1, Nat._6]]
  object _cairo_path_data_t:
    opaque type Struct0 = CStruct2[cairo_path_data_type_t, CInt]
    object Struct0:
      given _tag: Tag[Struct0] = Tag.materializeCStruct2Tag[cairo_path_data_type_t, CInt]
      def apply()(using Zone): Ptr[Struct0] = scala.scalanative.unsafe.alloc[Struct0](1)
      def apply(`type` : cairo_path_data_type_t, length : CInt)(using Zone): Ptr[Struct0] = 
        val ____ptr = apply()
        (!____ptr).`type` = `type`
        (!____ptr).length = length
        ____ptr
      extension (struct: Struct0)
        def `type` : cairo_path_data_type_t = struct._1
        def type_=(value: cairo_path_data_type_t): Unit = !struct.at1 = value
        def length : CInt = struct._2
        def length_=(value: CInt): Unit = !struct.at2 = value
    opaque type Struct1 = CStruct2[Double, Double]
    object Struct1:
      given _tag: Tag[Struct1] = Tag.materializeCStruct2Tag[Double, Double]
      def apply()(using Zone): Ptr[Struct1] = scala.scalanative.unsafe.alloc[Struct1](1)
      def apply(x : Double, y : Double)(using Zone): Ptr[Struct1] = 
        val ____ptr = apply()
        (!____ptr).x = x
        (!____ptr).y = y
        ____ptr
      extension (struct: Struct1)
        def x : Double = struct._1
        def x_=(value: Double): Unit = !struct.at1 = value
        def y : Double = struct._2
        def y_=(value: Double): Unit = !struct.at2 = value
    given _tag: Tag[_cairo_path_data_t] = Tag.CArray[CChar, Nat.Digit2[Nat._1, Nat._6]](Tag.Byte, Tag.Digit2[Nat._1, Nat._6](Tag.Nat1, Tag.Nat6))
    def apply()(using Zone): Ptr[_cairo_path_data_t] = 
      val ___ptr = alloc[_cairo_path_data_t](1)
      ___ptr
    @scala.annotation.targetName("apply_header")
    def apply(header: _cairo_path_data_t.Struct0)(using Zone): Ptr[_cairo_path_data_t] =
      val ___ptr = alloc[_cairo_path_data_t](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[_cairo_path_data_t.Struct0]].update(0, header)
      ___ptr
    @scala.annotation.targetName("apply_point")
    def apply(point: _cairo_path_data_t.Struct1)(using Zone): Ptr[_cairo_path_data_t] =
      val ___ptr = alloc[_cairo_path_data_t](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[_cairo_path_data_t.Struct1]].update(0, point)
      ___ptr
    extension (struct: _cairo_path_data_t)
      def header : _cairo_path_data_t.Struct0 = !struct.at(0).asInstanceOf[Ptr[_cairo_path_data_t.Struct0]]
      def header_=(value: _cairo_path_data_t.Struct0): Unit = !struct.at(0).asInstanceOf[Ptr[_cairo_path_data_t.Struct0]] = value
      def point : _cairo_path_data_t.Struct1 = !struct.at(0).asInstanceOf[Ptr[_cairo_path_data_t.Struct1]]
      def point_=(value: _cairo_path_data_t.Struct1): Unit = !struct.at(0).asInstanceOf[Ptr[_cairo_path_data_t.Struct1]] = value

  opaque type cairo_path_data_t = CArray[Byte, Nat.Digit2[Nat._1, Nat._6]]
  object cairo_path_data_t:
    opaque type Struct0 = CStruct2[cairo_path_data_type_t, CInt]
    object Struct0:
      given _tag: Tag[Struct0] = Tag.materializeCStruct2Tag[cairo_path_data_type_t, CInt]
      def apply()(using Zone): Ptr[Struct0] = scala.scalanative.unsafe.alloc[Struct0](1)
      def apply(`type` : cairo_path_data_type_t, length : CInt)(using Zone): Ptr[Struct0] = 
        val ____ptr = apply()
        (!____ptr).`type` = `type`
        (!____ptr).length = length
        ____ptr
      extension (struct: Struct0)
        def `type` : cairo_path_data_type_t = struct._1
        def type_=(value: cairo_path_data_type_t): Unit = !struct.at1 = value
        def length : CInt = struct._2
        def length_=(value: CInt): Unit = !struct.at2 = value
    opaque type Struct1 = CStruct2[Double, Double]
    object Struct1:
      given _tag: Tag[Struct1] = Tag.materializeCStruct2Tag[Double, Double]
      def apply()(using Zone): Ptr[Struct1] = scala.scalanative.unsafe.alloc[Struct1](1)
      def apply(x : Double, y : Double)(using Zone): Ptr[Struct1] = 
        val ____ptr = apply()
        (!____ptr).x = x
        (!____ptr).y = y
        ____ptr
      extension (struct: Struct1)
        def x : Double = struct._1
        def x_=(value: Double): Unit = !struct.at1 = value
        def y : Double = struct._2
        def y_=(value: Double): Unit = !struct.at2 = value
    given _tag: Tag[cairo_path_data_t] = Tag.CArray[CChar, Nat.Digit2[Nat._1, Nat._6]](Tag.Byte, Tag.Digit2[Nat._1, Nat._6](Tag.Nat1, Tag.Nat6))
    def apply()(using Zone): Ptr[cairo_path_data_t] = 
      val ___ptr = alloc[cairo_path_data_t](1)
      ___ptr
    @scala.annotation.targetName("apply_header")
    def apply(header: cairo_path_data_t.Struct0)(using Zone): Ptr[cairo_path_data_t] =
      val ___ptr = alloc[cairo_path_data_t](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[cairo_path_data_t.Struct0]].update(0, header)
      ___ptr
    @scala.annotation.targetName("apply_point")
    def apply(point: cairo_path_data_t.Struct1)(using Zone): Ptr[cairo_path_data_t] =
      val ___ptr = alloc[cairo_path_data_t](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[cairo_path_data_t.Struct1]].update(0, point)
      ___ptr
    extension (struct: cairo_path_data_t)
      def header : cairo_path_data_t.Struct0 = !struct.at(0).asInstanceOf[Ptr[cairo_path_data_t.Struct0]]
      def header_=(value: cairo_path_data_t.Struct0): Unit = !struct.at(0).asInstanceOf[Ptr[cairo_path_data_t.Struct0]] = value
      def point : cairo_path_data_t.Struct1 = !struct.at(0).asInstanceOf[Ptr[cairo_path_data_t.Struct1]]
      def point_=(value: cairo_path_data_t.Struct1): Unit = !struct.at(0).asInstanceOf[Ptr[cairo_path_data_t.Struct1]] = value


@extern
private[cairo] object extern_functions:
  import _root_.cairo.enumerations.*
  import _root_.cairo.predef.*
  import _root_.cairo.aliases.*
  import _root_.cairo.structs.*
  import _root_.cairo.unions.*
  /**
   * ************************************************************************
  */
  def FT_Attach_File(face : FT_Face, filepathname : CString): FT_Error = extern

  /**
   * ************************************************************************
  */
  def FT_Attach_Stream(face : FT_Face, parameters : Ptr[FT_Open_Args]): FT_Error = extern

  /**
   * ************************************************************************
  */
  def FT_CeilFix(a : FT_Fixed): FT_Fixed = extern

  /**
   * ************************************************************************
  */
  def FT_DivFix(a : FT_Long, b : FT_Long): FT_Long = extern

  /**
   * ************************************************************************
  */
  def FT_Done_Face(face : FT_Face): FT_Error = extern

  /**
   * ************************************************************************
  */
  def FT_Done_FreeType(library : FT_Library): FT_Error = extern

  /**
   * ************************************************************************
  */
  def FT_Error_String(error_code : FT_Error): CString = extern

  /**
   * ************************************************************************
  */
  def FT_Face_CheckTrueTypePatents(face : FT_Face): FT_Bool = extern

  /**
   * ************************************************************************
  */
  def FT_Face_GetCharVariantIndex(face : FT_Face, charcode : FT_ULong, variantSelector : FT_ULong): FT_UInt = extern

  /**
   * ************************************************************************
  */
  def FT_Face_GetCharVariantIsDefault(face : FT_Face, charcode : FT_ULong, variantSelector : FT_ULong): FT_Int = extern

  /**
   * ************************************************************************
  */
  def FT_Face_GetCharsOfVariant(face : FT_Face, variantSelector : FT_ULong): Ptr[FT_UInt32] = extern

  /**
   * ************************************************************************
  */
  def FT_Face_GetVariantSelectors(face : FT_Face): Ptr[FT_UInt32] = extern

  /**
   * ************************************************************************
  */
  def FT_Face_GetVariantsOfChar(face : FT_Face, charcode : FT_ULong): Ptr[FT_UInt32] = extern

  /**
   * ************************************************************************
  */
  def FT_Face_Properties(face : FT_Face, num_properties : FT_UInt, properties : Ptr[FT_Parameter]): FT_Error = extern

  /**
   * ************************************************************************
  */
  def FT_Face_SetUnpatentedHinting(face : FT_Face, value : FT_Bool): FT_Bool = extern

  /**
   * ************************************************************************
  */
  def FT_FloorFix(a : FT_Fixed): FT_Fixed = extern

  /**
   * ************************************************************************
  */
  def FT_Get_Char_Index(face : FT_Face, charcode : FT_ULong): FT_UInt = extern

  /**
   * ************************************************************************
  */
  def FT_Get_Charmap_Index(charmap : FT_CharMap): FT_Int = extern

  /**
   * ************************************************************************
  */
  def FT_Get_FSType_Flags(face : FT_Face): FT_UShort = extern

  /**
   * ************************************************************************
  */
  def FT_Get_First_Char(face : FT_Face, agindex : Ptr[FT_UInt]): FT_ULong = extern

  /**
   * ************************************************************************
  */
  def FT_Get_Glyph_Name(face : FT_Face, glyph_index : FT_UInt, buffer : FT_Pointer, buffer_max : FT_UInt): FT_Error = extern

  /**
   * ************************************************************************
  */
  def FT_Get_Kerning(face : FT_Face, left_glyph : FT_UInt, right_glyph : FT_UInt, kern_mode : FT_UInt, akerning : Ptr[FT_Vector]): FT_Error = extern

  /**
   * ************************************************************************
  */
  def FT_Get_Name_Index(face : FT_Face, glyph_name : Ptr[FT_String]): FT_UInt = extern

  /**
   * ************************************************************************
  */
  def FT_Get_Next_Char(face : FT_Face, char_code : FT_ULong, agindex : Ptr[FT_UInt]): FT_ULong = extern

  /**
   * ************************************************************************
  */
  def FT_Get_Postscript_Name(face : FT_Face): CString = extern

  /**
   * ************************************************************************
  */
  def FT_Get_SubGlyph_Info(glyph : FT_GlyphSlot, sub_index : FT_UInt, p_index : Ptr[FT_Int], p_flags : Ptr[FT_UInt], p_arg1 : Ptr[FT_Int], p_arg2 : Ptr[FT_Int], p_transform : Ptr[FT_Matrix]): FT_Error = extern

  /**
   * ************************************************************************
  */
  def FT_Get_Track_Kerning(face : FT_Face, point_size : FT_Fixed, degree : FT_Int, akerning : Ptr[FT_Fixed]): FT_Error = extern

  /**
   * ************************************************************************
  */
  def FT_Get_Transform(face : FT_Face, matrix : Ptr[FT_Matrix], delta : Ptr[FT_Vector]): Unit = extern

  /**
   * ************************************************************************
  */
  def FT_Init_FreeType(alibrary : Ptr[FT_Library]): FT_Error = extern

  /**
   * ************************************************************************
  */
  def FT_Library_Version(library : FT_Library, amajor : Ptr[FT_Int], aminor : Ptr[FT_Int], apatch : Ptr[FT_Int]): Unit = extern

  /**
   * ************************************************************************
  */
  def FT_Load_Char(face : FT_Face, char_code : FT_ULong, load_flags : FT_Int32): FT_Error = extern

  /**
   * ************************************************************************
  */
  def FT_Load_Glyph(face : FT_Face, glyph_index : FT_UInt, load_flags : FT_Int32): FT_Error = extern

  /**
   * ************************************************************************
  */
  def FT_MulDiv(a : FT_Long, b : FT_Long, c : FT_Long): FT_Long = extern

  /**
   * ************************************************************************
  */
  def FT_MulFix(a : FT_Long, b : FT_Long): FT_Long = extern

  /**
   * ************************************************************************
  */
  def FT_New_Face(library : FT_Library, filepathname : CString, face_index : FT_Long, aface : Ptr[FT_Face]): FT_Error = extern

  /**
   * ************************************************************************
  */
  def FT_New_Memory_Face(library : FT_Library, file_base : Ptr[FT_Byte], file_size : FT_Long, face_index : FT_Long, aface : Ptr[FT_Face]): FT_Error = extern

  /**
   * ************************************************************************
  */
  def FT_Open_Face(library : FT_Library, args : Ptr[FT_Open_Args], face_index : FT_Long, aface : Ptr[FT_Face]): FT_Error = extern

  /**
   * ************************************************************************
  */
  def FT_Reference_Face(face : FT_Face): FT_Error = extern

  /**
   * ************************************************************************
  */
  def FT_Render_Glyph(slot : FT_GlyphSlot, render_mode : FT_Render_Mode): FT_Error = extern

  /**
   * ************************************************************************
  */
  def FT_Request_Size(face : FT_Face, req : FT_Size_Request): FT_Error = extern

  /**
   * ************************************************************************
  */
  def FT_RoundFix(a : FT_Fixed): FT_Fixed = extern

  /**
   * ************************************************************************
  */
  def FT_Select_Charmap(face : FT_Face, encoding : FT_Encoding): FT_Error = extern

  /**
   * ************************************************************************
  */
  def FT_Select_Size(face : FT_Face, strike_index : FT_Int): FT_Error = extern

  /**
   * ************************************************************************
  */
  def FT_Set_Char_Size(face : FT_Face, char_width : FT_F26Dot6, char_height : FT_F26Dot6, horz_resolution : FT_UInt, vert_resolution : FT_UInt): FT_Error = extern

  /**
   * ************************************************************************
  */
  def FT_Set_Charmap(face : FT_Face, charmap : FT_CharMap): FT_Error = extern

  /**
   * ************************************************************************
  */
  def FT_Set_Pixel_Sizes(face : FT_Face, pixel_width : FT_UInt, pixel_height : FT_UInt): FT_Error = extern

  /**
   * ************************************************************************
  */
  def FT_Set_Transform(face : FT_Face, matrix : Ptr[FT_Matrix], delta : Ptr[FT_Vector]): Unit = extern

  /**
   * ************************************************************************
  */
  def FT_Vector_Transform(vector : Ptr[FT_Vector], matrix : Ptr[FT_Matrix]): Unit = extern

  def FcAtomicCreate(file : Ptr[FcChar8]): Ptr[FcAtomic] = extern

  def FcAtomicDeleteNew(atomic : Ptr[FcAtomic]): Unit = extern

  def FcAtomicDestroy(atomic : Ptr[FcAtomic]): Unit = extern

  def FcAtomicLock(atomic : Ptr[FcAtomic]): FcBool = extern

  def FcAtomicNewFile(atomic : Ptr[FcAtomic]): Ptr[FcChar8] = extern

  def FcAtomicOrigFile(atomic : Ptr[FcAtomic]): Ptr[FcChar8] = extern

  def FcAtomicReplaceOrig(atomic : Ptr[FcAtomic]): FcBool = extern

  def FcAtomicUnlock(atomic : Ptr[FcAtomic]): Unit = extern

  def FcBlanksAdd(b : Ptr[FcBlanks], ucs4 : FcChar32): FcBool = extern

  def FcBlanksCreate(): Ptr[FcBlanks] = extern

  def FcBlanksDestroy(b : Ptr[FcBlanks]): Unit = extern

  def FcBlanksIsMember(b : Ptr[FcBlanks], ucs4 : FcChar32): FcBool = extern

  def FcCacheCopySet(c : Ptr[FcCache]): Ptr[FcFontSet] = extern

  def FcCacheCreateTagFile(config : Ptr[FcConfig]): Unit = extern

  def FcCacheDir(c : Ptr[FcCache]): Ptr[FcChar8] = extern

  def FcCacheNumFont(c : Ptr[FcCache]): CInt = extern

  def FcCacheNumSubdir(c : Ptr[FcCache]): CInt = extern

  def FcCacheSubdir(c : Ptr[FcCache], i : CInt): Ptr[FcChar8] = extern

  def FcCharSetAddChar(fcs : Ptr[FcCharSet], ucs4 : FcChar32): FcBool = extern

  def FcCharSetCopy(src : Ptr[FcCharSet]): Ptr[FcCharSet] = extern

  def FcCharSetCount(a : Ptr[FcCharSet]): FcChar32 = extern

  def FcCharSetCoverage(a : Ptr[FcCharSet], page : FcChar32, result : Ptr[FcChar32]): FcChar32 = extern

  def FcCharSetCreate(): Ptr[FcCharSet] = extern

  def FcCharSetDelChar(fcs : Ptr[FcCharSet], ucs4 : FcChar32): FcBool = extern

  def FcCharSetDestroy(fcs : Ptr[FcCharSet]): Unit = extern

  def FcCharSetEqual(a : Ptr[FcCharSet], b : Ptr[FcCharSet]): FcBool = extern

  def FcCharSetFirstPage(a : Ptr[FcCharSet], map : CArray[FcChar32, Nat._8], next : Ptr[FcChar32]): FcChar32 = extern

  def FcCharSetHasChar(fcs : Ptr[FcCharSet], ucs4 : FcChar32): FcBool = extern

  def FcCharSetIntersect(a : Ptr[FcCharSet], b : Ptr[FcCharSet]): Ptr[FcCharSet] = extern

  def FcCharSetIntersectCount(a : Ptr[FcCharSet], b : Ptr[FcCharSet]): FcChar32 = extern

  def FcCharSetIsSubset(a : Ptr[FcCharSet], b : Ptr[FcCharSet]): FcBool = extern

  def FcCharSetMerge(a : Ptr[FcCharSet], b : Ptr[FcCharSet], changed : Ptr[FcBool]): FcBool = extern

  def FcCharSetNew(): Ptr[FcCharSet] = extern

  def FcCharSetNextPage(a : Ptr[FcCharSet], map : CArray[FcChar32, Nat._8], next : Ptr[FcChar32]): FcChar32 = extern

  def FcCharSetSubtract(a : Ptr[FcCharSet], b : Ptr[FcCharSet]): Ptr[FcCharSet] = extern

  def FcCharSetSubtractCount(a : Ptr[FcCharSet], b : Ptr[FcCharSet]): FcChar32 = extern

  def FcCharSetUnion(a : Ptr[FcCharSet], b : Ptr[FcCharSet]): Ptr[FcCharSet] = extern

  def FcConfigAppFontAddDir(config : Ptr[FcConfig], dir : Ptr[FcChar8]): FcBool = extern

  def FcConfigAppFontAddFile(config : Ptr[FcConfig], file : Ptr[FcChar8]): FcBool = extern

  def FcConfigAppFontClear(config : Ptr[FcConfig]): Unit = extern

  def FcConfigBuildFonts(config : Ptr[FcConfig]): FcBool = extern

  def FcConfigCreate(): Ptr[FcConfig] = extern

  def FcConfigDestroy(config : Ptr[FcConfig]): Unit = extern

  def FcConfigEnableHome(enable : FcBool): FcBool = extern

  def FcConfigFileInfoIterGet(config : Ptr[FcConfig], iter : Ptr[FcConfigFileInfoIter], name : Ptr[Ptr[FcChar8]], description : Ptr[Ptr[FcChar8]], enabled : Ptr[FcBool]): FcBool = extern

  def FcConfigFileInfoIterInit(config : Ptr[FcConfig], iter : Ptr[FcConfigFileInfoIter]): Unit = extern

  def FcConfigFileInfoIterNext(config : Ptr[FcConfig], iter : Ptr[FcConfigFileInfoIter]): FcBool = extern

  def FcConfigFilename(url : Ptr[FcChar8]): Ptr[FcChar8] = extern

  def FcConfigGetBlanks(config : Ptr[FcConfig]): Ptr[FcBlanks] = extern

  def FcConfigGetCache(config : Ptr[FcConfig]): Ptr[FcChar8] = extern

  def FcConfigGetCacheDirs(config : Ptr[FcConfig]): Ptr[FcStrList] = extern

  def FcConfigGetConfigDirs(config : Ptr[FcConfig]): Ptr[FcStrList] = extern

  def FcConfigGetConfigFiles(config : Ptr[FcConfig]): Ptr[FcStrList] = extern

  def FcConfigGetCurrent(): Ptr[FcConfig] = extern

  def FcConfigGetFilename(config : Ptr[FcConfig], url : Ptr[FcChar8]): Ptr[FcChar8] = extern

  def FcConfigGetFontDirs(config : Ptr[FcConfig]): Ptr[FcStrList] = extern

  def FcConfigGetFonts(config : Ptr[FcConfig], set : FcSetName): Ptr[FcFontSet] = extern

  def FcConfigGetRescanInterval(config : Ptr[FcConfig]): CInt = extern

  def FcConfigGetSysRoot(config : Ptr[FcConfig]): Ptr[FcChar8] = extern

  def FcConfigHome(): Ptr[FcChar8] = extern

  def FcConfigParseAndLoad(config : Ptr[FcConfig], file : Ptr[FcChar8], complain : FcBool): FcBool = extern

  def FcConfigParseAndLoadFromMemory(config : Ptr[FcConfig], buffer : Ptr[FcChar8], complain : FcBool): FcBool = extern

  def FcConfigReference(config : Ptr[FcConfig]): Ptr[FcConfig] = extern

  def FcConfigSetCurrent(config : Ptr[FcConfig]): FcBool = extern

  def FcConfigSetRescanInterval(config : Ptr[FcConfig], rescanInterval : CInt): FcBool = extern

  def FcConfigSetSysRoot(config : Ptr[FcConfig], sysroot : Ptr[FcChar8]): Unit = extern

  def FcConfigSubstitute(config : Ptr[FcConfig], p : Ptr[FcPattern], kind : FcMatchKind): FcBool = extern

  def FcConfigSubstituteWithPat(config : Ptr[FcConfig], p : Ptr[FcPattern], p_pat : Ptr[FcPattern], kind : FcMatchKind): FcBool = extern

  def FcConfigUptoDate(config : Ptr[FcConfig]): FcBool = extern

  def FcDefaultSubstitute(pattern : Ptr[FcPattern]): Unit = extern

  def FcDirCacheClean(cache_dir : Ptr[FcChar8], verbose : FcBool): FcBool = extern

  def FcDirCacheCreateUUID(dir : Ptr[FcChar8], force : FcBool, config : Ptr[FcConfig]): FcBool = extern

  def FcDirCacheDeleteUUID(dir : Ptr[FcChar8], config : Ptr[FcConfig]): FcBool = extern

  def FcDirCacheLoad(dir : Ptr[FcChar8], config : Ptr[FcConfig], cache_file : Ptr[Ptr[FcChar8]]): Ptr[FcCache] = extern

  def FcDirCacheLoadFile(cache_file : Ptr[FcChar8], file_stat : Ptr[stat]): Ptr[FcCache] = extern

  def FcDirCacheRead(dir : Ptr[FcChar8], force : FcBool, config : Ptr[FcConfig]): Ptr[FcCache] = extern

  def FcDirCacheRescan(dir : Ptr[FcChar8], config : Ptr[FcConfig]): Ptr[FcCache] = extern

  def FcDirCacheUnlink(dir : Ptr[FcChar8], config : Ptr[FcConfig]): FcBool = extern

  def FcDirCacheUnload(cache : Ptr[FcCache]): Unit = extern

  def FcDirCacheValid(cache_file : Ptr[FcChar8]): FcBool = extern

  def FcDirSave(set : Ptr[FcFontSet], dirs : Ptr[FcStrSet], dir : Ptr[FcChar8]): FcBool = extern

  def FcDirScan(set : Ptr[FcFontSet], dirs : Ptr[FcStrSet], cache : Ptr[FcFileCache], blanks : Ptr[FcBlanks], dir : Ptr[FcChar8], force : FcBool): FcBool = extern

  def FcFileIsDir(file : Ptr[FcChar8]): FcBool = extern

  def FcFileScan(set : Ptr[FcFontSet], dirs : Ptr[FcStrSet], cache : Ptr[FcFileCache], blanks : Ptr[FcBlanks], file : Ptr[FcChar8], force : FcBool): FcBool = extern

  def FcFini(): Unit = extern

  def FcFontList(config : Ptr[FcConfig], p : Ptr[FcPattern], os : Ptr[FcObjectSet]): Ptr[FcFontSet] = extern

  def FcFontMatch(config : Ptr[FcConfig], p : Ptr[FcPattern], result : Ptr[FcResult]): Ptr[FcPattern] = extern

  def FcFontRenderPrepare(config : Ptr[FcConfig], pat : Ptr[FcPattern], font : Ptr[FcPattern]): Ptr[FcPattern] = extern

  def FcFontSetAdd(s : Ptr[FcFontSet], font : Ptr[FcPattern]): FcBool = extern

  def FcFontSetCreate(): Ptr[FcFontSet] = extern

  def FcFontSetDestroy(s : Ptr[FcFontSet]): Unit = extern

  def FcFontSetList(config : Ptr[FcConfig], sets : Ptr[Ptr[FcFontSet]], nsets : CInt, p : Ptr[FcPattern], os : Ptr[FcObjectSet]): Ptr[FcFontSet] = extern

  def FcFontSetMatch(config : Ptr[FcConfig], sets : Ptr[Ptr[FcFontSet]], nsets : CInt, p : Ptr[FcPattern], result : Ptr[FcResult]): Ptr[FcPattern] = extern

  def FcFontSetPrint(s : Ptr[FcFontSet]): Unit = extern

  def FcFontSetSort(config : Ptr[FcConfig], sets : Ptr[Ptr[FcFontSet]], nsets : CInt, p : Ptr[FcPattern], trim : FcBool, csp : Ptr[Ptr[FcCharSet]], result : Ptr[FcResult]): Ptr[FcFontSet] = extern

  def FcFontSetSortDestroy(fs : Ptr[FcFontSet]): Unit = extern

  def FcFontSort(config : Ptr[FcConfig], p : Ptr[FcPattern], trim : FcBool, csp : Ptr[Ptr[FcCharSet]], result : Ptr[FcResult]): Ptr[FcFontSet] = extern

  def FcFreeTypeQuery(file : Ptr[FcChar8], id : CUnsignedInt, blanks : Ptr[FcBlanks], count : Ptr[CInt]): Ptr[FcPattern] = extern

  def FcFreeTypeQueryAll(file : Ptr[FcChar8], id : CUnsignedInt, blanks : Ptr[FcBlanks], count : Ptr[CInt], set : Ptr[FcFontSet]): CUnsignedInt = extern

  def FcGetDefaultLangs(): Ptr[FcStrSet] = extern

  def FcGetLangs(): Ptr[FcStrSet] = extern

  def FcGetVersion(): CInt = extern

  def FcInit(): FcBool = extern

  def FcInitBringUptoDate(): FcBool = extern

  def FcInitLoadConfig(): Ptr[FcConfig] = extern

  def FcInitLoadConfigAndFonts(): Ptr[FcConfig] = extern

  def FcInitReinitialize(): FcBool = extern

  def FcLangGetCharSet(lang : Ptr[FcChar8]): Ptr[FcCharSet] = extern

  def FcLangNormalize(lang : Ptr[FcChar8]): Ptr[FcChar8] = extern

  def FcLangSetAdd(ls : Ptr[FcLangSet], lang : Ptr[FcChar8]): FcBool = extern

  def FcLangSetCompare(lsa : Ptr[FcLangSet], lsb : Ptr[FcLangSet]): FcLangResult = extern

  def FcLangSetContains(lsa : Ptr[FcLangSet], lsb : Ptr[FcLangSet]): FcBool = extern

  def FcLangSetCopy(ls : Ptr[FcLangSet]): Ptr[FcLangSet] = extern

  def FcLangSetCreate(): Ptr[FcLangSet] = extern

  def FcLangSetDel(ls : Ptr[FcLangSet], lang : Ptr[FcChar8]): FcBool = extern

  def FcLangSetDestroy(ls : Ptr[FcLangSet]): Unit = extern

  def FcLangSetEqual(lsa : Ptr[FcLangSet], lsb : Ptr[FcLangSet]): FcBool = extern

  def FcLangSetGetLangs(ls : Ptr[FcLangSet]): Ptr[FcStrSet] = extern

  def FcLangSetHasLang(ls : Ptr[FcLangSet], lang : Ptr[FcChar8]): FcLangResult = extern

  def FcLangSetHash(ls : Ptr[FcLangSet]): FcChar32 = extern

  def FcLangSetSubtract(a : Ptr[FcLangSet], b : Ptr[FcLangSet]): Ptr[FcLangSet] = extern

  def FcLangSetUnion(a : Ptr[FcLangSet], b : Ptr[FcLangSet]): Ptr[FcLangSet] = extern

  def FcMatrixCopy(mat : Ptr[FcMatrix]): Ptr[FcMatrix] = extern

  def FcMatrixEqual(mat1 : Ptr[FcMatrix], mat2 : Ptr[FcMatrix]): FcBool = extern

  def FcMatrixMultiply(result : Ptr[FcMatrix], a : Ptr[FcMatrix], b : Ptr[FcMatrix]): Unit = extern

  def FcMatrixRotate(m : Ptr[FcMatrix], c : Double, s : Double): Unit = extern

  def FcMatrixScale(m : Ptr[FcMatrix], sx : Double, sy : Double): Unit = extern

  def FcMatrixShear(m : Ptr[FcMatrix], sh : Double, sv : Double): Unit = extern

  def FcNameConstant(string : Ptr[FcChar8], result : Ptr[CInt]): FcBool = extern

  def FcNameGetConstant(string : Ptr[FcChar8]): Ptr[FcConstant] = extern

  def FcNameGetConstantFor(string : Ptr[FcChar8], `object` : CString): Ptr[FcConstant] = extern

  def FcNameGetObjectType(`object` : CString): Ptr[FcObjectType] = extern

  def FcNameParse(name : Ptr[FcChar8]): Ptr[FcPattern] = extern

  def FcNameRegisterConstants(consts : Ptr[FcConstant], nconsts : CInt): FcBool = extern

  def FcNameRegisterObjectTypes(types : Ptr[FcObjectType], ntype : CInt): FcBool = extern

  def FcNameUnparse(pat : Ptr[FcPattern]): Ptr[FcChar8] = extern

  def FcNameUnregisterConstants(consts : Ptr[FcConstant], nconsts : CInt): FcBool = extern

  def FcNameUnregisterObjectTypes(types : Ptr[FcObjectType], ntype : CInt): FcBool = extern

  def FcObjectSetAdd(os : Ptr[FcObjectSet], `object` : CString): FcBool = extern

  def FcObjectSetBuild(first : CString, rest: Any*): Ptr[FcObjectSet] = extern

  def FcObjectSetCreate(): Ptr[FcObjectSet] = extern

  def FcObjectSetDestroy(os : Ptr[FcObjectSet]): Unit = extern

  def FcObjectSetVaBuild(first : CString, va : va_list): Ptr[FcObjectSet] = extern

  def FcPatternAddBool(p : Ptr[FcPattern], `object` : CString, b : FcBool): FcBool = extern

  def FcPatternAddCharSet(p : Ptr[FcPattern], `object` : CString, c : Ptr[FcCharSet]): FcBool = extern

  def FcPatternAddDouble(p : Ptr[FcPattern], `object` : CString, d : Double): FcBool = extern

  def FcPatternAddInteger(p : Ptr[FcPattern], `object` : CString, i : CInt): FcBool = extern

  def FcPatternAddLangSet(p : Ptr[FcPattern], `object` : CString, ls : Ptr[FcLangSet]): FcBool = extern

  def FcPatternAddMatrix(p : Ptr[FcPattern], `object` : CString, s : Ptr[FcMatrix]): FcBool = extern

  def FcPatternAddRange(p : Ptr[FcPattern], `object` : CString, r : Ptr[FcRange]): FcBool = extern

  def FcPatternAddString(p : Ptr[FcPattern], `object` : CString, s : Ptr[FcChar8]): FcBool = extern

  def FcPatternBuild(p : Ptr[FcPattern], rest: Any*): Ptr[FcPattern] = extern

  def FcPatternCreate(): Ptr[FcPattern] = extern

  def FcPatternDel(p : Ptr[FcPattern], `object` : CString): FcBool = extern

  def FcPatternDestroy(p : Ptr[FcPattern]): Unit = extern

  def FcPatternDuplicate(p : Ptr[FcPattern]): Ptr[FcPattern] = extern

  def FcPatternEqual(pa : Ptr[FcPattern], pb : Ptr[FcPattern]): FcBool = extern

  def FcPatternEqualSubset(pa : Ptr[FcPattern], pb : Ptr[FcPattern], os : Ptr[FcObjectSet]): FcBool = extern

  def FcPatternFilter(p : Ptr[FcPattern], os : Ptr[FcObjectSet]): Ptr[FcPattern] = extern

  def FcPatternFindIter(pat : Ptr[FcPattern], iter : Ptr[FcPatternIter], `object` : CString): FcBool = extern

  def FcPatternFormat(pat : Ptr[FcPattern], format : Ptr[FcChar8]): Ptr[FcChar8] = extern

  def FcPatternGet(p : Ptr[FcPattern], `object` : CString, id : CInt, v : Ptr[FcValue]): FcResult = extern

  def FcPatternGetBool(p : Ptr[FcPattern], `object` : CString, n : CInt, b : Ptr[FcBool]): FcResult = extern

  def FcPatternGetCharSet(p : Ptr[FcPattern], `object` : CString, n : CInt, c : Ptr[Ptr[FcCharSet]]): FcResult = extern

  def FcPatternGetDouble(p : Ptr[FcPattern], `object` : CString, n : CInt, d : Ptr[Double]): FcResult = extern

  def FcPatternGetInteger(p : Ptr[FcPattern], `object` : CString, n : CInt, i : Ptr[CInt]): FcResult = extern

  def FcPatternGetLangSet(p : Ptr[FcPattern], `object` : CString, n : CInt, ls : Ptr[Ptr[FcLangSet]]): FcResult = extern

  def FcPatternGetMatrix(p : Ptr[FcPattern], `object` : CString, n : CInt, s : Ptr[Ptr[FcMatrix]]): FcResult = extern

  def FcPatternGetRange(p : Ptr[FcPattern], `object` : CString, id : CInt, r : Ptr[Ptr[FcRange]]): FcResult = extern

  def FcPatternGetString(p : Ptr[FcPattern], `object` : CString, n : CInt, s : Ptr[Ptr[FcChar8]]): FcResult = extern

  def FcPatternGetWithBinding(p : Ptr[FcPattern], `object` : CString, id : CInt, v : Ptr[FcValue], b : Ptr[FcValueBinding]): FcResult = extern

  def FcPatternHash(p : Ptr[FcPattern]): FcChar32 = extern

  def FcPatternIterEqual(p1 : Ptr[FcPattern], i1 : Ptr[FcPatternIter], p2 : Ptr[FcPattern], i2 : Ptr[FcPatternIter]): FcBool = extern

  def FcPatternIterGetObject(pat : Ptr[FcPattern], iter : Ptr[FcPatternIter]): CString = extern

  def FcPatternIterGetValue(pat : Ptr[FcPattern], iter : Ptr[FcPatternIter], id : CInt, v : Ptr[FcValue], b : Ptr[FcValueBinding]): FcResult = extern

  def FcPatternIterIsValid(pat : Ptr[FcPattern], iter : Ptr[FcPatternIter]): FcBool = extern

  def FcPatternIterNext(pat : Ptr[FcPattern], iter : Ptr[FcPatternIter]): FcBool = extern

  def FcPatternIterStart(pat : Ptr[FcPattern], iter : Ptr[FcPatternIter]): Unit = extern

  def FcPatternIterValueCount(pat : Ptr[FcPattern], iter : Ptr[FcPatternIter]): CInt = extern

  def FcPatternObjectCount(pat : Ptr[FcPattern]): CInt = extern

  def FcPatternPrint(p : Ptr[FcPattern]): Unit = extern

  def FcPatternReference(p : Ptr[FcPattern]): Unit = extern

  def FcPatternRemove(p : Ptr[FcPattern], `object` : CString, id : CInt): FcBool = extern

  def FcPatternVaBuild(p : Ptr[FcPattern], va : va_list): Ptr[FcPattern] = extern

  def FcRangeCopy(r : Ptr[FcRange]): Ptr[FcRange] = extern

  def FcRangeCreateDouble(begin : Double, end : Double): Ptr[FcRange] = extern

  def FcRangeCreateInteger(begin : FcChar32, end : FcChar32): Ptr[FcRange] = extern

  def FcRangeDestroy(range : Ptr[FcRange]): Unit = extern

  def FcRangeGetDouble(range : Ptr[FcRange], begin : Ptr[Double], end : Ptr[Double]): FcBool = extern

  def FcStrBasename(file : Ptr[FcChar8]): Ptr[FcChar8] = extern

  def FcStrBuildFilename(path : Ptr[FcChar8], rest: Any*): Ptr[FcChar8] = extern

  def FcStrCmp(s1 : Ptr[FcChar8], s2 : Ptr[FcChar8]): CInt = extern

  def FcStrCmpIgnoreCase(s1 : Ptr[FcChar8], s2 : Ptr[FcChar8]): CInt = extern

  def FcStrCopy(s : Ptr[FcChar8]): Ptr[FcChar8] = extern

  def FcStrCopyFilename(s : Ptr[FcChar8]): Ptr[FcChar8] = extern

  def FcStrDirname(file : Ptr[FcChar8]): Ptr[FcChar8] = extern

  def FcStrDowncase(s : Ptr[FcChar8]): Ptr[FcChar8] = extern

  def FcStrFree(s : Ptr[FcChar8]): Unit = extern

  def FcStrListCreate(set : Ptr[FcStrSet]): Ptr[FcStrList] = extern

  def FcStrListDone(list : Ptr[FcStrList]): Unit = extern

  def FcStrListFirst(list : Ptr[FcStrList]): Unit = extern

  def FcStrListNext(list : Ptr[FcStrList]): Ptr[FcChar8] = extern

  def FcStrPlus(s1 : Ptr[FcChar8], s2 : Ptr[FcChar8]): Ptr[FcChar8] = extern

  def FcStrSetAdd(set : Ptr[FcStrSet], s : Ptr[FcChar8]): FcBool = extern

  def FcStrSetAddFilename(set : Ptr[FcStrSet], s : Ptr[FcChar8]): FcBool = extern

  def FcStrSetCreate(): Ptr[FcStrSet] = extern

  def FcStrSetDel(set : Ptr[FcStrSet], s : Ptr[FcChar8]): FcBool = extern

  def FcStrSetDestroy(set : Ptr[FcStrSet]): Unit = extern

  def FcStrSetEqual(sa : Ptr[FcStrSet], sb : Ptr[FcStrSet]): FcBool = extern

  def FcStrSetMember(set : Ptr[FcStrSet], s : Ptr[FcChar8]): FcBool = extern

  def FcStrStr(s1 : Ptr[FcChar8], s2 : Ptr[FcChar8]): Ptr[FcChar8] = extern

  def FcStrStrIgnoreCase(s1 : Ptr[FcChar8], s2 : Ptr[FcChar8]): Ptr[FcChar8] = extern

  def FcUcs4ToUtf8(ucs4 : FcChar32, dest : CArray[FcChar8, Nat._6]): CInt = extern

  def FcUtf16Len(string : Ptr[FcChar8], endian : FcEndian, len : CInt, nchar : Ptr[CInt], wchar : Ptr[CInt]): FcBool = extern

  def FcUtf16ToUcs4(src_orig : Ptr[FcChar8], endian : FcEndian, dst : Ptr[FcChar32], len : CInt): CInt = extern

  def FcUtf8Len(string : Ptr[FcChar8], len : CInt, nchar : Ptr[CInt], wchar : Ptr[CInt]): FcBool = extern

  def FcUtf8ToUcs4(src_orig : Ptr[FcChar8], dst : Ptr[FcChar32], len : CInt): CInt = extern

  def FcWeightFromOpenType(ot_weight : CInt): CInt = extern

  def FcWeightFromOpenTypeDouble(ot_weight : Double): Double = extern

  def FcWeightToOpenType(fc_weight : CInt): CInt = extern

  def FcWeightToOpenTypeDouble(fc_weight : Double): Double = extern

  private[cairo] def __sn_wrap_cairo_FcPatternAdd(p : Ptr[FcPattern], `object` : CString, value : Ptr[FcValue], append : FcBool): FcBool = extern

  private[cairo] def __sn_wrap_cairo_FcPatternAddWeak(p : Ptr[FcPattern], `object` : CString, value : Ptr[FcValue], append : FcBool): FcBool = extern

  private[cairo] def __sn_wrap_cairo_FcValueDestroy(v : Ptr[FcValue]): Unit = extern

  private[cairo] def __sn_wrap_cairo_FcValueEqual(va : Ptr[FcValue], vb : Ptr[FcValue]): FcBool = extern

  private[cairo] def __sn_wrap_cairo_FcValuePrint(v : Ptr[FcValue]): Unit = extern

  private[cairo] def __sn_wrap_cairo_FcValueSave(v : Ptr[FcValue], __return : Ptr[FcValue]): Unit = extern

  def cairo_append_path(cr : Ptr[cairo_t], path : Ptr[cairo_path_t]): Unit = extern

  def cairo_arc(cr : Ptr[cairo_t], xc : Double, yc : Double, radius : Double, angle1 : Double, angle2 : Double): Unit = extern

  def cairo_arc_negative(cr : Ptr[cairo_t], xc : Double, yc : Double, radius : Double, angle1 : Double, angle2 : Double): Unit = extern

  def cairo_clip(cr : Ptr[cairo_t]): Unit = extern

  def cairo_clip_extents(cr : Ptr[cairo_t], x1 : Ptr[Double], y1 : Ptr[Double], x2 : Ptr[Double], y2 : Ptr[Double]): Unit = extern

  def cairo_clip_preserve(cr : Ptr[cairo_t]): Unit = extern

  def cairo_close_path(cr : Ptr[cairo_t]): Unit = extern

  def cairo_copy_clip_rectangle_list(cr : Ptr[cairo_t]): Ptr[cairo_rectangle_list_t] = extern

  def cairo_copy_page(cr : Ptr[cairo_t]): Unit = extern

  def cairo_copy_path(cr : Ptr[cairo_t]): Ptr[cairo_path_t] = extern

  def cairo_copy_path_flat(cr : Ptr[cairo_t]): Ptr[cairo_path_t] = extern

  def cairo_create(target : Ptr[cairo_surface_t]): Ptr[cairo_t] = extern

  def cairo_curve_to(cr : Ptr[cairo_t], x1 : Double, y1 : Double, x2 : Double, y2 : Double, x3 : Double, y3 : Double): Unit = extern

  def cairo_debug_reset_static_data(): Unit = extern

  def cairo_destroy(cr : Ptr[cairo_t]): Unit = extern

  def cairo_device_acquire(device : Ptr[cairo_device_t]): cairo_status_t = extern

  def cairo_device_destroy(device : Ptr[cairo_device_t]): Unit = extern

  def cairo_device_finish(device : Ptr[cairo_device_t]): Unit = extern

  def cairo_device_flush(device : Ptr[cairo_device_t]): Unit = extern

  def cairo_device_get_reference_count(device : Ptr[cairo_device_t]): CUnsignedInt = extern

  def cairo_device_get_type(device : Ptr[cairo_device_t]): cairo_device_type_t = extern

  def cairo_device_get_user_data(device : Ptr[cairo_device_t], key : Ptr[cairo_user_data_key_t]): Ptr[Byte] = extern

  def cairo_device_observer_elapsed(abstract_device : Ptr[cairo_device_t]): Double = extern

  def cairo_device_observer_fill_elapsed(abstract_device : Ptr[cairo_device_t]): Double = extern

  def cairo_device_observer_glyphs_elapsed(abstract_device : Ptr[cairo_device_t]): Double = extern

  def cairo_device_observer_mask_elapsed(abstract_device : Ptr[cairo_device_t]): Double = extern

  def cairo_device_observer_paint_elapsed(abstract_device : Ptr[cairo_device_t]): Double = extern

  def cairo_device_observer_print(abstract_device : Ptr[cairo_device_t], write_func : cairo_write_func_t, closure : Ptr[Byte]): cairo_status_t = extern

  def cairo_device_observer_stroke_elapsed(abstract_device : Ptr[cairo_device_t]): Double = extern

  def cairo_device_reference(device : Ptr[cairo_device_t]): Ptr[cairo_device_t] = extern

  def cairo_device_release(device : Ptr[cairo_device_t]): Unit = extern

  def cairo_device_set_user_data(device : Ptr[cairo_device_t], key : Ptr[cairo_user_data_key_t], user_data : Ptr[Byte], destroy : cairo_destroy_func_t): cairo_status_t = extern

  def cairo_device_status(device : Ptr[cairo_device_t]): cairo_status_t = extern

  def cairo_device_to_user(cr : Ptr[cairo_t], x : Ptr[Double], y : Ptr[Double]): Unit = extern

  def cairo_device_to_user_distance(cr : Ptr[cairo_t], dx : Ptr[Double], dy : Ptr[Double]): Unit = extern

  def cairo_fill(cr : Ptr[cairo_t]): Unit = extern

  def cairo_fill_extents(cr : Ptr[cairo_t], x1 : Ptr[Double], y1 : Ptr[Double], x2 : Ptr[Double], y2 : Ptr[Double]): Unit = extern

  def cairo_fill_preserve(cr : Ptr[cairo_t]): Unit = extern

  def cairo_font_extents(cr : Ptr[cairo_t], extents : Ptr[cairo_font_extents_t]): Unit = extern

  def cairo_font_face_destroy(font_face : Ptr[cairo_font_face_t]): Unit = extern

  def cairo_font_face_get_reference_count(font_face : Ptr[cairo_font_face_t]): CUnsignedInt = extern

  def cairo_font_face_get_type(font_face : Ptr[cairo_font_face_t]): cairo_font_type_t = extern

  def cairo_font_face_get_user_data(font_face : Ptr[cairo_font_face_t], key : Ptr[cairo_user_data_key_t]): Ptr[Byte] = extern

  def cairo_font_face_reference(font_face : Ptr[cairo_font_face_t]): Ptr[cairo_font_face_t] = extern

  def cairo_font_face_set_user_data(font_face : Ptr[cairo_font_face_t], key : Ptr[cairo_user_data_key_t], user_data : Ptr[Byte], destroy : cairo_destroy_func_t): cairo_status_t = extern

  def cairo_font_face_status(font_face : Ptr[cairo_font_face_t]): cairo_status_t = extern

  def cairo_font_options_copy(original : Ptr[cairo_font_options_t]): Ptr[cairo_font_options_t] = extern

  def cairo_font_options_create(): Ptr[cairo_font_options_t] = extern

  def cairo_font_options_destroy(options : Ptr[cairo_font_options_t]): Unit = extern

  def cairo_font_options_equal(options : Ptr[cairo_font_options_t], other : Ptr[cairo_font_options_t]): cairo_bool_t = extern

  def cairo_font_options_get_antialias(options : Ptr[cairo_font_options_t]): cairo_antialias_t = extern

  def cairo_font_options_get_color_mode(options : Ptr[cairo_font_options_t]): cairo_color_mode_t = extern

  def cairo_font_options_get_color_palette(options : Ptr[cairo_font_options_t]): CUnsignedInt = extern

  def cairo_font_options_get_custom_palette_color(options : Ptr[cairo_font_options_t], index : CUnsignedInt, red : Ptr[Double], green : Ptr[Double], blue : Ptr[Double], alpha : Ptr[Double]): cairo_status_t = extern

  def cairo_font_options_get_hint_metrics(options : Ptr[cairo_font_options_t]): cairo_hint_metrics_t = extern

  def cairo_font_options_get_hint_style(options : Ptr[cairo_font_options_t]): cairo_hint_style_t = extern

  def cairo_font_options_get_subpixel_order(options : Ptr[cairo_font_options_t]): cairo_subpixel_order_t = extern

  def cairo_font_options_get_variations(options : Ptr[cairo_font_options_t]): CString = extern

  def cairo_font_options_hash(options : Ptr[cairo_font_options_t]): CUnsignedLongInt = extern

  def cairo_font_options_merge(options : Ptr[cairo_font_options_t], other : Ptr[cairo_font_options_t]): Unit = extern

  def cairo_font_options_set_antialias(options : Ptr[cairo_font_options_t], antialias : cairo_antialias_t): Unit = extern

  def cairo_font_options_set_color_mode(options : Ptr[cairo_font_options_t], color_mode : cairo_color_mode_t): Unit = extern

  def cairo_font_options_set_color_palette(options : Ptr[cairo_font_options_t], palette_index : CUnsignedInt): Unit = extern

  def cairo_font_options_set_custom_palette_color(options : Ptr[cairo_font_options_t], index : CUnsignedInt, red : Double, green : Double, blue : Double, alpha : Double): Unit = extern

  def cairo_font_options_set_hint_metrics(options : Ptr[cairo_font_options_t], hint_metrics : cairo_hint_metrics_t): Unit = extern

  def cairo_font_options_set_hint_style(options : Ptr[cairo_font_options_t], hint_style : cairo_hint_style_t): Unit = extern

  def cairo_font_options_set_subpixel_order(options : Ptr[cairo_font_options_t], subpixel_order : cairo_subpixel_order_t): Unit = extern

  def cairo_font_options_set_variations(options : Ptr[cairo_font_options_t], variations : CString): Unit = extern

  def cairo_font_options_status(options : Ptr[cairo_font_options_t]): cairo_status_t = extern

  def cairo_format_stride_for_width(format : cairo_format_t, width : CInt): CInt = extern

  def cairo_ft_font_face_create_for_ft_face(face : FT_Face, load_flags : CInt): Ptr[cairo_font_face_t] = extern

  def cairo_ft_font_face_create_for_pattern(pattern : Ptr[FcPattern]): Ptr[cairo_font_face_t] = extern

  def cairo_ft_font_face_get_synthesize(font_face : Ptr[cairo_font_face_t]): CUnsignedInt = extern

  def cairo_ft_font_face_set_synthesize(font_face : Ptr[cairo_font_face_t], synth_flags : CUnsignedInt): Unit = extern

  def cairo_ft_font_face_unset_synthesize(font_face : Ptr[cairo_font_face_t], synth_flags : CUnsignedInt): Unit = extern

  def cairo_ft_font_options_substitute(options : Ptr[cairo_font_options_t], pattern : Ptr[FcPattern]): Unit = extern

  def cairo_ft_scaled_font_lock_face(scaled_font : Ptr[cairo_scaled_font_t]): FT_Face = extern

  def cairo_ft_scaled_font_unlock_face(scaled_font : Ptr[cairo_scaled_font_t]): Unit = extern

  def cairo_get_antialias(cr : Ptr[cairo_t]): cairo_antialias_t = extern

  def cairo_get_current_point(cr : Ptr[cairo_t], x : Ptr[Double], y : Ptr[Double]): Unit = extern

  def cairo_get_dash(cr : Ptr[cairo_t], dashes : Ptr[Double], offset : Ptr[Double]): Unit = extern

  def cairo_get_dash_count(cr : Ptr[cairo_t]): CInt = extern

  def cairo_get_fill_rule(cr : Ptr[cairo_t]): cairo_fill_rule_t = extern

  def cairo_get_font_face(cr : Ptr[cairo_t]): Ptr[cairo_font_face_t] = extern

  def cairo_get_font_matrix(cr : Ptr[cairo_t], matrix : Ptr[cairo_matrix_t]): Unit = extern

  def cairo_get_font_options(cr : Ptr[cairo_t], options : Ptr[cairo_font_options_t]): Unit = extern

  def cairo_get_group_target(cr : Ptr[cairo_t]): Ptr[cairo_surface_t] = extern

  def cairo_get_hairline(cr : Ptr[cairo_t]): cairo_bool_t = extern

  def cairo_get_line_cap(cr : Ptr[cairo_t]): cairo_line_cap_t = extern

  def cairo_get_line_join(cr : Ptr[cairo_t]): cairo_line_join_t = extern

  def cairo_get_line_width(cr : Ptr[cairo_t]): Double = extern

  def cairo_get_matrix(cr : Ptr[cairo_t], matrix : Ptr[cairo_matrix_t]): Unit = extern

  def cairo_get_miter_limit(cr : Ptr[cairo_t]): Double = extern

  def cairo_get_operator(cr : Ptr[cairo_t]): cairo_operator_t = extern

  def cairo_get_reference_count(cr : Ptr[cairo_t]): CUnsignedInt = extern

  def cairo_get_scaled_font(cr : Ptr[cairo_t]): Ptr[cairo_scaled_font_t] = extern

  def cairo_get_source(cr : Ptr[cairo_t]): Ptr[cairo_pattern_t] = extern

  def cairo_get_target(cr : Ptr[cairo_t]): Ptr[cairo_surface_t] = extern

  def cairo_get_tolerance(cr : Ptr[cairo_t]): Double = extern

  def cairo_get_user_data(cr : Ptr[cairo_t], key : Ptr[cairo_user_data_key_t]): Ptr[Byte] = extern

  def cairo_glyph_allocate(num_glyphs : CInt): Ptr[cairo_glyph_t] = extern

  def cairo_glyph_extents(cr : Ptr[cairo_t], glyphs : Ptr[cairo_glyph_t], num_glyphs : CInt, extents : Ptr[cairo_text_extents_t]): Unit = extern

  def cairo_glyph_free(glyphs : Ptr[cairo_glyph_t]): Unit = extern

  def cairo_glyph_path(cr : Ptr[cairo_t], glyphs : Ptr[cairo_glyph_t], num_glyphs : CInt): Unit = extern

  def cairo_has_current_point(cr : Ptr[cairo_t]): cairo_bool_t = extern

  def cairo_identity_matrix(cr : Ptr[cairo_t]): Unit = extern

  def cairo_image_surface_create(format : cairo_format_t, width : CInt, height : CInt): Ptr[cairo_surface_t] = extern

  def cairo_image_surface_create_for_data(data : Ptr[CUnsignedChar], format : cairo_format_t, width : CInt, height : CInt, stride : CInt): Ptr[cairo_surface_t] = extern

  def cairo_image_surface_create_from_png(filename : CString): Ptr[cairo_surface_t] = extern

  def cairo_image_surface_create_from_png_stream(read_func : cairo_read_func_t, closure : Ptr[Byte]): Ptr[cairo_surface_t] = extern

  def cairo_image_surface_get_data(surface : Ptr[cairo_surface_t]): Ptr[CUnsignedChar] = extern

  def cairo_image_surface_get_format(surface : Ptr[cairo_surface_t]): cairo_format_t = extern

  def cairo_image_surface_get_height(surface : Ptr[cairo_surface_t]): CInt = extern

  def cairo_image_surface_get_stride(surface : Ptr[cairo_surface_t]): CInt = extern

  def cairo_image_surface_get_width(surface : Ptr[cairo_surface_t]): CInt = extern

  def cairo_in_clip(cr : Ptr[cairo_t], x : Double, y : Double): cairo_bool_t = extern

  def cairo_in_fill(cr : Ptr[cairo_t], x : Double, y : Double): cairo_bool_t = extern

  def cairo_in_stroke(cr : Ptr[cairo_t], x : Double, y : Double): cairo_bool_t = extern

  def cairo_line_to(cr : Ptr[cairo_t], x : Double, y : Double): Unit = extern

  def cairo_mask(cr : Ptr[cairo_t], pattern : Ptr[cairo_pattern_t]): Unit = extern

  def cairo_mask_surface(cr : Ptr[cairo_t], surface : Ptr[cairo_surface_t], surface_x : Double, surface_y : Double): Unit = extern

  def cairo_matrix_init(matrix : Ptr[cairo_matrix_t], xx : Double, yx : Double, xy : Double, yy : Double, x0 : Double, y0 : Double): Unit = extern

  def cairo_matrix_init_identity(matrix : Ptr[cairo_matrix_t]): Unit = extern

  def cairo_matrix_init_rotate(matrix : Ptr[cairo_matrix_t], radians : Double): Unit = extern

  def cairo_matrix_init_scale(matrix : Ptr[cairo_matrix_t], sx : Double, sy : Double): Unit = extern

  def cairo_matrix_init_translate(matrix : Ptr[cairo_matrix_t], tx : Double, ty : Double): Unit = extern

  def cairo_matrix_invert(matrix : Ptr[cairo_matrix_t]): cairo_status_t = extern

  def cairo_matrix_multiply(result : Ptr[cairo_matrix_t], a : Ptr[cairo_matrix_t], b : Ptr[cairo_matrix_t]): Unit = extern

  def cairo_matrix_rotate(matrix : Ptr[cairo_matrix_t], radians : Double): Unit = extern

  def cairo_matrix_scale(matrix : Ptr[cairo_matrix_t], sx : Double, sy : Double): Unit = extern

  def cairo_matrix_transform_distance(matrix : Ptr[cairo_matrix_t], dx : Ptr[Double], dy : Ptr[Double]): Unit = extern

  def cairo_matrix_transform_point(matrix : Ptr[cairo_matrix_t], x : Ptr[Double], y : Ptr[Double]): Unit = extern

  def cairo_matrix_translate(matrix : Ptr[cairo_matrix_t], tx : Double, ty : Double): Unit = extern

  def cairo_mesh_pattern_begin_patch(pattern : Ptr[cairo_pattern_t]): Unit = extern

  def cairo_mesh_pattern_curve_to(pattern : Ptr[cairo_pattern_t], x1 : Double, y1 : Double, x2 : Double, y2 : Double, x3 : Double, y3 : Double): Unit = extern

  def cairo_mesh_pattern_end_patch(pattern : Ptr[cairo_pattern_t]): Unit = extern

  def cairo_mesh_pattern_get_control_point(pattern : Ptr[cairo_pattern_t], patch_num : CUnsignedInt, point_num : CUnsignedInt, x : Ptr[Double], y : Ptr[Double]): cairo_status_t = extern

  def cairo_mesh_pattern_get_corner_color_rgba(pattern : Ptr[cairo_pattern_t], patch_num : CUnsignedInt, corner_num : CUnsignedInt, red : Ptr[Double], green : Ptr[Double], blue : Ptr[Double], alpha : Ptr[Double]): cairo_status_t = extern

  def cairo_mesh_pattern_get_patch_count(pattern : Ptr[cairo_pattern_t], count : Ptr[CUnsignedInt]): cairo_status_t = extern

  def cairo_mesh_pattern_get_path(pattern : Ptr[cairo_pattern_t], patch_num : CUnsignedInt): Ptr[cairo_path_t] = extern

  def cairo_mesh_pattern_line_to(pattern : Ptr[cairo_pattern_t], x : Double, y : Double): Unit = extern

  def cairo_mesh_pattern_move_to(pattern : Ptr[cairo_pattern_t], x : Double, y : Double): Unit = extern

  def cairo_mesh_pattern_set_control_point(pattern : Ptr[cairo_pattern_t], point_num : CUnsignedInt, x : Double, y : Double): Unit = extern

  def cairo_mesh_pattern_set_corner_color_rgb(pattern : Ptr[cairo_pattern_t], corner_num : CUnsignedInt, red : Double, green : Double, blue : Double): Unit = extern

  def cairo_mesh_pattern_set_corner_color_rgba(pattern : Ptr[cairo_pattern_t], corner_num : CUnsignedInt, red : Double, green : Double, blue : Double, alpha : Double): Unit = extern

  def cairo_move_to(cr : Ptr[cairo_t], x : Double, y : Double): Unit = extern

  def cairo_new_path(cr : Ptr[cairo_t]): Unit = extern

  def cairo_new_sub_path(cr : Ptr[cairo_t]): Unit = extern

  def cairo_paint(cr : Ptr[cairo_t]): Unit = extern

  def cairo_paint_with_alpha(cr : Ptr[cairo_t], alpha : Double): Unit = extern

  def cairo_path_destroy(path : Ptr[cairo_path_t]): Unit = extern

  def cairo_path_extents(cr : Ptr[cairo_t], x1 : Ptr[Double], y1 : Ptr[Double], x2 : Ptr[Double], y2 : Ptr[Double]): Unit = extern

  def cairo_pattern_add_color_stop_rgb(pattern : Ptr[cairo_pattern_t], offset : Double, red : Double, green : Double, blue : Double): Unit = extern

  def cairo_pattern_add_color_stop_rgba(pattern : Ptr[cairo_pattern_t], offset : Double, red : Double, green : Double, blue : Double, alpha : Double): Unit = extern

  def cairo_pattern_create_for_surface(surface : Ptr[cairo_surface_t]): Ptr[cairo_pattern_t] = extern

  def cairo_pattern_create_linear(x0 : Double, y0 : Double, x1 : Double, y1 : Double): Ptr[cairo_pattern_t] = extern

  def cairo_pattern_create_mesh(): Ptr[cairo_pattern_t] = extern

  def cairo_pattern_create_radial(cx0 : Double, cy0 : Double, radius0 : Double, cx1 : Double, cy1 : Double, radius1 : Double): Ptr[cairo_pattern_t] = extern

  def cairo_pattern_create_raster_source(user_data : Ptr[Byte], content : cairo_content_t, width : CInt, height : CInt): Ptr[cairo_pattern_t] = extern

  def cairo_pattern_create_rgb(red : Double, green : Double, blue : Double): Ptr[cairo_pattern_t] = extern

  def cairo_pattern_create_rgba(red : Double, green : Double, blue : Double, alpha : Double): Ptr[cairo_pattern_t] = extern

  def cairo_pattern_destroy(pattern : Ptr[cairo_pattern_t]): Unit = extern

  def cairo_pattern_get_color_stop_count(pattern : Ptr[cairo_pattern_t], count : Ptr[CInt]): cairo_status_t = extern

  def cairo_pattern_get_color_stop_rgba(pattern : Ptr[cairo_pattern_t], index : CInt, offset : Ptr[Double], red : Ptr[Double], green : Ptr[Double], blue : Ptr[Double], alpha : Ptr[Double]): cairo_status_t = extern

  def cairo_pattern_get_dither(pattern : Ptr[cairo_pattern_t]): cairo_dither_t = extern

  def cairo_pattern_get_extend(pattern : Ptr[cairo_pattern_t]): cairo_extend_t = extern

  def cairo_pattern_get_filter(pattern : Ptr[cairo_pattern_t]): cairo_filter_t = extern

  def cairo_pattern_get_linear_points(pattern : Ptr[cairo_pattern_t], x0 : Ptr[Double], y0 : Ptr[Double], x1 : Ptr[Double], y1 : Ptr[Double]): cairo_status_t = extern

  def cairo_pattern_get_matrix(pattern : Ptr[cairo_pattern_t], matrix : Ptr[cairo_matrix_t]): Unit = extern

  def cairo_pattern_get_radial_circles(pattern : Ptr[cairo_pattern_t], x0 : Ptr[Double], y0 : Ptr[Double], r0 : Ptr[Double], x1 : Ptr[Double], y1 : Ptr[Double], r1 : Ptr[Double]): cairo_status_t = extern

  def cairo_pattern_get_reference_count(pattern : Ptr[cairo_pattern_t]): CUnsignedInt = extern

  def cairo_pattern_get_rgba(pattern : Ptr[cairo_pattern_t], red : Ptr[Double], green : Ptr[Double], blue : Ptr[Double], alpha : Ptr[Double]): cairo_status_t = extern

  def cairo_pattern_get_surface(pattern : Ptr[cairo_pattern_t], surface : Ptr[Ptr[cairo_surface_t]]): cairo_status_t = extern

  def cairo_pattern_get_type(pattern : Ptr[cairo_pattern_t]): cairo_pattern_type_t = extern

  def cairo_pattern_get_user_data(pattern : Ptr[cairo_pattern_t], key : Ptr[cairo_user_data_key_t]): Ptr[Byte] = extern

  def cairo_pattern_reference(pattern : Ptr[cairo_pattern_t]): Ptr[cairo_pattern_t] = extern

  def cairo_pattern_set_dither(pattern : Ptr[cairo_pattern_t], dither : cairo_dither_t): Unit = extern

  def cairo_pattern_set_extend(pattern : Ptr[cairo_pattern_t], extend : cairo_extend_t): Unit = extern

  def cairo_pattern_set_filter(pattern : Ptr[cairo_pattern_t], filter : cairo_filter_t): Unit = extern

  def cairo_pattern_set_matrix(pattern : Ptr[cairo_pattern_t], matrix : Ptr[cairo_matrix_t]): Unit = extern

  def cairo_pattern_set_user_data(pattern : Ptr[cairo_pattern_t], key : Ptr[cairo_user_data_key_t], user_data : Ptr[Byte], destroy : cairo_destroy_func_t): cairo_status_t = extern

  def cairo_pattern_status(pattern : Ptr[cairo_pattern_t]): cairo_status_t = extern

  def cairo_pop_group(cr : Ptr[cairo_t]): Ptr[cairo_pattern_t] = extern

  def cairo_pop_group_to_source(cr : Ptr[cairo_t]): Unit = extern

  def cairo_push_group(cr : Ptr[cairo_t]): Unit = extern

  def cairo_push_group_with_content(cr : Ptr[cairo_t], content : cairo_content_t): Unit = extern

  def cairo_raster_source_pattern_get_acquire(pattern : Ptr[cairo_pattern_t], acquire : Ptr[cairo_raster_source_acquire_func_t], release : Ptr[cairo_raster_source_release_func_t]): Unit = extern

  def cairo_raster_source_pattern_get_callback_data(pattern : Ptr[cairo_pattern_t]): Ptr[Byte] = extern

  def cairo_raster_source_pattern_get_copy(pattern : Ptr[cairo_pattern_t]): cairo_raster_source_copy_func_t = extern

  def cairo_raster_source_pattern_get_finish(pattern : Ptr[cairo_pattern_t]): cairo_raster_source_finish_func_t = extern

  def cairo_raster_source_pattern_get_snapshot(pattern : Ptr[cairo_pattern_t]): cairo_raster_source_snapshot_func_t = extern

  def cairo_raster_source_pattern_set_acquire(pattern : Ptr[cairo_pattern_t], acquire : cairo_raster_source_acquire_func_t, release : cairo_raster_source_release_func_t): Unit = extern

  def cairo_raster_source_pattern_set_callback_data(pattern : Ptr[cairo_pattern_t], data : Ptr[Byte]): Unit = extern

  def cairo_raster_source_pattern_set_copy(pattern : Ptr[cairo_pattern_t], copy : cairo_raster_source_copy_func_t): Unit = extern

  def cairo_raster_source_pattern_set_finish(pattern : Ptr[cairo_pattern_t], finish : cairo_raster_source_finish_func_t): Unit = extern

  def cairo_raster_source_pattern_set_snapshot(pattern : Ptr[cairo_pattern_t], snapshot : cairo_raster_source_snapshot_func_t): Unit = extern

  def cairo_recording_surface_create(content : cairo_content_t, extents : Ptr[cairo_rectangle_t]): Ptr[cairo_surface_t] = extern

  def cairo_recording_surface_get_extents(surface : Ptr[cairo_surface_t], extents : Ptr[cairo_rectangle_t]): cairo_bool_t = extern

  def cairo_recording_surface_ink_extents(surface : Ptr[cairo_surface_t], x0 : Ptr[Double], y0 : Ptr[Double], width : Ptr[Double], height : Ptr[Double]): Unit = extern

  def cairo_rectangle(cr : Ptr[cairo_t], x : Double, y : Double, width : Double, height : Double): Unit = extern

  def cairo_rectangle_list_destroy(rectangle_list : Ptr[cairo_rectangle_list_t]): Unit = extern

  def cairo_reference(cr : Ptr[cairo_t]): Ptr[cairo_t] = extern

  def cairo_region_contains_point(region : Ptr[cairo_region_t], x : CInt, y : CInt): cairo_bool_t = extern

  def cairo_region_contains_rectangle(region : Ptr[cairo_region_t], rectangle : Ptr[cairo_rectangle_int_t]): cairo_region_overlap_t = extern

  def cairo_region_copy(original : Ptr[cairo_region_t]): Ptr[cairo_region_t] = extern

  def cairo_region_create(): Ptr[cairo_region_t] = extern

  def cairo_region_create_rectangle(rectangle : Ptr[cairo_rectangle_int_t]): Ptr[cairo_region_t] = extern

  def cairo_region_create_rectangles(rects : Ptr[cairo_rectangle_int_t], count : CInt): Ptr[cairo_region_t] = extern

  def cairo_region_destroy(region : Ptr[cairo_region_t]): Unit = extern

  def cairo_region_equal(a : Ptr[cairo_region_t], b : Ptr[cairo_region_t]): cairo_bool_t = extern

  def cairo_region_get_extents(region : Ptr[cairo_region_t], extents : Ptr[cairo_rectangle_int_t]): Unit = extern

  def cairo_region_get_rectangle(region : Ptr[cairo_region_t], nth : CInt, rectangle : Ptr[cairo_rectangle_int_t]): Unit = extern

  def cairo_region_intersect(dst : Ptr[cairo_region_t], other : Ptr[cairo_region_t]): cairo_status_t = extern

  def cairo_region_intersect_rectangle(dst : Ptr[cairo_region_t], rectangle : Ptr[cairo_rectangle_int_t]): cairo_status_t = extern

  def cairo_region_is_empty(region : Ptr[cairo_region_t]): cairo_bool_t = extern

  def cairo_region_num_rectangles(region : Ptr[cairo_region_t]): CInt = extern

  def cairo_region_reference(region : Ptr[cairo_region_t]): Ptr[cairo_region_t] = extern

  def cairo_region_status(region : Ptr[cairo_region_t]): cairo_status_t = extern

  def cairo_region_subtract(dst : Ptr[cairo_region_t], other : Ptr[cairo_region_t]): cairo_status_t = extern

  def cairo_region_subtract_rectangle(dst : Ptr[cairo_region_t], rectangle : Ptr[cairo_rectangle_int_t]): cairo_status_t = extern

  def cairo_region_translate(region : Ptr[cairo_region_t], dx : CInt, dy : CInt): Unit = extern

  def cairo_region_union(dst : Ptr[cairo_region_t], other : Ptr[cairo_region_t]): cairo_status_t = extern

  def cairo_region_union_rectangle(dst : Ptr[cairo_region_t], rectangle : Ptr[cairo_rectangle_int_t]): cairo_status_t = extern

  def cairo_region_xor(dst : Ptr[cairo_region_t], other : Ptr[cairo_region_t]): cairo_status_t = extern

  def cairo_region_xor_rectangle(dst : Ptr[cairo_region_t], rectangle : Ptr[cairo_rectangle_int_t]): cairo_status_t = extern

  def cairo_rel_curve_to(cr : Ptr[cairo_t], dx1 : Double, dy1 : Double, dx2 : Double, dy2 : Double, dx3 : Double, dy3 : Double): Unit = extern

  def cairo_rel_line_to(cr : Ptr[cairo_t], dx : Double, dy : Double): Unit = extern

  def cairo_rel_move_to(cr : Ptr[cairo_t], dx : Double, dy : Double): Unit = extern

  def cairo_reset_clip(cr : Ptr[cairo_t]): Unit = extern

  def cairo_restore(cr : Ptr[cairo_t]): Unit = extern

  def cairo_rotate(cr : Ptr[cairo_t], angle : Double): Unit = extern

  def cairo_save(cr : Ptr[cairo_t]): Unit = extern

  def cairo_scale(cr : Ptr[cairo_t], sx : Double, sy : Double): Unit = extern

  def cairo_scaled_font_create(font_face : Ptr[cairo_font_face_t], font_matrix : Ptr[cairo_matrix_t], ctm : Ptr[cairo_matrix_t], options : Ptr[cairo_font_options_t]): Ptr[cairo_scaled_font_t] = extern

  def cairo_scaled_font_destroy(scaled_font : Ptr[cairo_scaled_font_t]): Unit = extern

  def cairo_scaled_font_extents(scaled_font : Ptr[cairo_scaled_font_t], extents : Ptr[cairo_font_extents_t]): Unit = extern

  def cairo_scaled_font_get_ctm(scaled_font : Ptr[cairo_scaled_font_t], ctm : Ptr[cairo_matrix_t]): Unit = extern

  def cairo_scaled_font_get_font_face(scaled_font : Ptr[cairo_scaled_font_t]): Ptr[cairo_font_face_t] = extern

  def cairo_scaled_font_get_font_matrix(scaled_font : Ptr[cairo_scaled_font_t], font_matrix : Ptr[cairo_matrix_t]): Unit = extern

  def cairo_scaled_font_get_font_options(scaled_font : Ptr[cairo_scaled_font_t], options : Ptr[cairo_font_options_t]): Unit = extern

  def cairo_scaled_font_get_reference_count(scaled_font : Ptr[cairo_scaled_font_t]): CUnsignedInt = extern

  def cairo_scaled_font_get_scale_matrix(scaled_font : Ptr[cairo_scaled_font_t], scale_matrix : Ptr[cairo_matrix_t]): Unit = extern

  def cairo_scaled_font_get_type(scaled_font : Ptr[cairo_scaled_font_t]): cairo_font_type_t = extern

  def cairo_scaled_font_get_user_data(scaled_font : Ptr[cairo_scaled_font_t], key : Ptr[cairo_user_data_key_t]): Ptr[Byte] = extern

  def cairo_scaled_font_glyph_extents(scaled_font : Ptr[cairo_scaled_font_t], glyphs : Ptr[cairo_glyph_t], num_glyphs : CInt, extents : Ptr[cairo_text_extents_t]): Unit = extern

  def cairo_scaled_font_reference(scaled_font : Ptr[cairo_scaled_font_t]): Ptr[cairo_scaled_font_t] = extern

  def cairo_scaled_font_set_user_data(scaled_font : Ptr[cairo_scaled_font_t], key : Ptr[cairo_user_data_key_t], user_data : Ptr[Byte], destroy : cairo_destroy_func_t): cairo_status_t = extern

  def cairo_scaled_font_status(scaled_font : Ptr[cairo_scaled_font_t]): cairo_status_t = extern

  def cairo_scaled_font_text_extents(scaled_font : Ptr[cairo_scaled_font_t], utf8 : CString, extents : Ptr[cairo_text_extents_t]): Unit = extern

  def cairo_scaled_font_text_to_glyphs(scaled_font : Ptr[cairo_scaled_font_t], x : Double, y : Double, utf8 : CString, utf8_len : CInt, glyphs : Ptr[Ptr[cairo_glyph_t]], num_glyphs : Ptr[CInt], clusters : Ptr[Ptr[cairo_text_cluster_t]], num_clusters : Ptr[CInt], cluster_flags : Ptr[cairo_text_cluster_flags_t]): cairo_status_t = extern

  def cairo_select_font_face(cr : Ptr[cairo_t], family : CString, slant : cairo_font_slant_t, weight : cairo_font_weight_t): Unit = extern

  def cairo_set_antialias(cr : Ptr[cairo_t], antialias : cairo_antialias_t): Unit = extern

  def cairo_set_dash(cr : Ptr[cairo_t], dashes : Ptr[Double], num_dashes : CInt, offset : Double): Unit = extern

  def cairo_set_fill_rule(cr : Ptr[cairo_t], fill_rule : cairo_fill_rule_t): Unit = extern

  def cairo_set_font_face(cr : Ptr[cairo_t], font_face : Ptr[cairo_font_face_t]): Unit = extern

  def cairo_set_font_matrix(cr : Ptr[cairo_t], matrix : Ptr[cairo_matrix_t]): Unit = extern

  def cairo_set_font_options(cr : Ptr[cairo_t], options : Ptr[cairo_font_options_t]): Unit = extern

  def cairo_set_font_size(cr : Ptr[cairo_t], size : Double): Unit = extern

  def cairo_set_hairline(cr : Ptr[cairo_t], set_hairline : cairo_bool_t): Unit = extern

  def cairo_set_line_cap(cr : Ptr[cairo_t], line_cap : cairo_line_cap_t): Unit = extern

  def cairo_set_line_join(cr : Ptr[cairo_t], line_join : cairo_line_join_t): Unit = extern

  def cairo_set_line_width(cr : Ptr[cairo_t], width : Double): Unit = extern

  def cairo_set_matrix(cr : Ptr[cairo_t], matrix : Ptr[cairo_matrix_t]): Unit = extern

  def cairo_set_miter_limit(cr : Ptr[cairo_t], limit : Double): Unit = extern

  def cairo_set_operator(cr : Ptr[cairo_t], op : cairo_operator_t): Unit = extern

  def cairo_set_scaled_font(cr : Ptr[cairo_t], scaled_font : Ptr[cairo_scaled_font_t]): Unit = extern

  def cairo_set_source(cr : Ptr[cairo_t], source : Ptr[cairo_pattern_t]): Unit = extern

  def cairo_set_source_rgb(cr : Ptr[cairo_t], red : Double, green : Double, blue : Double): Unit = extern

  def cairo_set_source_rgba(cr : Ptr[cairo_t], red : Double, green : Double, blue : Double, alpha : Double): Unit = extern

  def cairo_set_source_surface(cr : Ptr[cairo_t], surface : Ptr[cairo_surface_t], x : Double, y : Double): Unit = extern

  def cairo_set_tolerance(cr : Ptr[cairo_t], tolerance : Double): Unit = extern

  def cairo_set_user_data(cr : Ptr[cairo_t], key : Ptr[cairo_user_data_key_t], user_data : Ptr[Byte], destroy : cairo_destroy_func_t): cairo_status_t = extern

  def cairo_show_glyphs(cr : Ptr[cairo_t], glyphs : Ptr[cairo_glyph_t], num_glyphs : CInt): Unit = extern

  def cairo_show_page(cr : Ptr[cairo_t]): Unit = extern

  def cairo_show_text(cr : Ptr[cairo_t], utf8 : CString): Unit = extern

  def cairo_show_text_glyphs(cr : Ptr[cairo_t], utf8 : CString, utf8_len : CInt, glyphs : Ptr[cairo_glyph_t], num_glyphs : CInt, clusters : Ptr[cairo_text_cluster_t], num_clusters : CInt, cluster_flags : cairo_text_cluster_flags_t): Unit = extern

  def cairo_status(cr : Ptr[cairo_t]): cairo_status_t = extern

  def cairo_status_to_string(status : cairo_status_t): CString = extern

  def cairo_stroke(cr : Ptr[cairo_t]): Unit = extern

  def cairo_stroke_extents(cr : Ptr[cairo_t], x1 : Ptr[Double], y1 : Ptr[Double], x2 : Ptr[Double], y2 : Ptr[Double]): Unit = extern

  def cairo_stroke_preserve(cr : Ptr[cairo_t]): Unit = extern

  def cairo_surface_copy_page(surface : Ptr[cairo_surface_t]): Unit = extern

  def cairo_surface_create_for_rectangle(target : Ptr[cairo_surface_t], x : Double, y : Double, width : Double, height : Double): Ptr[cairo_surface_t] = extern

  def cairo_surface_create_observer(target : Ptr[cairo_surface_t], mode : cairo_surface_observer_mode_t): Ptr[cairo_surface_t] = extern

  def cairo_surface_create_similar(other : Ptr[cairo_surface_t], content : cairo_content_t, width : CInt, height : CInt): Ptr[cairo_surface_t] = extern

  def cairo_surface_create_similar_image(other : Ptr[cairo_surface_t], format : cairo_format_t, width : CInt, height : CInt): Ptr[cairo_surface_t] = extern

  def cairo_surface_destroy(surface : Ptr[cairo_surface_t]): Unit = extern

  def cairo_surface_finish(surface : Ptr[cairo_surface_t]): Unit = extern

  def cairo_surface_flush(surface : Ptr[cairo_surface_t]): Unit = extern

  def cairo_surface_get_content(surface : Ptr[cairo_surface_t]): cairo_content_t = extern

  def cairo_surface_get_device(surface : Ptr[cairo_surface_t]): Ptr[cairo_device_t] = extern

  def cairo_surface_get_device_offset(surface : Ptr[cairo_surface_t], x_offset : Ptr[Double], y_offset : Ptr[Double]): Unit = extern

  def cairo_surface_get_device_scale(surface : Ptr[cairo_surface_t], x_scale : Ptr[Double], y_scale : Ptr[Double]): Unit = extern

  def cairo_surface_get_fallback_resolution(surface : Ptr[cairo_surface_t], x_pixels_per_inch : Ptr[Double], y_pixels_per_inch : Ptr[Double]): Unit = extern

  def cairo_surface_get_font_options(surface : Ptr[cairo_surface_t], options : Ptr[cairo_font_options_t]): Unit = extern

  def cairo_surface_get_mime_data(surface : Ptr[cairo_surface_t], mime_type : CString, data : Ptr[Ptr[CUnsignedChar]], length : Ptr[CUnsignedLongInt]): Unit = extern

  def cairo_surface_get_reference_count(surface : Ptr[cairo_surface_t]): CUnsignedInt = extern

  def cairo_surface_get_type(surface : Ptr[cairo_surface_t]): cairo_surface_type_t = extern

  def cairo_surface_get_user_data(surface : Ptr[cairo_surface_t], key : Ptr[cairo_user_data_key_t]): Ptr[Byte] = extern

  def cairo_surface_has_show_text_glyphs(surface : Ptr[cairo_surface_t]): cairo_bool_t = extern

  def cairo_surface_map_to_image(surface : Ptr[cairo_surface_t], extents : Ptr[cairo_rectangle_int_t]): Ptr[cairo_surface_t] = extern

  def cairo_surface_mark_dirty(surface : Ptr[cairo_surface_t]): Unit = extern

  def cairo_surface_mark_dirty_rectangle(surface : Ptr[cairo_surface_t], x : CInt, y : CInt, width : CInt, height : CInt): Unit = extern

  def cairo_surface_observer_add_fill_callback(abstract_surface : Ptr[cairo_surface_t], func : cairo_surface_observer_callback_t, data : Ptr[Byte]): cairo_status_t = extern

  def cairo_surface_observer_add_finish_callback(abstract_surface : Ptr[cairo_surface_t], func : cairo_surface_observer_callback_t, data : Ptr[Byte]): cairo_status_t = extern

  def cairo_surface_observer_add_flush_callback(abstract_surface : Ptr[cairo_surface_t], func : cairo_surface_observer_callback_t, data : Ptr[Byte]): cairo_status_t = extern

  def cairo_surface_observer_add_glyphs_callback(abstract_surface : Ptr[cairo_surface_t], func : cairo_surface_observer_callback_t, data : Ptr[Byte]): cairo_status_t = extern

  def cairo_surface_observer_add_mask_callback(abstract_surface : Ptr[cairo_surface_t], func : cairo_surface_observer_callback_t, data : Ptr[Byte]): cairo_status_t = extern

  def cairo_surface_observer_add_paint_callback(abstract_surface : Ptr[cairo_surface_t], func : cairo_surface_observer_callback_t, data : Ptr[Byte]): cairo_status_t = extern

  def cairo_surface_observer_add_stroke_callback(abstract_surface : Ptr[cairo_surface_t], func : cairo_surface_observer_callback_t, data : Ptr[Byte]): cairo_status_t = extern

  def cairo_surface_observer_elapsed(abstract_surface : Ptr[cairo_surface_t]): Double = extern

  def cairo_surface_observer_print(abstract_surface : Ptr[cairo_surface_t], write_func : cairo_write_func_t, closure : Ptr[Byte]): cairo_status_t = extern

  def cairo_surface_reference(surface : Ptr[cairo_surface_t]): Ptr[cairo_surface_t] = extern

  def cairo_surface_set_device_offset(surface : Ptr[cairo_surface_t], x_offset : Double, y_offset : Double): Unit = extern

  def cairo_surface_set_device_scale(surface : Ptr[cairo_surface_t], x_scale : Double, y_scale : Double): Unit = extern

  def cairo_surface_set_fallback_resolution(surface : Ptr[cairo_surface_t], x_pixels_per_inch : Double, y_pixels_per_inch : Double): Unit = extern

  def cairo_surface_set_mime_data(surface : Ptr[cairo_surface_t], mime_type : CString, data : Ptr[CUnsignedChar], length : CUnsignedLongInt, destroy : cairo_destroy_func_t, closure : Ptr[Byte]): cairo_status_t = extern

  def cairo_surface_set_user_data(surface : Ptr[cairo_surface_t], key : Ptr[cairo_user_data_key_t], user_data : Ptr[Byte], destroy : cairo_destroy_func_t): cairo_status_t = extern

  def cairo_surface_show_page(surface : Ptr[cairo_surface_t]): Unit = extern

  def cairo_surface_status(surface : Ptr[cairo_surface_t]): cairo_status_t = extern

  def cairo_surface_supports_mime_type(surface : Ptr[cairo_surface_t], mime_type : CString): cairo_bool_t = extern

  def cairo_surface_unmap_image(surface : Ptr[cairo_surface_t], image : Ptr[cairo_surface_t]): Unit = extern

  def cairo_surface_write_to_png(surface : Ptr[cairo_surface_t], filename : CString): cairo_status_t = extern

  def cairo_surface_write_to_png_stream(surface : Ptr[cairo_surface_t], write_func : cairo_write_func_t, closure : Ptr[Byte]): cairo_status_t = extern

  def cairo_tag_begin(cr : Ptr[cairo_t], tag_name : CString, attributes : CString): Unit = extern

  def cairo_tag_end(cr : Ptr[cairo_t], tag_name : CString): Unit = extern

  def cairo_text_cluster_allocate(num_clusters : CInt): Ptr[cairo_text_cluster_t] = extern

  def cairo_text_cluster_free(clusters : Ptr[cairo_text_cluster_t]): Unit = extern

  def cairo_text_extents(cr : Ptr[cairo_t], utf8 : CString, extents : Ptr[cairo_text_extents_t]): Unit = extern

  def cairo_text_path(cr : Ptr[cairo_t], utf8 : CString): Unit = extern

  def cairo_toy_font_face_create(family : CString, slant : cairo_font_slant_t, weight : cairo_font_weight_t): Ptr[cairo_font_face_t] = extern

  def cairo_toy_font_face_get_family(font_face : Ptr[cairo_font_face_t]): CString = extern

  def cairo_toy_font_face_get_slant(font_face : Ptr[cairo_font_face_t]): cairo_font_slant_t = extern

  def cairo_toy_font_face_get_weight(font_face : Ptr[cairo_font_face_t]): cairo_font_weight_t = extern

  def cairo_transform(cr : Ptr[cairo_t], matrix : Ptr[cairo_matrix_t]): Unit = extern

  def cairo_translate(cr : Ptr[cairo_t], tx : Double, ty : Double): Unit = extern

  def cairo_user_font_face_create(): Ptr[cairo_font_face_t] = extern

  def cairo_user_font_face_get_init_func(font_face : Ptr[cairo_font_face_t]): cairo_user_scaled_font_init_func_t = extern

  def cairo_user_font_face_get_render_color_glyph_func(font_face : Ptr[cairo_font_face_t]): cairo_user_scaled_font_render_glyph_func_t = extern

  def cairo_user_font_face_get_render_glyph_func(font_face : Ptr[cairo_font_face_t]): cairo_user_scaled_font_render_glyph_func_t = extern

  def cairo_user_font_face_get_text_to_glyphs_func(font_face : Ptr[cairo_font_face_t]): cairo_user_scaled_font_text_to_glyphs_func_t = extern

  def cairo_user_font_face_get_unicode_to_glyph_func(font_face : Ptr[cairo_font_face_t]): cairo_user_scaled_font_unicode_to_glyph_func_t = extern

  def cairo_user_font_face_set_init_func(font_face : Ptr[cairo_font_face_t], init_func : cairo_user_scaled_font_init_func_t): Unit = extern

  def cairo_user_font_face_set_render_color_glyph_func(font_face : Ptr[cairo_font_face_t], render_glyph_func : cairo_user_scaled_font_render_glyph_func_t): Unit = extern

  def cairo_user_font_face_set_render_glyph_func(font_face : Ptr[cairo_font_face_t], render_glyph_func : cairo_user_scaled_font_render_glyph_func_t): Unit = extern

  def cairo_user_font_face_set_text_to_glyphs_func(font_face : Ptr[cairo_font_face_t], text_to_glyphs_func : cairo_user_scaled_font_text_to_glyphs_func_t): Unit = extern

  def cairo_user_font_face_set_unicode_to_glyph_func(font_face : Ptr[cairo_font_face_t], unicode_to_glyph_func : cairo_user_scaled_font_unicode_to_glyph_func_t): Unit = extern

  def cairo_user_scaled_font_get_foreground_marker(scaled_font : Ptr[cairo_scaled_font_t]): Ptr[cairo_pattern_t] = extern

  def cairo_user_scaled_font_get_foreground_source(scaled_font : Ptr[cairo_scaled_font_t]): Ptr[cairo_pattern_t] = extern

  def cairo_user_to_device(cr : Ptr[cairo_t], x : Ptr[Double], y : Ptr[Double]): Unit = extern

  def cairo_user_to_device_distance(cr : Ptr[cairo_t], dx : Ptr[Double], dy : Ptr[Double]): Unit = extern

  def cairo_version(): CInt = extern

  def cairo_version_string(): CString = extern

  def stat(_0 : CString, _1 : Ptr[stat]): CInt = extern


object functions:
  import _root_.cairo.enumerations.*
  import _root_.cairo.predef.*
  import _root_.cairo.aliases.*
  import _root_.cairo.structs.*
  import _root_.cairo.unions.*
  import extern_functions.*
  export extern_functions.*

  def FcPatternAdd(p : Ptr[FcPattern], `object` : CString, value : Ptr[FcValue], append : FcBool): FcBool = 
    __sn_wrap_cairo_FcPatternAdd(p, `object`, value, append)

  def FcPatternAdd(p : Ptr[FcPattern], `object` : CString, value : FcValue, append : FcBool)(using Zone): FcBool = 
    val __ptr_0: Ptr[FcValue] = alloc[FcValue](1)
    !(__ptr_0 + 0) = value
    __sn_wrap_cairo_FcPatternAdd(p, `object`, (__ptr_0 + 0), append)

  def FcPatternAddWeak(p : Ptr[FcPattern], `object` : CString, value : Ptr[FcValue], append : FcBool): FcBool = 
    __sn_wrap_cairo_FcPatternAddWeak(p, `object`, value, append)

  def FcPatternAddWeak(p : Ptr[FcPattern], `object` : CString, value : FcValue, append : FcBool)(using Zone): FcBool = 
    val __ptr_0: Ptr[FcValue] = alloc[FcValue](1)
    !(__ptr_0 + 0) = value
    __sn_wrap_cairo_FcPatternAddWeak(p, `object`, (__ptr_0 + 0), append)

  def FcValueDestroy(v : FcValue)(using Zone): Unit = 
    val __ptr_0: Ptr[FcValue] = alloc[FcValue](1)
    !(__ptr_0 + 0) = v
    __sn_wrap_cairo_FcValueDestroy((__ptr_0 + 0))

  def FcValueDestroy(v : Ptr[FcValue]): Unit = 
    __sn_wrap_cairo_FcValueDestroy(v)

  def FcValueEqual(va : FcValue, vb : FcValue)(using Zone): FcBool = 
    val __ptr_0: Ptr[FcValue] = alloc[FcValue](2)
    !(__ptr_0 + 0) = va
    !(__ptr_0 + 1) = vb
    __sn_wrap_cairo_FcValueEqual((__ptr_0 + 0), (__ptr_0 + 1))

  def FcValueEqual(va : Ptr[FcValue], vb : Ptr[FcValue]): FcBool = 
    __sn_wrap_cairo_FcValueEqual(va, vb)

  def FcValuePrint(v : FcValue)(using Zone): Unit = 
    val __ptr_0: Ptr[FcValue] = alloc[FcValue](1)
    !(__ptr_0 + 0) = v
    __sn_wrap_cairo_FcValuePrint((__ptr_0 + 0))

  def FcValuePrint(v : Ptr[FcValue]): Unit = 
    __sn_wrap_cairo_FcValuePrint(v)

  def FcValueSave(v : FcValue)(using Zone): FcValue = 
    val __ptr_0: Ptr[FcValue] = alloc[FcValue](2)
    !(__ptr_0 + 0) = v
    __sn_wrap_cairo_FcValueSave((__ptr_0 + 0), (__ptr_0 + 1))
    !(__ptr_0 + 1)

  def FcValueSave(v : Ptr[FcValue])(using Zone): FcValue = 
    val __ptr_0: Ptr[FcValue] = alloc[FcValue](1)
    __sn_wrap_cairo_FcValueSave(v, (__ptr_0 + 0))
    !(__ptr_0 + 0)

  def FcValueSave(v : Ptr[FcValue])(__return : Ptr[FcValue]): Unit = 
    __sn_wrap_cairo_FcValueSave(v, __return)

object constants:
  val FT_Mod_Err_Base: CUnsignedInt = 0.toUInt
  val FT_Mod_Err_Autofit: CUnsignedInt = 0.toUInt
  val FT_Mod_Err_BDF: CUnsignedInt = 0.toUInt
  val FT_Mod_Err_Bzip2: CUnsignedInt = 0.toUInt
  val FT_Mod_Err_Cache: CUnsignedInt = 0.toUInt
  val FT_Mod_Err_CFF: CUnsignedInt = 0.toUInt
  val FT_Mod_Err_CID: CUnsignedInt = 0.toUInt
  val FT_Mod_Err_Gzip: CUnsignedInt = 0.toUInt
  val FT_Mod_Err_LZW: CUnsignedInt = 0.toUInt
  val FT_Mod_Err_OTvalid: CUnsignedInt = 0.toUInt
  val FT_Mod_Err_PCF: CUnsignedInt = 0.toUInt
  val FT_Mod_Err_PFR: CUnsignedInt = 0.toUInt
  val FT_Mod_Err_PSaux: CUnsignedInt = 0.toUInt
  val FT_Mod_Err_PShinter: CUnsignedInt = 0.toUInt
  val FT_Mod_Err_PSnames: CUnsignedInt = 0.toUInt
  val FT_Mod_Err_Raster: CUnsignedInt = 0.toUInt
  val FT_Mod_Err_SFNT: CUnsignedInt = 0.toUInt
  val FT_Mod_Err_Smooth: CUnsignedInt = 0.toUInt
  val FT_Mod_Err_TrueType: CUnsignedInt = 0.toUInt
  val FT_Mod_Err_Type1: CUnsignedInt = 0.toUInt
  val FT_Mod_Err_Type42: CUnsignedInt = 0.toUInt
  val FT_Mod_Err_Winfonts: CUnsignedInt = 0.toUInt
  val FT_Mod_Err_GXvalid: CUnsignedInt = 0.toUInt
  val FT_Mod_Err_Sdf: CUnsignedInt = 0.toUInt
  val FT_Mod_Err_Max: CUnsignedInt = 1.toUInt
  
  val FT_Err_Ok: CUnsignedInt = 0.toUInt
  val FT_Err_Cannot_Open_Resource: CUnsignedInt = 1.toUInt
  val FT_Err_Unknown_File_Format: CUnsignedInt = 2.toUInt
  val FT_Err_Invalid_File_Format: CUnsignedInt = 3.toUInt
  val FT_Err_Invalid_Version: CUnsignedInt = 4.toUInt
  val FT_Err_Lower_Module_Version: CUnsignedInt = 5.toUInt
  val FT_Err_Invalid_Argument: CUnsignedInt = 6.toUInt
  val FT_Err_Unimplemented_Feature: CUnsignedInt = 7.toUInt
  val FT_Err_Invalid_Table: CUnsignedInt = 8.toUInt
  val FT_Err_Invalid_Offset: CUnsignedInt = 9.toUInt
  val FT_Err_Array_Too_Large: CUnsignedInt = 10.toUInt
  val FT_Err_Missing_Module: CUnsignedInt = 11.toUInt
  val FT_Err_Missing_Property: CUnsignedInt = 12.toUInt
  val FT_Err_Invalid_Glyph_Index: CUnsignedInt = 16.toUInt
  val FT_Err_Invalid_Character_Code: CUnsignedInt = 17.toUInt
  val FT_Err_Invalid_Glyph_Format: CUnsignedInt = 18.toUInt
  val FT_Err_Cannot_Render_Glyph: CUnsignedInt = 19.toUInt
  val FT_Err_Invalid_Outline: CUnsignedInt = 20.toUInt
  val FT_Err_Invalid_Composite: CUnsignedInt = 21.toUInt
  val FT_Err_Too_Many_Hints: CUnsignedInt = 22.toUInt
  val FT_Err_Invalid_Pixel_Size: CUnsignedInt = 23.toUInt
  val FT_Err_Invalid_SVG_Document: CUnsignedInt = 24.toUInt
  val FT_Err_Invalid_Handle: CUnsignedInt = 32.toUInt
  val FT_Err_Invalid_Library_Handle: CUnsignedInt = 33.toUInt
  val FT_Err_Invalid_Driver_Handle: CUnsignedInt = 34.toUInt
  val FT_Err_Invalid_Face_Handle: CUnsignedInt = 35.toUInt
  val FT_Err_Invalid_Size_Handle: CUnsignedInt = 36.toUInt
  val FT_Err_Invalid_Slot_Handle: CUnsignedInt = 37.toUInt
  val FT_Err_Invalid_CharMap_Handle: CUnsignedInt = 38.toUInt
  val FT_Err_Invalid_Cache_Handle: CUnsignedInt = 39.toUInt
  val FT_Err_Invalid_Stream_Handle: CUnsignedInt = 40.toUInt
  val FT_Err_Too_Many_Drivers: CUnsignedInt = 48.toUInt
  val FT_Err_Too_Many_Extensions: CUnsignedInt = 49.toUInt
  val FT_Err_Out_Of_Memory: CUnsignedInt = 64.toUInt
  val FT_Err_Unlisted_Object: CUnsignedInt = 65.toUInt
  val FT_Err_Cannot_Open_Stream: CUnsignedInt = 81.toUInt
  val FT_Err_Invalid_Stream_Seek: CUnsignedInt = 82.toUInt
  val FT_Err_Invalid_Stream_Skip: CUnsignedInt = 83.toUInt
  val FT_Err_Invalid_Stream_Read: CUnsignedInt = 84.toUInt
  val FT_Err_Invalid_Stream_Operation: CUnsignedInt = 85.toUInt
  val FT_Err_Invalid_Frame_Operation: CUnsignedInt = 86.toUInt
  val FT_Err_Nested_Frame_Access: CUnsignedInt = 87.toUInt
  val FT_Err_Invalid_Frame_Read: CUnsignedInt = 88.toUInt
  val FT_Err_Raster_Uninitialized: CUnsignedInt = 96.toUInt
  val FT_Err_Raster_Corrupted: CUnsignedInt = 97.toUInt
  val FT_Err_Raster_Overflow: CUnsignedInt = 98.toUInt
  val FT_Err_Raster_Negative_Height: CUnsignedInt = 99.toUInt
  val FT_Err_Too_Many_Caches: CUnsignedInt = 112.toUInt
  val FT_Err_Invalid_Opcode: CUnsignedInt = 128.toUInt
  val FT_Err_Too_Few_Arguments: CUnsignedInt = 129.toUInt
  val FT_Err_Stack_Overflow: CUnsignedInt = 130.toUInt
  val FT_Err_Code_Overflow: CUnsignedInt = 131.toUInt
  val FT_Err_Bad_Argument: CUnsignedInt = 132.toUInt
  val FT_Err_Divide_By_Zero: CUnsignedInt = 133.toUInt
  val FT_Err_Invalid_Reference: CUnsignedInt = 134.toUInt
  val FT_Err_Debug_OpCode: CUnsignedInt = 135.toUInt
  val FT_Err_ENDF_In_Exec_Stream: CUnsignedInt = 136.toUInt
  val FT_Err_Nested_DEFS: CUnsignedInt = 137.toUInt
  val FT_Err_Invalid_CodeRange: CUnsignedInt = 138.toUInt
  val FT_Err_Execution_Too_Long: CUnsignedInt = 139.toUInt
  val FT_Err_Too_Many_Function_Defs: CUnsignedInt = 140.toUInt
  val FT_Err_Too_Many_Instruction_Defs: CUnsignedInt = 141.toUInt
  val FT_Err_Table_Missing: CUnsignedInt = 142.toUInt
  val FT_Err_Horiz_Header_Missing: CUnsignedInt = 143.toUInt
  val FT_Err_Locations_Missing: CUnsignedInt = 144.toUInt
  val FT_Err_Name_Table_Missing: CUnsignedInt = 145.toUInt
  val FT_Err_CMap_Table_Missing: CUnsignedInt = 146.toUInt
  val FT_Err_Hmtx_Table_Missing: CUnsignedInt = 147.toUInt
  val FT_Err_Post_Table_Missing: CUnsignedInt = 148.toUInt
  val FT_Err_Invalid_Horiz_Metrics: CUnsignedInt = 149.toUInt
  val FT_Err_Invalid_CharMap_Format: CUnsignedInt = 150.toUInt
  val FT_Err_Invalid_PPem: CUnsignedInt = 151.toUInt
  val FT_Err_Invalid_Vert_Metrics: CUnsignedInt = 152.toUInt
  val FT_Err_Could_Not_Find_Context: CUnsignedInt = 153.toUInt
  val FT_Err_Invalid_Post_Table_Format: CUnsignedInt = 154.toUInt
  val FT_Err_Invalid_Post_Table: CUnsignedInt = 155.toUInt
  val FT_Err_DEF_In_Glyf_Bytecode: CUnsignedInt = 156.toUInt
  val FT_Err_Missing_Bitmap: CUnsignedInt = 157.toUInt
  val FT_Err_Missing_SVG_Hooks: CUnsignedInt = 158.toUInt
  val FT_Err_Syntax_Error: CUnsignedInt = 160.toUInt
  val FT_Err_Stack_Underflow: CUnsignedInt = 161.toUInt
  val FT_Err_Ignore: CUnsignedInt = 162.toUInt
  val FT_Err_No_Unicode_Glyph_Name: CUnsignedInt = 163.toUInt
  val FT_Err_Glyph_Too_Big: CUnsignedInt = 164.toUInt
  val FT_Err_Missing_Startfont_Field: CUnsignedInt = 176.toUInt
  val FT_Err_Missing_Font_Field: CUnsignedInt = 177.toUInt
  val FT_Err_Missing_Size_Field: CUnsignedInt = 178.toUInt
  val FT_Err_Missing_Fontboundingbox_Field: CUnsignedInt = 179.toUInt
  val FT_Err_Missing_Chars_Field: CUnsignedInt = 180.toUInt
  val FT_Err_Missing_Startchar_Field: CUnsignedInt = 181.toUInt
  val FT_Err_Missing_Encoding_Field: CUnsignedInt = 182.toUInt
  val FT_Err_Missing_Bbx_Field: CUnsignedInt = 183.toUInt
  val FT_Err_Bbx_Too_Big: CUnsignedInt = 184.toUInt
  val FT_Err_Corrupted_Font_Header: CUnsignedInt = 185.toUInt
  val FT_Err_Corrupted_Font_Glyphs: CUnsignedInt = 186.toUInt
  val FT_Err_Max: CUnsignedInt = 187.toUInt
  
object types:
  export _root_.cairo.structs.*
  export _root_.cairo.aliases.*
  export _root_.cairo.unions.*
  export _root_.cairo.enumerations.*

object all:
  export _root_.cairo.enumerations.FT_Encoding_
  export _root_.cairo.enumerations.FT_Glyph_Format_
  export _root_.cairo.enumerations.FT_Kerning_Mode_
  export _root_.cairo.enumerations.FT_Pixel_Mode_
  export _root_.cairo.enumerations.FT_Render_Mode_
  export _root_.cairo.enumerations.FT_Size_Request_Type_
  export _root_.cairo.enumerations.FcEndian
  export _root_.cairo.enumerations._FcLangResult
  export _root_.cairo.enumerations._FcMatchKind
  export _root_.cairo.enumerations._FcResult
  export _root_.cairo.enumerations._FcSetName
  export _root_.cairo.enumerations._FcType
  export _root_.cairo.enumerations._FcValueBinding
  export _root_.cairo.enumerations._cairo_antialias
  export _root_.cairo.enumerations._cairo_color_mode
  export _root_.cairo.enumerations._cairo_content
  export _root_.cairo.enumerations._cairo_device_type
  export _root_.cairo.enumerations._cairo_dither
  export _root_.cairo.enumerations._cairo_extend
  export _root_.cairo.enumerations._cairo_fill_rule
  export _root_.cairo.enumerations._cairo_filter
  export _root_.cairo.enumerations._cairo_font_slant
  export _root_.cairo.enumerations._cairo_font_type
  export _root_.cairo.enumerations._cairo_font_weight
  export _root_.cairo.enumerations._cairo_format
  export _root_.cairo.enumerations._cairo_hint_metrics
  export _root_.cairo.enumerations._cairo_hint_style
  export _root_.cairo.enumerations._cairo_line_cap
  export _root_.cairo.enumerations._cairo_line_join
  export _root_.cairo.enumerations._cairo_operator
  export _root_.cairo.enumerations._cairo_path_data_type
  export _root_.cairo.enumerations._cairo_pattern_type
  export _root_.cairo.enumerations._cairo_region_overlap
  export _root_.cairo.enumerations._cairo_status
  export _root_.cairo.enumerations._cairo_subpixel_order
  export _root_.cairo.enumerations._cairo_surface_type
  export _root_.cairo.enumerations._cairo_text_cluster_flags
  export _root_.cairo.enumerations.cairo_ft_synthesize_t
  export _root_.cairo.enumerations.cairo_surface_observer_mode_t
  export _root_.cairo.aliases.FT_Alloc_Func
  export _root_.cairo.aliases.FT_Bool
  export _root_.cairo.aliases.FT_Byte
  export _root_.cairo.aliases.FT_Bytes
  export _root_.cairo.aliases.FT_Char
  export _root_.cairo.aliases.FT_CharMap
  export _root_.cairo.aliases.FT_Driver
  export _root_.cairo.aliases.FT_Encoding
  export _root_.cairo.aliases.FT_Error
  export _root_.cairo.aliases.FT_F26Dot6
  export _root_.cairo.aliases.FT_F2Dot14
  export _root_.cairo.aliases.FT_FWord
  export _root_.cairo.aliases.FT_Face
  export _root_.cairo.aliases.FT_Face_Internal
  export _root_.cairo.aliases.FT_Fast
  export _root_.cairo.aliases.FT_Fixed
  export _root_.cairo.aliases.FT_Free_Func
  export _root_.cairo.aliases.FT_Generic_Finalizer
  export _root_.cairo.aliases.FT_GlyphSlot
  export _root_.cairo.aliases.FT_Glyph_Format
  export _root_.cairo.aliases.FT_Int
  export _root_.cairo.aliases.FT_Int16
  export _root_.cairo.aliases.FT_Int32
  export _root_.cairo.aliases.FT_Int64
  export _root_.cairo.aliases.FT_Kerning_Mode
  export _root_.cairo.aliases.FT_Library
  export _root_.cairo.aliases.FT_List
  export _root_.cairo.aliases.FT_ListNode
  export _root_.cairo.aliases.FT_Long
  export _root_.cairo.aliases.FT_Memory
  export _root_.cairo.aliases.FT_Module
  export _root_.cairo.aliases.FT_Offset
  export _root_.cairo.aliases.FT_Outline_ConicToFunc
  export _root_.cairo.aliases.FT_Outline_CubicToFunc
  export _root_.cairo.aliases.FT_Outline_LineToFunc
  export _root_.cairo.aliases.FT_Outline_MoveToFunc
  export _root_.cairo.aliases.FT_Pixel_Mode
  export _root_.cairo.aliases.FT_Pointer
  export _root_.cairo.aliases.FT_Pos
  export _root_.cairo.aliases.FT_PtrDist
  export _root_.cairo.aliases.FT_Raster
  export _root_.cairo.aliases.FT_Raster_BitSet_Func
  export _root_.cairo.aliases.FT_Raster_BitTest_Func
  export _root_.cairo.aliases.FT_Raster_DoneFunc
  export _root_.cairo.aliases.FT_Raster_NewFunc
  export _root_.cairo.aliases.FT_Raster_RenderFunc
  export _root_.cairo.aliases.FT_Raster_ResetFunc
  export _root_.cairo.aliases.FT_Raster_SetModeFunc
  export _root_.cairo.aliases.FT_Realloc_Func
  export _root_.cairo.aliases.FT_Render_Mode
  export _root_.cairo.aliases.FT_Renderer
  export _root_.cairo.aliases.FT_Short
  export _root_.cairo.aliases.FT_Size
  export _root_.cairo.aliases.FT_Size_Internal
  export _root_.cairo.aliases.FT_Size_Request
  export _root_.cairo.aliases.FT_Size_Request_Type
  export _root_.cairo.aliases.FT_Slot_Internal
  export _root_.cairo.aliases.FT_SpanFunc
  export _root_.cairo.aliases.FT_Stream
  export _root_.cairo.aliases.FT_Stream_CloseFunc
  export _root_.cairo.aliases.FT_Stream_IoFunc
  export _root_.cairo.aliases.FT_String
  export _root_.cairo.aliases.FT_SubGlyph
  export _root_.cairo.aliases.FT_Tag
  export _root_.cairo.aliases.FT_UFWord
  export _root_.cairo.aliases.FT_UFast
  export _root_.cairo.aliases.FT_UInt
  export _root_.cairo.aliases.FT_UInt16
  export _root_.cairo.aliases.FT_UInt32
  export _root_.cairo.aliases.FT_UInt64
  export _root_.cairo.aliases.FT_ULong
  export _root_.cairo.aliases.FT_UShort
  export _root_.cairo.aliases.FcBool
  export _root_.cairo.aliases.FcChar16
  export _root_.cairo.aliases.FcChar32
  export _root_.cairo.aliases.FcChar8
  export _root_.cairo.aliases.FcLangResult
  export _root_.cairo.aliases.FcMatchKind
  export _root_.cairo.aliases.FcResult
  export _root_.cairo.aliases.FcSetName
  export _root_.cairo.aliases.FcType
  export _root_.cairo.aliases.FcValueBinding
  export _root_.cairo.aliases.cairo_antialias_t
  export _root_.cairo.aliases.cairo_bool_t
  export _root_.cairo.aliases.cairo_color_mode_t
  export _root_.cairo.aliases.cairo_content_t
  export _root_.cairo.aliases.cairo_destroy_func_t
  export _root_.cairo.aliases.cairo_device_type_t
  export _root_.cairo.aliases.cairo_dither_t
  export _root_.cairo.aliases.cairo_extend_t
  export _root_.cairo.aliases.cairo_fill_rule_t
  export _root_.cairo.aliases.cairo_filter_t
  export _root_.cairo.aliases.cairo_font_slant_t
  export _root_.cairo.aliases.cairo_font_type_t
  export _root_.cairo.aliases.cairo_font_weight_t
  export _root_.cairo.aliases.cairo_format_t
  export _root_.cairo.aliases.cairo_hint_metrics_t
  export _root_.cairo.aliases.cairo_hint_style_t
  export _root_.cairo.aliases.cairo_line_cap_t
  export _root_.cairo.aliases.cairo_line_join_t
  export _root_.cairo.aliases.cairo_operator_t
  export _root_.cairo.aliases.cairo_path_data_type_t
  export _root_.cairo.aliases.cairo_pattern_type_t
  export _root_.cairo.aliases.cairo_raster_source_acquire_func_t
  export _root_.cairo.aliases.cairo_raster_source_copy_func_t
  export _root_.cairo.aliases.cairo_raster_source_finish_func_t
  export _root_.cairo.aliases.cairo_raster_source_release_func_t
  export _root_.cairo.aliases.cairo_raster_source_snapshot_func_t
  export _root_.cairo.aliases.cairo_read_func_t
  export _root_.cairo.aliases.cairo_region_overlap_t
  export _root_.cairo.aliases.cairo_status_t
  export _root_.cairo.aliases.cairo_subpixel_order_t
  export _root_.cairo.aliases.cairo_surface_observer_callback_t
  export _root_.cairo.aliases.cairo_surface_type_t
  export _root_.cairo.aliases.cairo_text_cluster_flags_t
  export _root_.cairo.aliases.cairo_user_scaled_font_init_func_t
  export _root_.cairo.aliases.cairo_user_scaled_font_render_glyph_func_t
  export _root_.cairo.aliases.cairo_user_scaled_font_text_to_glyphs_func_t
  export _root_.cairo.aliases.cairo_user_scaled_font_unicode_to_glyph_func_t
  export _root_.cairo.aliases.cairo_write_func_t
  export _root_.cairo.aliases.ptrdiff_t
  export _root_.cairo.aliases.size_t
  export _root_.cairo.aliases.stat
  export _root_.cairo.aliases.va_list
  export _root_.cairo.structs.FT_BBox
  export _root_.cairo.structs.FT_BBox_
  export _root_.cairo.structs.FT_Bitmap
  export _root_.cairo.structs.FT_Bitmap_
  export _root_.cairo.structs.FT_Bitmap_Size
  export _root_.cairo.structs.FT_Bitmap_Size_
  export _root_.cairo.structs.FT_CharMapRec
  export _root_.cairo.structs.FT_CharMapRec_
  export _root_.cairo.structs.FT_Data
  export _root_.cairo.structs.FT_Data_
  export _root_.cairo.structs.FT_DriverRec_
  export _root_.cairo.structs.FT_FaceRec
  export _root_.cairo.structs.FT_FaceRec_
  export _root_.cairo.structs.FT_Face_InternalRec_
  export _root_.cairo.structs.FT_Generic
  export _root_.cairo.structs.FT_Generic_
  export _root_.cairo.structs.FT_GlyphSlotRec
  export _root_.cairo.structs.FT_GlyphSlotRec_
  export _root_.cairo.structs.FT_Glyph_Metrics
  export _root_.cairo.structs.FT_Glyph_Metrics_
  export _root_.cairo.structs.FT_LibraryRec_
  export _root_.cairo.structs.FT_ListNodeRec
  export _root_.cairo.structs.FT_ListNodeRec_
  export _root_.cairo.structs.FT_ListRec
  export _root_.cairo.structs.FT_ListRec_
  export _root_.cairo.structs.FT_Matrix
  export _root_.cairo.structs.FT_Matrix_
  export _root_.cairo.structs.FT_MemoryRec_
  export _root_.cairo.structs.FT_ModuleRec_
  export _root_.cairo.structs.FT_Open_Args
  export _root_.cairo.structs.FT_Open_Args_
  export _root_.cairo.structs.FT_Outline
  export _root_.cairo.structs.FT_Outline_
  export _root_.cairo.structs.FT_Outline_Funcs
  export _root_.cairo.structs.FT_Outline_Funcs_
  export _root_.cairo.structs.FT_Parameter
  export _root_.cairo.structs.FT_Parameter_
  export _root_.cairo.structs.FT_RasterRec_
  export _root_.cairo.structs.FT_Raster_Funcs
  export _root_.cairo.structs.FT_Raster_Funcs_
  export _root_.cairo.structs.FT_Raster_Params
  export _root_.cairo.structs.FT_Raster_Params_
  export _root_.cairo.structs.FT_RendererRec_
  export _root_.cairo.structs.FT_SizeRec
  export _root_.cairo.structs.FT_SizeRec_
  export _root_.cairo.structs.FT_Size_InternalRec_
  export _root_.cairo.structs.FT_Size_Metrics
  export _root_.cairo.structs.FT_Size_Metrics_
  export _root_.cairo.structs.FT_Size_RequestRec
  export _root_.cairo.structs.FT_Size_RequestRec_
  export _root_.cairo.structs.FT_Slot_InternalRec_
  export _root_.cairo.structs.FT_Span
  export _root_.cairo.structs.FT_Span_
  export _root_.cairo.structs.FT_StreamRec
  export _root_.cairo.structs.FT_StreamRec_
  export _root_.cairo.structs.FT_SubGlyphRec_
  export _root_.cairo.structs.FT_UnitVector
  export _root_.cairo.structs.FT_UnitVector_
  export _root_.cairo.structs.FT_Vector
  export _root_.cairo.structs.FT_Vector_
  export _root_.cairo.structs.FcAtomic
  export _root_.cairo.structs.FcBlanks
  export _root_.cairo.structs.FcCache
  export _root_.cairo.structs.FcCharSet
  export _root_.cairo.structs.FcConfig
  export _root_.cairo.structs.FcConfigFileInfoIter
  export _root_.cairo.structs.FcConstant
  export _root_.cairo.structs.FcFileCache
  export _root_.cairo.structs.FcFontSet
  export _root_.cairo.structs.FcLangSet
  export _root_.cairo.structs.FcMatrix
  export _root_.cairo.structs.FcObjectSet
  export _root_.cairo.structs.FcObjectType
  export _root_.cairo.structs.FcPattern
  export _root_.cairo.structs.FcPatternIter
  export _root_.cairo.structs.FcRange
  export _root_.cairo.structs.FcStrList
  export _root_.cairo.structs.FcStrSet
  export _root_.cairo.structs.FcValue
  export _root_.cairo.structs._FcAtomic
  export _root_.cairo.structs._FcBlanks
  export _root_.cairo.structs._FcCache
  export _root_.cairo.structs._FcCharSet
  export _root_.cairo.structs._FcConfig
  export _root_.cairo.structs._FcConfigFileInfoIter
  export _root_.cairo.structs._FcConstant
  export _root_.cairo.structs._FcFontSet
  export _root_.cairo.structs._FcGlobalCache
  export _root_.cairo.structs._FcLangSet
  export _root_.cairo.structs._FcMatrix
  export _root_.cairo.structs._FcObjectSet
  export _root_.cairo.structs._FcObjectType
  export _root_.cairo.structs._FcPattern
  export _root_.cairo.structs._FcPatternIter
  export _root_.cairo.structs._FcRange
  export _root_.cairo.structs._FcStrList
  export _root_.cairo.structs._FcStrSet
  export _root_.cairo.structs._FcValue
  export _root_.cairo.structs._cairo
  export _root_.cairo.structs._cairo_device
  export _root_.cairo.structs._cairo_font_face
  export _root_.cairo.structs._cairo_font_options
  export _root_.cairo.structs._cairo_matrix
  export _root_.cairo.structs._cairo_pattern
  export _root_.cairo.structs._cairo_rectangle
  export _root_.cairo.structs._cairo_rectangle_int
  export _root_.cairo.structs._cairo_rectangle_list
  export _root_.cairo.structs._cairo_region
  export _root_.cairo.structs._cairo_scaled_font
  export _root_.cairo.structs._cairo_surface
  export _root_.cairo.structs._cairo_user_data_key
  export _root_.cairo.structs.cairo_device_t
  export _root_.cairo.structs.cairo_font_extents_t
  export _root_.cairo.structs.cairo_font_face_t
  export _root_.cairo.structs.cairo_font_options_t
  export _root_.cairo.structs.cairo_glyph_t
  export _root_.cairo.structs.cairo_matrix_t
  export _root_.cairo.structs.cairo_path
  export _root_.cairo.structs.cairo_path_t
  export _root_.cairo.structs.cairo_pattern_t
  export _root_.cairo.structs.cairo_rectangle_int_t
  export _root_.cairo.structs.cairo_rectangle_list_t
  export _root_.cairo.structs.cairo_rectangle_t
  export _root_.cairo.structs.cairo_region_t
  export _root_.cairo.structs.cairo_scaled_font_t
  export _root_.cairo.structs.cairo_surface_t
  export _root_.cairo.structs.cairo_t
  export _root_.cairo.structs.cairo_text_cluster_t
  export _root_.cairo.structs.cairo_text_extents_t
  export _root_.cairo.structs.cairo_user_data_key_t
  export _root_.cairo.unions.FT_StreamDesc
  export _root_.cairo.unions.FT_StreamDesc_
  export _root_.cairo.unions._cairo_path_data_t
  export _root_.cairo.unions.cairo_path_data_t
  export _root_.cairo.functions.FT_Attach_File
  export _root_.cairo.functions.FT_Attach_Stream
  export _root_.cairo.functions.FT_CeilFix
  export _root_.cairo.functions.FT_DivFix
  export _root_.cairo.functions.FT_Done_Face
  export _root_.cairo.functions.FT_Done_FreeType
  export _root_.cairo.functions.FT_Error_String
  export _root_.cairo.functions.FT_Face_CheckTrueTypePatents
  export _root_.cairo.functions.FT_Face_GetCharVariantIndex
  export _root_.cairo.functions.FT_Face_GetCharVariantIsDefault
  export _root_.cairo.functions.FT_Face_GetCharsOfVariant
  export _root_.cairo.functions.FT_Face_GetVariantSelectors
  export _root_.cairo.functions.FT_Face_GetVariantsOfChar
  export _root_.cairo.functions.FT_Face_Properties
  export _root_.cairo.functions.FT_Face_SetUnpatentedHinting
  export _root_.cairo.functions.FT_FloorFix
  export _root_.cairo.functions.FT_Get_Char_Index
  export _root_.cairo.functions.FT_Get_Charmap_Index
  export _root_.cairo.functions.FT_Get_FSType_Flags
  export _root_.cairo.functions.FT_Get_First_Char
  export _root_.cairo.functions.FT_Get_Glyph_Name
  export _root_.cairo.functions.FT_Get_Kerning
  export _root_.cairo.functions.FT_Get_Name_Index
  export _root_.cairo.functions.FT_Get_Next_Char
  export _root_.cairo.functions.FT_Get_Postscript_Name
  export _root_.cairo.functions.FT_Get_SubGlyph_Info
  export _root_.cairo.functions.FT_Get_Track_Kerning
  export _root_.cairo.functions.FT_Get_Transform
  export _root_.cairo.functions.FT_Init_FreeType
  export _root_.cairo.functions.FT_Library_Version
  export _root_.cairo.functions.FT_Load_Char
  export _root_.cairo.functions.FT_Load_Glyph
  export _root_.cairo.functions.FT_MulDiv
  export _root_.cairo.functions.FT_MulFix
  export _root_.cairo.functions.FT_New_Face
  export _root_.cairo.functions.FT_New_Memory_Face
  export _root_.cairo.functions.FT_Open_Face
  export _root_.cairo.functions.FT_Reference_Face
  export _root_.cairo.functions.FT_Render_Glyph
  export _root_.cairo.functions.FT_Request_Size
  export _root_.cairo.functions.FT_RoundFix
  export _root_.cairo.functions.FT_Select_Charmap
  export _root_.cairo.functions.FT_Select_Size
  export _root_.cairo.functions.FT_Set_Char_Size
  export _root_.cairo.functions.FT_Set_Charmap
  export _root_.cairo.functions.FT_Set_Pixel_Sizes
  export _root_.cairo.functions.FT_Set_Transform
  export _root_.cairo.functions.FT_Vector_Transform
  export _root_.cairo.functions.FcAtomicCreate
  export _root_.cairo.functions.FcAtomicDeleteNew
  export _root_.cairo.functions.FcAtomicDestroy
  export _root_.cairo.functions.FcAtomicLock
  export _root_.cairo.functions.FcAtomicNewFile
  export _root_.cairo.functions.FcAtomicOrigFile
  export _root_.cairo.functions.FcAtomicReplaceOrig
  export _root_.cairo.functions.FcAtomicUnlock
  export _root_.cairo.functions.FcBlanksAdd
  export _root_.cairo.functions.FcBlanksCreate
  export _root_.cairo.functions.FcBlanksDestroy
  export _root_.cairo.functions.FcBlanksIsMember
  export _root_.cairo.functions.FcCacheCopySet
  export _root_.cairo.functions.FcCacheCreateTagFile
  export _root_.cairo.functions.FcCacheDir
  export _root_.cairo.functions.FcCacheNumFont
  export _root_.cairo.functions.FcCacheNumSubdir
  export _root_.cairo.functions.FcCacheSubdir
  export _root_.cairo.functions.FcCharSetAddChar
  export _root_.cairo.functions.FcCharSetCopy
  export _root_.cairo.functions.FcCharSetCount
  export _root_.cairo.functions.FcCharSetCoverage
  export _root_.cairo.functions.FcCharSetCreate
  export _root_.cairo.functions.FcCharSetDelChar
  export _root_.cairo.functions.FcCharSetDestroy
  export _root_.cairo.functions.FcCharSetEqual
  export _root_.cairo.functions.FcCharSetFirstPage
  export _root_.cairo.functions.FcCharSetHasChar
  export _root_.cairo.functions.FcCharSetIntersect
  export _root_.cairo.functions.FcCharSetIntersectCount
  export _root_.cairo.functions.FcCharSetIsSubset
  export _root_.cairo.functions.FcCharSetMerge
  export _root_.cairo.functions.FcCharSetNew
  export _root_.cairo.functions.FcCharSetNextPage
  export _root_.cairo.functions.FcCharSetSubtract
  export _root_.cairo.functions.FcCharSetSubtractCount
  export _root_.cairo.functions.FcCharSetUnion
  export _root_.cairo.functions.FcConfigAppFontAddDir
  export _root_.cairo.functions.FcConfigAppFontAddFile
  export _root_.cairo.functions.FcConfigAppFontClear
  export _root_.cairo.functions.FcConfigBuildFonts
  export _root_.cairo.functions.FcConfigCreate
  export _root_.cairo.functions.FcConfigDestroy
  export _root_.cairo.functions.FcConfigEnableHome
  export _root_.cairo.functions.FcConfigFileInfoIterGet
  export _root_.cairo.functions.FcConfigFileInfoIterInit
  export _root_.cairo.functions.FcConfigFileInfoIterNext
  export _root_.cairo.functions.FcConfigFilename
  export _root_.cairo.functions.FcConfigGetBlanks
  export _root_.cairo.functions.FcConfigGetCache
  export _root_.cairo.functions.FcConfigGetCacheDirs
  export _root_.cairo.functions.FcConfigGetConfigDirs
  export _root_.cairo.functions.FcConfigGetConfigFiles
  export _root_.cairo.functions.FcConfigGetCurrent
  export _root_.cairo.functions.FcConfigGetFilename
  export _root_.cairo.functions.FcConfigGetFontDirs
  export _root_.cairo.functions.FcConfigGetFonts
  export _root_.cairo.functions.FcConfigGetRescanInterval
  export _root_.cairo.functions.FcConfigGetSysRoot
  export _root_.cairo.functions.FcConfigHome
  export _root_.cairo.functions.FcConfigParseAndLoad
  export _root_.cairo.functions.FcConfigParseAndLoadFromMemory
  export _root_.cairo.functions.FcConfigReference
  export _root_.cairo.functions.FcConfigSetCurrent
  export _root_.cairo.functions.FcConfigSetRescanInterval
  export _root_.cairo.functions.FcConfigSetSysRoot
  export _root_.cairo.functions.FcConfigSubstitute
  export _root_.cairo.functions.FcConfigSubstituteWithPat
  export _root_.cairo.functions.FcConfigUptoDate
  export _root_.cairo.functions.FcDefaultSubstitute
  export _root_.cairo.functions.FcDirCacheClean
  export _root_.cairo.functions.FcDirCacheCreateUUID
  export _root_.cairo.functions.FcDirCacheDeleteUUID
  export _root_.cairo.functions.FcDirCacheLoad
  export _root_.cairo.functions.FcDirCacheLoadFile
  export _root_.cairo.functions.FcDirCacheRead
  export _root_.cairo.functions.FcDirCacheRescan
  export _root_.cairo.functions.FcDirCacheUnlink
  export _root_.cairo.functions.FcDirCacheUnload
  export _root_.cairo.functions.FcDirCacheValid
  export _root_.cairo.functions.FcDirSave
  export _root_.cairo.functions.FcDirScan
  export _root_.cairo.functions.FcFileIsDir
  export _root_.cairo.functions.FcFileScan
  export _root_.cairo.functions.FcFini
  export _root_.cairo.functions.FcFontList
  export _root_.cairo.functions.FcFontMatch
  export _root_.cairo.functions.FcFontRenderPrepare
  export _root_.cairo.functions.FcFontSetAdd
  export _root_.cairo.functions.FcFontSetCreate
  export _root_.cairo.functions.FcFontSetDestroy
  export _root_.cairo.functions.FcFontSetList
  export _root_.cairo.functions.FcFontSetMatch
  export _root_.cairo.functions.FcFontSetPrint
  export _root_.cairo.functions.FcFontSetSort
  export _root_.cairo.functions.FcFontSetSortDestroy
  export _root_.cairo.functions.FcFontSort
  export _root_.cairo.functions.FcFreeTypeQuery
  export _root_.cairo.functions.FcFreeTypeQueryAll
  export _root_.cairo.functions.FcGetDefaultLangs
  export _root_.cairo.functions.FcGetLangs
  export _root_.cairo.functions.FcGetVersion
  export _root_.cairo.functions.FcInit
  export _root_.cairo.functions.FcInitBringUptoDate
  export _root_.cairo.functions.FcInitLoadConfig
  export _root_.cairo.functions.FcInitLoadConfigAndFonts
  export _root_.cairo.functions.FcInitReinitialize
  export _root_.cairo.functions.FcLangGetCharSet
  export _root_.cairo.functions.FcLangNormalize
  export _root_.cairo.functions.FcLangSetAdd
  export _root_.cairo.functions.FcLangSetCompare
  export _root_.cairo.functions.FcLangSetContains
  export _root_.cairo.functions.FcLangSetCopy
  export _root_.cairo.functions.FcLangSetCreate
  export _root_.cairo.functions.FcLangSetDel
  export _root_.cairo.functions.FcLangSetDestroy
  export _root_.cairo.functions.FcLangSetEqual
  export _root_.cairo.functions.FcLangSetGetLangs
  export _root_.cairo.functions.FcLangSetHasLang
  export _root_.cairo.functions.FcLangSetHash
  export _root_.cairo.functions.FcLangSetSubtract
  export _root_.cairo.functions.FcLangSetUnion
  export _root_.cairo.functions.FcMatrixCopy
  export _root_.cairo.functions.FcMatrixEqual
  export _root_.cairo.functions.FcMatrixMultiply
  export _root_.cairo.functions.FcMatrixRotate
  export _root_.cairo.functions.FcMatrixScale
  export _root_.cairo.functions.FcMatrixShear
  export _root_.cairo.functions.FcNameConstant
  export _root_.cairo.functions.FcNameGetConstant
  export _root_.cairo.functions.FcNameGetConstantFor
  export _root_.cairo.functions.FcNameGetObjectType
  export _root_.cairo.functions.FcNameParse
  export _root_.cairo.functions.FcNameRegisterConstants
  export _root_.cairo.functions.FcNameRegisterObjectTypes
  export _root_.cairo.functions.FcNameUnparse
  export _root_.cairo.functions.FcNameUnregisterConstants
  export _root_.cairo.functions.FcNameUnregisterObjectTypes
  export _root_.cairo.functions.FcObjectSetAdd
  export _root_.cairo.functions.FcObjectSetBuild
  export _root_.cairo.functions.FcObjectSetCreate
  export _root_.cairo.functions.FcObjectSetDestroy
  export _root_.cairo.functions.FcObjectSetVaBuild
  export _root_.cairo.functions.FcPatternAddBool
  export _root_.cairo.functions.FcPatternAddCharSet
  export _root_.cairo.functions.FcPatternAddDouble
  export _root_.cairo.functions.FcPatternAddInteger
  export _root_.cairo.functions.FcPatternAddLangSet
  export _root_.cairo.functions.FcPatternAddMatrix
  export _root_.cairo.functions.FcPatternAddRange
  export _root_.cairo.functions.FcPatternAddString
  export _root_.cairo.functions.FcPatternBuild
  export _root_.cairo.functions.FcPatternCreate
  export _root_.cairo.functions.FcPatternDel
  export _root_.cairo.functions.FcPatternDestroy
  export _root_.cairo.functions.FcPatternDuplicate
  export _root_.cairo.functions.FcPatternEqual
  export _root_.cairo.functions.FcPatternEqualSubset
  export _root_.cairo.functions.FcPatternFilter
  export _root_.cairo.functions.FcPatternFindIter
  export _root_.cairo.functions.FcPatternFormat
  export _root_.cairo.functions.FcPatternGet
  export _root_.cairo.functions.FcPatternGetBool
  export _root_.cairo.functions.FcPatternGetCharSet
  export _root_.cairo.functions.FcPatternGetDouble
  export _root_.cairo.functions.FcPatternGetInteger
  export _root_.cairo.functions.FcPatternGetLangSet
  export _root_.cairo.functions.FcPatternGetMatrix
  export _root_.cairo.functions.FcPatternGetRange
  export _root_.cairo.functions.FcPatternGetString
  export _root_.cairo.functions.FcPatternGetWithBinding
  export _root_.cairo.functions.FcPatternHash
  export _root_.cairo.functions.FcPatternIterEqual
  export _root_.cairo.functions.FcPatternIterGetObject
  export _root_.cairo.functions.FcPatternIterGetValue
  export _root_.cairo.functions.FcPatternIterIsValid
  export _root_.cairo.functions.FcPatternIterNext
  export _root_.cairo.functions.FcPatternIterStart
  export _root_.cairo.functions.FcPatternIterValueCount
  export _root_.cairo.functions.FcPatternObjectCount
  export _root_.cairo.functions.FcPatternPrint
  export _root_.cairo.functions.FcPatternReference
  export _root_.cairo.functions.FcPatternRemove
  export _root_.cairo.functions.FcPatternVaBuild
  export _root_.cairo.functions.FcRangeCopy
  export _root_.cairo.functions.FcRangeCreateDouble
  export _root_.cairo.functions.FcRangeCreateInteger
  export _root_.cairo.functions.FcRangeDestroy
  export _root_.cairo.functions.FcRangeGetDouble
  export _root_.cairo.functions.FcStrBasename
  export _root_.cairo.functions.FcStrBuildFilename
  export _root_.cairo.functions.FcStrCmp
  export _root_.cairo.functions.FcStrCmpIgnoreCase
  export _root_.cairo.functions.FcStrCopy
  export _root_.cairo.functions.FcStrCopyFilename
  export _root_.cairo.functions.FcStrDirname
  export _root_.cairo.functions.FcStrDowncase
  export _root_.cairo.functions.FcStrFree
  export _root_.cairo.functions.FcStrListCreate
  export _root_.cairo.functions.FcStrListDone
  export _root_.cairo.functions.FcStrListFirst
  export _root_.cairo.functions.FcStrListNext
  export _root_.cairo.functions.FcStrPlus
  export _root_.cairo.functions.FcStrSetAdd
  export _root_.cairo.functions.FcStrSetAddFilename
  export _root_.cairo.functions.FcStrSetCreate
  export _root_.cairo.functions.FcStrSetDel
  export _root_.cairo.functions.FcStrSetDestroy
  export _root_.cairo.functions.FcStrSetEqual
  export _root_.cairo.functions.FcStrSetMember
  export _root_.cairo.functions.FcStrStr
  export _root_.cairo.functions.FcStrStrIgnoreCase
  export _root_.cairo.functions.FcUcs4ToUtf8
  export _root_.cairo.functions.FcUtf16Len
  export _root_.cairo.functions.FcUtf16ToUcs4
  export _root_.cairo.functions.FcUtf8Len
  export _root_.cairo.functions.FcUtf8ToUcs4
  export _root_.cairo.functions.FcWeightFromOpenType
  export _root_.cairo.functions.FcWeightFromOpenTypeDouble
  export _root_.cairo.functions.FcWeightToOpenType
  export _root_.cairo.functions.FcWeightToOpenTypeDouble
  export _root_.cairo.functions.cairo_append_path
  export _root_.cairo.functions.cairo_arc
  export _root_.cairo.functions.cairo_arc_negative
  export _root_.cairo.functions.cairo_clip
  export _root_.cairo.functions.cairo_clip_extents
  export _root_.cairo.functions.cairo_clip_preserve
  export _root_.cairo.functions.cairo_close_path
  export _root_.cairo.functions.cairo_copy_clip_rectangle_list
  export _root_.cairo.functions.cairo_copy_page
  export _root_.cairo.functions.cairo_copy_path
  export _root_.cairo.functions.cairo_copy_path_flat
  export _root_.cairo.functions.cairo_create
  export _root_.cairo.functions.cairo_curve_to
  export _root_.cairo.functions.cairo_debug_reset_static_data
  export _root_.cairo.functions.cairo_destroy
  export _root_.cairo.functions.cairo_device_acquire
  export _root_.cairo.functions.cairo_device_destroy
  export _root_.cairo.functions.cairo_device_finish
  export _root_.cairo.functions.cairo_device_flush
  export _root_.cairo.functions.cairo_device_get_reference_count
  export _root_.cairo.functions.cairo_device_get_type
  export _root_.cairo.functions.cairo_device_get_user_data
  export _root_.cairo.functions.cairo_device_observer_elapsed
  export _root_.cairo.functions.cairo_device_observer_fill_elapsed
  export _root_.cairo.functions.cairo_device_observer_glyphs_elapsed
  export _root_.cairo.functions.cairo_device_observer_mask_elapsed
  export _root_.cairo.functions.cairo_device_observer_paint_elapsed
  export _root_.cairo.functions.cairo_device_observer_print
  export _root_.cairo.functions.cairo_device_observer_stroke_elapsed
  export _root_.cairo.functions.cairo_device_reference
  export _root_.cairo.functions.cairo_device_release
  export _root_.cairo.functions.cairo_device_set_user_data
  export _root_.cairo.functions.cairo_device_status
  export _root_.cairo.functions.cairo_device_to_user
  export _root_.cairo.functions.cairo_device_to_user_distance
  export _root_.cairo.functions.cairo_fill
  export _root_.cairo.functions.cairo_fill_extents
  export _root_.cairo.functions.cairo_fill_preserve
  export _root_.cairo.functions.cairo_font_extents
  export _root_.cairo.functions.cairo_font_face_destroy
  export _root_.cairo.functions.cairo_font_face_get_reference_count
  export _root_.cairo.functions.cairo_font_face_get_type
  export _root_.cairo.functions.cairo_font_face_get_user_data
  export _root_.cairo.functions.cairo_font_face_reference
  export _root_.cairo.functions.cairo_font_face_set_user_data
  export _root_.cairo.functions.cairo_font_face_status
  export _root_.cairo.functions.cairo_font_options_copy
  export _root_.cairo.functions.cairo_font_options_create
  export _root_.cairo.functions.cairo_font_options_destroy
  export _root_.cairo.functions.cairo_font_options_equal
  export _root_.cairo.functions.cairo_font_options_get_antialias
  export _root_.cairo.functions.cairo_font_options_get_color_mode
  export _root_.cairo.functions.cairo_font_options_get_color_palette
  export _root_.cairo.functions.cairo_font_options_get_custom_palette_color
  export _root_.cairo.functions.cairo_font_options_get_hint_metrics
  export _root_.cairo.functions.cairo_font_options_get_hint_style
  export _root_.cairo.functions.cairo_font_options_get_subpixel_order
  export _root_.cairo.functions.cairo_font_options_get_variations
  export _root_.cairo.functions.cairo_font_options_hash
  export _root_.cairo.functions.cairo_font_options_merge
  export _root_.cairo.functions.cairo_font_options_set_antialias
  export _root_.cairo.functions.cairo_font_options_set_color_mode
  export _root_.cairo.functions.cairo_font_options_set_color_palette
  export _root_.cairo.functions.cairo_font_options_set_custom_palette_color
  export _root_.cairo.functions.cairo_font_options_set_hint_metrics
  export _root_.cairo.functions.cairo_font_options_set_hint_style
  export _root_.cairo.functions.cairo_font_options_set_subpixel_order
  export _root_.cairo.functions.cairo_font_options_set_variations
  export _root_.cairo.functions.cairo_font_options_status
  export _root_.cairo.functions.cairo_format_stride_for_width
  export _root_.cairo.functions.cairo_ft_font_face_create_for_ft_face
  export _root_.cairo.functions.cairo_ft_font_face_create_for_pattern
  export _root_.cairo.functions.cairo_ft_font_face_get_synthesize
  export _root_.cairo.functions.cairo_ft_font_face_set_synthesize
  export _root_.cairo.functions.cairo_ft_font_face_unset_synthesize
  export _root_.cairo.functions.cairo_ft_font_options_substitute
  export _root_.cairo.functions.cairo_ft_scaled_font_lock_face
  export _root_.cairo.functions.cairo_ft_scaled_font_unlock_face
  export _root_.cairo.functions.cairo_get_antialias
  export _root_.cairo.functions.cairo_get_current_point
  export _root_.cairo.functions.cairo_get_dash
  export _root_.cairo.functions.cairo_get_dash_count
  export _root_.cairo.functions.cairo_get_fill_rule
  export _root_.cairo.functions.cairo_get_font_face
  export _root_.cairo.functions.cairo_get_font_matrix
  export _root_.cairo.functions.cairo_get_font_options
  export _root_.cairo.functions.cairo_get_group_target
  export _root_.cairo.functions.cairo_get_hairline
  export _root_.cairo.functions.cairo_get_line_cap
  export _root_.cairo.functions.cairo_get_line_join
  export _root_.cairo.functions.cairo_get_line_width
  export _root_.cairo.functions.cairo_get_matrix
  export _root_.cairo.functions.cairo_get_miter_limit
  export _root_.cairo.functions.cairo_get_operator
  export _root_.cairo.functions.cairo_get_reference_count
  export _root_.cairo.functions.cairo_get_scaled_font
  export _root_.cairo.functions.cairo_get_source
  export _root_.cairo.functions.cairo_get_target
  export _root_.cairo.functions.cairo_get_tolerance
  export _root_.cairo.functions.cairo_get_user_data
  export _root_.cairo.functions.cairo_glyph_allocate
  export _root_.cairo.functions.cairo_glyph_extents
  export _root_.cairo.functions.cairo_glyph_free
  export _root_.cairo.functions.cairo_glyph_path
  export _root_.cairo.functions.cairo_has_current_point
  export _root_.cairo.functions.cairo_identity_matrix
  export _root_.cairo.functions.cairo_image_surface_create
  export _root_.cairo.functions.cairo_image_surface_create_for_data
  export _root_.cairo.functions.cairo_image_surface_create_from_png
  export _root_.cairo.functions.cairo_image_surface_create_from_png_stream
  export _root_.cairo.functions.cairo_image_surface_get_data
  export _root_.cairo.functions.cairo_image_surface_get_format
  export _root_.cairo.functions.cairo_image_surface_get_height
  export _root_.cairo.functions.cairo_image_surface_get_stride
  export _root_.cairo.functions.cairo_image_surface_get_width
  export _root_.cairo.functions.cairo_in_clip
  export _root_.cairo.functions.cairo_in_fill
  export _root_.cairo.functions.cairo_in_stroke
  export _root_.cairo.functions.cairo_line_to
  export _root_.cairo.functions.cairo_mask
  export _root_.cairo.functions.cairo_mask_surface
  export _root_.cairo.functions.cairo_matrix_init
  export _root_.cairo.functions.cairo_matrix_init_identity
  export _root_.cairo.functions.cairo_matrix_init_rotate
  export _root_.cairo.functions.cairo_matrix_init_scale
  export _root_.cairo.functions.cairo_matrix_init_translate
  export _root_.cairo.functions.cairo_matrix_invert
  export _root_.cairo.functions.cairo_matrix_multiply
  export _root_.cairo.functions.cairo_matrix_rotate
  export _root_.cairo.functions.cairo_matrix_scale
  export _root_.cairo.functions.cairo_matrix_transform_distance
  export _root_.cairo.functions.cairo_matrix_transform_point
  export _root_.cairo.functions.cairo_matrix_translate
  export _root_.cairo.functions.cairo_mesh_pattern_begin_patch
  export _root_.cairo.functions.cairo_mesh_pattern_curve_to
  export _root_.cairo.functions.cairo_mesh_pattern_end_patch
  export _root_.cairo.functions.cairo_mesh_pattern_get_control_point
  export _root_.cairo.functions.cairo_mesh_pattern_get_corner_color_rgba
  export _root_.cairo.functions.cairo_mesh_pattern_get_patch_count
  export _root_.cairo.functions.cairo_mesh_pattern_get_path
  export _root_.cairo.functions.cairo_mesh_pattern_line_to
  export _root_.cairo.functions.cairo_mesh_pattern_move_to
  export _root_.cairo.functions.cairo_mesh_pattern_set_control_point
  export _root_.cairo.functions.cairo_mesh_pattern_set_corner_color_rgb
  export _root_.cairo.functions.cairo_mesh_pattern_set_corner_color_rgba
  export _root_.cairo.functions.cairo_move_to
  export _root_.cairo.functions.cairo_new_path
  export _root_.cairo.functions.cairo_new_sub_path
  export _root_.cairo.functions.cairo_paint
  export _root_.cairo.functions.cairo_paint_with_alpha
  export _root_.cairo.functions.cairo_path_destroy
  export _root_.cairo.functions.cairo_path_extents
  export _root_.cairo.functions.cairo_pattern_add_color_stop_rgb
  export _root_.cairo.functions.cairo_pattern_add_color_stop_rgba
  export _root_.cairo.functions.cairo_pattern_create_for_surface
  export _root_.cairo.functions.cairo_pattern_create_linear
  export _root_.cairo.functions.cairo_pattern_create_mesh
  export _root_.cairo.functions.cairo_pattern_create_radial
  export _root_.cairo.functions.cairo_pattern_create_raster_source
  export _root_.cairo.functions.cairo_pattern_create_rgb
  export _root_.cairo.functions.cairo_pattern_create_rgba
  export _root_.cairo.functions.cairo_pattern_destroy
  export _root_.cairo.functions.cairo_pattern_get_color_stop_count
  export _root_.cairo.functions.cairo_pattern_get_color_stop_rgba
  export _root_.cairo.functions.cairo_pattern_get_dither
  export _root_.cairo.functions.cairo_pattern_get_extend
  export _root_.cairo.functions.cairo_pattern_get_filter
  export _root_.cairo.functions.cairo_pattern_get_linear_points
  export _root_.cairo.functions.cairo_pattern_get_matrix
  export _root_.cairo.functions.cairo_pattern_get_radial_circles
  export _root_.cairo.functions.cairo_pattern_get_reference_count
  export _root_.cairo.functions.cairo_pattern_get_rgba
  export _root_.cairo.functions.cairo_pattern_get_surface
  export _root_.cairo.functions.cairo_pattern_get_type
  export _root_.cairo.functions.cairo_pattern_get_user_data
  export _root_.cairo.functions.cairo_pattern_reference
  export _root_.cairo.functions.cairo_pattern_set_dither
  export _root_.cairo.functions.cairo_pattern_set_extend
  export _root_.cairo.functions.cairo_pattern_set_filter
  export _root_.cairo.functions.cairo_pattern_set_matrix
  export _root_.cairo.functions.cairo_pattern_set_user_data
  export _root_.cairo.functions.cairo_pattern_status
  export _root_.cairo.functions.cairo_pop_group
  export _root_.cairo.functions.cairo_pop_group_to_source
  export _root_.cairo.functions.cairo_push_group
  export _root_.cairo.functions.cairo_push_group_with_content
  export _root_.cairo.functions.cairo_raster_source_pattern_get_acquire
  export _root_.cairo.functions.cairo_raster_source_pattern_get_callback_data
  export _root_.cairo.functions.cairo_raster_source_pattern_get_copy
  export _root_.cairo.functions.cairo_raster_source_pattern_get_finish
  export _root_.cairo.functions.cairo_raster_source_pattern_get_snapshot
  export _root_.cairo.functions.cairo_raster_source_pattern_set_acquire
  export _root_.cairo.functions.cairo_raster_source_pattern_set_callback_data
  export _root_.cairo.functions.cairo_raster_source_pattern_set_copy
  export _root_.cairo.functions.cairo_raster_source_pattern_set_finish
  export _root_.cairo.functions.cairo_raster_source_pattern_set_snapshot
  export _root_.cairo.functions.cairo_recording_surface_create
  export _root_.cairo.functions.cairo_recording_surface_get_extents
  export _root_.cairo.functions.cairo_recording_surface_ink_extents
  export _root_.cairo.functions.cairo_rectangle
  export _root_.cairo.functions.cairo_rectangle_list_destroy
  export _root_.cairo.functions.cairo_reference
  export _root_.cairo.functions.cairo_region_contains_point
  export _root_.cairo.functions.cairo_region_contains_rectangle
  export _root_.cairo.functions.cairo_region_copy
  export _root_.cairo.functions.cairo_region_create
  export _root_.cairo.functions.cairo_region_create_rectangle
  export _root_.cairo.functions.cairo_region_create_rectangles
  export _root_.cairo.functions.cairo_region_destroy
  export _root_.cairo.functions.cairo_region_equal
  export _root_.cairo.functions.cairo_region_get_extents
  export _root_.cairo.functions.cairo_region_get_rectangle
  export _root_.cairo.functions.cairo_region_intersect
  export _root_.cairo.functions.cairo_region_intersect_rectangle
  export _root_.cairo.functions.cairo_region_is_empty
  export _root_.cairo.functions.cairo_region_num_rectangles
  export _root_.cairo.functions.cairo_region_reference
  export _root_.cairo.functions.cairo_region_status
  export _root_.cairo.functions.cairo_region_subtract
  export _root_.cairo.functions.cairo_region_subtract_rectangle
  export _root_.cairo.functions.cairo_region_translate
  export _root_.cairo.functions.cairo_region_union
  export _root_.cairo.functions.cairo_region_union_rectangle
  export _root_.cairo.functions.cairo_region_xor
  export _root_.cairo.functions.cairo_region_xor_rectangle
  export _root_.cairo.functions.cairo_rel_curve_to
  export _root_.cairo.functions.cairo_rel_line_to
  export _root_.cairo.functions.cairo_rel_move_to
  export _root_.cairo.functions.cairo_reset_clip
  export _root_.cairo.functions.cairo_restore
  export _root_.cairo.functions.cairo_rotate
  export _root_.cairo.functions.cairo_save
  export _root_.cairo.functions.cairo_scale
  export _root_.cairo.functions.cairo_scaled_font_create
  export _root_.cairo.functions.cairo_scaled_font_destroy
  export _root_.cairo.functions.cairo_scaled_font_extents
  export _root_.cairo.functions.cairo_scaled_font_get_ctm
  export _root_.cairo.functions.cairo_scaled_font_get_font_face
  export _root_.cairo.functions.cairo_scaled_font_get_font_matrix
  export _root_.cairo.functions.cairo_scaled_font_get_font_options
  export _root_.cairo.functions.cairo_scaled_font_get_reference_count
  export _root_.cairo.functions.cairo_scaled_font_get_scale_matrix
  export _root_.cairo.functions.cairo_scaled_font_get_type
  export _root_.cairo.functions.cairo_scaled_font_get_user_data
  export _root_.cairo.functions.cairo_scaled_font_glyph_extents
  export _root_.cairo.functions.cairo_scaled_font_reference
  export _root_.cairo.functions.cairo_scaled_font_set_user_data
  export _root_.cairo.functions.cairo_scaled_font_status
  export _root_.cairo.functions.cairo_scaled_font_text_extents
  export _root_.cairo.functions.cairo_scaled_font_text_to_glyphs
  export _root_.cairo.functions.cairo_select_font_face
  export _root_.cairo.functions.cairo_set_antialias
  export _root_.cairo.functions.cairo_set_dash
  export _root_.cairo.functions.cairo_set_fill_rule
  export _root_.cairo.functions.cairo_set_font_face
  export _root_.cairo.functions.cairo_set_font_matrix
  export _root_.cairo.functions.cairo_set_font_options
  export _root_.cairo.functions.cairo_set_font_size
  export _root_.cairo.functions.cairo_set_hairline
  export _root_.cairo.functions.cairo_set_line_cap
  export _root_.cairo.functions.cairo_set_line_join
  export _root_.cairo.functions.cairo_set_line_width
  export _root_.cairo.functions.cairo_set_matrix
  export _root_.cairo.functions.cairo_set_miter_limit
  export _root_.cairo.functions.cairo_set_operator
  export _root_.cairo.functions.cairo_set_scaled_font
  export _root_.cairo.functions.cairo_set_source
  export _root_.cairo.functions.cairo_set_source_rgb
  export _root_.cairo.functions.cairo_set_source_rgba
  export _root_.cairo.functions.cairo_set_source_surface
  export _root_.cairo.functions.cairo_set_tolerance
  export _root_.cairo.functions.cairo_set_user_data
  export _root_.cairo.functions.cairo_show_glyphs
  export _root_.cairo.functions.cairo_show_page
  export _root_.cairo.functions.cairo_show_text
  export _root_.cairo.functions.cairo_show_text_glyphs
  export _root_.cairo.functions.cairo_status
  export _root_.cairo.functions.cairo_status_to_string
  export _root_.cairo.functions.cairo_stroke
  export _root_.cairo.functions.cairo_stroke_extents
  export _root_.cairo.functions.cairo_stroke_preserve
  export _root_.cairo.functions.cairo_surface_copy_page
  export _root_.cairo.functions.cairo_surface_create_for_rectangle
  export _root_.cairo.functions.cairo_surface_create_observer
  export _root_.cairo.functions.cairo_surface_create_similar
  export _root_.cairo.functions.cairo_surface_create_similar_image
  export _root_.cairo.functions.cairo_surface_destroy
  export _root_.cairo.functions.cairo_surface_finish
  export _root_.cairo.functions.cairo_surface_flush
  export _root_.cairo.functions.cairo_surface_get_content
  export _root_.cairo.functions.cairo_surface_get_device
  export _root_.cairo.functions.cairo_surface_get_device_offset
  export _root_.cairo.functions.cairo_surface_get_device_scale
  export _root_.cairo.functions.cairo_surface_get_fallback_resolution
  export _root_.cairo.functions.cairo_surface_get_font_options
  export _root_.cairo.functions.cairo_surface_get_mime_data
  export _root_.cairo.functions.cairo_surface_get_reference_count
  export _root_.cairo.functions.cairo_surface_get_type
  export _root_.cairo.functions.cairo_surface_get_user_data
  export _root_.cairo.functions.cairo_surface_has_show_text_glyphs
  export _root_.cairo.functions.cairo_surface_map_to_image
  export _root_.cairo.functions.cairo_surface_mark_dirty
  export _root_.cairo.functions.cairo_surface_mark_dirty_rectangle
  export _root_.cairo.functions.cairo_surface_observer_add_fill_callback
  export _root_.cairo.functions.cairo_surface_observer_add_finish_callback
  export _root_.cairo.functions.cairo_surface_observer_add_flush_callback
  export _root_.cairo.functions.cairo_surface_observer_add_glyphs_callback
  export _root_.cairo.functions.cairo_surface_observer_add_mask_callback
  export _root_.cairo.functions.cairo_surface_observer_add_paint_callback
  export _root_.cairo.functions.cairo_surface_observer_add_stroke_callback
  export _root_.cairo.functions.cairo_surface_observer_elapsed
  export _root_.cairo.functions.cairo_surface_observer_print
  export _root_.cairo.functions.cairo_surface_reference
  export _root_.cairo.functions.cairo_surface_set_device_offset
  export _root_.cairo.functions.cairo_surface_set_device_scale
  export _root_.cairo.functions.cairo_surface_set_fallback_resolution
  export _root_.cairo.functions.cairo_surface_set_mime_data
  export _root_.cairo.functions.cairo_surface_set_user_data
  export _root_.cairo.functions.cairo_surface_show_page
  export _root_.cairo.functions.cairo_surface_status
  export _root_.cairo.functions.cairo_surface_supports_mime_type
  export _root_.cairo.functions.cairo_surface_unmap_image
  export _root_.cairo.functions.cairo_surface_write_to_png
  export _root_.cairo.functions.cairo_surface_write_to_png_stream
  export _root_.cairo.functions.cairo_tag_begin
  export _root_.cairo.functions.cairo_tag_end
  export _root_.cairo.functions.cairo_text_cluster_allocate
  export _root_.cairo.functions.cairo_text_cluster_free
  export _root_.cairo.functions.cairo_text_extents
  export _root_.cairo.functions.cairo_text_path
  export _root_.cairo.functions.cairo_toy_font_face_create
  export _root_.cairo.functions.cairo_toy_font_face_get_family
  export _root_.cairo.functions.cairo_toy_font_face_get_slant
  export _root_.cairo.functions.cairo_toy_font_face_get_weight
  export _root_.cairo.functions.cairo_transform
  export _root_.cairo.functions.cairo_translate
  export _root_.cairo.functions.cairo_user_font_face_create
  export _root_.cairo.functions.cairo_user_font_face_get_init_func
  export _root_.cairo.functions.cairo_user_font_face_get_render_color_glyph_func
  export _root_.cairo.functions.cairo_user_font_face_get_render_glyph_func
  export _root_.cairo.functions.cairo_user_font_face_get_text_to_glyphs_func
  export _root_.cairo.functions.cairo_user_font_face_get_unicode_to_glyph_func
  export _root_.cairo.functions.cairo_user_font_face_set_init_func
  export _root_.cairo.functions.cairo_user_font_face_set_render_color_glyph_func
  export _root_.cairo.functions.cairo_user_font_face_set_render_glyph_func
  export _root_.cairo.functions.cairo_user_font_face_set_text_to_glyphs_func
  export _root_.cairo.functions.cairo_user_font_face_set_unicode_to_glyph_func
  export _root_.cairo.functions.cairo_user_scaled_font_get_foreground_marker
  export _root_.cairo.functions.cairo_user_scaled_font_get_foreground_source
  export _root_.cairo.functions.cairo_user_to_device
  export _root_.cairo.functions.cairo_user_to_device_distance
  export _root_.cairo.functions.cairo_version
  export _root_.cairo.functions.cairo_version_string
  export _root_.cairo.functions.stat
  export _root_.cairo.functions.FcPatternAdd
  export _root_.cairo.functions.FcPatternAddWeak
  export _root_.cairo.functions.FcValueDestroy
  export _root_.cairo.functions.FcValueEqual
  export _root_.cairo.functions.FcValuePrint
  export _root_.cairo.functions.FcValueSave