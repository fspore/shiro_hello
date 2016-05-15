package org.lx.shiro_hello;

import java.util.concurrent.BlockingQueue;


public class VolatileTest {
	
	private static volatile int a = 0;
	public static void main(String[] args) throws Exception {

		Runnable target = new Runnable() {
			public void run() {
				for (int i = 0; i < 100000; i++) 
					a += 1;
			}
		};
		
		Runnable target2 = new Runnable() {
			public void run() {
				for (int i = 0; i < 1; i++) {
					System.out.println("_________"+a+"_________");
				}
			}
		};
		
		
		Runnable target3 = new Runnable(){
			private Fl f = new Fl();
			public void run() {
				f.tl = new ThreadLocal();
				System.out.println(f.tl);
			}
		};
		
		Thread t1, t2;
		t1 = new Thread(target3);
		t2 = new Thread(target3);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		BlockingQueue qq;
		System.out.println(a);
		
		
	}
}

class Fl{
	ThreadLocal<String> tl = new ThreadLocal<String>(){
		@Override
		protected String initialValue() {
			// TODO Auto-generated method stub
			return super.initialValue();
		}
	};
	
}