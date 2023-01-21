package com.ninja.event.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationService {
	
	@Autowired
	ApplicationEventPublisher publisher;// IoC container (ApplicationContext) IS-A ApplicationEventPublisher
	
	public void register(User user) {
		System.out.println("Registration for %s is done!".formatted(user.getName()));
		publisher.publishEvent(user);
	}

}
