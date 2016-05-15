package org.lx.patterns.behavior.interpreter.solution2;

import java.util.Map;


public interface Expression {
	public double interpret(Map<String,Expression> variables);

}
