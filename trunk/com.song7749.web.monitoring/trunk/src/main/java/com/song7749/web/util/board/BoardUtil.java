package com.song7749.web.util.board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.song7749.mds.board.model.Board;
import com.song7749.mds.board.service.BoardManager;

/**
 * ���� ���� ��ƿ��Ƽ
 * 
 * @author song7749
 * 
 */
public class BoardUtil {
	@Autowired
	BoardManager boardManager;

	public ArrayList<Board> getBoardList() {
		Board board = new Board();
		return boardManager.selectBoards(board);
	}
}
