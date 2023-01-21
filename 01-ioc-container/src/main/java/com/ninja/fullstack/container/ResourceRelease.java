package com.ninja.fullstack.container;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("release")
public class ResourceRelease implements ResourceBean{

	@Override
	public String data() {
		return "Resource Release Data";
	}

}
