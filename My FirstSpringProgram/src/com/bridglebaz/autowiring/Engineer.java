package com.bridglebaz.autowiring;

public class Engineer {
	private Branch branch;
	private Branch branch2;
	public Branch getBranch2() {
		return branch2;
	}
	public void setBranch2(Branch branch2) {
		this.branch2 = branch2;
	}
	public Engineer() {
	}
	@Override
	public String toString() {
		return "Engineer [branch=" + branch + ", branch2=" + branch2 + "]";
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
}
