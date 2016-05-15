package org.lx.patterns.syn.publishEscape;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class AnonymousInnerInstanceIsPublishedToThisClass {

	private BlockingQueue<Inner> inns = new LinkedBlockingQueue<Inner>();

	public void publish(Inner inn) {
		inns.add(inn);
	}

	public void haha() {
		while (true) {
			try {
				inns.take().InThisMethodWeHoldARefToOuterthisWhichCausesPotentialLeakOfPartiallyInitializedOuterInstance();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
