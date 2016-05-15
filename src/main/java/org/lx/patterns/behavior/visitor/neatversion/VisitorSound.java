package org.lx.patterns.behavior.visitor.neatversion;

public class VisitorSound implements Visitor {
	
	public void visit(Animal2 animal2) {
		System.out.println("Sorry! the sound of animals are not implemented other than cats and dogs. ");
	}
	
	public void visit(Cat2 cat2){
		System.out.println("meow! meow!");
	}
	
	public void visit(Dog2 dog2) {
		System.out.println("won! won!");
	}

}
