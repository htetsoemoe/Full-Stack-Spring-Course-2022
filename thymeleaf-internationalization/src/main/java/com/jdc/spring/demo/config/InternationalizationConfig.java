package com.jdc.spring.demo.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class InternationalizationConfig {
	
	@Bean
	MessageSource messageSource() {
		var bean = new ResourceBundleMessageSource();
		bean.addBasenames("/inter/app-labels");
		return bean;
	}

}
