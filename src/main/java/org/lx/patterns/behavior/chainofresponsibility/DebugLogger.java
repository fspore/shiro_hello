package org.lx.patterns.behavior.chainofresponsibility;

public class DebugLogger extends AbstractLogger{

	public DebugLogger(int level) {
		super(level);
	}

	@Override
	public void write(String msg) {
		System.out.println("[DEBUG]\t logging ::: " + msg);
	}

}
