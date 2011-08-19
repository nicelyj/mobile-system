package com.song7749.base;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Model ��ü�� Base Ŭ����. Serializable ��� �� toString �޼ҵ� ����. ��� Model ��ü�� �� Ŭ������
 * ��ӹ޾ƾ� �ϸ� ��ü����� ���� serialVersionUID�� ������ ��.
 * 
 * @author song7749
 */
public class BaseObject implements Serializable {
	private static final long serialVersionUID = 7656619984581604160L;

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
