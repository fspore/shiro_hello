package org.lx.patterns.creational.abstracfactory;

public class SVNRepo implements IRepository{
	
	public Profile findProfile(String profileName) {
		return new SVNProfile(profileName);
	}
}
