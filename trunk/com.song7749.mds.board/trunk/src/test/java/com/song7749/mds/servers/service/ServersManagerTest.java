package com.song7749.mds.servers.service;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.song7749.mds.servers.model.ServerInfo;
import com.song7749.mds.servers.model.ServerList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:META-INF/spring/applicationContext*" })
public class ServersManagerTest {
	@Autowired
	private ServersManager serversManager;

	@Test
	public void testInsertServers() {
		ServerList serverList = new ServerList();
		serverList.setServerName("�׽�Ʈ ����");
		serverList.setServerIp("111.111.111");
		serverList.setServerInfo(new ServerInfo());
		serverList.getServerInfo().setServerDomainName("monitoring");
		serverList.getServerInfo().setServerPort(3306);

		Integer processVal = this.serversManager.insertServers(serverList);
		Assert.assertTrue(processVal > 0);
	}

	@Test
	public void testUpdateServers() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteServers() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectServersByServersCommand() {
		fail("Not yet implemented");
	}

}
