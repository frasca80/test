package com.fscandelli.syntaxtree;

import java.util.Arrays;

public abstract class BinaryOperatorNode extends OperatorNode {

    public BinaryOperatorNode(ExpressionNode left, ExpressionNode right) {
	super(Arrays.asList(left, right));
    }

    public final ExpressionNode getLeft() {
	return getChildren().get(0);
    }

    public final ExpressionNode getRight() {
	return getChildren().get(1);
    }

}
