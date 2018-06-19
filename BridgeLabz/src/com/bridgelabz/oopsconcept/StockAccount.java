package com.bridgelabz.oopsconcept;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.datastructure.SinglyLinkedList;
import com.bridgelabz.datastructure.StackLinkedList;
import com.bridgelabz.utility.Utility;

public class StockAccount implements BankingDetail {
	
	CustomerInformation customer=new CustomerInformation();
	CompanyShares companyshare=new CompanyShares();
	SinglyLinkedList singlyLinkedList=new SinglyLinkedList();
	StackLinkedList stackLinkedList=new StackLinkedList<>();
	static StockAccount stock1=new StockAccount();
	/**
	 * Variables which are static for whole Program.
	 */
	String stockName[]= {"@","#","&","$","BRIDGELABZ","CAPGEMINI"};
	int[] shareRate= {200,300,500,100,50,150};
	long numOfSharesAvailable=30;
	File FILEPATH=new File("/home/administrator/Desktop/StockAccount");
	String customerData="";
	String currentcustomerData="";
	String shareStockData="";
	String currentShareStockData="";
	
	/**
	 * Function to take customer details
	 * @return customer
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException
	 */
	public CustomerInformation customerDetails() throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		Random rand=new Random();
		long accountNum=rand.nextInt(100000);
		ArrayList list=new ArrayList<>();
		while(true) {
			if(!list.contains(accountNum)) {
				list.add(accountNum);
			customer.setAccountNum(accountNum);
			System.out.println("Enter your first Name");
			String firstName=Utility.scanString();
			
			System.out.println("Enter your middle Name");
			String middleName=Utility.scanString();
			
			System.out.println("Enter your Last Name");
			String lastName=Utility.scanString();
			
			String name=firstName+" "+middleName+" "+lastName;
			customer.setName(name);
			currentcustomerData=currentcustomerData+"Share Holder Name : "+name+"\n";
	
			System.out.println("Enter your mobile number");
			long mobileNum=Utility.scanLong();
			customer.setMobNum(mobileNum);
			currentcustomerData=currentcustomerData+"Holder's Mob Num : "+mobileNum+"\n";
			
			customerData=customerData+" "+currentcustomerData+" ";
			System.out.println("Give your share details you want to purchase.");
			customerShareDetails custumshare=new customerShareDetails();
	        System.out.println("Enter how many shares you want");
	        long stockNum=Utility.scanLong();
	        CompanyShares shares=new CompanyShares();
	        for (int i = 0; i < stockNum; i++) {
	        	if(numOfSharesAvailable>1) {
		        	shares = shareDetails();
				        	custumshare.getShareArray1().add(shares);
					}
	        	}
			customer.setCompanyshare(custumshare);
			break;
			}
		}	
		return customer;	
	}
	/**
	 * Function is to create and return share details
	 * @return shares
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException
	 */
	public CompanyShares shareDetails() throws JsonGenerationException, JsonMappingException, IOException, ParseException {
			CompanyShares shares=new CompanyShares();
			
	    		System.out.println("Enter the Stock Symbol");
	            String symbol = Utility.scanString();
	            shares.setShareName(symbol);
	            currentShareStockData=currentShareStockData+"Share Name : "+symbol+"\n";
	            
	            System.out.println("Enter the Number of Stock");
	            long noOfShare = Utility.scanLong();
	            shares.setNumOfShare(noOfShare);
	            currentShareStockData=currentShareStockData+"Number of Shares : "+noOfShare+"\n";
	            
	            System.out.println("Enter the price of Stock");
	            int sharePrice = Utility.scanInt();
	            shares.setSharePrice(sharePrice);
	            currentShareStockData=currentShareStockData+"Shares Price : "+sharePrice+"\n";
	            
	            if(buy(sharePrice,symbol)==true) {
					numOfSharesAvailable=numOfSharesAvailable-noOfShare;
					shareStockData=shareStockData+currentShareStockData;
	            	return shares;
	            }
	            return null;
	}
	
	/**
	 * Function is to create profile of new customer
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void createProfile() throws JsonGenerationException, JsonMappingException, IOException, ParseException {
			
			CompanyPortfolio custum=new CompanyPortfolio();
        	customer = customerDetails();
        	custum.getCustomerArray().add(customer);
        	ObjectMapper mapper=new ObjectMapper();
        	mapper.writeValue(new File("/home/administrator/Funtional-Program/BridgeLabz/src/com/bridgelabz/oopsconcept/stockdetails.json"),custum);
        	String fileName=customerData+"\n"+shareStockData;
        	save(fileName);
	}
	

	@Override
	public double valueOf() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.bridgelabz.oopsconcept.BankingDetail#buy(int, java.lang.String)
	 */
	@Override
	public boolean buy(int amount, String symbol) throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		for (int i = 0; i < stockName.length; i++) {
			if(symbol.equals(stockName[i])==true) {
						shareRate[i]=shareRate[i]-amount;
						System.err.println("Available share rate of "+symbol+" is --> "+shareRate[i]);
						stackLinkedList.push(symbol);
						stackLinkedList.display();
						System.out.println("Enter the choice for other Stock Purchase");
						System.out.println("Enter \"1\" for further profile creation");
						System.out.println("Enter \"2\" to close the process");
						int choice=Utility.scanInt();
						switch (choice) {
						case 1:
							stock1.createProfile();
							break;
						case 2:
							System.out.println("Thanks for Creating Profile in Stock Market");
							break;
						default:
							System.out.println("Invalid Entry");
							break;
						}
						return true;
				}
			}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see com.bridgelabz.oopsconcept.BankingDetail#sell(long, java.lang.String)
	 */
	@Override
	public boolean sell(long amount, String symbol) throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		
		for (int i = 0; i < stockName.length; i++) {
			if(symbol.equals(stockName[i])==true) {
						shareRate[i]=(int) (shareRate[i]+amount);
						System.err.println("Available share rate of "+symbol+" is -> "+shareRate[i]);
						stackLinkedList.push(symbol);
						stackLinkedList.display();
						System.out.println("Enter the choice for other Stock Purchase");
						System.out.println("Enter \"1\" for further profile creation");
						System.out.println("Enter \"2\" to close the process");
						int choice=Utility.scanInt();
						switch (choice) {
						case 1:
							stock1.createProfile();
							break;
						case 2:
							System.out.println("Thanks for Creating Profile in Stock Market");
							break;
						default:
							System.out.println("Invalid Entry");
							break;
						}
						return true;
			}
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.bridgelabz.oopsconcept.BankingDetail#save(java.lang.String)
	 */
	@Override
	public void save(String fileName) throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		FileWriter fw=new FileWriter(FILEPATH);
		fw.write(fileName);
		fw.flush();
	}
	/* (non-Javadoc)
	 * @see com.bridgelabz.oopsconcept.BankingDetail#printReport()
	 */
	@Override
	public void printReport() throws FileNotFoundException, IOException, ParseException {
		JSONParser json=new JSONParser();
        Object obj=json.parse(new FileReader("/home/administrator/Funtional-Program/BridgeLabz/src/com/bridgelabz/oopsconcept/stockdetails.json"));
        JSONObject jsonObj = (JSONObject) obj;
        JSONArray totalShare = (JSONArray) jsonObj.get("customerArray");
        
        JSONObject customerDetails=(JSONObject) totalShare.get(0);
        JSONObject companyShareobj=(JSONObject) customerDetails.get("companyshare");
        singlyLinkedList.add(companyShareobj.get("shareArray1"));
        singlyLinkedList.display();
        JSONArray shareArray=(JSONArray) companyShareobj.get("shareArray1");
        for (int i = 0; i < shareArray.size(); i++) {
            JSONObject temp = (JSONObject) shareArray.get(i);
            System.out.println("| "+temp+" |");
        }
	}
	
	/**
	 * Main Function is to start stock Market
	 * @param args
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void main(String []args) throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		System.err.println("Create Profile");
		stock1.createProfile();
		System.out.println("Enter the stock Symbol if you want to purchased or sell your stock");
		String stockName=Utility.scanString();
		System.out.println("Enter amount of stock you want to purchased or sell");
		int amount=Utility.scanInt();
		System.out.println("Enter the choice for buying or selling the stock as 1 and 2");
		int choice = Utility.scanInt();
		StockAccount stock=new StockAccount();
		switch (choice) {
		case 1:
			stock.buy(amount,stockName);
			break;
		
		case 2:
			stock.sell(amount,stockName);
			break;

		default:
			System.err.println("Invalid Choices");
			break;
		}
		
	}
	@Override
	public void stockAccount(String fileName) {
		
	}
}
