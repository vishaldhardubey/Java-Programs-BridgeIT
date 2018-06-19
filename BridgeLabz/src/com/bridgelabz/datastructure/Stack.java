package com.bridgelabz.datastructure;

public class Stack<T> {
	static Object[] obj;
	static int size;
	static int top=-1;
	
	/*****************************************************************************
	 * Function to initialize the size of stack.
	 * @param size
	 * @return 
	 */
	public Object[] Stack(Comparable<T> size) {
		this.size=(int) size;
		obj=new Object[(int) size];
		return obj;
	}
	
	/*****************************************************************************
	 * Function to push the data.
	 * @param data
	 * @return 
	 */
	public static Object push(Comparable data) {
		if(top==size-1) {
			System.out.println("Stack Overflow");
			return obj;
		}
		return obj[++top]=data;
	}
	/*****************************************************************************
	 * Function to pop the element from given Object stack.
	 * @return object
	 */
	public static Object pop() {
		if(top==-1) {
			System.out.println("Empty Stack");
			return null;
		}
		top--;
		return obj[top];
	}
	/*****************************************************************************
	 * Function to get top element in the stack
	 * @return top 
	 */
	public Object peek() {
		if(top==-1) {
			System.out.println("Empty Stack");
			return null;
		}
		return obj[top];
	}
	
	/*****************************************************************************
	 * Function to check stack is empty or not.
	 * @return 
	 */
	public static boolean isEmpty() {
		if(top == -1) {
		System.out.println("Stack is Empty");
		return true;
		}
		return false;
	}
	/**
	 * Function to display elements present in stack
	 */
	public void display() {
		for (int i = 0; i < top; i++) {
			System.out.println(obj[i]);
		}
	}
	/**
	 * Function to return size of stack
	 * @return size.
	 */
	public int size() {
		 return size;
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
