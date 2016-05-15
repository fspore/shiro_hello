package org.lx.patterns.structural.flyweight;

import java.awt.Color;
import java.awt.Point;
/**
 * <pre>
 * {@link Line#Line(Color) Line的Constructor} 以及 {@link LineFlyweight#draw(Point)}
 * 应用这个pattern的场景：
 * 
 * a) Many similar objects are used and the storage cost is high
 * b) The majority of each object's state data can be made extrinsic
 * c) A few shared objects would easily replace many unshared objects
 * d) The identity of each object does not matter
 * 
 * 应用这个pattern主要是判断Flyweight应该怎样构成,哪些算intrinsic属性,哪些算extrinsic属性。
 * 可以首先从verbose开始。把所有属性都当成intrinsic属性。那么画面中会出现数量很多的类似的object,
 * 然后把属性一个一个合理地往外抽。直到不能抽为至。
 * </pre>
 * @see <a href="https://dzone.com/articles/design-patterns-flyweight">这个教程介绍得很好</a>
 * @author lx
 *
 */
public class DemoFlyWeight {
	public static void main(String[] args) {
		LineFlyweightFactory factory = new LineFlyweightFactory();
		//....
		LineFlyweight line = factory.getLine(Color.RED);
		LineFlyweight line2 = factory.getLine(Color.RED);
		//can use the lines independently
		line.draw(new Point(100, 100));
		line2.draw(new Point(200, 100));
		"".substring(1);

	}
}
