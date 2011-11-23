package com.song7749.web.monitoring.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.song7749.mds.member.model.Member;
import com.song7749.mds.member.service.LoginWebUtil;

/**
 * <pre>
 * Class Name : MonitoringLoginAdvice.java
 * Description : 로그인 체크를 위한 advice
 * 
 *  Modification Information
 *  Modify Date 	Modifier			Comment
 * -----------------------------------------------
 *  2011. 9. 5.		song7749		    신규 생성
 * 
 * </pre>
 * 
 * @author song7749
 * @since 2011. 9. 5.
 */
@Aspect
@Component
public class MonitoringLoginAdvice {
	private Logger logger = Logger.getLogger(getClass());
	@Autowired
	protected LoginWebUtil loginWebUtil;

	@Around("execution(public * com.song7749.web.monitoring.controller.*Controller.*AnonymousHandle(..))")
	public Object checkAnonymousHandle(ProceedingJoinPoint joinPoint)
			throws Throwable {
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		Model model = null;

		for (Object obj : joinPoint.getArgs()) {
			if (obj instanceof HttpServletRequest) {
				request = (HttpServletRequest) obj;
			} else if (obj instanceof HttpServletResponse) {
				response = (HttpServletResponse) obj;
			} else if (obj instanceof Model) {
				model = (Model) obj;
			}
		}

		logger.debug("====================================================================================================");
		logger.debug("Aspect-checkAnonymousHandle");
		logger.debug(request.getServerName() + ":" + request.getServerPort()
				+ "[" + request.getRequestURI() + "]");

		Boolean checkLogin = false;
		try {
			checkLogin = this.loginWebUtil.checkAuth(request, response);
			if (checkLogin == true) {
				Member member = this.loginWebUtil.getAuth(request, response);
				request.setAttribute("loginMember", member);
				model.addAttribute("loginMember", member);
			}
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

		logger.debug("====================================================================================================");
		return joinPoint.proceed();
	}

	@Around("execution(public * com.song7749.web.monitoring.controller.*Controller.*GeneralMemberHandle(..))")
	public Object checkGeneralMemberHandle(ProceedingJoinPoint joinPoint)
			throws Throwable {
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		Model model = null;

		for (Object obj : joinPoint.getArgs()) {
			if (obj instanceof HttpServletRequest) {
				request = (HttpServletRequest) obj;
			} else if (obj instanceof HttpServletResponse) {
				response = (HttpServletResponse) obj;
			} else if (obj instanceof Model) {
				model = (Model) obj;
			}
		}

		logger.debug("====================================================================================================");
		logger.debug("Aspect-GeneralMemberHandle");
		logger.debug(request.getServerName() + ":" + request.getServerPort()
				+ "[" + request.getRequestURI() + "]");

		Boolean checkLogin = false;
		try {
			checkLogin = this.loginWebUtil.checkAuth(request, response);
			if (checkLogin == true) {
				Member member = this.loginWebUtil.getAuth(request, response);
				request.setAttribute("loginMember", member);
				model.addAttribute("loginMember", member);
			} else {
				String returnUrl = null;
				if (request.getParameter("returnUrl") == null)
					returnUrl = "/";
				else
					returnUrl = request.getParameter("returnUrl");
				return "redirect:/login/loginForm.html?returnUrl=" + returnUrl;
			}
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

		logger.debug("====================================================================================================");

		return joinPoint.proceed();
	}
}
