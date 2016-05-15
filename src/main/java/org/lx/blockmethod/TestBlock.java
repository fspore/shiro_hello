package org.lx.blockmethod;

public class TestBlock {
	
	public static void main(String[] args) throws Exception {
		
		final BlockDemo bd = new BlockDemo();
		Runnable target = new Runnable() {
			public void run() {
				try {
					bd.blockingUntilProceeding();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		Thread thread = new Thread(target, "Good");
		thread.start();
		Thread.sleep(2000);//simulates the situation in which other thread is doing something for some time, then trigger the
							//Condition notEmpty
		bd.trigger();
	}
}
