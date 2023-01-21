package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.bean.MyClient;

public class JavaBasedConfigTest {
	@Test
	void test() {
		try(var context = new AnnotationConfigApplicationContext(AppConfig.class)) {
			var myClient = context.getBean(MyClient.class);
			myClient.sayHello();
		}
	}
}
