package org.lx.patterns.behavior.visitor;

public class OperationSound implements Operation {

	
	public void IamCat(Cat cat) {
		System.out.println("meow!");
		
	}

	public void IamDog(Dog dog) {
		System.out.println("wonwon!");
	}
	
}
