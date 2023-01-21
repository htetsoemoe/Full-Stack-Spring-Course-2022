package com.ninja.HelloSpringBeanTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ninja.hello.MyBean;

public class HelloSpringBeanTest {

	@Test
	void test () {
		try(var context = new GenericApplicationContext()) {
			
			// creates BeanDefinition
			var definition = new GenericBeanDefinition();
			definition.setBeanClass(MyBean.class);
			
			// register BeanDefinition to IoC 
			context.registerBeanDefinition("myBean", definition);
			
			// IoC container needs to refresh for bean instantiation
			context.refresh();
			
			var bean = context.getBean(MyBean.class);
			
			assertNotNull(bean);
			assertEquals("Hello Spring Bean", bean.getMessage());
		}
	}
}
