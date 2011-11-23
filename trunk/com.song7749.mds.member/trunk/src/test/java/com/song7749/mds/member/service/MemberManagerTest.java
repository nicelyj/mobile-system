package com.song7749.mds.member.service;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.song7749.mds.member.model.Member;
import com.song7749.mds.member.model.MemberAuth;
import com.song7749.mds.member.model.MemberDetail;
import com.song7749.mds.member.model.command.MemberCommand;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:META-INF/spring/applicationContext*" })
public class MemberManagerTest {
	@Autowired
	private MemberManager memberManager;
	public static Member staticMember;
	public static MemberAuth staticMemberAuth;

	@Test
	public void testInsertMember() {
		Member member = new Member();
		member.setMemberId("song77492");
		member.setMemberName("송민수2");
		member.setMemberNickName("보아뱀2");
		member.setMemberPassword("1111111111");
		member.setMemberPasswordA("어머니 성함");
		member.setMemberPasswordQ("어머니 성함은?");
		member.setMemberEmail("song7749@gmail.com");

		MemberDetail memberDetail = new MemberDetail();

		memberDetail.setMemberZipcode("173-062");
		memberDetail.setMemberAddressBase("서울");
		memberDetail.setMemberAddressDetail("양평동");
		memberDetail.setMemberMobileNumber("000-0000-0000");
		memberDetail.setMemberPhoneNumber("000-0000-0000");
		memberDetail.setMemberResistNumber("780000-000000");
		member.setMemberDetail(memberDetail);

		Integer processVal = this.memberManager.insertMember(member);
		MemberManagerTest.staticMember = member;
		Assert.assertTrue(processVal > 0);
	}

	@Test
	public void testUpdateMember() {

		Member member = new Member();
		member.setMemberSeq(MemberManagerTest.staticMember.getMemberSeq());
		member.setMemberName("송민수");
		member.setMemberNickName("보아뱀");
		member.setMemberPassword("11111111");
		member.setMemberPasswordA("어머니 성함2");
		member.setMemberPasswordQ("어머니 성함은2?");
		member.setMemberEmail("song7749@gmail.com2");

		MemberDetail memberDetail = new MemberDetail();

		memberDetail.setMemberZipcode("173-022");
		memberDetail.setMemberAddressBase("서울2");
		memberDetail.setMemberAddressDetail("양평동2");
		memberDetail.setMemberMobileNumber("000-0000-00002");
		memberDetail.setMemberPhoneNumber("000-0000-00002");
		memberDetail.setMemberResistNumber("780000-0000002");
		member.setMemberDetail(memberDetail);

		Integer processVal = this.memberManager.updateMember(member);
		Assert.assertTrue(processVal > 0);
	}

	@Test
	public void testSelectMemberListByMemberSearchCommand() {
		MemberCommand memberCommand = new MemberCommand();
		memberCommand.setMember(new Member());
		memberCommand.getMember().setMemberSeqList(
				new ArrayList<Integer>(MemberManagerTest.staticMember
						.getMemberSeq()));
		ArrayList<Member> members = this.memberManager
				.selectMemberListByMemberSearchCommand(memberCommand);
		Assert.assertTrue(members.size() > 0);
	}

	@Test
	public void testDeleteMember() {
		Member member = MemberManagerTest.staticMember;
		Integer processVal = this.memberManager.deleteMember(member);
		Assert.assertTrue(processVal > 0);
	}

	@Test
	public void testInsertMemberAuth() {
		MemberAuth memberAuth = new MemberAuth();
		memberAuth.setMemberSeq(1);
		memberAuth.setMemberAuthKey("12312asdfkjaselfjaselfkjaslgjdsrgrwefae");

		Integer processVal = this.memberManager.insertMemberAuth(memberAuth);
		Assert.assertTrue(processVal > 0);
		MemberManagerTest.staticMemberAuth = memberAuth;
	}

	@Test
	public void testSelectMemberAuthListByMemberAuth() {
		MemberAuth memberAuth = MemberManagerTest.staticMemberAuth;
		ArrayList<MemberAuth> memberAuthList = this.memberManager
				.selectMemberAuthListByMemberAuth(memberAuth);
		Assert.assertTrue(memberAuthList.size() > 0);
	}

	@Test
	public void testDeleteMemberAuth() {
		MemberAuth memberAuth = MemberManagerTest.staticMemberAuth;
		Integer processVal = this.memberManager.deleteMemberAuth(memberAuth);
		Assert.assertTrue(processVal > 0);
	}
}