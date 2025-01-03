package tree_sitter

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

object predef:
  private[tree_sitter] trait CEnumU[T](using eq: T =:= UInt):
    given Tag[T] = Tag.UInt.asInstanceOf[Tag[T]]
    extension (inline t: T)
     inline def int: CInt = eq.apply(t).toInt
     inline def uint: CUnsignedInt = eq.apply(t)
     inline def value: CUnsignedInt = eq.apply(t)


object enumerations:
  import predef.*
  opaque type TSInputEncoding = CUnsignedInt
  object TSInputEncoding extends CEnumU[TSInputEncoding]:
    given _tag: Tag[TSInputEncoding] = Tag.UInt
    inline def define(inline a: Long): TSInputEncoding = a.toUInt
    val TSInputEncodingUTF8 = define(0)
    val TSInputEncodingUTF16 = define(1)
    inline def getName(inline value: TSInputEncoding): Option[String] =
      inline value match
        case TSInputEncodingUTF8 => Some("TSInputEncodingUTF8")
        case TSInputEncodingUTF16 => Some("TSInputEncodingUTF16")
        case _ => _root_.scala.None
    extension (a: TSInputEncoding)
      inline def &(b: TSInputEncoding): TSInputEncoding = a & b
      inline def |(b: TSInputEncoding): TSInputEncoding = a | b
      inline def is(b: TSInputEncoding): Boolean = (a & b) == b

  opaque type TSLogType = CUnsignedInt
  object TSLogType extends CEnumU[TSLogType]:
    given _tag: Tag[TSLogType] = Tag.UInt
    inline def define(inline a: Long): TSLogType = a.toUInt
    val TSLogTypeParse = define(0)
    val TSLogTypeLex = define(1)
    inline def getName(inline value: TSLogType): Option[String] =
      inline value match
        case TSLogTypeParse => Some("TSLogTypeParse")
        case TSLogTypeLex => Some("TSLogTypeLex")
        case _ => _root_.scala.None
    extension (a: TSLogType)
      inline def &(b: TSLogType): TSLogType = a & b
      inline def |(b: TSLogType): TSLogType = a | b
      inline def is(b: TSLogType): Boolean = (a & b) == b

  opaque type TSQuantifier = CUnsignedInt
  object TSQuantifier extends CEnumU[TSQuantifier]:
    given _tag: Tag[TSQuantifier] = Tag.UInt
    inline def define(inline a: Long): TSQuantifier = a.toUInt
    val TSQuantifierZero = define(0)
    val TSQuantifierZeroOrOne = define(1)
    val TSQuantifierZeroOrMore = define(2)
    val TSQuantifierOne = define(3)
    val TSQuantifierOneOrMore = define(4)
    inline def getName(inline value: TSQuantifier): Option[String] =
      inline value match
        case TSQuantifierZero => Some("TSQuantifierZero")
        case TSQuantifierZeroOrOne => Some("TSQuantifierZeroOrOne")
        case TSQuantifierZeroOrMore => Some("TSQuantifierZeroOrMore")
        case TSQuantifierOne => Some("TSQuantifierOne")
        case TSQuantifierOneOrMore => Some("TSQuantifierOneOrMore")
        case _ => _root_.scala.None
    extension (a: TSQuantifier)
      inline def &(b: TSQuantifier): TSQuantifier = a & b
      inline def |(b: TSQuantifier): TSQuantifier = a | b
      inline def is(b: TSQuantifier): Boolean = (a & b) == b

  opaque type TSQueryError = CUnsignedInt
  object TSQueryError extends CEnumU[TSQueryError]:
    given _tag: Tag[TSQueryError] = Tag.UInt
    inline def define(inline a: Long): TSQueryError = a.toUInt
    val TSQueryErrorNone = define(0)
    val TSQueryErrorSyntax = define(1)
    val TSQueryErrorNodeType = define(2)
    val TSQueryErrorField = define(3)
    val TSQueryErrorCapture = define(4)
    val TSQueryErrorStructure = define(5)
    val TSQueryErrorLanguage = define(6)
    inline def getName(inline value: TSQueryError): Option[String] =
      inline value match
        case TSQueryErrorNone => Some("TSQueryErrorNone")
        case TSQueryErrorSyntax => Some("TSQueryErrorSyntax")
        case TSQueryErrorNodeType => Some("TSQueryErrorNodeType")
        case TSQueryErrorField => Some("TSQueryErrorField")
        case TSQueryErrorCapture => Some("TSQueryErrorCapture")
        case TSQueryErrorStructure => Some("TSQueryErrorStructure")
        case TSQueryErrorLanguage => Some("TSQueryErrorLanguage")
        case _ => _root_.scala.None
    extension (a: TSQueryError)
      inline def &(b: TSQueryError): TSQueryError = a & b
      inline def |(b: TSQueryError): TSQueryError = a | b
      inline def is(b: TSQueryError): Boolean = (a & b) == b

  opaque type TSQueryPredicateStepType = CUnsignedInt
  object TSQueryPredicateStepType extends CEnumU[TSQueryPredicateStepType]:
    given _tag: Tag[TSQueryPredicateStepType] = Tag.UInt
    inline def define(inline a: Long): TSQueryPredicateStepType = a.toUInt
    val TSQueryPredicateStepTypeDone = define(0)
    val TSQueryPredicateStepTypeCapture = define(1)
    val TSQueryPredicateStepTypeString = define(2)
    inline def getName(inline value: TSQueryPredicateStepType): Option[String] =
      inline value match
        case TSQueryPredicateStepTypeDone => Some("TSQueryPredicateStepTypeDone")
        case TSQueryPredicateStepTypeCapture => Some("TSQueryPredicateStepTypeCapture")
        case TSQueryPredicateStepTypeString => Some("TSQueryPredicateStepTypeString")
        case _ => _root_.scala.None
    extension (a: TSQueryPredicateStepType)
      inline def &(b: TSQueryPredicateStepType): TSQueryPredicateStepType = a & b
      inline def |(b: TSQueryPredicateStepType): TSQueryPredicateStepType = a | b
      inline def is(b: TSQueryPredicateStepType): Boolean = (a & b) == b

  opaque type TSSymbolType = CUnsignedInt
  object TSSymbolType extends CEnumU[TSSymbolType]:
    given _tag: Tag[TSSymbolType] = Tag.UInt
    inline def define(inline a: Long): TSSymbolType = a.toUInt
    val TSSymbolTypeRegular = define(0)
    val TSSymbolTypeAnonymous = define(1)
    val TSSymbolTypeAuxiliary = define(2)
    inline def getName(inline value: TSSymbolType): Option[String] =
      inline value match
        case TSSymbolTypeRegular => Some("TSSymbolTypeRegular")
        case TSSymbolTypeAnonymous => Some("TSSymbolTypeAnonymous")
        case TSSymbolTypeAuxiliary => Some("TSSymbolTypeAuxiliary")
        case _ => _root_.scala.None
    extension (a: TSSymbolType)
      inline def &(b: TSSymbolType): TSSymbolType = a & b
      inline def |(b: TSSymbolType): TSSymbolType = a | b
      inline def is(b: TSSymbolType): Boolean = (a & b) == b

object aliases:
  import _root_.tree_sitter.enumerations.*
  import _root_.tree_sitter.predef.*
  import _root_.tree_sitter.aliases.*
  import _root_.tree_sitter.structs.*
  type FILE = libc.stdio.FILE
  object FILE: 
    val _tag: Tag[FILE] = summon[Tag[libc.stdio.FILE]]
    inline def apply(inline o: libc.stdio.FILE): FILE = o
    extension (v: FILE)
      inline def value: libc.stdio.FILE = v

  type TSFieldId = uint16_t
  object TSFieldId: 
    given _tag: Tag[TSFieldId] = uint16_t._tag
    inline def apply(inline o: uint16_t): TSFieldId = o
    extension (v: TSFieldId)
      inline def value: uint16_t = v

  /**
   * ****************
  */
  type TSSymbol = uint16_t
  object TSSymbol: 
    given _tag: Tag[TSSymbol] = uint16_t._tag
    inline def apply(inline o: uint16_t): TSSymbol = o
    extension (v: TSSymbol)
      inline def value: uint16_t = v

  type int64_t = scala.Long
  object int64_t: 
    val _tag: Tag[int64_t] = summon[Tag[scala.Long]]
    inline def apply(inline o: scala.Long): int64_t = o
    extension (v: int64_t)
      inline def value: scala.Long = v

  type size_t = libc.stddef.size_t
  object size_t: 
    val _tag: Tag[size_t] = summon[Tag[libc.stddef.size_t]]
    inline def apply(inline o: libc.stddef.size_t): size_t = o
    extension (v: size_t)
      inline def value: libc.stddef.size_t = v

  type uint16_t = scala.scalanative.unsigned.UShort
  object uint16_t: 
    val _tag: Tag[uint16_t] = summon[Tag[scala.scalanative.unsigned.UShort]]
    inline def apply(inline o: scala.scalanative.unsigned.UShort): uint16_t = o
    extension (v: uint16_t)
      inline def value: scala.scalanative.unsigned.UShort = v

  type uint32_t = scala.scalanative.unsigned.UInt
  object uint32_t: 
    val _tag: Tag[uint32_t] = summon[Tag[scala.scalanative.unsigned.UInt]]
    inline def apply(inline o: scala.scalanative.unsigned.UInt): uint32_t = o
    extension (v: uint32_t)
      inline def value: scala.scalanative.unsigned.UInt = v

  type uint64_t = scala.scalanative.unsigned.ULong
  object uint64_t: 
    val _tag: Tag[uint64_t] = summon[Tag[scala.scalanative.unsigned.ULong]]
    inline def apply(inline o: scala.scalanative.unsigned.ULong): uint64_t = o
    extension (v: uint64_t)
      inline def value: scala.scalanative.unsigned.ULong = v

