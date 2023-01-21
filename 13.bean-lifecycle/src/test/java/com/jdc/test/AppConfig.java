package com.jdc.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jdc.bean.MyClient;
import com.jdc.bean.MyService;

@Configuration
public class AppConfig {
	
	@Bean
	MyService service() {
		return new MyService();
	}
	
	@Bean
	MyClient client() {
		return new MyClient();
	}
}
