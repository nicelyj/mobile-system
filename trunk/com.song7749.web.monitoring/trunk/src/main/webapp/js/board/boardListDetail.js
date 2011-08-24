$(document).ready(function(){
	$("#bntInputComment").click(function(){
		$("#frmInputComment").find("[name=dataMode]").val('insert');
		$.post('./boardList/boardCommentTran.jsp', $("#frmInputComment").serializeArray(),function(data){
			$("#replyPrint").html("<font color='red'><strong>댓글 입력 성공</strong></font>");
			document.location = document.location.href;
		});
	});	
});
