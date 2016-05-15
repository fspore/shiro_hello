package org.lx.patterns.behavior.command;

import java.util.ArrayList;
import java.util.List;
/**
 * This is the 
 * <b><em>Invoker</em></b>
 * @author lx
 *
 */
public class RemoteControl {
	private List<Command> commands = new ArrayList<Command>();
	
	public void takeCommand(Command command) {
		commands.add(command);
	}
	
	public void pressButton() {
		for (Command command : commands) {
			command.execute();
		}
		commands.clear();
	}
	
}
