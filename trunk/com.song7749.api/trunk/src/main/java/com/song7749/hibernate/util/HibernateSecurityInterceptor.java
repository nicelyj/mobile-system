package com.song7749.hibernate.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.EmptyInterceptor;

/**
 * <pre>
 * Class Name : HibernateSecurityInterceptor.java
 * Description :
 * seal,unseal 사용시에 예약어가 alias 되어 문제가 발생하는 부분을 처리함.
 *
 *  Modification Information
 *  Modify Date 	Modifier	Comment
 *  -----------------------------------------------
 *  2013. 11. 4.	song7749	새로 작성
 *
 * </pre>
 *
 * @author song7749
 * @since 2013. 11. 4.
 */
public class HibernateSecurityInterceptor extends EmptyInterceptor {

	private static final long serialVersionUID = 7049750866908874951L;
	private final String castStart="CAST(";
	private final String castEnd=" AS CHAR CHARACTER SET UTF8)";

	@Override
	public String onPrepareStatement(String sql) {
		// select 는 unseal , 나머지는 seal 로 분기해야 한다.
		if(sql.toLowerCase().indexOf("select")>=0){
			sql = unseal(sql);
		}
		else{
			sql = seal(sql);
		}
		return super.onPrepareStatement(sql);
	}

	/**
	 * seal
	 * @param sql
	 * @return String
	 */
	private String seal(String sql){
		Pattern p = Pattern.compile("(?i:seal_text)");
		Matcher m = p.matcher(sql);

		// 캐스트 해야할 포인트를 찾는다.
		List<Integer> castStartPoint = new ArrayList<Integer>();
		while(m.find()){
			castStartPoint.add(m.end());
		}

		// insert 하면 위치가 뒤로 이동됨으로 이동된 문자열 만큼 더해줘야 한다.
		int offset=0;
		StringBuffer sb = new StringBuffer(sql);
		for(Integer point : castStartPoint){
			sb.insert(point+offset+1, castStart);
			sb.insert(sb.indexOf(")", point+offset),castEnd);
			offset += castStart.length();
			offset += castEnd.length();
		}
		return sb.toString();
	}

	/**
	 * unseal
	 * @param sql
	 * @return String
	 */
	private String unseal(String sql){
		Pattern p = Pattern.compile("(?i:unseal_text)");
		Matcher m = p.matcher(sql);

		// 캐스트 해야할 포인트를 찾는다.
		List<Integer> castStartPoint = new ArrayList<Integer>();
		while(m.find()){
			castStartPoint.add(m.start());
		}

		// insert 하면 위치가 뒤로 이동됨으로 이동된 문자열 만큼 더해줘야 한다.
		int offset=0;
		StringBuffer sb = new StringBuffer(sql);
		for(Integer point : castStartPoint){
			sb.insert(point+offset, castStart);
			sb.insert(sb.indexOf(")", point+offset)+1,castEnd);
			offset += castStart.length();
			offset += castEnd.length();
		}
		return sb.toString();
	}
}