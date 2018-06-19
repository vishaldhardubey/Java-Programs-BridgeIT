package com.bridgelabz.service;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public interface PatientService {
	public boolean takeAppointment() throws IOException, ParseException;
	public void showPatientDetails() throws IOException, ParseException;
	public boolean searchPatientByName() throws IOException, ParseException;
	public Object searchPatientByMobileNum(long mobileNum) throws IOException, ParseException;
	public void searchPatientById() throws IOException, ParseException;
	public void showPopularDoctor() throws IOException, ParseException;
	public void showPopularSpecialization() throws IOException, ParseException;
}
