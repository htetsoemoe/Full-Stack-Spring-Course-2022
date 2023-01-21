package com.ninja.bean;

public class ParentService implements Service{

	@Override
	public String handle() {
		return "Message from Parent Service";
	}

}
