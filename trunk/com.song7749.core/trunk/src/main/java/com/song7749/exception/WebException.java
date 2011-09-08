package com.song7749.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.song7749.base.HttpResultCode;

public class WebException extends RuntimeException {
	private static final long serialVersionUID = 3582191228996415846L;

	private static final Log logger = LogFactory.getLog(WebException.class);
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpResultCode httpResultCode = HttpResultCode.getInstance();

	private String message;
	private Throwable cause;
	private Integer code;

	public WebException(HttpServletRequest request,
			HttpServletResponse response, Integer code) {
		super("errorCode:[" + code + "]");
		this.request = request;
		this.response = response;
		this.code = code;
		sendMessage();
	}

	public WebException(HttpServletRequest request,
			HttpServletResponse response, Integer code, String message) {
		super("errorCode:[" + code + "]:" + message);
		this.request = request;
		this.response = response;
		this.code = code;
		this.message = message;
		sendMessage();
	}

	public WebException(HttpServletRequest request,
			HttpServletResponse response, Integer code, Throwable cause) {
		super(cause);
		this.request = request;
		this.response = response;
		this.code = code;
		this.cause = cause;
		sendMessage();
	}

	public WebException(HttpServletRequest request,
			HttpServletResponse response, Integer code, String message,
			Throwable cause) {
		super("errorCode:[" + code + "]:" + message, cause);
		this.request = request;
		this.response = response;
		this.code = code;
		this.message = message;
		this.cause = cause;
		sendMessage();
	}

	public void sendMessage() {
		// 로그기록
		logger.info("[" + code + "]" + httpResultCode.getMessage(code)
				+ message + "," + "IP:" + request.getRemoteAddr() + ","
				+ "METHOD:" + request.getMethod() + "," + "URI:"
				+ request.getRequestURI() + "," + "QUERY:"
				+ request.getQueryString());

		if (cause != null) {
			logger.info("=========================== stacktrace start ==========================");
			for (StackTraceElement e : cause.getStackTrace()) {
				logger.info(e.toString());
			}
			logger.info("============================ stacktrace end ===========================");
		}

		String redirectUrl = "/error.jsp?code=" + code;
		try {
			response.sendRedirect(redirectUrl);
		} catch (IOException e) {
		}
	}
}
