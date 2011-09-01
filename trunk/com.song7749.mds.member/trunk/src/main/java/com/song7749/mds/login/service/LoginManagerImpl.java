package com.song7749.mds.login.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.song7749.mds.member.model.Member;
import com.song7749.mds.member.model.command.MemberCommand;
import com.song7749.mds.member.service.MemberManager;

/**
 * <pre>
 * Class Name : LoginManagerImpl.java
 * Description : 로그인 매니저 구현 클래스
 * 
 *  Modification Information
 *  Modify Date 	Modifier		Comment
 * -----------------------------------------------
 *  2011. 9. 1.		song7749		신규 생성
 * 
 * </pre>
 * 
 * @author song7749
 * @since 2011. 9. 1.
 */

public class LoginManagerImpl implements LoginManager {
	@Autowired
	private MemberManager memberManager;

	public Boolean login(Member member) {
		MemberCommand memberCommand = new MemberCommand();
		memberCommand.setMember(member);

		ArrayList<Member> selectedMember = this.memberManager
				.selectMemberListByMemberSearchCommand(memberCommand);

		return null;
	}

	public Boolean logout(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean checkAuth() {

		return null;
	}

	public Member getAuth() {
		// TODO Auto-generated method stub
		return null;
	}
}
