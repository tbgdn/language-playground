package com.tbgdn.common;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ExampleRunner implements CommandLineRunner {

    private final List<RunningExample> examples;

    @Override
    public void run(String... args) {
        this.examples.forEach(runner -> runner.run(args));
    }
}
