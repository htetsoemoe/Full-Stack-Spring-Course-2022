package com.ninja.fullstack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ninja.fullstack.container.Message;
import com.ninja.fullstack.container.ResourceBean;
import com.ninja.fullstack.container.ResourceTest;

@Configuration
@Profile("test")
public class TestConfig {

	@Bean
	Message testMessage() {
		return new Message("This is test message.");
	}
	
	@Bean
	ResourceBean testResource() {
		return new ResourceTest();
	}

}
