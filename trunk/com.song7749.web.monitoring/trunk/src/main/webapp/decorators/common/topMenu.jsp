<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp"%>
<ul class="jd_menu">
	<li> 님
		<ul>
			<li></li>
		</ul>
	</li>
	<li>회원관리
		<ul>
			<li><a href="/member/memberJoinForm.html">회원등록</a></li>
			<li><a href="/member/memberList.html">회원관리</a></li>
		</ul>
	</li>
	<li>게시판
		<ul id="boardList">
			<li><a href="/board/boards.html">게시판 관리</a></li>
		</ul>
	</li>
</ul>