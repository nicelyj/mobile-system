package com.song7749.mds.servers.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.song7749.mds.servers.dao.ServersDao;
import com.song7749.mds.servers.model.ServerList;
import com.song7749.mds.servers.model.command.ServersCommand;

public class ServersManagerImpl implements ServersManager {
	@Autowired
	private ServersDao serversDao;

	public void setServersDao(ServersDao serversDao) {
		this.serversDao = serversDao;
	}

	@Override
	@Transactional
	public Integer insertServers(ServerList serverList) {
		Integer processVal = this.serversDao.insertServerList(serverList);
		processVal += this.serversDao.insertServerInfo(serverList);
		return processVal;
	}

	@Override
	public Integer updateServers(ServerList serverList) {
		Integer processVal = this.serversDao.updateServerList(serverList);
		processVal += this.serversDao.updateServerInfo(serverList);
		return processVal;
	}

	@Override
	public Integer deleteServers(ServerList serverList) {
		Integer processVal = this.serversDao.deleteServerInfo(serverList);
		processVal += this.serversDao.deleteServerList(serverList);
		return processVal;
	}

	@Override
	public ArrayList<ServerList> selectServersByServersCommand(
			ServersCommand serversCommand) {
		return this.serversDao.selectServersByServersCommand(serversCommand);
	}

}
