package com.song7749.web.monitoring.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.song7749.mds.board.model.Board;
import com.song7749.mds.board.model.BoardContents;
import com.song7749.mds.board.model.BoardList;
import com.song7749.mds.board.model.command.BoardListCommand;
import com.song7749.mds.board.service.BoardManager;
import com.song7749.mds.member.model.Member;
import com.song7749.web.monitoring.base.BaseController;

@Controller
@RequestMapping("/board")
public class BoardController extends BaseController {
	@Autowired
	private BoardManager boardManager;

	public BoardController() {
	}

	@RequestMapping({ "/boards.html", "/boards.xml" })
	public String BoardList(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {
		String ViewTemplete = "board/boards";

		if (request.getRequestURI().equals("/board/boards.html")) {
			// 로그인 체크
			super.checkAuth(request, response, modelMap);

			modelMap.addAttribute(
					"javascript",
					"<script type=\"text/javascript\" src=\"/js/common/commonAjax.js\"></script>"
							+ "<script type=\"text/javascript\" src=\"/js/board/board.js\"></script>");
		}
		
		ArrayList<Board> boards = boardManager.selectBoards(new Board());
		modelMap.addAttribute("boards", boards);
		return ViewTemplete;
	}

	@RequestMapping(value = "/boardProcess.html", method = RequestMethod.POST)
	public void boardInsert(
			@RequestParam(value = "boardName", defaultValue = "", required = true) String boardName,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {

		// 로그인 체크
		super.checkAuth(request, response, modelMap);
		
		Board board = new Board();
		board.setBoardName(boardName);
		try {
			this.boardManager.insertBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/boardProcess.html", method = RequestMethod.PUT)
	public void boardUpdate(
			@RequestParam(value = "boardSeq", defaultValue = "0", required = true) Integer boardSeq,
			@RequestParam(value = "boardName", defaultValue = "", required = true) String boardName,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {

		// 로그인 체크
		super.checkAuth(request, response, modelMap);
		
		Board board = new Board();
		board.setBoardSeq(boardSeq);
		board.setBoardName(boardName);
		try {
			this.boardManager.updateBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/boardProcess.html", method = RequestMethod.DELETE)
	public void boardDelete(
			@RequestParam(value = "boardSeq", defaultValue = "0", required = true) Integer boardSeq,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {

		// 로그인 체크
		super.checkAuth(request, response, modelMap);
	
		Board board = new Board();
		board.setBoardSeq(boardSeq);
		try {
			this.boardManager.deleteBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/boardList.html")
	public String boardList(
			@RequestParam(value="boardSeq",defaultValue="1",required=false) Integer boardSeq,
			HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {
		
		String ViewTemplete = "board/boardList";
		// 로그인 체크 
		super.checkAuth(request, response, modelMap);
	
		// 게시판 조회
		Board board = new Board();
		board.setBoardSeq(boardSeq);
		ArrayList<Board> boards = this.boardManager.selectBoards(board);
		board.setBoardName(boards.get(0).getBoardName());
		
		// 게시글 리스트 조회
		BoardListCommand boardListCommand = new BoardListCommand();
		boardListCommand.setBoardList(new BoardList());
		boardListCommand.getBoardList().setBoardSeq(boardSeq);
		ArrayList<BoardList> boardLists = this.boardManager.selectBoardListsByBoardListCommand(boardListCommand );
		
		modelMap.addAttribute("board", board);
		modelMap.addAttribute("boardLists", boardLists);
		modelMap.addAttribute(
				"javascript","<script type=\"text/javascript\" src=\"/js/board/boardList.js\"></script>");
		return ViewTemplete;
	}
	
	@RequestMapping("/boardListForm.html")
	public String boardListForm(
			@RequestParam(value="boardSeq",defaultValue="1",required=true) Integer boardSeq,
			HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {
		String ViewTemplete = "board/boardListForm";
		// 로그인 체크 
		super.checkAuth(request, response, modelMap);
		
		// 게시판 조회
		Board board = new Board();
		board.setBoardSeq(boardSeq);
		ArrayList<Board> boards = this.boardManager.selectBoards(board);
		board.setBoardName(boards.get(0).getBoardName());
		
		modelMap.addAttribute("board", board);
		return ViewTemplete;
	}
	
	@RequestMapping(value="/boardListProcess.html",method= RequestMethod.POST)
	public void boardListProcess(
			@RequestParam(value="title",defaultValue="",required=true) String boardTitle,
			@RequestParam(value="contents",defaultValue="",required=true) String contents,
			@RequestParam(value="memberNickName",defaultValue="",required=true) String memberNickName,
			@RequestParam(value="boardListPublicReadYN",defaultValue="N",required=true) String boardListPublicReadYN,
			@RequestParam(value="boardSeq",defaultValue="0",required=true) Integer boardSeq,
			@RequestParam(value="boardListSeq",defaultValue="0",required=true) Integer boardListSeq,
			HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {

		// 로그인 체크 
		super.checkAuth(request, response, modelMap);		
		Member member = (Member) modelMap.get("loginMember");
		
		BoardList boardList = new BoardList();
		boardList.setMemberSeq(member.getMemberSeq());
		boardList.setBoardCommentCount(0);
		boardList.setBoardListDisplayYN("Y");
		boardList.setBoardListPublicReadYN(boardListPublicReadYN);
		boardList.setBoardListSeq(boardListSeq);
		boardList.setBoardReadCount(0);
		boardList.setBoardSeq(boardSeq);
		boardList.setBoardTitle(boardTitle);
		boardList.setMemberIp(request.getRemoteAddr());
		boardList.setBoardContents(new BoardContents());
		boardList.getBoardContents().setContents(contents);
		try {
			this.boardManager.insertBoardList(boardList);
			response.sendRedirect("/board/boardList.html?boardSeq="+boardSeq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}