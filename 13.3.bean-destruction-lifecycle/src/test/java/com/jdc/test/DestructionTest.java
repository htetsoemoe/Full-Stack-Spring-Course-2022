package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jdc.bean.SimpleBean;

public class DestructionTest {
	
	@Test
	void test() {
		try(var context = new GenericXmlApplicationContext()) {
			context.load("classpath:app-config.xml");
			context.refresh();
			
			var bean = context.getBean(SimpleBean.class);
			context.getBeanFactory().destroyBean(bean);
		}
	}

}
