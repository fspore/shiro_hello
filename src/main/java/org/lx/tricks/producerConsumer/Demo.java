package org.lx.tricks.producerConsumer;

public class Demo {
	public static void main(String[] args) {
		Stock stock = new Stock();
		Producer producer = new Producer(stock);
		Consumer consumer = new Consumer(stock);
		
		for (int i = 0; i < 1; i++) {
			Thread t = new Thread(producer, "producer " + i);
			t.start();
		}
		for (int i = 0; i < 2; i++) {
			Thread t = new Thread(consumer, "consumer " + i);
			t.start();
		}
	}
}
