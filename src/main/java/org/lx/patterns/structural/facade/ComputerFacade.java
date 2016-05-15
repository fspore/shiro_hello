package org.lx.patterns.structural.facade;

import static org.lx.patterns.structural.facade.Constants.BOOT_ADDRESS;
import static org.lx.patterns.structural.facade.Constants.SECTOR_SIZE;

public class ComputerFacade {
	
	private HardDrive hd;
	private CPU processor;
	private Memory ram;

	public ComputerFacade() {
		this.processor = new CPU();
		this.ram = new Memory();
		this.hd = new HardDrive();
	}
	
	public void start() {
		processor.freeze();
		ram.load(BOOT_ADDRESS, hd.read(BOOT_ADDRESS, SECTOR_SIZE));
		processor.jump(BOOT_ADDRESS);
		processor.execute();
	}
}
