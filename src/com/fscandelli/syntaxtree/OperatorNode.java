package com.fscandelli.syntaxtree;

import java.util.List;

public abstract class OperatorNode extends ExpressionNode {

    public OperatorNode(List<ExpressionNode> children) {
	super(children);
    }

}
