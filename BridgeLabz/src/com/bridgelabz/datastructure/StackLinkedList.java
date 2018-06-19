package com.bridgelabz.datastructure;

public class StackLinkedList<T> {
	
	Node<T>top;
	int size;
	/**
	 * Function to push the element into the stack
	 * @param data
	 */
	public void push(T data)
		{
			Node<T> n = new Node<T>(data);
			if(top==null)
			{
				top = n;
				size++;
				return;
			}
			n.next = top;
			top = n;
			size++;
		}
	/**
	 * Function to pop the element from stack.
	 * @return element
	 */
	public T pop()
	{
		if(top == null)
		{
			System.out.println("stack empty");
			return null;
		}
		Node<T> t = top;
		top = t.next;
		size--;
		return (T)t.data;
	}
		
	/**
	 * FUnction to display the element of the stack.
	 */
	public void display() {
		if(size==0) {
			System.out.println("Empty");
			return;
		 }
		 Node<T> temp=top;
		 while(temp!=null) {
			 System.out.println("Data : "+temp.data);
			 temp=temp.next;
		 }
	 }
	
	public void display1() {
		 Node<T> temp=top;
		 while(temp!=null) {
			 System.out.print(" "+temp.data);
			 temp=temp.next;
		 }
	 }
	
	/**
	 * Function to simply return the size of the stack.
	 * @return size
	 */
	public int size() {
		 return size;
	 }
	
	/**
	 * Function to check whether the given stack is empty or not.
	 * @return boolean
	 */
	public boolean isEmpty() {
		 return size==0;
	 }
}
