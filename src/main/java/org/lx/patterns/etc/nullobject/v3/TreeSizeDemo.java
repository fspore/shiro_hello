package org.lx.patterns.etc.nullobject.v3;


/**
 * https://en.wikipedia.org/wiki/Null_Object_pattern
 * @author lx
 *
 */
public class TreeSizeDemo {
	
	public static void main(String[] args) {
		Node n1 = new Node("n1");
		Node n1_left = new Node("n1_left");
		Node n1_right = new Node("n1_right");
		Node n1_left_left = new Node("n1_left_left");
		
		NullNode nullNode = new NullNode();
		
		n1.left = n1_left;
		n1.right = n1_right;
		
		n1_left.left = n1_left_left;
		n1_left.right = nullNode;
		
		n1_right.left = nullNode;
		n1_right.right = nullNode;
		
		n1_left_left.left = nullNode;
		n1_left_left.right = nullNode;
		
		System.out.println(n1.tree_size(n1));
		
		
		
	}

}


