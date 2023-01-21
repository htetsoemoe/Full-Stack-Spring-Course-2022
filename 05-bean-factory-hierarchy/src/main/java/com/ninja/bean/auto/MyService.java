package com.ninja.bean.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyService {
	
	
	private String message;
	
	@Autowired
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void showMessage() {
		System.out.println("Message is \" %s \" %n ".formatted(message));
	}

}
