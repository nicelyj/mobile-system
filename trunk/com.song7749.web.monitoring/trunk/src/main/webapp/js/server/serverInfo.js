var viewDatabaseProcessList = function(){
	$.post('/server/serverInfoDatabaseService.xml','dataType=process',function(xml){
		console.log($(xml).text());
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

$(document).ready(function(){
	$.post('/server/serverInfoDatabaseService.xml','dataType=state',function(xml){
		console.log($(xml).text());
		var html='<table class="table-list valid"><tr><td>Attribute</td><td>value</td></tr>';
		$(xml).find("list").find("DatabaseState").each(function(){
			html+='<tr><td>'+ $(this).find("name").text() +'</td><td>'+ $(this).find("value").text() +'</td>';
		});
		html+='</table>';
		$("#viewState").html(html);
	});
	viewDatabaseProcessList();
	window.setInterval("viewDatabaseProcessList", 3*1000);
});