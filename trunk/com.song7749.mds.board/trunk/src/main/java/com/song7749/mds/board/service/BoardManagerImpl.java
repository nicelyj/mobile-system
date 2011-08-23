package com.song7749.mds.board.service;

import java.util.ArrayList;

import com.song7749.mds.board.dao.BoardDao;
import com.song7749.mds.board.model.Board;
import com.song7749.mds.board.model.BoardComment;
import com.song7749.mds.board.model.BoardList;
import com.song7749.mds.board.model.command.BoardListCommand;

public class BoardManagerImpl implements BoardManager {
	private BoardDao boardDao;

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	public Integer insertBoard(Board board) {
		return this.boardDao.insertBoard(board);
	}

	public Integer updateBoard(Board board) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer deleteBoard(Board board) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Board> selectBoardList(Board board) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer insertBoardList(BoardList boardList) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer updateBoardList(BoardList boardList) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer updateBoardListReadCount(BoardList boardList)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer deleteBoardList(BoardList boardList) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer selectCountBoardListFrame(
			BoardListCommand boardListSearchCommand) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<BoardList> selectBoardListFrame(
			BoardListCommand boardListSearchCommand) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer insertBoardCommnet(BoardComment boardComment)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer updateBoardComment(BoardComment boardComment)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer deleteBoardComment(BoardComment boardComment)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer selectCountBoardCommentByBoardComment(
			BoardComment boardComment) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<BoardComment> selectBoardCommentsByBoardComment(
			BoardComment boardComment) {
		// TODO Auto-generated method stub
		return null;
	}

}
