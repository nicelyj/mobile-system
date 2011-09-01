var commonAjax = function(url,params,moveUrl){
	$.ajax({
		url:url,
		dataType:"text/json",
		data:params,
		type:"POST",
		success: function(){ 
			if(moveUrl == undefined)
				document.location = document.location.href;
			else
				document.location = moveUrl;				
	   },
	   error:function(){
		   alert('error');
	   }
	});	
};
