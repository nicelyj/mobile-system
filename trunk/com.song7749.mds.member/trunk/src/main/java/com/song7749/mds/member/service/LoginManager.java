package com.song7749.mds.member.service;

import com.song7749.mds.member.model.Member;
import com.song7749.mds.member.model.MemberAuth;

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
	public Boolean login(MemberAuth cookieAuth);

	public Boolean logout(MemberAuth cookieAuth);

	public Boolean checkAuth(MemberAuth cookieAuth);

	public Member getAuth(MemberAuth cookieAuth);
}
