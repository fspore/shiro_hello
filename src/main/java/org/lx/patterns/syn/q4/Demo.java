package org.lx.patterns.syn.q4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class Demo {
	private static abstract class MyThread extends Thread{
		private volatile boolean terminated = false;
		public BlockingQueue<Holder> holders = new LinkedBlockingQueue<Holder>();
		public void run() {
			body();
		}
		public abstract void body();
		public void terminate(){
			terminated = true;
		}
		public boolean isTerminated() {
			return terminated;
		}
		
		public void add(Holder h){
			holders.add(h);
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		final MyThread myThread = new MyThread(){
			@Override
			public void body() {
				while(!isTerminated()){
					try {
						holders.take().assertSanity();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}};
		myThread.start();
		
		
		Thread t = null;
		for (int i = 0; i < 10000; i++) {
			final Updater up = new Updater();
			Runnable target = new Runnable() {
				public void run() {
					if (up!=null) {
						try {
							up.init();
							myThread.add(up.holder);
						} catch (NullPointerException e) {}
					}
				}
			};
			t = new Thread(target);
			t.start();
			t.join();
		}
		myThread.terminate();
		System.out.println("_________complete_________");
		
		
	}
}


