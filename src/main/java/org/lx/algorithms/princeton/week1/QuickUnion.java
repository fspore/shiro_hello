package org.lx.algorithms.princeton.week1;

public class QuickUnion {
	int[] ids;
	
	public static void main(String[] args) {
		QuickUnion qu = new QuickUnion(10);
		
		qu.union(2, 3);
		qu.union(0, 1);
		qu.union(5, 7);
		qu.union(6, 2);
		qu.union(1, 2);
		qu.union(8, 9);
		qu.union(9, 8);
		
		int[][] tests = {{2,3},{1,6},{1,5},{0,7},{8,9},{0,6}};
		for (int i = 0; i < tests.length; i++) {
			int m = tests[i][0];
			int n = tests[i][1];
			System.out.printf("is connected (%d, %d) : %s\n",
					m, n, qu.isConnected(m, n));
		}
		
	}
	
	
	public QuickUnion(int n){
		ids = new int[n];
		for (int i = 0; i < ids.length; i++) {
			ids[i] = i;
		}
	}
	/**注意这个不要写成ids[m] = n 了,想想为什么。 A:可能会在rootOf()中出现无限循环*/
	public void union(int m, int n) {
		ids[m] = rootOf(n);
	}
	
	private int rootOf(int n) {
		int nid = ids[n];
		while (nid != n) {
			n = nid;
			nid = ids[n];
		}
		return nid;
	}
	
	public boolean isConnected(int m, int n) {
		return rootOf(m) == rootOf(n);
	}
}
