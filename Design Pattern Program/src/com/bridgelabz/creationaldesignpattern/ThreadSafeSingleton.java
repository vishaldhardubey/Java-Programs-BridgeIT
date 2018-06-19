package com.bridgelabz.creationaldesignpattern;

class ThreadSafeSingletonMain {
	private static ThreadSafeSingletonMain instance=null;
	private ThreadSafeSingletonMain() {
		System.out.println("Object has been created");
	}
	public static synchronized ThreadSafeSingletonMain getInstance() {
		if(instance==null) {
			instance=new ThreadSafeSingletonMain();
		}
		return instance;
	}
	public static ThreadSafeSingletonMain getInstanceUsingDoubleLocking() {
		if(instance==null) {
			synchronized (ThreadSafeSingletonMain.class) {
				if(instance==null) {
					instance=new ThreadSafeSingletonMain();
				}
			}
		}
		return instance;
	}
}
public class ThreadSafeSingleton{
	public static void main(String[] args) {
		ThreadSafeSingletonMain ref1=ThreadSafeSingletonMain.getInstance();
		System.out.println(ref1.hashCode());
		ThreadSafeSingletonMain ref2=ThreadSafeSingletonMain.getInstanceUsingDoubleLocking();
		System.out.println(ref2.hashCode());
	}
}
