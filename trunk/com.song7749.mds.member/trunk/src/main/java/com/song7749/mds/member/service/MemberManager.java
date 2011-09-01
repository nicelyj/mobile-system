package com.song7749.mds.member.service;

import java.util.ArrayList;

import com.song7749.mds.member.dao.MemberDao;
import com.song7749.mds.member.model.Member;
import com.song7749.mds.member.model.MemberAuth;
import com.song7749.mds.member.model.command.MemberCommand;

public interface MemberManager {
	public void setMemberDao(MemberDao memberDao);

	public Integer insertMember(Member member);

	public Integer updateMember(Member member);

	public Integer deleteMember(Member member);

	public ArrayList<Member> selectMemberListByMemberSearchCommand(
			MemberCommand memberCommand);

	public Integer insertMemberAuth(MemberAuth memberAuth);

	public Integer deleteMemberAuth(MemberAuth memberAuth);

	public ArrayList<MemberAuth> selectMemberAuthListByMemberAuth(
			MemberAuth memberAuth);

}
