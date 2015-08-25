 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
 <%@ taglib prefix="z" uri="/ziru"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>自如友家网站后台管理系统------房间列表</title>
		<%@ include file="/include/resources.jsp" %>
		
	</head>
	<body>
		<script type="text/javascript" src="ziru/house/room.js"></script>
		<div style="padding:1px;">
			<table id="roomList<s:property value='house.houseCode'/>">
				<thead>
					<tr>
						<th width="80" field="roomCode">房间编号</th>
						<th width="350" field="roomName">房间名称</th>
						<th width="160" field="roomType">房间类型</th>
						<th width="40" field="rentFee">月租</th>
						<th width="90" field="rentStatus">出租状态</th>
						<th width="80" field="isShow">发布状态</th>
						<th width="80" field="isTop">推荐房源</th>
						<th width="80" field="isPromotions">优先展示</th>
						<th width="60">房源包</th>
					</tr>
				</thead>
				<s:iterator value="roomList" id="room">
					<tr>
						<td><s:property value="#room.roomCode"/></td>
						<td>
							<a href="javascript:void(0)" onclick="view('<s:property value="#room.sysHouseId"/>')">
								<s:property value="#room.roomName"/>
							</a>
						</td>
						<td><s:property value="%{@cn.ziroom.system.action.DictAction@getValue(\'ROOM_TYPE\', #room.roomType)}"/></td>
						<td><s:property value="#room.rentFee"/></td>
						<td>
							<s:property value="%{@cn.ziroom.system.action.DictAction@getValue(\'ROOM_STATUS\', #room.rentStatus)}"/>
						</td>

						<td>
							<a href="#" onclick="pubRoom('<s:property value="#room.isShow"/>', '<s:property value="#room.sysRoomId"/>', '<s:property value="#room.rentStatus"/>')">
							<s:if test='#room.isShow=="N"'>未发布</s:if><s:else>已发布</s:else>
							</a>
						</td>
						<td>
							<s:if test='#room.isShow=="Y"'>
								<a href="#" onclick="recommendRoom('<s:property value="#room.sysRoomId"/>')">
									<s:if test='#room.isTop=="N"'>未推荐</s:if><s:else>已推荐</s:else>
								</a>
							</s:if>
							<s:else>
								<s:if test='#room.isTop=="N"'>未推荐</s:if><s:else>已推荐</s:else>
							</s:else>
						</td>
						<td>
							<s:if test='#room.isShow=="Y"'>
								<a href="#" onclick="priorityRoom('<s:property value="#room.sysRoomId"/>')">
								<s:if test='#room.isPromotions=="N"'>未选择</s:if><s:else>已选择</s:else>
								</a>
							</s:if>
							<s:else>
								<s:if test='#room.isPromotions=="N"'>未选择</s:if><s:else>已选择</s:else>
							</s:else>
						</td>
						<td>
							<a href='downHouse.do?room.roomId=<s:property value="#room.roomId"/>'>
								下载
							</a>
						</td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</body>
</html>
