package org.lx.patterns.syn.q4;

public class Updater {
	public Holder holder;
	
	public void init(){
		holder = new Holder((int)(Math.random()*30));
	}
}
