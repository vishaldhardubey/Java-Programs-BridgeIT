package com.bridgelabz.serviceImplementation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.model.Doctor;
import com.bridgelabz.service.DoctorService;
import com.bridgelabz.utility.Utility;

public class DoctorServiceImplementation implements DoctorService{
	static final String FILE_NAME="/home/administrator/Funtional-Program/Functional-Program/Clinique Management/src/com/bridgelabz/files/Doctor.json";
	DoctorArrayList docList=new DoctorArrayList();
	
	
	/****************************************************************************************************************************************************
	 * Function is to add Doctor in the list
	 * @throws IOException
	 * @throws ParseException
	 */
	@Override
	public void addDoctor() throws IOException, ParseException {
		JSONParser json=new JSONParser();
		List<JSONObject> 
		obj=(List<JSONObject>) json.parse(new FileReader(FILE_NAME));
		
		System.out.println(obj);
        
		System.out.println("Enter the number of entries");
		int scan=Utility.scanInt();
		for (int i = 0; i < scan; i++) {
			Doctor doctor=new Doctor();
			System.out.println("Enter Doctor First Name");
			String fName=Utility.scanString();
			doctor.setDoctorFirstName(fName);
			
			System.out.println("Enter Doctor Last Name");
			String lName=Utility.scanString();
			doctor.setDoctorLastName(lName);
			
			System.out.println("Enter Doctor ID");
			long id=Utility.scanLong();
			doctor.setDoctorId(id);
			
			System.out.println("Enter Doctor Speciality");
			String docSpeciality=Utility.scanString();
			doctor.setDoctorSpeciality(docSpeciality);
			
			System.out.println("Enter Doctor Availability");
			String docAvailability=Utility.scanString();
			doctor.setDoctorAvailability(docAvailability);
			
			System.out.println("Enter Doctor Count");
			int count=Utility.scanInt();
			doctor.setDoctorCount(count);

			docList.getDoctorArray().add(doctor);

			JSONObject jo=new JSONObject();
			jo.put("doctorFirstName",doctor.getDoctorFirstName());
			jo.put("doctorLastName", doctor.getDoctorLastName());
			jo.put("doctorId", doctor.getDoctorId());
			jo.put("doctorSpeciality", doctor.getDoctorSpeciality());
			jo.put("doctorAvailability", doctor.getDoctorAvailability());
			jo.put("doctorCount", doctor.getDoctorCount());
			obj.add(jo);
		}

		JSONArray jsonArray = new JSONArray();
		for (int i=0; i < obj.size(); i++) {
		      jsonArray.add(obj.get(i));
		}
        	Utility.isSave(jsonArray,FILE_NAME);
	}
	
	/*************************************************************************************************************************************************
	 * Function is to edit the data inside the Address Book
	 * @param name
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	@Override
	public void doEdit() throws IOException, ParseException {
		JSONParser json=new JSONParser();
        System.out.println("Enter the Name you want to edit");
        String name=Utility.scanString(); 
        Object obj=json.parse(new FileReader(FILE_NAME));
        JSONArray doctorList = (JSONArray) obj;
        int index=Utility.jsonBinarySearch(doctorList, name);
        if(index==-1) {
        	System.err.println(name+" Not Found");
        }
        else {
        for (int i = 0; i < doctorList.size(); i++) {
           if(index==i) {
	        	JSONObject doctorDetails=(JSONObject) doctorList.get(i);
	        	System.out.println("Enter the field you want to edit");
	        	System.out.println("1- 'FirstName' for FirstName");
	        	System.out.println("2- 'city' for City Name ");
	        	System.out.println("3-'state' for State");
	        	System.out.println("4- 'zip' for ZIP");
	        	System.out.println("all' for All");
	        
	        	String choice=Utility.scanString();
	        	
        	switch (choice) {
        	
			case "FirstName":
					System.out.println("Enter Doctor First Name");
					String fName=Utility.scanString();
					doctorDetails.put("doctorFirstName", fName);
					doctorList.set(i, doctorDetails);
					break;
				
			case "LastName":
					System.out.println("Enter the New City Name");
					String lName=Utility.scanString();
					doctorDetails.put("doctorLastName", lName);
					doctorList.set(i, doctorDetails);
					break;
			
			case "DoctorId":
					System.out.println("Enter the New Mobile Number");
					String doctorID=Utility.scanString();
					doctorDetails.put("doctorId", doctorID);
					doctorList.set(i, doctorDetails);
					break;
			case "Speciality":
					System.out.println("Enter the New Mobile Number");
					int speciality=Utility.scanInt();
					doctorDetails.put("doctorSpeciality", speciality);
					doctorList.set(i, doctorDetails);
					break;
					
			case "Availability":
					System.out.println("Enter the New Mobile Number");
					int availability=Utility.scanInt();
					doctorDetails.put("doctorAvailability", availability);
					doctorList.set(i, doctorDetails);
					break;
				
			case "DoctorCount":
					System.out.println("Enter the New Mobile Number");
					int doctorCount=Utility.scanInt();
					doctorDetails.put("doctorCount", doctorCount);
					doctorList.set(i, doctorDetails);
					break;
			
			case "all":
					System.out.println("Enter Doctor First Name");
					String fName1=Utility.scanString();
					doctorDetails.put("doctorFirstName", fName1);
						
					System.out.println("Enter the New City Name");
					String lName1=Utility.scanString();
					doctorDetails.put("doctorLastName", lName1);
					
					System.out.println("Enter the New Mobile Number");
					String doctorID1=Utility.scanString();
					doctorDetails.put("doctorId", doctorID1);
					
					System.out.println("Enter the New Mobile Number");
					int speciality1=Utility.scanInt();
					doctorDetails.put("doctorSpeciality", speciality1);
					
					System.out.println("Enter the New Mobile Number");
					int availability1=Utility.scanInt();
					doctorDetails.put("doctorAvailability", availability1);
					
					System.out.println("Enter the New Mobile Number");
					int doctorCount1=Utility.scanInt();
					doctorDetails.put("doctorCount", doctorCount1);
				
					doctorList.set(i, doctorDetails);
					break;

			default:
					System.out.println("Invalid Input");
					break;
			}
           }
        }
		}
        Utility.isSave(doctorList,FILE_NAME);
	}
	
	/**
	 * Function is to delete the doctor.
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	@Override
	public void doDelete() throws IOException, ParseException {
		JSONParser json=new JSONParser();
        Object obj=json.parse(new FileReader(FILE_NAME));
        JSONArray doctorDetails = (JSONArray) obj;
        System.out.println("Enter the Name you want to delete");
        Utility.scanSentence();
        String name=Utility.scanSentence();
        int index= Utility.jsonBinarySearch(doctorDetails, name);
        if(index==-1) {
        	System.err.println(name+" not found");
        }
        else {
        for (int i = 0; i < doctorDetails.size(); i++) {
        	if(index==i) {
        		doctorDetails.remove(i);
        	}
		}
        Utility.isSave(doctorDetails,FILE_NAME);
        }
	}
}
