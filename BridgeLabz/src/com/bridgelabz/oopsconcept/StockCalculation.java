package com.bridgelabz.oopsconcept;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;

public class StockCalculation {
	static long totalValue;
	static long stockTotalValue;
	public static Stock stockDetails() {
		Stock stock=new Stock();
		System.out.println("Enter the name Stock");
        String name = Utility.scanString();
        stock.setShareName(name);
        System.out.println("Enter the Nu of Stock");
        int noOfShare = Utility.scanInt();
        stock.setNumOfShare(noOfShare);
        System.out.println("Enter the price of Stock");
        long sharePrice = Utility.scanLong();
        stock.setSharePrice(sharePrice);
        return stock;
	}
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		StockPortfolio stockPortfolio = new StockPortfolio();
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("Enter how many shares you want");
        long stockNum=Utility.scanLong();
        Stock stock=new Stock();
        for (int i = 0; i < stockNum; i++) {
        	stock = stockDetails();
            stockPortfolio.getArrayStock().add(stock);
        }
        mapper.writeValue(new File("/home/administrator/Desktop/Stock.json"), stockPortfolio);
        
        JSONParser json=new JSONParser();
        Object jsonObj=json.parse(new FileReader("/home/administrator/Desktop/Stock.json"));
        JSONObject jsonObject = (JSONObject) jsonObj;
        JSONArray arrayStock = (JSONArray) jsonObject.get("arrayStock");
        for (int i = 0; i < arrayStock.size(); i++) {
            JSONObject temp = (JSONObject) arrayStock.get(i);
            System.out.println("| "+temp+" |");
        }
        for (int i = 0; i < arrayStock.size(); i++) {
            JSONObject temp = (JSONObject) arrayStock.get(i);
            totalValue += (long) temp.get("numOfShare")* (long)temp.get("sharePrice");
        }
        System.out.println("Total Price of given stock is : "+totalValue);
        
        
        
	}
}
