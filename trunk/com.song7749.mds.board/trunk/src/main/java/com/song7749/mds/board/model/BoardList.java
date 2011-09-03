package com.song7749.mds.board.model;

import java.sql.Date;
import java.sql.Time;

import com.song7749.base.BaseObject;

public class BoardList extends BaseObject {
	private static final long serialVersionUID = 5102094027180361972L;
	private Integer boardListSeq;
	private Integer boardSeq;
	private String boardTitle;
	private Integer boardReadCount;
	private Integer boardCommentCount;
	private Integer memberSeq;
	private String memberNickName;
	private String memberIp;
	private String boardListDisplayYN;
	private String boardListPublicReadYN;
	private String createDatetime;
	private String updateDatetime;

	private BoardContents boardContents;

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
	 * @return the boardSeq
	 */
	public Integer getBoardSeq() {
		return boardSeq;
	}

	/**
	 * @param boardSeq the boardSeq to set
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
	 * @param boardTitle the boardTitle to set
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
	 * @param boardReadCount the boardReadCount to set
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
	 * @param boardCommentCount the boardCommentCount to set
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
	 * @return the boardListDisplayYN
	 */
	public String getBoardListDisplayYN() {
		return boardListDisplayYN;
	}

	/**
	 * @param boardListDisplayYN the boardListDisplayYN to set
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
	 * @param boardListPublicReadYN the boardListPublicReadYN to set
	 */
	public void setBoardListPublicReadYN(String boardListPublicReadYN) {
		this.boardListPublicReadYN = boardListPublicReadYN;
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
	 * @return the boardContents
	 */
	public BoardContents getBoardContents() {
		return boardContents;
	}

	/**
	 * @param boardContents the boardContents to set
	 */
	public void setBoardContents(BoardContents boardContents) {
		this.boardContents = boardContents;
	}
}