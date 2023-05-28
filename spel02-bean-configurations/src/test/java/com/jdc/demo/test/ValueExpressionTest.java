package com.jdc.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.ExpressionConfigDemo;

@SpringJUnitConfig(classes = ExpressionConfigDemo.class)
public class ValueExpressionTest {

	@Value("#{'Hello Spring EL'}")
	String hello;
	
	@Value("#{'TT''s Clothing Store'}")
	String helloEscapeChar;
	
	@Value("#{new int[] {1, 2, 3}}")
	int myArray[];
	
	@Value("#{{'Hello', 'Spring', 'Expression Language'}}")
	List<String> lists;
	
	@Value("#{{'One':'Text One', 'Two':'Text Two'}}")
	Map<String, String> map;
	
	@Value("#{new java.util.Date()}")
	Date now;
	
	@Test
	void test() {
		assertEquals("Hello Spring EL", hello);
		assertEquals("TT's Clothing Store", helloEscapeChar);
		assertEquals(3, myArray.length);
		assertEquals(3, lists.size());
		assertEquals(2, map.size());
		assertNotNull(now);
		
	}
}
