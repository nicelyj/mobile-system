package com.song7749.mds.member.dao;

import java.util.ArrayList;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.song7749.base.Dao;
import com.song7749.mds.member.model.Member;
import com.song7749.mds.member.model.MemberAuth;
import com.song7749.mds.member.model.command.MemberCommand;

public interface MemberDao extends Dao {
	public void setMembermaster(SqlMapClientTemplate membermaster);

	public void setMemberslave(SqlMapClientTemplate memberslave);

	public Integer insertMember(Member member);

	public Integer insertMemberDetail(Member member);

	public Integer deleteMember(Member member);

	public Integer deleteMemberDetail(Member member);

	public Integer updateMember(Member member);

	public Integer updateMemberDetail(Member member);

	public ArrayList<Member> selectMemberListByMemberCommand(
			MemberCommand memberCommand);

	public Integer insertMemberAuth(MemberAuth memberAuth);

	public Integer deleteMemberAuth(MemberAuth memberAuth);

	public ArrayList<MemberAuth> selectMemberAuthListByMemberAuth(
			MemberAuth memberAuth);
}
