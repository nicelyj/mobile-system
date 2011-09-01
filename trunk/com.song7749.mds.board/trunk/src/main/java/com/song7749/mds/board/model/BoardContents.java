package com.song7749.mds.board.model;

import com.song7749.base.BaseObject;

public class BoardContents extends BaseObject {
	private static final long serialVersionUID = -5840703938861248824L;
	private Integer boardListSeq;
	private String contents = "";

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
	 * @return the contents
	 */
	public String getContents() {
		return contents;
	}

	/**
	 * @param contents
	 *            the contents to set
	 */
	public void setContents(String contents) {
		this.contents = contents;
	}
}
