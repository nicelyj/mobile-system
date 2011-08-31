package com.song7749.mds.member.model.command;

import com.song7749.mds.member.model.Member;
import com.song7749.mds.member.model.MemberDetail;

public class MemberCommand {
	private Member member;
	private MemberDetail memberDetail;

	/**
	 * @return the member
	 */
	public Member getMember() {
		return member;
	}

	/**
	 * @param member
	 *            the member to set
	 */
	public void setMember(Member member) {
		this.member = member;
	}

	/**
	 * @return the memberDetail
	 */
	public MemberDetail getMemberDetail() {
		return memberDetail;
	}

	/**
	 * @param memberDetail
	 *            the memberDetail to set
	 */
	public void setMemberDetail(MemberDetail memberDetail) {
		this.memberDetail = memberDetail;
	}

}
