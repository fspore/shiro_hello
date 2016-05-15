package org.lx.patterns.etc.nullobject.v2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DoctorService {

	private Dao<Doctor> docDao = new Dao<>();
	
	{
		List<Doctor> data = new ArrayList<>();
		data.add(new Doctor(1, "doc1", 1));
		data.add(new Doctor(2, "doc2", 1));
		data.add(new Doctor(3, "doc3", 2));
		docDao.setData(data);
	}
	
	private static final Doctor NULL_DOCTOR = new Doctor();
	public Doctor queryDoctor(long id){
		List<Doctor> data = docDao.getData();
		for (Doctor doctor : data) {
			if(id == doctor.getId()){
				return doctor;
			}
		}
		return NULL_DOCTOR;
	}
}
