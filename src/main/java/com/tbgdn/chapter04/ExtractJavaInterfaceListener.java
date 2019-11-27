package com.tbgdn.chapter04;

import com.tbgdn.grammar.JavaBaseListener;
import com.tbgdn.grammar.JavaParser;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.TokenStream;

import java.text.MessageFormat;

@RequiredArgsConstructor
public class ExtractJavaInterfaceListener extends JavaBaseListener {

    private final JavaParser parser;

    @Override
    public void enterClassDeclaration(JavaParser.ClassDeclarationContext ctx) {
        System.out.println(MessageFormat.format("interface I{0} '{'", ctx.Identifier()));
    }

    @Override
    public void exitClassDeclaration(JavaParser.ClassDeclarationContext ctx) {
        System.out.println("}");
    }

    @Override
    public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
        TokenStream tokens = parser.getTokenStream();
        String type = "void";
        if (ctx.type() != null){
            type = tokens.getText(ctx.type());
        }
        String args = tokens.getText(ctx.formalParameters());
        System.out.println(MessageFormat.format("\t{0} {1}{2};", type, ctx.Identifier(), args));
    }
}
