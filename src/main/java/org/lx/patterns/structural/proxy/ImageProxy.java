package org.lx.patterns.structural.proxy;

public class ImageProxy implements IImage{

	private String path;
	private IImage realImage;
	
	public ImageProxy(String path) {
		this.path = path;
	}
	
	public void draw() {
		if (realImage == null) {
			realImage = new Image(path);
		}
		realImage.draw();
	}

	public int getExtent() {
		if (realImage == null)
			return getImageInfoButNotLoadIt();
		return realImage.getExtent();
	}

	
	private int getImageInfoButNotLoadIt() {
		return 100;
	}

}
