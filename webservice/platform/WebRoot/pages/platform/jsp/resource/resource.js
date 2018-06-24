$(function(){
	loadDataGrid();
	check();
	var row = $('#dataGrid').datagrid('getChecked');
});
var id;
function loadDataGrid(){
	var screenWidth=document.body.clientWidth;
	$('#resourceDialog').dialog('close');
	 dataGrid = $('#dataGrid').datagrid({
		idField:'id',
		fit : true,
		url:"web/resource/selResource.do",
		iconCls : 'icon-search',
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
						field : 'name',
						title : '资源名称',
						width : screenWidth*0.15,
						align:'center',
					},
					{
						field : 'url',
						title : 'url',
						width : screenWidth*0.15,
						align:'center',
					},
					
					{
						field : 'menuCode',
						title : '关联菜单',
						width : screenWidth*0.10,
						align:'center',

					},
					{
						field : 'type',
						title : '类型',
						width : screenWidth*0.06,
						align:'center',
					},
					{
						field : 'permission',
						title : '权限字符串',
						width : screenWidth*0.22,
						align:'center',
					},
					{
						field : 'resCode',
						title : '资源编码',
						width : screenWidth*0.16,
						align:'center',
					},
					{
						field : 'resType',
						title : '资源类型',
						width : screenWidth*0.15,
						align:'center',
					},
				]],
				toolbar : '#tb',
				pagination : true,
	});
}

function searchFun() {
	dataGrid.datagrid('load', $.serializeObject($('#resourceForm')));
}

/**
 * 页面重置按钮
 */
function cleanFun() {
	$('#resourceForm input').val('');
	dataGrid.datagrid('load', {});
}
function check(){
	$('#name').blur(function(){
		var name = $('#name').val();
		if(name != null&& name !=""){
			$.ajax({
				url : "web/resource/checkName.do",
				type : "post",
				data : {'name' : name },
				dataType : 'JSON',
				success : function(data){
					if(data.success){
						$("#errorSpan").html("");
						 $(".button").removeAttr("disabled");
					}else{
						$("#errorSpan").html("资源已存在");
						$(".button").attr({"disabled":"disabled"});
					}
				},
			});
		}else{
			$("#errorSpan").html("资源不能为空");
		}
	});
}
var resourceObject = {
		
		add : function() {
			$('#resourceDialog').dialog('open').dialog('setTitle','添加');
			$('#resetForm').form('clear');
			$("#errorSpan").empty();
			$('#menuCode').combobox({    
			    url:'web/resource/queryMenu.do',    
			    valueField:'menuCode',    
			    textField:'name'   
			}); 
			$('#type').combobox({    
			    url:'web/resource/queryType.do',    
			    valueField:'type',    
			    textField:'type'   
			}); 
			this.url='web/resource/insert.do';
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
					$('#resourceDialog').dialog('close');
					$('#dataGrid').datagrid('load');
					}else{
						$messager.alert('系统提示',result.message,'warning');
						$('#resourceDialog').dialog('load');
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
			$('#menuCode').combobox({
			    url:'web/resource/queryMenu.do',    
			    valueField:'menuCode',    
			    textField:'name'
			    
			}); 
			$('#type').combobox({    
			    url:'web/resource/queryType.do',    
			    valueField:'type',    
			    textField:'type'
			    
			}); 
			$('#resourceDialog').dialog('open').dialog('setTitle', '修改');
			$('#resetForm').form('load',row[0]);
				
			this.url='web/resource/update.do';		
		},
		remove : function (){
			var row = $('#dataGrid').datagrid('getChecked');
			if(!!!row.length){
				$.messager.alert('提示','请选择一条以上数据再删除','info');
				return ;
			}else{
				var ids=[];
				for(var i=0;i<row.length;i++){
					ids.push(row[i].id);
				}
				$.messager.confirm("系统提示","您确定要删除这条记录吗？",function(r){
					if(r){
						$.ajax({
							url : 'web/resource/delete.do',
							type : 'post',
							data : {'ids' : ids.join(',')},
							typedata : 'json',
							success : function(data){
								var result = eval("("+data+")");
								if(result.success){
									$.messager.alert('系统提示',"删除成功","info");
									$('#dataGrid').datagrid('load');
									$('#dataGrid').datagrid('clearSelections');
								}else{
									$.messager.alert('系统提示',"删除失败","info");
									}
							}
						});
					}
				});
			}
		},
		
}