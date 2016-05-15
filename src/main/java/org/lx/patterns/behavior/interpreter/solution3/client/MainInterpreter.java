package org.lx.patterns.behavior.interpreter.solution3.client;

import java.util.ArrayList;
import java.util.Iterator;

import org.lx.patterns.behavior.interpreter.solution3.Context;
import org.lx.patterns.behavior.interpreter.solution3.Expression;
import org.lx.patterns.behavior.interpreter.solution3.HundredExpression;
import org.lx.patterns.behavior.interpreter.solution3.OneExpression;
import org.lx.patterns.behavior.interpreter.solution3.TenExpression;
import org.lx.patterns.behavior.interpreter.solution3.ThousandExpression;

public class MainInterpreter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	      String roman = "MCMXXVIII";
	      Context context = new Context(roman);

	      // Build the 'parse tree' 
	      ArrayList<Expression> tree = new ArrayList<Expression>();
	      //下面四行加的顺序很重要,要先加千的expr,再加百的expr ... 不能打乱
	      tree.add(new ThousandExpression());
	      tree.add(new HundredExpression());
	      tree.add(new TenExpression());
	      tree.add(new OneExpression());

	      // Interpret 
	      for (Iterator<Expression> it = tree.iterator(); it.hasNext();)
	      {
	    	  Expression exp = it.next();
	    	  exp.interpret(context);
	      }

	      System.out.println(roman + " = " + Integer.toString(context.getOutput()));
	}
}
