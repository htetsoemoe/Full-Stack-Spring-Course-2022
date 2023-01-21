package com.jdc.fullstack;

public class InstanceZooFactory {

	private boolean bigSize;
	
	public InstanceZooFactory(boolean bigSize) {
		this.bigSize = bigSize;
	}
	
	public ZooInterface getZoo() {
		var zoo = new Zoo();
		
		zoo.setAnimals(new String[bigSize ? 100 : 30]);
		zoo.setCustomers(bigSize ? 300 : 30);
		zoo.setEmployees(bigSize ? 100 : 30);
		
		return zoo;
	}
	
}
