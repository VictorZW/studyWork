<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/server.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="../common/common.jsp"%>
<script charset="UTF-8" type="text/javascript"
	src="<%=basePath%>pages/platform/jsp/log/log.js"></script>
</head>

<body>
	<table id="dataGrid"></table>
	
	<div id="tb">
		<div style="padding: 0 0 0 7px; color: #333;">
			<form id="searchForm" class="query  margin-left30 margin-top20">
				<table>
					<tr>
						<td><span class=" margin-left20"> 操作人:</span><input
							autocomplete="off" class="textbox" type="text" name="userName" />
							&nbsp;<span class=" margin-left20"> 操作时间:</span><input id="dd"
							type="text" class="easyui-datebox" name="time"></input></td>
						<td>&nbsp;<a class="easyui-linkbutton" iconCls="icon-search"
							onclick="searchFun();">查询</a>&nbsp; <a class="easyui-linkbutton"
							iconCls="icon-reload" onclick="cleanFun();">重置</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
