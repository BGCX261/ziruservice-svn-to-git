/**
 * 房间发布
 * @param roomCode
 */
function pubRoom(v, roomCode, status) {
	if(v=='Y') {		
		$.post("pubRoom.do",{"room.sysRoomId":roomCode},function() {
			$('#houseList').datagrid("reload");
		});
	} else {
		var url = "roomPubForm.do";
		if(status != 'ycz' && status != 'yxd') {
			$.post("pubRoom.do", {"room.sysRoomId":roomCode}, function(data) {
				if(data=='sucess') {
					$.messager.alert('成功', '发布成功！', 'info', function() {
						$('#pubDial').dialog('close');
						$('#houseList').datagrid('reload');
					});	
				}
			});
		} else {
			if (v) {
				url += "?room.sysRoomId=" + roomCode;
			}
			$("#pubDial").dialog("setTitle", '房间发布').dialog('open').dialog('refresh', url);	
		}
	}
}

/**
 * 房间屋发布
 */
function submitRoomForm() {
	$('#pubForm').form('submit', {
		url : 'pubRoom.do',
		onSubmit : function() {
			var v = $("#checkInTime").datebox("getValue");
			if(v ==""){
				$.messager.alert('提示', '入住时间没有填写！', 'info');
				return false;
			} else {				
				return true;
			}
		},
		success : function(data) {
			$.messager.alert('成功', '发布成功！', 'info', function() {
				$('#pubDial').dialog('close');
				$('#houseList').datagrid('reload');
			});
		}
	});
}

/**
 * 房间推荐
 * @param roomCode
 */
function recommendRoom(roomCode) {
	$.post("recommendRoom.do",{"room.sysRoomId":roomCode},function(data) {
		if(data == "success") {			
			$('#houseList').datagrid("reload");
		} else {
			$.messager.alert("警告",data,"warning");
		}
	});
}

/**
 * 房间优先展示
 * @param roomCode
 */
function priorityRoom(roomCode) {
	$.post("priorityRoom.do",{"room.sysRoomId":roomCode},function(data) {
		if(data == "success") {			
			$('#houseList').datagrid("reload");
		} else {
			$.messager.alert("警告",data,"warning");
		}
	});
}