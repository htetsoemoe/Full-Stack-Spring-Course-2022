package com.ninja.event.service;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

	@EventListener(User.class)
	public void send(User user) {
		System.out.printf("The comfirmation email has been sent to %s.%n", user.getEmail());
	}

}
