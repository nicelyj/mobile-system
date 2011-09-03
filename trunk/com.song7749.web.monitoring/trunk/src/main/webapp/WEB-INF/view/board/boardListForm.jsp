<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp"%>
${javascript }
<form name="frmInsertBoard" action="/board/boardListProcess.html">
<input type="hidden" name="boardSeq" value="" />
<input type="hidden" name="boardListSeq" value="" />
<input type="hidden" name="boardName" value="" />
	<table  class="table-list valid">
		<tbody>
			<tr>
				<th> 제목 </th>
				<td colspan="3"><input type="text" name="title" value="" size="80" /></td>
			</tr>
			<tr>
				<th> 닉네임 </th>
				<td><input type="text" name="memberNickName" value="" /></td>
				<th> 비밀글 </th>
				<td><input type="checkbox" name="boardListPublicReadYN" value="Y" /></td> 
			</tr>
			<tr>
				<th> 내용 </th>
				<td colspan="3">
					<textarea name="contents" rows="4" cols="80">
					</textarea>
				</td>
			</tr>
		</tbody>
	</table>
<input type="submit" value="입력">
</form>