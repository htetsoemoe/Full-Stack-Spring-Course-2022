package com.jdc.demo;

import java.util.Set;

import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.stereotype.Component;

import com.jdc.config.qualifiers.ServiceOne;
import com.jdc.config.qualifiers.ServiceTwo;

@Component
public class CustomQualifierRegistrationBean extends CustomAutowireConfigurer {
	public CustomQualifierRegistrationBean() {
		setCustomQualifierTypes(Set.of(
				ServiceOne.class, 
				ServiceTwo.class));
	}
}
