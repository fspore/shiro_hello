package org.lx.patterns.syn.publishEscape;

public class Outer {
	private int num;
	
	public Outer(AnonymousInnerInstanceIsPublishedToThisClass src) {
		// TODO Auto-generated constructor stub
		src.publish(new Inner(){
			public void InThisMethodWeHoldARefToOuterthisWhichCausesPotentialLeakOfPartiallyInitializedOuterInstance(){
				if (num != 42) {
					System.out.println("leaking !! 在if(num!=42)判断时,num还没有赋值为42,但如果这里也read num的话,则有可能是42,因为是第二次read:::"+num);
				} else {
					System.out.println("lucky, no leaking");
				}
			}
		});
		num = 42;
		
	}

}
