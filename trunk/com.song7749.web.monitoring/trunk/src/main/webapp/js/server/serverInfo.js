var selectView = function(serverType,dataType){
	var base = "";
	if(serverType==1){
		base='/server/serverInfo.html';
	}
	else if(serverType==3){
		base='/server/serverInfo.html';
	}
	var url = base+'?serverListSeq='+$("#serverListSeq").val()+'&serverInfoSeq='+$("#serverInfoSeq").val()+'&dataType='+dataType;
	document.location = url;
};

$(document).ready(function(){
	var viewState = function(){
		$.post('/server/serverInfoDatabaseService.xml','dataType=state',function(xml){
			var html='<table class="table-list valid"><tr><th>Attribute</th><th>value</th></tr>';
			$(xml).find("list").find("DatabaseState").each(function(){
				html+='<tr><td>'+ $(this).find("name").text() +'</td><td>'+ $(this).find("value").text() +'</td>';
			});
			html+='</table>';
			$("#view").html(html);
		});
	};

	

	var viewDatabaseProcessList = function(){
		$.post('/server/serverInfoDatabaseService.xml','dataType=process',function(xml){
			var html ='<table class="table-list valid"><tr><th colspan="7"><input type="button" value="process stop"></th></tr>';
				html+='<tr><td>id</td><td>user</td><td>host</td><td>db</td><td>command</td><td>time</td><td>state</td></tr>';
			$(xml).find("list").find("DatabaseProcess").each(function(){
				html+='<tr>';
				html+='<td>'+ $(this).find("id").text() +'</td>';
				html+='<td>'+ $(this).find("user").text() +'</td>';
				html+='<td>'+ $(this).find("host").text() +'</td>';
				html+='<td>'+ $(this).find("db").text() +'</td>';
				html+='<td>'+ $(this).find("command").text() +'</td>';
				html+='<td>'+ $(this).find("time").text() +'</td>';
				html+='<td>'+ $(this).find("state").text() +'</td>';			
				html+='</tr>';
			});
			html+='</table>';
			$("#view").html(html);
		});
	};
	
	// mysql database
	if($("#serverType").val()==3){
		if($("#dataType").val()=='state'){
			viewState();
		}
		else{
			viewDatabaseProcessList();
			var timeControll= setInterval(viewDatabaseProcessList, 1000);	
		}
	}
});