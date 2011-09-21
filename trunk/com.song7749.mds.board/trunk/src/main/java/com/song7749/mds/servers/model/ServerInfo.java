package com.song7749.mds.servers.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.song7749.base.BaseObject;
import com.song7749.mds.servers.model.type.ServerType;

public class ServerInfo extends BaseObject {
	private Integer serverInfoSeq;
	private Integer serverListSeq;
	private String serverDomainName;
	private Integer serverPort;
	private Integer serverType;

	/**
	 * @return the serverInfoSeq
	 */
	public Integer getServerInfoSeq() {
		return serverInfoSeq;
	}
	/**
	 * @param serverInfoSeq the serverInfoSeq to set
	 */
	public void setServerInfoSeq(Integer serverInfoSeq) {
		this.serverInfoSeq = serverInfoSeq;
	}
	/**
	 * @return the serverListSeq
	 */
	public Integer getServerListSeq() {
		return serverListSeq;
	}
	/**
	 * @param serverListSeq the serverListSeq to set
	 */
	public void setServerListSeq(Integer serverListSeq) {
		this.serverListSeq = serverListSeq;
	}
	/**
	 * @return the serverDomainName
	 */
	public String getServerDomainName() {
		return serverDomainName;
	}
	/**
	 * @param serverDomainName the serverDomainName to set
	 */
	public void setServerDomainName(String serverDomainName) {
		this.serverDomainName = serverDomainName;
	}
	/**
	 * @return the serverPort
	 */
	public Integer getServerPort() {
		return serverPort;
	}
	/**
	 * @param serverPort the serverPort to set
	 */
	public void setServerPort(Integer serverPort) {
		this.serverPort = serverPort;
	}
	/**
	 * @return the serverType
	 */
	public Integer getServerType() {
		return serverType;
	}
	/**
	 * @param serverType the serverType to set
	 */
	public void setServerType(Integer serverType) {
		this.serverType = serverType;
	}
}