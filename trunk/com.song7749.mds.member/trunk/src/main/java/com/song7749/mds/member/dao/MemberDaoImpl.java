package com.song7749.mds.member.dao;

import java.util.ArrayList;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.song7749.mds.member.model.Member;
import com.song7749.mds.member.model.MemberAuth;
import com.song7749.mds.member.model.command.MemberCommand;

@Repository
public class MemberDaoImpl implements MemberDao {
	private SqlMapClientTemplate membermaster;
	private SqlMapClientTemplate memberslave;

	public void setMembermaster(SqlMapClientTemplate membermaster) {
		this.membermaster = membermaster;
	}

	public void setMemberslave(SqlMapClientTemplate memberslave) {
		this.memberslave = memberslave;
	}

	public Integer insertMember(Member member) {
		Integer processVal = (Integer) membermaster.insert(
				"Member.insertMember", member);
		memberslave.queryForObject("Member.dummySql"); // cache flushed
		return processVal;
	}

	public Integer insertMemberDetail(Member member) {
		Integer processVal = (Integer) membermaster.insert(
				"Member.insertMemberDetail", member);
		memberslave.queryForObject("Member.dummySql"); // cache flushed
		return processVal;
	}

	public Integer deleteMember(Member member) {
		Integer processVal = (Integer) membermaster.delete(
				"Member.deleteMember", member);
		memberslave.queryForObject("Member.dummySql"); // cache flushed
		return processVal;
	}

	public Integer deleteMemberDetail(Member member) {
		Integer processVal = (Integer) membermaster.delete(
				"Member.deleteMemberDetail", member);
		memberslave.queryForObject("Member.dummySql"); // cache flushed
		return processVal;
	}

	public Integer updateMember(Member member) {
		Integer processVal = (Integer) membermaster.update(
				"Member.updateMember", member);
		memberslave.queryForObject("Member.dummySql"); // cache flushed
		return processVal;
	}

	public Integer updateMemberDetail(Member member) {
		Integer processVal = (Integer) membermaster.update(
				"Member.updateMemberDetail", member);
		memberslave.queryForObject("Member.dummySql"); // cache flushed
		return processVal;
	}

	public ArrayList<Member> selectMemberListByMemberCommand(
			MemberCommand memberCommand) {

		return (ArrayList<Member>) memberslave.queryForList(
				"Member.selectMemberListByMemberCommand", memberCommand);
	}

	public Integer insertMemberAuth(MemberAuth memberAuth) {
		return (Integer) membermaster.insert("Member.insertMemberAuth",
				memberAuth);
	}

	public Integer deleteMemberAuth(MemberAuth memberAuth) {
		return membermaster.delete("Member.deleteMemberAuth", memberAuth);
	}

	public ArrayList<MemberAuth> selectMemberAuthListByMemberAuth(
			MemberAuth memberAuth) {
		return (ArrayList<MemberAuth>) membermaster.queryForList(
				"Member.selectMemberAuthListByMemberAuth", memberAuth);
	}
}