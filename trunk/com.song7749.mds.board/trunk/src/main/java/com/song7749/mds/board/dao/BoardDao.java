package com.song7749.mds.board.dao;

import java.util.ArrayList;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.song7749.base.Dao;
import com.song7749.mds.board.model.Board;

public class BoardDao implements Dao {
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

	public Integer insertBoard(Board board) {
		Integer processVal = (int) boardmaster.update("BoardList.insertBoard",
				board);
		return processVal;
	}

	public ArrayList<Board> selectBoards(Board board) {
		return (ArrayList<Board>) this.boardslave.queryForList(
				"BoardList.selectBoards", board);
	}

}
