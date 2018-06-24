$(function(){
	loadDataGrid();
	check();
	var row = $('#dataGrid').datagrid('getChecked');
});

var roleCode;
function loadDataGrid(){
	var screenWidth=document.body.clientWidth;
	$('#roleDialog').dialog('close');
	$('#rolePowerDialog').dialog('close');
	 dataGrid = $('#dataGrid').datagrid({
		fit : true,
		url:"web/roleController/queryRoleNeed.do",
		iconCls : 'icon-search',
		singleSelect : false,
		rownumbers:true,
		striped:true,
		pageNumber:1,
        pageSize: 10,
        pageList: [10,20, 30, 40, 50, 100],
		columns : [[
					{
						field : 'roleCode',
						title : '编号',
						width : screenWidth*0.05,
						checkbox : true,
					},
					{
						field : 'roleName',
						title : '角色名称',
						width : screenWidth*0.32,
						align:'center',
					},
					{
						field : 'describe',
						title : '角色描述',
						width : screenWidth*0.32,
						align:'center',
					},
					{
						field : 'OPERATION',
						title : '操作',
						width : screenWidth*0.32,
						align:'center',
						formatter:function(val,row,index){ 
							return '<a class="hoverCode" href="'+path+'/pages/platform/jsp/role/roleUser.jsp?id='+row.roleCode+'">[人员分配]</a>'+"&nbsp;"+
							'<a style="cursor:pointer;color:blue"; class="hoverCode" onclick="rolePower();" onmousedown="hoverSelectRow('+index+');" >'+"[权限分配]"+'</a>';
						},
					},
				]],
				toolbar : '#tb',
				pagination : true,
	});
}

function searchFun() {
	dataGrid.datagrid('load', $.serializeObject($('#roleForm')));
}

/**
 * 页面重置按钮
 */
function cleanFun() {
	$('#roleForm input').val('');
	dataGrid.datagrid('load', {});
}
function check(){
	$('#roleName').blur(function(){
		var roleName = $('#roleName').val();
		if(roleName != null&& roleName !=""){
			$.ajax({
				url : "web/roleController/checkName.do",
				type : "post",
				data : {'roleName' : roleName },
				dataType : 'JSON',
				success : function(data){
					if(data.success){
						$("#errorSpan").html("");
						 $(".button").removeAttr("disabled");
					}else{
						$("#errorSpan").html("角色已存在");
						$(".button").attr({"disabled":"disabled"});
					}
				},
			});
		}else{
			$("#errorSpan").html("角色不能为空");
		}
	});
}
var roleObject = {
		
		add : function() {
			$('#roleDialog').dialog('open').dialog('setTitle','添加');
			$('#resetForm').form('clear');
			$("#errorSpan").empty();
			this.url='web/roleController/insert.do';
			check();
		},
		
		
		submit : function(){
			$('#resetForm').form('submit',{
				url:this.url,
				onSubmit:function(){
					return $(this).form('validate');
				},
				success : function(result){
					var result = eval('('+result+')');
					if(result.success){
						$.messager.alert('系统提示',result.message,'warning');
					$('#roleDialog').dialog('close');
					$('#dataGrid').datagrid('load');
					}else{
						$messager.alert('系统提示',result.message,'warning');
						$('#roleDialog').dialog('load');
					}
				}
			});
		},
		
		edit : function (){
			$("#errorSpan").empty();
			var row = $('#dataGrid').datagrid('getChecked');
			if(!!!row.length||row.length>1){
				$.messager.alert('提示','请有且只选择一条数据再修改','info');
				return ;
			}
			$('#roleDialog').dialog('open').dialog('setTitle', '修改');
			$('#resetForm').form('load',row[0]);
			
			this.url='web/roleController/update.do';
		},
		
		remove : function (){
			var row = $('#dataGrid').datagrid('getChecked');
			if(!!!row.length){
				$.messager.alert('提示','请选择一条以上数据再删除','info');
				return ;
			}else{
				var ids=[];
				for(var i=0;i<row.length;i++){
					ids.push(row[i].roleCode);
				}
				$.messager.confirm("系统提示","您确定要删除这条记录吗？",function(r){
					if(r){
						$.ajax({
							url : 'web/roleController/judge.do',
							type : 'post',
							data : {'roleids' : ids.join(',')},
							typedata : 'json',
							success : function(data){
								var result = eval("("+data+")");
								if(result.success){
									$.messager.alert('系统提示',"当前角色下有用户不能删除","info");
								}else{
									$.post('web/roleController/judgeRM.do',{roleids:ids.join(',')},function(result){
										if(result.success){
											$.messager.alert('系统提示',"当前角色已被分配权限不能删除","info");
										}else{
											$.post('web/roleController/delete.do',{ids:ids.join(',')},function(result){
												if(result.success){
													$.messager.alert('系统提示',result.message);
													$('#dataGrid').datagrid('load');
												}else{
													$.messager.alert('系统提示',result.message);
												}
											},'json');
										}
									},'json');								
								}
							}
						});
					}
				});
			}
		},
};



