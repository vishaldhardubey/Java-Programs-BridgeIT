package com.bridgelabz.oopsconcept;

import java.io.Serializable;

public class Rice implements Serializable{
	private String Name;
	private long Weight;
    private long Price;
    
    public Rice() {}
	public Rice(String name, long weight, long price) {
		super();
		Name = name;
		Weight = weight;
		Price = price;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public long getWeight() {
		return Weight;
	}
	public void setWeight(long weight) {
		Weight = weight;
	}
	public long getPrice() {
		return Price;
	}
	public void setPrice(long price) {
		Price = price;
	}
	
}
