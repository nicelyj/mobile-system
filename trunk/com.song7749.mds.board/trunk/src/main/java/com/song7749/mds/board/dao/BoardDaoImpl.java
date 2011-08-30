package com.song7749.mds.board.dao;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.song7749.base.Dao;
import com.song7749.mds.board.model.Board;

public class BoardDaoImpl implements BoardDao {
	private SqlMapClientTemplate boardmaster;
	private SqlMapClientTemplate boardslave;

	/**
	 * @param boardmaster
	 *            the boardmaster to set
	 */
	public void setBoardmaster(SqlMapClientTemplate boardmaster) {
		this.boardmaster = boardmaster;
	}

	/**
	 * @param boardslave
	 *            the boardslave to set
	 */
	public void setBoardslave(SqlMapClientTemplate boardslave) {
		this.boardslave = boardslave;
	}

	/**
	 * 보드 추가.<br>
	 * 
	 * @param board
	 * @return
	 */
	public Integer insertBoard(Board board) {
		Integer processVal = (Integer) boardmaster.insert(
				"BoardList.insertBoard", board);

		boardslave.queryForObject("BoardList.dummySql"); // cache flushed
		return processVal;
	}

	/**
	 * 보드 삭제<br>
	 * 
	 * @param board
	 * @return
	 */
	public Integer deleteBoard(Board board) {
		if ((board.getBoardSeq() != null && board.getBoardSeq() <= 0)
				&& board.getBoardName().isEmpty())
			throw new InvalidParameterException();

		Integer processVal = (int) boardmaster.update("BoardList.deleteBoard",
				board);
		boardslave.queryForObject("BoardList.dummySql"); // cache flushed
		return processVal;
	}

	/**
	 * 보드 수정
	 * 
	 * @param board
	 * @return
	 */
	public Integer updateBoard(Board board) {
		if (board.getBoardSeq() == null || board.getBoardSeq() == 0)
			throw new InvalidParameterException();

		Integer processVal = (int) boardmaster.update("BoardList.updateBoard",
				board);
		boardslave.queryForObject("BoardList.dummySql"); // cache flushed
		return processVal;
	}

	/**
	 * 보드 목록 .<br>
	 * 
	 * @param board
	 * @return
	 */
	public ArrayList<Board> selectBoards(Board board) {
		return (ArrayList<Board>) this.boardslave.queryForList(
				"BoardList.selectBoardsCaches", board);
	}

}
