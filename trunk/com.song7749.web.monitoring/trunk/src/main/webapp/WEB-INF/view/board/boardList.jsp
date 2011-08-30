<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp"%>
${javascript }
<form name="frmInsertBoard" action="/board/boardProcess.html">
	<table  class="table-list valid">
		<thead>
			<tr>
				<th>게시판 번호</th>
				<th>게시판 명</th>
				<th>관리</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="board" items="${boards }">
				<tr>
					<td width="200"> ${board.boardSeq } </td>
					<td width="200">
						<input type="hidden" name="boardSeq" value="${board.boardSeq }" />
						<input type="text" name="boardName" value="${board.boardName }" />
					</td>
					<td><input type="button" value="수정" name="updateBoard"/> <input type="button" value="삭제" name="deleteBoard"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</form>