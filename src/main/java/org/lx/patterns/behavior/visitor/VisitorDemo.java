package org.lx.patterns.behavior.visitor;
/**
 * <pre>
 * <p style="color:red">
 * The point of visitor is to extend a bunch of hierarchical elements with 
 * a new operation without changing their implementation.
 * 
 * 换一种说法:
 * Visitor lets you define a new operation without changing the classes of the 
 * elements on which it operates.
 * </p>
 * 
 * 当我们对Animal的hierarchy比较满意时,不愿意对它进行很大的更改——比如添加功能。而又必须添加功能时,
 * 可以把这些功能独立出来,放到另一个Operation的hierarchy中。这个Operation的interface是常变的。
 * <span style="color:blue">这个Operation的树就是Visitors。更正规的Visitor pattern
 * 会把总接口Animal的{@link org.lx.patterns.behavior.visitor.Animal#doAddtionalOperation(Operation) doAddtionalOperation}
 * 改名成accept(Visitor v),然后Cat, Dog的accept(visitor)方法中,
 * 方法体为visitor.visit(this);然后每个实体visitor对应这个this写
 * visit(Cat cat)、visit(Dog dog)方法。注意,这里的this不用多态特性。
 * 这样才能让visit是overload的函数。
 * </span>
 * Animal类中只须添加一个 doAddtionalOperation(Operation op)来与Operation hierarchy建立联系。
 * 
 * 注意:
 * 只要Animal树中每添加一个新的实体类,Operation接口都必须更新知道这个实例类。
 * 同时Operation的所有实体Operation都需要同时更新。
 * 
 * <span style="color:red">visitor pattern还有一个好处是：让所添加的功能(extended feature)集
 * 中到一个类中,而不是分散到所有的实体类里。这样更方便比较、观察。
 * {@link org.lx.patterns.behavior.visitor.OperationSound 比如这个OperationSound}</span>
 * @see <a href="http://stackoverflow.com/a/11243630/2961429" >Cat and Dog</a>
 * @see <a href="http://stackoverflow.com/a/478672/2961429" >define a new operation without changing the classes</a>
 * @see <a href="http://stackoverflow.com/a/11243630/2961429">visitor pattern used along with composite pattern </a>
 * 
	 * Composite c = new Composite();
	 * Visitor v = new ConcreteVisitor();
	 * c.visit(v);
 * </pre>
 * @author lx
 *
 */
public class VisitorDemo {
	public static void main(String[] args) {
		Animal a1, a2;
		a1 = new Cat();
		a2 = new Dog();
		
		Operation op;
		op = new OperationSound();
		a1.doAddtionalOperation(op);
		a2.doAddtionalOperation(op);
		
		System.out.println("__________________");
		
		op = new OperationClimb();
		a1.doAddtionalOperation(op);
		a2.doAddtionalOperation(op);
	}
}
