package com.song7749.web.monitoring.main;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.song7749.mds.board.model.Board;
import com.song7749.mds.board.service.BoardManager;

@Controller
public class MainController {
	@Autowired
	private BoardManager boardManager;

	public MainController() {

	}

	@RequestMapping("/index.html")
	public String mainIndex(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {

		ArrayList<Board> boards = boardManager.selectBoards(new Board());
		String viewTemplete = "main/index";

		modelMap.addAttribute("menuBoards", boards);
		return viewTemplete;
	}
}
