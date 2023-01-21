package com.jdc.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.jdc.demo.AppClient;
import com.jdc.demo.AppService;
import com.jdc.demo.AppServiceOne;
import com.jdc.demo.AppServiceTwo;

@Configuration
@ImportResource("classpath:app-config.xml")
public class AppConfig {

	@Bean
	AppClient appClient(@Qualifier("two") AppService service) {
		return new AppClient(service);
	}
	
	@Bean
	AppServiceOne one() {
		return new AppServiceOne();
	}

	@Bean(autowireCandidate = false)
	AppServiceTwo two() {
		return new AppServiceTwo();
	}

}
