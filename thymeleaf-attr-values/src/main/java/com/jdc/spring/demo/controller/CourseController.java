package com.jdc.spring.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.spring.demo.model.entity.Course.Level;
import com.jdc.spring.demo.model.repo.CourseRepo;
import com.jdc.spring.demo.model.service.CourseService;

@Controller
@RequestMapping("course")
public class CourseController {
	
	@Autowired
	private CourseService service;
	
	@GetMapping
	public String search(
			@RequestParam Optional<Level> level,
			@RequestParam Optional<String> name,
			ModelMap map) {
		map.put("result", service.search(level, name));
		return "courses";
	}
	
	@GetMapping("edit")
	public String edit() {
		return "course-edit";
	}
	
	@PostMapping
	public String save() {
		return "redirect:/course";
	}
	
	@ModelAttribute("levels")
	public List<Level> level() {
		return List.of(Level.values());
	}

}