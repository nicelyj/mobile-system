package com.song7749.web.monitoring.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import com.song7749.mds.member.model.Member;
import com.song7749.mds.member.service.LoginWebUtil;

public class BaseController {
	@Autowired
	protected LoginWebUtil loginWebUtil; 
	
	protected void checkAuth(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,ModelMap modelMap){
		try {
			this.loginWebUtil.checkAuth(httpServletRequest, httpServletResponse);
			Member member = this.loginWebUtil.getAuth(httpServletRequest, httpServletResponse);
			modelMap.addAttribute("loginMember", member);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
}
