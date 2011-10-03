<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp"%>
${javascript }
<form name="frmServerList" method="post" action="/server/serverProcess.html">
	<input type="hidden" id="serverListSeq" value="${serverListSeq }">
	<input type="hidden" id="serverInfoSeq" value="${serverInfoSeq }">
	<input type="hidden" id="serverType" value="${serverList.serverInfo.serverType }">
	<input type="hidden" id="dataType" value="${dataType }">
	<table  class="table-list valid" id="serverListTable">
		<thead>
			<tr>
				<th>SEQ</th>
				<td>${serverList.serverListSeq }</td>
				<th>서버명</th>
				<td>${serverList.serverName }</td>
				<th>IP</th>
				<td>${serverList.serverIp }</td>
			</tr>
			<tr>
				<th>Info SEQ</th>
				<td>${serverList.serverInfo.serverInfoSeq }</td>
				<th>용도</th>
				<td>${serverTypeDescript}</td>
				<th>Domain</th>
				<td>${serverList.serverInfo.serverDomainName } / Port : ${serverList.serverInfo.serverPort }</td>
			</tr>
		</thead>
	</table>
</form>
<span id="monitorMessage"> <font color="red"></font></span>
<c:if test="${serverList.serverInfo.serverType == 1}">
	<!-- javawebServer Database -->
	<table  class="table-list valid" id="serverStateTable">
		<thead>
			<tr>
				<td>
					<a href="javascript:selectView(${serverList.serverInfo.serverType},'systemProcess')">SYSTEM 프로세스 조회</a> |  
					<!-- <a href="javascript:selectView(${serverList.serverInfo.serverType},'webProcess')">WEB 프로세스 조회</a>  -->
				</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td valign="top" id="view"></td>
			</tr>
		</tbody>
	</table>
</c:if>
<c:if test="${serverList.serverInfo.serverType == 3}">
	<!-- mysql Database -->
	<table  class="table-list valid" id="serverStateTable">
		<thead>
			<tr>
				<td>
					<a href="javascript:selectView(${serverList.serverInfo.serverType},'state')">DB 상태 조회</a> | 
					<a href="javascript:selectView(${serverList.serverInfo.serverType},'process')">DB 프로세스 조회</a>
			</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td valign="top" id="view"></td>
			</tr>
		</tbody>
	</table>
</c:if>
<div id="time"></div>