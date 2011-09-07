package com.song7749.web.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

/**
 * web과 관련된 일반적인 유틸리티.
 * 
 */
public class WebUtil {

	/**
	 * javascript의 messagebox로 메세지를 출력 후 지정된 페이지로 리디렉션.
	 * 
	 * @param response
	 *            응답할 HttpServletResponse 객체.
	 * @param message
	 *            출력할 메세지.
	 * @param redirectUrl
	 *            메시지 표시 후 이동할 페이지.
	 */
	public static void messageAndRedirectUrl(HttpServletResponse response,
			String message, String redirectUrl) {
		message(response, message);

		String output = "<META HTTP-EQUIV='REFRESH' CONTENT='0; URL="
				+ redirectUrl + "'>";
		try {
			response.getWriter().print(output);
		} catch (IOException e) {
		}
	}

	/**
	 * javascript의 messagebox로 메세지를 출력 후 이전 페이지로 복귀.
	 * 
	 * @param response
	 *            응답할 HttpServletResponse 객체.
	 * @param message
	 *            출력할 메세지.
	 * @param back
	 *            되돌아갈 단계.
	 */
	public static void messageAndBack(HttpServletResponse response,
			String message, int back) {
		message(response, message);

		String output = "<script language='javascript'>history.go(" + back
				+ ");</script>";
		try {
			response.getWriter().print(output);
		} catch (IOException e) {
		}
	}

	/**
	 * javascript의 messagebox로 메세지를 출력.
	 * 
	 * @param response
	 *            응답할 HttpServletResponse 객체.
	 * @param message
	 *            출력할 메세지.
	 */
	public static void message(HttpServletResponse response, String message) {
		response.setContentType("text/html; charset=EUC-KR");
		String output = "<script language='javascript'>alert('" + message
				+ "');</script>";
		try {
			response.getWriter().print(output);
		} catch (IOException e) {
		}
	}

	/**
	 * spring-MVC에서 특정 view 파일을 이용하여 javascript로 메세지 출력 후 지정된 페이지로 리디렉션하는
	 * ModelAndView 객체 반환.
	 * 
	 * @param response
	 *            응답할 HttpServletResponse 객체.
	 * @param message
	 *            출력할 메세지.
	 * @param redirectUrl
	 *            메시지 표시 후 이동할 페이지.
	 */
	public static ModelAndView messageAndRedirectUrl(ModelAndView mav,
			String message, String redirect) {
		mav.setViewName("/common/messageAndRedirect");
		mav.addObject("message", message);
		mav.addObject("redirect", redirect);
		return mav;
	}

	/**
	 * request.getQueryString 변형
	 * 
	 * @param request
	 *            HttpServletRequest 객체
	 * @param queryString
	 *            제외될 쿼리스트링 (ex. "nSiteCode,sTab") 콤마로 구분
	 * @return
	 */
	public static String getQueryString(HttpServletRequest request,
			String queryString) {
		Enumeration requestEnum = request.getParameterNames();
		ArrayList requestParamList = new ArrayList();
		String[] queryExt = null;
		String returnValue = "";

		while (requestEnum.hasMoreElements()) {
			requestParamList.add(requestEnum.nextElement().toString());
		}

		try {
			if (queryString != "") {
				queryExt = queryString.split(",");

				if (queryExt.length > 0) {
					for (String query : queryExt) {
						for (int i = 0; i < requestParamList.size(); i++) {
							if (requestParamList.get(i).equals(query))
								requestParamList.remove(i);
						}
					}
				}
			}

			for (int i = (requestParamList.size() - 1); i >= 0; i--) {
				String currentParameter = requestParamList.get(i).toString();
				String currentValue = request.getParameter(currentParameter);
				returnValue = returnValue + currentParameter + "="
						+ currentValue + "&";
			}

			if (returnValue.length() > 0)
				returnValue = returnValue
						.substring(0, returnValue.length() - 1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return returnValue;
	}

	/**
	 * 온클릭 했는지 확인 한후 리턴 값 참고 : 파라미터 값 비교후 값이 같으면 값을 리턴
	 * 
	 * @param paramValue
	 * @param compareValue
	 * @param returnValue
	 * @return
	 */
	public static String onClickConfirm(String paramValue, String compareValue,
			String returnValue) {
		String returnString = "";
		try {
			if (paramValue == compareValue || paramValue.equals(compareValue)) {
				returnString = returnValue;
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnString = "";
		}
		return returnString;
	}
}