package com.tbgdn.chapter07;

import com.tbgdn.common.FileKeys;
import com.tbgdn.common.RunningExample;
import com.tbgdn.configuration.ApplicationSettings;
import com.tbgdn.grammar.PropertyFileLexer;
import com.tbgdn.grammar.PropertyFileParser;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
@RequiredArgsConstructor
public class PropertyFileVisitorExample implements RunningExample {

    private final ApplicationSettings settings;

    @Override
    public void run(String[] args) {
        CharStream stream = createStream(new String[]{settings.getChapter07().get(FileKeys.PROPERTY_FILE)});
        PropertyFileLexer lexer = new PropertyFileLexer(stream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        PropertyFileParser parser = new PropertyFileParser(tokenStream);
        ParseTree tree = parser.file();
        PropertyFileLoaderVisitor visitor = new PropertyFileLoaderVisitor();
        visitor.visit(tree);
        visitor.getProperties().forEach((key, value) -> System.out.println(MessageFormat.format("{0}={1}", key, value)));
    }
}
