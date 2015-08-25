<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>角色编辑界面</title>
		<%@ include file="/include/resources.jsp" %>
	</head>
	<body>
		<script type="text/javascript" src="ziru/user/user.js"></script>
		<div style="padding:5px;background:#fafafa;border-bottom:1px solid #eee;">
			<table cellpadding="0" cellspacing="0" style="width:100%">
				<tr>
					<td style="text-align:left">
						<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-add" onclick="submitUser();">保存</a>
					</td>
					<td style="text-align:right">
						<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-cancel" onclick="javascript:$('#userDial').dialog('close')">关闭</a>
					</td>
				</tr>
			</table>
		</div>
		<div style="padding:10px;height: auto;">
			<form action="" method="post" id="userForm">
				<input type="hidden" name="user.id" value="<s:property value="user.id"/>">
				<table cellpadding="0" cellspacing="3" >
					<tr height="20px">
						<th>选择角色：</th>
						<td><input type="text" id="staffRole" name="user.staffRole" value='<s:property value="user.staffRole"/>'/></td>
					</tr>
				</table>
			</form>
		</div>
		<script type="text/javascript">
			$(function(){
				$('#staffRole').roleselect({
					url:'searchRoleList.do'
				});
				$('#staffRole').combogrid('setText','${user.staffRole}');
			});
		</script>
	</body>
</html>