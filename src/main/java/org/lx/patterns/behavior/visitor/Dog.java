package org.lx.patterns.behavior.visitor;

public class Dog extends Animal{

	@Override
	public void doAddtionalOperation(Operation op) {
		op.IamDog(this);
	}

}
