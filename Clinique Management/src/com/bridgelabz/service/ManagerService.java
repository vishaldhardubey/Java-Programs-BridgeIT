package com.bridgelabz.service;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.parser.ParseException;

public interface ManagerService {
	public void addPatient() throws IOException, ParseException;
	public void updatePatientDetails() throws IOException, ParseException;
	public void deletePatient() throws JsonGenerationException, JsonMappingException, IOException, ParseException;
	public void showDoctorDetails() throws IOException, ParseException;
	public void searchDoctorbyName() throws IOException, ParseException;
	public Object searchDoctorbyId(long doctorID) throws IOException, ParseException;
	public void searchDoctorbyAvailability() throws IOException, ParseException;
}
