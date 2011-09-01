$(document).ready(function(){
	$("#frmInsertMember").validate({
		groups:{
			postCode:"postCode1 postCode1",
			address:"addressBase addressDetail"
		},
		errorPlacement: function(error, element) {
			if(element.attr("name") == 'postCode1' || element.attr("name") == 'postCode1'){
				error.insertAfter("#postCode");
			}
			else if(element.attr("name") == 'addressBase' || element.attr("name") == 'addressDetail'){
				error.insertAfter("[name$='addressDetail']");
			}
			else {
				error.insertAfter(element);
			}
		},
		rules:{
			memberId : {
				required : true,
				rangelength:  [4, 16]
			},
			memberName : {
				required: true,
				minlength:2
			},
			memberNickName: {
				required : true,
				minlength: 4
			},
			postCode1 : {
				required : true,
				digits: true,
				minlength: 3
			},
			postCode1 : {
				required : true,
				digits: true,
				minlength: 3
			},
			addressBase : {
				required : true,
				minlength: 2
			},
			addressDetail : {
				required : true,
				minlength: 2
			},
			phoneNumber: {
				required : true,
				digits: true,
				rangelength:  [8, 12]
			},
			mobilePhoneNumber: {
				required : true,
				digits: true,
				rangelength:  [8, 12]
			},
			memberPassword: {
				required : true,
				minlength: 8
			},
			memberPasswordRepeat: {
				equalTo: "[name=memberPassword]"
			},
			memberPasswordQ: {
				required : true,
				minlength: 4
			},
			memberPasswordA: {
				required : true,
				minlength: 4
			},
			email : {
				required : true,
				email: true
			}
		},		
		messages:{
			memberId:{
				required: "회원 ID는 필수항목 입니다.",
				rangelength: $.format("회원 ID는  최소 {0} 최대 {1} 글자 이상 입력해야합니다.")
			},
			memberName:{
				required: "이름은 필수 항목 입니다.",
				minlength: $.format("이름은  최소 {0} 글자 이상 입력해야합니다.")
			},
			memberNickName:{
				required: "닉네임은 필수 항목 입니다.",
				minlength: $.format("닉네임은   최소 {0} 글자 이상 입력해야합니다.")
			},
			postCode1 : {
				required: "우편번호는 필수 항목 입니다.",
				digits: "우편번호는 숫자로 입력하셔야 합니다.",
				minlength: $.format("우편번호는  최소 {0} 글자 이상 입력해야합니다.")
			},
			postCode1 : {
				required: "우편번호는 필수 항목 입니다. <br/>",
				digits: "우편번호는 숫자로 입력하셔야 합니다. <br/>",
				minlength: $.format("우편번호는  최소 {0} 글자 이상 입력해야합니다.")
			},
			addressBase: {
				required : "기본 주소는 필수 항목 입니다.",
				minlength: $.format("기본 주소는  최소  {0} 글자 이상 입력해야합니다.")
			},
			addressDetail: {
				required : "상세 주소는 필수 항목 입니다.",
				minlength: $.format("기본 주소는  최소  {0} 글자 이상 입력해야합니다.")
			},
			phoneNumber: {
				required : "전화번호는 필수 입력값 입니다.",
				digits: "전화번호는 숫자만 입력 가능합니다.",
				rangelength: $.format("전화번호는 최소  {0} 최대 {1} 글자 이상 입력해야합니다.")
			},
			mobilePhoneNumber: {
				required : "핸드폰 번호는 필수 입력값 입니다.",
				digits: "핸드폰 번호는 숫자만 입력 가능합니다.",
				rangelength: $.format("핸드폰 번호는 최소  {0} 최대 {1} 글자 이상 입력해야합니다.")
			},
			memberPassword: {
				required : "패스워드는 필수값 입니다.",
				minlength: $.format("패스워드는 최소  {0} 글자 이상 입력해야합니다.")
			},
			memberPasswordRepeat: {
				equalTo: "패스워드와 재입력된 패스워드가 다릅니다. 패스워드는 일치해야 합니다."
			},			
			memberPasswordQ: {
				required : "패스워드 질문은 필수 입력값 입니다.",
				minlength: $.format("패스워드 질문은 최소  {0} 글자 이상 입력해야합니다.")
			},
			memberPasswordA: {
				required : "패스워드 질문에 대한 답변은 필수 입력값 입니다.",
				minlength: $.format("패스워드 질문에 대한 답변은 최소  {0} 글자 이상 입력해야합니다.")
			},
			email : {
				required : " 이메일 주소를 입력해 주세요",				
				email : "이메일 형식이 일치하지 않습니다."
			}			
		},

		submitHandler: function(form) {
			if($(form).find("[name='memberSeq']").val() > 0){
				$(form).append('<input type="hidden" name="_method" value="PUT" />');
			}
			form.submit();				
		}
	});
});