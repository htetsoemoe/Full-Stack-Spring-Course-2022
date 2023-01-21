package com.jdc.stream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.jdc.stream.service.DataProvider;

@Controller
@RequestMapping("sse")
public class SseResultController {
	
	@Autowired
	private DataProvider provider;
	
	@GetMapping
	public SseEmitter emitter() {
		var emitter = new SseEmitter();
		provider.stream(emitter);	// SseEmitter is a sub class of ResponseBodyEmitter
		return emitter;
	}

}
