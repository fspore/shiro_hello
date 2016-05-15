package org.lx.patterns.creational.factorymethod;



/**
 * abstract Creator which establishes the
 * logic without any concrete implementation.
 * The construction of the concrete product---ConcreteLogger
 * is defered by abstracting the {@link #factoryMethod()}.
 * 
 * @author lx
 *
 */
public abstract class Creator {
	public void anOperation() {
		Logger logger = factoryMethod();
		//complex logic here:
		logger.regiter();
		logger.doStuff();
		logger.doOtherStuff(); 
	}
	/**abstract this method. So the construction is defered. But relationship can be established.*/
	protected abstract Logger factoryMethod();
}
