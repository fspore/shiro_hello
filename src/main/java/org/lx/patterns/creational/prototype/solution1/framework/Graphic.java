package org.lx.patterns.creational.prototype.solution1.framework;
/**
 * 一定要extends Cloneable???
 * @author lx
 *
 */
public interface Graphic extends Prototype<Graphic> {
	public abstract void draw();
}
