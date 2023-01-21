package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jdc.command.xml.CommandManager;

public class CommandTest {
	
	/*
	 * @Test void test() { try(var context = new
	 * AnnotationConfigApplicationContext("com.jdc.command")) { for(var i = 0; i <
	 * 3; i++) { var bean1 = context.getBean(CommandManager.class); bean1.execute();
	 * } } }
	 */
	
	
	@Test
	void test() {
		try(var context = new GenericXmlApplicationContext("classpath:/app-config.xml")) {
			for(var i = 0; i < 3; i++) {
				var bean1 = context.getBean(CommandManager.class);
				bean1.execute();
			}
		}
	}

}
