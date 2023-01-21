package com.ninja.fullstack.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MessageSourceConfig {
	
	@Bean
	public MessageSource messsgeSource() {
		var ms = new ResourceBundleMessageSource();
		ms.setBasename("greetings");
		return ms;
	}

}
