$(function(){
	loadDataGrid(); 
	comboBox();
	document.onkeydown = function(e) {
		var ev = document.all ? window.event : e;
		if (ev.keyCode == 13) {
			$("#search").click();
			return false;
		}
	};

});

function loadDataGrid(){
	var screenWidth=document.body.clientWidth;
	$('#userDialog').dialog('close');
	$('#codeDialog').dialog('close');
	$('#importExcelDialog').dialog('close');
	dataGrid = $('#dataGrid').datagrid({
		fit: true,
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
							checkbox : true
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
function comboBox(){
	$("#orgName").combobox({
		url:"web/orgController/selOrgComboBox.do",
		valueField:"orgName",
		textField:"orgName"
	});
}

/**
 * 序列化查询参数
 */
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
var userObject = {	
		add : function() {
			$('#userDialog').dialog('open').dialog('setTitle','添加');
			$('#uCode').removeAttr("readonly");
			$('#userDialog').height(250);
			$('#addForm').form('clear');
			$('#p2').show();
			$("#uOrg").combobox({
				url:"web/orgController/selOrgComboBox.do",
				valueField:"orgName",
				textField:"orgName",
			});
			$('#uCode').blur(function(){
				var userCode = $('#uCode').val();
				if(userCode == ""){
					$('#errorSpan1').html("账号不能为空").css("color","red");
					$('#uCode').focus(function(){
						$('#errorSpan1').html("");
						});	
				}else{
					$.ajax({
						url : "web/userController/checks.do",
						type : "post",
						data : {'userCode' : userCode },
						dataType : 'JSON',
						success : function(data){
								if(data.success){
									$('#errorSpan').html("账号已被注册").css("color","red");
									$('#uCode').focus(function(){								
									$('#errorSpan').html("");
									});
								}else{
									$('#errorSpan').html("");
								}
						},
					});
				}
			});
			$('#uName').blur(function(){
				var uName = $('#uName').val();
				if(uName == ""){
					$('#errorSpan2').html("姓名不能为空").css("color","red");
					$('#uName').focus(function(){
						$('#errorSpan2').html("");
						});	
				}
			});
			$('#passWord').blur(function(){
				var passWord = $('#passWord').val();
				if(passWord ==""){
					$('#errorSpan3').html("密码不能为空").css("color","red");
					$('#passWord').focus(function(){
						$('#errorSpan3').html("");
						});	
				}
			});
			this.url='web/userController/insert.do';
		},
		
		submit : function(){
			var uCode = $('#uCode').val();
			var uName = $('#uName').val();
			var passWord = $('#passWord').val();
			var jobnum = $('#jobnum').val();
			var cellphone = $('#cellphone').val();
			if(uCode == ""){

				$('#errorSpan1').html("账号不能为空").css("color","red");
				$('#uCode').focus(function(){								
					$('#errorSpan1').html("");
				});
			}else if(uName == ""){

				$('#errorSpan2').html("姓名不能为空").css("color","red");
				$('#uName').focus(function(){								
					$('#errorSpan2').html("");
				});
			}else{
				
				$('#addForm').form('submit',{
					url:this.url,
					onSubmit:function(){
						return $(this).form('validate');
					},
				
					success : function(result){
						var result = eval('('+result+')');
						if(result.success){
							$.messager.alert('系统提示',result.message,'warning');
						$('#userDialog').dialog('close');
						$('#dataGrid').datagrid('load');
						}else{
							$messager.alert('系统提示',result.message,'warning');
							$('#userDialog').dialog('load');
						}
					}
				});
			}
		},
		
		edit : function (){
			$('#errorSpan1').html("");
			$('#userDialog').height(0);
			var row = $('#dataGrid').datagrid('getChecked');
			if(!row.length||row.length>1){
				$.messager.alert('提示','请选择一条数据修改!','info');
				return ;
			}
			
			$("#uOrg").combobox({
				url:"web/orgController/selOrgComboBox.do",
				valueField:"orgName",
				textField:"orgName",
				panelHeight: 200,
			});
			
			$('#userDialog').dialog('open').dialog('setTitle', '修改');
			$('#addForm').form('load',row[0]);
			$('#p2').hide();
			$('#userDialog').height(220);
			$("#uCode").attr("readonly","true");
			
			var uName = $('#uName').val();
			$('#uName').blur(function(){
				var uName = $('#uName').val();
				if(uName == ""){
					$('#errorSpan2').html("姓名不能为空").css("color","red");
					$('#uName').focus(function(){
						$('#errorSpan2').html("");
						});	
				}
			});
			this.url='web/userController/update.do';
		},
		
		reset : function(){
			var row = $('#dataGrid').datagrid('getChecked');
			if(!!!row.length||row.length>1){
				$.messager.alert('提示','请有且只选择一条数据再修改','info');
				return ;
			}
				$('#codeDialog').dialog('open').dialog('setTitle', '修改密码');
				$('#resetForm').form('load',row[0]);
		},
		remove : function (){
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
						$.post('web/userController/delete.do',{ids:ids.join(',')},function(result){
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
		import:function(){
			$('#importExcelForm').form('clear');
			$('#importExcelDialog').dialog('open');
		},
		export:function(){
			window.location.href="web/userController/export.do";
		},
		template:function(){
			window.location.href="web/userController/download.do";
		},
		importExcel:function(){
			var excelFile = $("#excelFile").val();
			if(excelFile=='') {alert("请选择需上传的文件!");return false;}
			if(excelFile.indexOf('.xls')==-1){alert("文件格式不正确，请选择正确的Excel文件(后缀名.xls)！");return false;}
			$('#importExcelDialog').dialog('close');
			$(".bg-z").show();
			$(".spinner").show();
			$('#importExcelForm').form('submit',{
				url:"web/userController/upload.do",
				success:function(result){
					var result = eval('('+result+')');
					if(result.status==0){
						$(".bg-z").hide();
						$(".spinner").hide();
						$.messager.alert('系统提示',result.message,'info');
						$('#dataGrid').datagrid('load');
					}else{
						$(".bg-z").hide();
						$(".spinner").hide();
						$.messager.alert('系统提示',result.message,'warning');
					}
				}
			},'json');
		}
};

function submit1(){
	var alterPassWord = $('#alterPassWord').val();
	var confirm1 = $('#confirm1').val();
	if(alterPassWord != confirm1){
		$.messager.alert("系统提示","两次密码不一致","inof").CSS("color","red");
	}else{
		$('#resetForm').form('submit',{
			url:'web/userController/reset.do',
			onSubmit:function(){
				return $(this).form('validate');
			},
			success : function(result){
				var result = eval('('+result+')');
				if(result.success){
					$.messager.alert('系统提示',result.message,'warning');
				$('#codeDialog').dialog('close');
				$('#dataGrid').datagrid('load');
				}else{
					$messager.alert('系统提示',result.message,'warning');
					$('#codeDialog').dialog('load');
				}
			}
		});
	}
	
}
function submit2() {
	$('#p1 input').val("");
	$('#p2 input').val("");
	$('#p3 input').val("");
	$('#p4 input').val("");
	$('#p5 input').val("");
	$('#errorSpan').html("");
}


