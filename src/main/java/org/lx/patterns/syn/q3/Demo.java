package org.lx.patterns.syn.q3;

public class Demo {
	public volatile ImmutableValue im = new ImmutableValue(0);
	
	public void notThreadSafe(){
		im = new ImmutableValue(im.getI() + 1);
	}
	
	public static void main(String[] args) {
		final Demo demo = new Demo();
		Runnable tsk = new Runnable() {
			public void run() {
				demo.notThreadSafe();
			}
		};
		
		for (int i = 0; i < 10000; i++) {
			Thread t = new Thread(tsk);
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			t.start();
		}
		System.out.println(demo.im);
	}

}


class ImmutableValue{
	private final int i;
	
	public ImmutableValue(int i) {
		this.i = i;
	}
	public int getI() {
		return i;
	}
	@Override
	public String toString() {
		return "ImmutableValue [i=" + i + "]";
	}
}