package com.song7749.base;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * <pre>
 * Class Name : BaseObject.java
 * Description : Model ��ü�� Base Ŭ����. Serializable ��� �� toString �޼ҵ� ����. ��� Model ��ü�� �� Ŭ������
 * ��ӹ޾ƾ� �ϸ� ��ü����� ���� serialVersionUID�� ������ ��.
 * 
 *  Modification Information
 *  Modify Date		Modifier		Comment
 * ---------------------------------------------------
 *  2011. 11. 23.	song7749		�ű� ����
 * 
 * </pre>
 * 
 * @author song7749
 * @since 2011. 11. 23.
 */

public class BaseObject implements Serializable {
	private static final long serialVersionUID = 7656619984581604160L;

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
