package com.bridgelabz.oopsconcept;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.util.JSONWrappedObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;

public class AddressBook {
	
	PersonDataBase personList1=new PersonDataBase();
	ArrayList<A_PersonDetails> newAddressBook= new ArrayList<A_PersonDetails>();
	AddressBookManager addMgr=new AddressBookManager();
	/**
	 * Function to add the new person's address details
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * @throws ParseException 
	 */
	public void doAdd() throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		JSONParser json=new JSONParser();
		System.out.println("Enter the AddressBook Name in which you want to add the Address");
        String fileName=Utility.scanString();	
		List<JSONObject> 
		obj=(List<JSONObject>) json.parse(new FileReader("/home/administrator/Funtional-Program/BridgeLabz/src/com/bridgelabz/oopsconcept/"+fileName+".json"));
		
		System.out.println(obj);
        
		System.out.println("Enter the number of entries");
		int scan=Utility.scanInt();
		for (int i = 0; i < scan; i++) {
			A_PersonDetails person=new A_PersonDetails();
			System.out.println("Enter your First Name");
			String fName=Utility.scanString();
			
			System.out.println("Enter your Last Name");
			String lName=Utility.scanString();
			String Name=fName+" "+lName;
			person.setPersonName(Name);
			
			System.out.println("Enter your Mobile Number");
			long mobileNum=Utility.scanLong();
			person.setMobileNumber(mobileNum);
			
			System.out.println("Enter State");
			String state=Utility.scanString();
			person.setState(state);
			
			System.out.println("Enter City");
			String city=Utility.scanString();
			person.setCity(city);
			
			System.out.println("Enter ZIP");
			int ZIP=Utility.scanInt();
			person.setZIP(ZIP);
			

			personList1.getPersonList().add(person);

			JSONObject jo=new JSONObject();
			jo.put("personName", person.getPersonName());
			jo.put("mobileNumber", person.getMobileNumber());
			jo.put("zip", person.getZIP());
			jo.put("city", person.getCity());
			jo.put("state", person.getState());
			obj.add(jo);
		}

