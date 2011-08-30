$(document).ready(function(){
	$("[name='updateBoard']").click(function(){
		var params = new Object();
		params._method 	= 'PUT';
		params.boardSeq	= $(this).parent().parent().find("[name='boardSeq']").val();
		params.boardName= $(this).parent().parent().find("[name='boardName']").val();
		
		$.ajax({
			url:"/board/boardProcess.html",
			dataType:"text/json",
			data:params,
			type:"POST",
			success: function(msg){ 
				document.location = document.location.href;			   
		   },
		   error:function(){
		   }
		});
	});
});