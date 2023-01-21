package com.jdc.test;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/*import com.jdc.fullstack.AbstractZoo;
import com.jdc.fullstack.Zoo;
import com.jdc.fullstack.ZooInterface;*/

public class Testing {

	@Test
	void test() {
		try (var context = new GenericXmlApplicationContext()) {
			context.load(new ClassPathResource("application.xml"));
			context.refresh();
			System.out.println(Arrays.deepToString(context.getBeanDefinitionNames()));
			
			/*
			 * var bean1 = context.getBean(ZooInterface.class); 
			 * var bean2 =context.getBean(AbstractZoo.class); 
			 * var bean3 = context.getBean(Zoo.class);
			 * 
 			 * System.out.println(bean1); System.out.println(bean2);
 			 * System.out.println(bean3);
			 */
		}
	}

}
