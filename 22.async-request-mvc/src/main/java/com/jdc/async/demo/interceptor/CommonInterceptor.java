package com.jdc.async.demo.interceptor;

public class CommonInterceptor implements ActionInterceptor{

	@Override
	public void preProcess(Action action) {
		System.out.println("PreProcess from CommonIntercepter.");
	}
}
