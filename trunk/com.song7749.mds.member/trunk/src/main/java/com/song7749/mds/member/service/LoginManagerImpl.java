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

		// �̹� �α����� ȸ���ΰ� Ȯ��
		if (!cookieAuth.getMemberAuthKey().equals("")) {
			memberAuth.setMemberSeq(selectedMember.getMemberSeq());
			ArrayList<MemberAuth> memberAuthList = this.memberManager
					.selectMemberAuthListByMemberAuth(memberAuth);

			// �ֽ� �α��� ������ �����ͼ� Ű�� �� �Ѵ�.
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
		// ��Ű�� ����Ű�� �ð��� �����ϴ°� Ȯ���� �ڿ�
		// ����Ű ������ �α��� ��������
		// ������ �ð��� ������ �ð����� �����ΰ� Ȯ���Ͽ�
		// ������ �ð� �ڸ� ������ ��Ű��
		// �ƴϸ� �ƹ��͵� ���Ѵ�.

		return null;
	}

	public Member getAuth(MemberAuth cookieAuth) {
		// ��Ű���� ����Ű�� memberSeq �� �о
		// �����ϴ°� Ȯ���� �ڿ�
		// ȸ�������� ��ȯ.
		return null;
	}
}