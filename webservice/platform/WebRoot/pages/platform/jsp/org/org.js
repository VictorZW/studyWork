$(function(){
	$('#orgUserDialog').dialog('close');
	orgTree();
	loadDataGrid();
});
var lastIndex ;
var editingId;
function loadDataGrid(){
	var screenWidth=document.body.clientWidth*0.8;
	dataGrid = $('#dataGrid').datagrid({
		fit : true,
		url:"web/userController/queryUserInfo.do",
		iconCls : 'icon-search',
		width : 900,
		singleSelect : false,
		rownumbers:true,
		striped:true,
		pageNumber:1,
	    pageSize: 13,
	    pageList: [13,20, 30, 40, 50, 100],
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
						field : 'orgName',
						title : '所属部门',
						width : screenWidth*0.19,
						align : 'center',
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
					}
				]],
				toolbar : '#tb',
				pagination : true,
	});
}
function orgTree(){
	$('#orgTree').tree({    
	    url: 'web/orgController/selOrgTree.do',    
	    lines: true,
	    onContextMenu: function(e, node){
			e.preventDefault();
			// 查找节点
			$('#orgTree').tree('select', node.target);
			// 显示快捷菜单
			$('#mm').menu('show', {
				left: e.pageX,
				top: e.pageY
			});
		},
		onAfterEdit : function(node){
			var newData = $('#orgTree').tree('getSelected');
			$.ajax({
				url : 'web/orgController/updateOrgName.do',
				type : 'post',
				data : {'orgName' : newData.text,'orgCode' : newData.id},
				datatype : 'JSON'
			});
		},
		onDblClick : function(node){
			var node = $('#orgTree').tree('getSelected');
			$('#orgTree').tree('beginEdit',node.target);
		},	
		onClick : function(){
			var node = $('#orgTree').tree('getSelected');
			if(node.id == 10000001){
				dataGrid.datagrid('load',{
				});
			}else{
				dataGrid.datagrid('load',{
					orgCode : node.id
				});
			}
		}
	});  
};


function append() {
	var orgCode = $('#orgTree').tree('getSelected');
	$.ajax({
		url : 'web/orgController/insertOrgTreeChild.do',
		type : 'post',
		data : {'orgCode' : orgCode.id },
		dataType : 'JSON',
		success : function(data){
			if(data.success){
				var orgNewCode = data.orgNewCode;
				$('#orgTree').tree('append',{
					parent: orgCode.target,  
					data: [{
						id: orgNewCode,
						text: '新增节点'
					}],
				}); 
				var node = $('#orgTree').tree('find', orgNewCode);
				$('#orgTree').tree('select', node.target);
				$('#orgTree').tree('beginEdit',node.target);	
			}
		}
	});
}

function del(){
	var orgCode = $('#orgTree').tree('getSelected');
	$.ajax({
		url : 'web/orgController/delOrgTree.do',
		type : 'post',
		data : {'orgCode' : orgCode.id },
		dataType : 'JSON',
		success : function(data){
			//var result = eval('('+data+')');
			if(data.success){
				$.messager.alert("系统提示","删除成功","info");
				$('#orgTree').tree('reload');
			}else{
				$.messager.alert("系统提示","请先删除子部门","info");
			}
		}
	});
}

var orgObject = {
	add : function(){
		var orgCode = $('#orgTree').tree('getSelected');
		editingId = orgCode.id;
		if(orgCode == undefined){
			$.messager.alert("系统提示","请选择一个部门","info");
			return;
		}else{
			$('#orgUserDialog').dialog('open');
			$('#orgUserDataGrid').datagrid({
				fit : true,
				url:"web/orgController/selOrgUser.do?orgCode="+orgCode.id,
				iconCls : 'icon-search',
				width : 900,
				singleSelect : false,
				rownumbers:true,
				striped:true,
				pageNumber:1,
			    pageSize: 12,
			    pageList: [12,20, 30, 40, 50, 100],
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
								width : 100,
								align:'center',
							},
							{
								field : 'userName',
								title : '人员姓名',
								width : 100,
								align:'center',
							},
							{
								field : 'orgName',
								title : '所属部门',
								width : 100,
								align : 'center',
							},
							{
								field : 'jobNum',
								title : '工号',
								width : 100,
								align : 'center',
							},
							{
								field : 'cellPhone',
								title : '手机号',
								width : 100,
								align : 'center',
							}
						]],
						toolbar : '#table',
						pagination : true,
			});
		}
		
	}
};

function addOrgUser(){
	var row = $('#orgUserDataGrid').datagrid('getChecked');
	if(row == null){
		$('#orgUserDialog').dialog('close');
		return;
	}else{
		var userCode = [] ;
		for(var i=0;i<row.length;i++){
			userCode.push(row[i].userCode);
		}
		$.ajax({
			url : 'web/orgController/updateOrgUser.do',
			type : 'post',
			data : {userCode : userCode.join(","),orgCode : editingId},
			dataType : 'JSON',
			success : function(data){
				if(data.success){
					$.messager.alert("系统提示","添加成功","info");
					var node = $('#orgTree').tree('getSelected');
					dataGrid.datagrid('load',{
						orgCode : node.id
					});
					$('#orgUserDialog').dialog('close');
				}else{
					$.messager.alert("系统提示","添加失败","info");
				}
			}
		});
	}
	
}