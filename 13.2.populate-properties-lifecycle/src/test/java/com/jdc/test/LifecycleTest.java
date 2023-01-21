package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class LifecycleTest {
	
	@Test
	void testDemo() {
		try(var context = new GenericXmlApplicationContext()) {
			context.load("classpath:app-config.xml");
			context.refresh();
		}
	}

}
