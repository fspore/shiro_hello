package org.lx.patterns.behavior.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	private int state;
	private List<Observer> observers = new ArrayList<Observer>();
	
	
	final public void attach(Observer observer){
		observers.add(observer);
	}
	
	private void notifyAllObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		notifyAllObservers();
	}
	
	
}