object structs:
  import _root_.tree_sitter.enumerations.*
  import _root_.tree_sitter.predef.*
  import _root_.tree_sitter.aliases.*
  import _root_.tree_sitter.structs.*
  opaque type TSInput = CStruct3[Ptr[Byte], CFuncPtr4[Ptr[Byte], uint32_t, TSPoint, Ptr[uint32_t], CString], TSInputEncoding]
  object TSInput:
    given _tag: Tag[TSInput] = Tag.materializeCStruct3Tag[Ptr[Byte], CFuncPtr4[Ptr[Byte], uint32_t, TSPoint, Ptr[uint32_t], CString], TSInputEncoding]
    def apply()(using Zone): Ptr[TSInput] = scala.scalanative.unsafe.alloc[TSInput](1)
    def apply(payload : Ptr[Byte], read : CFuncPtr4[Ptr[Byte], uint32_t, TSPoint, Ptr[uint32_t], CString], encoding : TSInputEncoding)(using Zone): Ptr[TSInput] = 
      val ____ptr = apply()
      (!____ptr).payload = payload
      (!____ptr).read = read
      (!____ptr).encoding = encoding
      ____ptr
    extension (struct: TSInput)
      def payload : Ptr[Byte] = struct._1
      def payload_=(value: Ptr[Byte]): Unit = !struct.at1 = value
      def read : CFuncPtr4[Ptr[Byte], uint32_t, TSPoint, Ptr[uint32_t], CString] = struct._2
      def read_=(value: CFuncPtr4[Ptr[Byte], uint32_t, TSPoint, Ptr[uint32_t], CString]): Unit = !struct.at2 = value
      def encoding : TSInputEncoding = struct._3
      def encoding_=(value: TSInputEncoding): Unit = !struct.at3 = value

  opaque type TSInputEdit = CStruct6[uint32_t, uint32_t, uint32_t, TSPoint, TSPoint, TSPoint]
  object TSInputEdit:
    given _tag: Tag[TSInputEdit] = Tag.materializeCStruct6Tag[uint32_t, uint32_t, uint32_t, TSPoint, TSPoint, TSPoint]
    def apply()(using Zone): Ptr[TSInputEdit] = scala.scalanative.unsafe.alloc[TSInputEdit](1)
    def apply(start_byte : uint32_t, old_end_byte : uint32_t, new_end_byte : uint32_t, start_point : TSPoint, old_end_point : TSPoint, new_end_point : TSPoint)(using Zone): Ptr[TSInputEdit] = 
      val ____ptr = apply()
      (!____ptr).start_byte = start_byte
      (!____ptr).old_end_byte = old_end_byte
      (!____ptr).new_end_byte = new_end_byte
      (!____ptr).start_point = start_point
      (!____ptr).old_end_point = old_end_point
      (!____ptr).new_end_point = new_end_point
      ____ptr
    extension (struct: TSInputEdit)
      def start_byte : uint32_t = struct._1
      def start_byte_=(value: uint32_t): Unit = !struct.at1 = value
      def old_end_byte : uint32_t = struct._2
      def old_end_byte_=(value: uint32_t): Unit = !struct.at2 = value
      def new_end_byte : uint32_t = struct._3
      def new_end_byte_=(value: uint32_t): Unit = !struct.at3 = value
      def start_point : TSPoint = struct._4
      def start_point_=(value: TSPoint): Unit = !struct.at4 = value
      def old_end_point : TSPoint = struct._5
      def old_end_point_=(value: TSPoint): Unit = !struct.at5 = value
      def new_end_point : TSPoint = struct._6
      def new_end_point_=(value: TSPoint): Unit = !struct.at6 = value

  opaque type TSLanguage = CStruct0
  object TSLanguage:
    given _tag: Tag[TSLanguage] = Tag.materializeCStruct0Tag

  opaque type TSLogger = CStruct2[Ptr[Byte], CFuncPtr3[Ptr[Byte], TSLogType, CString, Unit]]
  object TSLogger:
    given _tag: Tag[TSLogger] = Tag.materializeCStruct2Tag[Ptr[Byte], CFuncPtr3[Ptr[Byte], TSLogType, CString, Unit]]
    def apply()(using Zone): Ptr[TSLogger] = scala.scalanative.unsafe.alloc[TSLogger](1)
    def apply(payload : Ptr[Byte], log : CFuncPtr3[Ptr[Byte], TSLogType, CString, Unit])(using Zone): Ptr[TSLogger] = 
      val ____ptr = apply()
      (!____ptr).payload = payload
      (!____ptr).log = log
      ____ptr
    extension (struct: TSLogger)
      def payload : Ptr[Byte] = struct._1
      def payload_=(value: Ptr[Byte]): Unit = !struct.at1 = value
      def log : CFuncPtr3[Ptr[Byte], TSLogType, CString, Unit] = struct._2
      def log_=(value: CFuncPtr3[Ptr[Byte], TSLogType, CString, Unit]): Unit = !struct.at2 = value

  opaque type TSNode = CStruct3[CArray[uint32_t, Nat._4], Ptr[Byte], Ptr[TSTree]]
  object TSNode:
    given _tag: Tag[TSNode] = Tag.materializeCStruct3Tag[CArray[uint32_t, Nat._4], Ptr[Byte], Ptr[TSTree]]
    def apply()(using Zone): Ptr[TSNode] = scala.scalanative.unsafe.alloc[TSNode](1)
    def apply(context : CArray[uint32_t, Nat._4], id : Ptr[Byte], tree : Ptr[TSTree])(using Zone): Ptr[TSNode] = 
      val ____ptr = apply()
      (!____ptr).context = context
      (!____ptr).id = id
      (!____ptr).tree = tree
      ____ptr
    extension (struct: TSNode)
      def context : CArray[uint32_t, Nat._4] = struct._1
      def context_=(value: CArray[uint32_t, Nat._4]): Unit = !struct.at1 = value
      def id : Ptr[Byte] = struct._2
      def id_=(value: Ptr[Byte]): Unit = !struct.at2 = value
      def tree : Ptr[TSTree] = struct._3
      def tree_=(value: Ptr[TSTree]): Unit = !struct.at3 = value

  opaque type TSParser = CStruct0
  object TSParser:
    given _tag: Tag[TSParser] = Tag.materializeCStruct0Tag

  opaque type TSPoint = CStruct2[uint32_t, uint32_t]
  object TSPoint:
    given _tag: Tag[TSPoint] = Tag.materializeCStruct2Tag[uint32_t, uint32_t]
    def apply()(using Zone): Ptr[TSPoint] = scala.scalanative.unsafe.alloc[TSPoint](1)
    def apply(row : uint32_t, column : uint32_t)(using Zone): Ptr[TSPoint] = 
      val ____ptr = apply()
      (!____ptr).row = row
      (!____ptr).column = column
      ____ptr
    extension (struct: TSPoint)
      def row : uint32_t = struct._1
      def row_=(value: uint32_t): Unit = !struct.at1 = value
      def column : uint32_t = struct._2
      def column_=(value: uint32_t): Unit = !struct.at2 = value

  opaque type TSQuery = CStruct0
  object TSQuery:
    given _tag: Tag[TSQuery] = Tag.materializeCStruct0Tag

  opaque type TSQueryCapture = CStruct2[TSNode, uint32_t]
  object TSQueryCapture:
    given _tag: Tag[TSQueryCapture] = Tag.materializeCStruct2Tag[TSNode, uint32_t]
    def apply()(using Zone): Ptr[TSQueryCapture] = scala.scalanative.unsafe.alloc[TSQueryCapture](1)
    def apply(node : TSNode, index : uint32_t)(using Zone): Ptr[TSQueryCapture] = 
      val ____ptr = apply()
      (!____ptr).node = node
      (!____ptr).index = index
      ____ptr
    extension (struct: TSQueryCapture)
      def node : TSNode = struct._1
      def node_=(value: TSNode): Unit = !struct.at1 = value
      def index : uint32_t = struct._2
      def index_=(value: uint32_t): Unit = !struct.at2 = value

  opaque type TSQueryCursor = CStruct0
  object TSQueryCursor:
    given _tag: Tag[TSQueryCursor] = Tag.materializeCStruct0Tag

  opaque type TSQueryMatch = CStruct4[uint32_t, uint16_t, uint16_t, Ptr[TSQueryCapture]]
  object TSQueryMatch:
    given _tag: Tag[TSQueryMatch] = Tag.materializeCStruct4Tag[uint32_t, uint16_t, uint16_t, Ptr[TSQueryCapture]]
    def apply()(using Zone): Ptr[TSQueryMatch] = scala.scalanative.unsafe.alloc[TSQueryMatch](1)
    def apply(id : uint32_t, pattern_index : uint16_t, capture_count : uint16_t, captures : Ptr[TSQueryCapture])(using Zone): Ptr[TSQueryMatch] = 
      val ____ptr = apply()
      (!____ptr).id = id
      (!____ptr).pattern_index = pattern_index
      (!____ptr).capture_count = capture_count
      (!____ptr).captures = captures
      ____ptr
    extension (struct: TSQueryMatch)
      def id : uint32_t = struct._1
      def id_=(value: uint32_t): Unit = !struct.at1 = value
      def pattern_index : uint16_t = struct._2
      def pattern_index_=(value: uint16_t): Unit = !struct.at2 = value
      def capture_count : uint16_t = struct._3
      def capture_count_=(value: uint16_t): Unit = !struct.at3 = value
      def captures : Ptr[TSQueryCapture] = struct._4
      def captures_=(value: Ptr[TSQueryCapture]): Unit = !struct.at4 = value

  opaque type TSQueryPredicateStep = CStruct2[TSQueryPredicateStepType, uint32_t]
  object TSQueryPredicateStep:
    given _tag: Tag[TSQueryPredicateStep] = Tag.materializeCStruct2Tag[TSQueryPredicateStepType, uint32_t]
    def apply()(using Zone): Ptr[TSQueryPredicateStep] = scala.scalanative.unsafe.alloc[TSQueryPredicateStep](1)
    def apply(`type` : TSQueryPredicateStepType, value_id : uint32_t)(using Zone): Ptr[TSQueryPredicateStep] = 
      val ____ptr = apply()
      (!____ptr).`type` = `type`
      (!____ptr).value_id = value_id
      ____ptr
    extension (struct: TSQueryPredicateStep)
      def `type` : TSQueryPredicateStepType = struct._1
      def type_=(value: TSQueryPredicateStepType): Unit = !struct.at1 = value
      def value_id : uint32_t = struct._2
      def value_id_=(value: uint32_t): Unit = !struct.at2 = value

  opaque type TSRange = CStruct4[TSPoint, TSPoint, uint32_t, uint32_t]
  object TSRange:
    given _tag: Tag[TSRange] = Tag.materializeCStruct4Tag[TSPoint, TSPoint, uint32_t, uint32_t]
    def apply()(using Zone): Ptr[TSRange] = scala.scalanative.unsafe.alloc[TSRange](1)
    def apply(start_point : TSPoint, end_point : TSPoint, start_byte : uint32_t, end_byte : uint32_t)(using Zone): Ptr[TSRange] = 
      val ____ptr = apply()
      (!____ptr).start_point = start_point
      (!____ptr).end_point = end_point
      (!____ptr).start_byte = start_byte
      (!____ptr).end_byte = end_byte
      ____ptr
    extension (struct: TSRange)
      def start_point : TSPoint = struct._1
      def start_point_=(value: TSPoint): Unit = !struct.at1 = value
      def end_point : TSPoint = struct._2
      def end_point_=(value: TSPoint): Unit = !struct.at2 = value
      def start_byte : uint32_t = struct._3
      def start_byte_=(value: uint32_t): Unit = !struct.at3 = value
      def end_byte : uint32_t = struct._4
      def end_byte_=(value: uint32_t): Unit = !struct.at4 = value

  opaque type TSTree = CStruct0
  object TSTree:
    given _tag: Tag[TSTree] = Tag.materializeCStruct0Tag

  opaque type TSTreeCursor = CStruct3[Ptr[Byte], Ptr[Byte], CArray[uint32_t, Nat._2]]
  object TSTreeCursor:
    given _tag: Tag[TSTreeCursor] = Tag.materializeCStruct3Tag[Ptr[Byte], Ptr[Byte], CArray[uint32_t, Nat._2]]
    def apply()(using Zone): Ptr[TSTreeCursor] = scala.scalanative.unsafe.alloc[TSTreeCursor](1)
    def apply(tree : Ptr[Byte], id : Ptr[Byte], context : CArray[uint32_t, Nat._2])(using Zone): Ptr[TSTreeCursor] = 
      val ____ptr = apply()
      (!____ptr).tree = tree
      (!____ptr).id = id
      (!____ptr).context = context
      ____ptr
    extension (struct: TSTreeCursor)
      def tree : Ptr[Byte] = struct._1
      def tree_=(value: Ptr[Byte]): Unit = !struct.at1 = value
      def id : Ptr[Byte] = struct._2
      def id_=(value: Ptr[Byte]): Unit = !struct.at2 = value
      def context : CArray[uint32_t, Nat._2] = struct._3
      def context_=(value: CArray[uint32_t, Nat._2]): Unit = !struct.at3 = value


