package com.song7749.web.monitoring.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.song7749.mds.member.service.MemberManager;
import com.song7749.mds.servers.model.ServerInfo;
import com.song7749.mds.servers.model.ServerList;
import com.song7749.mds.servers.model.command.ServersCommand;
import com.song7749.mds.servers.model.type.ServerType;
import com.song7749.mds.servers.service.ServersManager;
import com.song7749.util.DatabaseStateUtil;

@Controller
@RequestMapping("/server")
public class ServersController {
	private Logger logger = Logger.getLogger(getClass());
	@Autowired
	private ServersManager serversManager;
	@Autowired
	private MemberManager memberManager;

	@RequestMapping({ "/serverList.html", "/serverList.xml" })
	public String serverListGeneralMemberHandle(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {
		String viewTemplete = "server/serverList";
		if (request.getRequestURI().equals("/server/serverList.html")) {
			HashedMap serverTypeMap = new HashedMap();
			for (ServerType serverType : ServerType.values()) {
				serverTypeMap.put(serverType.getServerTypeCode(),
						serverType.getSeverTypeDescription());
			}
			modelMap.addAttribute("serverTypeMapList", serverTypeMap.keySet());
			modelMap.addAttribute("serverTypeMap", serverTypeMap);

			modelMap.addAttribute(
					"javascript",
					"<script type=\"text/javascript\" src=\"/js/common/commonAjax.js\"></script>"
							+ "<script type=\"text/javascript\" src=\"/js/server/serverList.js\"></script>");
		} else {
			modelMap.clear();
		}

		ServersCommand serversCommand = new ServersCommand();
		ArrayList<ServerList> serverLists = this.serversManager
				.selectServersByServersCommand(serversCommand);
		modelMap.addAttribute("serverLists", serverLists);
		return viewTemplete;
	}

	@RequestMapping(value = "/serverProcess.html", method = RequestMethod.POST)
	public void serverInsertGeneralMemberHandle(
			@RequestParam(value = "serverName", defaultValue = "", required = true) String serverName,
			@RequestParam(value = "serverIp", defaultValue = "", required = true) String serverIp,
			@RequestParam(value = "serverDomainName", defaultValue = "", required = true) String serverDomainName,
			@RequestParam(value = "serverPort", defaultValue = "0", required = true) Integer serverPort,
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

	@RequestMapping("/serverInfo.html")
	public String serverInfoGeneralMemberHandle(
			@RequestParam(value = "serverListSeq", defaultValue = "0", required = true) Integer serverListSeq,
			@RequestParam(value = "serverInfoSeq", defaultValue = "0", required = true) Integer serverInfoSeq,
			@RequestParam(value = "dataType", defaultValue = "state", required = true) String dataType,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {
		String viewTemplete = "server/serverInfo";

		ServersCommand serversCommand = new ServersCommand();
		serversCommand.setServerList(new ServerList());

		if (serverListSeq > 0)
			serversCommand.getServerList().setServerListSeq(serverListSeq);

		serversCommand.setServerInfo(new ServerInfo());
		if (serverInfoSeq > 0)
			serversCommand.getServerInfo().setServerInfoSeq(serverInfoSeq);

		ArrayList<ServerList> serverLists = this.serversManager
				.selectServersByServersCommand(serversCommand);

		ServerList serverList = null;
		String serverTypeDescript = null;
		if (serverLists.size() > 0) {
			serverList = serverLists.get(0);
			serverTypeDescript = ServerType
					.getServerTypeDescriptionFromCode(serverList
							.getServerInfo().getServerType());
		}
		modelMap.addAttribute("serverList", serverList);
		modelMap.addAttribute("serverTypeDescript", serverTypeDescript);
		modelMap.addAttribute("dataType", dataType);
		modelMap.addAttribute("serverListSeq", serverListSeq);
		modelMap.addAttribute("serverInfoSeq", serverInfoSeq);
		modelMap.addAttribute(
				"javascript",
				"<script type=\"text/javascript\" src=\"/js/common/commonAjax.js\"></script>"
						+ "<script type=\"text/javascript\" src=\"/js/server/serverInfo.js\"></script>");
		return viewTemplete;
	}

	@RequestMapping({ "/serviceInfoProcessList.xml",
			"/serviceInfoProcessList.html" })
	public String serviceInfoProcessListGeneralMemberHandle(
			@RequestParam(value = "serverListSeq", defaultValue = "0", required = true) Integer serverListSeq,
			@RequestParam(value = "serverInfoSeq", defaultValue = "0", required = true) Integer serverInfoSeq,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {
		String viewTemplete = "server/serverInfo";

		// xml �� ��� modelmap �� clear �Ѵ�.
		if (request.getRequestURI().indexOf("xml") > 0) {
			modelMap.clear();
		}

		return viewTemplete;
	}

	@RequestMapping({ "/serverInfoDatabaseService.xml",
			"/serverInfoDatabaseService.html" })
	public String serverInfoDatabaseServiceGeneralMemberHandle(
			@RequestParam(value = "serverListSeq", defaultValue = "0", required = true) Integer serverListSeq,
			@RequestParam(value = "serverInfoSeq", defaultValue = "0", required = true) Integer serverInfoSeq,
			@RequestParam(value = "dataType", defaultValue = "state", required = true) String dataType,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {

		String viewTemplete = "server/serverInfo";

		// xml �� ��� modelmap �� clear �Ѵ�.
		if (request.getRequestURI().indexOf("xml") > 0) {
			modelMap.clear();
		}

		// ���� ������ ȹ����
		ServersCommand serversCommand = new ServersCommand();
		if (serverListSeq > 0)
			serversCommand.getServerList().setServerListSeq(serverListSeq);

		serversCommand.setServerInfo(new ServerInfo());
		if (serverInfoSeq > 0)
			serversCommand.getServerInfo().setServerInfoSeq(serverInfoSeq);

		ArrayList<ServerList> serverLists = this.serversManager
				.selectServersByServersCommand(serversCommand);

		ServerList serverList = null;

		if (serverLists.size() > 0) {
			serverList = serverLists.get(0);
		} else {
			return viewTemplete;
		}

		// db ���� �����´�.
		ApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(request.getSession()
						.getServletContext());
		SqlMapClientTemplate dataSource = (SqlMapClientTemplate) context
				.getBean("sqlMapClientTemplate."
						+ serverList.getServerInfo().getServerDomainName());

		// db state
		if (dataType.equals("state")) {
			try {
				modelMap.addAttribute("list",
						DatabaseStateUtil.getMysqlDatabaseState(dataSource));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// db process
		else {
			try {
				modelMap.addAttribute("list",
						DatabaseStateUtil.getMysqlDatebaseProcess(dataSource));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return viewTemplete;
	}

	@RequestMapping({ "/serverInfoJavaWebSevice.xml",
			"/serverInfoJavaWebSevice.html" })
	public String serverInfoJavaWebServiceGeneralMemberHandle(
			@RequestParam(value = "serverListSeq", defaultValue = "0", required = true) Integer serverListSeq,
			@RequestParam(value = "serverInfoSeq", defaultValue = "0", required = true) Integer serverInfoSeq,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {
		String viewTemplete = "server/serverInfo";

		return viewTemplete;
	}

	@RequestMapping({ "/serverInfoPhpWebSevice.xml",
			"/serverInfoPhpWebSevice.html" })
	public String serverInfoPhpWebServiceGeneralMemberHandle(
			@RequestParam(value = "serverListSeq", defaultValue = "0", required = true) Integer serverListSeq,
			@RequestParam(value = "serverInfoSeq", defaultValue = "0", required = true) Integer serverInfoSeq,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {
		String viewTemplete = "server/serverInfo";

		return viewTemplete;
	}
}