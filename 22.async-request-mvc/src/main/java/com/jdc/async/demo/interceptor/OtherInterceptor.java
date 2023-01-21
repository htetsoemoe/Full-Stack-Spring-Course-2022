package com.jdc.async.demo.interceptor;

public class OtherInterceptor implements ActionInterceptor{
	
	@Override
	public void preProcess(Action action) {
		System.out.println("Pre process from OtherInterceptor.");
	}
	
	@Override
	public void postProcess() {
		System.out.println("Post process from OtherInterceptor.");
	}
	
	@Override
	public void onFinish() {
		System.out.println("OnFinish from OtherInterceptor.");
	}

}
