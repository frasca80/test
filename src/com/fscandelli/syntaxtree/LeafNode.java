package com.fscandelli.syntaxtree;

import java.util.Collections;

public abstract class LeafNode extends ExpressionNode {

    public LeafNode() {
	super(Collections.emptyList());
    }

}
