package org.lx.algorithms.arith;

import java.util.Scanner;
import java.util.Stack;
/**
 * 只能用带全括号的表达式。比如  (1+((2+3)*(4*5)))
 * @author lx
 *
 */
public class ArithmaticExpr {
	protected final int i = 1;
	
	 public static void main(String[] args)
	 {
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		System.out.println("输入算术表达式：括号全不能省略");
		String line = new Scanner(System.in).nextLine();
		String[] split = line.split("");
		for(int i = 1;i < split.length;i++)
		 { // Read token, push if operator.
			 String s = split[i];
			 if (s.equals("(")) ;
			 else if (s.equals("+")) ops.push(s);
			 else if (s.equals("-")) ops.push(s);
			 else if (s.equals("*")) ops.push(s);
			 else if (s.equals("/")) ops.push(s);
			 else if (s.equals(")"))
			 { // Pop, evaluate, and push result if token is ")".
				 String op = ops.pop();
				 double v = vals.pop();
				 if (op.equals("+")) v = vals.pop() + v;
				 else if (op.equals("-")) v = vals.pop() - v;
				 else if (op.equals("*")) v = vals.pop() * v;
				 else if (op.equals("/")) v = vals.pop() / v;
				 vals.push(v);
			 } // Token not operator or paren: push double value.
				else
					vals.push(Double.parseDouble(s));
		}
		 	System.out.println(vals.pop());
	 } 
}
