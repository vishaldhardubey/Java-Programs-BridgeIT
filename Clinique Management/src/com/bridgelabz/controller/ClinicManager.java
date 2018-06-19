package com.bridgelabz.controller;

import java.io.IOException;

import javax.xml.stream.events.StartDocument;

import org.json.simple.parser.ParseException;

import com.bridgelabz.serviceImplementation.DoctorServiceImplementation;
import com.bridgelabz.serviceImplementation.ManagerServiceImplementation;
import com.bridgelabz.serviceImplementation.PatientServiceImplementation;
import com.bridgelabz.utility.Utility;

public class ClinicManager {
	static DoctorServiceImplementation doctor=new DoctorServiceImplementation();
	static ManagerServiceImplementation serviceManager =new ManagerServiceImplementation();
	static PatientServiceImplementation patient=new PatientServiceImplementation();
	
	/**
	 * Function is to perform every task
	 * @param args
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void main(String[] args) throws IOException, ParseException {
		System.out.println("Welcome to Congress Hospital!!!");
		System.out.println("1. Add Doctor Details\t\t\t 2.Delete Doctor Details");
        System.out.println("3. Update Doctor Details\t\t 4.Show Doctor List");
        System.out.println("5. Add petient Details\t\t\t 6. Delete Paient Details");
        System.out.println("7. Update Patient Details\t\t 8. Show PatientList");
        System.out.println("9. Search Doctor\t\t\t 10.Search Paitent");
        System.out.println("11.Show Popular Specialization\t\t 12.Show Popular Doctor ");
        System.out.println("13.Take Appointment");
	    int choice = Utility.scanInt();
		
	    switch (choice) {
		case 1:
				doctor.addDoctor();
			break;
		case 2:
				doctor.doDelete();
			break;
		case 3:
				doctor.doEdit();
			break;
		case 4:
				serviceManager.showDoctorDetails();
			break;
		case 5:
				serviceManager.addPatient();
			break;
		case 6:
				serviceManager.deletePatient();
			break;
		case 7:
				serviceManager.updatePatientDetails();
			break;
		case 8:
				patient.showPatientDetails();	
			break;
		case 9:
				startDocSearch();
			break;
		case 10:
				startPatientSearch();
			break;
		case 11:
				patient.showPopularSpecialization();
			break;
		case 12:
				patient.showPopularDoctor();
			break;
		case 13:
				patient.takeAppointment();
			break;
		default:
				System.out.println("Invalid Input \nPlease Enter Again");
				main(args);
			break;
		}
	}
	
	public static void startDocSearch() throws IOException, ParseException {
		System.out.println("How do you wanna search a doctor???");
		System.out.println("1- Search Doctor by Name");
		System.out.println("2- Search Doctor by Doctor ID");
		System.out.println("3- Search Doctor by Availability");
		int key=Utility.scanInt();
		switch (key) {
		case 1:
			serviceManager.searchDoctorbyName();
			break;
		case 2:
			System.out.println("Enter the doctor Id");
			long id=Utility.scanLong();
			serviceManager.searchDoctorbyId(id);
			break;
		case 3:
			serviceManager.searchDoctorbyAvailability();
			break;
		default:
			System.out.println("Invalid Input \n Please Enter again");
			startDocSearch();
			break;
		}
	}
	public static void startPatientSearch() throws IOException, ParseException {
		System.out.println("How do you wanna search a patient???");
		System.out.println("1- Search Patient by Name");
		System.out.println("2- Search Patient by Doctor ID");
		System.out.println("3- Search Patient by Mobile Number");
		int key=Utility.scanInt();
		switch (key) {
		case 1:
			patient.searchPatientByName();
			break;
		case 2:
			patient.searchPatientById();
			break;
		case 3:
			patient.searchPatientByMobileNum(key);
			break;
		default:
			System.out.println("Invalid Input \n Please Enter again");
			startPatientSearch();
			break;
		}
	}
}
