package org.lx.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	private String name;
	private int salary;
	private List<Employee> subs;
	
	public Employee(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
		subs = new ArrayList<Employee>();
	}
	
	public void hierarchy(){
		System.out.println(toString());
		printHierarchy(1);
	}
	
	private void printHierarchy(int lv){
		for (Employee sub : subs) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < lv; i++) 
				sb.append("--");
			System.out.println("|" + sb.toString() + sub.toString());
			sub.printHierarchy(lv + 1);
		}
	}
	
	public Employee addSub(Employee e){
		subs.add(e);
		return this;
	}
	
	public Employee removeSub(Employee e){
		subs.remove(e);
		return this;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}
	
	
}
