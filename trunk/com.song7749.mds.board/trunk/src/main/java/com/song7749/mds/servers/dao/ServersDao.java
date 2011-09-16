package com.song7749.mds.servers.dao;

import java.util.ArrayList;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.song7749.base.Dao;
import com.song7749.mds.servers.model.ServerList;
import com.song7749.mds.servers.model.command.ServersCommand;

public interface ServersDao extends Dao {
	/**
	 * @param boardmaster
	 *            the boardmaster to set
	 */
	public void setBoardmaster(SqlMapClientTemplate boardmaster);

	/**
	 * @param boardslave
	 *            the boardslave to set
	 */
	public void setBoardslave(SqlMapClientTemplate boardslave);

	public Integer insertServerList(ServerList serverList);

	public Integer insertServerInfo(ServerList serverList);

	public Integer updateServerList(ServerList serverList);

	public Integer updateServerInfo(ServerList serverList);

	public Integer deleteServerList(ServerList serverList);

	public Integer deleteServerInfo(ServerList serverList);

	public ArrayList<ServerList> selectServersByServersCommand(
			ServersCommand serversCommand);

}
