package org.lx.patterns.structural.proxy;

@SuppressWarnings("unused")
public class Image implements IImage{
	
	private String path;
	private int extent;
	private byte[] bs;

	public Image(String path) {
		this.path = path;
		this.bs = load(path);
	}
	
	public void draw(){
		System.out.println("drawing a picture");
	}
	
	public int getExtent() {
		return calculateExtent();
	}
	

	private int calculateExtent() {
		int scale = 1;
		extent = 100 * scale;
		return extent;
	}

	private byte[] load(String path) {
		System.out.println("it takes a long time to load");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("image loaded");
		return new byte[]{0,1,2,1,0,0,1};
	}
}
