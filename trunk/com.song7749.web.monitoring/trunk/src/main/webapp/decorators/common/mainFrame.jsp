<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp"%>
<c:choose>
<c:when test="${ajax != true}">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
	<title><decorator:title default="song7749.com" /></title>	
	<decorator:head />
	<page:applyDecorator page="/decorators/common/head.jsp" name="commonHead"/>
 </head>
<body>
<div id="wrapper-outer">
	<div id="wrapper">
		<div id="topMenu">
			<page:applyDecorator page="/decorators/common/topMenu.jsp" name="commonTopMenu"/>
		</div>
		<decorator:body />
	</div>
	<div id="bottomMenu">		
		<page:applyDecorator page="/decorators/common/foot.jsp" name="commonFoot"/>
	</div>
</div>
</body>
</html>
</c:when>
<c:otherwise>
	<decorator:body />
</c:otherwise>
</c:choose> 