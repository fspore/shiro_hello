package org.lx.patterns.etc.nullobject.v2;

public class Client {

	/**
	 * http://stackoverflow.com/a/271874/2961429
	 * @param args
	 */
	public static void main(String[] args) {
		DoctorService doctorService = new DoctorService();
		
		HospitalService hospitalService = new HospitalService();
		
		long doctorId = 666;
		
		Doctor doctor = doctorService.queryDoctor(doctorId);
		
		//下面这行中的doctor.getHospitalId()就是 NullObjectPattern想达到的目的：不用null check。
		//queryDoctor(id)必返回一个doctor instance。绝对不会返回null。
		//这样做的好处是,client code可以放心地调用api。不必做多余的null check
		Hospital queryHospital = hospitalService.queryHospital(doctor.getHospitalId());
		
		System.out.println(queryHospital);
		
	}
}
