package org.lx.algorithms.arith;

/**
 * <pre>
 * public void m1(){
 * 	method(this)
 * }
 * 这个method(this)是static binding。
 * 不知道对不对:
 * 调用方法是static binding。 invoke on what object to 
 * decide which method definition to be used is dynamic binding.
 * sth.method()  点号前面的sth就是the object on which the method is invoked.
 * so go find the function in the `sth` class that matches `method()`
 * 如果没有这个sth. 那么默认为invoke on this.从本类中找。
 * 所以
 * </pre>
 * @author lx
 *
 */
public class DD {
	public static void main(String[] args) {
		Animal a = new Cat();
		a.m1();
	}
}

abstract class Animal {
	public void m1() {
		System.out.println("\t[INFO]\tAnimal#m1() is invoked");
		m2(this);
	}
	
	public void m2(Animal a) {
		System.out.println("\t[INFO]\tAnimal#m2() is invoked");
	}
}

class Cat extends Animal {
//	@Override
//	public void m1() {
//		System.out.println("_________delimeter_________");
//		m2(this);
//	}
	
	/**注意,由于函数的signature与Animal中的m2(this)不同。m2(this)静态绑定
	 * 为m2(Animal a)了,即使this的实体是Cat,但是会对this静态绑定
	 * 所以通过Animal#m1()的程序最终不会执行到这里。
	 * 而如果取消了Cat#m1()的注释。同样的,在Cat中也会m2(this)静态绑定,但是这回
	 * 会绑定为m2(Cat a),于是,经过Cat#m1()的程序会执行这里
	 * */
	public void m2(Cat a){
		System.out.println("_________mm2_________");
	}
}










