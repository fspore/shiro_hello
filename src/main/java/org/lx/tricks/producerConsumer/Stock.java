package org.lx.tricks.producerConsumer;

import java.util.ArrayList;

public class Stock {

	@SuppressWarnings("rawtypes")
	private ArrayList list = new ArrayList(10);
	private int count;
	
	@SuppressWarnings("unchecked")
	public synchronized void addProduct(int i) {
		while (count >= 10) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		list.add(i);
		count++;
		System.out.println("producer "+Thread.currentThread().getName()+"生产了 " + i);
		notify();
	}

	public synchronized int getProduct() {
		while (count == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		Object remove = list.remove(count-- - 1);
		notify();
		System.out.println("消费者"+Thread.currentThread().getName()+"消费了 " + remove);
		return (Integer)remove;
	}

}
