package com.fscandelli.syntaxtree;

import java.util.HashMap;
import java.util.Map;

public final class ExpressionMap {

    private  final Map<String, Expression> map ;

    public ExpressionMap(Map<String, Expression> map) {
	this.map = new HashMap<>(map);
    }
    
    public Expression getExpression(String symbolName) {
	return map.get(symbolName);
    }
    
}
