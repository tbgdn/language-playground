package com.tbgdn.chapter07;

import com.google.common.collect.Maps;
import com.tbgdn.grammar.PropertyFileBaseListener;
import com.tbgdn.grammar.PropertyFileParser;
import lombok.Getter;

import java.util.Map;

@Getter
public class PropertyFileLoader extends PropertyFileBaseListener {

    private final Map<String, String> properties = Maps.newHashMap();

    @Override
    public void exitProp(PropertyFileParser.PropContext ctx) {
        String id = ctx.ID().getText();
        String value = ctx.STRING().getText();
        properties.put(id, value);
    }
}
