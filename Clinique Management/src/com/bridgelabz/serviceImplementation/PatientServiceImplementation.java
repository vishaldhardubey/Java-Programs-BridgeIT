package com.bridgelabz.serviceImplementation;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.rmi.CORBA.Util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.model.Appointment;
import com.bridgelabz.service.PatientService;
import com.bridgelabz.utility.Utility;
/**
 * Purpose: Program is to give implementation to Patient Service!!!
 *
 *  @author  :Vishal Dhar Dubey
 *  @version :1.0
 *  @since   :09-06-2018
 */
public class PatientServiceImplementation implements PatientService {
	static final String APPOINTMENT_FILE="/home/administrator/Funtional-Program/Functional-Program/Clinique Management/src/com/bridgelabz/files/Appointment.json";
	static final String DOCTOR_FILE_NAME="/home/administrator/Funtional-Program/Functional-Program/Clinique Management/src/com/bridgelabz/files/Doctor.json";
	static final String PATIENT_FILE_PATH="/home/administrator/Funtional-Program/Functional-Program/Clinique Management/src/com/bridgelabz/files/Patient.json";
	ManagerServiceImplementation managerService=new ManagerServiceImplementation();
	JSONParser json=new JSONParser();
	private Random gen = new Random();
	
	PatientArrayList patientArrayList=new PatientArrayList();
	AppointmentArrayList appointmentArrayList=new AppointmentArrayList();
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	
	
