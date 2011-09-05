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

	public Boolean login(MemberAuth memberAuth) {

		MemberCommand memberCommand = new MemberCommand();
		memberCommand.setMember(memberAuth.getMember());

		ArrayList<Member> selectedMemberList = this.memberManager
				.selectMemberListByMemberSearchCommand(memberCommand);

		if (selectedMemberList.size() == 0)
			return false;

		Member selectedMember = selectedMemberList.get(0);

		// 마지막 로그인 시간을 웹서버 기분시로 넣는다.
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

			// 유효기간 초과되었는가 검사한다.
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss", Locale.KOREA);
			// 쿠키시간
			Date cookieTime = null;
			Date nowTime = new Date();
			try {
				cookieTime = formatter.parse(member.getMemberLastLoginTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}

			// 유효기간이 지났다!
			if (cookieTime.getTime() + 1 * 60 * 60 * 1000 < nowTime.getTime()) {
				this.logout(memberAuth);
				return false;
			}
			// 유효기간 이내면, 시간을 갱신해서 다시 인증키를 기록한다.
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
			// serialize 한뒤에 암호화하여 저장한다.
			memberAuthKey = SecurityUtil.encrypt(ObjectSerializeUtil
					.toString(member));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return memberAuthKey;
	}
}