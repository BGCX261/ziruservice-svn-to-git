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
					url:"roomPictures.do",
					columns:[
							[
				             {title:'房间编号',field:'roomCode',width:85,align:"center"},
				             {title:'图片名称',field:'imageName',width:85,align:"center"},
				             {title:'图片路径',field:'imagepath',width:85,align:"center"},
				             {title:'图片分类',field:'imageCate',width:85,align:"center"},
				             {title:'房屋编号',field:'houseCode',width:85,align:"center"},
				             {title:'资产房间ID',field:'sysRoomId',width:85,align:"center"},
				             {title:'资产房源ID',field:'sysHouseId',width:85,align:"center"},
				             {title:'原始图',field:'n',width:85,align:"center",formatter:function(value,rowData,rowIndex){
									var t = rowData.imagepath;
									t = '<a href="http://localhost:8080/ziroomService/houseImage/'+ t + '">原始图</a>';
									return t;
								}},
				             {title:'大图',field:'n1',width:85,align:"center",formatter:function(value,rowData,rowIndex){
									var t = rowData.imagepath;
									var l = t.lastIndexOf("/");
									var p = t.substring(0, l);
									var n = t.substring(l + 1);
									t = '<a href="http://localhost:8080/ziroomService/houseImage/'+ p + '/v480x360_' + n + '">大图</a>';
									return t;
								}},
				             {title:'中图',field:'n2',width:85,align:"center",formatter:function(value,rowData,rowIndex){
									var t = rowData.imagepath;
									var l = t.lastIndexOf("/");
									var p = t.substring(0, l);
									var n = t.substring(l + 1);
									t = '<a href="http://localhost:8080/ziroomService/houseImage/'+ p + '/v180x135_' + n + '">中图</a>';
									return t;
								}},
				             {title:'小图',field:'n3',width:85,align:"center",formatter:function(value,rowData,rowIndex){
									var t = rowData.imagepath;
									var l = t.lastIndexOf("/");
									var p = t.substring(0, l);
									var n = t.substring(l + 1);
									t = '<a href="http://localhost:8080/ziroomService/houseImage/'+ p + '/v88x66_' + n + '">小图</a>';
									return t;
								}}
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
