import TreeSitter from 'web-tree-sitter';
import init from 'web-tree-sitter/tree-sitter.wasm?init&url';
import initScala from '/tree-sitter-scala.wasm?init&url';

const Parser = TreeSitter;

let parser = await (async () => {
  await Parser.init({
    locateFile(scriptName, scriptDirectory) {
      return init
      // if (import.meta.env.MODE == 'development') 
      //   return 'node_modules/web-tree-sitter/' + scriptName;
      // else return 'assets!/' + scriptName;
    },
  });  
  const parser = new Parser();
  const Lang = await Parser.Language.load(initScala);
  parser.setLanguage(Lang);
  return parser;
})();

export default parser;

