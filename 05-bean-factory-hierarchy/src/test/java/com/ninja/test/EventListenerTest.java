package com.ninja.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ninja.bean.event.MyAppEvent;
import com.ninja.bean.event.MyEvent;
import com.ninja.bean.event.StaticListener;

public class EventListenerTest {

	@Test
	void test() {
		try(var context = new AnnotationConfigApplicationContext()) {
			context.addApplicationListener(new StaticListener());
			context.scan("com.ninja.bean.event");
			context.refresh();
			
			context.publishEvent(new MyAppEvent(context, "Publishing Application Event."));
			context.publishEvent(new MyEvent("Hello from Custom MyEvent Object"));
		}
	}
}
