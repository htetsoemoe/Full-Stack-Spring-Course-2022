package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.config.AppConfig;
import com.jdc.demo.AppClient;

public class AutoWiringOptionsTest {
	
	@Test
	void test() {
		/*
		 * try(var context = new GenericXmlApplicationContext()) {
		 * context.load("classpath:/app-config.xml"); context.refresh();
		 * 
		 * var client = context.getBean(AppClient.class);
		 * System.out.println(client.getService().getClass()); }
		 */
		
		
		try(var context = new AnnotationConfigApplicationContext()) {
			context.scan("com.jdc.demo");
			context.refresh();
			
			var client = context.getBean(AppClient.class);
			System.out.println(client.getService().getClass());//get 'Service' dependency name
		}
	}

}
