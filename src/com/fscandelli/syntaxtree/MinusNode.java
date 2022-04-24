package com.fscandelli.syntaxtree;

public final class MinusNode extends BinaryOperatorNode {

    public MinusNode(ExpressionNode left, ExpressionNode right) {
	super(left, right);
    }

    @Override
    public Number evaluate(ExpressionMap expressionMap) {
	return getLeft().evaluate(expressionMap).doubleValue() - getRight().evaluate(expressionMap).doubleValue();
    }

}
