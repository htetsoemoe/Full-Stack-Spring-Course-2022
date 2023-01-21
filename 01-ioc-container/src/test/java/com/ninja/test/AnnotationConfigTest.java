package com.ninja.test;

import org.junit.jupiter.api.AfterAll;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ninja.fullstack.config.MyBeans;
import com.ninja.fullstack.container.HelloService;

public class AnnotationConfigTest {
	public static ConfigurableApplicationContext CONTAINER;
	public static final String BASE_PACKAGE = "com.ninja.fullstack";
	
	@BeforeAll
	static void init() {
		CONTAINER = new AnnotationConfigApplicationContext(MyBeans.class);//creates IoC container with Java Config class
	}
	
	@AfterAll
	static void close() {
		CONTAINER.close();
	}
	
	@Test
	void test() {
		var bean = CONTAINER.getBean(HelloService.class);
		assertNotNull(bean); // using import static
		assertNull(bean.getMessage());
	}
}
