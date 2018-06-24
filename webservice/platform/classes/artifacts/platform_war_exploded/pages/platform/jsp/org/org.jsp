<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../common/server.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<%@ include file="../common/common.jsp"%>
	<script type="text/javascript" src="<%=basePath%>pages/platform/jsp/org/org.js" ></script>
  </head>
  
  <body>
    <div id="cc" class="easyui-layout" style="width:100%;height:100%;">        
    <div data-options="region:'west',title:'部门',split:true" style="width:20%;">
    	<ul id="orgTree"></ul>
    	<div id="mm" class="easyui-menu" style="width:120px;">
			<div onclick="append();" data-options="iconCls:'icon-add'">添加部门</div>
			<div onclick="del();" data-options="iconCls:'icon-remove'">删除部门</div>
		</div>  
    </div>   
    <div data-options="region:'center',title:'人员信息'" style="padding:5px;">
    		
    	<table id="dataGrid" style="width:100%"></table>
    	<div id="tb" style="padding:5px;">
    		<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="orgObject.add();">添加</a>
<!-- 			<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="orgObject.del();">删除</a>
 -->    	</div>
    	 <div id="orgUserDialog" class="easyui-dialog" title="分配人员" resizable="true" modal="true" close="true"
		style="width:600px;height:460px;left:auto;top:auto;">
		<table id="orgUserDataGrid" style="width:100%"></table>
		<div id="table" style="padding:5px;">

			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addOrgUser();">保存</a>

		</div>
		</div>
    </div>   
	</div> 
  </body>
</html>
