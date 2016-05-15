package org.lx.patterns.syn.q5;

import java.util.concurrent.locks.ReentrantLock;


public class DemoSyn {
	public static void main(String[] args) {
		Thread[] ts = new Thread[10];
		final Product p = new Product();
		Runnable task = new Runnable() {
			private String[] candidates = {"abc", "123", "xyz", "haha", "sub zero", "bullshit"};
			public void run() {
				p.initIfNotAlready(candidates[(int)(Math.random()*candidates.length)]);
			}
		};
		ReentrantLock l = null;
		for (int i = 0; i < ts.length; i++)
			ts[i] = new Thread(task, "线程"+i);
		
		for (int i = 0; i < ts.length; i++) {
			ts[i].start();
		}
		//即使Product里也synchronize了,但是出现了在main thread中没有被同一个lock保护住的代码,操作了shared variable SynObj
		//所以出现了上面for循环中对SynObj中的val field的lazy init无效的情况。
		p.getSynObj().initVal("jojo");
		System.out.println(p.getSynObj());
		
	}
}


