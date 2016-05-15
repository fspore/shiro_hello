package org.lx.patterns.behavior.chainofresponsibility;


/**
 * 这个logger的例子是把chain和responsibilty合在一起了。但这两个是可以分开的,见servlet的filter和filterChain	
 * 另一个更著名的例子是 
 * chain.doFilter(request, response);
 * 和filter.doFilter(req, res, chain);
 * 这两个方法。分别是servlet中{@link javax.servlet.FilterChain FilterChain} 和 {@link javax.servlet.Filter Filter}
 * 两个接口标准。
 * @author lx
 *
 */
public class ChainDemo {
	public static void main(String[] args) {
		AbstractLogger loggerChain = getLoggerChain();
		
		loggerChain.logMessage(AbstractLogger.INFO, "trivial");
		loggerChain.logMessage(AbstractLogger.DEBUG, "favorite bug");
		loggerChain.logMessage(AbstractLogger.ERROR, "!!!!!!ERROR!!!!");
		
	}

	public static AbstractLogger getLoggerChain() {
		AbstractLogger infoLogger = new InfoLogger(AbstractLogger.INFO);
		AbstractLogger debugLogger = new DebugLogger(AbstractLogger.DEBUG);
		AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
		errorLogger.setNextLogger(debugLogger)
					.setNextLogger(infoLogger);
		return errorLogger;
	}
}
