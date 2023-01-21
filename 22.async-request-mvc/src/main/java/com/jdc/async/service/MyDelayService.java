package com.jdc.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.jdc.async.controller.task.DeferredTask;

@Service
public class MyDelayService {

	@Async("rootAppExecutor")
	public void execute(DeferredTask task) {
		var mv = new ModelAndView("async-result");

		if (StringUtils.hasLength(task.getError())) {
			task.setErrorResult(new RuntimeException(task.getError()));
		}

		try {
			Thread.sleep(2000L);
			mv.getModel().put("message", "Message Async Service for DeferredReuslt.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		task.setResult(mv);
	}
}
