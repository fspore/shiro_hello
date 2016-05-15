package org.lx.patterns.behavior.chainofresponsibility;

public class InfoLogger extends AbstractLogger {

	public InfoLogger(int level) {
		super(level);
	}

	@Override
	public void write(String msg) {
		System.out.println("[INFO]\t logging ::: " + msg);
	}

}
