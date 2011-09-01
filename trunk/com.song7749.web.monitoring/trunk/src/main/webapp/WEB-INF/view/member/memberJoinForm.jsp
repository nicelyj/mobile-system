<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp"%>
${javascript }
<form name="frmInsertMember" id="frmInsertMember" method="post" action="/member/memberProcess.html">
<input type="hidden" name="memberSeq" value="${member.memberSeq}">
<table class="table-list valid">
	<tr>
		<td> ID </td>
		<td><input type="text" name="memberId" value="${member.memberId }"></td>
	</tr>
	<tr>
		<td> 이름 </td>
		<td><input type="text" name="memberName" value="${member.memberName }"></td>
	</tr>
	<tr>
		<td> 닉네임  </td>
		<td><input type="text" name="memberNickName" value="${member.memberNickName }"></td>
	</tr>
	<tr>
		<td> 패스워드 </td>
		<td><input type="password" name="memberPassword" value="${member.memberPassword }"></td>
	</tr>
	<tr>
		<td> 패스워드 확인 </td>
		<td><input type="password" name="memberPasswordRepeat" value="${member.memberPassword }"></td>
	</tr>
	<tr>
		<td> 패스워드 질문 </td>
		<td><input type="text" name="memberPasswordQ" value="${member.memberPasswordQ }"></td>
	</tr>
	<tr>
		<td> 패스워드 대답 </td>
		<td><input type="text" name="memberPasswordA" value="${member.memberPasswordA }"></td>
	</tr>
	<tr>
		<td> 주소 </td>
		<td>
			<input type="text" name="postCode1" size="3" maxlength="3" value="${fn:substring(member.memberDetail.memberZipcode,0,3) }">-
			<input type="text" name="postCode2" size="3" maxlength="3" value="${fn:substring(member.memberDetail.memberZipcode,4,7) }">
			<span id="postCode"></span>
			<input type="text" name="addressBase" value="${member.memberDetail.memberAddressBase }">
			<input type="text" name="addressDetail" value="${member.memberDetail.memberAddressDetail }">
		</td>
	</tr>
	<tr>
		<td> 전화번호 </td>
		<td><input type="text" name="phoneNumber" value="${member.memberDetail.memberPhoneNumber }"></td>
	</tr>
	<tr>
		<td> 핸드폰 번호 </td>
		<td><input type="text" name="mobilePhoneNumber" value="${member.memberDetail.memberMobileNumber }"></td>
	</tr>
	<tr>
		<td> 메일 주소 </td>
		<td><input type="text" name="email" value="${member.memberEmail }"></td>
	</tr>
</table>
<input type="submit" value="입력">
</form>