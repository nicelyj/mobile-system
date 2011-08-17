package com.song7749.web.monitoring.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.HttpRequestHandlerServlet;



@Controller
public class MainController {
	@RequestMapping("/index.html")
	public String mainIndex(HttpServletRequest request,
			HttpServletResponse response,
			ModelMap modelMap) {
		
		String viewTemplete = "main/index";
		
		
		return viewTemplete;
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String hello(@RequestParam String name) {
		return "Hello " + name;
	}
}
