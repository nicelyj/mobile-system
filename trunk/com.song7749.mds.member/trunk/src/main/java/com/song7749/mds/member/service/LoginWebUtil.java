package com.song7749.mds.member.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public static void login(Member member,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws IOException{
		LoginManager loginManager = new LoginManagerImpl();;
		CookieUtil cookieUtil = new CookieUtil(httpServletRequest);
		
		// 유효기간 내에 다시 로그인 시도를 했는가 검사
		if(cookieUtil.getValue("authKey") != null || cookieUtil.getValue("authKey").equals("")){
			MemberAuth memberAuth = new MemberAuth();
			memberAuth.setMemberAuthKey(cookieUtil.getValue("authKey"));
			if(loginManager.checkAuth(memberAuth) == true){
				httpServletResponse.sendRedirect(httpServletRequest.getParameter("returnUrl"));
			}			
		}
		
		MemberAuth memberAuth = new MemberAuth();
		memberAuth.setMember(member);
		// 로그인 성공시에 cookie 기록함.
		if(loginManager.login(memberAuth )){
			CookieUtil.createCookie("authKey", memberAuth.getMemberAuthKey(), "/", 1*60*60);
		}
	}
	
	public static void checkAuth(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse)
			throws Exception {
		LoginManager loginManager = new LoginManagerImpl();;
		CookieUtil cookieUtil = new CookieUtil(httpServletRequest);

		if(cookieUtil.getValue("authKey") == null || cookieUtil.getValue("authKey").equals("")){
			LoginWebUtil.redirectLoginForm(httpServletRequest,httpServletResponse);
		}else{
			MemberAuth memberAuth = new MemberAuth();
			memberAuth.setMemberAuthKey(cookieUtil.getValue("authKey"));
			if(loginManager.checkAuth(memberAuth) == false){
				LoginWebUtil.redirectLoginForm(httpServletRequest,httpServletResponse);
			}else{// 로그인 성공시에 쿠키값 갱신
				CookieUtil.createCookie("authKey", memberAuth.getMemberAuthKey(), "/", 1*60*60);	
			}
		}
	}
	
	public static void logOut(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws IOException{
		LoginManager loginManager = new LoginManagerImpl();;
		CookieUtil cookieUtil = new CookieUtil(httpServletRequest);

		if(cookieUtil.getValue("authKey") == null || cookieUtil.getValue("authKey").equals("")){
			httpServletResponse.sendRedirect(httpServletRequest.getParameter("returnUrl"));
		}else{
			MemberAuth memberAuth = new MemberAuth();
			memberAuth.setMemberAuthKey(cookieUtil.getValue("authKey"));
			if(loginManager.checkAuth(memberAuth) == true){
				loginManager.logout(memberAuth);
				CookieUtil.createCookie("authKey", "", "/", -1);
				httpServletResponse.sendRedirect(httpServletRequest.getParameter("returnUrl"));
			}
		}
	}
	
	public static void redirectLoginForm(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
		try {
			httpServletResponse.sendRedirect("/login/loginForm.html?returnUrl="+httpServletRequest.getParameter("returnUrl"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}