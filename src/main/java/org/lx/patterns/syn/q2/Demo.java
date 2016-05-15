package org.lx.patterns.syn.q2;


/**
 * calling non-private or non-final method in constructor will cause this escaping
 * @author lx
 *
 */
public class Demo {
	public static void main(String[] args) {
		int i = 0;
		while (i++<100) {
			new Child();
		}
	}
}


class Parent{
	private int num;
	public void overrideableMethod() {
	}
	public Parent() {
		overrideableMethod();
		for (int i = 0; i < 10000; i++) {
			this.num ++;
		}
	}
	public int getNum() {
		return num;
	}
}

class Child extends Parent{
	@Override
	public void overrideableMethod() {
		new Thread(new Runnable() {
			public void run() {
				int num = getNum();
				System.out.println("The value of num::: "+num);
			}
		}).start();
	}
}
