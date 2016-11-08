<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	%>
<!-- 文件上传页面代码：by http://www.wenboxz.com -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传Demo·http://www.wenboxz.com</title>
<script src="js/jquery-1.7.min.js" type="text/javascript"></script>
<script src="js/ajaxfileupload.js" type="text/javascript"></script>
<script src="js/upload.js" type="text/javascript"></script>
</head>
<body>
	<input id="basePath" type="hidden" value="<%=basePath%>" />
	<input type="file" name="attachfiles" id="attachfiles" />
	<input type="button" value="点击上传" id="scbtn" />
</body>
</html>