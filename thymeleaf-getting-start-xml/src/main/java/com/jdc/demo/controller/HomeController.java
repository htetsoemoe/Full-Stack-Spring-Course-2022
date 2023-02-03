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
	public String home(ModelMap model) {
		
		model.put("title", "Hello Thymeleaf View with XML Configuration");
		
		model.put("list", List.of("Java Basic", "Spring Framework", "Spring Data JPA", "React"));
		
		return "home";
	}
}
