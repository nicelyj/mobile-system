<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp"%>
<input type="hidden" id="getTopMenu" value="<c:if test="${loginMember.memberSeq>0}">true</c:if>">
<ul class="jd_menu">
	<c:choose>
		<c:when test="${loginMember.memberSeq>0}">
			<li> ${loginMember.memberName} (${loginMember.memberId})님
				<ul>
					<li><a href="/login/logOut.html">로그아웃</a></li>
				</ul>
			</li>
		</c:when>
		<c:otherwise>
			<li>로그인
				<ul>
					<li><a href="/login/loginForm.html"> 로그인</a></li>
					<li><a href="/member/memberJoinForm.html"> 회원가입</a></li>
				</ul>
			</li>
			
		</c:otherwise>	
	</c:choose>
	<li>회원관리
		<ul>
			<li><a href="/member/memberForm.html">회원등록</a></li>
			<li><a href="/member/memberList.html">회원관리</a></li>
		</ul>
	</li>
	<li>게시판
		<ul id="boardList">
			<li><a href="/board/boards.html">게시판 관리</a></li>
		</ul>
	</li>
</ul>