	/* (non-Javadoc)
	 * @see com.bridgelabz.service.PatientService#takeAppointment()
	 */
	@Override
	public boolean takeAppointment() throws IOException, ParseException {
		
		List<JSONObject> 
		obj3=(List<JSONObject>) json.parse(new FileReader(APPOINTMENT_FILE));
		System.out.println(obj3);
		
		System.out.println("Tell me you Name!!");
		String name=Utility.scanSentence();
		System.out.println("Your Mobile Number Please");
		long mobileNum=Utility.scanLong();
		if(!searchPatientByName()) {
			managerService.addPatient();
		}
			System.out.println("Enter the time slot in which you want to take appointment");
			System.out.println("Enter 1 for AM slot");
			System.out.println("Enter 2 for PM slot");
			int choice=Utility.scanInt();
			switch (choice) {
			
			/**
			 * Switch case is to approve appointment in Evening time.
			 */
			case 1:
				Object obj=json.parse(new FileReader(DOCTOR_FILE_NAME));
				JSONArray appointmentList=(JSONArray) obj;
				List<JSONObject> listBasedOnSlot=new ArrayList<JSONObject>();
				System.out.println("Enter the Specialization of doctor for which you want to take appointment");
				String speciality=Utility.scanString();
				
				for (int i = 0; i < appointmentList.size(); i++) {
						listBasedOnSlot.add((JSONObject) appointmentList.get(i));
				}
				JSONArray jsonArray = new JSONArray();
				for (int i = 0; i < listBasedOnSlot.size(); i++) {
					Appointment appointment=new Appointment();
					if((long)listBasedOnSlot.get(i).get("doctorCount")<5) {
						String slot= (String) listBasedOnSlot.get(i).get("doctorSpeciality");
						String slotTime=(String) listBasedOnSlot.get(i).get("doctorAvailability");
						
						if(slot.equalsIgnoreCase(speciality) && slotTime.equals("AM")) {
							long value=(long)listBasedOnSlot.get(i).get("doctorCount");
							value++;
							listBasedOnSlot.get(i).put("doctorCount", value);
							System.out.println("Doctor Count has incremented to :"+value);
							System.out.println(listBasedOnSlot.get(i));
							System.out.println("Enter the Doctor ID with whome you want to fix appointment");
							long docId=Utility.scanLong();
							JSONObject obj1 =(JSONObject) managerService.searchDoctorbyId(docId);
								if(obj1==null) {
									System.out.println("Entered Doctor ID is wrong.");
								}
									else {
									System.out.println(obj1);
									JSONObject obj2 =(JSONObject) searchPatientByMobileNum(mobileNum);
										if(obj2==null) {
											System.out.println(mobileNum+" : is not present in our DataBase");
										}
										else {
											System.out.println(obj2);
											appointment.setPatientName((String) obj2.get("patientFirstName"));
											appointment.setPatientId((long)obj2.get("patientId"));
											appointment.setDoctorName((String)obj1.get("doctorFirstName"));
											appointment.setDoctorId((long)obj1.get("doctorId"));
											appointment.setDateAndTime(dateFormat.format(date)+"AM");
											appointmentArrayList.getAppointmentList().add(appointment);
											
											JSONObject jo=new JSONObject();
											jo.put("patientFirstName",appointment.getPatientName());
											jo.put("patientId", appointment.getPatientId());
											jo.put("doctorFirstName", appointment.getDoctorName());
											jo.put("doctorId", appointment.getDoctorId());
											jo.put("dateAndTime", appointment.getDateAndTime());
											obj3.add(jo);
											System.out.println("Appointment has been book at : "+dateFormat.format(date)+"AM");
										}
								for (int i1=0; i1 < obj3.size(); i1++) {
								      jsonArray.add(obj3.get(i1));
								}
								Utility.isSave(jsonArray, APPOINTMENT_FILE);
								return true;
								}
							//increment to doctor count
						}
					}
					else {
						System.out.println("Doctor is Unavailable at this time.");
						System.out.println("Please Search for next slot");
						System.out.println("1- For looking at next slot");
						System.out.println("2- For canceling the appointment");
						int key=Utility.scanInt();
						switch (key) {
						case 1:
								takeAppointment();
							break;
						case 2:
								System.exit(0);
							break;
	
						default: System.out.println("Invalid Input");
							break;
						}
					}
				}
				break;
		/**
		 * Switch case is to approve appointment in Evening time.
		 */
			case 2:
				Object obj1=json.parse(new FileReader(DOCTOR_FILE_NAME));
				JSONArray appointmentList1=(JSONArray) obj1;
				List<JSONObject> listBasedOnSlot1=new ArrayList<JSONObject>();
				System.out.println("Enter the Specialization of doctor for which you want to take appointment");
				String speciality1=Utility.scanString();
				
				for (int i = 0; i < appointmentList1.size(); i++) {
						listBasedOnSlot1.add((JSONObject) appointmentList1.get(i));
				}
				
				for (int i = 0; i < listBasedOnSlot1.size(); i++) {
					Appointment appointment=new Appointment();
					if((long)listBasedOnSlot1.get(i).get("doctorCount")<5) {
						String slot= (String) listBasedOnSlot1.get(i).get("doctorSpeciality");
						
						String slotTime=(String) listBasedOnSlot1.get(i).get("doctorAvailability");
						if(slot.equalsIgnoreCase(speciality1) && slotTime.equals("PM")) {
							long value=(long)listBasedOnSlot1.get(i).get("doctorCount");
							value++;
							listBasedOnSlot1.get(i).put("doctorCount", value);
							System.out.println("Doctor Count has been incremented to : "+value);
							
							System.out.println(listBasedOnSlot1.get(i));
							System.out.println("Enter the Doctor ID with whome you want to fix appointment");
							long docId=Utility.scanLong();
							JSONObject obj2 =(JSONObject) managerService.searchDoctorbyId(docId);
							if(obj1==null) {
								System.out.println("Entered Doctor ID is wrong.");
							}
								else {
							System.out.println(obj2);
							JSONObject obj4 =(JSONObject) searchPatientByMobileNum(mobileNum);
							if(obj2==null) {
								System.out.println(mobileNum+" : is not present in our DataBase");
							}
							else {
							System.out.println(obj4);
							appointment.setPatientName((String) obj4.get("patientFirstName"));
							appointment.setPatientId((long)obj4.get("patientId"));
							appointment.setDoctorName((String)obj2.get("doctorFirstName"));
							appointment.setDoctorId((long)obj2.get("doctorId"));
							appointment.setDateAndTime(dateFormat.format(date)+"AM");
							appointmentArrayList.getAppointmentList().add(appointment);
							
							JSONObject jo=new JSONObject();
							jo.put("patientFirstName",appointment.getPatientName());
							jo.put("patientId", appointment.getPatientId());
							jo.put("doctorFirstName", appointment.getDoctorName());
							jo.put("doctorId", appointment.getDoctorId());
							jo.put("dateAndTime", appointment.getDateAndTime());
							obj3.add(jo);
							}
						}
							JSONArray jsonArray1 = new JSONArray();
							for (int i1=0; i1 < obj3.size(); i1++) {
							      jsonArray1.add(obj3.get(i1));
							}
							Utility.isSave(jsonArray1, APPOINTMENT_FILE);
							
							System.out.println("Appointment has been book at : "+dateFormat.format(date)+"PM");
							//increase in count
						}
					}
					else {
						System.out.println("Doctor is Unavailable at this time");
						System.out.println("Please Search for next slot");
						System.out.println("1- For looking at next slot");
						System.out.println("2- For canceling the appointment");
						int key1=Utility.scanInt();
						switch (key1) {
						case 1:
								takeAppointment();
							break;
						case 2:
								System.exit(0);
							break;
	
						default: System.out.println("Invalid Input");
							break;
						}
						
					}
				}
				break;
	
			default:
				System.out.println("Invalid Input");
				takeAppointment();
				break;
			}
			return false;	
	}

