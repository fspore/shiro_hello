package org.lx.patterns.syn.publishEscape;

import java.io.FileNotFoundException;

/**
 * <pre>
 * 关于匿名内部类会造成其enclosing Outer instance的发布被escape掉。
 * 匿名内部类的instance    为 A 是interface IA的一个匿名implementation的instance
 * enclosing instance  为 B
 * 
 * A的方法中,如果有对B进行调用的代码比如 A.doSomething(){B.field ...}。那么这个调用可能是危险的。
 * 证明如下：
 * 	如果 有这样一行代码  someOtherObj.register(new IA(){@Override... } ); 它的意思是把A publish 给这个 someOtherObj;
 *  你并不知道someOtherObj内部是什么样的,但你知道它能够拿到A的reference。也就是说someOtherObj能够通过这个reference来call A.doSomething();
 *  而someOtherObj是什么时候得到A的reference的呢？是在执行完 someOtherObj.register(new IA(){@Override... });这个时间点t1时立刻得到的,那么
 *  someOtherObj也就能在t1时立刻call A.doSomething();(比如某一个线程监视someOtherObj的状态,一旦有A的实例被注册,立刻call该实例的doSomething方法 )
 *  这个时候问题来了。
 *  时间点t1的时候,B不一定完成了初始化。
 *  {@code
 *  	someOtherObj.register(new IA(){@Override... } );
 *  	do a lot of stuff;
 *  	initB();
 *  }
 * 更详尽的解释在http://www.javaspecialists.eu/archive/Issue192.html
 * </pre>
 * @author lx
 *
 */
public class Demo {
	public static void main(String[] args) {
		final AnonymousInnerInstanceIsPublishedToThisClass src = new AnonymousInnerInstanceIsPublishedToThisClass();
		Runnable tsk = new Runnable() {
			public void run() {
				src.haha();
			}
		};
		new Thread(tsk, "test").start();
		
		while (true) {
			wait1sec(1);
			new Outer(src);
		}
	}

	private static void wait1sec(int millseconds) {
		try {
			Thread.sleep(millseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}

class Mocking{
	@SuppressWarnings("unchecked")
	public <E extends Throwable> void throwAs(Throwable e) throws E{
		throw (E) e;
	}
	
	public static void main(String[] args) {
		new Thread(new Runnable() {
			public void run() {
				new Mocking().<RuntimeException>throwAs(new FileNotFoundException());
			}
		}).start();
	}
}
