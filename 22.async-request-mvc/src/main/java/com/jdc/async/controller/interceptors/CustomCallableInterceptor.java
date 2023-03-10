package com.jdc.async.controller.interceptors;

import java.util.concurrent.Callable;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.CallableProcessingInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jdc.async.controller.task.CallableTask;

public class CustomCallableInterceptor implements CallableProcessingInterceptor{
	
	@Override
	public <T> void beforeConcurrentHandling(NativeWebRequest request, Callable<T> task) throws Exception {
		System.out.println("====================================");
		System.out.println("=====beforeConcurrentHandling=======");
		System.out.println("====================================");
		
		if (task instanceof CallableTask custom) {
			custom.setMessages("Message from Before Concurrent Handling.");
		}
	}
	
	@Override
	public <T> void preProcess(NativeWebRequest request, Callable<T> task) throws Exception {
		System.out.println("====================================");
		System.out.println("=====preProcess=======");
		System.out.println("====================================");
		
		if (task instanceof CallableTask custom) {
			custom.setMessages("Message from Pre Process.");
			custom.setError(request.getParameter("error"));
		}
	}
	
	@Override
	public <T> void postProcess(NativeWebRequest request, Callable<T> task, Object concurrentResult) throws Exception {
		System.out.println("====================================");
		System.out.println("=====postProcess=======");
		System.out.println("====================================");
		
		if (task instanceof CallableTask custom) {
			custom.setMessages("Message from Post Process.");
		}
	}
	
	@Override
	public <T> Object handleError(NativeWebRequest request, Callable<T> task, Throwable t) throws Exception {
		System.out.println("====================================");
		System.out.println("=====handleError=======");
		System.out.println("====================================");
		return RESULT_NONE;
	}
	
	@Override
	public <T> void afterCompletion(NativeWebRequest request, Callable<T> task) throws Exception {
		System.out.println("====================================");
		System.out.println("=====afterCompletion=======");
		System.out.println("====================================");
		
		if (task instanceof CallableTask custom) {
			custom.setMessages("Message from After Completion.");
		}
	}
	
	@Override
	public <T> Object handleTimeout(NativeWebRequest request, Callable<T> task) throws Exception {
		System.out.println("====================================");
		System.out.println("=====handleTimeout=======");
		System.out.println("====================================");
		
		var mv = new ModelAndView("async-result");
		mv.getModel().put("message", "Timeout in Handle Timeout Intercepter.");
		
		if (task instanceof CallableTask custom) {
			custom.setMessages("Message from Handle Timeout Intercepter.");
			mv.getModel().put("interceptersMessage", custom.getMessages());
		}
		
		return mv;
	}

}
