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
			<li>회원등록</li>
			<li>회원목록</li>
		</ul>
	</li>
	<li>게시판
		<ul>
			<li><a href="/board/boardList.html">게시판 관리</a></li>
			<c:forEach var="board" items="${menuBoards }">
				<li>${board.boardName }</li>
			</c:forEach>
		</ul>
	</li>
</ul>