package org.lx.patterns.etc.nullobject.v2;

public class Hospital {

	private long id;
	
	private String name;
	
	
	

	public Hospital(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Hospital() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", name=" + name + "]";
	}
	
	
}
