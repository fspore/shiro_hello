package org.lx.patterns.structural.flyweight;

import java.awt.Color;
import java.awt.Point;

//Flyweight
public interface LineFlyweight{
	public Color getColor();
	/**
	 * 注意,就是这个Point location是 Line的extrinsic属性。(非本质属性,所以不设为field,而是从argument传入)
	 * @param location
	 */
	public void draw(Point location);}

