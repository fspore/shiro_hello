package org.lx.patterns.structural.proxy.client;

import org.lx.patterns.structural.proxy.ImageProxy;

public class Client {
	public static void main(String[] args) {
		String path = "d:/abc/apple.jpg";
		ImageProxy image = new ImageProxy(path);
		image.draw();
		image.draw();
		image.draw();
	}
}
