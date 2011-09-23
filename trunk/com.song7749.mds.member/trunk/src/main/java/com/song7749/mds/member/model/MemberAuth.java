package com.song7749.mds.member.model;

import com.song7749.base.BaseObject;

/**
 * <pre>
 * Class Name : MemberAuth.java
 * Description : 회원 인증 모듈
 * 	인증키 셋은 setMemeber 호출시에만 초기화 된다.
 *  Modification Information
 *  Modify Date 	Modifier		Comment
 * -----------------------------------------------
 *  2011. 9. 1.		song7749		신규 생성
 * 
 * </pre>
 * 
 * @author song7749
 * @since 2011. 9. 1.
 */
public class MemberAuth extends BaseObject {
	private static final long serialVersionUID = 1L;
	private Member member;
	private Integer memberAuthSeq;
	private Integer memberSeq;
	private String memberAuthKey = "";
	private String memberAuthDateTime;
	private String startDate;
	private String endDate;

	/**
	 * @return the member
	 */
	public Member getMember() {
		return member;
	}

	/**
	 * @param member
	 *            the member to set
	 */
	public void setMember(Member member) {
		this.member = member;
		this.memberSeq = member.getMemberSeq();
	}

	/**
	 * @return the memberAuthSeq
	 */
	public Integer getMemberAuthSeq() {
		return memberAuthSeq;
	}

	/**
	 * @param memberAuthSeq
	 *            the memberAuthSeq to set
	 */
	public void setMemberAuthSeq(Integer memberAuthSeq) {
		this.memberAuthSeq = memberAuthSeq;
	}

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
	 * @return the memberAuthKey
	 */
	public String getMemberAuthKey() {
		return memberAuthKey;
	}

	/**
	 * @param memberAuthKey
	 *            the memberAuthKey to set
	 */
	public void setMemberAuthKey(String memberAuthKey) {
		this.memberAuthKey = memberAuthKey;
	}

	/**
	 * @return the memberAuthDateTime
	 */
	public String getMemberAuthDateTime() {
		return memberAuthDateTime;
	}

	/**
	 * @param memberAuthDateTime
	 *            the memberAuthDateTime to set
	 */
	public void setMemberAuthDateTime(String memberAuthDateTime) {
		this.memberAuthDateTime = memberAuthDateTime;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}