package com.jdc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {
		"com.jdc.service",
		"com.jdc.aspects"
})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

}
