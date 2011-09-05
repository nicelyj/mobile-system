package com.song7749.web.monitoring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	public MainController() {

	}

	@RequestMapping("/index.html")
	public String mainIndexAnonymousHandle(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {

		String viewTemplete = "main/index";
		return viewTemplete;
	}
}
