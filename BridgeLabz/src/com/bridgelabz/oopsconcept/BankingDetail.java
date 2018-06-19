package com.bridgelabz.oopsconcept;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.parser.ParseException;

public interface BankingDetail {
	public void stockAccount(String fileName);
	public double valueOf();
	public boolean buy(int amount, String symbol) throws JsonGenerationException, JsonMappingException, IOException, ParseException;
	public boolean sell(long amount, String symbol) throws JsonGenerationException, JsonMappingException, IOException, ParseException;
	public void save(String fileName) throws JsonGenerationException, JsonMappingException, IOException, ParseException;
	public void printReport() throws FileNotFoundException, IOException, ParseException;
}
