package com.fscandelli.syntaxtree;

import java.util.HashSet;
import java.util.Set;

public final class Expression {

    private final ExpressionNode node;

    public Expression(ExpressionNode node) {
	super();
	this.node = node;
    }

    public Number calc(ExpressionMap expressionMap) {
	return node.evaluate(expressionMap);
    }

    public Set<String> getReferencedSymbols() {
	Set<String> retVal = new HashSet<String>();
	retrieveReferencedSymbols(retVal, node);
	return retVal;
    }

    private void retrieveReferencedSymbols(Set<String> symbols, ExpressionNode node) {
	if (node instanceof SymbolNode) {
	    SymbolNode symbolNode = (SymbolNode) node;
	    symbols.add(symbolNode.getSymbol());
	} else {
	    for (ExpressionNode child : node.getChildren()) {
		retrieveReferencedSymbols(symbols, child);
	    }
	}
    }

}
