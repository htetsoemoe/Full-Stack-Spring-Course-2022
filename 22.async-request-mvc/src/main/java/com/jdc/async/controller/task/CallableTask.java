package com.jdc.async.controller.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import org.springframework.web.servlet.ModelAndView;

public class CallableTask implements Callable<ModelAndView>{
	
	private List<String> messages;
	
	private String error;
	
	public void setError(String error) {
		this.error = error;
	}
	
	public CallableTask() {
		messages = Collections.synchronizedList(new ArrayList<String>()); // for thread save purpose, we use Collections.synchronizedList
	}
	
	public void setMessages(String message) {
		this.messages.add(message);
	}

	public List<String> getMessages() {
		return messages;
	}
	
	@Override
	public ModelAndView call() throws Exception {
		var mv = new ModelAndView("async-result");
		
		if (null != error) {
			throw new IllegalStateException(error);
		}
		
		Thread.sleep(1500);
		mv.getModel().put("message", "Callable Process is Successful.");
		mv.getModel().put("interceptersMessage", messages);
		return mv;
	}

}
