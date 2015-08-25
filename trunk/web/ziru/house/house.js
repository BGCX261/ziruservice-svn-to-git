/**
 * 房屋查询
 */
function doSearch() {
	var houseCode = $("#houseCode").val();
	var tzb = $('#tzb').combobox('getValue');
	var ywz = $("#ywz").combobox('getValue');
	var zg = $("#zg").combobox('getValue');
	var gj = $("#gj").combobox('getValue');
	var a = $("#pub").val();
	var b = $("#tj").val();
	var c = $("#zs").val();
	var d = $("#czfs").val();
	$('#houseList').datagrid('load', {
		"house.houseCode" : houseCode,
		"house.dep1" : tzb,
		"house.dep2" : ywz,
		"house.r1" : zg,
		"house.r2" : gj,
		"house.isTop" : b,
		"house.isShow" : a,
		"house.isPromotions" : c,
		"house.rentType" : d
	});
}

/**
 * 房屋发布
 * 
 * @param houseCode
 */
function publishHouse(v, houseCode, status) {
	if (v == "Y") {
		$.post("pubHouse.do", {
			"house.sysHouseId" : houseCode
		}, function() {
			$('#houseList').datagrid("reload");
		});
	} else {
		var url = "housePubForm.do";
		if(status != 'km') {
			$.post("pubHouse.do", {"house.sysHouseId":houseCode}, function(data) {
				if(data=='sucess') {
					$.messager.alert('成功', '发布成功！', 'info', function() {
						$('#pubDial').dialog('close');
						$('#houseList').datagrid('reload');
					});	
				}
			});	
		} else {
			if (v) {
				url += "?house.sysHouseId=" + houseCode;
			}
			$("#pubDial").dialog("setTitle", '房屋发布').dialog('open').dialog(
					'refresh', url);
		}
		
	}
}

/**
 * 房屋发布
 */
function submitHouseForm() {
	$('#pubForm').form('submit', {
		url : 'pubHouse.do',
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
 * 房屋详情页
 * 
 * @param houseCode
 */
function view(houseCode) {
	var url = "houseView.do?house.sysHouseId=" + houseCode;
	$("#viewDial").dialog("setTitle", '房屋详情页').dialog('open').dialog('refresh', url);
}

/**
 * 房屋编辑页面
 * 
 * @param houseCode
 */
function openHouseForm(houseCode) {
	var url = "houseFind.do?house.sysHouseId=" + houseCode;
	$("#viewDial").dialog("setTitle", '房屋编辑').dialog('open').dialog('refresh',
			url);
}

/**
 * 保存房屋信息
 */
function saveHouse(houseCode) {
	var houseEvaluate = $("#houseEvaluate").val();
	var characteristics = $("#characteristics").val();
	var environmentEvaluate = $("#environmentEvaluate").val();
	if (itrim(houseEvaluate) == "" || itrim(characteristics) == ""
			|| itrim(environmentEvaluate) == "") {
		$.messager.alert('提示', '房屋信息,房屋特色,环境评价必须填写！', 'info');
		return;
	}
	var data = {
		"house.sysHouseId" : houseCode,
		"house.houseEvaluate" : houseEvaluate,
		"house.characteristics" : characteristics,
		"house.environmentEvaluate" : environmentEvaluate
	};
	$.post("saveHouse.do", data, function(data) {
		$.messager.alert('成功', '保存成功！', 'info');
	});
}

/**
 * 保存房间
 * 
 * @param roomCode
 */
function saveRoom(roomCode) {
	var error = "";
	var roomComment = $("#" + roomCode + "roomComment").val();
	var toiletDesc = $("#" + roomCode + "toiletDesc").val();
	var balconyDesc = $("#" + roomCode + "balconyDesc").val();
	var gardenDesc = $("#" + roomCode + "gardenDesc").val();
	var terraceDesc = $("#" + roomCode + "terraceDesc").val();
	var saloonDesc = $("#" + roomCode + "saloonDesc").val();
	var kitchenDesc = $("#" + roomCode + "kitchenDesc").val();
	if (roomComment !=undefined) {
		if(itrim(roomComment) == "") {
			error += "卧室特色、";
		}
	}
	if (toiletDesc!=undefined) {
		if(itrim(toiletDesc) == "") {
			error += "卫生间特色、";
		}
	}
	if (balconyDesc!=undefined) {
		if(itrim(balconyDesc) == "") {
			error += "阳台特色、";
		}
	}
	if (gardenDesc!=undefined) {
		if(itrim(gardenDesc) == "") {
			error += "花园特色、";
		}
	}
	if (terraceDesc!=undefined) {
		if(itrim(terraceDesc) == "") {
			error += "露台特色、";
		}
	}
	if (saloonDesc!=undefined) {
		if(itrim(saloonDesc) == "") {
			error += "客厅特色、";
		}
	}
	if (kitchenDesc!=undefined) {
		if(itrim(kitchenDesc) == "") {
			error += "厨房特色、";
		}
	}
	if(error!="") {
		$.messager.alert('提示', error+"没有填写", 'info');
		return;
	}
	var data = {
		"room.roomComment" : roomComment,
		"room.toiletDesc" : toiletDesc,
		"room.balconyDesc" : balconyDesc,
		"room.gardenDesc" : gardenDesc,
		"room.terraceDesc" : terraceDesc,
		"room.saloonDesc" : saloonDesc,
		"room.kitchenDesc" : kitchenDesc,
		"room.sysRoomId" : roomCode
	};
	$.post("saveRoom.do", data, function(data) {
		$.messager.alert('成功', '保存成功！', 'info');
	});
}
var itrim = function(str) {
	return str.replace(/^\s+/, '').replace(/\s+$/, '');
};