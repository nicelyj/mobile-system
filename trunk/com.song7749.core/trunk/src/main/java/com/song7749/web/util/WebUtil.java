package com.song7749.web.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

/**
 * web�� ���õ� �Ϲ����� ��ƿ��Ƽ.
 * 
 */
public class WebUtil {

	/**
	 * javascript�� messagebox�� �޼����� ��� �� ������ �������� ���𷺼�.
	 * 
	 * @param response
	 *            ������ HttpServletResponse ��ü.
	 * @param message
	 *            ����� �޼���.
	 * @param redirectUrl
	 *            �޽��� ǥ�� �� �̵��� ������.
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
	 * javascript�� messagebox�� �޼����� ��� �� ���� �������� ����.
	 * 
	 * @param response
	 *            ������ HttpServletResponse ��ü.
	 * @param message
	 *            ����� �޼���.
	 * @param back
	 *            �ǵ��ư� �ܰ�.
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
	 * javascript�� messagebox�� �޼����� ���.
	 * 
	 * @param response
	 *            ������ HttpServletResponse ��ü.
	 * @param message
	 *            ����� �޼���.
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
	 * spring-MVC���� Ư�� view ������ �̿��Ͽ� javascript�� �޼��� ��� �� ������ �������� ���𷺼��ϴ�
	 * ModelAndView ��ü ��ȯ.
	 * 
	 * @param response
	 *            ������ HttpServletResponse ��ü.
	 * @param message
	 *            ����� �޼���.
	 * @param redirectUrl
	 *            �޽��� ǥ�� �� �̵��� ������.
	 */
	public static ModelAndView messageAndRedirectUrl(ModelAndView mav,
			String message, String redirect) {
		mav.setViewName("/common/messageAndRedirect");
		mav.addObject("message", message);
		mav.addObject("redirect", redirect);
		return mav;
	}

	/**
	 * request.getQueryString ����
	 * 
	 * @param request
	 *            HttpServletRequest ��ü
	 * @param queryString
	 *            ���ܵ� ������Ʈ�� (ex. "nSiteCode,sTab") �޸��� ����
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
	 * ��Ŭ�� �ߴ��� Ȯ�� ���� ���� �� ���� : �Ķ���� �� ���� ���� ������ ���� ����
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