package com.song7749.util.database.model;

/**
 * <pre>
 * Class Name : DatabaseStateForMysql.java
 * Description : mysql database 의 상태를 위한 model
 * 
 *  Modification Information
 *  Modify Date 	Modifier			Comment
 * -----------------------------------------------
 *  2011. 9. 26.	song7749	 	   신규 생성
 * 
 * </pre>
 * 
 * @author song7749
 * @since 2011. 9. 26.
 */

public class DatabaseStateForMysql {
	private String name;
	private String value;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
