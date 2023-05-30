package com.jdc.demo;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jdc.demo.entity.Address;
import com.jdc.demo.entity.Member;

@Configuration
public class ExpressionConfigDemo {

	@Bean
	LocalDate today() {
		return LocalDate.now();
	}
	
	@Bean
	Member member() {
		var address = new Address(1, "No.94120", "50th street", "Chanmyatharzi");
		return new Member(1, "Thaw Thaw", address);
	}
}
