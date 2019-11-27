package com.tbgdn.chapter04;

import com.tbgdn.common.FileKeys;
import com.tbgdn.common.RunningExample;
import com.tbgdn.configuration.ApplicationSettings;
import com.tbgdn.grammar.JavaLexer;
import com.tbgdn.grammar.JavaParser;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JavaInterfaceExtractorExample implements RunningExample {

    private final ApplicationSettings settings;

    @Override
    public void run(String[] args) {
        CharStream stream = createStream(new String[]{settings.getChapter04().get(FileKeys.JAVA_INTERFACE)});
        JavaLexer lexer = new JavaLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);
        ParseTree tree = parser.compilationUnit();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new ExtractJavaInterfaceListener(parser), tree);
    }
}
