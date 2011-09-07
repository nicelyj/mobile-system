package com.song7749.web.monitoring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.song7749.mds.board.model.Board;
import com.song7749.mds.board.model.BoardComment;
import com.song7749.mds.board.model.BoardContents;
import com.song7749.mds.board.model.BoardList;
import com.song7749.mds.board.model.command.BoardListCommand;
import com.song7749.mds.board.service.BoardManager;
import com.song7749.mds.member.model.Member;
import com.song7749.mds.member.model.command.MemberCommand;
import com.song7749.mds.member.service.MemberManager;
import com.song7749.util.PropertiesUtil;
import com.song7749.web.util.Pagination;

@Controller
@RequestMapping("/board")
public class BoardController {
	private Logger logger = Logger.getLogger(getClass());
	@Autowired
	private BoardManager boardManager;
	@Autowired
	private MemberManager memberManager;

	public BoardController() {
	}

	@RequestMapping({ "/boards.html", "/boards.xml" })
	public String BoardListGeneralMemberHandle(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {
		String viewTemplete = "board/boards";

		if (request.getRequestURI().equals("/board/boards.html")) {
			modelMap.addAttribute(
					"javascript",
					"<script type=\"text/javascript\" src=\"/js/common/commonAjax.js\"></script>"
							+ "<script type=\"text/javascript\" src=\"/js/board/board.js\"></script>");
		} else {
			modelMap.clear();
		}

		ArrayList<Board> boards = boardManager.selectBoards(new Board());
		modelMap.addAttribute("boards", boards);
		return viewTemplete;
	}

	@RequestMapping(value = "/boardProcess.html", method = RequestMethod.POST)
	public void boardInsertGeneralMemberHandle(
			@RequestParam(value = "boardName", defaultValue = "", required = true) String boardName,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {

		Board board = new Board();
		board.setBoardName(boardName);
		try {
			this.boardManager.insertBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/boardProcess.html", method = RequestMethod.PUT)
	public void boardUpdateGeneralMemberHandle(
			@RequestParam(value = "boardSeq", defaultValue = "0", required = true) Integer boardSeq,
			@RequestParam(value = "boardName", defaultValue = "", required = true) String boardName,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {

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
	public void boardDeleteGeneralMemberHandle(
			@RequestParam(value = "boardSeq", defaultValue = "0", required = true) Integer boardSeq,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {

		Board board = new Board();
		board.setBoardSeq(boardSeq);
		try {
			this.boardManager.deleteBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/boardList.html")
	public String boardListGeneralMemberHandle(
			@RequestParam(value = "boardSeq", defaultValue = "1", required = false) Integer boardSeq,
			@RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {

		String viewTemplete = "board/boardList";
		Properties boardProperties = PropertiesUtil
				.getProperties("variable.properties");

		// �Խ��� ��ȸ
		Board board = new Board();
		board.setBoardSeq(boardSeq);
		ArrayList<Board> boards = this.boardManager.selectBoards(board);
		board.setBoardName(boards.get(0).getBoardName());

		// ������ ���� �ε�
		Integer listPerPage = Integer.parseInt(boardProperties
				.getProperty("boardlist_page_list_per_page"));
		Integer pageSize = Integer.parseInt(boardProperties
				.getProperty("boardlist_page_size"));

		int limit = listPerPage;
		int offset = (page - 1) * listPerPage;

		// �Խñ� ����Ʈ ��ȸ
		BoardListCommand boardListCommand = new BoardListCommand();
		boardListCommand.setBoardList(new BoardList());
		boardListCommand.getBoardList().setBoardSeq(boardSeq);
		boardListCommand.setLimit(limit);
		boardListCommand.setOffset(offset);

		ArrayList<BoardList> boardLists = this.boardManager
				.selectBoardListsByBoardListCommand(boardListCommand);

		Integer totalRows = 0;

		// ����¡ ó��
		if (boardLists.size() == listPerPage) {// ī��Ʈ ����
			totalRows = pageSize * listPerPage;

		} else if (boardLists.size() > 0) { // ī��Ʈ ���
			totalRows = (page - 1) * listPerPage + boardLists.size();
		} else {// ī��Ʈ ���� �ۼ�
			totalRows = this.boardManager
					.selectCountBoardListByBoardListCommand(boardListCommand);
			int totalPages = (int) Math.ceil((double) totalRows / listPerPage);
			boardListCommand
					.setOffset((Integer) (totalPages - 1) * listPerPage);

			boardLists = this.boardManager
					.selectBoardListsByBoardListCommand(boardListCommand);
		}

		Pagination pagination = new Pagination(0);
		pagination.initialize(totalRows, page, request, listPerPage, pageSize,
				"/board/boardList.html");
		String pagingNavi = pagination.print();

		// �Խ��� ����Ʈ ���� ��� id list ��ȸ
		ArrayList<Integer> memberSeqList = new ArrayList<Integer>();
		if (boardLists.size() > 0) {
			for (BoardList boardList : boardLists) {
				memberSeqList.add(boardList.getMemberSeq());
			}
			MemberCommand memberCommand = new MemberCommand();
			memberCommand.setMember(new Member());
			memberCommand.getMember().setMemberSeqList(memberSeqList);
			ArrayList<Member> memberList = this.memberManager
					.selectMemberListByMemberSearchCommand(memberCommand);
			Map<Integer, String> memberIdMap = new HashedMap();
			for (Member member : memberList) {
				memberIdMap.put(member.getMemberSeq(), member.getMemberId());
			}
			modelMap.addAttribute("memberIdMap", memberIdMap);
		}

		modelMap.addAttribute("board", board);
		modelMap.addAttribute("boardLists", boardLists);
		modelMap.addAttribute("pagingNavi", pagingNavi);

		modelMap.addAttribute(
				"javascript",
				"<script type=\"text/javascript\" src=\"/js/common/commonAjax.js\"></script>"
						+ "<script type=\"text/javascript\" src=\"/js/board/boardList.js\"></script>");
		return viewTemplete;
	}

	@RequestMapping("/boardListDetail.html")
	public String boardListDetailGeneralMemberHandle(
			@RequestParam(value = "boardListSeq", defaultValue = "0", required = true) Integer boardListSeq,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {

		String viewTemplete = "board/boardListDetail";

		// �Խñ� ����Ʈ ��ȸ
		BoardListCommand boardListCommand = new BoardListCommand();
		boardListCommand.setBoardList(new BoardList());
		boardListCommand.getBoardList().setBoardListSeq(boardListSeq);
		ArrayList<BoardList> boardLists = this.boardManager
				.selectBoardListsByBoardListCommand(boardListCommand);
		if (boardLists.size() > 0) {
			modelMap.addAttribute("boardList", boardLists.get(0));
		}

		// �Խñۿ� �ش��ϴ� ȸ����ȸ
		if (boardLists.size() > 0) {
			MemberCommand memberCommand = new MemberCommand();
			memberCommand.setMember(new Member());
			memberCommand.getMember().setMemberSeq(
					boardLists.get(0).getMemberSeq());
			ArrayList<Member> memberList = this.memberManager
					.selectMemberListByMemberSearchCommand(memberCommand);

			if (memberList.size() > 0)
				modelMap.addAttribute("member", memberList.get(0));

			// �Խñ� ��ȸ�� ����
			this.boardManager.updateBoardListReadCount(boardLists.get(0));
		}

		modelMap.addAttribute(
				"javascript",
				"<script type=\"text/javascript\" src=\"/js/common/commonAjax.js\"></script>"
						+ "<script type=\"text/javascript\" src=\"/js/board/boardListDetail.js\"></script>");
		return viewTemplete;
	}

	@RequestMapping({ "/boardListForm.html", "/boardListModifyForm.html" })
	public String boardListFormGeneralMemberHandle(
			@RequestParam(value = "boardSeq", defaultValue = "1", required = true) Integer boardSeq,
			@RequestParam(value = "boardListSeq", defaultValue = "0", required = false) Integer boardListSeq,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {
		String viewTemplete = "board/boardListForm";

		// �Խ��� ��ȸ
		Board board = new Board();
		board.setBoardSeq(boardSeq);
		ArrayList<Board> boards = this.boardManager.selectBoards(board);
		if (boards.size() > 0)
			board.setBoardName(boards.get(0).getBoardName());

		// ������ ��쿡�� ���� �Խó��� ��������.
		if (request.getRequestURI().equals("/board/boardListModifyForm.html")) {
			// ���� �Խñ��ΰ� Ȯ���Ѵ�.
			Member loginMember = (Member) modelMap.get("loginMember");
			ArrayList<BoardList> boardLists = new ArrayList<BoardList>();
			BoardListCommand boardListCommand = new BoardListCommand();
			boardListCommand.setBoardList(new BoardList());
			boardListCommand.getBoardList().setBoardListSeq(boardListSeq);
			boardListCommand.getBoardList().setMemberSeq(
					loginMember.getMemberSeq());
			boardLists = this.boardManager
					.selectBoardListsByBoardListCommand(boardListCommand);

			if (boardLists.size() == 0) {
				try {
					response.sendError(0, "�Խù� �ۼ��ڰ� �ƴմϴ�.");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				modelMap.addAttribute("boardList", boardLists.get(0));
			}
			modelMap.addAttribute("_method", "PUT");
		} else {
			modelMap.addAttribute("_method", "POST");
		}

		modelMap.addAttribute("board", board);
		return viewTemplete;
	}

	@RequestMapping(value = "/boardListProcess.html", method = RequestMethod.POST)
	public void boardListInsertProcessGeneralMemberHandle(
			@RequestParam(value = "title", defaultValue = "", required = true) String boardTitle,
			@RequestParam(value = "contents", defaultValue = "", required = true) String contents,
			@RequestParam(value = "boardListPublicReadYN", defaultValue = "N", required = true) String boardListPublicReadYN,
			@RequestParam(value = "boardSeq", defaultValue = "0", required = true) Integer boardSeq,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {

		Member member = (Member) modelMap.get("loginMember");
		BoardList boardList = new BoardList();
		boardList.setMemberNickName(member.getMemberNickName());
		boardList.setBoardListPublicReadYN(boardListPublicReadYN);
		boardList.setBoardTitle(boardTitle);
		boardList.setBoardContents(new BoardContents());
		boardList.getBoardContents().setContents(contents);
		boardList.setBoardSeq(boardSeq);
		boardList.setBoardCommentCount(0);
		boardList.setBoardReadCount(0);
		boardList.setBoardListDisplayYN("Y");
		boardList.setMemberNickName(member.getMemberNickName());
		boardList.setMemberSeq(member.getMemberSeq());
		boardList.setMemberIp(request.getRemoteAddr());
		this.boardManager.insertBoardList(boardList);
		try {
			response.sendRedirect("/board/boardList.html?boardSeq=" + boardSeq);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/boardListProcess.html", method = RequestMethod.PUT)
	public void boardListInsertUpdateProcessGeneralMemberHandle(
			@RequestParam(value = "title", defaultValue = "", required = true) String boardTitle,
			@RequestParam(value = "contents", defaultValue = "", required = true) String contents,
			@RequestParam(value = "boardListPublicReadYN", defaultValue = "N", required = true) String boardListPublicReadYN,
			@RequestParam(value = "boardListSeq", defaultValue = "0", required = true) Integer boardListSeq,
			@RequestParam(value = "boardSeq", defaultValue = "0", required = true) Integer boardSeq,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {

		Member member = (Member) modelMap.get("loginMember");
		BoardList boardList = new BoardList();
		boardList.setBoardListPublicReadYN(boardListPublicReadYN);
		boardList.setBoardTitle(boardTitle);
		boardList.setBoardContents(new BoardContents());
		boardList.getBoardContents().setContents(contents);
		boardList.setBoardListSeq(boardListSeq);
		this.boardManager.updateBoardList(boardList);
		try {
			response.sendRedirect("/board/boardList.html?boardSeq=" + boardSeq);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/boardListProcess.html", method = RequestMethod.DELETE)
	public void boardListDeleteProcessGeneralMemberHandle(
			@RequestParam(value = "boardListSeq", defaultValue = "0", required = true) Integer boardListSeq,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {

		// ���� �Խñ��ΰ� Ȯ���Ѵ�.
		Member loginMember = (Member) modelMap.get("loginMember");
		ArrayList<BoardList> boardLists = new ArrayList<BoardList>();
		BoardListCommand boardListCommand = new BoardListCommand();
		boardListCommand.setBoardList(new BoardList());
		boardListCommand.getBoardList().setBoardListSeq(boardListSeq);
		boardListCommand.getBoardList()
				.setMemberSeq(loginMember.getMemberSeq());
		boardLists = this.boardManager
				.selectBoardListsByBoardListCommand(boardListCommand);

		if (boardLists.size() == 0) {
			try {
				response.sendError(0, "�Խù� �ۼ��ڰ� �ƴմϴ�.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			BoardList boardList = new BoardList();
			boardList.setBoardListSeq(boardListSeq);
			this.boardManager.deleteBoardList(boardList);
		}
	}

	@RequestMapping("/boardCommentList.xml")
	public String boardCommentList(
			@RequestParam(value = "boardListSeq", defaultValue = "0", required = true) Integer boardListSeq,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {

		modelMap.clear();

		BoardComment boardComment = new BoardComment();
		boardComment.setBoardListSeq(boardListSeq);
		ArrayList<BoardComment> boardComments = this.boardManager
				.selectBoardCommentsByBoardComment(boardComment);

		modelMap.addAttribute("boardComments", boardComments);
		return "";

	}

	@RequestMapping(value = "boardCommentProcess.html", method = RequestMethod.POST)
	public void boardCommentInsertProcessGeneralMemberHandle(
			@RequestParam(value = "boardSeq", defaultValue = "0", required = true) Integer boardSeq,
			@RequestParam(value = "boardListSeq", defaultValue = "0", required = true) Integer boardListSeq,
			@RequestParam(value = "comment", defaultValue = "0", required = true) String comment,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {

		Member member = (Member) modelMap.get("loginMember");
		BoardComment boardComment = new BoardComment();
		boardComment.setBoardListSeq(boardListSeq);
		boardComment.setComment(comment);
		boardComment.setMemberIp(request.getRemoteAddr());
		boardComment.setMemberNickName(member.getMemberNickName());
		boardComment.setMemberSeq(member.getMemberSeq());
		if (this.boardManager.insertBoardCommnet(boardComment) > 0) {

		}
	}

	@RequestMapping(value = "boardCommentProcess.xml", method = RequestMethod.DELETE)
	public String boardCommentDeleteProcessGeneralMemberHandle(
			@RequestParam(value = "boardCommentSeq", defaultValue = "0", required = true) Integer boardCommentSeq,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {

		// ȸ������ ��ȸ
		Member member = (Member) modelMap.get("loginMember");

		BoardComment boardComment = new BoardComment();
		boardComment.setBoardCommentSeq(boardCommentSeq);
		ArrayList<BoardComment> boardComments = this.boardManager
				.selectBoardCommentsByBoardComment(boardComment);

		modelMap.clear();
		if (boardComments.size() == 0) {
			modelMap.addAttribute("respondMessage", "���� �Խ� �ڸ�Ʈ�� �����ϴ�.");
		} else {
			if (boardComments.get(0).getMemberSeq()
					.equals(member.getMemberSeq())) {
				if (this.boardManager.deleteBoardComment(boardComment) > 0)
					boardListComentCountUpdate(boardComments.get(0)
							.getBoardListSeq());

				modelMap.addAttribute("respondMessage", "�����Ǿ����ϴ�.");
			} else {
				modelMap.addAttribute("respondMessage", "���� �Խñ��� �ƴմϴ�.");
			}
		}

		return "";
	}

	private void boardListComentCountUpdate(Integer boardListSeq) {
		BoardComment boardCommentForboardCount = new BoardComment();
		boardCommentForboardCount.setBoardListSeq(boardListSeq);
		Integer boardcommentCount = this.boardManager
				.selectCountBoardCommentByBoardComment(boardCommentForboardCount);

		BoardList boardList = new BoardList();
		boardList.setBoardListSeq(boardListSeq);
		boardList.setBoardCommentCount(boardcommentCount);
		this.boardManager.updateBoardList(boardList);
	}
}