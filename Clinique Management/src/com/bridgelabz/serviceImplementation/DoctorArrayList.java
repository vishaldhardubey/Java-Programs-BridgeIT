package com.bridgelabz.serviceImplementation;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.model.Doctor;

public class DoctorArrayList {
	private List<Doctor> doctorArray=new ArrayList<>();

	public List<Doctor> getDoctorArray() {
		return doctorArray;
	}

	public void setDoctorArray(List<Doctor> doctorArray) {
		this.doctorArray = doctorArray;
	}
	
}
