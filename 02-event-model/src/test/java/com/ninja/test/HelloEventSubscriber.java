package com.ninja.test;

import org.junit.jupiter.api.Test;
//import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ninja.event.Message;
import com.ninja.event.service.User;
import com.ninja.event.service.UserRegistrationService;

public class HelloEventSubscriber {
	
	public static String CONFIG = "com.ninja.event";
	
	@Test
	void test() {
		try(var context = new AnnotationConfigApplicationContext()) {
			context.scan(CONFIG);
			context.refresh();
			context.start();
			context.stop();
			
			//var event = new PayloadApplicationEvent<Message>(context, message);
			//context.publishEvent(event);
			
			var message = new Message("Custom Payload Data");
			context.publishEvent(message);
			
			
			User thaw = new User();
			thaw.setName("Thaw Thaw");
			thaw.setEmail("thawthaw@gmail.com");
			
			var registrationService = context.getBean(UserRegistrationService.class);
			registrationService.register(thaw);
		}
	}

}
