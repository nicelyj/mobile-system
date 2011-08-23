package com.song7749.mds.board.model.command;

import com.song7749.mds.board.model.Board;
import com.song7749.mds.board.model.BoardComment;
import com.song7749.mds.board.model.BoardContents;
import com.song7749.mds.board.model.BoardList;

public class BoardListCommand {
	private Board board;
	private BoardList boardList;
	private BoardComment boardComment;
	private BoardContents boardContents;
	private String addContent = "N";
	private Integer limit = null;
	private Integer offset = null;

	/**
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * @param board
	 *            the board to set
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

	/**
	 * @return the boardList
	 */
	public BoardList getBoardList() {
		return boardList;
	}

	/**
	 * @param boardList
	 *            the boardList to set
	 */
	public void setBoardList(BoardList boardList) {
		this.boardList = boardList;
	}

	/**
	 * @return the boardComment
	 */
	public BoardComment getBoardComment() {
		return boardComment;
	}

	/**
	 * @param boardComment
	 *            the boardComment to set
	 */
	public void setBoardComment(BoardComment boardComment) {
		this.boardComment = boardComment;
	}

	/**
	 * @return the boardContents
	 */
	public BoardContents getBoardContents() {
		return boardContents;
	}

	/**
	 * @param boardContents
	 *            the boardContents to set
	 */
	public void setBoardContents(BoardContents boardContents) {
		this.boardContents = boardContents;
	}

	/**
	 * @return the addContent
	 */
	public String getAddContent() {
		return addContent;
	}

	/**
	 * @param addContent
	 *            the addContent to set
	 */
	public void setAddContent(String addContent) {
		this.addContent = addContent;
	}

	/**
	 * @return the limit
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * @param limit
	 *            the limit to set
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	/**
	 * @return the offset
	 */
	public Integer getOffset() {
		return offset;
	}

	/**
	 * @param offset
	 *            the offset to set
	 */
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
}
