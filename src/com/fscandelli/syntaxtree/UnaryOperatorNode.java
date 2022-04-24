package com.fscandelli.syntaxtree;

import java.util.Arrays;

public abstract class UnaryOperatorNode extends OperatorNode {

    public UnaryOperatorNode(ExpressionNode node) {
	super(Arrays.asList(node));
    }

    public final ExpressionNode getNode() {
	return getChildren().get(0);
    }

    
}
