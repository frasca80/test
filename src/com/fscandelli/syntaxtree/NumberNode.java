package com.fscandelli.syntaxtree;

public final class NumberNode extends LeafNode {
    private final Number number;

    public NumberNode(double number) {
	super();
	this.number = number;
    }

    public Number getNumber() {
	return number;
    }

    @Override
    public Number evaluate(ExpressionMap expressionMap) {
	return number;
    }
}
