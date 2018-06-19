package com.bridgelabz.service;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public interface DoctorService {
	public void addDoctor() throws IOException, ParseException;
	public void doEdit() throws IOException, ParseException;
	public void doDelete() throws IOException, ParseException;
	
}
