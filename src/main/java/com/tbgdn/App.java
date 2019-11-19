package com.tbgdn;


import com.tbgdn.grammar.ArrayInitLexer;
import com.tbgdn.grammar.ArrayInitParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ArrayInitParser parser = createParser();
        ArrayInitParser.InitContext context = parser.init();
        System.out.println(context.toStringTree(parser));
        //
        ParseTreeWalker walker = new ParseTreeWalker();
        context = createParser().init();
        walker.walk(new ShortToUnicode(), context);
    }

    private static ArrayInitParser createParser() {
        CharStream input = CharStreams.fromString("{1,2,3}");
        ArrayInitLexer lexer = new ArrayInitLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new ArrayInitParser(tokens);
    }


}
