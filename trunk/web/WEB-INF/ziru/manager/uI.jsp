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
		<script type="text/javascript" src="ziru/house/house.js"></script>
		<script type="text/javascript">
		
			$(function(){
				var _house_status = '<s:property value="%{@cn.ziroom.system.action.DictAction@getValue(\'HOUSE_STATUS\')}"/>';
				$('#houseList').datagrid({
					width : 660,
					url:"customer.do",
					columns:[
							[{title:'编号',field:'custCode',width:200,align:"left"},
				             {title:'姓名',field:'custName',width:85,align:"center"},
				             {title:'电话',field:'phone',width:85,align:"center"},
				             {title:'性别',field:'sex',width:85,align:"center"},
				             {title:'籍贯',field:'birthPlace',width:85,align:"center"},
				             {title:'出生日期',field:'birth',width:85,align:"center"},
				             {title:'邮箱',field:'email',width:85,align:"center"},
				             {title:'证件类型',field:'certificateType',width:85,align:"center"},
				             {title:'证件号码',field:'certNum',width:85,align:"center"},
				             {title:'客户来源',field:'origin',width:85,align:"center"},
				             {title:'学历',field:'degree',width:85,align:"center"},
				             {title:'是否结婚',field:'marriage',width:85,align:"center"},
				             {title:'职业',field:'professional',width:85,align:"center"},
				             {title:'国籍',field:'nationality',width:85,align:"center"},
				             {title:'工作单位',field:'workUnit',width:85,align:"center"},
				             {title:'联系地址',field:'address',width:85,align:"center"},
				             {title:'民族',field:'national',width:85,align:"center"},
				             {title:'客户状态',field:'custStatus',width:85,align:"center"},
				             {title:'资产客户主键',field:'sysCustId',width:85,align:"center"}
							]],
					idField:"houseCode",
					fit:true,
					singleSelect:true,
					//pagination:true,
					//rownumbers:true
				});		  
			});
		</script>
		<div style="padding:0px;height: 580px">
			<table id="houseList" ></table>
		</div>
	</body>
</html>