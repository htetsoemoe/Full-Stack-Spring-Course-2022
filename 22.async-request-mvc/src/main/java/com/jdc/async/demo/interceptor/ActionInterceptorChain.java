package com.jdc.async.demo.interceptor;

import java.util.Arrays;
import java.util.List;

public class ActionInterceptorChain implements ActionInterceptor{
	
	private List<ActionInterceptor> chain;
	
	public ActionInterceptorChain(ActionInterceptor[] interceptors) {
		chain = Arrays.stream(interceptors).toList();
	}
	
	@Override
	public void preProcess(Action action) {
		for(var interceptor : chain) {
			interceptor.preProcess(action);
		}
	}
	
	@Override
	public void postProcess() {
		for(var interceptor : chain) {
			interceptor.postProcess();
		}
	}
	
	@Override
	public void onError() {
		for(var intercepter : chain) {
			intercepter.onError();
		}
	}
	
	@Override
	public void onFinish() {
		for(var intercepter : chain) {
			intercepter.onFinish();
		}
	}

}
