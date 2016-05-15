package org.lx.patterns.etc.nullobject.v2;

import java.util.List;

public class Dao<T> {

	private List<T> data;

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
	
	
}
