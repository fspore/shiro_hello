package org.lx.tricks.producerConsumer;

public class Producer implements Runnable {

	private Stock stock;
	
	public Producer( Stock stock) {
		this.stock = stock;
	}
	
	public void run() {
		for (int i = 0; i < 1000; i++) {
			try {
				Thread.sleep((long) (Math.random()*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			stock.addProduct(i);
		}
	}

}
