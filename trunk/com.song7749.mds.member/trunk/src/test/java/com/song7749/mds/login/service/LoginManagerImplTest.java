package com.song7749.mds.login.service;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.aspectj.lang.annotation.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.song7749.mds.member.model.Member;
import com.song7749.mds.member.model.MemberAuth;
import com.song7749.mds.member.model.MemberDetail;
import com.song7749.mds.member.service.MemberManager;
import com.song7749.mds.member.service.MemberManagerTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:META-INF/spring/applicationContext*" })
public class LoginManagerImplTest {
	@Autowired
	private LoginManager loginManager;
	@Autowired
	private MemberManager memberManager;
	public static Member staticMember;
	public static MemberAuth staticMemberAuth;
	
	@org.junit.Before
	public void setUp(){
		Member member = new Member();
		member.setMemberId("song77494");
		member.setMemberName("�۹μ�");
		member.setMemberNickName("���ƹ�");
		member.setMemberPassword("123456789");
		member.setMemberPasswordA("��Ӵ� ����");
		member.setMemberPasswordQ("��Ӵ� ������?");
		member.setMemberEmail("song7749@gmail.com");

		MemberDetail memberDetail = new MemberDetail();

		memberDetail.setMemberZipcode("173-062");
		memberDetail.setMemberAddressBase("����");
		memberDetail.setMemberAddressDetail("����");
		memberDetail.setMemberMobileNumber("000-0000-0000");
		memberDetail.setMemberPhoneNumber("000-0000-0000");
		memberDetail.setMemberResistNumber("780000-000000");
		member.setMemberDetail(memberDetail);

		Integer processVal = this.memberManager.insertMember(member);
		LoginManagerImplTest.staticMember = member;
	}
	@After
	public void tearDown(){
		Member member = LoginManagerImplTest.staticMember;
		Integer processVal = this.memberManager.deleteMember(member);	
	}
	
	@Test
	public void testLogin() {
		Member member = LoginManagerImplTest.staticMember;
		System.out.println();
		Boolean processBoolean = this.loginManager.login(member );
		Assert.assertTrue(processBoolean);
	}	

	@Test
	public void testLogout() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckAuth() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAuth() {
		fail("Not yet implemented");
	}

}
