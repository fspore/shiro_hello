package org.lx.patterns.behavior.interpreter.solution2;

import java.util.Map;


public class Cosine implements Expression{
	Expression operand;

	public Cosine(Expression inputOperand) {
		operand = inputOperand;
	}

	public double interpret(Map<String,Expression> variables) {
		//carry out the appropriate operation
		return Math.cos(Math.toRadians(operand.interpret(variables)));
	}
}
