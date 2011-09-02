package com.song7749.mds.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.song7749.exception.MemberLoginException;
import com.song7749.mds.member.model.Member;
import com.song7749.mds.member.model.MemberAuth;
import com.song7749.mds.member.model.command.MemberCommand;

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
	protected MemberManager memberManager;
	protected Member member = new Member();

	public Boolean login(MemberAuth cookieAuth) {

		MemberCommand memberCommand = new MemberCommand();
		memberCommand.setMember(cookieAuth.getMember());

		ArrayList<Member> selectedMemberList = this.memberManager
				.selectMemberListByMemberSearchCommand(memberCommand);

		if (selectedMemberList.size() == 0)
			throw new MemberLoginException();

		Member selectedMember = selectedMemberList.get(0);

		MemberAuth memberAuth = new MemberAuth();

		// 이미 로그인한 회원인가 확인
		if (!cookieAuth.getMemberAuthKey().equals("")) {
			memberAuth.setMemberSeq(selectedMember.getMemberSeq());
			ArrayList<MemberAuth> memberAuthList = this.memberManager
					.selectMemberAuthListByMemberAuth(memberAuth);

			// 최신 로그인 정보를 가져와서 키를 비교 한다.
			MemberAuth selectedMemberAuth = memberAuthList.get(memberAuthList
					.size() - 1);
			if (cookieAuth.getMemberAuthKey().equals(
					selectedMemberAuth.getMemberAuthKey()))
				return true;
		}

		memberAuth.setMember(selectedMember);
		Integer processVal = this.memberManager.insertMemberAuth(memberAuth);
		return processVal > 0;
	}

	public Boolean logout(MemberAuth cookieAuth) {
		MemberAuth memberAuth = new MemberAuth();
		memberAuth.setMemberAuthKey(cookieAuth.getMemberAuthKey());
		memberAuth.setMemberSeq(cookieAuth.getMemberSeq());
		try {
			this.memberManager.deleteMemberAuth(memberAuth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public Boolean checkAuth(MemberAuth cookieAuth) {
		// 쿠키에 인증키와 시간이 존재하는가 확인한 뒤에
		// 인증키 없으면 로그인 페이지로
		// 있으면 시간이 정해진 시간보다 이전인가 확인하여
		// 정해진 시간 뒤면 재인증 시키고
		// 아니면 아무것도 안한다.

		return null;
	}

	public Member getAuth(MemberAuth cookieAuth) {
		// 쿠키에서 인증키와 memberSeq 를 읽어서
		// 존재하는가 확인한 뒤에
		// 회원정보를 반환.
		return null;
	}
}