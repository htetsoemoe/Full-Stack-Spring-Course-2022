package com.jdc.stream.listener;

import java.util.concurrent.Callable;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.CallableProcessingInterceptor;

public class CallableResultLifecycle implements CallableProcessingInterceptor{
	
	@Override
	public <T> void beforeConcurrentHandling(NativeWebRequest request, Callable<T> task) throws Exception {
		System.out.println("""
				===========> CallableProcessingInterceptor Before Concurrent Handling Started
				""");
	}

}
