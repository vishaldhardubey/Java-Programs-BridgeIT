package com.bridgelabz.oopsconcept;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;

public class AddressBookJSON implements AddressBookDataStorage {
	ObjectMapper mapper = new ObjectMapper();
	JSONParser json = new JSONParser();

	@Override
	public void doSave(JSONArray jsonArray) {
		System.out.println("Enter the File Name where you want to store this contact");
		String fileName = Utility.scanString();
		try {
			mapper.writeValue(
					new File("/home/administrator/Funtional-Program/BridgeLabz/src/com/bridgelabz/oopsconcept/"
							+ fileName + ".json"),
					jsonArray);
		} catch (IOException e) {
			System.out.println("Exception Occured while Writing the values");
			e.printStackTrace();
		}
		System.out.println("Data hasbeen written");
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList read() {
		System.out.println("Enter the file in which you want to read");
		String fileName = Utility.scanString();
		List<JSONObject> obj;
		try {
			obj = (List<JSONObject>) json.parse(
					new FileReader("/home/administrator/Funtional-Program/BridgeLabz/src/com/bridgelabz/oopsconcept/"
							+ fileName + ".json"));
		} catch (IOException | ParseException e1) {
			e1.printStackTrace();
		}
		return null;
	}
}
