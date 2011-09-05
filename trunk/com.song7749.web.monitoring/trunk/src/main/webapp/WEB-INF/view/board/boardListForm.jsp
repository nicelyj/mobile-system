<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp"%>
${javascript }
<form name="frmInsertBoard" method="post" action="/board/boardListProcess.html">
<input type="hidden" name="_method" value="${_method}" />
<input type="hidden" name="boardListSeq" value="${boardList.boardListSeq }" />
<input type="hidden" name="boardSeq" value="${board.boardSeq }" />
<input type="hidden" name="boardName" value="${board.boardName }" />
	${board.boardName }
	<table  class="table-list valid">
		<tbody>
			<c:if test="${boardList.boardListSeq >0}">
				<tr>
					<th width="100"> 글번호 </th>
					<td>${boardList.boardListSeq }</td>
				</tr>
			</c:if>
			<tr>
				<th width="100"> 제목 </th>
				<td><input type="text" name="title" value="${boardList.boardTitle }" size="80" /></td>
			</tr>
			<tr>
				<th width="100"> 닉네임 </th>
				<td width="100"><input type="text" name="memberNickName" value="${boardList.memberNickName }" readonly="readonly"/></td>
			</tr>
			<tr>
				<th width="100"> 비밀글 </th>
				
				<td width="100">
					<input type="checkbox" name="boardListPublicReadYN" value="Y" <c:if test="${boardList.boardListPublicReadYN=='Y'}" >checked</c:if> />
					</td> 
			</tr>
			<tr>
				<th width="100"> 내용 </th>
				<td>
					<textarea name="contents" rows="8" cols="80">${boardList.boardContents.contents}</textarea>
				</td>
			</tr>
		</tbody>
	</table>
	<c:choose>
		<c:when test="${boardList.boardListSeq >0}">
			<input type="submit" value="수정">
		</c:when>
		<c:otherwise>
			<input type="submit" value="입력">
		</c:otherwise>
	</c:choose>
</form>