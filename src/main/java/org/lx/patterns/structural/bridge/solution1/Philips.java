package org.lx.patterns.structural.bridge.solution1;

//Concrete Implementor 
public class Philips implements TV {
	public void on() {
		// Philips specific on
		System.out.println("_________Philips On_________");
	}

	public void off() {
		// Philips specific off
		System.out.println("_________Philips Off_________");
	}

	public void tuneChannel(int channel)
	{
		// Philips specific tuneChannel
		System.out.println("_________Philips On channel "+channel+"_________");
	}
}
