<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/ziru" prefix="z"%>
   				<div region="north" border="false" style="height:94px;background:#A1C4ff">
   					<div class="header">
						<div style="padding:10px;text-align:right;">
							<span style="color:#ddd">欢迎你，${sessionScope.user.staffName}</span>
							<a id="logout" href="javascript:logout();" style="color:#fff">退出</a>
						</div>
						<div class="toptitle"></div>
					</div>
					<div class="topmenu">
						<a href="#" class="easyui-linkbutton" plain="true">首页</a>
						<z:function funCode="01"></z:function>
						<a href="javascript:void(0);" onclick="loadFunction('houseIndex.do?functionCode=\'01\'')" class="easyui-linkbutton" plain="true">房源管理</a>
						<a href="javascript:void(0);" class="easyui-linkbutton" plain="true">预约看房单</a>
						<a href="javascript:void(0);" class="easyui-menubutton" menu="#pubMenu" plain="true">信息发布</a>
						
						<z:function funCode="02">
						<a href="javascript:void(0);" class="easyui-menubutton" menu="#systemMenu" plain="true">系统管理</a>
						</z:function>
						<!--  
						<a href="javascript:void(0);" onclick="loadFunction('cI.do?functionCode=\'01\'')" class="easyui-linkbutton" plain="true">合同管理</a>
						<a href="javascript:void(0);" onclick="loadFunction('uI.do?functionCode=\'01\'')" class="easyui-linkbutton" plain="true">客户管理</a>
						<a href="javascript:void(0);" onclick="loadFunction('fI.do?functionCode=\'01\'')" class="easyui-linkbutton" plain="true">房间图片管理</a>
						<a href="javascript:void(0);" onclick="loadFunction('rI.do?functionCode=\'01\'')" class="easyui-linkbutton" plain="true">配置物品管理</a>
						-->
					</div>
					<div id="pubMenu" style="width:150px;">
						<div href="javascript:void(0);" onclick="loadFunction('homePageIndex.do')">首页管理</div>
						<div href="javascript:void(0);" onclick="loadFunction('')">专题页管理</div>
					</div>
					<!--  
					<div id="systemMenu" style="width:150px;">
						<z:function funCode="0201">
						<div onclick="loadFunction('userIndex.do?functionCode=\'0201\'')">用户管理</div>
						</z:function>
						<z:function funCode="0202">
						<div onclick="loadFunction('roleIndex.do?functionCode=\'0202\'')">角色管理</div>
						</z:function>
					</div>
					-->
				</div>
				<!--  
   				<div region="east" border="false" style="padding:5px;width:170px;border-left:1px solid #92B7D0">
					<div class="submenu" style="padding:0 20px;">
						<a href="#">房源管理</a>
					</div>
					<div class="submenu" style="padding:0 20px;">
						<a href="#">小区信息</a>
					</div>
   				</div>
   				-->