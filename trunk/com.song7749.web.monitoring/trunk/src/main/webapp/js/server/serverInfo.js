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


var timeStop = function(){
	clearInterval($("#time").data("timeControll"));
	$("#monitorMessage").html(" <font color=red> monitor stop </font>");
};

var viewDatabaseProcessListTime = function(){
	timeStop();
	$("#time").data("timeControll",setInterval(viewDatabaseProcessList, 1000));
	$("#monitorMessage").html(" <font color=red> monitor start </font>");	
};

var viewWindowsSystemProcessListTime = function(){
	timeStop();
	$("#time").data("timeControll",setInterval(viewWindowsSystemProcessList, 1000));
	$("#monitorMessage").html(" <font color=red> monitor start </font>");	
};	

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

var killProcessFromDatabaseService = function(id){
	console.log('serverListSeq='+$("#serverListSeq").val()+'&serverInfoSeq='+$("#serverInfoSeq").val()+'&id='+id);
	$.post('/server/killProcessFromDatabaseService.html','serverListSeq='+$("#serverListSeq").val()+'&serverInfoSeq='+$("#serverInfoSeq").val()+'&id='+id,function(xml){});
	$("#monitorMessage").html(" <font color=red> id : "+ id +" process killed </font>");	
};

var killProcessSystemService = function(id){
	console.log('serverListSeq='+$("#serverListSeq").val()+'&serverInfoSeq='+$("#serverInfoSeq").val()+'&id='+id);
	$.post('/server/killProcessSystemService.html','serverListSeq='+$("#serverListSeq").val()+'&serverInfoSeq='+$("#serverInfoSeq").val()+'&id='+id,function(xml){});
	$("#monitorMessage").html(" <font color=red> id : "+ id +" process killed </font>");	
};


var viewDatabaseProcessList = function(){
	$.post('/server/serverInfoDatabaseService.xml','dataType=process',function(xml){
		var html ='<table class="table-list valid">';
			html+='<tr>';
			html+='<th colspan="8">';
			html+='<input type="button" value="process start" onclick="viewDatabaseProcessListTime()">';
			html+='<input type="button" value="process stop" onclick="timeStop()">';
			html+='</th>';
			html+='</tr>';
			html+='<tr><th>id</th><th>user</th><th>host</th><th>db</th><th>command</th><th>time</th><th>state</th><th width="100">종료</th></tr>';
			$(xml).find("list").find("DatabaseProcess").each(function(){
				html+='<tr>';
				html+='<td>'+ $(this).find("id").text() +'</td>';
				html+='<td>'+ $(this).find("user").text() +'</td>';
				html+='<td>'+ $(this).find("host").text() +'</td>';
				html+='<td>'+ $(this).find("db").text() +'</td>';
				html+='<td>'+ $(this).find("command").text() +'</td>';
				html+='<td>'+ $(this).find("time").text() +'</td>';
				html+='<td>'+ $(this).find("state").text() +'</td>';			
				html+='<td> <input type="button" value="kill process" onclick="killProcessFromDatabaseService('+$(this).find("id").text()+')" /></td>';			
				html+='</tr>';
			});
		html+='</table>';
		$("#view").html(html);
	});
};

var viewWindowsSystemProcessList = function(){
	$.post('/server/serviceInfoProcessList.xml','',function(xml){
		var html ='<table class="table-list valid">';
		html+='<tr>';
		html+='<th colspan="6">';
		html+='<input type="button" value="process start" onclick="viewWindowsSystemProcessListTime()">';
		html+='<input type="button" value="process stop" onclick="timeStop()">';
		html+='</th>';
		html+='</tr>';
		$(xml).find("list").find("WindowsProcess").each(function(loop){
			var td;
			var killText;
			if(loop==0){
				td='th';
				killText='<th width="100">종료</th>';
			}
			else{
				td='td';
				killText='<td> <input type="button" value="kill process" onclick="killProcessSystemService('+$(this).find("pid").text()+')" /></td>';				
			}

			html+='<tr>';
			html+='<'+td+'>'+ $(this).find("processName").text() +'</'+td+'>';
			html+='<'+td+'>'+ $(this).find("pid").text() +'</'+td+'>';
			html+='<'+td+'>'+ $(this).find("sessionName").text() +'</'+td+'>';
			html+='<'+td+'>'+ $(this).find("sessionCode").text() +'</'+td+'>';
			html+='<'+td+'>'+ $(this).find("useMemory").text() +'</'+td+'>';
			html+=killText;
			html+='</tr>';
		});
		html+='</table>';
		$("#view").html(html);
	});
};

$(document).ready(function(){
	// mysql database
	if($("#serverType").val()==3){
		if($("#dataType").val()=='state'){
			viewState();
		}
		else{
			viewDatabaseProcessListTime();
		}
	}
	// process
	if($("#serverType").val()==1){
		if($("#dataType").val()=='systemProcess'){
			viewWindowsSystemProcessListTime();	
		}
		else{

		}
	}
});