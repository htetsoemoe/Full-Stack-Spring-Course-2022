package com.jdc.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.ElJavaConfiguration;
import com.jdc.demo.ImageFileProvider;

//@SpringJUnitConfig(locations = "classpath:/application.xml")
@SpringJUnitConfig(classes = ElJavaConfiguration.class)
public class ElConfigurationTest {
	
	@Autowired
	private ImageFileProvider fileProvider;
	
	@Test
	void demo() {
		assertNotNull(fileProvider);
		assertEquals("C:\\Users\\DELL", fileProvider.getBaseDirectory());
		System.out.println(fileProvider.getBaseDirectory());
	}

}
