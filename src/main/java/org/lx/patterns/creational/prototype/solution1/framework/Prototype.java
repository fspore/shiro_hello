package org.lx.patterns.creational.prototype.solution1.framework;

public interface Prototype<T> extends Cloneable {
	public abstract T clone();
}
