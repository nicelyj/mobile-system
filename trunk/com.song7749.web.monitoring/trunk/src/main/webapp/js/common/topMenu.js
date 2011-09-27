$(document).ready(function(){
	if($("#getTopMenu").val()=="true"){
		$.post("/board/boards.xml", "", function(xml){
			var html ='';
			$(xml).find("list").find("Board").each(function(){
				html+='<li><a href="/board/boardList.html?boardSeq='+$(this).find("boardSeq").text()+'">'+$(this).find("boardName").text()+'</a></li>';
			});
			$("#boardList").append(html);
		});
		$.post("/server/serverList.xml", "", function(xml){
			var html ='';
			$(xml).find("list").find("ServerList").each(function(){
				html+='<li title="'+$(this).find("serverDomainName").text()+' - '+ $(this).find("serverIp").text() +'('+$(this).find("serverPort").text()+')"><a href="/server/serverInfo.html?serverListSeq='+$(this).find("serverListSeq").text()+'&serverInfoSeq='+$(this).find("serverInfo").find("serverInfoSeq").text()+'">'+$(this).find("serverName").text()+'</a></li>';
			});
			$("#serverList").append(html);
		});
	}
});