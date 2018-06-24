$(function(){
	 loadDataGrid();
	 $('#roleUserDialog').dialog('close');
});
var id = window.location.search.substr(1);
function loadDataGrid(){
	var screenWidth=document.body.clientWidth;
	$('#dataGrid').datagrid({
		fit : true,
		url:"web/roleController/queryRoleUserPage.do?"+id,
		title : '角色人员分配',
		iconCls : 'icon-search',
		width : 900,
		singleSelect : false,
		rownumbers:true,
		striped:true,
		pageNumber:1,
        pageSize: 10,
        pageList: [10,20, 30, 40, 50, 100],
		columns : [[
					{
						field : 'id',
						title : '编号',
						width : screenWidth*0.05,
						checkbox : true,
					},
					{
						field : 'userCode',
						title : '登录账号',
						width : screenWidth*0.19,
						align:'center',
					},
					{
						field : 'userName',
						title : '人员姓名',
						width : screenWidth*0.19,
						align:'center',
					},
					{
						field : 'jobNum',
						title : '工号',
						width : screenWidth*0.19,
						align : 'center',
					},
					{
						field : 'cellPhone',
						title : '手机号',
						width : screenWidth*0.19,
						align : 'center',
					},
					{
						field : 'orgName',
						title : '所属部门',
						width : screenWidth*0.19,
						align : 'center',
					},
				]],
				toolbar : '#tb',
				pagination : true,
			/*	onLoadSuccess : function(){
					roleUserData();
				}*/
	});
}

function roleUserData(){
	 dataGrid = $('#roleUserDataGrid').datagrid({
		fit : true,
		url:"web/roleController/queryRoleUserNOTIN.do?"+id,
		iconCls : 'icon-search',
		rownumbers:true,
		columns : [[
					{
						field : 'id',
						title : '编号',
						width : 70,
						checkbox : true,
					},
					{
						field : 'userCode',
						title : '登录账号',
						width : 180,
						align:'center',
					},
					{
						field : 'userName',
						title : '人员姓名',
						width : 350,
						align:'center',
					},

				]],
				toolbar : '#table',
	});
}
function searchFun() {
	dataGrid.datagrid('load', $.serializeObject($('#searchForm')));
}
function cleanFun() {
	$('#searchForm input').val('');
	dataGrid.datagrid('load', {});
}
var roleUser = {
	add : function(){
		$('#searchForm input').val('');
		$('#roleUserDialog').dialog('open');
		roleUserData();
	},
	remove : function(){
		var row = $('#dataGrid').datagrid('getChecked');
		if(!!!row.length){
			$.messager.alert('提示','请选择一条以上数据再删除','info');
			return ;
		}else{
			var ids=[];
			for(var i=0;i<row.length;i++){
				ids.push(row[i].userCode);
			}
			$.messager.confirm("系统提示","您确定要删除这条记录吗？",function(r){
				if(r){
					$.post('web/roleController/deleteRoleUsers.do?'+id,{ids:ids.join(',')},function(result){
						if(result.success){
							$.messager.alert('系统提示',result.message);
							$('#dataGrid').datagrid('load');
						}else{
							$.messager.alert('系统提示',result.message);
						}
					},'json');
				}
			});
		}
	},
};

function addRoleUser(){
	var row = $('#roleUserDataGrid').datagrid('getChecked');
	if(!!!row.length){
		$.messager.alert('提示','请有且只有选择一条数据再保存','info');
		return ;
	}else{
		var ids = [];
		for(var i=0;i<row.length;i++){
			ids.push(row[i].userCode);
		}
	}
	$.ajax({
		url : "web/roleController/insertRoleUser.do?"+id,
		type : "post",
		data : {ids:ids.join(',')},
		dataType : 'JSON',
		success : function(result){
			if(result.success){
				$.messager.alert('系统提示',result.message,'warning');
				$('#roleUserDialog').dialog('close');
				$('#dataGrid').datagrid('load');
			}else{
				$.messager.alert('系统提示',result.message,'warning');
				$('#roleUserDialog').dialog('close');
			}
		}
	});
};

