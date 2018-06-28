package com.bridgelabz.oopsconcept;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;

public class AddressBookManager {
	static ArrayList<String> book=new ArrayList<>();
	String fileName="";
	ObjectMapper mapper=new ObjectMapper();
	
	/**
	 * @return
	 * @throws IOException
	 */
	public boolean createNewAddressBook() throws IOException {
		FileReader fr=new FileReader("/home/administrator/Funtional-Program/BridgeLabz/src/com/bridgelabz/oopsconcept/AllFiles");
		BufferedReader br=new BufferedReader(fr);
		String word=br.readLine();
		String[] str=null;
		while(word!=null) {
			str=word.split(",");
			break;
		}
		System.out.println("Enter the File Name that you want to assign");
		fileName=Utility.scanString();
		for (int i = 0; i < str.length; i++) {
			book.add(str[i]);
		}
		book.add(fileName);
		FileWriter writer = new FileWriter("/home/administrator/Funtional-Program/BridgeLabz/src/com/bridgelabz/oopsconcept/AllFiles"); 
		for(String str1: book) {
		  writer.write(word+str1+",");
		}
		System.out.println(book);
		writer.close();
		
		File f=new File("/home/administrator/Funtional-Program/BridgeLabz/src/com/bridgelabz/oopsconcept/"+fileName+".json");
		boolean fileCreated=f.createNewFile();
		FileWriter fw=new FileWriter(f);
		fw.write("[]");
		fw.flush();
		return fileCreated;
	}
	/**
	 * @param jsonArray
	 * @param fileName
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void isSave(JSONArray jsonArray,String fileName) throws JsonGenerationException, JsonMappingException, IOException {	
		System.out.println("You want to Save this File!!!");
		System.out.println("1 - Enter to Save the Data");
		System.out.println("2 - Enter to Exit without saving");
		int key = Utility.scanInt();
		switch (key) {
		case 1:
				mapper.writeValue(new File("/home/administrator/Funtional-Program/BridgeLabz/src/com/bridgelabz/oopsconcept/"+fileName+".json"), jsonArray);
				System.out.println("Data hasbeen written");
			break;
		case 2:
				doClose(fileName);
		break;
		default:
			System.err.println("Invalid Input");
			break;
		}
	}

	/**
	 * Function is to Open the Existing File
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void doOpen() throws FileNotFoundException, IOException, ParseException {
		System.out.println("Enter the AddressBook Name you want to Open");
		String fileNameToOpen=Utility.scanString();
		if(book.contains(fileNameToOpen)) {
			JSONParser parse=new JSONParser();
			Object obj=(JSONObject) parse.parse(new FileReader("/home/administrator/Funtional-Program/BridgeLabz/src/com/bridgelabz/oopsconcept/"+fileNameToOpen+".json"));
			JSONArray array=(JSONArray) obj;
			for (int i = 0; i < array.size(); i++) {
				System.out.println(array.get(i));
			}
		}
		else 
		{
			System.out.println("File Doesn't Exists");
		}
	}
	
	/**
	 * Function is to close Already opened file
	 * @param fileName1
	 */
	public void doClose(String fileName1) {
		if(book.contains(fileName1)) {
			System.exit(0);
		}
		else {
			System.err.println("File Doesn't Exists");
		}
	}
	public void doDelete() {
		
	}
}
