<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>房屋/房间发布页</title>
		<%@ include file="/include/resources.jsp" %>
		
	</head>
	<body>
		<div style="padding:5px;background:#fafafa;border-bottom:1px solid #eee;">
			<table cellpadding="0" cellspacing="0" style="width:100%">
				<tr>
					<td style="text-align:left">
					<s:if test="house!=null">
						<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-ok" onclick="submitHouseForm();">发布</a>
					</s:if>
					<s:if test="room!=null">
						<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-ok" onclick="submitRoomForm();">发布</a>
					</s:if>
					</td>
					<td style="text-align:right">
						<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-cancel" onclick="javascript:$('#pubDial').dialog('close')">关闭</a>
					</td>
				</tr>
			</table>
		</div>
		<form action="" method="post" id="pubForm">
		<div style="padding:10px">
			<div style="padding-left:5px;padding-right: 5px">
				<table cellpadding="0" cellspacing="0" class="form-table" border="0" width="660">
					<s:if test="house!=null">
						<input type="hidden" name="house.sysHouseId" value='<s:property value="house.sysHouseId"/>'/>
						<tr>
							<th>房屋名称：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc"><s:property value="house.title"/></td>
							<th>房屋编号：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc"><s:property value="house.houseCode"/></td>
							<th>商圈：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc">
								<s:property value="house.city"/><s:property value="house.counties"/><s:property value="house.shopping"/>
							</td>
						</tr>
						<tr>
							<th>管家名称：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc"><s:property value="house.stewardName"/></td>
							<th></th>
							<td></td>
							<th>出租状态：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc"><s:property value="%{@cn.ziroom.system.action.DictAction@getValue(\'HOUSE_STATUS\', house.rentStatus)}"/></td>
						</tr>
						<tr>
							<th>入住时间:</th>
							<td colspan="5"><input id="checkInTime"  type="text" name="house.checkInTime" value='<s:property value="house.checkInTime"/>'/></td>
						</tr>
					</s:if>
					<s:if test="room!=null">
						<input type="hidden" name="room.sysRoomId" value='<s:property value="room.sysRoomId"/>'/>
						<tr>
							<th>房间编号：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc"><s:property value="room.roomCode"/></td>
							<th>房屋编号：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc"><s:property value="room.houseCode"/></td>
							<th>房间名称：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc">
								<s:property value="room.roomName"/>
							</td>
						</tr>
						<tr>
							<th>出租价格：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc"><s:property value="room.rentFee"/></td>
							<th></th>
							<td></td>
							<th>出租状态：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc"><s:property value="%{@cn.ziroom.system.action.DictAction@getValue(\'ROOM_STATUS\', room.rentStatus)}"/></td>
						</tr>
						<tr>
							<th>入住时间:</th>
							<td colspan="5"><input id="checkInTime" editable="false"  type="text" name="room.checkInTime" value='<s:property value="room.checkInTime"/>'/></td>
						</tr>
					</s:if>
				</table>
			</div>
		</div>
		</form>
		<script type="text/javascript">
			$(function(){
				$("#checkInTime").datebox({					
					editable:false
				});
			});
		</script>
	</body>
</html>