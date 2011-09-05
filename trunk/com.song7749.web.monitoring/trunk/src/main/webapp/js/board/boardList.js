$(document).ready(function(){
	$("[name='bntBoardWrite']").click(function(){
		document.location = '/board/boardListForm.html?boardSeq='+$("[name='boardSeq']").val();
	});
	$("[name='bntModifyBoardList']").click(function(){
		var boardListSeq = $(this).parent().parent().find("[name='boardListSeq']").val();
		document.location = '/board/boardListModifyForm.html?boardSeq='+$("[name='boardSeq']").val()+'&boardListSeq='+boardListSeq;
	});
	$("[name='bntDeleteBoardList']").click(function(){
		var params = new Object();
		params._method 	= 'DELETE';
		params.boardSeq	= $(this).parent().parent().find("[name='boardSeq']").val();
		params.boardListSeq=  $(this).parent().parent().find("[name='boardListSeq']").val();
		if(confirm("정말삭제하시겠습니까?"))
			commonAjax("/board/boardListProcess.html",params);
		else
			return;
	});
});