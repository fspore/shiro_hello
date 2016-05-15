package org.lx.patterns.structural.composite;

public class CoDemo {
	public static void main(String[] args) {
		Employee ceo = new Employee("Jami", 30000);
		Employee lv1_0 = new Employee("Tom", 11000);
		Employee lv1_0_0 = new Employee("Karl", 8000);
		Employee lv1_0_1 = new Employee("Charls", 9000);
		Employee lv1_0_1_0 = new Employee("ss1", 4000);
		Employee lv1_0_1_1 = new Employee("ss2", 3000);
		Employee lv1_0_2 = new Employee("Lee", 7000);
		Employee lv1_0_2_0 = new Employee("ss3", 3600);
		Employee lv1_1 = new Employee("Lili", 12000);
		Employee lv1_2 = new Employee("Lucy", 12500);
		Employee lv1_2_0 = new Employee("Oly", 7500);
		
		ceo.addSub(lv1_0).addSub(lv1_1).addSub(lv1_2);
		lv1_0.addSub(lv1_0_0).addSub(lv1_0_1).addSub(lv1_0_2);
		lv1_2.addSub(lv1_2_0);
		lv1_0_1.addSub(lv1_0_1_0).addSub(lv1_0_1_1);
		lv1_0_2.addSub(lv1_0_2_0);
		
		ceo.hierarchy();
		
		System.out.println("_________delimeter_________");
		
		lv1_0.hierarchy();
		System.out.println("_________delimeter_________");
		
		lv1_1.hierarchy();
		
		System.out.println("_________delimeter_________");
		
		lv1_2.hierarchy();
		
		System.out.println("_________delimeter_________");
		lv1_0_1.hierarchy();
		
		System.out.println("_________delimeter_________");
		lv1_0_1_0.hierarchy();
	}
}
