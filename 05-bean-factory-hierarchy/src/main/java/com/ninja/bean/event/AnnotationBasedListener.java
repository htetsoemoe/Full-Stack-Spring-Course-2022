package com.ninja.bean.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AnnotationBasedListener {
	
	@EventListener(classes = MyEvent.class) // custom event object
	public void handle(MyEvent event) {
		System.out.println("MyEvent Event Handler : MyEvent");
		System.out.println(event.getMessage());
	}
}
