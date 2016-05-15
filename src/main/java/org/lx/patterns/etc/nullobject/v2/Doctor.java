package org.lx.patterns.etc.nullobject.v2;

public class Doctor {

	private long id;
	
	private String name;
	
	private long hospitalId;
	
	

	public Doctor() {
		super();
	}
	
	

	public Doctor(long id, String name, long hospitalId) {
		super();
		this.id = id;
		this.name = name;
		this.hospitalId = hospitalId;
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

	public long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(long hospitalId) {
		this.hospitalId = hospitalId;
	}



	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", hospitalId="
				+ hospitalId + "]";
	}
	
	
	
}
