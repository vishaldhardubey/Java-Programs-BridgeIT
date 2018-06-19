package com.bridgelabz.serviceImplementation;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.model.Patient;
import com.bridgelabz.service.ManagerService;
import com.bridgelabz.utility.Utility;

public class ManagerServiceImplementation implements ManagerService {
	PatientArrayList patientList=new PatientArrayList();
	static final String PATIENT_FILE_PATH="/home/administrator/Funtional-Program/Functional-Program/Clinique Management/src/com/bridgelabz/files/Patient.json";
	static final String DOCTOR_FILE_NAME="/home/administrator/Funtional-Program/Functional-Program/Clinique Management/src/com/bridgelabz/files/Doctor.json";
	JSONParser json=new JSONParser();
	
	@Override
	public void addPatient() throws IOException, ParseException {
		JSONParser json=new JSONParser();
		List<JSONObject> 
		obj=(List<JSONObject>) json.parse(new FileReader(PATIENT_FILE_PATH));
		
		System.out.println(obj);
        
		System.out.println("Enter the number of patients you want to register");
		int scan=Utility.scanInt();
		
		for (int i = 0; i < scan; i++) {
			Patient patient=new Patient();
			
			System.out.println("Enter Patient First Name");
			String fName=Utility.scanString();
			patient.setPatientFirstName(fName);
			
			System.out.println("Enter Patient Last Name");
			String lName=Utility.scanString();
			patient.setPatientLastName(lName);
			
			System.out.println("Enter Patient ID");
			long id=Utility.scanLong();
			patient.setPatientId(id);
			
			System.out.println("Enter Patient Age");
			long patientAge=Utility.scanInt();
			patient.setPatientAge(patientAge);
			

			System.out.println("Enter Patient Mobile Number");
			long patientMobileNum=Utility.scanLong();
			patient.setPatientMobileNum(patientMobileNum);
			patientList.getPatientArray().add(patient);

			JSONObject jo=new JSONObject();
			jo.put("patientFirstName",patient.getPatientFirstName());
			jo.put("patientLastName", patient.getPatientLastName());
			jo.put("patientAge", patient.getPatientAge());
			jo.put("patientMobileNum", patient.getPatientMobileNum());
			jo.put("patientId", patient.getPatientId());
			obj.add(jo);
		}

		JSONArray jsonArray = new JSONArray();
		for (int i=0; i < obj.size(); i++) {
		      jsonArray.add(obj.get(i));
		}
        	Utility.isSave(jsonArray,PATIENT_FILE_PATH);
	}

	@Override
	public void updatePatientDetails() throws IOException, ParseException {
		JSONParser json=new JSONParser();
        
        Object obj=json.parse(new FileReader(PATIENT_FILE_PATH));
        JSONArray patientList = (JSONArray) obj;
        System.out.println("Enter the Name you want to edit");
        String name=Utility.scanString(); 
        int index=Utility.jsonBinarySearch(patientList, name);
        if(index==-1) {
        	System.err.println(name+" Not Found");
        }
        else {
        for (int i = 0; i < patientList.size(); i++) {
           if(index==i) {
	        	JSONObject patientDetails=(JSONObject) patientList.get(i);
	        	System.out.println("Enter the field you want to edit");
	        	System.out.println("1- 'FirstName' for First Name");
	        	System.out.println("2- 'LastName' for Last Name ");
	        	System.out.println("4- 'Age' for Patient Age");
	        	System.out.println("5- 'MobileNum' for Mobile Number");
	        	System.out.println("6- 'Id' for patient Id");
	        	System.out.println("all' for All");
	        
	        	String choice=Utility.scanString();
	        	
        	switch (choice) {
        	
			case "FirstName":
					System.out.println("Enter Doctor First Name");
					String fName=Utility.scanString();
					patientDetails.put("patientFirstName", fName);
					patientList.set(i, patientDetails);
					break;
				
			case "LastName":
					System.out.println("Enter the New City Name");
					String lName=Utility.scanString();
					patientDetails.put("patientLastName", lName);
					patientList.set(i, patientDetails);
					break;
			
			case "Age":
					System.out.println("Enter the Patient Age");
					String patientAge=Utility.scanString();
					patientDetails.put("patientAge", patientAge);
					patientList.set(i, patientDetails);
					break;
			case "MobileNum":
					System.out.println("Enter the Patients Mobile Number");
					int patientMobileNumber=Utility.scanInt();
					patientDetails.put("patientMobileNum", patientMobileNumber);
					patientList.set(i, patientDetails);
					break;
					
			case "Id":
					System.out.println("Enter the Patient ID");
					int patientID=Utility.scanInt();
					patientDetails.put("patientId", patientID);
					patientList.set(i, patientDetails);
					break;
			
			case "all":
					System.out.println("Enter Doctor First Name");
					String fName1=Utility.scanString();
					patientDetails.put("patientFirstName", fName1);
							
					System.out.println("Enter the New City Name");
					String lName1=Utility.scanString();
					patientDetails.put("patientLastName", lName1);
						
					System.out.println("Enter the New Mobile Number");
					String patientAge1=Utility.scanString();
					patientDetails.put("patientAge", patientAge1);
						
					System.out.println("Enter the New Mobile Number");
					int patientMobileNumber1=Utility.scanInt();
					patientDetails.put("patientMobileNum", patientMobileNumber1);
						
					System.out.println("Enter the Patient ID");
					int patientID1=Utility.scanInt();
					patientDetails.put("patientId", patientID1);
					
					patientList.set(i, patientDetails);
					break;

			default:
					System.out.println("Invalid Input");
					break;
			}
           }
        }
		}
        Utility.isSave(patientList,PATIENT_FILE_PATH);
	}

