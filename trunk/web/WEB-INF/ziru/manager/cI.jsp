 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
 <%@ taglib prefix="z" uri="/ziru"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>自如友家网站后台管理系统------合同列表</title>
		<%@ include file="/include/resources.jsp" %>
	</head>
	<body>
		<script type="text/javascript" src="ziru/house/house.js"></script>
		<script type="text/javascript">
		
			$(function(){
				var _house_status = '<s:property value="%{@cn.ziroom.system.action.DictAction@getValue(\'CONTRACT_STATUS\')}"/>';
				var _house_product = '<s:property value="%{@cn.ziroom.system.action.DictAction@getValue(\'HOUSE_PRODUCT\')}"/>';
				var FEE_TYPE = '<s:property value="%{@cn.ziroom.system.action.DictAction@getValue(\'FEE_TYPE\')}"/>';
				var LEASE_YEAR = '<s:property value="%{@cn.ziroom.system.action.DictAction@getValue(\'LEASE_YEAR\')}"/>';
				$('#houseList').datagrid({
					width : 660,
					url:"contract.do",
					columns:[
							[{title:'合同编号',field:'contractCode',width:200,align:"left"},
				             {title:'客户编号',field:'custCode',width:85,align:"center"},
				             {title:'房源编号',field:'houseCode',width:85,align:"center"},
				             {title:'房间编号',field:'roomCode',width:85,align:"center"},
				             {title:'验证码',field:'securityCode',width:85,align:"center"},
				             {title:'签约周期',field:'cycle',width:85,align:"center",formatter:function(value, rowData, rowIndex) {
									var x = LEASE_YEAR.replace(/&quot;/g, "\"");
									var y = '';
									$.each(eval("("+x+")"), function(key, val) {
										if(key == value) {
											y = val;
										}
									});
									return y;
								}},
				             {title:'空置期',field:'vacancy',width:85,align:"center"},
				             {title:'签约日期',field:'signDate',width:85,align:"center"},
				             {title:'生效日期',field:'effectDate',width:85,align:"center"},
				             {title:'终止日期',field:'stopDate',width:85,align:"center"},
				             {title:'收/出房价格',field:'price',width:85,align:"center"},
				             {title:'店编号',field:'storeNum',width:85,align:"center"},
				             {title:'店名称',field:'storeName',width:85,align:"center"},
				             {title:'区域名称',field:'businessName',width:85,align:"center"},
				             {title:'大区名称',field:'areaName',width:85,align:"center"},
				             {title:'店经理编号',field:'storeLeaderCode',width:85,align:"center"},
				             {title:'店经理名称',field:'storeLeaderName',width:85,align:"center"},
				             {title:'经纪人编号',field:'storeAgentCode',width:85,align:"center"},
				             {title:'经纪人名称',field:'storeAgentName',width:85,align:"center"},
				             {title:'管家编号',field:'agentCode',width:85,align:"center"},
				             {title:'房源产品',field:'houseProduct',width:85,align:"center",formatter:function(value, rowData, rowIndex) {
									var x = _house_product.replace(/&quot;/g, "\"");
									var y = '';
									$.each(eval("("+x+")"), function(key, val) {
										if(key == value) {
											y = val;
										}
									});
									return y;
								}},
				             {title:'是否整租',field:'rental',width:85,align:"center"},
				             {title:'付款/收款方式',field:'payment',width:85,align:"center",formatter:function(value, rowData, rowIndex) {
									var x = FEE_TYPE.replace(/&quot;/g, "\"");
									var y = '';
									$.each(eval("("+x+")"), function(key, val) {
										if(key == value) {
											y = val;
										}
									});
									return y;
								}},
				             {title:'合同状态',field:'contractState',width:85,align:"center",formatter:function(value, rowData, rowIndex) {
									var x = _house_status.replace(/&quot;/g, "\"");
									var y = '';
									$.each(eval("("+x+")"), function(key, val) {
										if(key == value) {
											y = val;
										}
									});
									return y;
								}},
				             {title:'资产合同主键',field:'sysContractId',width:85,align:"center"},
				             {title:'资产房间主键',field:'sysRoomId',width:85,align:"center"},
				             {title:'资产房源主键',field:'sysHouseId',width:85,align:"center"},
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