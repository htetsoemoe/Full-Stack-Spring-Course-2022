package com.jdc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	public String basicData(ModelMap map) {
		map.put("nullValue", null);
		map.put("notNullValue", "This is not null");
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
