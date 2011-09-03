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
import com.song7749.web.monitoring.base.BaseController;

@Controller
public class MainController extends BaseController{

	public MainController() {

	}

	@RequestMapping("/index.html")
	public String mainIndex(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {

		String viewTemplete = "main/index";
		return viewTemplete;
	}
}
