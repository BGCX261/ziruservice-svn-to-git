
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
					url:"config.do",
					columns:[
							[{title:'房源编号',field:'houseCode',width:200,align:"left"},
				             {title:'房间编号',field:'roomCode',width:85,align:"center"},
				             {title:'物品编码',field:'itemCode',width:85,align:"center"},
				             {title:'物品名称',field:'itemName',width:85,align:"center"},
				             {title:'品牌',field:'itemBrand',width:85,align:"center"},
				             {title:'数量',field:'itemNum',width:85,align:"center"},
				             {title:'单位',field:'itemUnit',width:85,align:"center"},
				             {title:'新旧程度',field:'itemUseYears',width:85,align:"center"},
				             {title:'物品描述',field:'itemDesc',width:85,align:"center"},
				             {title:'物品类型',field:'itemType',width:85,align:"center"},
				             {title:'物品规格',field:'itemSpac',width:85,align:"center"},
				             {title:'物品图片路径',field:'pictUrl',width:85,align:"center"},
				             {title:'资产房间ID',field:'sysRoomId',width:85,align:"center"}
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