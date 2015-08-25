/**
 * 登录
 */
function login() {
	$('#loginForm').form('submit', {
		url:'login.do',
		onSubmit:function() {
			// 验证码是否正确
			var validatorCode = getCookie("validatorCode");
			var _validatorCode = $("#validatorCode").val();
			if(validatorCode == _validatorCode) {
				return true;
			} else {
				$.messager.alert('警告','验证码不正确!','warning');
				return false;
			}
		},
		success:function(data) {
			if(data == 'success') {
				window.location.href="forward.do";	
				//$.messager.alert('登陆成功','用户名登录成功!','warning');
			} else if(data == 'loginError') {
				$.messager.alert('登陆错误','用户名或密码不正确!','warning');
			} else {
				$.messager.alert('错误','请联系管理员!','warning');
			}
		}
	});
}

/**
 * 获得验证码
 */
function modifyCode() {
	var timestamp = (new Date()).valueOf();
	$("#imageCode").attr("src", "createCode.do?timestamp=" + timestamp);
}