package com.tbgdn.common;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import java.io.IOException;
import java.io.InputStream;

public interface RunningExample {

    void run(String[] args);

    default CharStream createStream(String[] args) {
        String inputFilePath = null;
        if (args.length == 1) {
            inputFilePath = args[0];
        }
        InputStream in = System.in;
        if (inputFilePath == null) {
            System.out.println("[WARNING] Reading input from System Input...");
        }else{
            in = this.getClass().getResourceAsStream(inputFilePath);
        }
        try {
            return CharStreams.fromStream(in);
        } catch (IOException e) {
            return CharStreams.fromString("");
        }
    }
}
