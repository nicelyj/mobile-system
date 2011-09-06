package com.song7749.mds.board.model;

import java.sql.Date;
import java.sql.Time;

import com.song7749.base.BaseObject;

public class BoardComment extends BaseObject {
	private static final long serialVersionUID = -2733045706223144843L;
	private Integer boardCommentSeq;
	private Integer boardListSeq;
	private String comment;
	private Integer memberSeq;
	private String memberNickName;
	private String memberIp;
	private String createDatetime;
	private String updateDatetime;
	/**
	 * @return the boardCommentSeq
	 */
	public Integer getBoardCommentSeq() {
		return boardCommentSeq;
	}
	/**
	 * @param boardCommentSeq the boardCommentSeq to set
	 */
	public void setBoardCommentSeq(Integer boardCommentSeq) {
		this.boardCommentSeq = boardCommentSeq;
	}
	/**
	 * @return the boardListSeq
	 */
	public Integer getBoardListSeq() {
		return boardListSeq;
	}
	/**
	 * @param boardListSeq the boardListSeq to set
	 */
	public void setBoardListSeq(Integer boardListSeq) {
		this.boardListSeq = boardListSeq;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @return the memberSeq
	 */
	public Integer getMemberSeq() {
		return memberSeq;
	}
	/**
	 * @param memberSeq the memberSeq to set
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
	 * @param memberNickName the memberNickName to set
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
	 * @param memberIp the memberIp to set
	 */
	public void setMemberIp(String memberIp) {
		this.memberIp = memberIp;
	}
	/**
	 * @return the createDatetime
	 */
	public String getCreateDatetime() {
		return createDatetime;
	}
	/**
	 * @param createDatetime the createDatetime to set
	 */
	public void setCreateDatetime(String createDatetime) {
		this.createDatetime = createDatetime;
	}
	/**
	 * @return the updateDatetime
	 */
	public String getUpdateDatetime() {
		return updateDatetime;
	}
	/**
	 * @param updateDatetime the updateDatetime to set
	 */
	public void setUpdateDatetime(String updateDatetime) {
		this.updateDatetime = updateDatetime;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}