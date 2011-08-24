package com.song7749.web.monitoring.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.song7749.mds.board.model.Board;
import com.song7749.mds.board.service.BoardManager;
import com.song7749.web.util.board.BoardUtil;

@Controller
public class BoardController {
	@Autowired
	private BoardManager boardManager;
	@Autowired
	private BoardUtil boardUtil;

	public BoardController() {
	}

	@RequestMapping("board/boardForm.html")
	public String boardForm(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {

		String viewTemplete = "board/boardForm";
		ArrayList<Board> boards = boardUtil.getBoardList();
		modelMap.addAttribute("menuBoards", boards);

		return viewTemplete;
	}

	@RequestMapping("board/boardProcess.html")
	public void boardProcess(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {

		String boardSeq = request.getParameter("boardSeq");
		String boardName = request.getParameter("boardName");

		Board board = new Board();
		board.setBoardName(boardName);
		try {
			this.boardManager.insertBoard(board);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		try {
			response.sendRedirect("boardForm.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}