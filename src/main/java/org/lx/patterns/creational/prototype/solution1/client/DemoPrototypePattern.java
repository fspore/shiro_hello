package org.lx.patterns.creational.prototype.solution1.client;

import org.lx.patterns.creational.prototype.solution1.framework.Graphic;
import org.lx.patterns.creational.prototype.solution1.framework.GraphicTool;
import org.lx.patterns.creational.prototype.solution1.framework.Prototype;
/**
 * <pre>
 * <p style="color:red">framework里的一个类及两个接口{@link GraphicTool},{@link Prototype},{@link Graphic}
 * 即构成一个使用prototype设计模式的场景。</p>
 * <span style="color:#ff8000">
 * GraphicTool想要设计一个spawnRandomly()的方法,也就是说GraphicTool
 * 想要设计一个procedural,这个procedural会specify什么时候创建新对象,
 * 创建几个,怎么排列组合;但这个procedural不知道也不必知道这个对象的具体类型。
 * </span>
 * <span style="color:blue">
 * 如果你发现自己在subclass一大堆,而这些subclasses有两个特点:
 * A)只有一个的具体类型上不一样。
 * 比如BreedFarm, BreddFarmForCat, BreedFarmForDog, BreedFarmForDragon。
 * 这个类型可以位于field,可以位于TypeParameter,可以位于method parameter。
 * B)这些subclass都有逻辑,需要建这些类型的instances。
 * 这时候可以考虑使用Prototype pattern
 * 
 * 
 * </span>
 * 所以让Graphic接口extend Cloneable,告诉GraphicTool:"我有一个办法
 * 可以得到克隆的Graphic对象。",这样Graphic Tool就相信了Graphic的声称,
 * 于是可以放心地call prototype.clone()来得到某个concrete graphic对象
 * 的克隆,这是可以保证的,因为prototype是GraphicTool的强制性依赖,想要实例化
 * GraphicTool, Client就必须提供一个Graphic实例作为prototype, 而
 * 根据Graphic接口的contract, 这个prototype必有可以用的clone()方法。
 * </pre>
 * @author lx
 *
 */
public class DemoPrototypePattern {
	public static void main(String[] args) throws CloneNotSupportedException {
		GraphicTool staffGraphicToolTool = new GraphicTool(new EnemyShip());
		staffGraphicToolTool.spawnRandomly(9);
	}
}
