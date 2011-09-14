package com.song7749.mds.servers.dao;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.song7749.mds.servers.model.ServerList;

public class ServersDaoImpl implements ServersDao {
	private SqlMapClientTemplate boardmaster;
	private SqlMapClientTemplate boardslave;

	/**
	 * @param boardmaster
	 *            the boardmaster to set
	 */
	public void setBoardmaster(SqlMapClientTemplate boardmaster) {
		this.boardmaster = boardmaster;
	}

	/**
	 * @param boardslave
	 *            the boardslave to set
	 */
	public void setBoardslave(SqlMapClientTemplate boardslave) {
		this.boardslave = boardslave;
	}

	@Override
	public Integer insertServerList(ServerList serverList) {
		Integer processVal = (Integer) this.boardmaster.insert(
				"Servers.insertServerList", serverList);

		boardslave.queryForObject("Servers.dummySql"); // cache flushed
		return processVal;
	}

	@Override
	public Integer insertServerInfo(ServerList serverList) {
		Integer processVal = (Integer) this.boardmaster.insert(
				"Servers.insertServerInfo", serverList);

		boardslave.queryForObject("Servers.dummySql"); // cache flushed
		return processVal;
	}

}
