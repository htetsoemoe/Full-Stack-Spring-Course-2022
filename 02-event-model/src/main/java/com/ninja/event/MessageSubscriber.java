package com.ninja.event;

//import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MessageSubscriber {
	
//	@EventListener(PayloadApplicationEvent.class)
//	public void onEvent(PayloadApplicationEvent<Message> event) {
//		System.out.println(event.getPayload().getName());
//	}
	
	@EventListener(Message.class)
	public void onEvent(Message event) {
		System.out.println(event.getName());
	}
}
