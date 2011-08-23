package com.song7749.mds.board.model;

import java.sql.Date;
import java.sql.Time;

public class BoardList {
	private Integer boardListSeq = 0;
	private Integer boardSeq = 0;
	private String boardTitle = "";
	private Integer boardReadCount = 0;
	private Integer boardCommentCount = 0;
	private Integer memberSeq = 0;
	private String memberNickName = "";
	private String memberIp = "";
	private String boardListDisplayYN = "";
	private String boardListPublicReadYN = "";
	private Date createDate;
	private Time createTime;
	private Date updateDate;
	private Time updateTime;

	/**
	 * @return the boardListSeq
	 */
	public Integer getBoardListSeq() {
		return boardListSeq;
	}

	/**
	 * @param boardListSeq
	 *            the boardListSeq to set
	 */
	public void setBoardListSeq(Integer boardListSeq) {
		this.boardListSeq = boardListSeq;
	}

	/**
	 * @return the boardSeq
	 */
	public Integer getBoardSeq() {
		return boardSeq;
	}

	/**
	 * @param boardSeq
	 *            the boardSeq to set
	 */
	public void setBoardSeq(Integer boardSeq) {
		this.boardSeq = boardSeq;
	}

	/**
	 * @return the boardTitle
	 */
	public String getBoardTitle() {
		return boardTitle;
	}

	/**
	 * @param boardTitle
	 *            the boardTitle to set
	 */
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	/**
	 * @return the boardReadCount
	 */
	public Integer getBoardReadCount() {
		return boardReadCount;
	}

	/**
	 * @param boardReadCount
	 *            the boardReadCount to set
	 */
	public void setBoardReadCount(Integer boardReadCount) {
		this.boardReadCount = boardReadCount;
	}

	/**
	 * @return the boardCommentCount
	 */
	public Integer getBoardCommentCount() {
		return boardCommentCount;
	}

	/**
	 * @param boardCommentCount
	 *            the boardCommentCount to set
	 */
	public void setBoardCommentCount(Integer boardCommentCount) {
		this.boardCommentCount = boardCommentCount;
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
	 * @return the memberIp
	 */
	public String getMemberIp() {
		return memberIp;
	}

	/**
	 * @param memberIp
	 *            the memberIp to set
	 */
	public void setMemberIp(String memberIp) {
		this.memberIp = memberIp;
	}

	/**
	 * @return the boardListDisplayYN
	 */
	public String getBoardListDisplayYN() {
		return boardListDisplayYN;
	}

	/**
	 * @param boardListDisplayYN
	 *            the boardListDisplayYN to set
	 */
	public void setBoardListDisplayYN(String boardListDisplayYN) {
		this.boardListDisplayYN = boardListDisplayYN;
	}

	/**
	 * @return the boardListPublicReadYN
	 */
	public String getBoardListPublicReadYN() {
		return boardListPublicReadYN;
	}

	/**
	 * @param boardListPublicReadYN
	 *            the boardListPublicReadYN to set
	 */
	public void setBoardListPublicReadYN(String boardListPublicReadYN) {
		this.boardListPublicReadYN = boardListPublicReadYN;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate
	 *            the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the createTime
	 */
	public Time getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(Time createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate
	 *            the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the updateTime
	 */
	public Time getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime
	 *            the updateTime to set
	 */
	public void setUpdateTime(Time updateTime) {
		this.updateTime = updateTime;
	}
}
