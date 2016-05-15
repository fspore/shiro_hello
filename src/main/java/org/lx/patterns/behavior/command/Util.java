package org.lx.patterns.behavior.command;

public class Util {
	private static RemoteControl remoteControl = new RemoteControl();
	
	
	public static RemoteControl getRemoteControl() {
		return remoteControl;
	}
}
