package com.ninja.fullstack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.ninja.fullstack.container.HelloService;

@Component
public class MyBeans {
	
	@Bean
	HelloService service() {
		return new HelloService();
	}

}
