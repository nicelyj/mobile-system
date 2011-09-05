package com.song7749.web.monitoring.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.song7749.mds.member.model.Member;
import com.song7749.mds.member.model.MemberDetail;
import com.song7749.mds.member.model.command.MemberCommand;
import com.song7749.mds.member.service.MemberManager;
import com.song7749.web.monitoring.base.BaseController;

@Controller
@RequestMapping("/member")
public class MemberContorller extends BaseController {
	@Autowired
	private MemberManager memberManager;

	public MemberContorller() {
	}

	@RequestMapping("/memberList.html")
	public String memberList(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {
		String viewTemplete = "member/memberList";

		if(super.checkAuth(request, response, modelMap) == false)
			return viewTemplete;
		
		MemberCommand memberCommand = new MemberCommand();
		ArrayList<Member> memberList = this.memberManager
				.selectMemberListByMemberSearchCommand(memberCommand);

		modelMap.addAttribute("memberList", memberList);
		modelMap.addAttribute(
				"javascript",
				"<script type=\"text/javascript\" src=\"/js/common/commonAjax.js\"></script>"
						+ "<script type=\"text/javascript\" src=\"/js/member/memberList.js\"></script>");

		return viewTemplete;
	}

	@RequestMapping({ "/memberForm.html", "/memberJoinForm.html", "/memberModifyForm.html" })
	public String MemberInputForm(
			@RequestParam(value = "memberSeq", defaultValue = "0", required = false) Integer memberSeq,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {

		String viewTemplete = "member/memberJoinForm";

		if(!request.getRequestURI().equals("/member/memberJoinForm.html")){
			if(super.checkAuth(request, response, modelMap) == false)
				return viewTemplete;
		}
		
		if (request.getRequestURI().equals("/member/memberModifyForm.html")
				&& memberSeq > 0) {

			MemberCommand memberCommand = new MemberCommand();
			memberCommand.setMember(new Member());
			memberCommand.getMember().setMemberSeq(memberSeq);
			ArrayList<Member> memberList = this.memberManager
					.selectMemberListByMemberSearchCommand(memberCommand);

			modelMap.addAttribute("member", memberList.get(0));
		}

		modelMap.addAttribute(
				"javascript",
				"<script type=\"text/javascript\" src=\"/js/common/commonAjax.js\"></script>"
						+ "<script type=\"text/javascript\" src=\"/js/member/memberForm.js\"></script>");
		return viewTemplete;
	}

	@RequestMapping(value = "/memberProcess.html", method = {
			RequestMethod.POST, RequestMethod.PUT })
	public void memberInsertOrUpdate(
			@RequestParam(value = "memberSeq", defaultValue = "", required = false) Integer memberSeq,
			@RequestParam(value = "memberId", defaultValue = "", required = true) String memberId,
			@RequestParam(value = "memberName", defaultValue = "", required = true) String memberName,
			@RequestParam(value = "memberNickName", defaultValue = "", required = false) String memberNickName,
			@RequestParam(value = "memberPassword", defaultValue = "", required = true) String memberPassword,
			@RequestParam(value = "memberPasswordQ", defaultValue = "", required = true) String memberPasswordQ,
			@RequestParam(value = "memberPasswordA", defaultValue = "", required = true) String memberPasswordA,
			@RequestParam(value = "email", defaultValue = "", required = true) String memberEmail,
			@RequestParam(value = "postCode1", defaultValue = "", required = true) String postCode1,
			@RequestParam(value = "postCode2", defaultValue = "", required = true) String postCode2,
			@RequestParam(value = "addressBase", defaultValue = "", required = true) String memberAddressBase,
			@RequestParam(value = "addressDetail", defaultValue = "", required = true) String memberAddressDetail,
			@RequestParam(value = "phoneNumber", defaultValue = "", required = true) String memberPhoneNumber,
			@RequestParam(value = "mobilePhoneNumber", defaultValue = "", required = true) String memberMobileNumber,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {
	
		Member member = new Member();
		member.setMemberName(memberName);
		member.setMemberNickName(memberNickName);
		member.setMemberPassword(memberPassword);
		member.setMemberPasswordQ(memberPasswordQ);
		member.setMemberPasswordA(memberPasswordA);
		member.setMemberEmail(memberEmail);
		member.setMemberDetail(new MemberDetail());
		member.getMemberDetail().setMemberZipcode(postCode1 + "-" + postCode2);
		member.getMemberDetail().setMemberAddressBase(memberAddressBase);
		member.getMemberDetail().setMemberAddressDetail(memberAddressDetail);
		member.getMemberDetail().setMemberMobileNumber(memberMobileNumber);
		member.getMemberDetail().setMemberPhoneNumber(memberPhoneNumber);

		try {
			if (request.getMethod().equals("POST")) {
				member.setMemberId(memberId);
				this.memberManager.insertMember(member);
			} else {
				member.setMemberSeq(memberSeq);
				this.memberManager.updateMember(member);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			response.sendRedirect("/member/memberList.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/memberProcess.html", method = RequestMethod.DELETE)
	public String memberDelete(
			@RequestParam(value = "memberSeq", defaultValue = "0", required = true) Integer memberSeq,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {

		String viewTemplete = null;
		if(super.checkAuth(request, response, modelMap) == false)
			return viewTemplete;
	
		Member member = new Member();
		member.setMemberSeq(memberSeq);
		try {
			this.memberManager.deleteMember(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viewTemplete;
	}
}