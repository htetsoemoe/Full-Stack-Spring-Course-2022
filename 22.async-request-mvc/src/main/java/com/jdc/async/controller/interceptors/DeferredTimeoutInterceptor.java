package com.jdc.async.controller.interceptors;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.DeferredResultProcessingInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class DeferredTimeoutInterceptor implements DeferredResultProcessingInterceptor{
	
	@Override
	public <T> boolean handleTimeout(NativeWebRequest request, DeferredResult<T> deferredResult) throws Exception {
		System.out.println("""
				=========>	Handle Timeout : DeferredTimeoutInterceptor
				""");
		ModelAndView mv = new ModelAndView("error-result");
		mv.getModel().put("message", "Handle Timeout from DeferredTimeoutInterceptor");
		deferredResult.setErrorResult(mv);
		return false;
	}
}
