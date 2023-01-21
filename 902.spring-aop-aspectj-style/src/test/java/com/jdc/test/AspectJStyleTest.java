package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.config.AppConfig;
import com.jdc.service.MyService;

@SpringJUnitConfig(classes = AppConfig.class)
public class AspectJStyleTest {

	@Autowired
	MyService myService;
	
	@Test
	void test() {
		myService.divided(10, 0);
	}
}
