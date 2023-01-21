package com.ninja.fullstack.container;

import org.springframework.stereotype.Component;

@Component
public class HelloService {
	public String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
