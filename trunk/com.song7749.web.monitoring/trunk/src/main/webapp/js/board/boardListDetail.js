var deleteComment = function(boardCommentSeq){
	if(confirm('정말 삭제하시겠습니까')){
		var params = new Object();
		params._method 			= 'DELETE';
		params.boardCommentSeq	= boardCommentSeq;
		commonAjax("/board/boardCommentProcess.xml",params);
	}
} ;

$(document).ready(function(){
	$.post("/board/boardCommentList.xml",{boardListSeq:$("#frmInputComment").find("[name='boardListSeq']").val()},function(xml){
		var html="";
		$(xml).find("list").find("BoardComment").each(function(){
			html+='<tr>';
			html+='	<td>'+$(this).find("memberNickName").text()+'</td>';
			html+='	<td>'+$(this).find("comment").text()+'</td>';
			html+='	<td>'+$(this).find("createDatetime").text()+'</td>';

			html+='	<td>';
			if($(this).find("memberSeq").text() ==  $("#frmInputComment").find("[name='loginMemberSeq']").val())			
				html+='	<a href="javascript:deleteComment('+$(this).find("boardCommentSeq").text()+');">삭제</a>';
			html+='	</td>';
			html+='</tr>';			
		});
		$("#tblCommentList").append(html);
	});
	
	$("#bntInputComment").click(function(){
		var params = new Object();
		params._method 			= 'POST';
		params.boardSeq			= $("#frmInputComment").find("[name='boardSeq']").val();
		params.boardListSeq		= $("#frmInputComment").find("[name='boardListSeq']").val();
		params.comment			= $("#frmInputComment").find("[name='comment']").val();
		commonAjax("/board/boardCommentProcess.html",params);
	});
});
