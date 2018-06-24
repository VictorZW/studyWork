$(function(){
	dictTree();
	loadDataGrid();
	$('#dictDialog').dialog('close');
	$("#dictTypeDialog").dialog('close');
});
var control;
var editingId;
var only = true;
var parentNo;
var row;
var changes;
function loadDataGrid(){
	dataGrid = $('#dataGrid').datagrid({
		fit : true,
		url:"web/dictController/querydict.do",
		queryParams:{parentNo:'x'},
		iconCls : 'icon-search', 
		singleSelect : true,
		rownumbers:true,
		striped:true,
		columns : [[
					{
						field : 'DICTID',
						title : '字典编号',
						checkbox : false,
						hidden : true
					},
					{
						field : 'DICTNAME',
						title : '字典名称',
						width : 180,
						align:'center',
						editor:'text'
					},
					{
						field : 'DICTCODE',
						title : '字典编码',
						width : 180,
						align:'center',
						editor:'text'
					},
					{
						field : 'DICTTYPE',
						title : '字典类别',
						width : 180,
						align:'center'
					},
					{
						field : 'PNO',
						title : '父类编码',
						hidden : true
					},
					{
						field : 'OPERATION',
						title : '操作',
						width : 170,
						align:'center',
						formatter:function(val,row,index){ 
							return '<a style="cursor:pointer;color:blue"; class="hoverCode" onclick="deleteRow();" onmousedown="hoverSelectRow('+index+');" >'+"[删除]"+'</a>';
						},
					},
					
				]],
				toolbar : '#tb',
				onDblClickCell : onDblClickCell,
				onClickRow : onClickRow,
				onAfterEdit : onAfterEdit,
	});
}
function combobox(){
	$("#dictTypes,#dictType").combobox({
		url:"web/dictController/queryDictType.do",
		valueField:"DICTCODE",
		textField:"DICTNAME",
	});
}

function dictTree() {
	$('#dictTree').treegrid({    
	    url:'web/dictController/selDictTree.do',  
	    idField:'id',    
	    treeField:'text', 
		rownumbers: true,
		fitColumns: true,
		toolbar : '#tb_t',
		fit:true,
	    columns:[[  
					{
						 field : 'id',
						 title : '字典编码',
						 width : 50
					 }, 
	              {
	            	 field : 'text',
	            	 title : '字典名称',
	            	 width : 50,
	            	 editor:{type:'text',
							options:{
								required:true
							}
		            		}
	              }, 
	              {
	             	 field : 'type',
	             	 title : '类型',
	             	 width : 50,
	            	 align:'center',
	            	 editor:{type:'text',
							options:{
								required:true
							}
		            		}
	               }
	    ]],
	    onDblClickRow : function(row){
	    	if (editingId != undefined){
				$('#dictTree').treegrid('select', editingId);
				return;
			}else{
				var row = $('#dictTree').treegrid('getSelected');
				if (row){
					editingId = row.id;
					$('#dictTree').treegrid('beginEdit', editingId);
				}
			}		
		},
		onClickRow : function(row){
			if(editingId != undefined){
				$('#dictTree').treegrid('endEdit', editingId);
				editingId = undefined;
			}
			$('#dictTree').treegrid('endEdit', control);
			only = true;
			parentNo=row.id;
			dataGrid.datagrid('load',{parentNo : row.id});
		},
		onLoadSuccess : function(row,data){
			if(data){
				parentNo=data[0].id;
				dataGrid.datagrid('load',{parentNo : data[0].id});
			}
			
		},
		onAfterEdit:function(row,changes){
       	 if(changes){
       			$.ajax({
           			url : 'web/dictController/updateDictByNo.do',
           			type : 'post',
           			data : {'no' : row.id, 'value' : changes.text, 'type' : changes.type},
           			datatype : 'JSON',
           			success : function(data){
           				var result = eval('('+data+')');
           				if(result.success){
           					$.messager.alert("系统提示",result.message,"info");
           					control = true;
           				}else{
           					$.messager.alert("系统提示",result.message,"info");
           				}
           			}
           		});
       	 }else if(changes.text){
       		$.ajax({
       			url : 'web/dictController/updateDictByNo.do',
       			type : 'post',
       			data : {'no' : row.id, 'value' : changes.text, 'type' : changes.type},
       			datatype : 'JSON',
       			success : function(data){
       				var result = eval('('+data+')');
       				if(result.success){
       					$.messager.alert("系统提示",result.message,"info");
       					control = true;
       				}else{
       					$.messager.alert("系统提示",result.message,"info");
       				}
       			}
       		});
       	 }
        }
	});	
};

function searchFun() {
	dataGrid.datagrid('load', $.serializeObject($('#searchForm')));
}

function hoverSelectRow(index){
	$('#dataGrid').datagrid('selectRow',index);
}
function cleanFun() {
	$('#searchForm input').val('');
	dataGrid.datagrid('load', {});
}
function deleteDict(){
	
}

var editIndex = undefined;
function endEditing(){
	if (editIndex == undefined){return true}
	if ($('#dataGrid').datagrid('validateRow', editIndex)){
		$('#dataGrid').datagrid('endEdit', editIndex);
		editIndex = undefined;
		return true;
	} else {
		return false;
	}
}
var editingId = undefined;
function onDblClickCell(index, field, value){
	if (editingId != undefined){
		$('#dataGrid').datagrid('select', editingId);
		return;
	}else{
		$('#dataGrid').datagrid('beginEdit', index);
		editingId = index;
	}
}

