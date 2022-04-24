package com.fscandelli.syntaxtree;

public final class AbsoluteNode extends UnaryOperatorNode {

    public AbsoluteNode(ExpressionNode node) {
	super(node);
    }

    @Override
    public Number evaluate(ExpressionMap expressionMap) {
	return Math.abs(getNode().evaluate(expressionMap).doubleValue());
    }

}
