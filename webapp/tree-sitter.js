import TreeSitter from "web-tree-sitter";
import init from "web-tree-sitter/tree-sitter.wasm?init&url";
import initScala from "/tree-sitter-scala.wasm?init&url";

let parser = await (async () => {
  await TreeSitter.init({
    locateFile(scriptName, scriptDirectory) {
      return init;
    },
  });
  const parser = new TreeSitter();
  const Lang = await TreeSitter.Language.load(initScala);
  parser.setLanguage(Lang);
  return parser;
})();

export default parser;
