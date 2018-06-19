package com.bridgelabz.oopsconcept;

import java.util.ArrayList;
import java.util.LinkedList;

public class PersonDataBase {
	
	ArrayList<A_PersonDetails> personList=new ArrayList<A_PersonDetails>();

	public ArrayList<A_PersonDetails> getPersonList() {
		return personList;
	}
	public void setPersonList(ArrayList<A_PersonDetails> personList) {
		this.personList = personList;
	}
}
