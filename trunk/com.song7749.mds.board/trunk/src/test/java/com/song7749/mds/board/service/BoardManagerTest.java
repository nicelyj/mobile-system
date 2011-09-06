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
import com.song7749.mds.board.model.BoardComment;
import com.song7749.mds.board.model.BoardContents;
import com.song7749.mds.board.model.BoardList;
import com.song7749.mds.board.model.command.BoardListCommand;

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
	private static BoardList staticBoardList;
	private static BoardComment staticBoardComment;

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
	 * {@link com.song7749.mds.board.service.BoardManager#insertBoardList(com.song7749.mds.board.model.BoardList)}
	 * .
	 */
	@Test
	public void testInsertBoardList() {
		BoardList boardList = new BoardList();
		boardList.setBoardCommentCount(0);
		boardList.setBoardListDisplayYN("Y");
		boardList.setBoardListPublicReadYN("Y");
		boardList.setBoardReadCount(0);
		boardList.setBoardSeq(BoardManagerTest.staticBoard.getBoardSeq());
		boardList.setBoardTitle("테스트게시물");
		boardList.setMemberIp("127.0.0.1");
		boardList.setMemberNickName("닉네임이다");
		boardList.setMemberSeq(1);
		boardList.setBoardContents(new BoardContents());
		boardList.getBoardContents().setContents("게시판내용입니다");
		int processVal = this.boardManager.insertBoardList(boardList);
		Assert.assertTrue(processVal>0);
		BoardManagerTest.staticBoardList = boardList;
	}

	/**
	 * Test method for
	 * {@link com.song7749.mds.board.service.BoardManager#updateBoardList(com.song7749.mds.board.model.BoardList)}
	 * .
	 */
	@Test
	public void testUpdateBoardList() {
		BoardList boardList = BoardManagerTest.staticBoardList;
		boardList.setBoardCommentCount(1);
		boardList.setBoardListDisplayYN("N");
		boardList.setBoardListPublicReadYN("N");
		boardList.setBoardReadCount(1);
		boardList.setBoardSeq(BoardManagerTest.staticBoard.getBoardSeq());
		boardList.setBoardTitle("테스트게시물2");
		boardList.setMemberIp("127.0.0.19");
		boardList.setMemberNickName("이상한 닉네임");
		boardList.setMemberSeq(1);
		boardList.setBoardContents(new BoardContents());
		boardList.getBoardContents().setContents("게시판내용입니다. 게시판내용 수정입니다.");
		int processVal = this.boardManager.updateBoardList(boardList);
		Assert.assertTrue(processVal>0);
	}

	/**
	 * Test method for
	 * {@link com.song7749.mds.board.service.BoardManager#updateBoardListReadCount(com.song7749.mds.board.model.BoardList)}
	 * .
	 */
	@Test
	public void testUpdateBoardListReadCount() {
		int processVal = this.boardManager.updateBoardList(BoardManagerTest.staticBoardList);
		Assert.assertTrue(processVal>0);		
	}

	/**
	 * Test method for
	 * {@link com.song7749.mds.board.service.BoardManager#selectCountBoardListFrame(com.song7749.mds.board.model.command.BoardListCommand)}
	 * .
	 */
	@Test
	public void testSelectCountBoardListByBoardListCommand() {
		BoardListCommand boardListCommand = new BoardListCommand();
		boardListCommand.setBoardList(BoardManagerTest.staticBoardList);
		int processVal = this.boardManager.selectCountBoardListByBoardListCommand(boardListCommand );
		Assert.assertTrue(processVal>0);		
	}

	/**
	 * Test method for
	 * {@link com.song7749.mds.board.service.BoardManager#selectBoardListFrame(com.song7749.mds.board.model.command.BoardListCommand)}
	 * .
	 */
	@Test
	public void testSelectBoardListsByBoardListCommand() {
		BoardListCommand boardListCommand = new BoardListCommand();
		boardListCommand.setBoardList(BoardManagerTest.staticBoardList);
		ArrayList<BoardList> boardLists = this.boardManager.selectBoardListsByBoardListCommand(boardListCommand);
		Assert.assertTrue(boardLists.size()>0);
	}

	/**
	 * Test method for
	 * {@link com.song7749.mds.board.service.BoardManager#insertBoardCommnet(com.song7749.mds.board.model.BoardComment)}
	 * .
	 */
	@Test
	public void testInsertBoardCommnet() {
		BoardComment boardComment = new BoardComment();
		boardComment.setComment("댓글 테스트");
		boardComment.setBoardListSeq(BoardManagerTest.staticBoardList.getBoardListSeq());
		boardComment.setMemberSeq(BoardManagerTest.staticBoardList.getMemberSeq());
		boardComment.setMemberIp(BoardManagerTest.staticBoardList.getMemberIp());
		boardComment.setMemberNickName(BoardManagerTest.staticBoardList.getMemberNickName());
		int processVal = this.boardManager.insertBoardCommnet(boardComment);
		Assert.assertTrue(processVal>0);
		BoardManagerTest.staticBoardComment =boardComment;
	}

	/**
	 * Test method for
	 * {@link com.song7749.mds.board.service.BoardManager#updateBoardComment(com.song7749.mds.board.model.BoardComment)}
	 * .
	 */
	@Test
	public void testUpdateBoardComment() {
		BoardComment boardComment = new BoardComment();
		boardComment.setComment("댓글 업데이트 테스트");
		boardComment.setBoardCommentSeq(BoardManagerTest.staticBoardComment.getBoardCommentSeq());
		boardComment.setMemberSeq(BoardManagerTest.staticBoardList.getMemberSeq());
		int processVal = this.boardManager.updateBoardComment(boardComment);
		Assert.assertTrue(processVal>0);
	}

	/**
	 * Test method for
	 * {@link com.song7749.mds.board.service.BoardManager#selectCountBoardCommentByBoardComment(com.song7749.mds.board.model.BoardComment)}
	 * .
	 */
	@Test
	public void testSelectCountBoardCommentByBoardComment() {
		int boardCommentCount = this.boardManager.selectCountBoardCommentByBoardComment(BoardManagerTest.staticBoardComment);
		Assert.assertTrue(boardCommentCount > 0);
	}

	/**
	 * Test method for
	 * {@link com.song7749.mds.board.service.BoardManager#selectBoardCommentsByBoardComment(com.song7749.mds.board.model.BoardComment)}
	 * .
	 */
	@Test
	public void testSelectBoardCommentsByBoardComment() {
		ArrayList<BoardComment> boardComments = this.boardManager.selectBoardCommentsByBoardComment(BoardManagerTest.staticBoardComment);
		Assert.assertTrue(boardComments.size() > 0);
	}

	/**
	 * Test method for
	 * {@link com.song7749.mds.board.service.BoardManager#deleteBoardComment(com.song7749.mds.board.model.BoardComment)}
	 * .
	 */
	@Test
	public void testDeleteBoardComment() {
		int processVal = this.boardManager.deleteBoardComment(BoardManagerTest.staticBoardComment);
		Assert.assertTrue(processVal > 0);
	}


	/**
	 * Test method for
	 * {@link com.song7749.mds.board.service.BoardManager#deleteBoardList(com.song7749.mds.board.model.BoardList)}
	 * .
	 */
	@Test
	public void testDeleteBoardList() {
		BoardList boardList = new BoardList();
		boardList.setBoardListSeq(BoardManagerTest.staticBoardList.getBoardListSeq());
		int processVal = this.boardManager.deleteBoardList(boardList);
		Assert.assertTrue(processVal>0);		
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
}