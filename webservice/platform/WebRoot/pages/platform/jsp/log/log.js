$(function() {
	loadDataGrid();
});
var dataGrid;
function loadDataGrid() {
	var screenWidth = document.body.clientWidth;
	dataGrid = $('#dataGrid').datagrid({
		fit : true,
		url : "web/logController/sellogs.do",
		iconCls : 'icon-search',
		singleSelect : false,
		rownumbers : true,
		striped : true,
		pageNumber : 1,
		pageSize : 13,
		pageList : [ 13, 20, 30, 40, 50, 100 ],
		columns : [ [ {
			field : 'ID',
			title : '序号',
			width : screenWidth * 0.05,
			align : 'center',
		}, {
			field : 'USERCODE',
			title : '登录账号',
			width : screenWidth * 0.1,
			align : 'center',
		}, {
			field : 'USERNAME',
			title : '人员姓名',
			width : screenWidth * 0.1,
			align : 'center',
		}, {
			field : 'LOGTIME',
			title : '操作时间',
			width : screenWidth * 0.2,
			align : 'center',
		}, {
			field : 'LOGTYPE',
			title : '日志类型',
			width : screenWidth * 0.15,
			align : 'center',
		}, {
			field : 'LOGINFO',
			title : '日志内容',
			width : screenWidth * 0.2,
			align : 'center',
		}, {
			field : 'LOGIP',
			title : 'IP地址',
			width : screenWidth * 0.18,
			align : 'center',
		} ] ],
		toolbar : '#tb',
		pagination : true,
	});
}

function searchFun() {
	dataGrid.datagrid('load', $.serializeObject($('#searchForm')));
}
function cleanFun() {
	$( "#dialog-confirm" ).dialog({
	     resizable: false,
	     height:280,
	     modal: true,
	//按钮
	     buttons: {
	       "是": function() {
	    	   alert("是");
	         $( this ).dialog( "close" );
	       },
	       "否": function() {
	    	   alert("否");
	         $( this ).dialog( "close" );
	       },
	  "取消": function() {
		  alert("取消");
	         $( this ).dialog( "close" );
	       }
	     }
	   });
	$('#searchForm input').val('');
	dataGrid.datagrid('load', {});
}