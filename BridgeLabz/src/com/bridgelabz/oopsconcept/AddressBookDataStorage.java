package com.bridgelabz.oopsconcept;

import java.util.ArrayList;

import org.json.simple.JSONArray;

public interface AddressBookDataStorage {
	public ArrayList read();
	void doSave(JSONArray jsonArray);
}
