package org.lx.threadpool;

import java.util.concurrent.BlockingQueue;

public class MyThread extends Thread{
	
	private BlockingQueue<Runnable> bq;
	private boolean keepDoing = true;

	public MyThread() {
	}

	public MyThread(String name){
		super(name);
	}
	
	public MyThread(String name, BlockingQueue<Runnable> bq){
		this(name);
		this.bq = bq;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(keepDoing ){
			try {
				Runnable task = bq.take();
				task.run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("\t[INFO]\tMyThread#run() is invoked");
		}
	}

	public boolean isKeepDoing() {
		return keepDoing;
	}

	public void setKeepDoing(boolean keepDoing) {
		this.keepDoing = keepDoing;
	}
	
}
