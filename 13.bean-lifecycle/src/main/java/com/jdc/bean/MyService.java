package com.jdc.bean;

import org.springframework.stereotype.Component;

@Component
public class MyService {
	public void prepareData() {
		System.out.println("Preparing data from MyService.");
	}
}
