package com.fscandelli.syntaxtree;

import java.util.ArrayList;
import java.util.List;

public abstract class ExpressionNode {
    private final List<ExpressionNode> children;

    public ExpressionNode(List<ExpressionNode> children) {
	this.children = new ArrayList<ExpressionNode>(children);
    }

    public List<ExpressionNode> getChildren() {
	return children;
    }

    public abstract Number evaluate(ExpressionMap expressionMap);
}
