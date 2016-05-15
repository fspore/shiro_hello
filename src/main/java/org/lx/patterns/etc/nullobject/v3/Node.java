package org.lx.patterns.etc.nullobject.v3;

public class Node{
	Node left;
	Node right;
	
	String name;
	
	public Node(String name) {
		this.name = name;
	}
	
	public Node() {
	}

	/**
	 * a little bit tricky here.
	 * 是选择overload还是override
	 * overload用的是static binding. 是做不到这个NullObjectPattern的。
	 * 必须要用override。
	 * 因为我们想要让当node是NullNode时,调用NullNode的override的tree_size方法。
	 * 所以,如果用static binding,是在编译时就确定使用哪个方法,而此时tree_size(Node node)
	 * 的node并不知道它实际上是什么类型,但是知道它的声明类型,所以必选tree_size(Node node)方法
	 * 而不会选tree_size(NullNode node)方法。
	 * @param node
	 * @return
	 */
	public int tree_size(Node node){
		return 1 + left.tree_size(left) + right.tree_size(right);
	}
	
	

	@Override
	public String toString() {
		return "Node [name=" + name + "]";
	}
	
	
	
}
