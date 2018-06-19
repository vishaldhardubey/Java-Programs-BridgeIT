package com.bridgelabz.serviceImplementation;

import java.util.ArrayList;

import com.bridgelabz.model.Patient;

public class PatientArrayList {
	ArrayList<Patient> patientArray=new ArrayList<>();

	public ArrayList<Patient> getPatientArray() {
		return patientArray;
	}

	public void setPatientArray(ArrayList<Patient> patientArray) {
		this.patientArray = patientArray;
	}
}
