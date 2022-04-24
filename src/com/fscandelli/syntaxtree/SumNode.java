package com.fscandelli.syntaxtree;

import java.util.List;

public final class SumNode extends OperatorNode {

    public SumNode(List<ExpressionNode> children) {
	super(children);
    }

    @Override
    public Number evaluate(ExpressionMap expressionMap) {
	double retVal = 0;
	for (ExpressionNode child : getChildren()) {
	    retVal = retVal + child.evaluate(expressionMap).doubleValue();
	}
	return retVal;
    }

}