@extern
private[tree_sitter] object extern_functions:
  import _root_.tree_sitter.enumerations.*
  import _root_.tree_sitter.predef.*
  import _root_.tree_sitter.aliases.*
  import _root_.tree_sitter.structs.*
  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_child(_0 : Ptr[TSNode], _1 : uint32_t, __return : Ptr[TSNode]): Unit = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_child_by_field_id(_0 : Ptr[TSNode], _1 : TSFieldId, __return : Ptr[TSNode]): Unit = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_child_by_field_name(self : Ptr[TSNode], field_name : CString, field_name_length : uint32_t, __return : Ptr[TSNode]): Unit = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_child_count(_0 : Ptr[TSNode]): uint32_t = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_descendant_for_byte_range(_0 : Ptr[TSNode], _1 : uint32_t, _2 : uint32_t, __return : Ptr[TSNode]): Unit = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_descendant_for_point_range(_0 : Ptr[TSNode], _1 : Ptr[TSPoint], _2 : Ptr[TSPoint], __return : Ptr[TSNode]): Unit = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_end_byte(_0 : Ptr[TSNode]): uint32_t = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_end_point(_0 : Ptr[TSNode], __return : Ptr[TSPoint]): Unit = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_eq(_0 : Ptr[TSNode], _1 : Ptr[TSNode]): Boolean = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_field_name_for_child(_0 : Ptr[TSNode], _1 : uint32_t): CString = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_first_child_for_byte(_0 : Ptr[TSNode], _1 : uint32_t, __return : Ptr[TSNode]): Unit = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_first_named_child_for_byte(_0 : Ptr[TSNode], _1 : uint32_t, __return : Ptr[TSNode]): Unit = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_has_changes(_0 : Ptr[TSNode]): Boolean = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_has_error(_0 : Ptr[TSNode]): Boolean = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_is_extra(_0 : Ptr[TSNode]): Boolean = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_is_missing(_0 : Ptr[TSNode]): Boolean = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_is_named(_0 : Ptr[TSNode]): Boolean = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_is_null(_0 : Ptr[TSNode]): Boolean = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_named_child(_0 : Ptr[TSNode], _1 : uint32_t, __return : Ptr[TSNode]): Unit = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_named_child_count(_0 : Ptr[TSNode]): uint32_t = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_named_descendant_for_byte_range(_0 : Ptr[TSNode], _1 : uint32_t, _2 : uint32_t, __return : Ptr[TSNode]): Unit = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_named_descendant_for_point_range(_0 : Ptr[TSNode], _1 : Ptr[TSPoint], _2 : Ptr[TSPoint], __return : Ptr[TSNode]): Unit = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_next_named_sibling(_0 : Ptr[TSNode], __return : Ptr[TSNode]): Unit = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_next_sibling(_0 : Ptr[TSNode], __return : Ptr[TSNode]): Unit = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_parent(_0 : Ptr[TSNode], __return : Ptr[TSNode]): Unit = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_prev_named_sibling(_0 : Ptr[TSNode], __return : Ptr[TSNode]): Unit = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_prev_sibling(_0 : Ptr[TSNode], __return : Ptr[TSNode]): Unit = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_start_byte(_0 : Ptr[TSNode]): uint32_t = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_start_point(_0 : Ptr[TSNode], __return : Ptr[TSPoint]): Unit = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_string(_0 : Ptr[TSNode]): CString = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_symbol(_0 : Ptr[TSNode]): TSSymbol = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_node_type(_0 : Ptr[TSNode]): CString = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_parser_logger(self : Ptr[TSParser], __return : Ptr[TSLogger]): Unit = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_parser_parse(self : Ptr[TSParser], old_tree : Ptr[TSTree], input : Ptr[TSInput]): Ptr[TSTree] = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_parser_set_logger(self : Ptr[TSParser], logger : Ptr[TSLogger]): Unit = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_query_cursor_exec(_0 : Ptr[TSQueryCursor], _1 : Ptr[TSQuery], _2 : Ptr[TSNode]): Unit = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_query_cursor_set_point_range(_0 : Ptr[TSQueryCursor], _1 : Ptr[TSPoint], _2 : Ptr[TSPoint]): Unit = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_tree_cursor_copy(_0 : Ptr[TSTreeCursor], __return : Ptr[TSTreeCursor]): Unit = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_tree_cursor_current_node(_0 : Ptr[TSTreeCursor], __return : Ptr[TSNode]): Unit = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_tree_cursor_goto_first_child_for_point(_0 : Ptr[TSTreeCursor], _1 : Ptr[TSPoint]): int64_t = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_tree_cursor_new(_0 : Ptr[TSNode], __return : Ptr[TSTreeCursor]): Unit = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_tree_cursor_reset(_0 : Ptr[TSTreeCursor], _1 : Ptr[TSNode]): Unit = extern

  private[tree_sitter] def __sn_wrap_tree_sitter_ts_tree_root_node(self : Ptr[TSTree], __return : Ptr[TSNode]): Unit = extern

  /**
   * Get the number of distinct field names in the language.
  */
  def ts_language_field_count(_0 : Ptr[TSLanguage]): uint32_t = extern

  /**
   * Get the numerical id for the given field name string.
  */
  def ts_language_field_id_for_name(_0 : Ptr[TSLanguage], _1 : CString, _2 : uint32_t): TSFieldId = extern

  /**
   * Get the field name string for the given numerical id.
  */
  def ts_language_field_name_for_id(_0 : Ptr[TSLanguage], _1 : TSFieldId): CString = extern

  /**
   * Get the number of distinct node types in the language.
  */
  def ts_language_symbol_count(_0 : Ptr[TSLanguage]): uint32_t = extern

  /**
   * Get the numerical id for the given node type string.
  */
  def ts_language_symbol_for_name(self : Ptr[TSLanguage], string : CString, length : uint32_t, is_named : Boolean): TSSymbol = extern

  /**
   * Get a node type string for the given numerical id.
  */
  def ts_language_symbol_name(_0 : Ptr[TSLanguage], _1 : TSSymbol): CString = extern

  /**
   * Check whether the given node type id belongs to named nodes, anonymous nodes, or a hidden nodes.
  */
  def ts_language_symbol_type(_0 : Ptr[TSLanguage], _1 : TSSymbol): TSSymbolType = extern

  /**
   * Get the ABI version number for this language. This version number is used to ensure that languages were generated by a compatible version of Tree-sitter.
  */
  def ts_language_version(_0 : Ptr[TSLanguage]): uint32_t = extern

  /**
   * Edit the node to keep it in-sync with source code that has been edited.
  */
  def ts_node_edit(_0 : Ptr[TSNode], _1 : Ptr[TSInputEdit]): Unit = extern

  /**
   * Get the parser's current cancellation flag pointer.
  */
  def ts_parser_cancellation_flag(self : Ptr[TSParser]): Ptr[size_t] = extern

  /**
   * Delete the parser, freeing all of the memory that it used.
  */
  def ts_parser_delete(parser : Ptr[TSParser]): Unit = extern

  /**
   * Get the ranges of text that the parser will include when parsing.
  */
  def ts_parser_included_ranges(self : Ptr[TSParser], length : Ptr[uint32_t]): Ptr[TSRange] = extern

  /**
   * Get the parser's current language.
  */
  def ts_parser_language(self : Ptr[TSParser]): Ptr[TSLanguage] = extern

  /**
   * Create a new parser.
  */
  def ts_parser_new(): Ptr[TSParser] = extern

  /**
   * Use the parser to parse some source code stored in one contiguous buffer. The first two parameters are the same as in the `ts_parser_parse` function above. The second two parameters indicate the location of the buffer and its length in bytes.
  */
  def ts_parser_parse_string(self : Ptr[TSParser], old_tree : Ptr[TSTree], string : CString, length : uint32_t): Ptr[TSTree] = extern

  /**
   * Use the parser to parse some source code stored in one contiguous buffer with a given encoding. The first four parameters work the same as in the `ts_parser_parse_string` method above. The final parameter indicates whether the text is encoded as UTF8 or UTF16.
  */
  def ts_parser_parse_string_encoding(self : Ptr[TSParser], old_tree : Ptr[TSTree], string : CString, length : uint32_t, encoding : TSInputEncoding): Ptr[TSTree] = extern

  /**
   * Set the file descriptor to which the parser should write debugging graphs during parsing. The graphs are formatted in the DOT language. You may want to pipe these graphs directly to a `dot(1)` process in order to generate SVG output. You can turn off this logging by passing a negative number.
  */
  def ts_parser_print_dot_graphs(self : Ptr[TSParser], file : CInt): Unit = extern

  /**
   * Instruct the parser to start the next parse from the beginning.
  */
  def ts_parser_reset(self : Ptr[TSParser]): Unit = extern

  /**
   * Set the parser's current cancellation flag pointer.
  */
  def ts_parser_set_cancellation_flag(self : Ptr[TSParser], flag : Ptr[size_t]): Unit = extern

  /**
   * Set the ranges of text that the parser should include when parsing.
  */
  def ts_parser_set_included_ranges(self : Ptr[TSParser], ranges : Ptr[TSRange], length : uint32_t): Boolean = extern

  /**
   * Set the language that the parser should use for parsing.
  */
  def ts_parser_set_language(self : Ptr[TSParser], language : Ptr[TSLanguage]): Boolean = extern

  /**
   * Set the maximum duration in microseconds that parsing should be allowed to take before halting.
  */
  def ts_parser_set_timeout_micros(self : Ptr[TSParser], timeout : uint64_t): Unit = extern

  /**
   * Get the duration in microseconds that parsing is allowed to take.
  */
  def ts_parser_timeout_micros(self : Ptr[TSParser]): uint64_t = extern

  def ts_query_capture_count(_0 : Ptr[TSQuery]): uint32_t = extern

  /**
   * Get the name and length of one of the query's captures, or one of the query's string literals. Each capture and string is associated with a numeric id based on the order that it appeared in the query's source.
  */
  def ts_query_capture_name_for_id(_0 : Ptr[TSQuery], id : uint32_t, length : Ptr[uint32_t]): CString = extern

  /**
   * Get the quantifier of the query's captures. Each capture is * associated with a numeric id based on the order that it appeared in the query's source.
  */
  def ts_query_capture_quantifier_for_id(_0 : Ptr[TSQuery], pattern_id : uint32_t, capture_id : uint32_t): TSQuantifier = extern

  /**
   * Delete a query cursor, freeing all of the memory that it used.
  */
  def ts_query_cursor_delete(_0 : Ptr[TSQueryCursor]): Unit = extern

  /**
   * Manage the maximum number of in-progress matches allowed by this query cursor.
  */
  def ts_query_cursor_did_exceed_match_limit(_0 : Ptr[TSQueryCursor]): Boolean = extern

  def ts_query_cursor_match_limit(_0 : Ptr[TSQueryCursor]): uint32_t = extern

  /**
   * Create a new cursor for executing a given query.
  */
  def ts_query_cursor_new(): Ptr[TSQueryCursor] = extern

  /**
   * Advance to the next capture of the currently running query.
  */
  def ts_query_cursor_next_capture(_0 : Ptr[TSQueryCursor], `match` : Ptr[TSQueryMatch], capture_index : Ptr[uint32_t]): Boolean = extern

  /**
   * Advance to the next match of the currently running query.
  */
  def ts_query_cursor_next_match(_0 : Ptr[TSQueryCursor], `match` : Ptr[TSQueryMatch]): Boolean = extern

  def ts_query_cursor_remove_match(_0 : Ptr[TSQueryCursor], id : uint32_t): Unit = extern

  /**
   * Set the range of bytes or (row, column) positions in which the query will be executed.
  */
  def ts_query_cursor_set_byte_range(_0 : Ptr[TSQueryCursor], _1 : uint32_t, _2 : uint32_t): Unit = extern

  def ts_query_cursor_set_match_limit(_0 : Ptr[TSQueryCursor], _1 : uint32_t): Unit = extern

  /**
   * Delete a query, freeing all of the memory that it used.
  */
  def ts_query_delete(_0 : Ptr[TSQuery]): Unit = extern

  /**
   * Disable a certain capture within a query.
  */
  def ts_query_disable_capture(_0 : Ptr[TSQuery], _1 : CString, _2 : uint32_t): Unit = extern

  /**
   * Disable a certain pattern within a query.
  */
  def ts_query_disable_pattern(_0 : Ptr[TSQuery], _1 : uint32_t): Unit = extern

  def ts_query_is_pattern_guaranteed_at_step(self : Ptr[TSQuery], byte_offset : uint32_t): Boolean = extern

  /**
   * Create a new query from a string containing one or more S-expression patterns. The query is associated with a particular language, and can only be run on syntax nodes parsed with that language.
  */
  def ts_query_new(language : Ptr[TSLanguage], source : CString, source_len : uint32_t, error_offset : Ptr[uint32_t], error_type : Ptr[TSQueryError]): Ptr[TSQuery] = extern

  /**
   * Get the number of patterns, captures, or string literals in the query.
  */
  def ts_query_pattern_count(_0 : Ptr[TSQuery]): uint32_t = extern

  /**
   * Get all of the predicates for the given pattern in the query.
  */
  def ts_query_predicates_for_pattern(self : Ptr[TSQuery], pattern_index : uint32_t, length : Ptr[uint32_t]): Ptr[TSQueryPredicateStep] = extern

  /**
   * Get the byte offset where the given pattern starts in the query's source.
  */
  def ts_query_start_byte_for_pattern(_0 : Ptr[TSQuery], _1 : uint32_t): uint32_t = extern

  def ts_query_string_count(_0 : Ptr[TSQuery]): uint32_t = extern

  def ts_query_string_value_for_id(_0 : Ptr[TSQuery], id : uint32_t, length : Ptr[uint32_t]): CString = extern

  /**
   * Set the allocation functions used by the library.
  */
  def ts_set_allocator(new_malloc : CFuncPtr1[size_t, Ptr[Byte]], new_calloc : CFuncPtr2[size_t, size_t, Ptr[Byte]], new_realloc : CFuncPtr2[Ptr[Byte], size_t, Ptr[Byte]], new_free : CFuncPtr1[Ptr[Byte], Unit]): Unit = extern

  /**
   * Create a shallow copy of the syntax tree. This is very fast.
  */
  def ts_tree_copy(self : Ptr[TSTree]): Ptr[TSTree] = extern

  /**
   * Get the field id of the tree cursor's current node.
  */
  def ts_tree_cursor_current_field_id(_0 : Ptr[TSTreeCursor]): TSFieldId = extern

  /**
   * Get the field name of the tree cursor's current node.
  */
  def ts_tree_cursor_current_field_name(_0 : Ptr[TSTreeCursor]): CString = extern

  /**
   * Delete a tree cursor, freeing all of the memory that it used.
  */
  def ts_tree_cursor_delete(_0 : Ptr[TSTreeCursor]): Unit = extern

  /**
   * Move the cursor to the first child of its current node.
  */
  def ts_tree_cursor_goto_first_child(_0 : Ptr[TSTreeCursor]): Boolean = extern

  /**
   * Move the cursor to the first child of its current node that extends beyond the given byte offset or point.
  */
  def ts_tree_cursor_goto_first_child_for_byte(_0 : Ptr[TSTreeCursor], _1 : uint32_t): int64_t = extern

  /**
   * Move the cursor to the next sibling of its current node.
  */
  def ts_tree_cursor_goto_next_sibling(_0 : Ptr[TSTreeCursor]): Boolean = extern

  /**
   * Move the cursor to the parent of its current node.
  */
  def ts_tree_cursor_goto_parent(_0 : Ptr[TSTreeCursor]): Boolean = extern

  /**
   * Delete the syntax tree, freeing all of the memory that it used.
  */
  def ts_tree_delete(self : Ptr[TSTree]): Unit = extern

  /**
   * Edit the syntax tree to keep it in sync with source code that has been edited.
  */
  def ts_tree_edit(self : Ptr[TSTree], edit : Ptr[TSInputEdit]): Unit = extern

  /**
   * Compare an old edited syntax tree to a new syntax tree representing the same document, returning an array of ranges whose syntactic structure has changed.
  */
  def ts_tree_get_changed_ranges(old_tree : Ptr[TSTree], new_tree : Ptr[TSTree], length : Ptr[uint32_t]): Ptr[TSRange] = extern

  /**
   * Get the language that was used to parse the syntax tree.
  */
  def ts_tree_language(_0 : Ptr[TSTree]): Ptr[TSLanguage] = extern

  /**
   * Write a DOT graph describing the syntax tree to the given file.
  */
  def ts_tree_print_dot_graph(_0 : Ptr[TSTree], _1 : Ptr[FILE]): Unit = extern


