package org.lx.patterns.structural.bridge.solution1;

//Refined abstraction
public class ConcreteRemote extends RemoteControl {
	
	public ConcreteRemote(TV implementor) {
		super(implementor);
	}

	private int currentChannel;

	public void nextChannel() {
		currentChannel++;
		setChannel(currentChannel);
	}

	public void prevChannel() {
		currentChannel--;
		setChannel(currentChannel);
	}
}
