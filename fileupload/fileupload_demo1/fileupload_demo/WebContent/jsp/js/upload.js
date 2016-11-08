var basePath = null;
$(function() {
	basePath = $("#basePath").attr("value");
	$("#scbtn").click(function() {
		ajaxFileUpload();
	});

});

// 文件上传
function ajaxFileUpload() {
	$.ajaxFileUpload({
		url : basePath + "upload.ajax",// 用于文件上传的服务器端请求地址
		secureuri : false,// 一般设置为false
		fileElementId : 'attachfiles',// 文件上传控件的id属性
		dataType : 'json',// 返回值类型 一般设置为json
		enctype : "multipart/form-data",
		success : function(data, status) // 服务器成功响应处理函数
		{
		},
		error : function(data, status, e) {
		}
	});
	return false;
}
