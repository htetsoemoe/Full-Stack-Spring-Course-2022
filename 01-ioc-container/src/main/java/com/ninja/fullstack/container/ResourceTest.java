package com.ninja.fullstack.container;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class ResourceTest implements ResourceBean{

	@Override
	public String data() {
		return "Resource Test(Development) Data";
	}

}
