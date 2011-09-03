package com.song7749.mds.board.dao;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.song7749.base.Dao;
import com.song7749.mds.board.model.Board;
import com.song7749.mds.board.model.BoardList;
import com.song7749.mds.board.model.command.BoardListCommand;

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
		Integer processVal = (Integer) this.boardmaster.insert(
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

		Integer processVal = (Integer) this.boardmaster.update("BoardList.deleteBoard",
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

		Integer processVal = (Integer) this.boardmaster.update("BoardList.updateBoard",
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
	@Override
	public ArrayList<Board> selectBoards(Board board) {
		return (ArrayList<Board>) this.boardslave.queryForList(
				"BoardList.selectBoardsCaches", board);
	}

	@Override
	public Integer insertBoardList(BoardList boardList) {
		Integer processVal = (Integer) this.boardmaster.insert("BoardList.insertBoardList", boardList);
		return processVal;
	}
	
	public Integer insertBoardContents(BoardList boardList){
		Integer processVal = (Integer) this.boardmaster.insert("BoardList.insertBoardContents", boardList);	
		return processVal;
	}

	@Override
	public Integer updateBoardList(BoardList boardList) {
		Integer processVal = (Integer) this.boardmaster.update("BoardList.updateBoardList", boardList);
		return processVal;
	}

	@Override
	public Integer updateBoardContents(BoardList boardList) {
		Integer processVal = (Integer) this.boardmaster.update("BoardList.updateBoardContents", boardList);
		return processVal;
	}

	@Override
	public Integer updateBoardListReadCount(BoardList boardList) {
		Integer processVal = (Integer) this.boardmaster.update("BoardList.updateBoardListReadCount", boardList);
		return processVal;
	}

	@Override
	public Integer selectCountBoardListByBoardListCommand(
			BoardListCommand boardListCommand) {
		return  (Integer) this.boardslave.queryForObject("BoardList.selectCountBoardListByBoardListCommand", boardListCommand);
	}

	@Override
	public ArrayList<BoardList> selectBoardListsByBoardListCommand(
			BoardListCommand boardListCommand) {
		return (ArrayList<BoardList>)this.boardslave.queryForList("BoardList.selectBoardListsByBoardListCommand", boardListCommand);
	}

	@Override
	public Integer deleteBoardContents(BoardList boardList) {
		return (Integer)this.boardmaster.delete("BoardList.deleteBoardContents", boardList);
	}

	@Override
	public Integer deleteBoardList(BoardList boardList) {
		return (Integer)this.boardmaster.delete("BoardList.deleteBoardList", boardList);
	}
}
