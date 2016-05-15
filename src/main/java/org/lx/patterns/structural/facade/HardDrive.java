package org.lx.patterns.structural.facade;

public class HardDrive {
	
	public byte[] read(long position, int size) {
		System.out.println("HardDrive reads data from position " +position);
		return new byte[]{1,2,3,4,5,6};
	}
}
