<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp"%>
${javascript }
<span id="selectServerTypeSpan" style="display: none;">
	<select name="serverType">
		<c:forEach var="servserTypeMapKey" items="${serverTypeMapList }">
			<option value="${servserTypeMapKey }">${serverTypeMap[servserTypeMapKey] }</option>
		</c:forEach>
	</select>
</span>
<form name="frmServerList" method="post" action="/server/serverProcess.html">
	<table  class="table-list valid" id="serverListTable">
		<thead>
			<tr>
				<th>SEQ</th>
				<th>서버명</th>
				<th>IP</th>
				<th>Type</th>
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
						<td> 
							${serverList.serverListSeq } 
							<input type="hidden" name="serverListSeq" value="${serverList.serverListSeq }" />
							<input type="hidden" name="serverInfoSeq" value="${serverList.serverInfo.serverInfoSeq }" />
						</td>
						<td>
							<input type="text" name="serverName" value="${serverList.serverName }" />
						</td>
						<td>
							<input type="text" name="serverIp" value="${serverList.serverIp }" />
						</td>
						<td>
							<select name="serverType">
								<c:forEach var="servserTypeMapKey" items="${serverTypeMapList }">
									<option value="${servserTypeMapKey }" <c:if test="${serverList.serverInfo.serverType==servserTypeMapKey }">selected</c:if>>${serverTypeMap[servserTypeMapKey] }</option>
								</c:forEach>
							</select>
						</td>
						<td>
							<input type="text" name="serverDomainName" value="${serverList.serverInfo.serverDomainName }" />
						</td>
						<td>
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
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</c:otherwise>
		</c:choose>
		</tbody>
	</table>
</form>