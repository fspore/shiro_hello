package org.lx.patterns.behavior.command;
/**
 * <pre>
 * Command declares an interface for all commands, 
 * providing a simple execute() method which asks 
 * the Receiver of the command to carry out an operation.
 * 
 *  The Receiver has the knowledge of what to do to
 *   carry out the request.  The Invoker holds a command
 *    and can get the Command to execute a request by
 *     calling the execute method. 
 *     
 *     The Client creates
 *      ConcreteCommands and sets a Receiver for the 
 *      command. 
 *      
 *      The ConcreteCommand defines a binding
 *       between the action and the receiver. When
 *        the Invoker calls execute the ConcreteCommand
 *         will run one or more actions on the Receiver
 * </pre>
 * @author lx
 *
 */
public class Client {
	public static void main(String[] args) {
		RemoteControl control = Util.getRemoteControl();
		
		Command c1, c2;
		Light l1 = new Light("Big Blue");
		
		c1 = new LightOnCommand(l1);
		c2 = new LightOffCommand(l1);
		
		//模拟1
		control.takeCommand(c1);
		control.pressButton();
		//模拟2
		System.out.println("_________sim2_________");
		control.takeCommand(c1);
		control.takeCommand(c2);
		control.pressButton();
		//模拟3
		//由于RemoteControl这个Invoker不与任何Receiver——比如Light——具有耦合关系,所以是通用的。
		//只是command的实体类与receiver具有耦合关系。

	
	
	
	}
}















