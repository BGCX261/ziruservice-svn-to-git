<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>角色编辑界面</title>
		<%@ include file="/include/resources.jsp" %>
	</head>
	<body>
		<script type="text/javascript" src="ziru/role/role.js"></script>
		<script type="text/javascript">
			$(function(){
				var url = "getFunTree.do";
				var roleId = $("#roleId").val();
				if(roleId != "") {
					url += "?role.roleId="+roleId;
				}
				$('#funTree').tree({
					cascadeCheck:true,
					checkbox: true,
					url: url
				});
				
			});
		</script>
		<div style="padding:5px;background:#fafafa;border-bottom:1px solid #eee;">
			<table cellpadding="0" cellspacing="0" style="width:100%">
				<tr>
					<td style="text-align:left">
						<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-add" onclick="submitRole();">保存</a>
					</td>
					<td style="text-align:right">
						<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-cancel" onclick="javascript:$('#roleDial').dialog('close')">关闭</a>
					</td>
				</tr>
			</table>
		</div>
		<div style="padding:10px;height: auto;">
			<form action="" method="post" id="roleForm">
				<input type="hidden" name="role.roleId" id="roleId" value="<s:property value="role.roleId"/>">
				<input type="hidden" name="role.funCode" id="funCode">
				<table cellpadding="0" cellspacing="3" >
					<tr height="20px">
						<th>角色名称：</th>
						<td><input type="text" name="role.roleName" id="v_roleName" value='<s:property value="role.roleName"/>' maxlength="15"/></td>
					</tr>
					<tr height="20px">
						<th>角色描述：</th>
						<td><input type="text" name="role.roleDesc" value='<s:property value="role.roleDesc"/>' maxlength="200"/></td>
					</tr>
					<tr>
						<td colspan="2">
							<ul id="funTree"></ul>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>