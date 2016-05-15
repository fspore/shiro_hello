package org.lx.patterns.structural.bridge.solution1;


/**
 * <pre>
 * 其实本质上是：
 * <span style="color:blue">
 * 	一种视角：把primitive api与non-primitive api进行分离。
 * 
 *  另一种视角：因为在一个Abstraction hierarchy不断扩展的过程中,
 *  有些extension是水平方向的,与向下扩展的方向垂直。比如A-->Aa, Ab;
 *         A
     /     \
    Aa      Ab
 *  而如果此后又要向下extend的话,由于多了一个起点,所以垂直扩展的路线就多了一条。
 *  这样滚雪球,会造成subclass过多。所以需要用Bridge pattern进行
 *  分离。这也是为什么Prefer Composition/Aggregation to Inheritance
 *          A
     /     \
    Aa      Ab
   /         \
 Aa@  	     Ab@
 *  
 *  <a href="http://stackoverflow.com/a/319757/2961429">Stackoverflow</a>
 * </span>
 * 
 * <span style="color:red"><em>
 *   Say you must implement a hierarchy of colored shapes. 
 *   You wouldn't subclass Shape with Rectangle and Circle 
 *   and then subclass Rectangle with RedRectangle, 
 *   BlueRectangle and GreenRectangle and the same for Circle, 
 *   would you? You would prefer to say that each Shape has a 
 *   Color and to implement a hierarchy of colors, and that is 
 *   the Bridge Pattern. Well, I wouldn't implement a "hierarchy 
 *   of colors", but you get the idea...
 * </em></span>
 * 
 * 一个Class hierachy的API中, 有些是primitive api,
 * 有些是non-primitive。比如电视的turn on, turn off, set channel这些
 * 是primitive api,它们的实现逻辑是厂商各异的。并且重要特征是：不会调用其他
 * primitive api。(有极少例外,比如add()与addAll() )
 * 而non-primitive api则是会以primitive api为基础砖块来构建逻辑
 * 的api, 比如 prevChannel(), nextChannel(),这两个api
 * 可以用setChannel()来间接实现。
 * 
 * 而primitive api基本是不变的。non-primitive api却可能改变。
 * 所以把它们分离成两个hierarchy树。由non-primitive一方保有对方的
 * reference。
 * <span style="color:red">
 * 要点在于,把primitve api分离出去,与non-primitve api构成aggregation
 * 或者composition的关系而非inheritance的关系。?
 * </span>
 * 
 * <span style="color:blue">
 * 	另一个例子是《Design Patterns》pdfpage163中提到的。
 * MS平台与Mac平台下,要在桌面画一个Window这个东西。由于两个平台的实现是不一样的,
 * 即primitive api不一样。但是我们并不关心这个不一样。这个不同应该从runtime
 * 传进来,而不是在compile time写死。也就是说,我们在compile time应该被允许
 * new一个Window的对象,而这个对象并不是platform dependent的。我们真的能
 * 做到这一点吗？实际上不能。应该换句话说——我们在compile time应该被允许实例化一
 * 个platform independent的Window的概念。这个是应该被允许的。
 * 至于Window的platform dependent的基础细节WindowImp这个包含了
 * primitive api的实例, 则应该在run-time时动态创建。然后我们可以对Window
 * 这个hierarchy进行自由扩展,比如:
 * 
 * IconWindow extends Window
 * TransientWindow extends Window
 * 
 * 而对WindowImp这另一个hierarchy也可以进行自由implement,比如:
 * 
 * PS3WindowImp implements WindowImp
 * AndroidWindowImp implements WindowImp
 * </span>
 * </pre>
 * @author lx
 *
 */
public class Client {
	public static void main(String[] args) throws InterruptedException {
		ConcreteRemote remote = new ConcreteRemote(detectCurrentTV());
		remote.on();
		remote.nextChannel();
		Thread.sleep(1500);
		remote.nextChannel();
		Thread.sleep(800);
		remote.nextChannel();
		Thread.sleep(1000);
		remote.prevChannel();
		Thread.sleep(1000);
		remote.off();
	}
	
	
	public static TV detectCurrentTV(){
		//suppose we somehow finds out it is sony at run-time
		return new Sony();
	}
}