	@Override
	public void deletePatient() throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		
        Object obj=json.parse(new FileReader(PATIENT_FILE_PATH));
        JSONArray patientDetails = (JSONArray) obj;
        System.out.println("Enter the Name you want to delete");
        Utility.scanSentence();
        String name=Utility.scanSentence();
        int index= Utility.jsonBinarySearch(patientDetails, name);
        if(index==-1) {
        	System.err.println(name+" not found");
        }
        else {
        for (int i = 0; i < patientDetails.size(); i++) {
        	if(index==i) {
        		patientDetails.remove(i);
        	}
		}
        Utility.isSave(patientDetails,PATIENT_FILE_PATH);
        }
	}
	@Override
	public void showDoctorDetails() throws IOException, ParseException {
		Object obj=json.parse(new FileReader(DOCTOR_FILE_NAME));
		JSONArray doctorDetails=(JSONArray) obj;
		for (int i = 0; i < doctorDetails.size(); i++) {
			System.out.println(doctorDetails.get(i));
		}
	}

	@Override
	public void searchDoctorbyName() throws IOException, ParseException {
		Object obj = json.parse(new FileReader(DOCTOR_FILE_NAME));
		JSONArray doctorList=(JSONArray) obj;
		System.out.println("Enter the Doctors Name you want to search");
		String name = Utility.scanString();
		int index = Utility.jsonBinarySearch(doctorList, name);
		if(index==-1) {
			System.out.println(name+" is not Available");
		}
		else {
			for (int i = 0; i < doctorList.size(); i++) {
				if(i==index) {
					System.out.println(doctorList.get(i));
				}
			}
		}
	}

	@Override
	public Object searchDoctorbyId(long doctorID) throws IOException, ParseException {
		Object obj=json.parse(new FileReader(DOCTOR_FILE_NAME));
		JSONArray doctorList=(JSONArray) obj;
		int index=Utility.jsonSearch(doctorList, doctorID);
		if(index==-1) {
			System.out.println(doctorID+" is not Available");
		}
		else {
			for (int i = 0; i < doctorList.size(); i++) {
				if(i==index) {
					return (doctorList.get(index));
				}
			}
		}
		return null;
	}

	@Override
	public void searchDoctorbyAvailability() throws IOException, ParseException {
		Object obj = json.parse(new FileReader(DOCTOR_FILE_NAME));
		JSONArray doctorList=(JSONArray)obj;
		System.out.println("Enter the shift you are looking for as AM or PM.");
		String availability=Utility.scanString();
		List<JSONObject> jsonValues = new ArrayList<JSONObject>();
		
		for (int i = 0; i < doctorList.size(); i++) {
            jsonValues.add((JSONObject) doctorList.get(i));
        }
        for (int i = 0; i < jsonValues.size(); i++) { 	
			if(jsonValues.get(i).containsValue(availability)){
					System.out.println(jsonValues.get(i));
				}
        }
	}

}
