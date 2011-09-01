var updateMember = function(memberSeq){
	document.location = '/member/memberModifyForm.html?memberSeq='+memberSeq;
};
var deleteMember = function(memberSeq){
	var params = new Object();
	params._method 	= 'DELETE';
	params.memberSeq= memberSeq;
	if(confirm('정말 삭제하시겠습니까?'))
		commonAjax("/member/memberProcess.html",params);
	else
		return;
};
