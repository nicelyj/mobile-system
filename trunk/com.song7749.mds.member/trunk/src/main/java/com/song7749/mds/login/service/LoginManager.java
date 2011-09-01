package com.song7749.mds.login.service;

import com.song7749.mds.member.model.Member;

/**
 * <pre>
 * Interface Name : LoginManager.java
 * Description : 
 * 
 *  Modification Information
 *  Modify Date 	Modifier			Comment
 * -----------------------------------------------
 *  2011. 9. 1.		song7749		    신규 생성
 * 
 * </pre>
 * 
 * @author song7749
 * @since 2011. 9. 1.
 */
public interface LoginManager {
	public Boolean login(Member member);

	public Boolean logout(Member member);

	public Boolean checkAuth();

	public Member getAuth();
}
