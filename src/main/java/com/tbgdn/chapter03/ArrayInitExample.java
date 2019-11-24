package com.tbgdn.chapter03;

import com.tbgdn.common.FileKeys;
import com.tbgdn.common.RunningExample;
import com.tbgdn.configuration.ApplicationSettings;
import com.tbgdn.grammar.ArrayInitLexer;
import com.tbgdn.grammar.ArrayInitParser;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArrayInitExample implements RunningExample {

    private final ApplicationSettings settings;

    @Override
    public void run(String[] args) {
        CharStream stream = createStream(new String[]{settings.getChapter03().get(FileKeys.ARRAY_INIT)});
        ArrayInitLexer lexer = new ArrayInitLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ArrayInitParser parser = new ArrayInitParser(tokens);
        ParseTree parseTree = parser.init();
        System.out.println(parseTree.toStringTree(parser));
    }
}
