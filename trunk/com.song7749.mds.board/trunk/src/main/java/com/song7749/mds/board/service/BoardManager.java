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

	public ArrayList<Board> selectBoardList(Board board);

	public Integer insertBoardList(BoardList boardList);

	public Integer updateBoardList(BoardList boardList);

	public Integer updateBoardListReadCount(BoardList boardList)
			throws Exception;

	public Integer deleteBoardList(BoardList boardList);

	public Integer selectCountBoardListFrame(
			BoardListCommand boardListSearchCommand);

	public ArrayList<BoardList> selectBoardListFrame(
			BoardListCommand boardListSearchCommand);

	public Integer insertBoardCommnet(BoardComment boardComment)
			throws Exception;

	public Integer updateBoardComment(BoardComment boardComment)
			throws Exception;

	public Integer deleteBoardComment(BoardComment boardComment)
			throws Exception;

	public Integer selectCountBoardCommentByBoardComment(
			BoardComment boardComment);

	public ArrayList<BoardComment> selectBoardCommentsByBoardComment(
			BoardComment boardComment);
}
