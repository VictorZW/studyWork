$(function(){
	$('#searchForm').form('clear');
	loadDataGrid();
	loadCombobox();
	$('#importDialog').dialog('close');
});

function loadCombobox()
{
	$("#fileStatus").combobox({
		url:"web/dictController/list.do?type=filestatus",
		valueField:"NO",
		textField:"VALUE",
		panelHeight:"auto"
	});
	$("#sfileStatus").combobox({
		url:"web/dictController/list.do?type=filestatus",
		valueField:"NO",
		textField:"VALUE",
		panelHeight:"auto"
	});
}
function loadDataGrid(){
	var screenWidth = document.body.clientWidth;
	dataGrid = $('#dataGrid').datagrid({
		fit: true,
		url:"web/fileUploadController/list.do",
		iconCls : 'icon-search',
		width : 900,
		singleSelect : true,
		rownumbers:true,
		striped:true,
		pageNumber:1,
        pageSize: 13,
        pageList: [13,20, 30, 40, 50, 100],
		columns : [[
					{
						field : 'ID',
						title : '编号',
						width : screenWidth*0.05,
						hidden : true
					},
					{
						field : 'FILENAME',
						title : '文件名称',
						width : screenWidth*0.2,
						align:'center',
					},
					{
						field : 'FILEDESC',
						title : '文件描述',
						width : screenWidth*0.4,
						align:'center',
					},					{
						field : 'CREATEUSER',
						title : '上传人',
						width : screenWidth*0.1,
						align : 'center',
					},
					{
						field : 'CREATETIME',
						title : '上传时间',
						width : screenWidth*0.1,
						align : 'center',
					},
					{
						field : 'STATUS',
						title : '状态',
						width : screenWidth*0.08,
						align : 'center',
					},
					{
						field : 'OPERATION',
						title : '操作',
						width : screenWidth*0.1,
						align:'center',
						formatter:function(val,row,index){ 
							return '<a href="web/fileUploadController/download.do?fileid='+row.ID+'" style="cursor:pointer;color:blue"; class="hoverCode" onmousedown="hoverSelectRow('+index+');" >'+"[下载]"+'</a>';
							
						},
					}
				]],
				toolbar : '#tb',
				pagination : true,
	});
}

function searchFun() {
	dataGrid.datagrid('load', $.serializeObject($('#searchForm')));
}

function cleanFun() {
	$('#searchForm input').val('');
	dataGrid.datagrid('load',{});
}

function add(){
	$('#importForm').form('clear');
	$('#importDialog').dialog('open');
}

function imports(){
	var status = $('#fileStatus').combobox('getValue');
	if(status==''){
		$('#error').html("状态不能为空").css("color","red");
		$("#xlk").combobox({
			 onSelect: function(rec){   
				 $('#error').html("");
		        }
		});
		$('#importForm').form('clear');
	}else{
		var excelFile = $("#excelFile").val();
	    if(excelFile=='') {$.messager.alert('系统提示','请选择需上传的文件!','info');return false;}
	    /*if(excelFile.indexOf('.xls')==-1){alert("文件格式不正确，请选择正确的Excel文件(后缀名.xls)！");return false;}*/
	    //$("#importForm").submit();
	    $('#importForm').form('submit',{
			url: "web/fileUploadController/upload.do",	
			success : function(result){
				var result = eval('('+result+')');
				if(result.success){
					$.messager.alert('系统提示',"上传成功",'warning');
				$('#importDialog').dialog('close');
				$('#dataGrid').datagrid('load');
				}else{
					$messager.alert('系统提示',"上传失败",'warning');
					$('#importDialog').dialog('load');
				}
			}
		});
	}
	
}

function hoverSelectRow(index){
	$('#dataGrid').datagrid('selectRow',index);
}