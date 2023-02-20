package com.jdc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping
	public String home() {
		return "home";
	}
	
	@GetMapping("basic")
	public String basicData() {
		return "basic-data";
	}
	
	@GetMapping("collections")
	public String collections() {
		return "collections";
	}
	
	@GetMapping("dates")
	public String dates() {
		return "dates";
	}
	
	@GetMapping("others")
	public String otherUtilis() {
		return "others";
	}

}
