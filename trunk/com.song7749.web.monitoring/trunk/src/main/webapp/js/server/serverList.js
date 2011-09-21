var addRow = function(){
	var html="";
	html+='<tr>';
	html+='<td></td>';
	html+='<td><input type="text" name="serverName" value="" /></td>';
	html+='<td><input type="text" name="serverIp" value="" /></td>';
	html+='<td>'+$("#selectServerTypeSpan").html()+'</td>';
	html+='<td><input type="text" name="serverDomainName" value="" /></td>';
	html+='<td><input type="text" name="serverPort" value="" /></td>';
	html+='<td><input type="button" value="저장" name="insertServer"/></td>';
	html+='</tr>';
	$("#serverListTable").append(html);
	
	$("[name='insertServer']").click(function(){
		var params = new Object();
		params._method 	= 'POST';
		params.serverName=$(this).parent().parent().find("[name='serverName']").val();
		params.serverIp=$(this).parent().parent().find("[name='serverIp']").val();
		params.serverDomainName=$(this).parent().parent().find("[name='serverDomainName']").val();
		params.serverPort=$(this).parent().parent().find("[name='serverPort']").val();
		commonAjax("/server/serverProcess.html",params);
	});
};

$(document).ready(function(){
	$("[name='updateServerList']").click(function(){
		var params = new Object();
		params._method 	= 'PUT';
		params.serverListSeq=$(this).parent().parent().find("[name='serverListSeq']").val();
		params.serverInfoSeq=$(this).parent().parent().find("[name='serverInfoSeq']").val();
		params.serverName=$(this).parent().parent().find("[name='serverName']").val();
		params.serverType=$(this).parent().parent().find("[name='serverType']").val();
		params.serverIp=$(this).parent().parent().find("[name='serverIp']").val();
		params.serverDomainName=$(this).parent().parent().find("[name='serverDomainName']").val();
		params.serverPort=$(this).parent().parent().find("[name='serverPort']").val();
		commonAjax("/server/serverProcess.html",params);
	});
	$("[name='deleteServerList']").click(function(){
		var params = new Object();
		params._method 	= 'DELETE';
		params.serverListSeq=$(this).parent().parent().find("[name='serverListSeq']").val();
		params.serverInfoSeq=$(this).parent().parent().find("[name='serverInfoSeq']").val();
		commonAjax("/server/serverProcess.html",params);
	});
	$("#serverListTable").find("td:last").append('<input type="button" value="서버추가" onclick="addRow()">');
});