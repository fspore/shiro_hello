package org.lx.patterns.behavior.visitor;

public class Cat extends Animal {

	@Override
	public void doAddtionalOperation(Operation op) {
		op.IamCat(this);
	}

}
