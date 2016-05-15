package org.lx.patterns.structural.flyweight;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

//Flyweight factory
public class LineFlyweightFactory {
	private List<LineFlyweight> pool;

	public LineFlyweightFactory() {
		pool = new ArrayList<LineFlyweight>();
	}

	public LineFlyweight getLine(Color c) {
		// check if we've already created a line with this color
		for (LineFlyweight line : pool) {
			if (line.getColor().equals(c))
				return line;
		}
		// if not, create one and save it to the pool
		LineFlyweight line = newLine(c);
		pool.add(line);
		return line;
	}

	private LineFlyweight newLine(Color c) {
		return new Line(c);
	}
}