	@Override
	public void showPatientDetails() throws IOException, ParseException {
		Object obj=json.parse(new FileReader(PATIENT_FILE_PATH));
		JSONArray patientList=(JSONArray) obj;
		for (int i = 0; i < patientList.size(); i++) {
			System.out.println(patientList.get(i));
		}
	}

	@Override
	public boolean searchPatientByName() throws IOException, ParseException {
		Object obj = json.parse(new FileReader(PATIENT_FILE_PATH));
		JSONArray patientList=(JSONArray) obj;
		System.out.println("Enter the Patient Name you want to search");
		Utility.scanSentence();
		String name = Utility.scanSentence();
		int index = Utility.jsonBinarySearch(patientList, name);
		int count=0;
		if(index==-1) {
			System.out.println(name+" is not Available");
			return false;
		}
		else {
			for (int i = 0; i < patientList.size(); i++) {
				if(i==index) {
					System.out.println(patientList.get(i));
					count++;
				}
			}
			if(count>0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Object searchPatientByMobileNum(long patientMobileNumber) throws IOException, ParseException {
		Object obj=json.parse(new FileReader(PATIENT_FILE_PATH));
		JSONArray patientList=(JSONArray) obj;
		int index=Utility.jsonSearch(patientList, patientMobileNumber);
		if(index==-1) {
			System.out.println(patientMobileNumber+" is not Available");
		}
		else {
			for (int i = 0; i < patientList.size(); i++) {
				if(i==index) {
					return patientList.get(index);
				}
			}
		}
		return null;
	}

	@Override
	public void searchPatientById() throws IOException, ParseException {
		Object obj=json.parse(new FileReader(PATIENT_FILE_PATH));
		JSONArray patientList=(JSONArray) obj;
		System.out.println("Enter the patient ID you want to search");
		long patientId=Utility.scanLong();
		int index=Utility.jsonSearch(patientList, patientId);
		if(index==-1) {
			System.out.println(patientId+" is not Available");
		}
		else {
			for (int i = 0; i < patientList.size(); i++) {
				if(i==index) {
					System.out.println(patientList.get(index));
				}
			}
		}		
	}

	@Override
	public void showPopularDoctor() throws IOException, ParseException {
		Object obj=json.parse(new FileReader(DOCTOR_FILE_NAME));
		JSONArray appointmentList1=(JSONArray) obj;
		List<JSONObject> list=new ArrayList<JSONObject>();
		for (int i = 0; i < appointmentList1.size(); i++) {
			list.add((JSONObject) appointmentList1.get(i));
		}
		long temp=0;
		for (int i = 0; i < list.size()-1; i++) {
			long rank1=(long) list.get(i).get("doctorCount");
			
			for (int j = 0; j < list.size(); j++) {
				long rank2=(long)list.get(j).get("doctorCount");
				if(rank1>rank2) {
					temp=rank1;
				}
				else {
					temp=rank2;
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
			if((long)list.get(i).get("doctorCount")==temp) {
				System.out.println(list.get(i));
			}
		}
	}

	@Override
	public void showPopularSpecialization() throws IOException, ParseException {
		Object obj=json.parse(new FileReader(DOCTOR_FILE_NAME));
		JSONArray appointmentList1=(JSONArray) obj;
		List<JSONObject> list=new ArrayList<JSONObject>();
		for (int i = 0; i < appointmentList1.size(); i++) {
			list.add((JSONObject) appointmentList1.get(i));
		}
		long temp=0;
		for (int i = 0; i < list.size(); i++) {
			long rank1=(long)list.get(i).get("doctorCount");
			for (int j = 0; j < list.size(); j++) {
				long rank2=(long)list.get(j).get("doctorCount");
				if(rank1>rank2) {
					temp=rank1;
				}
				else {
					temp=rank2;
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
			if((long)list.get(i).get("doctorCount")==temp) {
				System.out.println(list.get(i).get("doctorSpeciality"));
			}
		}
	}

}
