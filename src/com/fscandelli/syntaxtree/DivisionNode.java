package com.fscandelli.syntaxtree;

public final class DivisionNode extends BinaryOperatorNode {

    public DivisionNode(ExpressionNode left, ExpressionNode right) {
	super(left, right);
    }

    @Override
    public Number evaluate(ExpressionMap expressionMap) {
	return getLeft().evaluate(expressionMap).doubleValue() / getRight().evaluate(expressionMap).doubleValue();
    }

}
