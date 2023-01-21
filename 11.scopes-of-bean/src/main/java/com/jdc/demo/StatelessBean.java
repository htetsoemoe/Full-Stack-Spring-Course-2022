package com.jdc.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class StatelessBean {
	private int value;
	
	public StatelessBean() {
		System.out.println("Stateless Bean Contructor Called.");
	}
	
	public void showCount() {
		System.out.println("Stateless count is %d.".formatted(++value));
	}
}
