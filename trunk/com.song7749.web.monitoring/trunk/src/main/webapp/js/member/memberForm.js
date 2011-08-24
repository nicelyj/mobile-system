$(document).ready(function(){
	/**
	 * form validate
	 */
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
			password: {
				required : true,
				minlength: 8
			},
			passwordRepeat: {
				equalTo: "[name=password]"
			},
			passwordQ: {
				required : true,
				minlength: 4
			},
			passwordA: {
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
				required: "ȸ�� ID�� �ʼ��׸� �Դϴ�.",
				rangelength: $.format("ȸ�� ID��  �ּ� {0} �ִ� {1} ���� �̻� �Է��ؾ��մϴ�.")
			},
			memberName:{
				required: "�̸��� �ʼ� �׸� �Դϴ�.",
				minlength: $.format("�̸���  �ּ� {0} ���� �̻� �Է��ؾ��մϴ�.")
			},
			memberNickName:{
				required: "�г����� �ʼ� �׸� �Դϴ�.",
				minlength: $.format("�г�����   �ּ� {0} ���� �̻� �Է��ؾ��մϴ�.")
			},
			postCode1 : {
				required: "�����ȣ�� �ʼ� �׸� �Դϴ�.",
				digits: "�����ȣ�� ���ڷ� �Է��ϼž� �մϴ�.",
				minlength: $.format("�����ȣ��  �ּ� {0} ���� �̻� �Է��ؾ��մϴ�.")
			},
			postCode1 : {
				required: "�����ȣ�� �ʼ� �׸� �Դϴ�. <br/>",
				digits: "�����ȣ�� ���ڷ� �Է��ϼž� �մϴ�. <br/>",
				minlength: $.format("�����ȣ��  �ּ� {0} ���� �̻� �Է��ؾ��մϴ�.")
			},
			addressBase: {
				required : "�⺻ �ּҴ� �ʼ� �׸� �Դϴ�.",
				minlength: $.format("�⺻ �ּҴ�  �ּ�  {0} ���� �̻� �Է��ؾ��մϴ�.")
			},
			addressDetail: {
				required : "�� �ּҴ� �ʼ� �׸� �Դϴ�.",
				minlength: $.format("�⺻ �ּҴ�  �ּ�  {0} ���� �̻� �Է��ؾ��մϴ�.")
			},
			phoneNumber: {
				required : "��ȭ��ȣ�� �ʼ� �Է°� �Դϴ�.",
				digits: "��ȭ��ȣ�� ���ڸ� �Է� �����մϴ�.",
				rangelength: $.format("��ȭ��ȣ�� �ּ�  {0} �ִ� {1} ���� �̻� �Է��ؾ��մϴ�.")
			},
			mobilePhoneNumber: {
				required : "�ڵ��� ��ȣ�� �ʼ� �Է°� �Դϴ�.",
				digits: "�ڵ��� ��ȣ�� ���ڸ� �Է� �����մϴ�.",
				rangelength: $.format("�ڵ��� ��ȣ�� �ּ�  {0} �ִ� {1} ���� �̻� �Է��ؾ��մϴ�.")
			},
			password: {
				required : "�н������ �ʼ��� �Դϴ�.",
				minlength: $.format("�н������ �ּ�  {0} ���� �̻� �Է��ؾ��մϴ�.")
			},
			passwordRepeat: {
				equalTo: "�н������ ���Էµ� �н����尡 �ٸ��ϴ�. �н������ ��ġ�ؾ� �մϴ�."
			},			
			passwordQ: {
				required : "�н����� ������ �ʼ� �Է°� �Դϴ�.",
				minlength: $.format("�н����� ������ �ּ�  {0} ���� �̻� �Է��ؾ��մϴ�.")
			},
			passwordA: {
				required : "�н����� ������ ���� �亯�� �ʼ� �Է°� �Դϴ�.",
				minlength: $.format("�н����� ������ ���� �亯�� �ּ�  {0} ���� �̻� �Է��ؾ��մϴ�.")
			},
			email : {
				required : " �̸��� �ּҸ� �Է��� �ּ���",				
				email : "�̸��� ������ ��ġ���� �ʽ��ϴ�."
			}			
		},
		submitHandler: function(form) {
			form.submit();
		}
	});
});