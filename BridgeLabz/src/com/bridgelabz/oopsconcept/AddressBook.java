package com.bridgelabz.oopsconcept;

import java.io.FileNotFoundException;
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

import com.bridgelabz.utility.Utility;

public class AddressBook {
	PersonDataBase personList1 = new PersonDataBase();
	ArrayList personDataJDBC = new ArrayList();
	AddressBookManager addMgr = new AddressBookManager();
	JSONParser json = new JSONParser();

	/***************************************************************************************************************************************************
	* Function to add the new person's address details
	* @return
	* @throws IOException
	* @throws JsonMappingException
	* @throws JsonGenerationException
	* @throws ParseException
	*/
	@SuppressWarnings("unchecked")
	public void doAdd() throws JsonGenerationException,
	JsonMappingException, IOException, ParseException {
		
					System.out.println("Enter the AddressBook Name in which you want to add the Address");
					        String fileName=Utility.scanString();
					List<JSONObject>
					obj=(List<JSONObject>) json.parse(new
					FileReader("/home/administrator/Funtional-Program/BridgeLabz/src/com/bridgelabz/oopsconcept/"+fileName+".json"));
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
					jo.put("mobileNum", person.getMobileNumber());
					jo.put("zip", person.getZIP());
					jo.put("city", person.getCity());
					jo.put("state", person.getState());
					obj.add(jo);
			}

