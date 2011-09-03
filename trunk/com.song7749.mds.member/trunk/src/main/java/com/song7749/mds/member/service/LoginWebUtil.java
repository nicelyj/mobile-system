package com.song7749.mds.member.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.song7749.mds.member.model.Member;
import com.song7749.mds.member.model.MemberAuth;
import com.song7749.web.util.CookieUtil;

/**
 * <pre>
 * Class Name : LoginWebUtil.java
 * Description : 쿠키값을 이용해서 로그인 여부 확인
 * 
 *  Modification Information
 *  Modify Date 	Modifier			Comment
 * -----------------------------------------------
 *  2011. 9. 2.		song7749			신규 생성
 * 
 * </pre>
 * 
 * @author song7749
 * @since 2011. 9. 2.
 */

public class LoginWebUtil {
	@Autowired
	private LoginManager loginManager;

	public void login(Member member,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws Exception{
		CookieUtil cookieUtil = new CookieUtil(httpServletRequest);
		
		// 유효기간 내에 다시 로그인 시도를 했는가 검사
		if(cookieUtil.getValue("authKey") != null){
			MemberAuth memberAuth = new MemberAuth();
			memberAuth.setMemberAuthKey(cookieUtil.getValue("authKey"));
			if(this.loginManager.checkAuth(memberAuth) == true){
				httpServletResponse.sendRedirect(httpServletRequest.getParameter("returnUrl"));
			}			
		}
		
		MemberAuth memberAuth = new MemberAuth();
		memberAuth.setMember(member);
		// 로그인 성공시에 cookie 기록함.
		try {
			if(this.loginManager.login(memberAuth )){
				httpServletResponse.addCookie(CookieUtil.createCookie("authKey", memberAuth.getMemberAuthKey(), "/", 1*60*60));	
				System.out.println();
				httpServletResponse.sendRedirect(httpServletRequest.getParameter("returnUrl"));
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void checkAuth(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse)
			throws Exception {
		CookieUtil cookieUtil = new CookieUtil(httpServletRequest);
		
		if(cookieUtil.getValue("authKey") == null){
			this.redirectLoginForm(httpServletRequest,httpServletResponse);
		}else{
			MemberAuth memberAuth = new MemberAuth();
			memberAuth.setMemberAuthKey(cookieUtil.getValue("authKey"));
			if(this.loginManager.checkAuth(memberAuth) == false){
				this.redirectLoginForm(httpServletRequest,httpServletResponse);
			}else{// 로그인 성공시에 쿠키값 갱신
				httpServletResponse.addCookie(CookieUtil.createCookie("authKey", memberAuth.getMemberAuthKey(), "/", 1*60*60));	
			}
		}
	}
	
	public Member getAuth(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws IOException{
		CookieUtil cookieUtil = new CookieUtil(httpServletRequest);
		
		if(cookieUtil.getValue("authKey") == null){
			this.redirectLoginForm(httpServletRequest,httpServletResponse);
			return null;
		}else{
			MemberAuth memberAuth = new MemberAuth();
			memberAuth.setMemberAuthKey(cookieUtil.getValue("authKey"));
			return this.loginManager.getAuth(memberAuth);
		}
	}
	
	public void logOut(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws IOException{
		CookieUtil cookieUtil = new CookieUtil(httpServletRequest);

		if(cookieUtil.getValue("authKey") == null){
			httpServletResponse.sendRedirect(httpServletRequest.getParameter("returnUrl"));
		}else{
			MemberAuth memberAuth = new MemberAuth();
			memberAuth.setMemberAuthKey(cookieUtil.getValue("authKey"));
			if(this.loginManager.checkAuth(memberAuth) == true){
				this.loginManager.logout(memberAuth);
				httpServletResponse.addCookie(CookieUtil.createCookie("authKey", "", "/", -1));
				if(httpServletRequest.getParameter("returnUrl") == null)
					httpServletResponse.sendRedirect("/");
				else
					httpServletResponse.sendRedirect(httpServletRequest.getParameter("returnUrl"));
			}
		}
	}
	
	public void redirectLoginForm(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
		try {
			if(httpServletRequest.getParameter("returnUrl") == null){
				httpServletResponse.sendRedirect("/login/loginForm.html?returnUrl=/");
			}
			else{
				httpServletResponse.sendRedirect("/login/loginForm.html?returnUrl="+httpServletRequest.getParameter("returnUrl"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}