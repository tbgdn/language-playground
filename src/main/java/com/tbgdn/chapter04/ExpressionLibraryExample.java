package com.tbgdn.chapter04;

import com.tbgdn.common.FileKeys;
import com.tbgdn.common.RunningExample;
import com.tbgdn.configuration.ApplicationSettings;
import com.tbgdn.grammar.LibExprLexer;
import com.tbgdn.grammar.LibExprParser;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExpressionLibraryExample implements RunningExample {

    private final ApplicationSettings settings;

    @Override
    public void run(String[] args) {
        CharStream stream = createStream(new String[]{settings.getChapter04().get(FileKeys.EXPRESSION_LIBRARY)});
        LibExprLexer lexer = new LibExprLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LibExprParser parser = new LibExprParser(tokens);
        ParseTree parseTree = parser.prog();
        System.out.println(parseTree.toStringTree(parser));
    }
}
