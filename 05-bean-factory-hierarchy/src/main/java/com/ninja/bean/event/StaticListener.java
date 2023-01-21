package com.ninja.bean.event;

import org.springframework.context.ApplicationListener;

public class StaticListener implements ApplicationListener<MyAppEvent>{

	@Override
	public void onApplicationEvent(MyAppEvent event) {
		System.out.println("Static Listener : MyAppEvent");
		System.out.println(event.getMessage());
	}

}
