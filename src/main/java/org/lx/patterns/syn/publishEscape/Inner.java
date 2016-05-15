package org.lx.patterns.syn.publishEscape;

public interface Inner {
	public void InThisMethodWeHoldARefToOuterthisWhichCausesPotentialLeakOfPartiallyInitializedOuterInstance();
}
