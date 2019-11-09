package com.tbgdn;


import com.tbgdn.grammar.ArrayInitLexer;
import com.tbgdn.grammar.ArrayInitParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.Trees;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        CharStream input = CharStreams.fromStream(System.in);
        ArrayInitLexer lexer = new ArrayInitLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ArrayInitParser parser = new ArrayInitParser(tokens);
        parser.init().value()
                .stream()
                .flatMap(val -> val.children.stream())
                .map(Trees::toStringTree)
                .forEach(System.out::print);
    }
}
