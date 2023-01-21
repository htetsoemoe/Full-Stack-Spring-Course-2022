package com.jdc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.jdc.scope.Counter;
import com.jdc.scope.CounterClient;

@Configuration
public class SingletonConfig {

	@Bean
	@Scope("prototype")
	Counter counter() {
		return new Counter();
	}
	
	@Bean
	@Scope("prototype")
	@Autowired
	CounterClient client(Counter counter) {
		return new CounterClient(counter, "Singleton");
	}
}
