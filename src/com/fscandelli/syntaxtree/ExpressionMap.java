package com.fscandelli.syntaxtree;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ExpressionMap {

    private static final Map<String, Expression> MAP = new ConcurrentHashMap<>();

    public Expression getExpression(String symbolName) {
	return MAP.get(symbolName);
    }
    
    public void setExpression(String symbolName, Expression expression){
	MAP.put(symbolName, expression);
    }
}
