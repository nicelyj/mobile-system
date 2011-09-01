$(document).ready(function(){
	$.post("/board/boards.xml", "", function(xml){
		var html ='';
		$(xml).find("list").find("Board").each(function(){
			html+='<li><a href="/board/boardList.html?boardSeq='+$(this).find("boardSeq").text()+'">'+$(this).find("boardName").text()+'</a></li>';
		});
		$("#boardList").append(html);
	});
});