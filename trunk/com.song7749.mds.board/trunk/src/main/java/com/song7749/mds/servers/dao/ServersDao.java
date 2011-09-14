package com.song7749.mds.servers.dao;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.song7749.base.Dao;
import com.song7749.mds.servers.model.ServerList;

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

}
