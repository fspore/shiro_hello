package org.lx.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class MyThreadPool {
	
	BlockingQueue<Runnable> tasks;
	List<MyThread> threads = new ArrayList<MyThread>();
	
	public MyThreadPool(BlockingQueue<Runnable> tasks, int maxThread) {
		// TODO Auto-generated constructor stub
		this.tasks = tasks;
		for (int i = 0; i < maxThread; i++) {
			threads.add(new MyThread("第"+i+"线程", tasks));
		}
		for (MyThread thread : threads) {
			System.out.println("_________"+thread+"_________");
			thread.start();
		}
	}
	
	public void addTask(Runnable task){
		tasks.add(task);
	}
	
	public void endOneThread(int index){
		MyThread thread = threads.get(index);
		thread.setKeepDoing(false);
	}
}
