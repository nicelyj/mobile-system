var commonAjax = function(url,params){
	$.ajax({
		url:url,
		dataType:"text/json",
		data:params,
		type:"POST",
		success: function(){ 
			document.location = document.location.href;			   
	   },
	   error:function(){
		   alert('error');
	   }
	});	
};
