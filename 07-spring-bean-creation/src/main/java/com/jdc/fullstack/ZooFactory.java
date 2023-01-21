package com.jdc.fullstack;

public class ZooFactory {
	
	public static ZooInterface defaultZoo() {
		return new Zoo();
	}
	
	public static ZooInterface zooWithAnimalsCount(int count) {
		var zoo = new Zoo();
		zoo.setAnimals(new String[count]);
		return zoo;
	}
	
	public static ZooInterface zooWithEmployeesCount(int count) {
		var zoo = new Zoo();
		zoo.setEmployees(count);
		return zoo;
	}
	
	public static ZooInterface zooWithCustomersCount(int count) {
		var zoo = new Zoo();
		zoo.setCustomers(count);
		return zoo;
	}
}
