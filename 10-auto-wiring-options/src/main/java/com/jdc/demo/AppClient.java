package com.jdc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jdc.config.qualifiers.ServiceOne;

@Component
public class AppClient {
	
	private AppService service;
	
	@Autowired
	public AppClient(@ServiceOne AppService service) { // @Autowire inject using Constructor argument name
		super();
		this.service = service;
	}

	public void setService(AppService service) {
		this.service = service;
	}
	
	public AppService getService() {
		return service;
	}
}
