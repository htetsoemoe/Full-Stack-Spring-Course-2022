package com.ninja.bean.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class BeanListener implements ApplicationListener<MyAppEvent>{

	@Override
	public void onApplicationEvent(MyAppEvent event) {
		System.out.println("Bean Listener : MyAppEvent");
		System.out.println(event.getMessage());
	}

}
