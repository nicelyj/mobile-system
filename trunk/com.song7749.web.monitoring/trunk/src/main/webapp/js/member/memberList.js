var deleteMember = function (memberSeq){
	if(confirm("���� �����Ͻðڽ��ϱ�?")){
		document.location = './member/memberTran.jsp?dataMode=delete&memberSeq='+memberSeq;
	}
	else{
		return ;
	}
	
};