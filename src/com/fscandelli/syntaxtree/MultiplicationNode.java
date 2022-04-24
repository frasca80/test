package com.fscandelli.syntaxtree;

import java.util.List;

public final class MultiplicationNode extends OperatorNode {

    public MultiplicationNode(List<ExpressionNode> children) {
	super(children);
    }

    @Override
    public Number evaluate(ExpressionMap expressionMap) {
	double retVal = 1;
	for (ExpressionNode child : getChildren()) {
	    retVal = retVal * child.evaluate(expressionMap).doubleValue();
	}
	return retVal;
    }

}
