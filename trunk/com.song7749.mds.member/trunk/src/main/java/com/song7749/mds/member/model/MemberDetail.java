package com.song7749.mds.member.model;

import com.song7749.base.BaseObject;

public class MemberDetail extends BaseObject {

	private static final long serialVersionUID = 4841235047236352820L;

	private Integer memberSeq;
	private String memberResistNumber;
	private String memberZipcode;
	private String memberAddressBase;
	private String memberAddressDetail;
	private String memberPhoneNumber;
	private String memberMobileNumber;

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
	 * @return the memberResistNumber
	 */
	public String getMemberResistNumber() {
		return memberResistNumber;
	}

	/**
	 * @param memberResistNumber
	 *            the memberResistNumber to set
	 */
	public void setMemberResistNumber(String memberResistNumber) {
		this.memberResistNumber = memberResistNumber;
	}

	/**
	 * @return the memberZipcode
	 */
	public String getMemberZipcode() {
		return memberZipcode;
	}

	/**
	 * @param memberZipcode
	 *            the memberZipcode to set
	 */
	public void setMemberZipcode(String memberZipcode) {
		this.memberZipcode = memberZipcode;
	}

	/**
	 * @return the memberAddressBase
	 */
	public String getMemberAddressBase() {
		return memberAddressBase;
	}

	/**
	 * @param memberAddressBase
	 *            the memberAddressBase to set
	 */
	public void setMemberAddressBase(String memberAddressBase) {
		this.memberAddressBase = memberAddressBase;
	}

	/**
	 * @return the memberAddressDetail
	 */
	public String getMemberAddressDetail() {
		return memberAddressDetail;
	}

	/**
	 * @param memberAddressDetail
	 *            the memberAddressDetail to set
	 */
	public void setMemberAddressDetail(String memberAddressDetail) {
		this.memberAddressDetail = memberAddressDetail;
	}

	/**
	 * @return the memberPhoneNumber
	 */
	public String getMemberPhoneNumber() {
		return memberPhoneNumber;
	}

	/**
	 * @param memberPhoneNumber
	 *            the memberPhoneNumber to set
	 */
	public void setMemberPhoneNumber(String memberPhoneNumber) {
		this.memberPhoneNumber = memberPhoneNumber;
	}

	/**
	 * @return the memberMobileNumber
	 */
	public String getMemberMobileNumber() {
		return memberMobileNumber;
	}

	/**
	 * @param memberMobileNumber
	 *            the memberMobileNumber to set
	 */
	public void setMemberMobileNumber(String memberMobileNumber) {
		this.memberMobileNumber = memberMobileNumber;
	}
}