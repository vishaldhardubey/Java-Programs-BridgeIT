package com.bridglebaz.autowiring;

public class Branch1 {
	private String branchl;
	public Branch1() {}
	public Branch1(String branchl) {
		this.branchl = branchl;
	}

	@Override
	public String toString() {
		return "Branch1 [branchl=" + branchl + "]";
	}
}
