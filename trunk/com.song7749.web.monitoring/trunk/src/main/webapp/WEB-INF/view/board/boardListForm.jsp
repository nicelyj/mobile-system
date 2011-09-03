<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp"%>
${javascript }
<form name="frmInsertBoard" method="post" action="/board/boardListProcess.html">
<input type="hidden" name="boardListSeq" value="" />
<input type="hidden" name="boardSeq" value="${board.boardSeq }" />
<input type="hidden" name="boardName" value="${board.boardName }" />
	${board.boardName }
	<table  class="table-list valid">
		<tbody>
			<tr>
				<th width="100"> 제목 </th>
				<td><input type="text" name="title" value="" size="80" /></td>
			</tr>
			<tr>
				<th width="100"> 닉네임 </th>
				<td width="100"><input type="text" name="memberNickName" value="" /></td>
			</tr>
			<tr>
				<th width="100"> 비밀글 </th>
				<td width="100"><input type="checkbox" name="boardListPublicReadYN" value="Y" /></td> 
			</tr>
			<tr>
				<th width="100"> 내용 </th>
				<td>
					<textarea name="contents" rows="8" cols="80"></textarea>
				</td>
			</tr>
		</tbody>
	</table>
<input type="submit" value="입력">
</form>