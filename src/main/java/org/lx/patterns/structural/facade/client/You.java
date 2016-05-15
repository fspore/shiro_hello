package org.lx.patterns.structural.facade.client;

import org.lx.patterns.structural.facade.ComputerFacade;

public class You {
	public static void main(String[] args) {
		ComputerFacade computer = new ComputerFacade();
		computer.start();
	}
}
