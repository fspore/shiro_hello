package org.lx.patterns.behavior.visitor.neatversion;

public class Cat2 extends Animal2{

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
