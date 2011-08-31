package com.song7749.mds.member.model;

import java.sql.Date;
import java.util.ArrayList;

import com.song7749.base.BaseObject;

public class Member extends BaseObject {
	private static final long serialVersionUID = 8951079944667150478L;

	private Integer memberSeq;
	private ArrayList<Integer> memberSeqList;
	private String memberId;
	private String memberName;
	private String memberNickName;
	private String memberPassword;
	private String memberPasswordQ;
	private String memberPasswordA;
	private String memberEmail;
	private Date memberLastLoginTime;

	private MemberDetail memberDetail;

	/**
	 * @return the memberSeq
	 */
	public Integer getMemberSeq() {
		return memberSeq;
	}

	/**
	 * @param memberSeq
	 *            the memberSeq to set
	 */
	public void setMemberSeq(Integer memberSeq) {
		this.memberSeq = memberSeq;
	}

	/**
	 * @return the memberSeqList
	 */
	public ArrayList<Integer> getMemberSeqList() {
		return memberSeqList;
	}

	/**
	 * @param memberSeqList
	 *            the memberSeqList to set
	 */
	public void setMemberSeqList(ArrayList<Integer> memberSeqList) {
		this.memberSeqList = memberSeqList;
	}

	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId
	 *            the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	/**
	 * @return the memberName
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * @param memberName
	 *            the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * @return the memberNickName
	 */
	public String getMemberNickName() {
		return memberNickName;
	}

	/**
	 * @param memberNickName
	 *            the memberNickName to set
	 */
	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}

	/**
	 * @return the memberPassword
	 */
	public String getMemberPassword() {
		return memberPassword;
	}

	/**
	 * @param memberPassword
	 *            the memberPassword to set
	 */
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	/**
	 * @return the memberPasswordQ
	 */
	public String getMemberPasswordQ() {
		return memberPasswordQ;
	}

	/**
	 * @param memberPasswordQ
	 *            the memberPasswordQ to set
	 */
	public void setMemberPasswordQ(String memberPasswordQ) {
		this.memberPasswordQ = memberPasswordQ;
	}

	/**
	 * @return the memberPasswordA
	 */
	public String getMemberPasswordA() {
		return memberPasswordA;
	}

	/**
	 * @param memberPasswordA
	 *            the memberPasswordA to set
	 */
	public void setMemberPasswordA(String memberPasswordA) {
		this.memberPasswordA = memberPasswordA;
	}

	/**
	 * @return the memberEmail
	 */
	public String getMemberEmail() {
		return memberEmail;
	}

	/**
	 * @param memberEmail
	 *            the memberEmail to set
	 */
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	/**
	 * @return the memberLastLoginTime
	 */
	public Date getMemberLastLoginTime() {
		return memberLastLoginTime;
	}

	/**
	 * @param memberLastLoginTime
	 *            the memberLastLoginTime to set
	 */
	public void setMemberLastLoginTime(Date memberLastLoginTime) {
		this.memberLastLoginTime = memberLastLoginTime;
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

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}