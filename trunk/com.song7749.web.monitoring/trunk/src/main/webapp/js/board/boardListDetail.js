$(document).ready(function(){
	$("#bntInputComment").click(function(){
		$("#frmInputComment").find("[name=dataMode]").val('insert');
		$.post('./boardList/boardCommentTran.jsp', $("#frmInputComment").serializeArray(),function(data){
			$("#replyPrint").html("<font color='red'><strong>��� �Է� ����</strong></font>");
			document.location = document.location.href;
		});
	});	
});
