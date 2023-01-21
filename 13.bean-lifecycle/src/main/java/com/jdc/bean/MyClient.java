package com.jdc.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyClient implements InitializingBean{
	
	@Autowired
	MyService myService;

	@Override
	public void afterPropertiesSet() throws Exception {
		this.myService.prepareData();
	}
	
	public void sayHello() {
		System.out.println("Hello from MyService! This bean is ready to use stage.");
	}
}
