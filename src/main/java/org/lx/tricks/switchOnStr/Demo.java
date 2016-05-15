package org.lx.tricks.switchOnStr;

public class Demo {
	
	public void foo(String str) {
		Color color = Color.fromString(str);
		switch (color) {
		case GREEN: /*do some stuff*/; break;
		case RED: 	/*do some stuff*/; break;
		case YELLOW:/*do some stuff*/; break;
		case UNDEFINED:/*default behavior*/; break;
		}
		//goes on
	}
}

enum Color{
    GREEN, RED, YELLOW, UNDEFINED;
    public static Color fromString(String stringName) {
        for(Color col : Color.values()) {
            if(col.name().equalsIgnoreCase(stringName)) {
                return col;
            }
        }
        return UNDEFINED;
    }
}