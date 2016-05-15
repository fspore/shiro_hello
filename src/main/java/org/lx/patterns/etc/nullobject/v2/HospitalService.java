package org.lx.patterns.etc.nullobject.v2;

import java.util.ArrayList;
import java.util.List;

public class HospitalService {

	private Dao<Hospital> hospitalDao;
	{
		hospitalDao = new Dao<>();
		
		List<Hospital> data = new ArrayList<>();
		data.add(new Hospital(1, "hos1"));
		data.add(new Hospital(2, "hos2"));
		data.add(new Hospital(3, "hos3"));
		
		hospitalDao.setData(data);
	}
	
	private static final Hospital NULL_HOSPITAL = new Hospital();
	public Hospital queryHospital(long hospitalId) {
		List<Hospital> data = hospitalDao.getData();
		for (Hospital hospital : data) {
			if(hospitalId == hospital.getId()){
				return hospital;
			}
		}
		return NULL_HOSPITAL;
	}
	
	
}
