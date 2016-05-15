package org.lx.blockmethod;

public class WaitingUsingSynDemo {

	public static void main(String[] args) {
		final WaitingUsingSynDemo demo = new WaitingUsingSynDemo();
		
		new Thread(){
			@Override
			public void run() {
				demo.process();
			};
		}.start();
		
		new Thread(){
			@Override
			public void run() {
				while (!demo.isDataDownloaded())
					demo.retriveData();
			};
		}.start();
		
	}

	private boolean dataDownloaded = false;
	

	public boolean isDataDownloaded() {
		return dataDownloaded;
	}

	public void setDataDownloaded(boolean dataDownloaded) {
		this.dataDownloaded = dataDownloaded;
	}

	public synchronized void process() {
		try {
			while (!dataDownloaded) {
				System.out.println("_________no data, wait_________");
				this.wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void retriveData() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.notify();
	}
}
