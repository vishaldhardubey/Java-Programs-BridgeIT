package com.bridgelabz.creationaldesignpattern;

class BillPughSingletonImplementationA {
	private BillPughSingletonImplementationA() {
		System.out.println("Object has been created");
	}
	private static class SingletonHelper{
		private static final BillPughSingletonImplementationA INSTANCE =new BillPughSingletonImplementationA();
	}
	public static BillPughSingletonImplementationA getInstance() {
		return SingletonHelper.INSTANCE;
	}
}
public class BillPughSingletonImplementation{
	public static void main(String[] args) {
		BillPughSingletonImplementationA ref=	BillPughSingletonImplementationA.getInstance();
		System.out.println(ref.hashCode());
	}
}
