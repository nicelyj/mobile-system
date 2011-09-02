package com.song7749.mds.member.service;

import javax.servlet.http.HttpServletRequest;

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

	public static LoginManager checkAuth(HttpServletRequest httpServletRequest)
			throws Exception {
		LoginManager loginManager;

		CookieUtil cookieUtil = new CookieUtil(httpServletRequest);
		cookieUtil.getValue("authKey");
		return null;
	}
}