function onClickRow(rowIndex, rowData){
	if(editingId != undefined){
		$('#dataGrid').datagrid('endEdit', editingId);
		editingId = undefined;
	}
}

function onAfterEdit(rowIndex, rowData, changes){
	if(changes.DICTNAME){
		$.ajax({
   			url : 'web/dictController/updateDict.do',
   			type : 'post',
   			data : {'dictId' : rowData.DICTID, 'dictName' : changes.DICTNAME,'no':changes.DICTCODE},
   			datatype : 'JSON',
   			success : function(data){
   				var result = eval('('+data+')');
   				if(result.success){
   					$.messager.alert("系统提示",result.message,"info");
   				}else{
   					$.messager.alert("系统提示",result.message,"info");
   				}
   			}
   		});
	}
}
function insertDictType(){
	if(only == true){
		$.ajax({
			url : 'web/dictController/insertDictType.do',
			type : 'post',
			datatype : 'JSON',
			success : function(data){
				var result = eval('('+data+')');
				var id = result.no;
				if(result.success){
					$('#dictTree').treegrid('append', {
						parent: '0',  
						data: [{
							id: id,
							text: '新增类型',
						}],
					}
					);
						$('#dictTree').treegrid('select', id);
						$('#dictTree').treegrid('beginEdit',id);
						control = id;
						only = false;
				}else{
						$.messager.alert("系统提示",result.message,"info");
				}
			}
		});
	}else{
		$.messager.alert("系统提示","请保存当前新增后再操作","info");
	}
}

function addDict(){
	$('#addDict').form('clear');
	$('#dictDialog').dialog('open');
}

function dictSubmit(){
	var dictName = $('#dictName').val();
	var no =  $("#no").val();
	$("#parentNo").val(parentNo);
	if(dictName ==""){
		$('#errorSpan2').html("名称不能为空").css("color","red");
		$('#dictName').focus(function(){
			$('#errorSpan2').html("");
			});
	}else if(no==""){
		$('#errorSpan3').html("编码不能为空").css("color","red");
		$("#no").focus(function(){
			$('#errorSpan2').html("");
		});
	}else{
		$.ajax({
			url : "web/dictController/check2.do",
			type : "post",
			data : {'no' : no , 'dictName':dictName,'parentNo':parentNo},
			dataType : 'JSON',
			success : function(data){				
				if(data.success){
				$('#errorSpan2').html("该字典已存在").css("color","red");
				$('#addDictType').focus(function(){
					$('#errorSpan2').html("");
					});
				}else{
					$('#addDict').form('submit', {
						url: 'web/dictController/addDict.do',
						onSubmit: function(){
							return $(this).form('validate');
						},
						success: function(data){
							var result = eval('('+data+')');
							if(result.success){
								$.messager.alert('系统提示','成功','info');
								$("#dictDialog").dialog('close');
								$("#dataGrid").datagrid('load');
							}else{
								$.messager.alert('系统提示','失败','info');
							}
						}
					});
					}
				}
		});
	}
}

function dictTypeSubmit(){
	var dictType = $('#addDictType').val();
	if(dictType ==""){
		$('#errorSpan1').html("账号不能为空").css("color","red");
		$('#addDictType').focus(function(){
			$('#errorSpan1').html("");
			});
	}else{
		$.ajax({
			url : "web/dictController/check1.do",
			type : "post",
			data : {'dictType' : dictType },
			dataType : 'JSON',
			success : function(data){				
				if(data.success){
				$('#errorSpan1').html("该类型已存在").css("color","red");
				$('#addDictType').focus(function(){
					$('#errorSpan1').html("");
					});
				}else{
					$('#addType').form('submit', {
						url: 'web/dictController/addDictType.do',
						onSubmit: function(){
							return $(this).form('validate');
						},
						success: function(data){
							var result = eval('('+data+')');
							if(result.success){
								$.messager.alert('系统提示','成功','info');
								$("#dictTypeDialog").dialog('close');
								$("#dataGrid").datagrid('load');
								$("#dictTypes,#dictType").combobox('reload');
							}else{
								$.messager.alert('系统提示','失败','info');
							}
						}
					});
				}
			},
		});
	}
};

function deleteRow(){
	var node = $('#dataGrid').datagrid('getSelected');
	$.messager.confirm("系统提示","您确定要删除这条记录吗？",function(r){
		if(r){
			$.post('web/dictController/deleteRow.do',{'dictid' : node.DICTID},function(result){
				if(result.success){
					$.messager.alert('系统提示','成功');
					$('#dataGrid').datagrid('load');
				}else{
					$.messager.alert('系统提示','失败');
				}
			},'json');
		}
	});
}

function deleteDictType(){
	var node = $('#dictTree').treegrid('getSelected');
	$.ajax({
		url : 'web/dictController/deleteDictType.do',
		type : 'post',
		data : { no : node.id},
		datatype : 'JSON',
		success : function(data){
			var result = eval('('+data+')');
			if(result.success){
				$.messager.alert("系统提示","删除成功","info");
				$('#dictTree').treegrid('load');
				$('#dictTree').treegrid('select',node.pid);
			}else{
				$.messager.alert("系统提示","请先删除子菜单","info");
			}
		}
	});
	
}