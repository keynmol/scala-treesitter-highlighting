import TreeSitter from 'web-tree-sitter';
import init from 'web-tree-sitter/tree-sitter.wasm?init&url';

const Parser = TreeSitter;

let parser = await (async () => {
  await Parser.init({
    locateFile(scriptName, scriptDirectory) {
      if (import.meta.env.MODE == 'development') 
        return 'node_modules/web-tree-sitter/' + scriptName;
      else return 'assets/' + scriptName;
    },
  });  
  const parser = new Parser();
  const Lang = await Parser.Language.load('tree-sitter-scala.wasm');
  parser.setLanguage(Lang);
  // const tree = parser.parse('object Main {def hello = 25}');
  // console.log(tree.rootNode.toString());
  return parser;
})();

export default parser;

