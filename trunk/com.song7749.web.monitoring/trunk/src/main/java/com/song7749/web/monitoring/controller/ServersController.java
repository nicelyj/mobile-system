package com.song7749.web.monitoring.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.song7749.mds.board.model.Board;
import com.song7749.mds.board.service.BoardManager;
import com.song7749.mds.member.service.MemberManager;
import com.song7749.mds.servers.model.ServerInfo;
import com.song7749.mds.servers.model.ServerList;
import com.song7749.mds.servers.model.command.ServersCommand;
import com.song7749.mds.servers.service.ServersManager;

@Controller
@RequestMapping("/server")
public class ServersController {
	private Logger logger = Logger.getLogger(getClass());
	@Autowired
	private ServersManager serversManager;
	@Autowired
	private MemberManager memberManager;
	
	@RequestMapping({ "/serverList.html", "/serverList.xml"})
	public String serverListGeneralMemberHandle(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {
		String viewTemplete = "server/serverList";
		if (request.getRequestURI().equals("/server/serverList.html")) {
			modelMap.addAttribute(
				"javascript",
				"<script type=\"text/javascript\" src=\"/js/common/commonAjax.js\"></script>"+
				"<script type=\"text/javascript\" src=\"/js/server/serverList.js\"></script>"
			);
		} else {
			modelMap.clear();
		}

		ServersCommand serversCommand = new ServersCommand();
		ArrayList<ServerList> serverLists = this.serversManager.selectServersByServersCommand(serversCommand);
		modelMap.addAttribute("serverLists", serverLists);
		return viewTemplete;
	}

	@RequestMapping(value = "/serverProcess.html", method = RequestMethod.POST)
	public void serverInsertGeneralMemberHandle(
			@RequestParam(value = "serverName", defaultValue = "", required = true) String serverName,
			@RequestParam(value = "serverIp", defaultValue = "", required = true) String serverIp,
			@RequestParam(value = "serverDomainName", defaultValue = "", required = true) String serverDomainName,
			@RequestParam(value = "serverPort", defaultValue = "35001", required = true) Integer serverPort,
			@RequestParam(value = "serverType", defaultValue = "1", required = true) Integer serverType,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {

		ServerList serverList = new ServerList();
		serverList.setServerName(serverName);
		serverList.setServerIp(serverIp);
		serverList.setServerInfo(new ServerInfo());
		serverList.getServerInfo().setServerDomainName(serverDomainName);
		serverList.getServerInfo().setServerPort(serverPort);
		serverList.getServerInfo().setServerType(serverType);
		
		try {
			this.serversManager.insertServers(serverList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "/serverProcess.html", method = RequestMethod.PUT)
	public void serverUpdateGeneralMemberHandle(
			@RequestParam(value = "serverListSeq", defaultValue = "0", required = true) Integer serverListSeq,
			@RequestParam(value = "serverInfoSeq", defaultValue = "0", required = true) Integer serverInfoSeq,
			@RequestParam(value = "serverName", defaultValue = "", required = true) String serverName,
			@RequestParam(value = "serverIp", defaultValue = "", required = true) String serverIp,
			@RequestParam(value = "serverDomainName", defaultValue = "", required = true) String serverDomainName,
			@RequestParam(value = "serverPort", defaultValue = "35001", required = true) Integer serverPort,
			@RequestParam(value = "serverType", defaultValue = "1", required = true) Integer serverType,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {

		ServerList serverList = new ServerList();
		serverList.setServerListSeq(serverListSeq);
		serverList.setServerName(serverName);
		serverList.setServerIp(serverIp);
		serverList.setServerInfo(new ServerInfo());
		serverList.getServerInfo().setServerInfoSeq(serverInfoSeq);
		serverList.getServerInfo().setServerDomainName(serverDomainName);
		serverList.getServerInfo().setServerPort(serverPort);
		serverList.getServerInfo().setServerType(serverType);
		try {
			this.serversManager.updateServers(serverList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/serverProcess.html", method = RequestMethod.DELETE)
	public void serverDeleteGeneralMemberHandle(
			@RequestParam(value = "serverListSeq", defaultValue = "0", required = true) Integer serverListSeq,
			@RequestParam(value = "serverInfoSeq", defaultValue = "0", required = true) Integer serverInfoSeq,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {

		ServerList serverList = new ServerList();
		serverList.setServerListSeq(serverListSeq);
		serverList.setServerInfo(new ServerInfo());
		serverList.getServerInfo().setServerInfoSeq(serverInfoSeq);
		try {
			this.serversManager.deleteServers(serverList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String serverInfoGeneralMemberHandle(
			@RequestParam(value = "serverListSeq", defaultValue = "0", required = true) Integer serverListSeq,
			@RequestParam(value = "serverInfoSeq", defaultValue = "0", required = true) Integer serverInfoSeq,
			HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {
		String viewTemplete = "server/serverList";

		ServersCommand serversCommand = new ServersCommand();
		serversCommand.setServerList(new ServerList());
		serversCommand.getServerList().setServerListSeq(serverListSeq);
		serversCommand.setServerInfo(new ServerInfo());
		serversCommand.getServerInfo().setServerInfoSeq(serverInfoSeq);
		ArrayList<ServerList> serverLists = this.serversManager.selectServersByServersCommand(serversCommand);

		modelMap.addAttribute("serverLists", serverLists);
		modelMap.addAttribute(
				"javascript",
				"<script type=\"text/javascript\" src=\"/js/common/commonAjax.js\"></script>"+
				"<script type=\"text/javascript\" src=\"/js/server/serverInfo.js\"></script>"
			);
		return viewTemplete;
	}
}