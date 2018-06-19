package com.bridgelabz.oopsconcept;

public class A_PersonDetails {
		private String personName;
		private long mobileNumber; 
		private String city;
		private String state;
		private int ZIP;
	
		//Default constructor of a class
	/**
	 * Functions to set and get the persons details
	 * @return details
	 */
		public String getPersonName() {
			return personName;
		}
		public void setPersonName(String personName) {
			this.personName = personName;
		}
		public long getMobileNumber() {
			return mobileNumber;
		}
		public void setMobileNumber(long mobileNumber) {
			this.mobileNumber = mobileNumber;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public int getZIP() {
			return ZIP;
		}
		public void setZIP(Integer ZIP) {
			this.ZIP = ZIP;
	}
}
