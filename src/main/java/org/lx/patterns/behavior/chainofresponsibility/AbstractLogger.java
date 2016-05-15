package org.lx.patterns.behavior.chainofresponsibility;


public abstract class AbstractLogger {
	public static final int INFO = 1;
	public static final int DEBUG = 2;
	public static final int ERROR = 3;
	
	protected int level;
	
	protected AbstractLogger nextLogger;
	
	public AbstractLogger(int level) {
		this.level = level;
	}
	
	public AbstractLogger setNextLogger(AbstractLogger logger){
		this.nextLogger = logger;
		return logger;
	}
	
	
	public void logMessage(int msg_level, String msg){
		if (this.level <= msg_level) {
			write(msg);
		}
		if (nextLogger != null) {
			nextLogger.logMessage(msg_level, msg);
		}
	}

	public abstract void write(String msg);
	
	
}
