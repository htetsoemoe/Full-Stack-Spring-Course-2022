package com.jdc.demo.aspects;

public class MessageLogger {
	public void doBefore() {
		System.out.println("Before Business Method Invocation.");
	}
	
	public void doAfter() {
		System.out.println("After Business Method Invocation.");
	}
}
