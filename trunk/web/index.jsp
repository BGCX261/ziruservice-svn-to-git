<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>自如友家网站后台管理系统------登录页面</title>
		<%@ include file="/include/resources.jsp"%>
	</head>
	<body>
		<link rel="stylesheet" type="text/css" href="./css/login.css" media="screen">
		<script type="text/javascript" src="ziru/login.js"></script>
		<div class="easyui-dialog" title="登录系统" closable="false" border="false" modal="true">
			<div class="header" style="height:60px;">
				<div class="toptitle"></div>
			</div>
			<div style="padding:30px 0;">
				<form action="" method="post" id="loginForm">
					<div style="padding-left:100px">
						<table cellpadding="0" cellspacing="3" border="0">
							<tr height="25">
								<td align="right" width="100">登录帐号：</td>
								<td><input type="text" name="user.account" style="width: 180px"></input></td>
							</tr>
							<tr height="25">
								<td align="right">登录密码：</td>
								<td><input type="password" name="user.staffPass" style="width: 180px"></input></td>
							</tr>
							<tr height="25">
								<td align="right">验证码：</td>
								<td>
									<input type="text" name="validatorCode" id="validatorCode" style="width: 80px" >
									<img id="imageCode" alt="验证码" src="createCode.do" align="center" valign="middle" height="25">&nbsp;<a href="javascript:modifyCode();">更换</a>
								</td>
							</tr>
							<tr height="50">
								<td colspan="2" align="center">
									<a href="javascript:login();" class="easyui-linkbutton" iconCls="icon-ok">登陆</a>
									<a href="#" class="easyui-linkbutton" iconCls="icon-no">退出</a>
								</td>
							</tr>
						</table>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>