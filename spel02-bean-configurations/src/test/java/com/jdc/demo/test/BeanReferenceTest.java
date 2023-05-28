package com.jdc.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.ExpressionConfigDemo;

@SpringJUnitConfig(classes = ExpressionConfigDemo.class)
public class BeanReferenceTest {
	
	@Value("#{@today}")
	LocalDate now;

	@Test
	void test() {
		assertNotNull(now);
		assertEquals(LocalDate.now(), now);
	}
}
