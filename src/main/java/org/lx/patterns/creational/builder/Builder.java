package org.lx.patterns.creational.builder;

public abstract class Builder {
	
	protected Meal meal;
	
	public abstract void buildDrink();
	public abstract void buildMain();
	public abstract void buildDessert();
	
	public abstract Meal getMeal();
	
}
