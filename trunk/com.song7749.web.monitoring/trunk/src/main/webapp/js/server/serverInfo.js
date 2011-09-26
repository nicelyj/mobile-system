$(document).ready(function(){
	var viewState = function(){
		$.post('/server/serverInfoDatabaseService.xml','dataType=state',function(xml){
			var html='<table class="table-list valid"><tr><td>Attribute</td><td>value</td></tr>';
			$(xml).find("list").find("DatabaseState").each(function(){
				html+='<tr><td>'+ $(this).find("name").text() +'</td><td>'+ $(this).find("value").text() +'</td>';
			});
			html+='</table>';
			$("#viewState").html(html);
		});
		$.post('/server/serverInfoDatabaseService.xml','dataType=innoDbState',function(xml){
			var html='<table class="table-list valid"><tr><td>Attribute</td><td>value</td></tr>';
			$(xml).find("list").find("DatabaseState").each(function(){
				html+='<tr><td>'+ $(this).find("name").text() +'</td><td>'+ $(this).find("value").text() +'</td>';
			});
			html+='</table>';
			$("#viewState").html(html);
		});
	};
	

	var viewDatabaseProcessList = function(){
		$.post('/server/serverInfoDatabaseService.xml','dataType=process',function(xml){
			var html='<table class="table-list valid"><tr><td>id</td><td>user</td><td>host</td><td>db</td><td>command</td><td>time</td><td>state</td></tr>';
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
			$("#viewProcess").html(html);
		});	
	};
	
	var processTime = setInterval(viewDatabaseProcessList, 2*1000);
	viewDatabaseProcessList();
});