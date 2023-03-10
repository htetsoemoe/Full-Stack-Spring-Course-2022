package com.jdc.demo.controllers;

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
		model.put("message", "Hello Thymeleaf with Java Based Configuration");
		model.put("list", List.of(
				"Java Basic",
				"Spring Framework",
				"Spring Data JPA",
				"React JavaScript Library"
				));
		
		return "home";
	}

}
