package org.lx.blockmethod;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 没有使用java多线程相关技术的阻塞方法,叫busy waiting,
 * 见{@link BlockDemo}使用的{@link ReentrantLock}和{@link Condition}结合的await, signal方式
 * @author lx
 *
 */
public class BusyWaitingDispatcherDemo {
	
	private boolean ready = false;
	public static void main(String[] args) {
		
		final BusyWaitingDispatcherDemo dispatcherDemo = new BusyWaitingDispatcherDemo();
		
		new Thread(){
			@Override
			public void run() {
				dispatcherDemo.waitAndProcess();
			};
		}.start();
		
		new Thread(){
			@Override
			public void run() {
				dispatcherDemo.gotcha();
			}
		}.start();
	}
	
	public void waitAndProcess(){
		while(!ready){
			System.out.println("_________while busy waiting_________");
		}
		System.out.println("process the data");
	}
	
	public void gotcha(){
		System.out.println("_________retrieving data_________");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ready = true;
	}
}
