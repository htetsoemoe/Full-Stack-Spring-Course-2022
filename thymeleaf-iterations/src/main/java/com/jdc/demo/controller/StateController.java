package com.jdc.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.context.LazyContextVariable;

import com.jdc.demo.model.entity.State;
import com.jdc.demo.model.service.StateService;

@Controller
@RequestMapping("states")
public class StateController {
	
	@Autowired
	private StateService service;
	
	@GetMapping
	public String index(ModelMap map) {
		map.put("size", service.getAllCount());
		
		// using LazyContextVariable for Thymeleaf
		map.put("list", new LazyContextVariable<List<State>>() {

			@Override
			protected List<State> loadValue() {
				return service.findAll();
			}
		});
		return "states";
	}
	
	@PostMapping
	public String upload(@RequestParam MultipartFile file) { // this multipart file 'name' must equal to input's name 
		service.upload(file);		
		return "redirect:/states";
	}
	/**
	 * •In Spring MVC, "request parameters" map to query parameters, form data,and parts in multipart requests. 
	 * This is because the Servlet API combines query parameters and form data into a single map called "parameters", 
	 * and that includes automatic parsing of the request body. 
	 */
}
