 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>自如友家网站后台管理系统------角色列表</title>
		<%@ include file="/include/resources.jsp" %>
	</head>
	<body>
		<script type="text/javascript" src="ziru/role/role.js"></script>
		<script type="text/javascript">
			$(function(){
				$('#roleList').datagrid({
					width : 660,
					url:"searchRole.do",
					columns:[[{title:'角色名称',field:'roleName',width:85,align:"left"},
					          {title:'描述',field:'roleDesc',width:585,align:"left"}]],
					idField:"roleId",
					fit:true,
					singleSelect:true,
					pagination:true,
					rownumbers:true,
					onDblClickRow:function(rowIndex, rowData) {
						openRolePage(rowData.roleId);
					}
				});		  
			});
		</script>
		<div style="padding:10px;height: 380px">
			<table id="roleList" toolbar="#toolbar"></table>
		</div>
		<div id="toolbar" class="toolbar">
			<table cellpadding="0" cellspacing="0" style="width:100%">
				<tr>
					<td>
						<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="openRolePage();">新增权限</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="delRole();">删除权限</a>
					</td>
				</tr>
			</table>
		</div>
		<div id="roleDial" class="easyui-dialog" style="width:720px;height:450px;position:relative" closed="true" modal="true"></div>
	</body>
</html>