 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
 <%@ taglib prefix="z" uri="/ziru"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>自如友家网站后台管理系统------房屋列表</title>
		<%@ include file="/include/resources.jsp" %>
	</head>
	<body>
		
		<div style="padding:0px;height: 310px">
			<table id="houseList" toolbar="#toolbar"></table>
		</div>
		<div id="toolbar" class="toolbar" style="height: 50px">
			<table cellpadding="0" cellspacing="0" style="width:100%">
				<tr>
					<th>房源编号：</th>
					<td><input type="text" id="houseCode" maxlength="20" size="10" class="easyui-validatebox"></td>
					<th>部门：</th>
					<td colspan="3">
						<select id="tzb" ></select>&nbsp;&nbsp;<select id="ywz" ></select>
					</td>
					<th>主管：</th>
					<td><select id="zg" name=""></select></td>
					<th>管家名称：</th>
					<td><select id="gj" name=""></select></td>
					<th></th>
				</tr>
				<tr>
					<th>出租方式：</th>
					<td><select id="czfs"><option value="">不限</option><option value="001">分租</option><option value="002">整租</option></select></td>
					<th>是否发布：</th>
					<td><select id="pub"><option value="">请选择</option><option value="Y">是</option><option value="N">否</option></select></td>
					<th>是否优先展示：</th>
					<td>
						<select id="tj"><option value="">请选择</option><option value="Y">是</option><option value="N">否</option></select>&nbsp;&nbsp;
					</td>
					<th>是否推荐：</th>
					<td><select id="zs"><option value="">请选择</option><option value="Y">是</option><option value="N">否</option></select></td>
					<th colspan="3"><a href="javascript:doSearch();" class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></th>
				</tr>
			</table>
		</div>
		<div id="pubDial" class="easyui-dialog" style="width:700px;height:500px;position:relative" closed="true" modal="true"></div>
		<div id="houseDial" class="easyui-dialog" style="width:900px;height:600px;position:relative" closed="true" modal="true"></div>
		<div id="viewDial" class="easyui-dialog" style="width:1000px;height:600px;position:relative" closed="true" modal="true"></div>
		<script type="text/javascript" src="ziru/house/house.js"></script>
		<script type="text/javascript">
			// 加载数据
			$(function(){
				$('#tzb').combobox({
					valueField:'id',
					textField:'text',
					editable:false,
					value:'',
					data:[{"id":"","text":"请选择拓展部"},{"id":"A18065","text":"业务拓展1部"},{"id":"A18087","text":"业务拓展2部"}],
					onSelect:function(nv) {
						var url = 'getDeptOrPerson.do?type=first&param='+nv.id;
						$('#ywz').combobox("reload", url);
					}
				});
				$('#ywz').combobox({
					data:[{"deptCode":"","departName":"请选择业务组"}],
					editable:false,
					value:'',
					valueField:'deptCode',
					textField:'departName'
				});
				$('#zg').combobox({
					url:'getDeptOrPerson.do?type=second',
					data:[{"staffid":"","staffName":"请选择主管"}],
					value:'',
					valueField:'staffid',
					textField:'staffName'
				});
				$('#gj').combobox({
					url:'getDeptOrPerson.do?type=third',
					data:[{"staffid":"","staffName":"请选择管家"}],
					value:'',
					valueField:'staffid',
					textField:'staffName'
				});
			});
		</script>
		<script type="text/javascript">
			var pubs = [{v:'Y',n:'发布'},{v:'N',n:'不发布'}];
			$(function(){
				var _house_status = '<s:property value="%{@cn.ziroom.system.action.DictAction@getValue(\'HOUSE_STATUS\')}"/>';
				var _city = '<s:property value="%{@cn.common.resource.ResourceBuilder@getValue(3)}"/>';
				var _counties = '<s:property value="%{@cn.common.resource.ResourceBuilder@getValue(4)}"/>';
				var _shopping = '<s:property value="%{@cn.common.resource.ResourceBuilder@getValue(5)}"/>';
				var _houseProduct = '<s:property value="%{@cn.ziroom.system.action.DictAction@getValue(\'HOUSE_PRODUCT\')}"/>';
				$('#houseList').datagrid({
					idField:"houseCode",
					fit:true,
					singleSelect:true,
					pagination:true,
					rownumbers:true,
					view: detailview,
					width : 660,
					url:"searchHouse.do",
					columns:[
							[{title:'房源名称',field:'title',width:250,align:"left",formatter:function(value,rowData,rowIndex){
								var t = value;
								<z:function funCode="0106">
									t = '<a href="javascript:void(0);" onclick="view(\''+rowData.sysHouseId+'\');">' + t + '</a>';
								</z:function>
								return t;
							}},
				             {title:'房源编号',field:'houseCode',width:85,align:"left"},
							 {field:'name',title:'所在区域',width:85,align:"left",formatter:function(value,rowData,rowIndex) {
							 	var a1 = "";
							 	var a2 = "";
							 	var a3 = "";
							 	var x = _city.replace(/&quot;/g, "\"");
								$.each(eval("("+x+")"), function(key, val) {
									if(key == rowData.city) {
										a1 = val;
									}
								});
								var y = _counties.replace(/&quot;/g, "\"");
								$.each(eval("("+y+")"), function(key, val) {
									if(key == rowData.counties) {
										a2 = val;
									}
								});
								var z = _shopping.replace(/&quot;/g, "\"");
								$.each(eval("("+z+")"), function(key, val) {
									if(key == rowData.shopping) {
										a3 = val;
									}
								});
								return a1+a2+a3;
							}},
							{field:'areaName',title:'小区名称',width:85,align:"left"},
							{field:'payment',title:'出租价格',width:50,align:"right"},
							{field:'rentNum',title:"剩余间数",width:50, align:'right'},
							{field:'stewardName',title:'管家名称',width:50,align:"left"},
							{field:'houseProduct',title:'房源产品',width:60, align:'right',formatter:function(value, rowData, rowIndex){
								var x = _houseProduct.replace(/&quot;/g, "\"");
								var y = '';
								$.each(eval("("+x+")"), function(key, val) {
									if(key == value) {
										y = val;
									}
								});
								return y;
							}},
							{field:'rentStatus',title:'房屋状态',width:60,align:"center",formatter:function(value, rowData, rowIndex) {
								var x = _house_status.replace(/&quot;/g, "\"");
								var y = '';
								$.each(eval("("+x+")"), function(key, val) {
									if(key == value) {
										y = val;
									}
								});
								return y;
							}},
							{field:'isShow',title:'发布状态',width:80,align:"center",editor:"text",formatter:function(value, rowData) {
								var houseCode = rowData.sysHouseId;
								var status = rowData.rentStatus;
								var button="";
								button = '<a href="#" class="easyui-linkbutton" onclick="publishHouse(\''+value+'\',\''+ houseCode +'\',\'' + status + '\')">';
								if(value=="N") {
									button += '未发布';
								} else {
									button += '已发布';
								}
								button += "</a>";
								return button;
							}}
							]],
					
					detailFormatter:function(index,row){
						return '<div id="detial-' + index + '" style="padding:5px 0;"></div>';
					},
					onExpandRow:function(index,row) {
						var url = 'roomListPage.do?house.sysHouseId='+row.sysHouseId;
						$('#detial-'+index).panel({
							border:false,
							cache:false,
							href:url,
							onLoad:function() {
								$('#houseList').datagrid('fixDetailRowHeight', index);
							}
						});
					}
				});		  
			});
		</script>
	</body>
</html>