		JSONArray jsonArray = new JSONArray();
		for (int i=0; i < obj.size(); i++) {
		      jsonArray.add(obj.get(i));
		}
        	addMgr.isSave(jsonArray,fileName);
	}
	/*************************************************************************************************************************************************
	 * Function is to edit the data inside the Address Book
	 * @param name
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void doEdit() throws FileNotFoundException, IOException, ParseException {
		JSONParser json=new JSONParser();
		System.err.println("Enter the AddressBook Name in which you want to edit the Address");
        String fileName=Utility.scanString();
        System.out.println("Enter the Name you want to edit");
        String name=Utility.scanString(); 
        Object obj=json.parse(new FileReader("/home/administrator/Funtional-Program/BridgeLabz/src/com/bridgelabz/oopsconcept/"+fileName+".json"));
        JSONArray personDetailList = (JSONArray) obj;
        int index=Utility.jsonBinarySearch(personDetailList, name);
        if(index==-1) {
        	System.err.println(name+" Not Found");
        }
        else {
        for (int i = 0; i < personDetailList.size(); i++) {
           if(index==i) {
	        	JSONObject customerDetails=(JSONObject) personDetailList.get(i);
	        	System.out.println("Enter the field you want to edit");
	        	System.out.println("1- 'mobile' for mobileNum");
	        	System.out.println("2- 'city' for City Name ");
	        	System.out.println("3-'state' for State");
	        	System.out.println("4- 'zip' for ZIP");
	        	System.out.println("all' for All");
	        
	        	String choice=Utility.scanString();
	        	
        	switch (choice) {
        	
			case "mobile":
					System.out.println("Enter the New Mobile Number");
					long mobileNo=Utility.scanLong();
					customerDetails.put("mobileNum", mobileNo);
					personDetailList.set(i, customerDetails);
					break;
				
			case "city":
					System.out.println("Enter the New City Name");
					String citychange=Utility.scanString();
					customerDetails.put("city", citychange);
					personDetailList.set(i, customerDetails);
					break;
			
			case "state":
					System.out.println("Enter the New Mobile Number");
					String state=Utility.scanString();
					customerDetails.put("state", state);
					personDetailList.set(i, customerDetails);
					break;
			case "ZIP":
					System.out.println("Enter the New Mobile Number");
					int ZIP=Utility.scanInt();
					customerDetails.put("ZIP", ZIP);
					personDetailList.set(i, customerDetails);
					break;
			
			case "all":
					System.out.println("Enter the New State Name");
					long mobileNo1=Utility.scanLong();
					customerDetails.put("mobileNum", mobileNo1);
					
					System.out.println("Enter the New City Name");
					String citychange2=Utility.scanString();
					customerDetails.put("city", citychange2);
					
					System.out.println("Enter the New Mobile Number");
					String state3=Utility.scanString();
					customerDetails.put("state", state3);
					
					System.out.println("Enter the New Mobile Number");
					int ZIP1=Utility.scanInt();
					customerDetails.put("ZIP", ZIP1);
					
					personDetailList.set(i, customerDetails);
					break;

			default:
					System.out.println("Invalid Input");
					break;
			}
           }
        }
		}
        addMgr.isSave(personDetailList,fileName);
	}
	/**
	 * Function is to delete the perticular details
	 * @param name
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void doDelete() throws FileNotFoundException, IOException, ParseException {
		JSONParser json=new JSONParser();
		System.out.println("Enter the AddressBook Name in which you want to delete the Address");
        String fileName=Utility.scanString();
        Object obj=json.parse(new FileReader("/home/administrator/Funtional-Program/BridgeLabz/src/com/bridgelabz/oopsconcept/"+fileName+".json"));
        JSONArray personDetailList = (JSONArray) obj;
        System.out.println("Enter the Name you want to delete");
        Utility.scanSentence();
        String name=Utility.scanSentence();
        int index= Utility.jsonBinarySearch(personDetailList, name);
        if(index==-1) {
        	System.err.println(name+" not found");
        }
        else {
        for (int i = 0; i < personDetailList.size(); i++) {
        	if(index==i) {
        		personDetailList.remove(i);
        	}
		}
        addMgr.isSave(personDetailList,fileName);
        }
	}
	/**
	 * Function is to sort the details according to their Name.
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void doSort() throws FileNotFoundException, IOException, ParseException {
		JSONParser json=new JSONParser();
		System.err.println("Enter the AddressBook Name that you want to sort");
        String fileName=Utility.scanString();
        Object obj=json.parse(new FileReader("/home/administrator/Funtional-Program/BridgeLabz/src/com/bridgelabz/oopsconcept/"+fileName+".json"));
        JSONArray personDetailList = (JSONArray) obj;
     
        Utility.jsonSortLong(personDetailList);
        addMgr.isSave(personDetailList,fileName);
	}
	/**
	 * Function to sort jsonarray on the basis of ZIP code
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void doSortByZIP() throws FileNotFoundException, IOException, ParseException {
		System.err.println("Enter the AddressBook Name that you want to sort by ZIP");
	    String fileName=Utility.scanString();
		JSONParser json=new JSONParser();
        Object obj=json.parse(new FileReader("/home/administrator/Funtional-Program/BridgeLabz/src/com/bridgelabz/oopsconcept/"+fileName+".json"));
        JSONArray personDetailList = (JSONArray) obj;
        Utility.jsonSortLong(personDetailList);
        addMgr.isSave(personDetailList,fileName);
	}
	
	/**
	 * Function to print the Details on console
	 * @param person
	 */
	public void doPrint(JSONArray person) {
		for (int i = 0; i < person.size(); i++) {
			
		}
	}
}
