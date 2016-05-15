package org.lx.patterns.behavior.visitor.neatversion;
/**
 * <pre>
 * <span style="color:red">
 * 注意,不要在{@link org.lx.patterns.behavior.visitor.neatversion.Animal2 Animal2}
 * 里写accept(visitor)的方法体visitor.visit(this)。
 * </span>
 * 假设写了,那么看起来可以被继承,方便很多。但是在Animal2方法中,调用
 * visitor.visit(this)时,由于this在Animal2类中,所以
 * 声明类型变成Animal2类型,
 * 所以调用的只有visitor的visit(Animal2 animal2)方法,
 * 即使this的实体是Cat2或者Dog2
 * </pre>
 * @author lx
 *
 */
public class Demo {
	public static void main(String[] args) {
		Animal2 a1, a2, a3;
		a1 = new Cat2();
		a2 = new Dog2();
		a3 = new Monkey2();
		
		Visitor v = new VisitorSound();
		
		a1.accept(v);
		a2.accept(v);
		a3.accept(v);
		
		
		
	}
}
