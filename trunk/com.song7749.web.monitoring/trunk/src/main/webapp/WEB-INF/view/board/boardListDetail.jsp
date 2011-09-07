<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp"%>
${javascript }
<form name="frmInputComment" id="frmInputComment" method="post">
<input type="hidden" name="loginMemberSeq" value="${loginMember.memberSeq }">
<input type="hidden" name="boardSeq" value="${boardList.boardSeq }">
<input type="hidden" name="boardListSeq" value="${boardList.boardListSeq }">
<table class="table-list valid">
	<tr>
		<td width="100"> 번호 </td>
		<td width="100"> ${boardList.boardListSeq }</td>
		<td width="100"> 제목 </td>
		<td> ${boardList.boardTitle } </td>
	</tr>
	<tr>
		<td> 닉네임 </td>
		<td>${boardList.memberNickName }</td>
		<td> 작성일 </td>
		<td>${boardList.createDatetime }</td>
		 
	</tr>
	<tr>
		<td> 내용 </td>
		<td colspan="3">
			${boardList.boardContents.contents}
		</td>
	</tr>
	<tr>
		<td> 댓글수 </td>
		<td> ${boardList.boardCommentCount } </td>
		<td> 조회수 </td>
		<td> ${boardList.boardReadCount } </td>
	</tr>
	<tr>
		<td colspan="4">
			<textarea name="comment" rows="3" cols="80"></textarea>
			<input type="button" value="댓글입력" id="bntInputComment"/>
			<span id="replyrint"></span>
		</td>
	</tr>
	<tr>
		<td colspan="4">
			<table class="table-list valid" cellspacing="1" cellpadding="5" id="tblCommentList">
				<tr>
					<td>작성자</td>
					<td>내용</td>
					<td>작성일시</td>
					<td>삭제</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>