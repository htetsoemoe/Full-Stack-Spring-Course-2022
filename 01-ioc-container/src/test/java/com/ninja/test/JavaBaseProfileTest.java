package com.ninja.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ninja.fullstack.config.ProfileConfig;
import com.ninja.fullstack.config.TestConfig;
import com.ninja.fullstack.container.Message;
import com.ninja.fullstack.container.ResourceBean;

public class JavaBaseProfileTest {
	
	@Test
	void test() {
		System.setProperty("spring.profiles.active", "test");
		
		try(var context = new AnnotationConfigApplicationContext(ProfileConfig.class, TestConfig.class)) {
			var message = context.getBean(Message.class);
			System.out.println(message.getValue());
			
			var resource = context.getBean(ResourceBean.class);
			System.out.println(resource.data());
		}
	}

}
