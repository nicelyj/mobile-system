$(document).ready(function(){
	$("[name='bntBoardWrite']").click(function(){
		document.location = '/board/boardListForm.html?boardSeq='+$("[name='boardSeq']").val();
	});
	$("[name='bntModifyBoardList']").click(function(){
		var boardListSeq = $(this).parent().parent().find("[name='boardListSeq']").val();
		document.location = '/board/boardListModifyForm.html?boardSeq='+$("[name='boardSeq']").val()+'&boardListSeq='+boardListSeq;
	});
});
