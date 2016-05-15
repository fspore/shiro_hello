package org.lx.patterns.syn.q1;


public class GetterSetterDemo {
	public static void main(String[] args) {
		final Doo doo = new Doo();
		Thread t1, t2, t3, t4, t5, t6, t7, t8, t9;
		Runnable r1 = new Runnable() {
			public void run() {
				System.out.println(doo.getNum() + ":::" + Thread.currentThread().getName());
			}
		};
		Runnable r2 = new Runnable() {
			public void run() {
				doo.setNum(-7);
			}
		};
		t1 = new Thread(r1, "t1");
		t2 = new Thread(r2, "t2");
		t3 = new Thread(r1, "t3");
		t4 = new Thread(r1, "t4");
		t5 = new Thread(r1, "t5");
		t6 = new Thread(r1, "t6");
		t7 = new Thread(r1, "t7");
		t8 = new Thread(r1, "t8");
		t9 = new Thread(r1, "t9");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		
	}
}

class Doo{
	private int num;

	public  int getNum() {
		class Ao{
			private String s = "Ao";
			@Override
			public String toString() {
				return "Ao [s=" + s + "]" + Doo.this;
			}
		}
		System.out.println(new Ao());
		
		return num;
	}

	public synchronized void setNum(int num) {
		for (int i = 0; i < 100000; i++) {
			this.num++;
		}
	}

	@Override
	public String toString() {
		return "Doo [num=" + num + "]";
	}
	
	
	
}
