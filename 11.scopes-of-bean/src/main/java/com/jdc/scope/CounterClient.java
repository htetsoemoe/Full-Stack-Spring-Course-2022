package com.jdc.scope;

public class CounterClient {

	private Counter counter;
	private String name;

	public CounterClient(Counter counter, String name) {
		super();
		this.counter = counter;
		this.name = name;
		
		System.out.println("%s constructor was initialized.".formatted(name));
	}
	
	public void countUp() {
		System.out.println("""
				%s count is %d
				""".formatted(name, counter.getCount()));
	}

}
