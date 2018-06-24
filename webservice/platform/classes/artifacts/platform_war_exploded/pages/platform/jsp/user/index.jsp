<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../common/server.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="../common/common.jsp"%>
<script type="text/javascript"
	src="<%=basePath%>pages/platform/jsp/user/index.js"></script>
</head>

<body>
	<table id="dataGrid" style="width: 100%"></table>

	<div id="tb" style="padding: 5px;">
		<div style="padding: 0 0 0 7px; color: #333;">
			<form id="searchForm" class="query  margin-left30 margin-top20">
				<table>
					<tr>
						<td><span class=" margin-left20"> 登录账号:</span><input
							autocomplete="off" class="textbox" type="text" name="userCode" />
							&nbsp;<span class=" margin-left20"> 人员姓名:</span><input
							autocomplete="off" class="textbox" type="text" name="userName" />
							&nbsp;<span class=" margin-left20"> 所属部门:</span><input
							autocomplete="off" id="orgName" type="text" name="orgName"
							data-options="editable:false" /></td>
						<td>&nbsp;<a class="easyui-linkbutton" iconCls="icon-search"
							onclick="searchFun();">查询</a>&nbsp; <a class="easyui-linkbutton"
							iconCls="icon-reload" onclick="cleanFun();">重置</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div style="margin-bottom: 5px;">
			<shiro:hasPermission name=" UserController:insert">
				<a class="easyui-linkbutton" iconCls="icon-add" plain="true"
					onclick="userObject.add();">添加</a>
			</shiro:hasPermission>
			<shiro:hasPermission name=" UserController:update">
				<a class="easyui-linkbutton" iconCls="icon-edit" plain="true"
					onclick="userObject.edit();">修改</a>
			</shiro:hasPermission>
			<shiro:hasPermission name=" UserController:delete">
				<a class="easyui-linkbutton" iconCls="icon-remove" plain="true"
					onclick="userObject.remove();">删除</a>
			</shiro:hasPermission>
			<shiro:hasPermission name=" UserController:resetPassWord">
				<a class="easyui-linkbutton" iconCls="icon-reload" plain="true"
					onclick="userObject.reset();">重置密码</a>
			</shiro:hasPermission>
			<shiro:hasPermission name=" UserController:insert">
				<a class="easyui-linkbutton" iconCls="icon-import" plain="true"
					onclick="userObject.import();">导入</a>
			</shiro:hasPermission>
			<shiro:hasPermission name=" UserController:insert">
				<a class="easyui-linkbutton" iconCls="icon-redo" plain="true"
					onclick="userObject.export();">导出</a>
			</shiro:hasPermission>
			<a class="easyui-linkbutton" iconCls="icon-template" plain="true"
				onclick="userObject.template();">下载</a>
		</div>
	</div>

	<div id="userDialog" class="easyui-dialog" title="编辑人员信息"
		resizable="true" modal="true" close="true"
		style="width: 400px; left: auto; top: auto;">
		<form id="addForm" method="post">
			<p class="p1">
				登录账号：<input autocomplete="off" type="text" class="textbox dialog"
					id="uCode" name="userCode"><span id="errorSpan1"></span>
			</p>
			<p id="p1" class="p1">
				人员姓名：<input autocomplete="off" type="text" class="textbox dialog"
					id="uName" name="userName"><span id="errorSpan2"></span>
			</p>
			<p id="p2" class="p1">
				登录密码：<input autocomplete="off" type="password"
					class="textbox dialog" id="passWord" name="password"><span
					id="errorSpan3"></span>
			</p>
			<p id="p3" class="p1">
				所属部门：<input autocomplete="off" type="text" class="dialog" id="uOrg"
					name="orgName" data-options="editable:false">
			</p>
			<p id="p5" class="p1">
				员工工号：<input autocomplete="off" type="text" class="textbox dialog"
					id="jobnum" name="jobNum"><span id="errorSpan4"></span>
			</p>
			<p id="p6" class="p1">
				手机号码：<input autocomplete="off" type="text" class="textbox dialog"
					id="cellphone" name="cellPhone"><span id="errorSpan5"></span>
			</p>
			<p class="p2">
				<input id=button1 type="button" class="button" value="保存"
					onclick="userObject.submit()">&nbsp;&nbsp;<input
					id="buttosn2" type="button" class="button" onclick="submit2();"
					value="重置">
			</p>
		</form>
	</div>
	<div id="codeDialog" class="easyui-dialog" title="重置密码"
		resizable="true" modal="true" close="true"
		style="width: 400px; height: 160px; left: auto; top: auto;">
		<form id="resetForm" method="post">
			<table class="dialogTable" align="center" border="0">
				<tr>
					<td><input type="hidden" name="userCode"></td>
				</tr>
				<tr>
					<td>新密码：&nbsp;<input type="password" class="textbox dialog"
						id="alterPassWord" name="alterPassword"></td>
				</tr>
				<tr>
					<td>重复密码：<input type="password" class="textbox dialog"
						id="confirm1" name="confirm1"></td>
				</tr>
				<tr align="center" colspan="2">
					<td><input type="button" class="button" value="保存"
						onclick="submit1();">&nbsp;&nbsp;<input type="button"
						class="button" onclick="submit2();" value="重置"></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="importExcelDialog" class="easyui-dialog" title="用户信息导入"
		resizable="true" modal="true" close="true"
		style="width: 400px; height: 300px; left: auto; top: auto;">
		<div class="ftitle">用户信息导入</div>
		<form id="importExcelForm" method="post" enctype="multipart/form-data">
			<table align="center" style="padding: 20px;border-collapse:separate; border-spacing:0px 30px;" border="0" width="90%;"
				id="impotExcelTable">
				<tr>
					<td align="center">
						<p style="magin: 0 auto">
							Excel文件：<input type="file" id="excelFile" name="file">
						</p>
					</td>
				</tr>
				<tr>
					<td align="center"><a class="easyui-linkbutton"
						iconCls="icon-redo" type="submit"
						onclick="userObject.importExcel()">开始上传</a></td>
				</tr>
			</table>
		</form>
	</div>
<div class="bg-z"></div>
<div class="spinner">
  <div class="rect1"></div>
  <div class="rect2"></div>
  <div class="rect3"></div>
  <div class="rect4"></div>
  <div class="rect5"></div>
</div>
</body>
</html>
