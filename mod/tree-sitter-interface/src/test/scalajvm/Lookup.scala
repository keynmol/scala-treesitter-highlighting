package ts_highlight

import io.github.treesitter.jtreesitter.NativeLibraryLookup
import java.lang.foreign.Arena
import java.lang.foreign.SymbolLookup
import java.nio.file.Path

class ScalaTSLibraryLookup extends NativeLibraryLookup:
  override def get(arena: Arena): SymbolLookup =
    ScalaTSLibraryLookup.lookup.getOrElse(
      sys.error("Lookup wasn't initialiased")
    )

object ScalaTSLibraryLookup:
  var lookup: Option[SymbolLookup] = None
