<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="../common/server.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/common.jsp"%>
<script type="text/javascript" src="<%=basePath%>pages/platform/jsp/file/file.js" ></script>
</head>
<body>
<table id="dataGrid" style="width:100%"></table>

	<div id="tb" style="padding:5px;">
		<div style="padding:0 0 0 7px;color:#333;">
		<form id="searchForm" class="query  margin-left30 margin-top20">
			<table>
				<tr><td>
			         <span class=" margin-left20" > 文件名称:</span><input autocomplete="off" class="textbox" type="text" name="fileName" />
			         &nbsp;<span class=" margin-left20" >状态：</span><input autocomplete="off" id="sfileStatus" name="sfileStatus" data-options="editable:false"/><span id="error">
			         &nbsp;时间：<input id="d1" type="text" class="easyui-datebox"  name="startTime"></input>&nbsp;至&nbsp;<input id="d2" type="text" class="easyui-datebox"  name="endTime"></input> 
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
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add();">添加</a>
		
		</div>
	</div>
	<div id="importDialog" class="easyui-dialog" title="文件上传" resizable="true" modal="true" close="true"
		style="width:450px;height:350px;left:auto;top:auto;">
		<form  id="importForm" method="post" enctype="multipart/form-data">
		<p style="margin-left:3px"><span>状态：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><input autocomplete="off" id="fileStatus"  name="fileStatus" data-options="editable:false"/><span id="error"></span></p><br>
		<p style="margin-left:3px"><span>文件描述：</span><input name="dec" class="easyui-textbox" data-options="multiline:true" style="width:300px;height:100px"></p><br>
		<p style="margin-left:3px"><span>文件上传：</span><input class="testbox" type="file" id="excelFile" name="file"><br><br><br></p>
		<p style="text-align:center"><a class="easyui-linkbutton" iconCls="icon-redo"  type="submit"  onclick="imports();">上传</a></p>
		</form>
</div>
</body>
</html>