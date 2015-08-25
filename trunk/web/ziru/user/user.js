/**
 * 打开角色选择界面
 */
function openAutPage() {
	var r = $("#userList").datagrid("getSelected");
	if(r==null) {
		$.messager.alert("提示","请选择记录","info");
		return;
	}
	var url = "userPage.do?user.id="+r.id;
	$("#userDial").dialog("setTitle", '设置角色').dialog('open').dialog('refresh', url);
}

/**
 * 提交表单
 */
function submitUser() {
	$('#userForm').form('submit', {
		url : 'saveUser.do',
		onSubmit : function() {
			return true;
		},
		success : function(data) {
			$.messager.alert('成功', '操作成功！', 'info', function() {
				$('#userDial').dialog('close');
				$('#userList').datagrid('reload');
			});
		}
	});
}