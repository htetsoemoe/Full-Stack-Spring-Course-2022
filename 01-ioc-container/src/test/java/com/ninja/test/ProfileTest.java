package com.ninja.test;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ninja.fullstack.container.Message;
import com.ninja.fullstack.container.ResourceBean;

public class ProfileTest {
	
	@Test
	void test() {
		try(var context = new GenericXmlApplicationContext()) {
			
			var environment = context.getEnvironment();
			environment.setActiveProfiles("publish");
			
			context.load("classpath:/app-config.xml");
			context.refresh();
			
			System.out.println(Arrays.toString(environment.getActiveProfiles()));
			System.out.println(Arrays.toString(environment.getDefaultProfiles()));
			
			var bean = context.getBean(Message.class);
			System.out.println(bean.getValue());
			
			
			var resource = context.getBean(ResourceBean.class);
			System.out.println(resource.data());
			
		}
	}

}
