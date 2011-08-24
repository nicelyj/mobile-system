<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp"%>
<script type="text/javascript" src="/js/board/board.js"></script>
<form name="frmInsertBoard" method="post" action="/board/boardProcess.html">
	<table  class="table-list valid">
		<tr>
			<td width="200"> 게시판 명 </td>
			<td width="200"><input type="text" name="boardName" value=""></td>
			<td><input type="submit" value="입력"></td>
		</tr>
	</table>
</form>