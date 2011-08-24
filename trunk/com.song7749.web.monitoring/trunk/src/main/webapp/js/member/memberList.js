var deleteMember = function (memberSeq){
	if(confirm("정말 삭제하시겠습니까?")){
		document.location = './member/memberTran.jsp?dataMode=delete&memberSeq='+memberSeq;
	}
	else{
		return ;
	}
	
};