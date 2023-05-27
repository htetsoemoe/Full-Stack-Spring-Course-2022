package com.jdc.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.ExpressionConfigDemo;

@SpringJUnitConfig(classes = ExpressionConfigDemo.class)
public class SpelOperatorsTest {
	
	@Value("#{10 gt 17}")
	boolean result_01;
	
	@Value("#{10 le 17}")
	boolean result_02;
	
	@Value("#{10 + 7}")
	int value_01;
	
	// Elvis Operator => Nullable ?: Default
	@Value("#{systemProperties['user.images'] ?: 'C:\\Users\\DELL\\images'}")
	String folder;
	
	@Test
	void test() {
		assertFalse(result_01);
		assertTrue(result_02);
		
		assertEquals(17, value_01);
		
		assertEquals("C:\\Users\\DELL\\images", folder);
	}
}
