package com.song7749.web.monitoring.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.song7749.mds.board.model.Board;
import com.song7749.mds.board.service.BoardManager;

@Controller
public class BoardController {
	@Autowired
	private BoardManager boardManager;

	public BoardController() {
	}

	@RequestMapping("board/boardList.html")
	public String BoardList(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {
		String ViewTemplete = "board/boardList";

		setBoardList(modelMap);
		modelMap.addAttribute("javascript",
				"<script type=\"text/javascript\" src=\"/js/common/commonAjax.js\"></script>"+
				"<script type=\"text/javascript\" src=\"/js/board/board.js\"></script>");

		return ViewTemplete;
	}

	@RequestMapping(value = "board/boardProcess.html", method = RequestMethod.POST)
	public void boardInsert(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {

		String boardName = request.getParameter("boardName");

		Board board = new Board();
		board.setBoardName(boardName);
		try {
			this.boardManager.insertBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			response.sendRedirect("boardList.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "board/boardProcess.html", method = RequestMethod.PUT)
	public void boardUpdate(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {

		String boardSeq = request.getParameter("boardSeq");
		String boardName = request.getParameter("boardName");

		Board board = new Board();
		board.setBoardSeq(Integer.parseInt(boardSeq));
		board.setBoardName(boardName);
		try {
			this.boardManager.updateBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "board/boardProcess.html", method = RequestMethod.DELETE)
	public void boardDelete(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {

		String boardSeq = request.getParameter("boardSeq");

		Board board = new Board();
		board.setBoardSeq(Integer.parseInt(boardSeq));
		try {
			this.boardManager.deleteBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setBoardList(ModelMap modelMap) {
		ArrayList<Board> boards = boardManager.selectBoards(new Board());
		modelMap.addAttribute("boards", boards);
		modelMap.addAttribute("menuBoards", boards);
	}
}