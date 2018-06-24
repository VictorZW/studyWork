<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/server.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="../common/common.jsp"%>
<script type="text/javascript"
	src="<%=basePath%>pages/platform/jsp/resource/resource.js"></script>
</head>
<body>
	<table id="dataGrid"></table>
	<div id="tb" style="padding: 5px;">
		<div style="padding: 0 0 0 7px;">
			<form id="resourceForm" method="post">
				<table>
					<tr>
						<td><span>资源名称:</span><input class="textbox" type="text"
							name="name" /> <span>关联菜单:</span><input class="textbox"
							type="text" name="menuCode" /> <span>权限字符串:</span><input
							class="textbox" type="text" name="permission" size="35" /></td>
						<td>&nbsp;<a class="easyui-linkbutton" iconCls="icon-search"
							onclick="searchFun();">查询</a>&nbsp; <a class="easyui-linkbutton"
							iconCls="icon-reload" onclick="cleanFun();">重置</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<!-- <div id="tb" style="padding:5px;"> -->
		<div style="margin-bottom: 5px;">
			<shiro:hasPermission name="ResourceController:insert">
				<a class="easyui-linkbutton" iconCls="icon-add" plain="true"
					onclick="resourceObject.add();">添加</a>
			</shiro:hasPermission>
			<shiro:hasPermission name="ResourceController:edit">
				<a class="easyui-linkbutton" iconCls="icon-edit" plain="true"
					onclick="resourceObject.edit();">修改</a>
			</shiro:hasPermission>
			<shiro:hasPermission name="ResourceController:remove">
				<a class="easyui-linkbutton" iconCls="icon-add" plain="true"
					onclick="resourceObject.remove();">删除</a>
			</shiro:hasPermission>
		</div>
		<!-- </div> -->
		<div id="resourceDialog" class="easyui-dialog" title="编辑资源信息"
			resizable="true" modal="true" close="true"
			style="width: 400px; height: 300px; left: auto; top: auto;">
			<form id="resetForm" method="post">
				<table class="dialogTable" align="center" border="0">
					<tr>
						<td><input type="hidden" class="checkbox dialog" id="id"
							name="id"></td>
					</tr>
					<tr>
						<td>资源名称&nbsp;&nbsp;&nbsp;： <input type="text"
							class="textbox dialog" id="name" name="name" size="32"><span
							id="errorSpan"></span></td>
					</tr>
					<tr>
						<td>url&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：
							<input type="text" class="textbox dialog" id="url" name="url"
							size="32">
					<tr>
						<td>关联菜单&nbsp;&nbsp;&nbsp;： <input id="menuCode"
							name="menuCode" size="30"></td>
					</tr>
					<tr>
						<td>类型&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：
							<input id="type" name="type" size="30">
						</td>
					</tr>
					<tr>
						<td>权限字符串： <input type="text" class="textbox dialog"
							id="permission" name="permission" size="32"></td>
					</tr>
					<tr>
						<td>资源编码&nbsp;&nbsp;&nbsp;： <input type="text"
							class="textbox dialog" id="resCode" name="resCode" size="32"></td>
					</tr>
					<tr>
						<td>资源类型&nbsp;&nbsp;&nbsp;： <input type="text"
							class="textbox dialog" id="resType" name="resType" size="32"></td>
					</tr>
					<tr align="center" colspan="2">
						<td><input type="button" class="button" value="保存"
							onclick="resourceObject.submit()">&nbsp;&nbsp;<input
							type="reset" class="button" value="重置"></td>
					</tr>
				</table>
			</form>
		</div>
</body>
</html>