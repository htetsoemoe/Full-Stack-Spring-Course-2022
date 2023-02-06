package com.jdc.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping
	public String home(ModelMap map) {
		map.put("message", "Thymeleaf View with Spring Boot");
		map.put("list", List.of(
				"Java Basic",
				"Spring Framework",
				"Spring Data JPA",
				"Thymeleaf Template Engine"
				));
		return "home";
	}
	
	@GetMapping("html5")
	public String html5(ModelMap map) {
		map.put("message", "React with Spring Boot");
		map.put("list", List.of(
				"JavaScript Basic",
				"ES6 Features",
				"Asychronous Programming",
				"React JavaScript Library"
				));
		
		return "html-attr";
	}
	
	@GetMapping("out-text")
	public String outputText(ModelMap map) {
		map.put("message", "<b>This is a output message.</b>");	
		return "outputs";
	}
}
