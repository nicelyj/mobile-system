package com.song7749.mds.login.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.song7749.exception.MemberLoginException;
import com.song7749.mds.member.model.Member;
import com.song7749.mds.member.model.MemberAuth;
import com.song7749.mds.member.model.command.MemberCommand;
import com.song7749.mds.member.service.MemberManager;
import com.song7749.mds.member.service.MemberManagerTest;

/**
 * <pre>
 * Class Name : LoginManagerImpl.java
 * Description : �α��� �Ŵ��� ���� Ŭ����
 * 
 *  Modification Information
 *  Modify Date 	Modifier		Comment
 * -----------------------------------------------
 *  2011. 9. 1.		song7749		�ű� ����
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

		ArrayList<Member> selectedMemberList = this.memberManager
				.selectMemberListByMemberSearchCommand(memberCommand);

		if(selectedMemberList.size() == 0)
			throw new MemberLoginException();
		
		Member selectedMember = selectedMemberList.get(0);
		
		MemberAuth memberAuth = new MemberAuth();
		memberAuth.setMember(selectedMember);
		// TODO ��Ű����
		
		Integer processVal = this.memberManager.insertMemberAuth(memberAuth);
		return processVal > 0;
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
