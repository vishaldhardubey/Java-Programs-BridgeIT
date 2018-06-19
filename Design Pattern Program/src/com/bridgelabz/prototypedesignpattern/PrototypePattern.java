package com.bridgelabz.prototypedesignpattern;

import java.util.ArrayList;
import java.util.List;

class Employee implements Cloneable{
private List<String> employeeList;
	
	public Employee(){
		employeeList = new ArrayList<String>();
	}
	
	public Employee(List<String> list){
		this.employeeList=list;
	}
	public void loadData(){
		employeeList.add("vishal");
		employeeList.add("baba");
		employeeList.add("raja");
		employeeList.add("babu");
	}
	public List<String> getEmpList() {
		return employeeList;
	}

	@Override
	public Object clone() throws CloneNotSupportedException{
			List<String> temp = new ArrayList<String>();
			for(String s : this.getEmpList()){
				temp.add(s);
			}
			return new Employee(temp);
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
			Employee emp =new Employee();
			emp.loadData();
			
			Employee emp1=(Employee) emp.clone();
			Employee emp2=(Employee) emp.clone();			
			
			List<String> list = emp1.getEmpList();
			list.add("vishal");
			List<String> list1 = emp2.getEmpList();
			list1.remove("baba");
			
			System.out.println("emps List: "+emp1.getEmpList());
			System.out.println("emps1 List: "+list);
			System.out.println("emps2 List: "+list1);
		}
}