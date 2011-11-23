package com.song7749.web.monitoring.controller;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:META-INF/spring/applicationContext*",
		"file:src/main/webapp/WEB-INF/spring/applicationContext*.xml",
		"file:src/main/webapp/WEB-INF/SpringMVC-servlet.xml" })
public class BoardControllerTest {
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private AnnotationMethodHandlerAdapter adapter;
	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private LoginController loginController;
	@Autowired
	private BoardController boardController;

	@Before
	public void setUp() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		adapter = new AnnotationMethodHandlerAdapter();

		// 로그인 처리
		request.setRequestURI("/login/loginProcess.html");
		request.setParameter("memberId", "song7749");
		request.setParameter("memberPassword", "11111111");
		try {
			ModelAndView mv = adapter
					.handle(request, response, loginController);
			logger.debug("==========================================================");
			logger.debug("test start : login check");
			logger.debug(response.getStatus() + " "
					+ response.getContentAsString());
			logger.debug("==========================================================");
			request.setCookies(response.getCookies());

			Assert.assertEquals(200, response.getStatus());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testBoardListGeneralMemberHandle() throws Exception {
		request.setRequestURI("/board/boards.html");
		request.setMethod("GET");

		ModelAndView mv = adapter.handle(request, response, boardController);

		// HTTP 검사
		Assert.assertEquals(200, response.getStatus());
		// 로그인 통과 검사
		Assert.assertTrue(mv.getViewName().equals("board/boards"));
		// respondText 검사
		Assert.assertNotNull(response.getContentAsString());
	}

	@Test
	public void testBoardInsertGeneralMemberHandle() throws Exception {
		request.setRequestURI("/board/boards.html");
		request.setMethod("GET");

		ModelAndView mv = adapter.handle(request, response, boardController);

		// HTTP 검사
		Assert.assertEquals(200, response.getStatus());
		// 로그인 통과 검사
		Assert.assertTrue(mv.getViewName().equals("board/boards"));
		// respondText 검사
		Assert.assertNotNull(response.getContentAsString());

	}

	@Test
	public void testBoardUpdateGeneralMemberHandle() {
		fail("Not yet implemented");
	}

	@Test
	public void testBoardDeleteGeneralMemberHandle() {
		fail("Not yet implemented");
	}

	@Test
	public void testBoardListGeneralMemberHandle1() {
		fail("Not yet implemented");
	}

	@Test
	public void testBoardListDetailGeneralMemberHandle() {
		fail("Not yet implemented");
	}

	@Test
	public void testBoardListFormGeneralMemberHandle() {
		fail("Not yet implemented");
	}

	@Test
	public void testBoardListInsertProcessGeneralMemberHandle() {
		fail("Not yet implemented");
	}

	@Test
	public void testBoardListInsertUpdateProcessGeneralMemberHandle() {
		fail("Not yet implemented");
	}

	@Test
	public void testBoardListDeleteProcessGeneralMemberHandle() {
		fail("Not yet implemented");
	}

	@Test
	public void testBoardCommentList() {
		fail("Not yet implemented");
	}

	@Test
	public void testBoardCommentInsertProcessGeneralMemberHandle() {
		fail("Not yet implemented");
	}

	@Test
	public void testBoardCommentDeleteProcessGeneralMemberHandle() {
		fail("Not yet implemented");
	}

}
