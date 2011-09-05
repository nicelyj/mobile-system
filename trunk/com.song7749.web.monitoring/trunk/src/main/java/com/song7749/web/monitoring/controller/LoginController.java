package com.song7749.web.monitoring.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.song7749.mds.member.model.Member;
import com.song7749.mds.member.service.LoginWebUtil;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginWebUtil loginWebUtil; 
	
	@RequestMapping("/loginForm.html")
	public String loginForm(
			@RequestParam(value="returnUrl",defaultValue="/",required=false) String returnUrl,
			HttpServletRequest request,
			HttpServletResponse httpResponse, ModelMap modelMap) {
			
		String ViewTemplete = "login/loginForm";

		modelMap.addAttribute("returnUrl", returnUrl);
		modelMap.addAttribute(
				"javascript","<script type=\"text/javascript\" src=\"/js/login/login.js\"></script>");
		
		return ViewTemplete;
	}
	
	@RequestMapping("/logOut.html")
	public void logOut(	HttpServletRequest request,
			HttpServletResponse httpResponse) {
		try {
			this.loginWebUtil.logOut(request, httpResponse);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/loginProcess.html")
	public void loginProcess(
			@RequestParam(value="memberId",defaultValue="",required=true) String memberId,
			@RequestParam(value="memberPassword",defaultValue="",required=true) String memberPassword,
			HttpServletRequest request,
			HttpServletResponse httpResponse) {
		
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPassword(memberPassword);
		try {
			this.loginWebUtil.login(member, request, httpResponse);
		} catch (Exception e) {
			// 아이디 패스워드 틀리다는 에러 페이지 보여줘야 함.
			e.printStackTrace();
		}
	}
}
