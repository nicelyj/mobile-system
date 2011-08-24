package com.song7749.mds.board.service;

import java.util.ArrayList;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.song7749.mds.board.model.Board;

/**
 * BoardManagerTest
 * 
 * @author song7749
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:META-INF/spring/applicationContext*" })
public class BoardManagerTest extends TestCase {
	@Autowired
	private BoardManager boardManager;
	private static Board staticBoard;

	/**
	 * Test method for
	 * {@link com.song7749.mds.board.service.BoardManager#insertBoard(com.song7749.mds.board.model.Board)}
	 * .
	 */
	@Test
	public void testInsertBoard() {
		Board board = new Board();
		board.setBoardName("test");
		Integer insertid = this.boardManager.insertBoard(board);
		BoardManagerTest.staticBoard = board;
		Assert.assertTrue(insertid > 0);
	}

	/**
	 * Test method for
	 * {@link com.song7749.mds.board.service.BoardManager#selectBoardList(com.song7749.mds.board.model.Board)}
	 * .
	 */
	@Test
	public void testSelectBoards() {
		Board board = new Board();
		ArrayList<Board> boards = new ArrayList<Board>();
		boards = this.boardManager.selectBoards(board);
		Assert.assertTrue(boards.size() > 0);
	}

	/**
	 * Test method for
	 * {@link com.song7749.mds.board.service.BoardManager#updateBoard(com.song7749.mds.board.model.Board)}
	 * .
	 */
	@Test
	public void testUpdateBoard() {
		Board board = BoardManagerTest.staticBoard;
		board.setBoardName("testupdate");
		int affectedRows = this.boardManager.updateBoard(board);
		Assert.assertTrue(affectedRows > 0);

	}

	/**
	 * Test method for
	 * {@link com.song7749.mds.board.service.BoardManager#deleteBoard(com.song7749.mds.board.model.Board)}
	 * .
	 */
	@Test
	public void testDeleteBoard() {
		Board board = new Board();
		// board.setBoardName("test");
		board.setBoardSeq(BoardManagerTest.staticBoard.getBoardSeq());
		int processVal = this.boardManager.deleteBoard(board);
		Assert.assertTrue("보드삭제 실패", processVal > 0);
	}

	/**
	 * Test method for
	 * {@link com.song7749.mds.board.service.BoardManager#insertBoardList(com.song7749.mds.board.model.BoardList)}
	 * .
	 */
	public void testInsertBoardList() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.song7749.mds.board.service.BoardManager#updateBoardList(com.song7749.mds.board.model.BoardList)}
	 * .
	 */
	public void testUpdateBoardList() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.song7749.mds.board.service.BoardManager#updateBoardListReadCount(com.song7749.mds.board.model.BoardList)}
	 * .
	 */
	public void testUpdateBoardListReadCount() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.song7749.mds.board.service.BoardManager#deleteBoardList(com.song7749.mds.board.model.BoardList)}
	 * .
	 */
	public void testDeleteBoardList() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.song7749.mds.board.service.BoardManager#selectCountBoardListFrame(com.song7749.mds.board.model.command.BoardListCommand)}
	 * .
	 */
	public void testSelectCountBoardListFrame() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.song7749.mds.board.service.BoardManager#selectBoardListFrame(com.song7749.mds.board.model.command.BoardListCommand)}
	 * .
	 */
	public void testSelectBoardListFrame() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.song7749.mds.board.service.BoardManager#insertBoardCommnet(com.song7749.mds.board.model.BoardComment)}
	 * .
	 */
	public void testInsertBoardCommnet() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.song7749.mds.board.service.BoardManager#updateBoardComment(com.song7749.mds.board.model.BoardComment)}
	 * .
	 */
	public void testUpdateBoardComment() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.song7749.mds.board.service.BoardManager#deleteBoardComment(com.song7749.mds.board.model.BoardComment)}
	 * .
	 */
	public void testDeleteBoardComment() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.song7749.mds.board.service.BoardManager#selectCountBoardCommentByBoardComment(com.song7749.mds.board.model.BoardComment)}
	 * .
	 */
	public void testSelectCountBoardCommentByBoardComment() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.song7749.mds.board.service.BoardManager#selectBoardCommentsByBoardComment(com.song7749.mds.board.model.BoardComment)}
	 * .
	 */
	public void testSelectBoardCommentsByBoardComment() {
		fail("Not yet implemented");
	}

}
