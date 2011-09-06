$(document).ready(function(){
	$("#bntInputComment").click(function(){
		var params = new Object();
		params._method 			= 'POST';
		params.boardSeq			= $("#frmInputComment").find("[name='boardSeq']").val();
		params.boardListSeq		= $("#frmInputComment").find("[name='boardListSeq']").val();
		params.comment			= $("#frmInputComment").find("[name='comment']").val();
		commonAjax("/board/boardCommentProcess.html",params);
	});
});
