package com.jdc.scope;

public class Counter {
	
	private int count;
	
	public Counter() {
		System.out.println("Counter constructor was initialized.");
	}
	
	public int getCount() {
		return ++count;
	}

}
