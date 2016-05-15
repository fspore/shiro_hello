package org.lx.patterns.behavior.command;


/**
 * This is one 
 * <b><em>Receiver</em></b>
 * <br><b>Note that Receivers don't need to share any super class</b>
 * @author lx
 *
 */
public class Light {
	private String name;
	
	public Light(String name) {
		this.name = name;
	}
	
	public void switchOn() {
		System.out.println("_________Light "+ name +" is switched ON. It is shinny_________");
	}
	
	public void switchOff() {
		System.out.println("_________Light "+ name +" is switched OFF. It is dark now_________");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
