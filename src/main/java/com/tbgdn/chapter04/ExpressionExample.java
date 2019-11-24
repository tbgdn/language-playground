package com.tbgdn.chapter04;

import com.tbgdn.common.FileKeys;
import com.tbgdn.common.RunningExample;
import com.tbgdn.configuration.ApplicationSettings;
import com.tbgdn.grammar.ExprLexer;
import com.tbgdn.grammar.ExprParser;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ExpressionExample implements RunningExample {

    private final ApplicationSettings settings;

    @Override
    public void run(String[] args) {
        CharStream stream = createStream(new String[]{settings.getChapter04().get(FileKeys.EXPRESSION)});
        ExprLexer lexer = new ExprLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        ParseTree parseTree = parser.prog();
        System.out.println(parseTree.toStringTree(parser));
    }
}
