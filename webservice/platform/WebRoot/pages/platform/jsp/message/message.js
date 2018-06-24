$(function(){
	loadDataGrid();
	//check();
	var row = $('#dataGrid').datagrid('getChecked');
});
var ID;
function loadDataGrid(){
	var screenWidth=document.body.clientWidth;
	$('#messageDialog').dialog('close');
	 dataGrid = $('#dataGrid').datagrid({
		idField:'ID',
		fit : true,
		url:"web/messageController/querymessage.do",
		iconCls : 'icon-search',
		singleSelect : false,
		rownumbers:true,
		striped:true,
		pageNumber:1,
        pageSize: 10,
        pageList: [10,20, 30, 40, 50, 100],
		columns : [[
					{
		            	field : 'ID',
		            	checkbox : true,
		            },
					{
						field : 'MESSAGECODE',
						title : '消息编号',
						width : screenWidth*0.08,
						align:'center',
					},
					{
						field : 'TITLE',
						title : '消息标题',
						width : screenWidth*0.10,
						align:'center',
					},
					{
						field : 'TYPE',
						title : '消息类别',
						width : screenWidth*0.15,
						align : 'center',
					},
					{
						field : 'SENDER',
						title : '发送人',
						width : screenWidth*0.15,
						align : 'center',
					},
					{
						field : 'RECIPIENT',
						title : '接收人',
						width : screenWidth*0.15,
						align : 'center',
					},
					{
						field : 'CONTENT',
						title : '消息内容',
						width : screenWidth*0.15,
						align : 'center',
					},
					{
						field : 'TIMES',
						title : '发送时间',
						width : screenWidth*0.15,
						align : 'center',
					},
				]],
				toolbar : '#tb',
				pagination : true,
	});
}

function searchFun() {
	dataGrid.datagrid('load', $.serializeObject($('#searchForm')));
}

/**
 * 页面重置按钮
 */
function cleanFun() {
	$('#searchForm input').val('');
	dataGrid.datagrid('load', {});
}

var messageObject = {
		add : function() {
			$('#messageDialog').dialog('open').dialog('setTitle','添加');
			$('#resetForm').form('clear');
			$("#errorSpan").empty();
			this.url='web/messageController/insert.do';
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
					$('#messageDialog').dialog('close');
					$('#dataGrid').datagrid('load');
					}else{
						$messager.alert('系统提示',result.message,'warning');
						$('#messageDialog').dialog('load');
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
			$('#messageDialog').dialog('open').dialog('setTitle', '修改');
			$('#resetForm').form('load',row[0]);
			this.url='web/messageController/update.do';
			//$('#dataGrid').datagrid('clearSelections');
		},
		remove : function (){
			var row = $('#dataGrid').datagrid('getChecked');
			var ids=[];
			if(!!!row.length){
				$.messager.alert('提示','请选择一条以上数据再删除','info');
				return ;
			}else{
				for(var i=0;i<row.length;i++){
					ids.push(row[i].ID);
				}
				$.messager.confirm("系统提示","您确定要删除这条记录吗？",function(r){
					if(r){
						$.ajax({
							url : 'web/messageController/delete.do',
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