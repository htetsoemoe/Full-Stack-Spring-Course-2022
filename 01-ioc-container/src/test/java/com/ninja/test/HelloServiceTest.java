package com.ninja.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ninja.fullstack.container.HelloService;

public class HelloServiceTest {
	
	public HelloService service;
	public static ConfigurableApplicationContext CONTAINER;
	
	public static final String CONFIG_FILE = "classpath:/app-config.xml";
	
	@BeforeAll
	static void start() {
		CONTAINER = new GenericXmlApplicationContext(CONFIG_FILE);
	}
	
	@AfterAll
	static void end() {
		CONTAINER.close();
	}
	
	@Test
	void test() {
		service = CONTAINER.getBean("service", HelloService.class);
		
		Assertions.assertNotNull(service);
		Assertions.assertEquals("Hello Spring IoC Container", service.getMessage());
	}
}
