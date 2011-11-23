package com.song7749.base;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * <pre>
 * Class Name : BaseObject.java
 * Description : Model 객체의 Base 클래스. Serializable 상속 및 toString 메소드 제공. 모든 Model 객체는 이 클래스를
 * 상속받아야 하며 객체통신을 위해 serialVersionUID를 생성할 것.
 * 
 *  Modification Information
 *  Modify Date		Modifier		Comment
 * ---------------------------------------------------
 *  2011. 11. 23.	song7749		신규 생성
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
