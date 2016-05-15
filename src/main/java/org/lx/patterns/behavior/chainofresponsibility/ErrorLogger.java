package org.lx.patterns.behavior.chainofresponsibility;

public class ErrorLogger extends AbstractLogger {

	public ErrorLogger(int level) {
		super(level);
	}

	@Override
	public void write(String msg) {
		System.out.println("[ERROR]\t logging ::: " + msg);
	}

}
