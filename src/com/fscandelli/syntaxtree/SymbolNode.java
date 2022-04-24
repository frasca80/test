package com.fscandelli.syntaxtree;

public final class SymbolNode extends LeafNode {
    private final String symbol;

    public SymbolNode(String symbol) {
	super();
	this.symbol = symbol;
    }

    public String getSymbol() {
	return symbol;
    }

    @Override
    public Number evaluate(ExpressionMap expressionMap) {
	return expressionMap.getExpression(symbol).calc(expressionMap);
    }

}
