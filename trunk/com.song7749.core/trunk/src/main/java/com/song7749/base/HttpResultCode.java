package com.song7749.base;

import java.util.HashMap;

public class HttpResultCode {
	private static HttpResultCode httpResultCode;
	private HashMap<Integer, String> errorMap = new HashMap<Integer, String>();

	private HttpResultCode() {
		errorMap.put(OK, "정상처리 되었습니다.");
		errorMap.put(INTERNAL_SERVER_ERROR, "내부 서버 오류가 발생하였습니다.");
		errorMap.put(BAD_REQUEST, "요청 형식이 잘못되었습니다.");
		errorMap.put(FORBIDDEN, "자원의 접근이 제한되었습니다.");
		errorMap.put(REQUEST_TIMEOUT, "요청 대기시간이 초과되었습니다.");
		errorMap.put(NOT_FOUND, "존재하지 않는 자원입니다.");
		errorMap.put(SERVICE_UNAVAILABLE, "서버의 자원이 부족합니다.");
	}

	public static synchronized HttpResultCode getInstance() {
		if (httpResultCode == null) {
			httpResultCode = new HttpResultCode();
		}
		return httpResultCode;
	}

	public String getMessage(Integer errorCode) {
		return errorMap.get(errorCode);
	}

	/** 정상처리 */
	public static final Integer OK = 200;

	/** 내부 서버 오류 */
	public static final Integer INTERNAL_SERVER_ERROR = 500;

	/** 잘못된 요청 형식 */
	public static final Integer BAD_REQUEST = 400;

	/** 접근이 제한됨 */
	public static final Integer FORBIDDEN = 403;

	/** 요청 대기시간 초과 */
	public static final Integer REQUEST_TIMEOUT = 408;

	/** 존재하지 않는 자원 */
	public static final Integer NOT_FOUND = 404;

	/** 서버 리소스 부족 */
	public static final Integer SERVICE_UNAVAILABLE = 503;
}