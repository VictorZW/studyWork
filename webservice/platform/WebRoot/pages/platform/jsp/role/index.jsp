<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="../common/server.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="../common/common.jsp"%>
<base href="<%=basePath%>">
    
<title>角色管理</title>
<script type="text/javascript">
var path="<%=path%>";
</script>
<script type="text/javascript" charset="utf-8">
<%@ include file="index.js"%>
</script>
</head>
  
<body>
	<table id="dataGrid"></table>

	<div id="tb" style="padding:5px;">
		<div style="padding:0 0 0 7px;">
		<form id="roleForm" method="post">
			<table>
				<tr>
					<td>
			        	<span> 角色名称:</span><input class="textbox" type="text" name="roleName" />
			        </td>
			        <td>
					&nbsp;<a class="easyui-linkbutton" iconCls="icon-search" onclick="searchFun();">查询</a>&nbsp;
			         	<a class="easyui-linkbutton" iconCls="icon-reload" onclick="cleanFun();">重置</a>
			        </td>
			    </tr>
			</table>
		</form>
		</div>
		<!-- <div style="margin-bottom:5px;display: none;"> -->
		<div style="margin-bottom:5px;">
		<%-- <shiro:hasPermission name=" RoleController:insert"> --%>
		<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="roleObject.add();">添加</a>
		<%-- </shiro:hasPermission> --%>
			<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="roleObject.edit();">修改</a>
			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="roleObject.remove();">删除</a>
			
		</div>
	</div>
	<div id="roleDialog" class="easyui-dialog" title="编辑角色信息" resizable="true" modal="true" close="true"
		style="width:400px;height:160px;left:auto;top:auto;">
		<form id="resetForm" method="post">
				<table class="dialogTable" align="center" border="0" >
					<tr><td><input type="hidden" name="roleCode"></td></tr>
					<tr><td>角色名称：<input type="text" class="textbox dialog" id="roleName" name="roleName"><span id="errorSpan"></span></td></tr>
					<tr><td>角色描述：<input type="text" class="textbox dialog" id="describe" name="describe"></td></tr> 	
					<tr align="center" colspan="2"><td ><input type="button" class="button" value="保存" onclick="roleObject.submit()" >&nbsp;&nbsp;<input type="reset" class="button" value="重置"></td></tr>
				</table>
		</form>
	</div>
	
	<div id="rolePowerDialog" class="easyui-dialog" title="权限分配" resizable="true" modal="true" close="true"
		style="width:400px;height:450px;left:auto;top:auto;">
    	<div style="margin-bottom:5px;">
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="RoleMenu.del();" onMouseUp="RoleMenu.add();">保存</a>
		</div>
    	<div>
    		<ul id="rolePowerTree"></ul>
    	</div>
	</div>
</body>
</html>
