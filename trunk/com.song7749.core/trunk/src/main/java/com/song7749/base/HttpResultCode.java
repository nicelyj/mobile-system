package com.song7749.base;

import java.util.HashMap;

public class HttpResultCode {
	private static HttpResultCode httpResultCode;
	private HashMap<Integer, String> errorMap = new HashMap<Integer, String>();

	private HttpResultCode() {
		errorMap.put(OK, "����ó�� �Ǿ����ϴ�.");
		errorMap.put(INTERNAL_SERVER_ERROR, "���� ���� ������ �߻��Ͽ����ϴ�.");
		errorMap.put(BAD_REQUEST, "��û ������ �߸��Ǿ����ϴ�.");
		errorMap.put(FORBIDDEN, "�ڿ��� ������ ���ѵǾ����ϴ�.");
		errorMap.put(REQUEST_TIMEOUT, "��û ���ð��� �ʰ��Ǿ����ϴ�.");
		errorMap.put(NOT_FOUND, "�������� �ʴ� �ڿ��Դϴ�.");
		errorMap.put(SERVICE_UNAVAILABLE, "������ �ڿ��� �����մϴ�.");
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

	/** ����ó�� */
	public static final Integer OK = 200;

	/** ���� ���� ���� */
	public static final Integer INTERNAL_SERVER_ERROR = 500;

	/** �߸��� ��û ���� */
	public static final Integer BAD_REQUEST = 400;

	/** ������ ���ѵ� */
	public static final Integer FORBIDDEN = 403;

	/** ��û ���ð� �ʰ� */
	public static final Integer REQUEST_TIMEOUT = 408;

	/** �������� �ʴ� �ڿ� */
	public static final Integer NOT_FOUND = 404;

	/** ���� ���ҽ� ���� */
	public static final Integer SERVICE_UNAVAILABLE = 503;
}