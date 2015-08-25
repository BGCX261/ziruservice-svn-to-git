/**
 * 打开角色编辑界面
 */
function openRolePage(v) {
	var url = "findRole.do";
	if(v) {
		url += "?role.roleId=" + v;
	}
	$("#roleDial").dialog("setTitle", '编辑角色').dialog('open').dialog('refresh', url);
}

/**
 * 保存角色
 */
function submitRole() {
	var nodes = $('#funTree').tree('getChecked');
	var s = '';
	for(var i=0; i<nodes.length; i++){
		if (s != '') {
			s += ',';
		}
		s += ((nodes[i].text).split("|"))[0];
	}
	$("#funCode").val(s);
	$('#roleForm').form('submit', {
		url : 'saveRole.do',
		onSubmit : function() {
			if($("#v_roleName").val()=="") {
				$.messager.alert('提示', "角色名称没有填写！", 'info');
				return false;
			} else {
				return true;
			}
		},
		success : function(data) {
			if(data == 'success') {				
				$.messager.alert('成功', '操作成功！', 'info', function() {
					$('#roleDial').dialog('close');
					$('#roleList').datagrid('reload');
				});
			} else {
				$.messager.alert('提示', data, 'info');
			}
		}
	});
}

/**
 * 删除权限
 */
function delRole() {
	var r = $("#roleList").datagrid("getSelected");
	if(r==null) {
		$.messager.alert("提示","请选择记录","info");
		return;
	}
	var roleId = r.roleId;
	$.post("delRole.do",{"role.roleId":roleId}, function() {
		$.messager.alert('成功', '操作成功！', 'info', function() {
			$('#roleList').datagrid('reload');
		});
	});
}