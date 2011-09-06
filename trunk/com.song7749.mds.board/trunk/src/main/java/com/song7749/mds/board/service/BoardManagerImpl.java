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
		return this.boardDao.updateBoard(board);
	}

	public Integer deleteBoard(Board board) {
		return this.boardDao.deleteBoard(board);
	}

	public ArrayList<Board> selectBoards(Board board) {
		return this.boardDao.selectBoards(board);
	}

	public Integer insertBoardList(BoardList boardList) {
		Integer processVal = this.boardDao.insertBoardList(boardList);
		processVal +=this.boardDao.insertBoardContents(boardList);
		return processVal;
	}

	public Integer updateBoardList(BoardList boardList) {
		Integer processVal = this.boardDao.updateBoardList(boardList);
		processVal +=this.boardDao.updateBoardContents(boardList);
		return processVal;
	}

	public Integer updateBoardListReadCount(BoardList boardList)
			throws Exception {
		return this.boardDao.updateBoardListReadCount(boardList);
	}

	public Integer deleteBoardList(BoardList boardList) {
		Integer processVal = this.boardDao.deleteBoardContents(boardList);
		processVal+= this.boardDao.deleteBoardList(boardList);
		return processVal;
	}

	public Integer selectCountBoardListByBoardListCommand(
			BoardListCommand boardListCommand) {
		return this.boardDao.selectCountBoardListByBoardListCommand(boardListCommand);
	}

	public ArrayList<BoardList> selectBoardListsByBoardListCommand(
			BoardListCommand boardListCommand) {
		return this.boardDao.selectBoardListsByBoardListCommand(boardListCommand);
	}

	public Integer insertBoardCommnet(BoardComment boardComment){
		return this.boardDao.insertBoardComment(boardComment);
	}

	public Integer updateBoardComment(BoardComment boardComment){
		return this.boardDao.updateBoardComment(boardComment);
	}

	public Integer deleteBoardComment(BoardComment boardComment){
		return this.boardDao.deleteBoardComment(boardComment);
	}

	public Integer selectCountBoardCommentByBoardComment(
			BoardComment boardComment) {
		return this.boardDao.selectCountBoardCommentByBoardComment(boardComment);
	}

	public ArrayList<BoardComment> selectBoardCommentsByBoardComment(
			BoardComment boardComment) {
		// TODO Auto-generated method stub
		return this.boardDao.selectBoardCommentsByBoardComment(boardComment);
	}

}
