package org.lx.algorithms.princeton.week1.quickfind;

public class QuickFind {
	int[] nodes;
	
	public static void main(String[] args) {
		QuickFind qf = new QuickFind(10);
		System.out.println(qf.connected(2, 7));
		qf.union(0, 1);
		qf.union(2, 3);
		qf.union(5, 7);
		qf.union(8, 7);
		qf.union(3, 5);
		
		
		int[][] tests = {{2,7},{1,3},{2,5},{3,6},{5,8}};
		for (int i = 0; i < tests.length; i++) {
			System.out.printf("is connected (%d, %d) : %s\n", 
					tests[i][0], tests[i][1] ,qf.connected(tests[i][0], tests[i][1]));
		}
	}
	
	
	
	public QuickFind(int n) {
		this.nodes = new int[n];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = i;
		}
	}
	
	public void union(int m, int n) {
		int mid = nodes[m];
		int nid = nodes[n];
		if (mid == nid)
			return;
		for (int i = 0; i < nodes.length; i++)
			if (nodes[i] == mid)
				nodes[i] = nid;
	}
	
	public boolean connected(int m, int n) {
		return isSameGroup(m, n);
	}
	/**未处理边界情况*/
	public boolean isSameGroup(int m, int n) {
		return nodes[m] == nodes[n];
	}
	
	
}
