package com.jdc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@Autowired
	private ProductService service;

	@GetMapping("/")
	public String home(ModelMap map) {
		map.put("products", service.findAll());
		return "home";
	}
	
	@GetMapping("/page1")
	public String page1() {
		return "view-one";
	}
	
	@GetMapping("/page2")
	public String page2() {
		return "view-two";
	}
}
