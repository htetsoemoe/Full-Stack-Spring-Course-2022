package com.jdc.customscope;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.jdc.customscope")
public class AppConfig {
	
	@Bean
	CustomScopeConfigurer customScopeConfigurer(CustomScope customScope) {
		var config = new CustomScopeConfigurer();
		config.addScope("custom", customScope);
		return config;
	}

}
