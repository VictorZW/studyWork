$(function(){
	MenuTree();
});

var control;
var editingId;
var only = true;
function MenuTree() {
	var screenWidth=document.body.clientWidth;
	$('#MenuTree').treegrid({    
	    url:'web/menusController/selMenuTree.do',  
	    idField:'id',    
	    treeField:'text', 
		rownumbers: true,
		fitColumns: true,
		toolbar : '#tb',
		fit:true,
	    columns:[[  
					{
						 field : 'id',
						 title : '序号',
						 width : screenWidth*0.05,
						 align : 'center',
						 hidden : true
					 }, 
	              {
	            	 field : 'text',
	            	 title : '菜单名称',
	            	 width : screenWidth*0.2,
	            	 editor:{type:'text',
							options:{
								required:true
							}
		            		}
	              }, 
	              {
	             	 field : 'url',
	             	 title : 'URL',
	             	 width : screenWidth*0.4,
	            	 align:'center',
	            	 editor:{type:'text',
							options:{
								required:true
							}
		            		}
	               }, 
		              {
		             	 field : 'orderId',
		             	 title : '排序',
		             	 width : screenWidth*0.35,
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
				$('#MenuTree').treegrid('select', editingId);
				return;
			}else{
				var row = $('#MenuTree').treegrid('getSelected');
				if (row){
					editingId = row.id;
					$('#MenuTree').treegrid('beginEdit', editingId);
				}
			}		
		},
		onClickRow : function(row){
			if(editingId != undefined){
				$('#MenuTree').treegrid('endEdit', editingId);
				editingId = undefined;
			}
				$('#MenuTree').treegrid('endEdit', control);
				only = true;
		},
		onAfterEdit:function(row,changes){
       	 if(changes){
       			$.ajax({
           			url : 'web/menusController/updateMenuTreeChild.do',
           			type : 'post',
           			data : {'menuId' : row.id, 'menuName' : changes.text, 'menuUrl' : changes.url,'orderId':changes.orderId},
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
       			url : 'web/menusController/updateMenuTreeChild.do',
       			type : 'post',
       			data : {'menuId' : row.id, 'menuName' : changes.text, 'menuUrl' : changes.url,'orderId':changes.orderId},
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

function insertParent() {
	if(only == true){
		$.ajax({
			url : 'web/menusController/insertParent.do',
			type : 'post',
			datatype : 'JSON',
			success : function(data){
				var result = eval('('+data+')');
				var id = result.menuId;
				if(result.success){
					$('#MenuTree').treegrid('append', {
						parent: '0',  
						data: [{
							id: id,
							text: '新增菜单',
						}],
					}
					);
						$('#MenuTree').treegrid('select', id);
						$('#MenuTree').treegrid('beginEdit',id);
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

function insertChild() {
	if(only == true){
	var row = $('#MenuTree').treegrid('getChecked');
	if(row.length == ""){
		$.messager.alert("系统提示","请选择一根节点","info");
	}else{
		$.ajax({
			url : 'web/menusController/insertChild.do',
			type : 'post',
			data : {'menuId' : row[0].id},
			datatype : 'JSON',
			success : function(data){
				var result = eval('('+data+')');
				if(result.success){
					var pid = result.pid;
					var id = result.menuId;
					$('#MenuTree').treegrid('append', {
						parent: pid,  
						data: [{
							id: id,
							text: '新增菜单',
						}],
					}
					);
						$('#MenuTree').treegrid('select', id);
						$('#MenuTree').treegrid('beginEdit',id);
						control = id;
						only = false;
				}else{
					$.messager.alert("系统提示",result.message,"info");
				}
			}
		});
	}
	}else{
		$.messager.alert("系统提示","请保存当前新增后再操作","info");
	}
}

function deleteMenu(){
	var node = $('#MenuTree').treegrid('getSelected');
	$.ajax({
		url : 'web/menusController/deleteMenu.do',
		type : 'post',
		data : {pid : node.pid, menuId : node.id},
		datatype : 'JSON',
		success : function(data){
			var result = eval('('+data+')');
			if(result.success){
				$.messager.alert("系统提示","删除成功","info");
				$('#MenuTree').treegrid('load');
				$('#MenuTree').treegrid('select',node.pid);
			}else{
				$.messager.alert("系统提示","请先删除子菜单","info");
			}
		}
	});
	
}
