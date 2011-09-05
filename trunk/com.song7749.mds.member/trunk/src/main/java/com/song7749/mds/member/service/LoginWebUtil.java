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
 * Description : ��Ű���� �̿��ؼ� �α��� ���� Ȯ��
 * 
 *  Modification Information
 *  Modify Date 	Modifier			Comment
 * -----------------------------------------------
 *  2011. 9. 2.		song7749			�ű� ����
 * 
 * </pre>
 * 
 * @author song7749
 * @since 2011. 9. 2.
 */

public class LoginWebUtil {
	@Autowired
	private LoginManager loginManager;

	public Boolean login(Member member, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		CookieUtil cookieUtil = new CookieUtil(httpServletRequest);

		// ��ȿ�Ⱓ ���� �ٽ� �α��� �õ��� �ߴ°� �˻�
		if (cookieUtil.getValue("authKey") != null) {
			MemberAuth memberAuth = new MemberAuth();
			memberAuth.setMemberAuthKey(cookieUtil.getValue("authKey"));
			if (this.loginManager.checkAuth(memberAuth) == true) {
				String url = null;
				if (httpServletRequest.getParameter("returnUrl") == null)
					url = "/";
				else
					url = httpServletRequest.getParameter("returnUrl");
				httpServletResponse.sendRedirect(url);
				return true;
			}
		}

		MemberAuth memberAuth = new MemberAuth();
		memberAuth.setMember(member);
		// �α��� �����ÿ� cookie �����.
		try {
			if (this.loginManager.login(memberAuth)) {
				httpServletResponse.addCookie(CookieUtil.createCookie(
						"authKey", memberAuth.getMemberAuthKey(), "/",
						1 * 60 * 60));
				String url = null;
				if (httpServletRequest.getParameter("returnUrl") == null)
					url = "/";
				else
					url = httpServletRequest.getParameter("returnUrl");

				httpServletResponse.sendRedirect(url);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public Boolean checkAuth(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		Boolean chekLogin = false;
		CookieUtil cookieUtil = new CookieUtil(httpServletRequest);

		if (cookieUtil.getValue("authKey") == null) {
			return false;
		} else {
			MemberAuth memberAuth = new MemberAuth();
			memberAuth.setMemberAuthKey(cookieUtil.getValue("authKey"));
			if (this.loginManager.checkAuth(memberAuth) == false) {
				return false;
			} else {// �α��� �����ÿ� ��Ű�� ����
				httpServletResponse.addCookie(CookieUtil.createCookie(
						"authKey", memberAuth.getMemberAuthKey(), "/",
						1 * 60 * 60));
				chekLogin = true;
			}
		}
		return chekLogin;
	}

	public Member getAuth(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		CookieUtil cookieUtil = new CookieUtil(httpServletRequest);

		if (cookieUtil.getValue("authKey") == null) {
			return null;
		} else {
			MemberAuth memberAuth = new MemberAuth();
			memberAuth.setMemberAuthKey(cookieUtil.getValue("authKey"));
			return this.loginManager.getAuth(memberAuth);
		}
	}

	public void logOut(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		CookieUtil cookieUtil = new CookieUtil(httpServletRequest);

		if (cookieUtil.getValue("authKey") == null) {
			httpServletResponse.sendRedirect(httpServletRequest
					.getParameter("returnUrl"));
		} else {
			MemberAuth memberAuth = new MemberAuth();
			memberAuth.setMemberAuthKey(cookieUtil.getValue("authKey"));

			if (this.loginManager.checkAuth(memberAuth) == true) {
				this.loginManager.logout(memberAuth);
				httpServletResponse.addCookie(CookieUtil.createCookie(
						"authKey", "", "/", -1));
				String url = null;
				if (httpServletRequest.getParameter("returnUrl") == null)
					url = "/";
				else
					url = httpServletRequest.getParameter("returnUrl");

				httpServletResponse.sendRedirect(url);
			}
		}
	}
}