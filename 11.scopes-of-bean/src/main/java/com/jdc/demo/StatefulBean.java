package com.jdc.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class StatefulBean {

	private int value;
	
	public StatefulBean() {
		System.out.println("Stateful Bean Constructor Called.");
	}
	
	public void showCount() {
		System.out.println("Stateful count is %d.".formatted(++value));
	}
}
