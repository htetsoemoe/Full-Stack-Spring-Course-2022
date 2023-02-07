package com.jdc.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.demo.dto.Account;
import com.jdc.demo.dto.Contact;
import com.jdc.demo.dto.Course;

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
	
	@GetMapping("literals")
	public String literals(ModelMap map) {
		map.put("message", "This is literal values.");
		
		return "literals";
	}
	
	@GetMapping("objects")
	public String objects(ModelMap map) {
		map.put("account", new Account(1, "Thaw Thaw", new Contact("099412088264", "thaw@gmail.com")));
		
		return "objects";
	}
	
	@GetMapping("records")
	public String records(ModelMap map) {
		map.put("course", new Course(1,"Java Basic", 4, "Basic", "Basic Course for Java"));
		return "records";
	}
}
