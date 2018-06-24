<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
		pageEncoding="utf-8"%>
<%@ include file="../common/server.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="../common/common.jsp"%>
	<script type="text/javascript" src="<%=basePath%>pages/platform/jsp/message/message.js" ></script>
  </head>
  
  <body>
   		<table id="dataGrid"></table>
   		<div id="tb" style="padding: 5px;">
   			<div style="padding:0 0 0 7px;color:#333;">
		<form id="searchForm" class="query  margin-left30 margin-top20">
			<table>
				<tr><td>
			         <span class=" margin-left20" > 发送人:</span><input autocomplete="off" class="textbox" type="text" name="sender" />
			         &nbsp;<span class=" margin-left20" > 消息类别:</span><input autocomplete="off" class="textbox" type="text" name="type" />
			         &nbsp;<span class=" margin-left20" > 发送时间:</span><input id="dd" type="text" class="easyui-datebox" name="time" ></input>
			         </td>
			         <td>
			         	&nbsp;<a class="easyui-linkbutton" iconCls="icon-search" onclick="searchFun();">查询</a>&nbsp;
			         	<a class="easyui-linkbutton" iconCls="icon-reload" onclick="cleanFun();">重置</a>
			         </td>
			    </tr>
			</table>
		</form>
		</div>
		<div style="margin-bottom:5px;">
		<shiro:hasPermission name="messageController:insert">
		<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="messageObject.add();">添加</a>
		</shiro:hasPermission>
		<shiro:hasPermission name="messageController:update">
		<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="messageObject.edit();">修改</a>
		</shiro:hasPermission>
		<shiro:hasPermission name="messageController:remove">
		<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="messageObject.remove();">删除</a>
		</shiro:hasPermission>
	</div>
	 </div>
		<div id="messageDialog" class="easyui-dialog" title="编辑消息信息" resizable="true" modal="true" closed="true" 
		style="width:400px;height:300px;left:auto;top:auto;">
		<form id="resetForm" method="post">
				<table class="dialogTable" align="center" border="0" >
					<p class="p1">
					<input type="hidden" class="checkbox dialog" id="id" name="ID">
					<p>
					<p id="p1" class="p1">
					消息标题： <input type="text" class="textbox dialog" id="title" name="TITLE" ><span id="errorSpan"></span>
					</p>
					<p id="p2" class="p1">
					消息类别： <input type="text" class="textbox dialog" id="type" name="TYPE" >
					</p>
					<p id="p3" class="p1">
					发送人：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class="textbox dialog" id="sender" name="SENDER" >
					</p>
					<p id="p4" class="p1">
					接收人：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class="textbox dialog" id="recipient" name="RECIPIENT" >	
					</p>
					<p id="p5" class="p1">
					消息内容： <input type="text"  id="content" name="CONTENT" style="width: 134px;height:60px;" > 	
					</p>
					<p class="p2">
					<input type="button" class="button" value="保存" onclick="messageObject.submit()" >&nbsp;&nbsp;<input type="reset" class="button" value="重置">	
					</p>
				</table>
		</form>
	</div>
  </body>
</html>
