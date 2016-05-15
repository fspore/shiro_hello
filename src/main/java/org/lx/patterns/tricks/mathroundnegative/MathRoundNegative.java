package org.lx.patterns.tricks.mathroundnegative;
/**
 * <pre>
 * http://stackoverflow.com/a/269735/2961429
 * 无论Math.round(double a)中的a是正positive还是negative,
 * 都作下列运算：
 * 将 (a + 0.5d), 取这个值的floor地板。最后将结果转为long
 * 地板是什么呢?左边就是地板。右边是天花板。
 * -12, -11, -10 ... 1, 2, 3 ...
 * 例子：-11.6 由于处于-12到-11之间,那么对于-11.6,它的地板是左边的-12,天花板是右边的-11
 * 对 -11.6+0.5d 之后得到 -11.1,这个值的floor仍然是 -12,所以输出-12
 * 对 -11.4+0.5d 之后得到 -10.9,这个值的区间变成 -11到-10, 所以floor变成 -11,所以输出-11,
 * 对 -11.5+0.5d 之后得到 -10.0,这个值的区间变成 -11到-10, 所以floor变成 -11,所以输出-11
 * </pre>
 * 
 * @author lx
 *
 */
public class MathRoundNegative{
	public static void main(String[] args) {
        System.out.println(Math.round(-11.6));
        System.out.println("_________delimeter_________");
        System.out.println(Math.round(-11.4));
        System.out.println(Math.round(-11.5));
       
	}
	
}
