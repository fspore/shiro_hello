package org.lx.patterns.creational.factorymethod;


/**
 * <pre>
 * The factory method pattern is already complete
 * with the interface {@link Logger} and the 
 * abstract Creator {@link Creator}.
 * 
 * If the client code ever want to use {@link Creator#anOperation() creator.anOperation()}
 * , it is the client's responsibility to plug in
 * the concrete impementation of the `Creator~Logger` API.
 * For example, by adding a jar.
 * 
 * </pre>
 * @author lx
 *
 */
public class Client {
	public static void main(String[] args) {
	}
}