				JSONArray jsonArray = new JSONArray();
				for (int i=0; i < obj.size(); i++) {
				      jsonArray.add(obj.get(i));
				}
				Utility.saveJsonOrJdbc(jsonArray,key);
			break;
	
}

	/*************************************************************************************************************************************************
	 * Function is to edit the data inside the Address Book
	 * 
	 * @param name
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	@SuppressWarnings("unchecked")
	public void doEdit() throws FileNotFoundException, IOException, ParseException {
		System.err.println("Enter the AddressBook Name in which you want to edit the Address");
		String fileName = Utility.scanString();
		System.out.println("Enter the Name you want to edit");
		Utility.scanSentence();
		String name = Utility.scanSentence();
		Object obj = json
				.parse(new FileReader("/home/administrator/Funtional-Program/BridgeLabz/src/com/bridgelabz/oopsconcept/"
						+ fileName + ".json"));
		JSONArray personDetailList = (JSONArray) obj;
		int index = Utility.jsonBinarySearch(personDetailList, name);
		if (index == -1) {
			System.err.println(name + " Not Found");
		} else {
			for (int i = 0; i < personDetailList.size(); i++) {
				if (index == i) {
					JSONObject customerDetails = (JSONObject) personDetailList.get(i);
					System.out.println("Enter the field you want to edit");
					System.out.println("1- for mobileNum");
					System.out.println("2- for City Name ");
					System.out.println("3- for State");
					System.out.println("4- for ZIP");
					System.out.println("5- for All");

					int choice = Utility.scanInt();

					switch (choice) {

					case 1:
						System.out.println("Enter the New Mobile Number");
						long mobileNo = Utility.scanLong();
						customerDetails.put("mobileNum", mobileNo);
						personDetailList.set(i, customerDetails);
						break;
					case 2:
						System.out.println("Enter the New City Name");
						String citychange = Utility.scanString();
						customerDetails.put("city", citychange);
						personDetailList.set(i, customerDetails);
						break;
					case 3:
						System.out.println("Enter the New Mobile Number");
						String state = Utility.scanString();
						customerDetails.put("state", state);
						personDetailList.set(i, customerDetails);
						break;
					case 4:
						System.out.println("Enter the New Mobile Number");
						int ZIP = Utility.scanInt();
						customerDetails.put("ZIP", ZIP);
						personDetailList.set(i, customerDetails);
						break;
					case 5:
						System.out.println("Enter the New State Name");
						long mobileNo1 = Utility.scanLong();
						customerDetails.put("mobileNum", mobileNo1);
						System.out.println("Enter the New City Name");
						String citychange2 = Utility.scanString();
						customerDetails.put("city", citychange2);
						System.out.println("Enter the New Mobile Number");
						String state3 = Utility.scanString();
						customerDetails.put("state", state3);
						System.out.println("Enter the New Mobile Number");
						int ZIP1 = Utility.scanInt();
						customerDetails.put("ZIP", ZIP1);
						personDetailList.set(i, customerDetails);
						break;

					default:
						System.out.println("Invalid Input");
						break;
					}
					Utility.saveJsonOrJdbc(personDetailList,choice);
				}
			}
		}
	}

	/**
	 * Function is to delete the perticular details
	 * 
	 * @param name
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void doDelete() throws FileNotFoundException, IOException, ParseException {
		System.out.println("Enter the Address Book Database from which you want to delete contact");
		System.out.println("1- for JSON File");
		System.out.println("2- for Mysql Database");
		int key = Utility.scanInt();
		switch (key) {
		case 1:
			System.out.println("Enter the AddressBook Name in which you want to delete the Address");
			String fileName = Utility.scanString();
			Object obj = json.parse(
					new FileReader("/home/administrator/Funtional-Program/BridgeLabz/src/com/bridgelabz/oopsconcept/"
							+ fileName + ".json"));
			JSONArray personDetailList = (JSONArray) obj;
			System.out.println("Enter the Name you want to delete");
			Utility.scanSentence();
			String name = Utility.scanSentence();
			int index = Utility.jsonBinarySearch(personDetailList, name);
			if (index == -1) {
				System.err.println(name + " not found");
			} else {
				for (int i = 0; i < personDetailList.size(); i++) {
					if (index == i) {
						personDetailList.remove(i);
					}
				}
				Utility.saveJsonOrJdbc(personDetailList, key);
			}

			break;
		case 2:
			System.out.println("Enter the table Name in which you want to delete the Address");
			String fileName1 = Utility.scanString();
			Object obj1 = json.parse(
					new FileReader("/home/administrator/Funtional-Program/BridgeLabz/src/com/bridgelabz/oopsconcept/"
							+ fileName1 + ".json"));
			JSONArray personDetailList1 = (JSONArray) obj1;
			System.out.println("Enter the Name you want to delete");
			Utility.scanSentence();
			String name1 = Utility.scanSentence();
			int index1 = Utility.jsonBinarySearch(personDetailList1, name1);
			if (index1 == -1) {
				System.err.println(name1 + " not found");
			} else {
				for (int i = 0; i < personDetailList1.size(); i++) {
					if (index1 == i) {
						personDetailList1.remove(i);
					}
				}
				Utility.saveJsonOrJdbc(personDetailList1, key);
			}
		default:
			break;
		}

	}

	/**
	 * Function is to sort the details according to their Name.
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void doSort() throws FileNotFoundException, IOException, ParseException {
		JSONParser json = new JSONParser();
		System.err.println("Enter the AddressBook Name that you want to sort");
		String fileName = Utility.scanString();
		Object obj = json
				.parse(new FileReader("/home/administrator/Funtional-Program/BridgeLabz/src/com/bridgelabz/oopsconcept/"
						+ fileName + ".json"));
		JSONArray personDetailList = (JSONArray) obj;
		Utility.jsonSortLong(personDetailList);

		//Utility.saveJsonOrJdbc(personDetailList);
	}

	/**
	 * Function to sort jsonarray on the basis of ZIP code
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void doSortByZIP() throws FileNotFoundException, IOException, ParseException {
		System.err.println("Enter the AddressBook Name that you want to sort by ZIP");
		String fileName = Utility.scanString();
		JSONParser json = new JSONParser();
		Object obj = json
				.parse(new FileReader("/home/administrator/Funtional-Program/BridgeLabz/src/com/bridgelabz/oopsconcept/"
						+ fileName + ".json"));
		JSONArray personDetailList = (JSONArray) obj;
		Utility.jsonSortLong(personDetailList);

		//Utility.saveJson(personDetailList);
	}

	/**
	 * Function to print the Details on console
	 * 
	 * @param person
	 */
	public void doPrint(JSONArray person) {
		for (int i = 0; i < person.size(); i++) {
		}
	}
}
