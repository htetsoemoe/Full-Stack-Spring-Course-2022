package com.jdc.demo.test.templating;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = TemplatingConfig.class)
public class TemplatingExpressionTest {
	
	@Value("Hello! I am #{@defaultUser.name()} and #{@defaultUser.age()} years old.")
	String message;

	@Test
	void test() {
		System.out.println(message);
	}
}
