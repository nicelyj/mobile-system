package com.song7749.mds.board.service;

import java.util.ArrayList;

import com.song7749.mds.board.dao.BoardDao;
import com.song7749.mds.board.model.Board;
import com.song7749.mds.board.model.BoardComment;
import com.song7749.mds.board.model.BoardList;
import com.song7749.mds.board.model.command.BoardListCommand;

public interface BoardManager {
	public void setBoardDao(BoardDao boardDao);

	public Integer insertBoard(Board board);

	public Integer updateBoard(Board board);

	public Integer deleteBoard(Board board);

	public ArrayList<Board> selectBoards(Board board);

	public Integer insertBoardList(BoardList boardList);

	public Integer updateBoardList(BoardList boardList);

	public Integer updateBoardListReadCount(BoardList boardList)
			throws Exception;

	public Integer deleteBoardList(BoardList boardList);

	public Integer selectCountBoardListByBoardListCommand(
			BoardListCommand boardListCommand);

	public ArrayList<BoardList> selectBoardListsByBoardListCommand(
			BoardListCommand boardListCommand);

	public Integer insertBoardCommnet(BoardComment boardComment);

	public Integer updateBoardComment(BoardComment boardComment);

	public Integer deleteBoardComment(BoardComment boardComment);

	public Integer selectCountBoardCommentByBoardComment(
			BoardComment boardComment);

	public ArrayList<BoardComment> selectBoardCommentsByBoardComment(
			BoardComment boardComment);
}