package com.song7749.mds.board.dao;

import java.util.ArrayList;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.song7749.base.Dao;
import com.song7749.mds.board.model.Board;

public interface BoardDao extends Dao{

	/**
	 * @param boardmaster
	 *            the boardmaster to set
	 */
	public void setBoardmaster(SqlMapClientTemplate boardmaster);
	
	/**
	 * @param boardslave
	 *            the boardslave to set
	 */
	public void setBoardslave(SqlMapClientTemplate boardslave);

	/**
	 * 보드 추가.<br>
	 * 
	 * @param board
	 * @return
	 */
	public Integer insertBoard(Board board);
	
	/**
	 * 보드 삭제<br>
	 * 
	 * @param board
	 * @return
	 */
	public Integer deleteBoard(Board board);
	
	/**
	 * 보드 수정
	 * 
	 * @param board
	 * @return
	 */
	public Integer updateBoard(Board board);
	
	/**
	 * 보드 목록 .<br>
	 * 
	 * @param board
	 * @return
	 */
	public ArrayList<Board> selectBoards(Board board);
}
