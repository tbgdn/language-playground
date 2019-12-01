package com.tbgdn.chapter04;

import com.tbgdn.common.FileKeys;
import com.tbgdn.common.RunningExample;
import com.tbgdn.configuration.ApplicationSettings;
import com.tbgdn.grammar.RowsLexer;
import com.tbgdn.grammar.RowsParser;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RowsParserExample implements RunningExample {

    private final ApplicationSettings settings;

    @Override
    public void run(String[] args) {
        for (int i = 1; i <= 3; i++){
            CharStream in = createStream(new String[]{this.settings.getChapter04().get(FileKeys.ROWS)});
            RowsLexer lexer = new RowsLexer(in);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            RowsParser parser = new RowsParser(tokens, i);
            parser.setBuildParseTree(false);
            parser.file();
        }
    }
}
