package com.song7749.web.monitoring.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.song7749.base.HttpResultCode;
import com.song7749.exception.WebException;
import com.song7749.mds.member.model.Member;
import com.song7749.mds.member.service.LoginWebUtil;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginWebUtil loginWebUtil;

	@RequestMapping("/loginForm.html")
	public String loginFormAnonymousHandle(
			@RequestParam(value = "returnUrl", defaultValue = "/", required = false) String returnUrl,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {

		String ViewTemplete = "login/loginForm";

		modelMap.addAttribute("returnUrl", returnUrl);
		modelMap.addAttribute("javascript",
				"<script type=\"text/javascript\" src=\"/js/login/login.js\"></script>");

		return ViewTemplete;
	}

	@RequestMapping("/logOut.html")
	public void logOutGeneralMemberHandle(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			this.loginWebUtil.logOut(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/loginProcess.html")
	public void loginProcessAnonymousHandle(
			@RequestParam(value = "memberId", defaultValue = "", required = true) String memberId,
			@RequestParam(value = "memberPassword", defaultValue = "", required = true) String memberPassword,
			HttpServletRequest request, HttpServletResponse response) {

		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPassword(memberPassword);
		try {
			if (memberId.equals("") || memberPassword.equals("")) {
				throw new WebException(request, response,
						HttpResultCode.BAD_REQUEST, "아이디 혹은 패스워드가 일치하지 않습니다.");

			} else if (this.loginWebUtil.login(member, request, response) == false) {
				throw new WebException(request, response,
						HttpResultCode.BAD_REQUEST, "아이디 혹은 패스워드가 일치하지 않습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}