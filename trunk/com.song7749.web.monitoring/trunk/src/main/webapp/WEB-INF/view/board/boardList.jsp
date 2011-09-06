<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp"%>
${javascript }
<input type="hidden" name="boardSeq" value="${board.boardSeq }">
<input type="hidden" name="boardName" value="${board.boardName }">
${board.boardName } : <input type="button" name="bntBoardWrite" value="글쓰기">
<table  class="table-list valid">
	<thead>
		<tr>
			<th>글번호</th>
			<th width="500">제목</th>
			<th width="150">아이디(닉네임)</th>
			<th width="50">조회수</th>
			<th width="50">댓글수</th>
			<th>작성일</th>
			<th width="50">수정</th>
			<th width="50">삭제</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${fn:length(boardLists) >0 }">
				<c:forEach var="boardList" items="${boardLists }">
					<tr>
						<td>
							${boardList.boardListSeq }
							<input type="hidden" name="boardListSeq" value="${boardList.boardListSeq }">
						</td>
						<td><a href="/board/boardListDetail.html?boardListSeq=${boardList.boardListSeq }">${boardList.boardTitle }</a></td>
						<td>${memberIdMap[boardList.memberSeq] }(${boardList.memberNickName })</td>
						<td>${boardList.boardReadCount }</td>
						<td>${boardList.boardCommentCount }</td>
						<td>${boardList.createDatetime }</td>
						<td>
							<input type="button" name="bntModifyBoardList" value="수정">
						</td>
						<td>
							<input type="button" name="bntDeleteBoardList" value="삭제">
						</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="9">게시글이 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
<input type="button" name="bntBoardWrite" value="글쓰기">