package org.lx.patterns.creational.prototype.solution1.framework;

public class GraphicTool {
	
	private Graphic prototype;

	public GraphicTool(Graphic prototype) {
		this.prototype = prototype;
	}
	
	public void spawnRandomly(int num){
		Graphic g;
		for (int i = 0; i < num; i++) {
			g = prototype.clone();
			g.draw();
		}
	}
	
}
