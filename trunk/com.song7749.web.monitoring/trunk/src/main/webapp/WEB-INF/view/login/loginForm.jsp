<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp"%>
${javascript }
<form name="frmLogin" action="/login/loginProcess.html">
	<input type="hidden" name="returnUrl" value="${returnUrl }">
	<table  class="table-list valid">
		<tr>
			<th width="200">ID</th>
			<td width="200"><input type="text" name="memberId" value=""></td>
			<td rowspan="2"><input type="submit" value="로그인"></td>
		</tr>
		<tr>
			<th width="200">PASSWORD</th>
			<td width="200"><input type="password" name="memberPassword" value=""></td>
		</tr>
	</table>
</form>