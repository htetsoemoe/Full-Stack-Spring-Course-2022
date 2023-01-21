package com.ninja.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ninja.bean.auto.MyService;

@Configuration
@ComponentScan("com.ninja.bean.auto")
public class AutowireTest {
	
	@Bean
	String message() {
		return "Hello from message bean";
	}
	
	@Test
	void test() {
		try(var context = new AnnotationConfigApplicationContext(AutowireTest.class)) {
			
			// Using Spring Framework
//			var service = context.getBean(MyService.class);
//			service.showMessage();
			
			
			var service = new MyService();
			context.getAutowireCapableBeanFactory().autowireBean(service);
			service.showMessage();
		}
	}

}
