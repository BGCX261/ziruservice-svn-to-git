<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>房屋/房间详情页</title>
		<%@ include file="/include/resources.jsp" %>
	</head>
	<body>
		
		<div style="padding:5px;background:#fafafa;border-bottom:1px solid #eee;">
			<table cellpadding="0" cellspacing="0" style="width:100%">
				<tr>
					<td style="text-align:right">
						<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-cancel" onclick="javascript:$('#viewDial').dialog('close')">关闭</a>
					</td>
				</tr>
			</table>
		</div>
		<div style="padding:10px">
			<div style="padding-left:5px;padding-right: 5px">
				<table cellpadding="0" cellspacing="0" class="form-table" border="0" width="900">
						<tr>
							<th>房源名称：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc"><s:property value="house.title"/></td>
							<th>房源编号：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc"><s:property value="house.houseCode"/></td>
							<th>房屋编号：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc">
								<s:property value="house.dictHouseCode"/>
							</td>
							<th>商圈：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc">
								<s:property value="%{@cn.common.resource.ResourceBuilder@getValue(3, house.city)}"/>
								<s:property value="%{@cn.common.resource.ResourceBuilder@getValue(4, house.counties)}"/>
								<s:property value="%{@cn.common.resource.ResourceBuilder@getValue(5, house.shopping)}"/>
							</td>
						</tr>
						<tr>
							<th>环线：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc">
								<s:property value="%{@cn.common.resource.ResourceBuilder@getValue(6, house.cycle)}"/>
							</td>
							<th>环线方位：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc">
								<s:property value="%{@cn.common.resource.ResourceBuilder@getValue(7, house.cycleFace)}"/>
							</td>
							<th>地铁线路：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc">
								<s:property value="%{@cn.common.resource.ResourceBuilder@getValue(1, house.subwayLine)}"/>
							</td>
							<th>地铁站点：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc">
								<s:property value="%{@cn.common.resource.ResourceBuilder@getValue(2, house.subwayStations)}"/>
							</td>
						</tr>
						<tr>
							<th>楼牌号：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc"><s:property value="house.building"/></td>
							<th>单元：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc"><s:property value="house.unit"/></td>
							<th>楼层：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc">
								<s:property value="house.floor"/>/<s:property value="house.totalFloor"/>
							</td>
							<th>门牌号：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc">
								<s:property value="house.houseNumber"/>
							</td>
						</tr>
						<tr>
							<th>建筑类型：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc">
								<s:property value="%{@cn.ziroom.system.action.DictAction@getValue(\'BUILDING_TYPE\', house.buildType)}"/>
							</td>
							<th></th>
							<td style="text-align:left;border-bottom:1px solid #ccc"></td>
							<th>房屋朝向：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc">
								<s:property value="%{@cn.ziroom.system.action.DictAction@getValue(\'HOUSE_FACE\', house.houseFace)}"/>
							</td>
							<th>房屋面积：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc">
								<s:property value="house.houseArea"/>
							</td>
						</tr>
						<tr>
							<th>供暖方式：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc">
								<s:property value="%{@cn.ziroom.system.action.DictAction@getValue(\'HEATING_TYPE\', house.heating)}"/>
							</td>
							<th>户型：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc">
								<s:property value="house.decorateBedroomNum"/>室
								<s:property value="house.decorateLivingNum"/>厅
								<s:property value="house.decorateBathroomNum"/>卫
								<s:property value="house.decorateKitchenNum"/>厨
								<s:property value="house.decorateBalcony"/>阳台
								<s:property value="house.decorateGarden"/>花园
								<s:property value="house.decorateGazebo"/>露台
							</td>
							<th>出租价格：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc">
								<s:property value="house.payment"/>
							</td>
							<th>电梯情况：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc">
								<s:property value="house.ladder"/>梯<s:property value="house.household"/>户
							</td>
						</tr>
						<tr>
							<th>房源产品：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc">
								<s:property value="%{@cn.ziroom.system.action.DictAction@getValue(\'HOUSE_PRODUCT\', house.houseProduct)}"/>
							</td>
							<th>房源状态：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc">
								<s:property value="%{@cn.ziroom.system.action.DictAction@getValue(\'HOUSE_STATUS\', house.houseStatus)}"/>
							</td>
							<th>出租状态：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc">
								<s:property value="%{@cn.ziroom.system.action.DictAction@getValue(\'HOUSE_STATUS\', house.rentStatus)}"/>
							</td>
							<th>小区宽带：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc">
								<s:property value="house.broadband"/>
							</td>
						</tr>
						<tr>
							<th>房屋信息：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc" colspan="7"><s:property value="house.houseEvaluate"/></td>
						</tr>
						<tr>
							<th>房屋特色：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc" colspan="7"><s:property value="house.characteristics"/></td>
						</tr>
						<tr>
							<th>环境评价：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc" colspan="7"><s:property value="house.environmentEvaluate"/></td>
						</tr>
						<tr>
							<th>管家名称：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc"><s:property value="house.stewardName"/></td>
							<th>管家电话：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc">
								<s:property value="house.stewardPhone"/>
							</td>
							<th>经纪人名称：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc">
								<s:property value="house.agentName"/>
							</td>
							<th>经济人电话：</th>
							<td style="text-align:left;border-bottom:1px solid #ccc">
								<s:property value="house.agentPhone"/>
							</td>
						</tr>
						<tr height="20"><td colspan="8"></td></tr>
						<tr>
							<td colspan="8">
								<div class="easyui-tabs" fit="true" plain="true" style="height:400px;width:300px;">
									<s:iterator value="house.roomList" id="room">
										<s:if test='#room.roomType!="KITCHEN"'>
											<div title="<s:property value="%{@cn.ziroom.system.action.DictAction@getValue(\'HOUSE_FACE\', #room.roomPosition)}"/><s:property value="#room.roomCode"/>" style="padding:10px;">
											<table cellpadding="0" cellspacing="0" class="form-table" border="0" width="850">
												<tr>
													<th>房间编码：</th>
													<td style="text-align:left;border-bottom:1px solid #ccc"><s:property value="#room.roomCode"/></td>
													<th>房间名称：</th>
													<td style="text-align:left;border-bottom:1px solid #ccc"><s:property value="#room.roomName"/></td>
													<th>房间类型：</th>
													<td style="text-align:left;border-bottom:1px solid #ccc">
														<s:property value="%{@cn.ziroom.system.action.DictAction@getValue(\'ROOM_TYPE\', #room.roomType)}"/>
													</td>
													<th>房间面积：</th>
													<td style="text-align:left;border-bottom:1px solid #ccc">
														<s:property value="#room.roomArea"/>
													</td>
												</tr>
												<tr>
													<th>窗户朝向：</th>
													<td style="text-align:left;border-bottom:1px solid #ccc">
														<s:property value="%{@cn.ziroom.system.action.DictAction@getValue(\'WINDOW_FACE\', #room.roomPosition)}"/>
													</td>
													<th>出房价格：</th>
													<td style="text-align:left;border-bottom:1px solid #ccc"><s:property value="#room.rentFee"/></td>
													<th>付款方式：</th>
													<td style="text-align:left;border-bottom:1px solid #ccc">
														<s:property value="#room.payWay"/>
													</td>
													<th>隔音效果：</th>
													<td style="text-align:left;border-bottom:1px solid #ccc">
														<s:property value="#room.noiseEffect"/>
													</td>
												</tr>
												<tr>
													<th>卧室面积：</th>
													<td style="text-align:left;border-bottom:1px solid #ccc" colspan="7">
														长：<s:property value="#room.roomLength"/>
														宽：<s:property value="#room.roomWidth"/>
														高：<s:property value="#room.roomHeight"/>
													</td>
												</tr>
												<tr>
													<th>卧室特色：</th>
													<td style="text-align:left;border-bottom:1px solid #ccc" colspan="7">
														<s:property value="#room.roomComment"/>
													</td>
												</tr>
												
												<s:if test='#room.tolietExist=="Y"'>
													<tr>
														<th>卫生间面积：</th>
														<td style="text-align:left;border-bottom:1px solid #ccc">
															长：<s:property value="#room.toiletLength"/>
															宽：<s:property value="#room.toiletWidth"/>
															高：<s:property value="#room.toiletHeight"/>
														</td>
														<th>是否有窗户：</th>
														<td style="text-align:left;border-bottom:1px solid #ccc">
															<s:property value="%{@cn.ziroom.system.action.DictAction@getValue(\'HAVE_WINDOW\', #room.toiletWindow)}"/>
														</td>
														<th>是否有窗帘：</th>
														<td style="text-align:left;border-bottom:1px solid #ccc">
															<s:property value="%{@cn.ziroom.system.action.DictAction@getValue(\'HAVE_CURTAIN\', #room.toiletCurtain)}"/>
														</td>
														<th>是否排气扇：</th>
														<td style="text-align:left;border-bottom:1px solid #ccc">
															<s:property value="%{@cn.ziroom.system.action.DictAction@getValue(\'HAVE_CURTAIN\', #room.toiletFan)}"/>
														</td>
													</tr>
													<tr>
														<th>卫生间特色：</th>
														<td style="text-align:left;border-bottom:1px solid #ccc" colspan="7">
															<s:property value="#room.toiletDesc"/>
														</td>
													</tr>
												</s:if>
												
												<s:if test='#room.balconyExist=="Y"'>
													<tr>
														<th>阳台面积：</th>
														<td style="text-align:left;border-bottom:1px solid #ccc">
															长：<s:property value="#room.balconyLength"/>
															宽：<s:property value="#room.balconyWidth"/>
															高：<s:property value="#room.balconyHeight"/>
														</td>
														<th>阳台形状：</th>
														<td style="text-align:left;border-bottom:1px solid #ccc" colspan="5">
															<s:property value="#room.balconyType"/>
														</td>
													</tr>
													<tr>
														<th>阳台特色：</th>
														<td style="text-align:left;border-bottom:1px solid #ccc" colspan="7">
															<s:property value="#room.balconyDesc"/>
														</td>
													</tr>
												</s:if>
												
												<s:if test='#room.garderExist=="Y"'>
													<tr>
														<th>花园面积：</th>
														<td style="text-align:left;border-bottom:1px solid #ccc">
															长：<s:property value="#room.gardenLength"/>
															宽：<s:property value="#room.gardenWidth"/>
															高：<s:property value="#room.gardenHeight"/>
														</td>
														<th>花园类型：</th>
														<td style="text-align:left;border-bottom:1px solid #ccc">
															<s:property value="#room.gardenType"/>
														</td>
														<th>天然泥土：</th>
														<td style="text-align:left;border-bottom:1px solid #ccc" colspan="5">
															<s:property value="#room.gardenClay"/>
														</td>
													</tr>
													<tr>
														<th>花园特色：</th>
														<td style="text-align:left;border-bottom:1px solid #ccc" colspan="7">
															<s:property value="#room.gardenDesc"/>
														</td>
													</tr>
												</s:if>
												
												<s:if test='#room.terraceExist=="Y"'>
													<tr>
														<th>露台面积：</th>
														<td style="text-align:left;border-bottom:1px solid #ccc" colspan="7">
															长：<s:property value="#room.terraceLength"/>
															宽：<s:property value="#room.terraceWidth"/>
															高：<s:property value="#room.terraceHeight"/>
														</td>
													</tr>
													<tr>
														<th>花园特色：</th>
														<td style="text-align:left;border-bottom:1px solid #ccc" colspan="7">
															<s:property value="#room.terraceDesc"/>
														</td>
													</tr>
												</s:if>
												
											</table>
										</s:if>
										<s:else>
											<div title="公共区域" style="padding:10px;">
											<table cellpadding="0" cellspacing="0" class="form-table" border="0" width="850">
												<tr>
													<th>客厅面积：</th>
													<td style="text-align:left;border-bottom:1px solid #ccc">
														长：<s:property value="#room.saloonLength"/>
														宽：<s:property value="#room.saloonWidth"/>
														高：<s:property value="#room.saloonHeight"/>
													</td>
													<th>地面材料：</th>
													<td style="text-align:left;border-bottom:1px solid #ccc">
														<s:property value="%{@cn.ziroom.system.action.DictAction@getValue(\'FLOOR_MATERIAL\', #room.saloonMaterial)}"/>
													</td>
													<th>主色调：</th>
													<td style="text-align:left;border-bottom:1px solid #ccc"><s:property value="#room.saloonMaster"/></td>
													<th>窗户朝向：</th>
													<td style="text-align:left;border-bottom:1px solid #ccc">
														<s:property value="#room.saloonPosition"/>
													</td>
												</tr>
												<tr>
													<th>客厅特色：</th>
													<td style="text-align:left;border-bottom:1px solid #ccc" colspan="7">
														<s:property value="#room.saloonDesc"/>
													</td>
												</tr>
												
												<tr>
													<th>厨房面积：</th>
													<td style="text-align:left;border-bottom:1px solid #ccc">
														长：<s:property value="#room.kitchenLength"/>
														宽：<s:property value="#room.kitchenWidth"/>
														高：<s:property value="#room.kitchenHeight"/>
													</td>
													<th colspan="2">燃气灶类型：</th>
													<td style="text-align:left;border-bottom:1px solid #ccc">
														<s:property value="%{@cn.ziroom.system.action.DictAction@getValue(\'GAS_STOVE_TYPE\', #room.kitchenStove)}"/>
													</td>
													<th colspan="2">燃气接入类型：</th>
													<td style="text-align:left;border-bottom:1px solid #ccc">
														<s:property value="%{@cn.ziroom.system.action.DictAction@getValue(\'GAS_INTERFACE_TYPE\', #room.kitchenGastype)}"/>
													</td>
												</tr>
												<tr>
													<th>厨房特色：</th>
													<td style="text-align:left;border-bottom:1px solid #ccc" colspan="7">
														<s:property value="#room.kitchenDesc"/>
													</td>
												</tr>
												
												<s:if test='#room.tolietExist=="Y"'>
													<tr>
														<th>卫生间面积：</th>
														<td style="text-align:left;border-bottom:1px solid #ccc">
															长：<s:property value="#room.toiletLength"/>
															宽：<s:property value="#room.toiletWidth"/>
															高：<s:property value="#room.toiletHeight"/>
														</td>
														<th>是否有窗户：</th>
														<td style="text-align:left;border-bottom:1px solid #ccc">
															<s:property value="%{@cn.ziroom.system.action.DictAction@getValue(\'HAVE_WINDOW\', #room.toiletWindow)}"/>
														</td>
														<th>是否有窗帘：</th>
														<td style="text-align:left;border-bottom:1px solid #ccc">
															<s:property value="%{@cn.ziroom.system.action.DictAction@getValue(\'HAVE_CURTAIN\', #room.toiletCurtain)}"/>
														</td>
														<th>是否排气扇：</th>
														<td style="text-align:left;border-bottom:1px solid #ccc">
															<s:property value="%{@cn.ziroom.system.action.DictAction@getValue(\'HAVE_CURTAIN\', #room.toiletFan)}"/>
														</td>
													</tr>
													<tr>
														<th>卫生间特色：</th>
														<td style="text-align:left;border-bottom:1px solid #ccc" colspan="7">
															<s:property value="#room.toiletDesc"/>
														</td>
													</tr>
												</s:if>
												
												<s:if test='#room.balconyExist=="Y"'>
													<tr>
														<th>阳台面积：</th>
														<td style="text-align:left;border-bottom:1px solid #ccc">
															长：<s:property value="#room.balconyLength"/>
															宽：<s:property value="#room.balconyWidth"/>
															高：<s:property value="#room.balconyHeight"/>
														</td>
														<th>阳台形状：</th>
														<td style="text-align:left;border-bottom:1px solid #ccc" colspan="5">
															<s:property value="#room.balconyType"/>
														</td>
													</tr>
													<tr>
														<th>阳台特色：</th>
														<td style="text-align:left;border-bottom:1px solid #ccc" colspan="7">
															<s:property value="#room.balconyDesc"/>
														</td>
													</tr>
												</s:if>
												
												<s:if test='#room.garderExist=="Y"'>
													<tr>
														<th>花园面积：</th>
														<td style="text-align:left;border-bottom:1px solid #ccc">
															长：<s:property value="#room.gardenLength"/>
															宽：<s:property value="#room.gardenWidth"/>
															高：<s:property value="#room.gardenHeight"/>
														</td>
														<th>花园类型：</th>
														<td style="text-align:left;border-bottom:1px solid #ccc">
															<s:property value="#room.gardenType"/>
														</td>
														<th>天然泥土：</th>
														<td style="text-align:left;border-bottom:1px solid #ccc" colspan="5">
															<s:property value="#room.gardenClay"/>
														</td>
													</tr>
													<tr>
														<th>花园特色：</th>
														<td style="text-align:left;border-bottom:1px solid #ccc" colspan="7">
															<s:property value="#room.gardenDesc"/>
														</td>
													</tr>
												</s:if>
												
												<s:if test='#room.terraceExist=="Y"'>
													<tr>
														<th>露台面积：</th>
														<td style="text-align:left;border-bottom:1px solid #ccc" colspan="7">
															长：<s:property value="#room.terraceLength"/>
															宽：<s:property value="#room.terraceWidth"/>
															高：<s:property value="#room.terraceHeight"/>
														</td>
													</tr>
													<tr>
														<th>花园特色：</th>
														<td style="text-align:left;border-bottom:1px solid #ccc" colspan="7">
															<s:property value="#room.terraceDesc"/>
														</td>
													</tr>
												</s:if>
											</table>
										</s:else>
										</div>
									</s:iterator>
								</div>
							</td>
						</tr>
				</table>
			</div>
		</div>
	</body>
</html>