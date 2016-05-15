package org.lx.threadpool;

import java.io.BufferedReader;
import java.net.SocketImpl;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class TestThreadPool {
	
	public static void main(String[] args) throws Exception {
		int maxThread = 5;
		BlockingQueue<Runnable> tasks = new ArrayBlockingQueue<Runnable>(6);
		MyThreadPool threadPool = new MyThreadPool(tasks, maxThread);
		
		Runnable task = new Runnable() {
			int num = 0;
			public void run() {
				System.out
						.println("\t[INFO]\trequest "+ (num++) +" is handled"
								+ " by "+Thread.currentThread().getName());
			}
		};
		
		for (int i = 0; i < 100; i++) {
			Thread.sleep((long) (2000*Math.random()));
			threadPool.addTask(task);
			if(i == 10){
				threadPool.endOneThread(0);
				threadPool.endOneThread(1);
				threadPool.endOneThread(2);
				threadPool.endOneThread(3);
				threadPool.endOneThread(4);
			}
		}
		
//		ReentrantLock lock;
	}
}
