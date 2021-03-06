package org.lx.patterns.behavior.interpreter.solution2;

import java.util.Map;


public class Divide implements Expression {

	Expression leftOperand;
	Expression rightOperand;
	public Divide(Expression left, Expression right) { 
		leftOperand = left; 
		rightOperand = right;
	}
	
	public double interpret(Map<String,Expression> variables) {
		//carry out the appropriate operations
		if (rightOperand.interpret(variables) == 0) {
			System.out.println("Can't devide by 0");
			return 0;
		}
		else
			return leftOperand.interpret(variables) / rightOperand.interpret(variables);
	}

}
