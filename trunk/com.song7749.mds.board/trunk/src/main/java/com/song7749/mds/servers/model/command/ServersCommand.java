package com.song7749.mds.servers.model.command;

import com.song7749.mds.servers.model.ServerInfo;
import com.song7749.mds.servers.model.ServerList;

public class ServersCommand {
	private ServerInfo serverInfo;
	private ServerList serverList;

	/**
	 * @return the serverInfo
	 */
	public ServerInfo getServerInfo() {
		return serverInfo;
	}

	/**
	 * @param serverInfo
	 *            the serverInfo to set
	 */
	public void setServerInfo(ServerInfo serverInfo) {
		this.serverInfo = serverInfo;
	}

	/**
	 * @return the serverList
	 */
	public ServerList getServerList() {
		return serverList;
	}

	/**
	 * @param serverList
	 *            the serverList to set
	 */
	public void setServerList(ServerList serverList) {
		this.serverList = serverList;
	}

}
