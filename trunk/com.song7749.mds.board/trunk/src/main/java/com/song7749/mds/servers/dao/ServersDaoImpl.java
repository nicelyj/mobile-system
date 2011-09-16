package com.song7749.mds.servers.dao;

import java.util.ArrayList;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.song7749.mds.servers.model.ServerList;
import com.song7749.mds.servers.model.command.ServersCommand;

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

	@Override
	public Integer updateServerList(ServerList serverList) {
		Integer processVal = (Integer) this.boardmaster.update(
				"Servers.updateServerList", serverList);

		boardslave.queryForObject("Servers.dummySql"); // cache flushed
		return processVal;
	}

	@Override
	public Integer updateServerInfo(ServerList serverList) {
		Integer processVal = (Integer) this.boardmaster.update(
				"Servers.updateServerInfo", serverList);

		boardslave.queryForObject("Servers.dummySql"); // cache flushed
		return processVal;
	}

	@Override
	public Integer deleteServerList(ServerList serverList) {
		Integer processVal = (Integer) this.boardmaster.update(
				"Servers.deleteServerList", serverList);

		boardslave.queryForObject("Servers.dummySql"); // cache flushed
		return processVal;
	}

	@Override
	public Integer deleteServerInfo(ServerList serverList) {
		Integer processVal = (Integer) this.boardmaster.update(
				"Servers.deleteServerInfo", serverList);

		boardslave.queryForObject("Servers.dummySql"); // cache flushed
		return processVal;
	}

	@Override
	public ArrayList<ServerList> selectServersByServersCommand(
			ServersCommand serversCommand) {
		return (ArrayList<ServerList>) this.boardslave.queryForList("Servers.selectServersByServersCommand", serversCommand);
	}

}