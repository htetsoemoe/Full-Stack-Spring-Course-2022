package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jdc.bean.MyClient;

public class XMLConfigTest {
	
	@Test
	void test() {
		try(var context = new GenericXmlApplicationContext("classpath:/app-config.xml")) {
			var bean = context.getBean(MyClient.class);
		}
	}

}

// Singleton beans instantiated before BeanFctory Initialization, that's why we don't need to create the bean from context