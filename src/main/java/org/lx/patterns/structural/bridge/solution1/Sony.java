package org.lx.patterns.structural.bridge.solution1;

//Concrete Implementor 
public class Sony implements TV {
	public void on() {
		// Sony specific on
		System.out.println("_________Sony On_________");
	}

	public void off() {
		// Sony specific off
		System.out.println("_________Sony Off_________");
	}

	public void tuneChannel(int channel) {
		// Sony specific tuneChannel
		System.out.println("_________Sony On channel "+channel+"_________");
	}

}
