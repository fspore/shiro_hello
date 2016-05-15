package org.lx.tricks.ducktyping;

import static org.lx.tricks.ducktyping.DuckType.coerce;

import java.lang.reflect.Method;
/**
 * 见{@link #someMethod}
 * @see <a href="http://thinking-in-code.blogspot.com/2008/11/duck-typing-in-java-using-dynamic.html">original tutorial</a>
 * @author lx
 *
 */
public class DuckDemo {
	public static void main(String[] args) throws Exception, NoSuchMethodException {
		someMethod(coerce(new Duck()).to(Foo.class));
		someMethod(coerce(new Person()).to(Foo.class));
		
		//注意anotherMethod只接受Foo类型的object,但我们用duck typing做到了多态。而该多态的两个object却不是Foo继承体系的成员！！
		anotherMethod(new Duck());
		anotherMethod(new Person());
		
		System.out.println("_________下面是模拟的原理,因为Method.invoke()可不管那么多。_________");
		Duck duck = new Duck();
		Method[] methods = Foo.class.getMethods();
		for (Method method : methods) {
			String name = method.getName();
			Class<?>[] parameterTypes = method.getParameterTypes();
			duck.getClass().getMethod(name, parameterTypes).invoke(duck);
		}
		
		
	}
	/**我们的要求是：因为Duck和Person都是历史代码,不能加入hierarchy。而又想要polymorphism的好处。
	 * 比如这个方程,我们想让它接受new Duck(),new Person()即使他们并不处于Foo的继承树中;这就是duck typing*/
	private static void someMethod(Foo foo) {
		foo.bar();
	}
	
	private static void anotherMethod(Object obj){
		coerce(obj).to(Foo.class).bar();
	}
}

interface Foo {
	String bar();
}

class Duck {
	public String bar() { System.out.println("a loud Quaaaaaaaaaaaaack!");
	return "bar"; }
}

class Person {
	public String bar() { System.out.println("a person making a quacking sound.");
	return "foobar"; }
}
