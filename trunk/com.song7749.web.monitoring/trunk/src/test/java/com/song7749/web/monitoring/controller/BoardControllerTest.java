package com.song7749.web.monitoring.controller;

import static org.junit.Assert.fail;
import junit.framework.Assert;

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

	@Autowired
	private BoardController boardController;

	@Before
	public void setUp() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		adapter = new AnnotationMethodHandlerAdapter();
	}

	@Test
	public void testBoardListGeneralMemberHandle() throws Exception {

		request.setRequestURI("/board/boards.xml");
		request.setMethod("GET");

		ModelAndView mv = adapter.handle(request, response, boardController);
		// HTTP 검사
		Assert.assertEquals(200, response.getStatus());
		// respondText 검사
		Assert.assertNotNull(response.getContentAsString());
		System.out.println(response.getContentAsString());
		try {
			new AnnotationMethodHandlerAdapter().handle(request, response,
					boardController);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testBoardInsertGeneralMemberHandle() {
		fail("Not yet implemented");
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
