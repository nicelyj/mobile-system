<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp"%>
${javascript }
<form name="frmServerList" method="post" action="/server/serverProcess.html">
	<table  class="table-list valid" id="serverListTable">
		<thead>
			<tr>
				<th>SEQ</th>
				<th>서버명</th>
				<th>IP</th>
				<th>Domain</th>
				<th>Port</th>
				<th>관리</th>
			</tr>
		</thead>
		<tbody>
		<c:choose>
			<c:when test="${fn:length(serverLists)>0}">
				<c:forEach var="serverList" items="${serverLists }">
					<tr>
						<td width="150"> 
							${serverList.serverListSeq } 
							<input type="hidden" name="serverListSeq" value="${serverList.serverListSeq }" />
							<input type="hidden" name="serverInfoSeq" value="${serverList.serverInfo.serverInfoSeq }" />
						</td>
						<td width="150">
							<input type="text" name="serverName" value="${serverList.serverName }" />
						</td>
						<td width="150">
							<input type="text" name="serverIp" value="${serverList.serverIp }" />
						</td>
						<td width="150">
							<input type="text" name="serverDomainName" value="${serverList.serverInfo.serverDomainName }" />
						</td>
						<td width="150">
							<input type="text" name="serverPort" value="${serverList.serverInfo.serverPort }" />
						</td>
						<td>
							<input type="button" value="수정" name="updateServerList"/> 
							<input type="button" value="삭제" name="deleteServerList"/>
						</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td width="150"></td>
					<td width="150"></td>
					<td width="150"></td>
					<td width="150"></td>
					<td width="150"></td>
					<td></td>
				</tr>
			</c:otherwise>
		</c:choose>
		</tbody>
	</table>
</form>