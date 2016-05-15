package org.lx.patterns.behavior.visitor.neatversion;

public abstract class Animal2 {
	/**
	 * you override this method.
	 * Make sure the method body to be visitor.visit(this)
	 * for any sub classes
	 * @param visitor
	 */
	public abstract void accept(Visitor visitor);
}
