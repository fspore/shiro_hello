package org.lx.patterns.syn.q5;

public class SynObj {

	private volatile boolean inited = false;
	private volatile String val;
	
	synchronized public boolean isInited(){
		return inited;
	}
	
	synchronized public void initVal(String val){
		this.val = val;
		System.out.println("_________"+val+"_________" + Thread.currentThread().getName());
		inited = true;
	}
	
	@Override
	public String toString() {
		return "SynO [inited=" + inited + ", val=" + val + "]";
	}
	
}
