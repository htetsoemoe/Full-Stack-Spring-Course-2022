package com.ninja.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ninja.fullstack.container.ResourceBean;

public class ProfileAnnotationTest {
	
	@Test
	void test() {
		System.setProperty("spring.profiles.active", "release");
		
		try(var context = new AnnotationConfigApplicationContext("com.ninja.fullstack")) {
			var bean = context.getBean(ResourceBean.class);
			System.out.println(bean.data());
		}
	}

}
