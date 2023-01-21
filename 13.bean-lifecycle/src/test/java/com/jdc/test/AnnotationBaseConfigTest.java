package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationBaseConfigTest {
	
	@Test
	void test() {
		try(var context = new AnnotationConfigApplicationContext("com.jdc.bean")) {
			
		}
	}
}
