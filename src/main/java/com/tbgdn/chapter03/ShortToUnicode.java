package com.tbgdn.chapter03;

import com.tbgdn.grammar.ArrayInitBaseListener;
import com.tbgdn.grammar.ArrayInitParser;

public class ShortToUnicode extends ArrayInitBaseListener {

    @Override
    public void enterInit(ArrayInitParser.InitContext ctx) {
        System.out.print("'");
    }

    @Override
    public void exitInit(ArrayInitParser.InitContext ctx) {
        System.out.println("'");
    }

    @Override
    public void enterValue(ArrayInitParser.ValueContext ctx) {
        int value = Integer.parseInt(ctx.getText());
        System.out.printf("\\u%04x", value);
    }
}
