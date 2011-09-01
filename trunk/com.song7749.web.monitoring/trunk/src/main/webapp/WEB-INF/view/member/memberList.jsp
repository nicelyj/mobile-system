<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp"%>
${javascript }
<table class="table-list valid">
	<thead>
		<tr >
			<th>회원번호</th>
			<th>회원ID</th>
			<th>회원이름(회원닉네임)</th>
			<th>회원메일</th>
			<th>전화번호</th>
			<th>핸드폰번호</th>
			<th>관리</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${fn:length(memberList)>0}">
				<c:forEach var="member" items="${memberList }">
					<tr >
						<td>${member.memberSeq }</td>
						<td>${member.memberId }</td>
						<td>${member.memberName } (${member.memberNickName })</td>
						<td>${member.memberEmail }</td>
						<td>${member.memberDetail.memberPhoneNumber }</td>
						<td>${member.memberDetail.memberMobileNumber }</td>
						<td>
							<input type="button" name="updateMember" value="수정" onclick="updateMember(${member.memberSeq })">
							<input type="button" name="deleteMember" value="삭제" onclick="deleteMember(${member.memberSeq })">
						</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
			<tr >
				<td colspan="7"></td>
			</tr>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>