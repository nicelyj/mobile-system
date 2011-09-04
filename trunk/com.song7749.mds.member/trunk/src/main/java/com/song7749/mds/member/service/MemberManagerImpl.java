package com.song7749.mds.member.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song7749.mds.member.dao.MemberDao;
import com.song7749.mds.member.model.Member;
import com.song7749.mds.member.model.MemberAuth;
import com.song7749.mds.member.model.MemberDetail;
import com.song7749.mds.member.model.command.MemberCommand;

@Service
public class MemberManagerImpl implements MemberManager {
	@Autowired
	private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public Integer insertMember(Member member) {
		Integer processVal = this.memberDao.insertMember(member);
		this.memberDao.insertMemberDetail(member);
		return processVal;
	}

	public Integer updateMember(Member member) {
		Integer processVal = 0;
		processVal += this.memberDao.updateMember(member);
		if (member.getMemberDetail() instanceof MemberDetail)
			processVal += this.memberDao.updateMemberDetail(member);
		return processVal;
	}

	public Integer deleteMember(Member member) {
		Integer processVal = this.memberDao.deleteMember(member);
		this.memberDao.deleteMemberDetail(member);
		return processVal;
	}

	public ArrayList<Member> selectMemberListByMemberSearchCommand(
			MemberCommand memberCommand) {
		return this.memberDao.selectMemberListByMemberCommand(memberCommand);
	}

	public Integer insertMemberAuth(MemberAuth memberAuth) {
		return this.memberDao.insertMemberAuth(memberAuth);
	}

	public Integer deleteMemberAuth(MemberAuth memberAuth) {
		return this.memberDao.deleteMemberAuth(memberAuth);
	}

	public ArrayList<MemberAuth> selectMemberAuthListByMemberAuth(
			MemberAuth memberAuth) {
		return this.memberDao.selectMemberAuthListByMemberAuth(memberAuth);
	}

}
