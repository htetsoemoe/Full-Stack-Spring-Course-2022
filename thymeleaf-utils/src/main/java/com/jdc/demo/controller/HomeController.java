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
	
	@GetMapping("objects")
	public String object(ModelMap map) {
		map.put("nullValue", null);
		map.put("notNullValue", "This is not null");
		return "object";
	}
	
	@GetMapping("bools")
	public String bools() {
		return "bools";
	}
	
	@GetMapping("numbers")
	public String numbers() {
		return "numbers";
	}
	
	@GetMapping("strings")
	public String strings(ModelMap model) {
		model.put("escapeXML", "<hello />");
		model.put("escapeString", "\"Hello\' \t \r \\ Java");
		return "strings";
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
