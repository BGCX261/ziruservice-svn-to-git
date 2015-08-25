 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib uri="/ziru" prefix="z"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="height:100%">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>网站管理后台</title>
        
        <%@ include file="/include/resources.jsp" %>
        
        <script type="text/javascript">
        	$.parser.onComplete = function(){
            	$('body').css('visibility','visible');
        	};
        	$(function(){
            	$(window).resize(function(){
                	$('#mainlayout').layout('resize');
            	});
            	<z:function funCode="01">
            		$("#main").panel("refresh", "houseIndex.do?functionCode='01'");
                </z:function>
        	});
        	function logout(){
        		$.post("logout.do",function(){
        			window.location.href="index.jsp";
        		});
        	}
        </script>
    </head>
    <body style="margin:0;padding:0;height:100%;overflow:hidden;background:#F2FBFF">
   		<div class="mainwrap">
   			<div id="mainlayout" class="easyui-layout" fit="true">
   				<%@ include file="/include/menu.jsp" %>
    			<div region="center" border="false" style="overflow:hidden" id="main">
    			
    			
    			
    			
    			
    			</div>
    			<%@ include file="/include/footer.jsp" %>
			</div>
		</div>
	</body>
</html>
    				
    			