package com.song7749.mds.board.model;

import com.song7749.base.BaseObject;

public class Board extends BaseObject {
	private static final long serialVersionUID = -952945932664626399L;

	private Integer boardSeq;
	private String boardName;

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
	 * @return the boardName
	 */
	public String getBoardName() {
		return boardName;
	}

	/**
	 * @param boardName
	 *            the boardName to set
	 */
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

}
