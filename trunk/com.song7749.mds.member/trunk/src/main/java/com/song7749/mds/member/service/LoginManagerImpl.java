package com.song7749.mds.member.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;

import com.song7749.mds.member.model.Member;
import com.song7749.mds.member.model.MemberAuth;
import com.song7749.mds.member.model.command.MemberCommand;
import com.song7749.util.security.SecurityUtil;
import com.song7749.util.string.ObjectSerializeUtil;

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

	public Boolean login(MemberAuth memberAuth) {

		MemberCommand memberCommand = new MemberCommand();
		memberCommand.setMember(memberAuth.getMember());

		ArrayList<Member> selectedMemberList = this.memberManager
				.selectMemberListByMemberSearchCommand(memberCommand);

		if (selectedMemberList.size() == 0)
			return false;

		Member selectedMember = selectedMemberList.get(0);

		// ������ �α��� �ð��� ������ ��н÷� �ִ´�.
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss", Locale.KOREA);
		selectedMember.setMemberLastLoginTime(formatter.format(date));

		String memberAuthKey = this.setAuth(selectedMember);
		memberAuth.setMember(selectedMember);
		memberAuth.setMemberAuthKey(memberAuthKey);
		Integer processVal = this.memberManager.insertMemberAuth(memberAuth);
		return processVal > 0;
	}

	public Boolean logout(MemberAuth memberAuth) {
		try {
			this.memberManager.deleteMemberAuth(memberAuth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public Boolean checkAuth(MemberAuth memberAuth) {
		if (memberAuth.getMemberAuthKey().equals("")) {
			return false;
		} else {
			Member member = this.getAuth(memberAuth);

			// ��ȿ�Ⱓ �ʰ��Ǿ��°� �˻��Ѵ�.
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss", Locale.KOREA);
			// ��Ű�ð�
			Date cookieTime = null;
			Date nowTime = new Date();
			try {
				cookieTime = formatter.parse(member.getMemberLastLoginTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}

			// ��ȿ�Ⱓ�� ������!
			if (cookieTime.getTime() + 1 * 60 * 60 * 1000 < nowTime.getTime()) {
				this.logout(memberAuth);
				return false;
			}
			// ��ȿ�Ⱓ �̳���, �ð��� �����ؼ� �ٽ� ����Ű�� ����Ѵ�.
			else {
				member.setMemberLastLoginTime(formatter.format(nowTime));
				memberAuth.setMemberAuthKey(this.setAuth(member));
				return true;
			}
		}
	}

	public Member getAuth(MemberAuth memberAuth) {
		Member member = null;
		try {
			member = (Member) ObjectSerializeUtil.fromString(SecurityUtil
					.decrypt(memberAuth.getMemberAuthKey()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}

	private String setAuth(Member member) {
		String memberAuthKey = null;
		try {
			// serialize �ѵڿ� ��ȣȭ�Ͽ� �����Ѵ�.
			memberAuthKey = SecurityUtil.encrypt(ObjectSerializeUtil
					.toString(member));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return memberAuthKey;
	}
}