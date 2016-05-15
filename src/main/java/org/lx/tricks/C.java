package org.lx.tricks;

import java.util.ArrayList;

interface A {
	int x = 99;
}

class B {
	int x = 1;
}

public class C extends B implements A {
	public void pX() {
		System.out.println(A.x);
	}

	public static void main(String[] args) {
		new C().pX();
	}

	public synchronized Object pop() throws Exception {
		ArrayList list = null;
		synchronized (list) {
			if (list.size() <= 0) {
				wait();
			}
			return list.remove(1);
		}
	}
}
