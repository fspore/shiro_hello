package org.lx.patterns.syn.q4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Singleton {
	private static Singleton instance;
	private boolean inUse;
	private int val;
	private final Map map;

	private Singleton() {
		inUse = true;
		val = 9999;
		this.map = new HashMap();
	}

	public static Singleton getInstance() {
		if (instance == null)
			instance = new Singleton();
		return instance;
	}
	
	public static void main(String[] args){
		Singleton s = new Singleton();
		Map abc = s.map;
		int i = 0;
		while(i++<10000){
			getInstance();
		}
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter a number");
		int n = reader.nextInt();
		System.out.println("Thank you " + n);
	}
}