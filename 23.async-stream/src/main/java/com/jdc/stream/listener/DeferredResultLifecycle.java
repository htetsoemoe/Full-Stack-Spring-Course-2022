package com.jdc.stream.listener;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.DeferredResultProcessingInterceptor;

public class DeferredResultLifecycle implements DeferredResultProcessingInterceptor{
	
	@Override
	public <T> void beforeConcurrentHandling(NativeWebRequest request, DeferredResult<T> deferredResult)
			throws Exception {
		System.out.println("""
				===========> DeferredResultProcessingInterceptor Before Concurrent Handling Started
				""");
	}
	
	@Override
	public <T> boolean handleTimeout(NativeWebRequest request, DeferredResult<T> deferredResult) throws Exception {
		System.out.println("""
				===========> DeferredResult Handle Timeout
				""");
		return true;
	}

}
