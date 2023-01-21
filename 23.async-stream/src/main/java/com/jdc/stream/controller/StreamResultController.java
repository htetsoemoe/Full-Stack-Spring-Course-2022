package com.jdc.stream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import com.jdc.stream.service.DataProvider;

@Controller
@RequestMapping("stream")
public class StreamResultController {
	
	@Autowired
	private AsyncTaskExecutor executor;
	
	@Autowired
	private DataProvider provider;
	
	@GetMapping
	@ResponseBody
	public ResponseBodyEmitter emitter() {
		var emitter = new ResponseBodyEmitter();
		
		provider.stream(emitter);

		
//	If you use executor
		
//		executor.execute(() -> {
//			try {
//				for (int i = 1; i <= 10; i++) {
//					Thread.sleep(1000);
//					emitter.send(String.valueOf(i));
//				}
//			} catch (InterruptedException | IOException e) {
//				e.printStackTrace();
//			} finally {
//				emitter.complete();
//			}
//		});
		
		return emitter;
	}
}