function hoverSelectRow(index){
	$('#dataGrid').datagrid('selectRow',index);
}
function rolePower(){	
	var row = $('#dataGrid').datagrid('getChecked');
	roleCode=(row[0].roleCode);
	$('#rolePowerDialog').dialog('open');
	$('#rolePowerTree').tree({
		url:"web/roleController/selectMenuTree.do",
		lines: true,
		checkbox: true,
	        onLoadSuccess : function(node,data){
				$.ajax({
					url : 'web/roleController/selectRoleMenu.do',
					type : 'post',
					data : {'roleCode': roleCode},
					dataType : 'JSON',
					success : function(data){
						for(var i=0;i<data.ids.length;i++){
							var n = $('#rolePowerTree').tree('find', data.ids[i].ID);
							if( $('#rolePowerTree').tree('isLeaf', n.target)){
								$('#rolePowerTree').tree('check', n.target);
							}
						}
					}
				});
				
			}    
	});
	
	$('#dataGrid').datagrid('load');
}
var RoleMenu = {
		del : function(){
			var suc;
			var nodes = $('#rolePowerTree').tree('getChecked');
			var nodes1 = $('#rolePowerTree').tree('getChecked', 'indeterminate');
			
			var menuid=[];
			var menuid1=[];
			for(var i=0;i<nodes.length;i++){
				menuid.push(nodes[i].id);
			}
			for(var i=0;i<nodes1.length;i++){
				menuid1.push(nodes1[i].id);
			}
			if(menuid1!=""){
				menuid.unshift(menuid1);
			}
			 var menuids = menuid.join(',');
			if(!menuids){
				$.ajax({
					url : 'web/roleController/deleteRoleMenu.do',
					type : 'post',
					data : {roleCode : roleCode},
					dataType : 'JSON',
					success : function(result){
						if(result.success){
							$.ajax({
								url : 'web/roleController/deleteroleResource.do',
								type : 'post',
								data : {roleCode : roleCode},
								dataType : 'JSON',
								success : function(result){
									if(result.success){
										$.messager.alert('系统提示',"当前角色权限已被收回","info");	
										$('#rolePowerDialog').dialog('close');
									}
								}
							})
						}
					}
					})
				return
			}else{
				$.ajax({
					url : 'web/roleController/deleteRoleMenu.do',
					type : 'post',
					data : {roleCode : roleCode},
					dataType : 'JSON',
					success : function(data){
						if(data.success){
							$.ajax({
								url : 'web/roleController/addRoleMenu.do',
								type : 'post',
								data : {'roleCode' : roleCode,'menuids' : menuids},
								dataType : 'JSON',
								success : function(datas){
									if(datas.success){	
										$.messager.alert('系统提示',datas.message,'info');
										$('#rolePowerDialog').dialog('close');
									}else{
									}
								}
							});
						}else{
							
						}
					}
				});
			}
		},
		add : function(){
		}
};
