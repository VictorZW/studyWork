<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="../common/server.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="../common/common.jsp"%>
<script type="text/javascript" src="<%=basePath%>pages/platform/jsp/role/roleUser.js" ></script>
</head>
  
<body>
	<table id="dataGrid" style="width:100%"></table>

	<div id="tb" style="padding:5px;">
		<div style="margin-bottom:5px;">
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="roleUser.add();">添加</a>
			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="roleUser.remove();">删除</a>
			<a href="<%=basePath%>pages/platform/jsp/role/index.jsp" class="easyui-linkbutton" iconCls="icon-remove" plain="true">返回</a>
		</div>
	</div>	
	<div id="roleUserDialog" class="easyui-dialog" title="分配角色" resizable="true" modal="true" close="true"
		style="width:700px;height:400px;left:auto;top:auto;">
		<table id="roleUserDataGrid" style="width:100%;height:400px"></table>
		<div id="table" style="padding:5px;">
		<div style="margin-bottom:5px;">
			<form id="searchForm" class="query  margin-left30 margin-top20">
			<table>
				<tr><td>
			         <span class=" margin-left20" > 登录账号:</span><input autocomplete="off" class="textbox" type="text" name="userCode" />
			         &nbsp;<span class=" margin-left20" > 人员姓名:</span><input autocomplete="off" class="textbox" type="text" name="userName" />
			         </td>
			         <td>
			         	&nbsp;<a class="easyui-linkbutton" iconCls="icon-search" onclick="searchFun();">查询</a>&nbsp;
			         	<a class="easyui-linkbutton" iconCls="icon-reload" onclick="cleanFun();">重置</a>
			         </td>
			    </tr>
			</table>
		</form>
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addRoleUser();">保存</a>
		</div>
	</div>
	</div>	
</body>
</html>
