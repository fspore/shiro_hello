package org.lx.patterns.behavior.observer;

public abstract class Observer {

	protected Subject subject;

	public Observer(Subject subject){
		this.subject = subject;
		subject.attach(this);
	}
	abstract void update();

}
