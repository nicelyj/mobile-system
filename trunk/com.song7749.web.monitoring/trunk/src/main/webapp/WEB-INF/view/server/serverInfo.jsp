<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp"%>
${javascript }
<form name="frmServerList" method="post" action="/server/serverProcess.html">
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
	<!-- Database 메뉴출력 -->
	<table  class="table-list valid" id="serverListTable">
		<thead>
			<tr>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td></td>
			</tr>
		</tbody>
	</table>
</form>