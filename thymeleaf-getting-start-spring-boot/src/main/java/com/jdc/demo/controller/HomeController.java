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
				"React JavaScript Library"
				));
		return "home";
	}
	
	@GetMapping("html5")
	public String html5(ModelMap map) {
		map.put("message", "Thymeleaf View with Spring Boot");
		map.put("list", List.of(
				"Java Basic",
				"Spring Framework",
				"Spring Data JPA",
				"React JavaScript Library"
				));
		
		return "html-attr";
	}
}
