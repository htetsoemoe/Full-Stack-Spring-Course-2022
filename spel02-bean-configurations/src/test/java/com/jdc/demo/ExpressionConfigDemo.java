package com.jdc.demo;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExpressionConfigDemo {

	@Bean
	LocalDate today() {
		return LocalDate.now();
	}
}
