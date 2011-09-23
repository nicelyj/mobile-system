package com.song7749.web.monitoring.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:META-INF/spring/applicationContext*",
		"file:src/main/webapp/WEB-INF/spring/applicationContext*.xml",
		"file:src/main/webapp/WEB-INF/SpringMVC-servlet.xml" })
public class MemberAuthTaskTest {
	@Autowired
	private MemberAuthTask memberAuthTask;

	@Test
	public void testDeleteMemberAuth() {
		this.memberAuthTask.deleteMemberAuth();
	}

}
