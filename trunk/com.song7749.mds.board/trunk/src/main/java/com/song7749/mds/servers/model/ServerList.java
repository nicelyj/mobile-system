package com.song7749.mds.servers.model;

import com.song7749.base.BaseObject;

public class ServerList extends BaseObject {
	private Integer serverListSeq;
	private String serverName;
	private String serverIp;

	private ServerInfo serverInfo;

	/**
	 * @return the serverListSeq
	 */
	public Integer getServerListSeq() {
		return serverListSeq;
	}

	/**
	 * @param serverListSeq
	 *            the serverListSeq to set
	 */
	public void setServerListSeq(Integer serverListSeq) {
		this.serverListSeq = serverListSeq;
	}

	/**
	 * @return the serverName
	 */
	public String getServerName() {
		return serverName;
	}

	/**
	 * @param serverName
	 *            the serverName to set
	 */
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	/**
	 * @return the serverIp
	 */
	public String getServerIp() {
		return serverIp;
	}

	/**
	 * @param serverIp
	 *            the serverIp to set
	 */
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

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

}
