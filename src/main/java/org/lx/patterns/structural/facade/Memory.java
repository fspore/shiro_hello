package org.lx.patterns.structural.facade;

import java.util.Arrays;

public class Memory {
	
	public void load(long position, byte[] data) {
		System.out.printf("Memory is loading data %s from position %s\n", Arrays.toString(data), position);
	}
}
