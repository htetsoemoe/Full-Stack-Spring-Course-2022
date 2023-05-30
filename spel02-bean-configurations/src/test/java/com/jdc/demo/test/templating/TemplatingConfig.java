package com.jdc.demo.test.templating;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TemplatingConfig {
	
	@Bean
	User defaultUser() {
		return new User("Thaw Thaw", 27);
	}
}
