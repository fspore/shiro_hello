package org.lx.patterns.behavior.observer;

public class ObserverPatternDemo {
	public static void main(String[] args) {
		Subject subject = new Subject();
		
		new BinaryObserver(subject);
		new HexObserver(subject);
		
		System.out.println("now I'm gonna change the state of the subject. \n"
				+ "Notice how this 'setState' behavior \nautomatically triggers the observers \n::::");
		subject.setState(12);
	}
}
