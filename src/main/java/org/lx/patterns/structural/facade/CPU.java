package org.lx.patterns.structural.facade;

public class CPU {
	
	public void freeze() {
		System.out.println("CPU is freezed now");
	}
	
	public void jump(long position) {
		System.out.println("CPU jumping to " + position);
	}
	
	public void execute() {
		System.out.println("CPU is executing");
	}
}
