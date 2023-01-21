package com.ninja.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ninja.bean.post.RuntimeMessage;

public class BeanFactoryPostProcessorTest {
	
	private static final String CONFIG = "classpath:/post-processor.xml";
	
	@Test
	void test() {
		try(var context = new GenericXmlApplicationContext(CONFIG)) {
			var bean = context.getBean(RuntimeMessage.class);
			System.out.println(bean.getValue());
		}
	}
}
