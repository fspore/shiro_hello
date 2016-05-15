package org.lx.tricks.producerConsumer;

public class Consumer implements Runnable{

	private Stock stock;
	
	public Consumer(Stock stock) {
		this.stock = stock;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			int p = stock.getProduct();
			try {
				Thread.sleep((long) (Math.random()*100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
