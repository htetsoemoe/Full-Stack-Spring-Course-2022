package com.ninja.event;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class FrameworkLifecycleListener{

	@EventListener(ContextRefreshedEvent.class)
	public void onRefresh(ContextRefreshedEvent event) {
		var date = new Date(event.getTimestamp());
		var dateString = new SimpleDateFormat("yyyy/MM/dd HH:mm ss SSS").format(date);
		
		System.out.println("IoC Container refreshed at %s.".formatted(dateString));
	}
	
	@EventListener(ContextClosedEvent.class)
	public void onClosed(ContextClosedEvent event) {
		var date = new Date(event.getTimestamp());
		var dateString = new SimpleDateFormat("yyyy/MM/dd HH:mm ss SSS").format(date);
		
		System.out.println("IoC Container closed at %s.".formatted(dateString));
	}
	
	@EventListener(ContextStartedEvent.class)
	public void onStarted(ContextStartedEvent event) {
		var date = new Date(event.getTimestamp());
		var dateString = new SimpleDateFormat("yyyy/MM/dd HH:mm ss SSS").format(date);
		
		System.out.println("IoC Container started at %s.".formatted(dateString));
	}
	
	@EventListener(ContextStoppedEvent.class)
	public void onStopped(ContextStoppedEvent event) {
		var date = new Date(event.getTimestamp());
		var dateString = new SimpleDateFormat("yyyy/MM/dd HH:mm ss SSS").format(date);
		
		System.out.println("IoC Container stopped at %s.".formatted(dateString));
	}

}
