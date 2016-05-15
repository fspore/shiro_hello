package org.lx.patterns.behavior.visitor;

public class OperationClimb implements Operation {

	public void IamCat(Cat cat) {
		System.out.println("kitty is climbing!");
		
	}

	public void IamDog(Dog dog) {
		System.out.println("doggy is climbing!");
	}

}
