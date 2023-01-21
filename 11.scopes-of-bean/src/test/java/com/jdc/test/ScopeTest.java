package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.config.SingletonConfig;
import com.jdc.scope.CounterClient;

public class ScopeTest {
	
	@Test
	void test() {
		try(var context = new AnnotationConfigApplicationContext()) {
			context.register(SingletonConfig.class);
			context.refresh();
			
			var bean1 = context.getBean(CounterClient.class);
			var bean2 = context.getBean(CounterClient.class);
			var bean3 = context.getBean(CounterClient.class);
			
			for(int i=0; i<3; i++) {
				bean1.countUp();
				bean2.countUp();
				bean3.countUp();
			}
		}
	}

}
