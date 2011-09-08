<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp"%>
<div class="error">
	<p class="bgE"></p>
		<c:choose>
			<c:when test="${param.code != '' && param.code != null}">
				<c:if test="${param.code == '400'}">
					<p class="mark">요청 형식이 잘못되었습니다.</p>
				</c:if>
				<c:if test="${param.code == '403'}">
					<p class="mark">자원의 접근이 제한되었습니다.</p>
				</c:if>
				<c:if test="${param.code == '404'}">
					<p class="mark">존재하지 않는 자원입니다.</p>
				</c:if>
				<c:if test="${param.code == '500'}">
					<p class="mark">내부 서버 오류가 발생하였습니다.</p>
				</c:if>        	
			</c:when>
			<c:otherwise>
				<c:redirect url="/error.jsp?code=404"></c:redirect>
			</c:otherwise>
		</c:choose>
    <p class="backBtn"><a href="javascript:history.go(-1);" class="backName">이전페이지로 가기</a></p>
</div>