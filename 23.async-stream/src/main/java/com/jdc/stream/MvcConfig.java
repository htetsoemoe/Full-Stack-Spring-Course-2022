package com.jdc.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jdc.stream.listener.AsyncLifecycleListener;
import com.jdc.stream.listener.CallableResultLifecycle;
import com.jdc.stream.listener.DeferredResultLifecycle;

@Configuration
@EnableWebMvc
@ComponentScan("com.jdc.stream.controller")
public class MvcConfig implements WebMvcConfigurer{
	
	@Autowired
	private AsyncTaskExecutor executor;

	// first 3 configurations
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/views/", ".jsp");
	}
	
	// first 3 configurations
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
	}
	
	// first 3 configurations (optional in first 3)
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
	}
	
	
	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
		configurer.setTaskExecutor(executor);
		//configurer.setDefaultTimeout(3000L);
		configurer.registerCallableInterceptors(new CallableResultLifecycle());
		configurer.registerDeferredResultInterceptors(new DeferredResultLifecycle());
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AsyncLifecycleListener());
	}
	
}
