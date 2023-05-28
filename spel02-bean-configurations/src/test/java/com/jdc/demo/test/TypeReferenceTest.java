package com.jdc.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.ExpressionConfigDemo;

@SpringJUnitConfig(classes = ExpressionConfigDemo.class)
public class TypeReferenceTest {
	
	@Value("#{T(java.lang.Integer).MAX_VALUE}")
	int maxValue;
	
	@Value("#{T(com.jdc.demo.MyFormatter).format(100000)}")
	String formattedValue;
	
	@Test
	void test() {
		assertEquals(Integer.MAX_VALUE, maxValue);
		assertEquals("100,000", formattedValue);
	}

}
