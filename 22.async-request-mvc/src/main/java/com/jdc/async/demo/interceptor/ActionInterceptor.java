package com.jdc.async.demo.interceptor;

public interface ActionInterceptor {
	
	default void preProcess(Action action) {}
	
	default void postProcess() {}
	
	default void onFinish() {}
	
	default void onError() {}

}
