package com.tbgdn.chapter04;

import com.tbgdn.grammar.ExprLexer;
import com.tbgdn.grammar.ExprParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.InputStream;

public class ExpressionTester {

    public static void main(String[] args) throws Exception{
        new ExpressionTester().run(args);
    }

    public void run(String[] args) throws Exception {
        CharStream stream = createStream(args);
        ExprLexer lexer = new ExprLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        ParseTree parseTree = parser.prog();
        System.out.println(parseTree.toStringTree(parser));
    }

    CharStream createStream(String[] args) throws Exception{
        String inputFilePath = null;
        if (args.length == 1) {
            inputFilePath = args[0];
        }
        InputStream in = System.in;
        if (inputFilePath != null) {
            in = this.getClass().getResourceAsStream(inputFilePath);
        }
        return CharStreams.fromStream(in);
    }
}
