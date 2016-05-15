package org.lx.patterns.behavior.interpreter.solution1;

import java.util.Scanner;

public class InterpreterPatternDemo {

	   //Rule: Robert and John are male
	   public static Expression getMaleExpression(){
	      Expression robert = new TerminalExpression("Robert");
	      Expression john = new TerminalExpression("John");
	      return new OrExpression(robert, john);		
	   }

	   //Rule: Julie is a married women
	   public static Expression getMarriedWomanExpression(){
	      Expression julie = new TerminalExpression("Julie");
	      Expression married = new TerminalExpression("Married");
	      return new AndExpression(julie, married);		
	   }

	   public static void main(String[] args) {
	      Expression isMale = getMaleExpression();
	      Expression isMarriedWoman = getMarriedWomanExpression();
	      Scanner sc = new Scanner(System.in);
	      System.out.println("State your question: ");
	      String name = sc.nextLine();
	      System.out.printf("%s is male? %s\n", name, isMale.interpret(name));
	      System.out.println("Julie is a married women? " + isMarriedWoman.interpret("Married Julie"));
	   }
	}