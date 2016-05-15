package org.lx.patterns.syn.q5;
/**
 * 只包含单一个Thread safe的对象SynObj,但是Product却不是Thread safe的。
 * 因为m1中。multipe variables or multiple public method participate in an invariant. That invariant is not atomiced.
 * @author lx
 *
 */
public class Product {
	private final SynObj synObj = new SynObj();
	
	synchronized public void initIfNotAlready(String val) {
		if(!synObj.isInited())
			synObj.initVal(val);
	}

	public SynObj getSynObj() {
		return synObj;
	}
	
	
	
}
