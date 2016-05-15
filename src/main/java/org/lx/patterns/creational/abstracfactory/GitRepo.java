package org.lx.patterns.creational.abstracfactory;

public class GitRepo implements IRepository{
	
	public Profile findProfile(String profileName) {
		return new GitProfile(profileName);
	}
}
