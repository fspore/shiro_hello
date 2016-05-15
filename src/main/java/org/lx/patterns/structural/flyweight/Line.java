package org.lx.patterns.structural.flyweight;

import java.awt.Color;
import java.awt.Point;

//ConcreteFlyweight
public class Line implements LineFlyweight{
	private Color color; 
	/**
	 * 我们认为Color是Line的本质属性(instrisic)。我们通过本质属性当key从FlyweightFactory保存的缓存中搜索Line。
	 * @param c
	 */
	public Line(Color c){this.color = c;}
	
	public Color getColor(){return color;}
	
	public void draw(Point location){
		//draw the character on screen
		System.out.println("dawing line at location : " + location);
	}
	
}

