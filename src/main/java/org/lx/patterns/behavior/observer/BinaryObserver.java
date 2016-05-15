package org.lx.patterns.behavior.observer;

public class BinaryObserver extends Observer {

	public BinaryObserver(Subject subject) {
		super(subject);
	}

	@Override
	void update() {
		System.out.println( "Binary String: " + Integer.toBinaryString(subject.getState()));
	}

}
