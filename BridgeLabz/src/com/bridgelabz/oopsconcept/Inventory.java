package com.bridgelabz.oopsconcept;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Inventory implements Serializable {
		
		private ArrayList<Rice> arrayRice=new ArrayList<Rice>();
		private ArrayList<Pulses> arrayPulses=new ArrayList<Pulses>();
		private ArrayList<Wheat> arrayWheat=new ArrayList<Wheat>();
		
		
		public ArrayList<Rice> getRice() {
			return arrayRice;
		}
		public void setRice(ArrayList<Rice> arrayRice) {
			this.arrayRice = arrayRice;
		}
		public ArrayList<Pulses> getPulses() {
			return arrayPulses;
		}
		public void setPulses(ArrayList<Pulses> arrayPulses) {
			this.arrayPulses = arrayPulses;
		}
		public ArrayList<Wheat> getWheat() {
			return arrayWheat;
		}
		public void setWheat(ArrayList<Wheat> arrayWheat) {
			this.arrayWheat = arrayWheat;
		}
	
}
