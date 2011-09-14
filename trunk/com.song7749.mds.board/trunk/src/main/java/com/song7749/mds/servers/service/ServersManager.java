package com.song7749.mds.servers.service;

import java.util.ArrayList;

import com.song7749.mds.servers.dao.ServersDao;
import com.song7749.mds.servers.model.ServerList;
import com.song7749.mds.servers.model.command.ServersCommand;

public interface ServersManager {
	public void setServersDao(ServersDao serversDao);

	public Integer insertServers(ServerList serverList);

	public Integer updateServers(ServerList serverList);

	public Integer deleteServers(ServerList serverList);

	public ArrayList<ServerList> selectServersByServersCommand(
			ServersCommand serversCommand);
}
