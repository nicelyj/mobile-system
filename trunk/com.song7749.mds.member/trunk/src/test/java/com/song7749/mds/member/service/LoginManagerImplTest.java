package com.song7749.mds.member.service;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.song7749.mds.member.model.Member;
import com.song7749.mds.member.model.MemberAuth;
import com.song7749.mds.member.model.MemberDetail;

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
	public void setUp() {
		Member member = new Member();
		member.setMemberId("song77494");
		member.setMemberName("송민수");
		member.setMemberNickName("보아뱀");
		member.setMemberPassword("123456789");
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
		LoginManagerImplTest.staticMember = member;
	}

	@After
	public void tearDown() {
		Member member = LoginManagerImplTest.staticMember;
		Integer processVal = this.memberManager.deleteMember(member);
	}

	@Test
	public void testLogin() {
		Member member = LoginManagerImplTest.staticMember;
		MemberAuth memberAuth = new MemberAuth();
		memberAuth.setMember(member);
		Boolean processBoolean = this.loginManager.login(memberAuth);
		Assert.assertTrue(processBoolean);
		LoginManagerImplTest.staticMemberAuth = memberAuth;
	}

	@Test
	public void testCheckAuth() {
		Boolean processBoolean = this.loginManager
				.checkAuth(LoginManagerImplTest.staticMemberAuth);
		Assert.assertTrue(processBoolean);
	}

	@Test
	public void testLogout() {
		Boolean processBoolean = this.loginManager
				.logout(LoginManagerImplTest.staticMemberAuth);
		Assert.assertTrue(processBoolean);
	}
}
