package org.lx.patterns;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreading {
	public static void main(String[] args) {
		Thread t1, t2, t3, t4;
		final Obj obj = new Obj();
		Runnable task = new Runnable() {
			public void run() {
				for (int i = 0; i < 200; i++) {
					obj.method1();
				}
			}
		};
		Runnable task2 = new Runnable() {
			public void run() {
					obj.method2();
			}
		};
		t1 = new Thread(task, "haha");
		t2 = new Thread(task, "wii");
		t3 = new Thread(task, "sony");
		t1.start();
		t2.start();
		t3.start();
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		obj.out.setNum(1);
		t4 = new Thread(task2, "xbox");
		t4.start();
		yoyo();
	}

	private static void yoyo() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("_________yoyo_________");
		}
	}
}


class Obj{
	public Out out = new Out();
	private ReentrantLock lock;
	public Condition good;
	public Obj() {
		// TODO Auto-generated constructor stub
		lock = new ReentrantLock();
		good = lock.newCondition();
		
	}
	
	public void method1(){
		ReentrantLock lock = this.lock;
		lock.lock();
		System.out.println("________" + Thread.currentThread().getName());
		while (out.getNum() == 1) {
			System.out.println("_________delimeter_________");
			try {
				good.await();
			} catch (Exception e) {
				System.out.println("_________exception_________");
			}
		}
		
		lock.unlock();
	}
	
	public void method2(){
		ReentrantLock lock = this.lock;
		lock.lock();
		System.out.println("_________Now I'm coming_________");
		good.signalAll();
		lock.unlock();
	}
	
	
}

class Out{
	public int num = 0;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}