package com.jdc.scope.controller;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jdc.scope.model.Counter;

@Controller
public class HomeController {
	
	@Autowired
	public Counter requestCounter;
	
	@Autowired
	public Counter sessionCounter;
	
	@Autowired
	public Counter applicationCounter;
	
	@Autowired
	public ServletContext servletContext;
	
	@PostConstruct
	public void init() {
		servletContext.setAttribute("counter", new Counter());
	}
	
	@GetMapping("/")
	public String index(ModelMap model, 
			@RequestAttribute("counter") Counter reqCounter, 
			@SessionAttribute("counter") Counter sesCounter) {
		model.addAttribute("request", requestCounter.countUp());
		model.addAttribute("session", sessionCounter.countUp());
		model.addAttribute("application", applicationCounter.countUp());
		
		var appCounter = (Counter) servletContext.getAttribute("counter");
		
		appCounter.countUp();
		sesCounter.countUp();
		reqCounter.countUp();
		
		return "home";
	}
	
	@ModelAttribute
	void loadScopeObject(HttpServletRequest request) {
		request.setAttribute("counter", new Counter());
		
		var session = request.getSession();
		if (session.getAttribute("counter") == null) {
			session.setAttribute("counter", new Counter());
		}
	}

}
