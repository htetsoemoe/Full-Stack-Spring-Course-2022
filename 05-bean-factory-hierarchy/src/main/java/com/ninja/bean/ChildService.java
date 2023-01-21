package com.ninja.bean;

public class ChildService implements Service{

	@Override
	public String handle() {
		return "Message from Child Service";
	}

}
