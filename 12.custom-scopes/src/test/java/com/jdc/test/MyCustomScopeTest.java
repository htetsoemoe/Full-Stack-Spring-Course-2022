package com.jdc.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.customscope.AppConfig;
import com.jdc.customscope.MyCustomObject;

public class MyCustomScopeTest {
	
	@Test
	void test() {
		try(var context = new AnnotationConfigApplicationContext()) {
			context.register(AppConfig.class);
			context.refresh();
			
			Assertions.assertNotNull(context.getBean(MyCustomObject.class));
			Assertions.assertNotNull(context.getBean(MyCustomObject.class));
		}
	}
}
