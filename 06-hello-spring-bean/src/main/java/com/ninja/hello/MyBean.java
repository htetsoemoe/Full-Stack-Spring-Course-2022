package com.ninja.hello;

import org.springframework.stereotype.Component;

@Component
public class MyBean {
	
	private String message;
	
	public MyBean() {
		this.message = "Hello Spring Bean";
	}
	
	public String getMessage() {
		return message;
	}
	
}
