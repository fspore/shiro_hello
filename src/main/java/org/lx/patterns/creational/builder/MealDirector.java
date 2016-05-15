package org.lx.patterns.creational.builder;

public class MealDirector {

	public Meal createMeal(Builder builder) {
		builder.buildDrink();
		builder.buildMain();
		builder.buildDessert();
		return builder.getMeal();
	}

}
