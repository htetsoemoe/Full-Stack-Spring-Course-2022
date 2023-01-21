package com.ninja.fullstack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ninja.fullstack.container.Message;
import com.ninja.fullstack.container.ResourceBean;
import com.ninja.fullstack.container.ResourceRelease;

@Configuration
@Profile("release")
public class ProfileConfig {
		
	@Bean
	Message releaseMessage() {
		return new Message("This is release message.");
	}
	
	@Bean
	ResourceBean releaseResource() {
		return new ResourceRelease();
	}

}
