<%@ page language="java" import="java.util.*"  contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../common/server.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="../common/common.jsp"%>
	<script type="text/javascript" src="<%=basePath%>pages/platform/jsp/menu/menu.js" ></script>
  </head>
  
  <body>
  <div id="tb" style="padding:5px;">
  <div style="margin-bottom:5px;">
  	<shiro:hasPermission name=" MenusController:insertParent">
	<a class="easyui-linkbutton" iconCls="icon-add" plain="true" id="insertParent" onclick="insertParent();">添加根节点</a>
	</shiro:hasPermission>
  	<shiro:hasPermission name=" MenusController:insertChild">
	<a class="easyui-linkbutton" iconCls="icon-add" plain="true" id="insertChild" onclick="insertChild();">添加子节点</a>
	</shiro:hasPermission>
	<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="deleteMenu();">删除</a>
	</div>
   </div>	
    <table id="MenuTree" style="width:99%"></table> 
  </body>
</html>
