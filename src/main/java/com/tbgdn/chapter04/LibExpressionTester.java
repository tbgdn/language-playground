package com.tbgdn.chapter04;

import com.tbgdn.grammar.LibExprLexer;
import com.tbgdn.grammar.LibExprParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class LibExpressionTester extends ExpressionTester{

    public static void main(String[] args) throws Exception {
        new LibExpressionTester().run(args);
    }

    public void run(String[] args) throws Exception{
        CharStream stream = createStream(args);
        LibExprLexer lexer = new LibExprLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LibExprParser parser = new LibExprParser(tokens);
        ParseTree parseTree = parser.prog();
        System.out.println(parseTree.toStringTree(parser));
    }
}
