$(document).ready(function(){
	$("[name='bntBoardWrite']").click(function(){
		document.location = '/board/boardListForm.html?boardSeq='+$("[name='boardSeq']").val();
	});
});
