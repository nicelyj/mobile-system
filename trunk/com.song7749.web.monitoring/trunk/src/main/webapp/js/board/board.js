var addRow = function(){
	var html="";
	html+='<tr>';
	html+='<td width="200"></td>';
	html+='<td width="200"><input type="text" name="boardName" value="" /></td>';
	html+='<td><input type="button" value="저장" name="insertBoard"/></td>';
	html+='</tr>';
	$("#boardListTable").append(html);
	
	$("[name='insertBoard']").click(function(){
		var params = new Object();
		params._method 	= 'POST';
		params.boardSeq	= $(this).parent().parent().find("[name='boardSeq']").val();
		params.boardName= $(this).parent().parent().find("[name='boardName']").val();
		commonAjax("/board/boardProcess.html",params);
	});
};

$(document).ready(function(){
	$("[name='updateBoard']").click(function(){
		var params = new Object();
		params._method 	= 'PUT';
		params.boardSeq	= $(this).parent().parent().find("[name='boardSeq']").val();
		params.boardName= $(this).parent().parent().find("[name='boardName']").val();
		commonAjax("/board/boardProcess.html",params);
	});
	$("[name='deleteBoard']").click(function(){
		var params = new Object();
		params._method 	= 'DELETE';
		params.boardSeq	= $(this).parent().parent().find("[name='boardSeq']").val();
		params.boardName= $(this).parent().parent().find("[name='boardName']").val();
		commonAjax("/board/boardProcess.html",params);
	});
	$("#boardListTable").find("td:last").append('<input type="button" value="게시판추가" onclick="addRow()">');
});