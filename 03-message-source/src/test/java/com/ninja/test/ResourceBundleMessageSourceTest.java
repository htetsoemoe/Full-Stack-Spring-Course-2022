package com.ninja.test;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@SpringJUnitConfig(locations = "classpath:/application.xml")
public class ResourceBundleMessageSourceTest {

//	@Autowired
//	ResourceBundleMessageSource messageSource;
	
	@Autowired
	ApplicationContext messageSource;
	
	@Test
	void test() {
		var message = messageSource.getMessage("title", new Object[] {"John Doe"}, new Locale("my"));
		System.out.println(message);
	}
}
