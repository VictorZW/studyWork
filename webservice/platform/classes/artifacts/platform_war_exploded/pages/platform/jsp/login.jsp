<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="common/server.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="<%=basePath%>pages/platform/css/login.css" rel="stylesheet">
<script type="text/javascript"
	src="<%=basePath%>pages/platform/js/jquery-1.12.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>pages/platform/js/jquery.md5.js"></script>
<script type="text/javascript" src="<%=basePath%>pages/platform/js/login.js"></script>
<meta charset="utf-8">
<script type="text/javascript">
</script>
</head>
<body>
	<div class="logo"></div>
	<div class="enter">
		<form action="<%=basePath%>web/login/loginForPC.do" method="post"
			id="loginForm" onsubmit="return sub_mit()">
			<div class="main_bg">
				<div class="main">
					<div class="name">
						<span>用户名：</span> <input id="userCode" name="userCode" type="text">
					</div>
					<div class="password">
						<span>密&nbsp;&nbsp;&nbsp;码：</span> <input id="password" name="password" type="password">
					</div>
					<div class="error" ><span>${error}</span></div>
					<div class="btnbox">
						<input id="loginBtn" style="cursor:pointer" name="登录" type="submit" value="登录" /><input
							class="margin-left40" style="cursor:pointer" name="重置" type="reset" value="重置" />
					</div>
				</div>
			</div>
			</form>
	</div>
	<div class="footer">
		<p>技术支持：山东创德软件技术有限公司</p>
	</div>
</body>
</html>