package com.jdc.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.ExpressionConfigDemo;

@SpringJUnitConfig(classes = ExpressionConfigDemo.class)
public class BeanPropertiesAccessDemo {
	
	@Value("#{@member.name}")
	String name;
	
	@Value("#{@member.address.township}")
	String township;
	
	@Value("#{T(com.jdc.demo.NumberGenerator).generate()}")
	int randomNumber;
	
	@Test
	void test() {
		assertEquals("Thaw Thaw", name);
		assertEquals("Chanmyatharzi", township);
		assertTrue(randomNumber <= 100);
	}

}
