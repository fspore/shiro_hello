package org.lx.blockmethod;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockDemo {
	
	private ReentrantLock lock = new ReentrantLock();
	private Condition notEmpty = lock.newCondition();
	private int count = 0;

	public void blockingUntilProceeding() throws Exception {
		System.out.println("\t[INFO]\tBlockDemo#blockingUntilProceeding() is invoked");
		ReentrantLock lock = this.lock;
		lock.lock();
		while(count==0){ //while empty, wait until Condition.signal
			System.out.println("_________while: this won't busy wait, so only one line_________");
			notEmpty.await();
		}
		lock.unlock();
		System.out.println("_________count is no longer 0 end_________");
		
		
	}

	public void trigger() {
		lock.lock();
		System.out.println("\t[INFO]\tBlockDemo#trigger() is invoked");
		count++;
		notEmpty.signal();
		lock.unlock();
	}

}
