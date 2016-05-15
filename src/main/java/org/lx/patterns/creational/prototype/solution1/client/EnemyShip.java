package org.lx.patterns.creational.prototype.solution1.client;

import org.lx.patterns.creational.prototype.solution1.framework.Graphic;

public class EnemyShip implements Graphic{

	public EnemyShip clone() {
		try {
			return (EnemyShip) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void draw() {
		System.out.println("drawing a EnemyShip!" + this.toString().substring(this.toString().indexOf("@")));
	}

}

