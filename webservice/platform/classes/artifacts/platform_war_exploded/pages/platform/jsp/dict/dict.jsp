<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../common/server.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%@ include file="../common/common.jsp"%>
	<script type="text/javascript" src="<%=basePath%>pages/platform/jsp/dict/dict.js" ></script>
  </head>
<body>
    <div id="cc" class="easyui-layout" style="width:100%;height:100%;">        
    <div data-options="region:'west',title:'字典分类',split:true" style="width:45%;">
    	<div id="tb_t" style="padding:5px;">
		    <div style="margin-bottom:5px;">
		    <shiro:hasPermission name=" DictController:addDict">
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" id="insertType" onclick="insertDictType();">添加</a>
			</shiro:hasPermission>
			<shiro:hasPermission name=" DictController:addDict">
			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteDictType();">删除</a>
			</shiro:hasPermission>
			<!-- <a class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="saveDictType();">保存</a> -->
			</div>
   		</div>	
    	<table id="dictTree" style="width:99%"></table>  
    </div>   
    <div data-options="region:'center',title:'字典信息'" style="padding:5px;">
    	<div id="tb" style="padding:5px;">
    		<shiro:hasPermission name=" DictController:addDict">
    		<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addDict();">添加</a>
    		</shiro:hasPermission>
    	</div>
    	
    	<div id="dictDialog" class="easyui-dialog" title="新增字典" resizable="true" modal="true" close="true"
		style="width:400px;left:auto;top:auto;">
			<form id="addDict" method="post">
					<input type="hidden" id="parentNo" name="parentNo">
					<p class="p1">字典编码：<input autocomplete="off" type="text" class="textbox dialog" id="no" name="no"><span id="errorSpan2"></span></p>
					<p class="p1">字典名称：<input autocomplete="off" type="text" class="textbox dialog" id="dictName" name="dictName"><span id="errorSpan2"></span></p>
					<p class="p2"><input id=button1 type="button" class="button" value="保存" onclick="dictSubmit();" >&nbsp;&nbsp;<input id="buttosn2" type="button" class="button" onclick="submit1();" value="重置"></p>
			</form>
		</div>
		<table id="dataGrid" style="width:100%"></table>
    </div>   
	</div> 
  </body>
</html>
