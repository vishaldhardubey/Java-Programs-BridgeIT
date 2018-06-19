package com.bridgelabz.oopsconcept;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;

import com.bridgelabz.utility.Utility;

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

public class DataManagement {
    static long TOTAL_PRICE_RICE;
    static long TOTAL_PRICE_PULSES;
    static long TOTAL_PRICE_WHEAT;
    static Utility utility = new Utility();

    public static Rice makeRiceObject() {
        System.out.println("Enter the name of rice");
        String name = utility.scanString();
        System.out.println("Enter the weight:");
        int weight = utility.scanInt();
        System.out.println("Enter the price per kg:");
        long price = utility.scanLong();
        Rice rice=new Rice(name, weight, price);
        return rice;
    }

    public static Pulses makePulsesObject() {
       
        System.out.println("Enter the name of pulses");
        String name = utility.scanString();
        System.out.println("Enter the weight:");
        long weight = utility.scanLong();
        System.out.println("Enter the price per kg:");
        long price = utility.scanLong();
        Pulses pulses = new Pulses(name, weight, price);
        return pulses;
    }

    public static Wheat makeWheatObject() {
        System.out.println("Enter the name of wheat");
        String name = utility.scanString();
        System.out.println("Enter the weight:");
        long weight = utility.scanLong();
        System.out.println("Enter the price per kg:");
        long price = utility.scanLong();
        Wheat wheat = new Wheat(name, weight, price);
        return wheat;
    }

    public static void main(String[] args)
            throws JsonGenerationException, JsonMappingException, IOException, ParseException {
        Inventory inventory = new Inventory();
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("Enter how many types of rice you are having");
        int riceTypes = utility.scanInt();
        Rice rice = new Rice();
        for (int i = 0; i < riceTypes; i++) {
            rice = makeRiceObject();
            inventory.getRice().add(rice);
        }

        System.out.println("Enter how many types of pulses you are having");
        int pulsesTypes = utility.scanInt();
        Pulses pulses = new Pulses();
        for (int i = 0; i < pulsesTypes; i++) {
            pulses = makePulsesObject();
            inventory.getPulses().add(pulses);
        }
        System.out.println("Enter how many types of wheat you are having");
        int wheatTypes = utility.scanInt();
        Wheat wheat = new Wheat();
        for (int i = 0; i < wheatTypes; i++) {
            wheat = makeWheatObject();
            inventory.getWheat().add(wheat);
        }
        mapper.writeValue(new File("/home/administrator/Desktop/example.json"),inventory);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("/home/administrator/Desktop/example.json"));
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray arrayRice = (JSONArray) jsonObject.get("rice");
        for (int i = 0; i < arrayRice.size(); i++) {
            JSONObject temporary = (JSONObject) arrayRice.get(i);
            TOTAL_PRICE_RICE += (long) temporary.get("weight") * (long) temporary.get("price");
        }
        JSONArray arrayPulses = (JSONArray) jsonObject.get("pulses");
        for (int i = 0; i < arrayPulses.size(); i++) {
            JSONObject temporary = (JSONObject) arrayPulses.get(i);
            TOTAL_PRICE_PULSES += (long) temporary.get("weight") * (long) temporary.get("price");
        }
        JSONArray arrayWheat = (JSONArray) jsonObject.get("wheat");
        for (int i = 0; i < arrayWheat.size(); i++) {
            JSONObject temporary = (JSONObject) arrayWheat.get(i);
            TOTAL_PRICE_WHEAT += (long)temporary.get("weight") * (long) temporary.get("price");

            System.out.println("The overall price of rice in stock is " + TOTAL_PRICE_RICE + " rupees");
            System.out.println("The overall price of pulses in stock is " + TOTAL_PRICE_PULSES + " rupees");
            System.out.println("The overall price of wheat in stock is " + TOTAL_PRICE_WHEAT + " rupees");

        }

    }
}

