 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>自如友家网站后台管理系统------用户列表</title>
		<%@ include file="/include/resources.jsp" %>
	</head>
	<body>
		<script type="text/javascript" src="ziru/user/user.js"></script>
		<script type="text/javascript">
			$(function(){
				$('#userList').datagrid({
					width : 660,
					url:"searchUser.do",
					columns:[[{title:'工号',field:'staffid',width:85,align:"left"},
					          {title:'账号',field:'account',width:85,align:"left"},
					          {title:'姓名',field:'staffName',width:85,align:"left"},
					          {title:'电话',field:'mobileNumber',width:85,align:"left"},
					          {title:'业务组',field:'groupName',width:85,align:"left"},
					          {title:'拓展部',field:'departName',width:85,align:"left"},
					          {title:'角色',field:'staffRole',width:85,align:"left"}
							]],
					idField:"id",
					fit:true,
					singleSelect:true,
					pagination:true,
					rownumbers:true
				});
			});
		</script>
		<div style="padding:10px;height: 380px">
			<table id="userList" toolbar="#toolbar"></table>
		</div>
		<div id="toolbar" class="toolbar">
			<table cellpadding="0" cellspacing="0" style="width:100%">
				<tr>
					<td>
						<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="openAutPage();">权限设置</a>
					</td>
				</tr>
			</table>
		</div>
		<div id="userDial" class="easyui-dialog" style="width:300px;height:200px;position:relative" closed="true" modal="true"></div>
	</body>
</html>