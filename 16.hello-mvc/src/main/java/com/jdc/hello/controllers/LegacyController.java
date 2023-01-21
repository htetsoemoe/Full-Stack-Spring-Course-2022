package com.jdc.hello.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LegacyController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		var modelView = new ModelAndView("old-style");
		modelView.getModel().put("message", "Hello from Legacy Controller!");
		return modelView;
	}

}
