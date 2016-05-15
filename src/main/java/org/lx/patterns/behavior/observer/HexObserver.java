package org.lx.patterns.behavior.observer;

public class HexObserver extends Observer {

	public HexObserver(Subject subject) {
		super(subject);
	}

	@Override
	void update() {
		System.out.println("Hex Observer: " + Integer.toHexString(subject.getState()));
	}

}
