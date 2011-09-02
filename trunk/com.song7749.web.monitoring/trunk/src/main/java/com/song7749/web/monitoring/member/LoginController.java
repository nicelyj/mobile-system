package com.song7749.web.monitoring.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.glassfish.api.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping("/loginForm.html")
	public String loginForm(
			@RequestParam(value="returnUrl",defaultValue="/",required=false) String returnUrl,
			HttpServletRequest request,
			HttpServletResponse httpResponse, ModelMap modelMap) {
			
		String ViewTemplete = "login/loginForm";

		modelMap.addAttribute(
				"javascript","<script type=\"text/javascript\" src=\"/js/login/login.js\"></script>");
		
		return ViewTemplete;
	}
	
	public void logOut(	HttpServletRequest request,
			HttpServletResponse httpResponse) {
		
	}
	
	@RequestMapping("/loginProcess.html")
	public void loginProcess(
			@RequestParam(value="memberId",defaultValue="",required=true) String memberId,
			@RequestParam(value="memberPassword",defaultValue="",required=true) String memberPassword,
			HttpServletRequest request,
			HttpServletResponse httpResponse) {
	}
}
