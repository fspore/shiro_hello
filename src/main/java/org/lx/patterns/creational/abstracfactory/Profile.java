package org.lx.patterns.creational.abstracfactory;
/**
 * 这里偷懒了,应该Profile当interface,由gitRepo和svnRepo取得的不是同一个实体灯才行的。
 * @author lx
 *
 */
public class Profile {

	private String profileName;

	public Profile(String profileName) {
		this.profileName = profileName;
	}

	@Override
	public String toString() {
		return "Profile [profileName=" + profileName + "]";
	}
}

class GitProfile extends Profile{
	public GitProfile(String profileName) {
		super(profileName);
	}

	@Override
	public String toString() {
		return "GitProfile [toString()=" + super.toString() + "]";
	}
	
	
}

class SVNProfile extends Profile{
	public SVNProfile(String profileName) {
		super(profileName);
	}

	@Override
	public String toString() {
		return "SVNProfile [toString()=" + super.toString() + "]";
	}
	
	
}
