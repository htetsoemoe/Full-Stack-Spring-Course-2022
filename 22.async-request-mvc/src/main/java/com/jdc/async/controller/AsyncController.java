package com.jdc.async.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;

import com.jdc.async.controller.task.CallableTask;
import com.jdc.async.controller.task.DeferredTask;
import com.jdc.async.service.MyDelayService;

@Controller
@RequestMapping("async")
public class AsyncController {
	
	@Autowired
	private MyDelayService service;
	
	@GetMapping("callable")
	public Callable<ModelAndView> index() {
		return new CallableTask();
		
//		return new Callable<String>() {
//
//			@Override
//			public String call() throws Exception {
//				model.put("message", "Hello from Callable Result");
//				Thread.sleep(500);
//				System.out.println("In Callable Process");
//				return "async-result";
//			}
//			
//		};
	}
	
	@GetMapping("deferred")
	public DeferredResult<ModelAndView> deferredExecution() {
		var result = new DeferredTask(1500L);
		
		// listener
//		result.onTimeout(() -> {
//			var mv = new ModelAndView("error-result");
//			mv.getModel().put("message", "DeferredResult Execution is Timeout.");
//			result.setResult(mv);
//		});
		
		result.onCompletion(() -> {
			System.out.println("Request has been completed.");
		});
		
		result.onError(e -> {
			e.printStackTrace();
		});
		
		service.execute(result);
		
		return result;
	}
	
	@ExceptionHandler({
		RuntimeException.class,
		IllegalStateException.class
	})
	ModelAndView handle(Exception e) {
		ModelAndView mv = new ModelAndView("error-result");
		mv.getModel().put("message", e.getMessage());
		return mv;
	}

}
