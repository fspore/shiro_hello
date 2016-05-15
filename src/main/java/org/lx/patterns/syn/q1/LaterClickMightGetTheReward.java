package org.lx.patterns.syn.q1;

public class LaterClickMightGetTheReward {
	
	
	
	public static void main(String[] args) {
		Thread t1, t2, t3, t4, t5;
		Runnable r = new Reward();
		t1 = new Thread(r, "Thread 1");
		t2 = new Thread(r, "Thread 2");
		t3 = new Thread(r, "Thread 3");
		t4 = new Thread(r, "Thread 4");
		t5 = new Thread(r, "Thread 5");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

}

class Reward implements Runnable{
	private volatile boolean claimed;
	
	
	public void run(){
		synchronized (this) {
			if (!claimed) {
				claimed = true;
				System.out.println(Thread.currentThread().getName() + ":::" + "get the reward!");
			} else {
				System.out.println(Thread.currentThread().getName() + ":::" + "the reward is already claimed");
			}
		}
		
	}
}