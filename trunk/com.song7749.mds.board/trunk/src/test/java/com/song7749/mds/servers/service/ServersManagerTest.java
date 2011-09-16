package com.song7749.mds.servers.service;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.song7749.mds.servers.model.ServerInfo;
import com.song7749.mds.servers.model.ServerList;
import com.song7749.mds.servers.model.command.ServersCommand;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:META-INF/spring/applicationContext*" })
public class ServersManagerTest {
	@Autowired
	private ServersManager serversManager;
	private static ServerList staticServerList;
	
	
	@Test
	public void testInsertServers() {
		ServerList serverList = new ServerList();
		serverList.setServerName("테스트 서버");
		serverList.setServerIp("111.111.111");
		serverList.setServerInfo(new ServerInfo());
		serverList.getServerInfo().setServerDomainName("monitoring");
		serverList.getServerInfo().setServerPort(3306);

		Integer processVal = this.serversManager.insertServers(serverList);
		Assert.assertTrue(processVal > 0);
		ServersManagerTest.staticServerList = serverList;
	}

	@Test
	public void testUpdateServers() {
		ServerList serverList = ServersManagerTest.staticServerList;
		serverList.setServerName("테스트 서버2");
		serverList.getServerInfo().setServerDomainName("monitoring 2");
		Integer processVal = this.serversManager.updateServers(serverList);
		Assert.assertTrue(processVal>0);
		ServersManagerTest.staticServerList = serverList;
	}

	@Test
	public void testSelectServersByServersCommand() {
		ServersCommand serversCommand = new ServersCommand();
		serversCommand.setServerList(staticServerList);
		ArrayList<ServerList> serverLists = this.serversManager.selectServersByServersCommand(serversCommand);
		Assert.assertTrue(serverLists.size()>0);
	}

	@Test
	public void testDeleteServers() {
		ServerList serverList = ServersManagerTest.staticServerList;
		Integer processVal = this.serversManager.deleteServers(serverList);
		Assert.assertTrue(processVal>0);
	}
}
