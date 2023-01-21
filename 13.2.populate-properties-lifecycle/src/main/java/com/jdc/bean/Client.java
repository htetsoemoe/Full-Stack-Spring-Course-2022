package com.jdc.bean;

import org.springframework.stereotype.Component;

@Component
public class Client {
	
	private Service service;

	public Client() {
		System.out.println("Client was created.");
	}
	
	public void setService(Service service) {
		this.service = service;
	}

}
