package com.bridglebaz.autowiring;

public class Branch {
	private String name;
	private int code;
	Branch1 branch1;
	Branch(){}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Branch1 getBranch1() {
		return branch1;
	}
	public void setBranch1(Branch1 branch1) {
		this.branch1 = branch1;
	}
	@Override
	public String toString() {
		return "Branch [name=" + name + ", code=" + code + ", branch1=" + branch1 + "]";
	}
	public Branch(String name, int code, Branch1 branch1) {
		super();
		this.name = name;
		this.code = code;
		this.branch1 = branch1;
	}
	
}