object functions:
  import _root_.tree_sitter.enumerations.*
  import _root_.tree_sitter.predef.*
  import _root_.tree_sitter.aliases.*
  import _root_.tree_sitter.structs.*
  import extern_functions.*
  export extern_functions.*

  /**
   * Get the node's child at the given index, where zero represents the first child.
  */
  def ts_node_child(_0 : TSNode, _1 : uint32_t)(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](2)
    !(__ptr_0 + 0) = _0
    __sn_wrap_tree_sitter_ts_node_child((__ptr_0 + 0), _1, (__ptr_0 + 1))
    !(__ptr_0 + 1)

  /**
   * Get the node's child at the given index, where zero represents the first child.
  */
  def ts_node_child(_0 : Ptr[TSNode], _1 : uint32_t)(__return : Ptr[TSNode]): Unit = 
    __sn_wrap_tree_sitter_ts_node_child(_0, _1, __return)

  /**
   * Get the node's child at the given index, where zero represents the first child.
  */
  def ts_node_child(_0 : Ptr[TSNode], _1 : uint32_t)(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    __sn_wrap_tree_sitter_ts_node_child(_0, _1, (__ptr_0 + 0))
    !(__ptr_0 + 0)

  /**
   * Get the node's child with the given numerical field id.
  */
  def ts_node_child_by_field_id(_0 : Ptr[TSNode], _1 : TSFieldId)(__return : Ptr[TSNode]): Unit = 
    __sn_wrap_tree_sitter_ts_node_child_by_field_id(_0, _1, __return)

  /**
   * Get the node's child with the given numerical field id.
  */
  def ts_node_child_by_field_id(_0 : TSNode, _1 : TSFieldId)(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](2)
    !(__ptr_0 + 0) = _0
    __sn_wrap_tree_sitter_ts_node_child_by_field_id((__ptr_0 + 0), _1, (__ptr_0 + 1))
    !(__ptr_0 + 1)

  /**
   * Get the node's child with the given numerical field id.
  */
  def ts_node_child_by_field_id(_0 : Ptr[TSNode], _1 : TSFieldId)(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    __sn_wrap_tree_sitter_ts_node_child_by_field_id(_0, _1, (__ptr_0 + 0))
    !(__ptr_0 + 0)

  /**
   * Get the node's child with the given field name.
  */
  def ts_node_child_by_field_name(self : Ptr[TSNode], field_name : CString, field_name_length : uint32_t)(__return : Ptr[TSNode]): Unit = 
    __sn_wrap_tree_sitter_ts_node_child_by_field_name(self, field_name, field_name_length, __return)

  /**
   * Get the node's child with the given field name.
  */
  def ts_node_child_by_field_name(self : TSNode, field_name : CString, field_name_length : uint32_t)(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](2)
    !(__ptr_0 + 0) = self
    __sn_wrap_tree_sitter_ts_node_child_by_field_name((__ptr_0 + 0), field_name, field_name_length, (__ptr_0 + 1))
    !(__ptr_0 + 1)

  /**
   * Get the node's child with the given field name.
  */
  def ts_node_child_by_field_name(self : Ptr[TSNode], field_name : CString, field_name_length : uint32_t)(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    __sn_wrap_tree_sitter_ts_node_child_by_field_name(self, field_name, field_name_length, (__ptr_0 + 0))
    !(__ptr_0 + 0)

  /**
   * Get the node's number of children.
  */
  def ts_node_child_count(_0 : TSNode)(using Zone): uint32_t = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    !(__ptr_0 + 0) = _0
    __sn_wrap_tree_sitter_ts_node_child_count((__ptr_0 + 0))

  /**
   * Get the node's number of children.
  */
  def ts_node_child_count(_0 : Ptr[TSNode]): uint32_t = 
    __sn_wrap_tree_sitter_ts_node_child_count(_0)

  /**
   * Get the smallest node within this node that spans the given range of bytes or (row, column) positions.
  */
  def ts_node_descendant_for_byte_range(_0 : Ptr[TSNode], _1 : uint32_t, _2 : uint32_t)(__return : Ptr[TSNode]): Unit = 
    __sn_wrap_tree_sitter_ts_node_descendant_for_byte_range(_0, _1, _2, __return)

  /**
   * Get the smallest node within this node that spans the given range of bytes or (row, column) positions.
  */
  def ts_node_descendant_for_byte_range(_0 : TSNode, _1 : uint32_t, _2 : uint32_t)(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](2)
    !(__ptr_0 + 0) = _0
    __sn_wrap_tree_sitter_ts_node_descendant_for_byte_range((__ptr_0 + 0), _1, _2, (__ptr_0 + 1))
    !(__ptr_0 + 1)

  /**
   * Get the smallest node within this node that spans the given range of bytes or (row, column) positions.
  */
  def ts_node_descendant_for_byte_range(_0 : Ptr[TSNode], _1 : uint32_t, _2 : uint32_t)(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    __sn_wrap_tree_sitter_ts_node_descendant_for_byte_range(_0, _1, _2, (__ptr_0 + 0))
    !(__ptr_0 + 0)

  def ts_node_descendant_for_point_range(_0 : Ptr[TSNode], _1 : Ptr[TSPoint], _2 : Ptr[TSPoint])(__return : Ptr[TSNode]): Unit = 
    __sn_wrap_tree_sitter_ts_node_descendant_for_point_range(_0, _1, _2, __return)

  def ts_node_descendant_for_point_range(_0 : TSNode, _1 : TSPoint, _2 : TSPoint)(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](2)
    val __ptr_1: Ptr[TSPoint] = alloc[TSPoint](2)
    !(__ptr_0 + 0) = _0
    !(__ptr_1 + 0) = _1
    !(__ptr_1 + 1) = _2
    __sn_wrap_tree_sitter_ts_node_descendant_for_point_range((__ptr_0 + 0), (__ptr_1 + 0), (__ptr_1 + 1), (__ptr_0 + 1))
    !(__ptr_0 + 1)

  def ts_node_descendant_for_point_range(_0 : Ptr[TSNode], _1 : Ptr[TSPoint], _2 : Ptr[TSPoint])(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    __sn_wrap_tree_sitter_ts_node_descendant_for_point_range(_0, _1, _2, (__ptr_0 + 0))
    !(__ptr_0 + 0)

  /**
   * Get the node's end byte.
  */
  def ts_node_end_byte(_0 : Ptr[TSNode]): uint32_t = 
    __sn_wrap_tree_sitter_ts_node_end_byte(_0)

  /**
   * Get the node's end byte.
  */
  def ts_node_end_byte(_0 : TSNode)(using Zone): uint32_t = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    !(__ptr_0 + 0) = _0
    __sn_wrap_tree_sitter_ts_node_end_byte((__ptr_0 + 0))

  /**
   * Get the node's end position in terms of rows and columns.
  */
  def ts_node_end_point(_0 : Ptr[TSNode])(using Zone): TSPoint = 
    val __ptr_0: Ptr[TSPoint] = alloc[TSPoint](1)
    __sn_wrap_tree_sitter_ts_node_end_point(_0, (__ptr_0 + 0))
    !(__ptr_0 + 0)

  /**
   * Get the node's end position in terms of rows and columns.
  */
  def ts_node_end_point(_0 : Ptr[TSNode])(__return : Ptr[TSPoint]): Unit = 
    __sn_wrap_tree_sitter_ts_node_end_point(_0, __return)

  /**
   * Get the node's end position in terms of rows and columns.
  */
  def ts_node_end_point(_0 : TSNode)(using Zone): TSPoint = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    val __ptr_1: Ptr[TSPoint] = alloc[TSPoint](1)
    !(__ptr_0 + 0) = _0
    __sn_wrap_tree_sitter_ts_node_end_point((__ptr_0 + 0), (__ptr_1 + 0))
    !(__ptr_1 + 0)

  /**
   * Check if two nodes are identical.
  */
  def ts_node_eq(_0 : Ptr[TSNode], _1 : Ptr[TSNode]): Boolean = 
    __sn_wrap_tree_sitter_ts_node_eq(_0, _1)

  /**
   * Check if two nodes are identical.
  */
  def ts_node_eq(_0 : TSNode, _1 : TSNode)(using Zone): Boolean = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](2)
    !(__ptr_0 + 0) = _0
    !(__ptr_0 + 1) = _1
    __sn_wrap_tree_sitter_ts_node_eq((__ptr_0 + 0), (__ptr_0 + 1))

  /**
   * Get the field name for node's child at the given index, where zero represents the first child. Returns NULL, if no field is found.
  */
  def ts_node_field_name_for_child(_0 : TSNode, _1 : uint32_t)(using Zone): CString = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    !(__ptr_0 + 0) = _0
    __sn_wrap_tree_sitter_ts_node_field_name_for_child((__ptr_0 + 0), _1)

  /**
   * Get the field name for node's child at the given index, where zero represents the first child. Returns NULL, if no field is found.
  */
  def ts_node_field_name_for_child(_0 : Ptr[TSNode], _1 : uint32_t): CString = 
    __sn_wrap_tree_sitter_ts_node_field_name_for_child(_0, _1)

  /**
   * Get the node's first child that extends beyond the given byte offset.
  */
  def ts_node_first_child_for_byte(_0 : Ptr[TSNode], _1 : uint32_t)(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    __sn_wrap_tree_sitter_ts_node_first_child_for_byte(_0, _1, (__ptr_0 + 0))
    !(__ptr_0 + 0)

  /**
   * Get the node's first child that extends beyond the given byte offset.
  */
  def ts_node_first_child_for_byte(_0 : TSNode, _1 : uint32_t)(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](2)
    !(__ptr_0 + 0) = _0
    __sn_wrap_tree_sitter_ts_node_first_child_for_byte((__ptr_0 + 0), _1, (__ptr_0 + 1))
    !(__ptr_0 + 1)

  /**
   * Get the node's first child that extends beyond the given byte offset.
  */
  def ts_node_first_child_for_byte(_0 : Ptr[TSNode], _1 : uint32_t)(__return : Ptr[TSNode]): Unit = 
    __sn_wrap_tree_sitter_ts_node_first_child_for_byte(_0, _1, __return)

  /**
   * Get the node's first named child that extends beyond the given byte offset.
  */
  def ts_node_first_named_child_for_byte(_0 : TSNode, _1 : uint32_t)(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](2)
    !(__ptr_0 + 0) = _0
    __sn_wrap_tree_sitter_ts_node_first_named_child_for_byte((__ptr_0 + 0), _1, (__ptr_0 + 1))
    !(__ptr_0 + 1)

  /**
   * Get the node's first named child that extends beyond the given byte offset.
  */
  def ts_node_first_named_child_for_byte(_0 : Ptr[TSNode], _1 : uint32_t)(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    __sn_wrap_tree_sitter_ts_node_first_named_child_for_byte(_0, _1, (__ptr_0 + 0))
    !(__ptr_0 + 0)

  /**
   * Get the node's first named child that extends beyond the given byte offset.
  */
  def ts_node_first_named_child_for_byte(_0 : Ptr[TSNode], _1 : uint32_t)(__return : Ptr[TSNode]): Unit = 
    __sn_wrap_tree_sitter_ts_node_first_named_child_for_byte(_0, _1, __return)

  /**
   * Check if a syntax node has been edited.
  */
  def ts_node_has_changes(_0 : Ptr[TSNode]): Boolean = 
    __sn_wrap_tree_sitter_ts_node_has_changes(_0)

  /**
   * Check if a syntax node has been edited.
  */
  def ts_node_has_changes(_0 : TSNode)(using Zone): Boolean = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    !(__ptr_0 + 0) = _0
    __sn_wrap_tree_sitter_ts_node_has_changes((__ptr_0 + 0))

  /**
   * Check if the node is a syntax error or contains any syntax errors.
  */
  def ts_node_has_error(_0 : TSNode)(using Zone): Boolean = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    !(__ptr_0 + 0) = _0
    __sn_wrap_tree_sitter_ts_node_has_error((__ptr_0 + 0))

  /**
   * Check if the node is a syntax error or contains any syntax errors.
  */
  def ts_node_has_error(_0 : Ptr[TSNode]): Boolean = 
    __sn_wrap_tree_sitter_ts_node_has_error(_0)

  /**
   * Check if the node is *extra*. Extra nodes represent things like comments, which are not required the grammar, but can appear anywhere.
  */
  def ts_node_is_extra(_0 : Ptr[TSNode]): Boolean = 
    __sn_wrap_tree_sitter_ts_node_is_extra(_0)

  /**
   * Check if the node is *extra*. Extra nodes represent things like comments, which are not required the grammar, but can appear anywhere.
  */
  def ts_node_is_extra(_0 : TSNode)(using Zone): Boolean = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    !(__ptr_0 + 0) = _0
    __sn_wrap_tree_sitter_ts_node_is_extra((__ptr_0 + 0))

  /**
   * Check if the node is *missing*. Missing nodes are inserted by the parser in order to recover from certain kinds of syntax errors.
  */
  def ts_node_is_missing(_0 : Ptr[TSNode]): Boolean = 
    __sn_wrap_tree_sitter_ts_node_is_missing(_0)

  /**
   * Check if the node is *missing*. Missing nodes are inserted by the parser in order to recover from certain kinds of syntax errors.
  */
  def ts_node_is_missing(_0 : TSNode)(using Zone): Boolean = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    !(__ptr_0 + 0) = _0
    __sn_wrap_tree_sitter_ts_node_is_missing((__ptr_0 + 0))

  /**
   * Check if the node is *named*. Named nodes correspond to named rules in the grammar, whereas *anonymous* nodes correspond to string literals in the grammar.
  */
  def ts_node_is_named(_0 : TSNode)(using Zone): Boolean = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    !(__ptr_0 + 0) = _0
    __sn_wrap_tree_sitter_ts_node_is_named((__ptr_0 + 0))

  /**
   * Check if the node is *named*. Named nodes correspond to named rules in the grammar, whereas *anonymous* nodes correspond to string literals in the grammar.
  */
  def ts_node_is_named(_0 : Ptr[TSNode]): Boolean = 
    __sn_wrap_tree_sitter_ts_node_is_named(_0)

  /**
   * Check if the node is null. Functions like `ts_node_child` and `ts_node_next_sibling` will return a null node to indicate that no such node was found.
  */
  def ts_node_is_null(_0 : TSNode)(using Zone): Boolean = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    !(__ptr_0 + 0) = _0
    __sn_wrap_tree_sitter_ts_node_is_null((__ptr_0 + 0))

  /**
   * Check if the node is null. Functions like `ts_node_child` and `ts_node_next_sibling` will return a null node to indicate that no such node was found.
  */
  def ts_node_is_null(_0 : Ptr[TSNode]): Boolean = 
    __sn_wrap_tree_sitter_ts_node_is_null(_0)

  /**
   * Get the node's *named* child at the given index.
  */
  def ts_node_named_child(_0 : TSNode, _1 : uint32_t)(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](2)
    !(__ptr_0 + 0) = _0
    __sn_wrap_tree_sitter_ts_node_named_child((__ptr_0 + 0), _1, (__ptr_0 + 1))
    !(__ptr_0 + 1)

  /**
   * Get the node's *named* child at the given index.
  */
  def ts_node_named_child(_0 : Ptr[TSNode], _1 : uint32_t)(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    __sn_wrap_tree_sitter_ts_node_named_child(_0, _1, (__ptr_0 + 0))
    !(__ptr_0 + 0)

  /**
   * Get the node's *named* child at the given index.
  */
  def ts_node_named_child(_0 : Ptr[TSNode], _1 : uint32_t)(__return : Ptr[TSNode]): Unit = 
    __sn_wrap_tree_sitter_ts_node_named_child(_0, _1, __return)

  /**
   * Get the node's number of *named* children.
  */
  def ts_node_named_child_count(_0 : Ptr[TSNode]): uint32_t = 
    __sn_wrap_tree_sitter_ts_node_named_child_count(_0)

  /**
   * Get the node's number of *named* children.
  */
  def ts_node_named_child_count(_0 : TSNode)(using Zone): uint32_t = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    !(__ptr_0 + 0) = _0
    __sn_wrap_tree_sitter_ts_node_named_child_count((__ptr_0 + 0))

  /**
   * Get the smallest named node within this node that spans the given range of bytes or (row, column) positions.
  */
  def ts_node_named_descendant_for_byte_range(_0 : TSNode, _1 : uint32_t, _2 : uint32_t)(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](2)
    !(__ptr_0 + 0) = _0
    __sn_wrap_tree_sitter_ts_node_named_descendant_for_byte_range((__ptr_0 + 0), _1, _2, (__ptr_0 + 1))
    !(__ptr_0 + 1)

  /**
   * Get the smallest named node within this node that spans the given range of bytes or (row, column) positions.
  */
  def ts_node_named_descendant_for_byte_range(_0 : Ptr[TSNode], _1 : uint32_t, _2 : uint32_t)(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    __sn_wrap_tree_sitter_ts_node_named_descendant_for_byte_range(_0, _1, _2, (__ptr_0 + 0))
    !(__ptr_0 + 0)

  /**
   * Get the smallest named node within this node that spans the given range of bytes or (row, column) positions.
  */
  def ts_node_named_descendant_for_byte_range(_0 : Ptr[TSNode], _1 : uint32_t, _2 : uint32_t)(__return : Ptr[TSNode]): Unit = 
    __sn_wrap_tree_sitter_ts_node_named_descendant_for_byte_range(_0, _1, _2, __return)

  def ts_node_named_descendant_for_point_range(_0 : TSNode, _1 : TSPoint, _2 : TSPoint)(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](2)
    val __ptr_1: Ptr[TSPoint] = alloc[TSPoint](2)
    !(__ptr_0 + 0) = _0
    !(__ptr_1 + 0) = _1
    !(__ptr_1 + 1) = _2
    __sn_wrap_tree_sitter_ts_node_named_descendant_for_point_range((__ptr_0 + 0), (__ptr_1 + 0), (__ptr_1 + 1), (__ptr_0 + 1))
    !(__ptr_0 + 1)

  def ts_node_named_descendant_for_point_range(_0 : Ptr[TSNode], _1 : Ptr[TSPoint], _2 : Ptr[TSPoint])(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    __sn_wrap_tree_sitter_ts_node_named_descendant_for_point_range(_0, _1, _2, (__ptr_0 + 0))
    !(__ptr_0 + 0)

  def ts_node_named_descendant_for_point_range(_0 : Ptr[TSNode], _1 : Ptr[TSPoint], _2 : Ptr[TSPoint])(__return : Ptr[TSNode]): Unit = 
    __sn_wrap_tree_sitter_ts_node_named_descendant_for_point_range(_0, _1, _2, __return)

  /**
   * Get the node's next / previous *named* sibling.
  */
  def ts_node_next_named_sibling(_0 : Ptr[TSNode])(__return : Ptr[TSNode]): Unit = 
    __sn_wrap_tree_sitter_ts_node_next_named_sibling(_0, __return)

  /**
   * Get the node's next / previous *named* sibling.
  */
  def ts_node_next_named_sibling(_0 : TSNode)(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](2)
    !(__ptr_0 + 0) = _0
    __sn_wrap_tree_sitter_ts_node_next_named_sibling((__ptr_0 + 0), (__ptr_0 + 1))
    !(__ptr_0 + 1)

  /**
   * Get the node's next / previous *named* sibling.
  */
  def ts_node_next_named_sibling(_0 : Ptr[TSNode])(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    __sn_wrap_tree_sitter_ts_node_next_named_sibling(_0, (__ptr_0 + 0))
    !(__ptr_0 + 0)

  /**
   * Get the node's next / previous sibling.
  */
  def ts_node_next_sibling(_0 : Ptr[TSNode])(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    __sn_wrap_tree_sitter_ts_node_next_sibling(_0, (__ptr_0 + 0))
    !(__ptr_0 + 0)

  /**
   * Get the node's next / previous sibling.
  */
  def ts_node_next_sibling(_0 : TSNode)(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](2)
    !(__ptr_0 + 0) = _0
    __sn_wrap_tree_sitter_ts_node_next_sibling((__ptr_0 + 0), (__ptr_0 + 1))
    !(__ptr_0 + 1)

  /**
   * Get the node's next / previous sibling.
  */
  def ts_node_next_sibling(_0 : Ptr[TSNode])(__return : Ptr[TSNode]): Unit = 
    __sn_wrap_tree_sitter_ts_node_next_sibling(_0, __return)

  /**
   * Get the node's immediate parent.
  */
  def ts_node_parent(_0 : Ptr[TSNode])(__return : Ptr[TSNode]): Unit = 
    __sn_wrap_tree_sitter_ts_node_parent(_0, __return)

  /**
   * Get the node's immediate parent.
  */
  def ts_node_parent(_0 : Ptr[TSNode])(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    __sn_wrap_tree_sitter_ts_node_parent(_0, (__ptr_0 + 0))
    !(__ptr_0 + 0)

  /**
   * Get the node's immediate parent.
  */
  def ts_node_parent(_0 : TSNode)(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](2)
    !(__ptr_0 + 0) = _0
    __sn_wrap_tree_sitter_ts_node_parent((__ptr_0 + 0), (__ptr_0 + 1))
    !(__ptr_0 + 1)

  def ts_node_prev_named_sibling(_0 : Ptr[TSNode])(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    __sn_wrap_tree_sitter_ts_node_prev_named_sibling(_0, (__ptr_0 + 0))
    !(__ptr_0 + 0)

  def ts_node_prev_named_sibling(_0 : Ptr[TSNode])(__return : Ptr[TSNode]): Unit = 
    __sn_wrap_tree_sitter_ts_node_prev_named_sibling(_0, __return)

  def ts_node_prev_named_sibling(_0 : TSNode)(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](2)
    !(__ptr_0 + 0) = _0
    __sn_wrap_tree_sitter_ts_node_prev_named_sibling((__ptr_0 + 0), (__ptr_0 + 1))
    !(__ptr_0 + 1)

  def ts_node_prev_sibling(_0 : TSNode)(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](2)
    !(__ptr_0 + 0) = _0
    __sn_wrap_tree_sitter_ts_node_prev_sibling((__ptr_0 + 0), (__ptr_0 + 1))
    !(__ptr_0 + 1)

  def ts_node_prev_sibling(_0 : Ptr[TSNode])(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    __sn_wrap_tree_sitter_ts_node_prev_sibling(_0, (__ptr_0 + 0))
    !(__ptr_0 + 0)

  def ts_node_prev_sibling(_0 : Ptr[TSNode])(__return : Ptr[TSNode]): Unit = 
    __sn_wrap_tree_sitter_ts_node_prev_sibling(_0, __return)

  /**
   * Get the node's start byte.
  */
  def ts_node_start_byte(_0 : Ptr[TSNode]): uint32_t = 
    __sn_wrap_tree_sitter_ts_node_start_byte(_0)

  /**
   * Get the node's start byte.
  */
  def ts_node_start_byte(_0 : TSNode)(using Zone): uint32_t = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    !(__ptr_0 + 0) = _0
    __sn_wrap_tree_sitter_ts_node_start_byte((__ptr_0 + 0))

  /**
   * Get the node's start position in terms of rows and columns.
  */
  def ts_node_start_point(_0 : TSNode)(using Zone): TSPoint = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    val __ptr_1: Ptr[TSPoint] = alloc[TSPoint](1)
    !(__ptr_0 + 0) = _0
    __sn_wrap_tree_sitter_ts_node_start_point((__ptr_0 + 0), (__ptr_1 + 0))
    !(__ptr_1 + 0)

  /**
   * Get the node's start position in terms of rows and columns.
  */
  def ts_node_start_point(_0 : Ptr[TSNode])(__return : Ptr[TSPoint]): Unit = 
    __sn_wrap_tree_sitter_ts_node_start_point(_0, __return)

  /**
   * Get the node's start position in terms of rows and columns.
  */
  def ts_node_start_point(_0 : Ptr[TSNode])(using Zone): TSPoint = 
    val __ptr_0: Ptr[TSPoint] = alloc[TSPoint](1)
    __sn_wrap_tree_sitter_ts_node_start_point(_0, (__ptr_0 + 0))
    !(__ptr_0 + 0)

  /**
   * Get an S-expression representing the node as a string.
  */
  def ts_node_string(_0 : Ptr[TSNode]): CString = 
    __sn_wrap_tree_sitter_ts_node_string(_0)

  /**
   * Get an S-expression representing the node as a string.
  */
  def ts_node_string(_0 : TSNode)(using Zone): CString = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    !(__ptr_0 + 0) = _0
    __sn_wrap_tree_sitter_ts_node_string((__ptr_0 + 0))

  /**
   * Get the node's type as a numerical id.
  */
  def ts_node_symbol(_0 : Ptr[TSNode]): TSSymbol = 
    __sn_wrap_tree_sitter_ts_node_symbol(_0)

  /**
   * Get the node's type as a numerical id.
  */
  def ts_node_symbol(_0 : TSNode)(using Zone): TSSymbol = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    !(__ptr_0 + 0) = _0
    __sn_wrap_tree_sitter_ts_node_symbol((__ptr_0 + 0))

  /**
   * Get the node's type as a null-terminated string.
  */
  def ts_node_type(_0 : Ptr[TSNode]): CString = 
    __sn_wrap_tree_sitter_ts_node_type(_0)

  /**
   * Get the node's type as a null-terminated string.
  */
  def ts_node_type(_0 : TSNode)(using Zone): CString = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    !(__ptr_0 + 0) = _0
    __sn_wrap_tree_sitter_ts_node_type((__ptr_0 + 0))

  /**
   * Get the parser's current logger.
  */
  def ts_parser_logger(self : Ptr[TSParser])(__return : Ptr[TSLogger]): Unit = 
    __sn_wrap_tree_sitter_ts_parser_logger(self, __return)

  /**
   * Get the parser's current logger.
  */
  def ts_parser_logger(self : Ptr[TSParser])(using Zone): TSLogger = 
    val __ptr_0: Ptr[TSLogger] = alloc[TSLogger](1)
    __sn_wrap_tree_sitter_ts_parser_logger(self, (__ptr_0 + 0))
    !(__ptr_0 + 0)

  /**
   * Use the parser to parse some source code and create a syntax tree.
  */
  def ts_parser_parse(self : Ptr[TSParser], old_tree : Ptr[TSTree], input : Ptr[TSInput]): Ptr[TSTree] = 
    __sn_wrap_tree_sitter_ts_parser_parse(self, old_tree, input)

  /**
   * Use the parser to parse some source code and create a syntax tree.
  */
  def ts_parser_parse(self : Ptr[TSParser], old_tree : Ptr[TSTree], input : TSInput)(using Zone): Ptr[TSTree] = 
    val __ptr_0: Ptr[TSInput] = alloc[TSInput](1)
    !(__ptr_0 + 0) = input
    __sn_wrap_tree_sitter_ts_parser_parse(self, old_tree, (__ptr_0 + 0))

  /**
   * Set the logger that a parser should use during parsing.
  */
  def ts_parser_set_logger(self : Ptr[TSParser], logger : TSLogger)(using Zone): Unit = 
    val __ptr_0: Ptr[TSLogger] = alloc[TSLogger](1)
    !(__ptr_0 + 0) = logger
    __sn_wrap_tree_sitter_ts_parser_set_logger(self, (__ptr_0 + 0))

  /**
   * Set the logger that a parser should use during parsing.
  */
  def ts_parser_set_logger(self : Ptr[TSParser], logger : Ptr[TSLogger]): Unit = 
    __sn_wrap_tree_sitter_ts_parser_set_logger(self, logger)

  /**
   * Start running a given query on a given node.
  */
  def ts_query_cursor_exec(_0 : Ptr[TSQueryCursor], _1 : Ptr[TSQuery], _2 : Ptr[TSNode]): Unit = 
    __sn_wrap_tree_sitter_ts_query_cursor_exec(_0, _1, _2)

  /**
   * Start running a given query on a given node.
  */
  def ts_query_cursor_exec(_0 : Ptr[TSQueryCursor], _1 : Ptr[TSQuery], _2 : TSNode)(using Zone): Unit = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    !(__ptr_0 + 0) = _2
    __sn_wrap_tree_sitter_ts_query_cursor_exec(_0, _1, (__ptr_0 + 0))

  def ts_query_cursor_set_point_range(_0 : Ptr[TSQueryCursor], _1 : Ptr[TSPoint], _2 : Ptr[TSPoint]): Unit = 
    __sn_wrap_tree_sitter_ts_query_cursor_set_point_range(_0, _1, _2)

  def ts_query_cursor_set_point_range(_0 : Ptr[TSQueryCursor], _1 : TSPoint, _2 : TSPoint)(using Zone): Unit = 
    val __ptr_0: Ptr[TSPoint] = alloc[TSPoint](2)
    !(__ptr_0 + 0) = _1
    !(__ptr_0 + 1) = _2
    __sn_wrap_tree_sitter_ts_query_cursor_set_point_range(_0, (__ptr_0 + 0), (__ptr_0 + 1))

  def ts_tree_cursor_copy(_0 : Ptr[TSTreeCursor])(using Zone): TSTreeCursor = 
    val __ptr_0: Ptr[TSTreeCursor] = alloc[TSTreeCursor](1)
    __sn_wrap_tree_sitter_ts_tree_cursor_copy(_0, (__ptr_0 + 0))
    !(__ptr_0 + 0)

  def ts_tree_cursor_copy(_0 : Ptr[TSTreeCursor])(__return : Ptr[TSTreeCursor]): Unit = 
    __sn_wrap_tree_sitter_ts_tree_cursor_copy(_0, __return)

  /**
   * Get the tree cursor's current node.
  */
  def ts_tree_cursor_current_node(_0 : Ptr[TSTreeCursor])(__return : Ptr[TSNode]): Unit = 
    __sn_wrap_tree_sitter_ts_tree_cursor_current_node(_0, __return)

  /**
   * Get the tree cursor's current node.
  */
  def ts_tree_cursor_current_node(_0 : Ptr[TSTreeCursor])(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    __sn_wrap_tree_sitter_ts_tree_cursor_current_node(_0, (__ptr_0 + 0))
    !(__ptr_0 + 0)

  def ts_tree_cursor_goto_first_child_for_point(_0 : Ptr[TSTreeCursor], _1 : Ptr[TSPoint]): int64_t = 
    __sn_wrap_tree_sitter_ts_tree_cursor_goto_first_child_for_point(_0, _1)

  def ts_tree_cursor_goto_first_child_for_point(_0 : Ptr[TSTreeCursor], _1 : TSPoint)(using Zone): int64_t = 
    val __ptr_0: Ptr[TSPoint] = alloc[TSPoint](1)
    !(__ptr_0 + 0) = _1
    __sn_wrap_tree_sitter_ts_tree_cursor_goto_first_child_for_point(_0, (__ptr_0 + 0))

  /**
   * Create a new tree cursor starting from the given node.
  */
  def ts_tree_cursor_new(_0 : TSNode)(using Zone): TSTreeCursor = 
    val __ptr_0: Ptr[TSTreeCursor] = alloc[TSTreeCursor](1)
    val __ptr_1: Ptr[TSNode] = alloc[TSNode](1)
    !(__ptr_1 + 0) = _0
    __sn_wrap_tree_sitter_ts_tree_cursor_new((__ptr_1 + 0), (__ptr_0 + 0))
    !(__ptr_0 + 0)

  /**
   * Create a new tree cursor starting from the given node.
  */
  def ts_tree_cursor_new(_0 : Ptr[TSNode])(using Zone): TSTreeCursor = 
    val __ptr_0: Ptr[TSTreeCursor] = alloc[TSTreeCursor](1)
    __sn_wrap_tree_sitter_ts_tree_cursor_new(_0, (__ptr_0 + 0))
    !(__ptr_0 + 0)

  /**
   * Create a new tree cursor starting from the given node.
  */
  def ts_tree_cursor_new(_0 : Ptr[TSNode])(__return : Ptr[TSTreeCursor]): Unit = 
    __sn_wrap_tree_sitter_ts_tree_cursor_new(_0, __return)

  /**
   * Re-initialize a tree cursor to start at a different node.
  */
  def ts_tree_cursor_reset(_0 : Ptr[TSTreeCursor], _1 : TSNode)(using Zone): Unit = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    !(__ptr_0 + 0) = _1
    __sn_wrap_tree_sitter_ts_tree_cursor_reset(_0, (__ptr_0 + 0))

  /**
   * Re-initialize a tree cursor to start at a different node.
  */
  def ts_tree_cursor_reset(_0 : Ptr[TSTreeCursor], _1 : Ptr[TSNode]): Unit = 
    __sn_wrap_tree_sitter_ts_tree_cursor_reset(_0, _1)

  /**
   * Get the root node of the syntax tree.
  */
  def ts_tree_root_node(self : Ptr[TSTree])(using Zone): TSNode = 
    val __ptr_0: Ptr[TSNode] = alloc[TSNode](1)
    __sn_wrap_tree_sitter_ts_tree_root_node(self, (__ptr_0 + 0))
    !(__ptr_0 + 0)

  /**
   * Get the root node of the syntax tree.
  */
  def ts_tree_root_node(self : Ptr[TSTree])(__return : Ptr[TSNode]): Unit = 
    __sn_wrap_tree_sitter_ts_tree_root_node(self, __return)

object types:
  export _root_.tree_sitter.structs.*
  export _root_.tree_sitter.aliases.*
  export _root_.tree_sitter.enumerations.*

object all:
  export _root_.tree_sitter.enumerations.TSInputEncoding
  export _root_.tree_sitter.enumerations.TSLogType
  export _root_.tree_sitter.enumerations.TSQuantifier
  export _root_.tree_sitter.enumerations.TSQueryError
  export _root_.tree_sitter.enumerations.TSQueryPredicateStepType
  export _root_.tree_sitter.enumerations.TSSymbolType
  export _root_.tree_sitter.aliases.FILE
  export _root_.tree_sitter.aliases.TSFieldId
  export _root_.tree_sitter.aliases.TSSymbol
  export _root_.tree_sitter.aliases.int64_t
  export _root_.tree_sitter.aliases.size_t
  export _root_.tree_sitter.aliases.uint16_t
  export _root_.tree_sitter.aliases.uint32_t
  export _root_.tree_sitter.aliases.uint64_t
  export _root_.tree_sitter.structs.TSInput
  export _root_.tree_sitter.structs.TSInputEdit
  export _root_.tree_sitter.structs.TSLanguage
  export _root_.tree_sitter.structs.TSLogger
  export _root_.tree_sitter.structs.TSNode
  export _root_.tree_sitter.structs.TSParser
  export _root_.tree_sitter.structs.TSPoint
  export _root_.tree_sitter.structs.TSQuery
  export _root_.tree_sitter.structs.TSQueryCapture
  export _root_.tree_sitter.structs.TSQueryCursor
  export _root_.tree_sitter.structs.TSQueryMatch
  export _root_.tree_sitter.structs.TSQueryPredicateStep
  export _root_.tree_sitter.structs.TSRange
  export _root_.tree_sitter.structs.TSTree
  export _root_.tree_sitter.structs.TSTreeCursor
  export _root_.tree_sitter.functions.ts_language_field_count
  export _root_.tree_sitter.functions.ts_language_field_id_for_name
  export _root_.tree_sitter.functions.ts_language_field_name_for_id
  export _root_.tree_sitter.functions.ts_language_symbol_count
  export _root_.tree_sitter.functions.ts_language_symbol_for_name
  export _root_.tree_sitter.functions.ts_language_symbol_name
  export _root_.tree_sitter.functions.ts_language_symbol_type
  export _root_.tree_sitter.functions.ts_language_version
  export _root_.tree_sitter.functions.ts_node_edit
  export _root_.tree_sitter.functions.ts_parser_cancellation_flag
  export _root_.tree_sitter.functions.ts_parser_delete
  export _root_.tree_sitter.functions.ts_parser_included_ranges
  export _root_.tree_sitter.functions.ts_parser_language
  export _root_.tree_sitter.functions.ts_parser_new
  export _root_.tree_sitter.functions.ts_parser_parse_string
  export _root_.tree_sitter.functions.ts_parser_parse_string_encoding
  export _root_.tree_sitter.functions.ts_parser_print_dot_graphs
  export _root_.tree_sitter.functions.ts_parser_reset
  export _root_.tree_sitter.functions.ts_parser_set_cancellation_flag
  export _root_.tree_sitter.functions.ts_parser_set_included_ranges
  export _root_.tree_sitter.functions.ts_parser_set_language
  export _root_.tree_sitter.functions.ts_parser_set_timeout_micros
  export _root_.tree_sitter.functions.ts_parser_timeout_micros
  export _root_.tree_sitter.functions.ts_query_capture_count
  export _root_.tree_sitter.functions.ts_query_capture_name_for_id
  export _root_.tree_sitter.functions.ts_query_capture_quantifier_for_id
  export _root_.tree_sitter.functions.ts_query_cursor_delete
  export _root_.tree_sitter.functions.ts_query_cursor_did_exceed_match_limit
  export _root_.tree_sitter.functions.ts_query_cursor_match_limit
  export _root_.tree_sitter.functions.ts_query_cursor_new
  export _root_.tree_sitter.functions.ts_query_cursor_next_capture
  export _root_.tree_sitter.functions.ts_query_cursor_next_match
  export _root_.tree_sitter.functions.ts_query_cursor_remove_match
  export _root_.tree_sitter.functions.ts_query_cursor_set_byte_range
  export _root_.tree_sitter.functions.ts_query_cursor_set_match_limit
  export _root_.tree_sitter.functions.ts_query_delete
  export _root_.tree_sitter.functions.ts_query_disable_capture
  export _root_.tree_sitter.functions.ts_query_disable_pattern
  export _root_.tree_sitter.functions.ts_query_is_pattern_guaranteed_at_step
  export _root_.tree_sitter.functions.ts_query_new
  export _root_.tree_sitter.functions.ts_query_pattern_count
  export _root_.tree_sitter.functions.ts_query_predicates_for_pattern
  export _root_.tree_sitter.functions.ts_query_start_byte_for_pattern
  export _root_.tree_sitter.functions.ts_query_string_count
  export _root_.tree_sitter.functions.ts_query_string_value_for_id
  export _root_.tree_sitter.functions.ts_set_allocator
  export _root_.tree_sitter.functions.ts_tree_copy
  export _root_.tree_sitter.functions.ts_tree_cursor_current_field_id
  export _root_.tree_sitter.functions.ts_tree_cursor_current_field_name
  export _root_.tree_sitter.functions.ts_tree_cursor_delete
  export _root_.tree_sitter.functions.ts_tree_cursor_goto_first_child
  export _root_.tree_sitter.functions.ts_tree_cursor_goto_first_child_for_byte
  export _root_.tree_sitter.functions.ts_tree_cursor_goto_next_sibling
  export _root_.tree_sitter.functions.ts_tree_cursor_goto_parent
  export _root_.tree_sitter.functions.ts_tree_delete
  export _root_.tree_sitter.functions.ts_tree_edit
  export _root_.tree_sitter.functions.ts_tree_get_changed_ranges
  export _root_.tree_sitter.functions.ts_tree_language
  export _root_.tree_sitter.functions.ts_tree_print_dot_graph
  export _root_.tree_sitter.functions.ts_node_child
  export _root_.tree_sitter.functions.ts_node_child_by_field_id
  export _root_.tree_sitter.functions.ts_node_child_by_field_name
  export _root_.tree_sitter.functions.ts_node_child_count
  export _root_.tree_sitter.functions.ts_node_descendant_for_byte_range
  export _root_.tree_sitter.functions.ts_node_descendant_for_point_range
  export _root_.tree_sitter.functions.ts_node_end_byte
  export _root_.tree_sitter.functions.ts_node_end_point
  export _root_.tree_sitter.functions.ts_node_eq
  export _root_.tree_sitter.functions.ts_node_field_name_for_child
  export _root_.tree_sitter.functions.ts_node_first_child_for_byte
  export _root_.tree_sitter.functions.ts_node_first_named_child_for_byte
  export _root_.tree_sitter.functions.ts_node_has_changes
  export _root_.tree_sitter.functions.ts_node_has_error
  export _root_.tree_sitter.functions.ts_node_is_extra
  export _root_.tree_sitter.functions.ts_node_is_missing
  export _root_.tree_sitter.functions.ts_node_is_named
  export _root_.tree_sitter.functions.ts_node_is_null
  export _root_.tree_sitter.functions.ts_node_named_child
  export _root_.tree_sitter.functions.ts_node_named_child_count
  export _root_.tree_sitter.functions.ts_node_named_descendant_for_byte_range
  export _root_.tree_sitter.functions.ts_node_named_descendant_for_point_range
  export _root_.tree_sitter.functions.ts_node_next_named_sibling
  export _root_.tree_sitter.functions.ts_node_next_sibling
  export _root_.tree_sitter.functions.ts_node_parent
  export _root_.tree_sitter.functions.ts_node_prev_named_sibling
  export _root_.tree_sitter.functions.ts_node_prev_sibling
  export _root_.tree_sitter.functions.ts_node_start_byte
  export _root_.tree_sitter.functions.ts_node_start_point
  export _root_.tree_sitter.functions.ts_node_string
  export _root_.tree_sitter.functions.ts_node_symbol
  export _root_.tree_sitter.functions.ts_node_type
  export _root_.tree_sitter.functions.ts_parser_logger
  export _root_.tree_sitter.functions.ts_parser_parse
  export _root_.tree_sitter.functions.ts_parser_set_logger
  export _root_.tree_sitter.functions.ts_query_cursor_exec
  export _root_.tree_sitter.functions.ts_query_cursor_set_point_range
  export _root_.tree_sitter.functions.ts_tree_cursor_copy
  export _root_.tree_sitter.functions.ts_tree_cursor_current_node
  export _root_.tree_sitter.functions.ts_tree_cursor_goto_first_child_for_point
  export _root_.tree_sitter.functions.ts_tree_cursor_new
  export _root_.tree_sitter.functions.ts_tree_cursor_reset
  export _root_.tree_sitter.functions.ts_tree_root_node