package org.lx.patterns.creational.builder;

import java.util.logging.Logger;

/**
 * <pre>
 * 有些资料说,Builder pattern 不用director
 * 这个pattern属于Creational pattern族。该族中的最基本pattern是factory pattern。
 * 随着软件的开发,如果发现一开始用factory pattern不够的时候,有时候会将其进化成
 * Abstract factory,或者Builder, 或者 Prototype 等pattern
 * 
 * This is exactly the difference. 
 * The Builder is only needed when an object cannot 
 * be produced in one step. One great an example
 *  of this would be in the de-serialization process 
 *  for a complex object. Often times the parameters
 *   for the complex object must be retrieved one by one.
 * </pre>
 * 
 * @author lx
 *
 */
@SuppressWarnings("unused")
public class ClientCode {
	public static void main(String[] args) {
		boolean isKid = true;

		MealDirector director = new MealDirector();
		Builder builder = null;

		if (isKid) {
			builder = new KidsMealBuilder();
		} else {
			builder = new AdultMealBuilder();
		}
		StringBuilder sb;
		Meal meal = director.createMeal(builder);

	}
}

//class Cliente {
//	private void someMethodThatLogs(AbstractLoggerCreator logCreator) {
//		Logger logger = logCreator.createLogger();
//		logger.log(null, "message");
//	}
//
//	 public static void main(String[] args){
//	 //for the purposes of this example, create an XMLLoggerCreator directly, 
//	 //but this would normally be passed to constructor for use.
//	 AbstractLoggerCreator creator = new XMLLoggerCreator();
//	 Cliente client = new Cliente();
//	 client.someMethodThatLogs(creator);
//	 }
//}

