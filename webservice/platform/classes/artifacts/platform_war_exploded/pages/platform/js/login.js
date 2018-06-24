$(function(){
	//回车键实现登录
	document.onkeydown = function(e) {
		var ev = document.all ? window.event : e;
		if (ev.keyCode == 13) {
			$("#loginBtn").click();
			return false;
		}
	};
});

function sub_mit(){
	var userCode = $('#userCode').val();
	var password = $('#password').val();
	if(!!!userCode){
		alert("用户名不能为空");
		return false;
	}
	if(!!!password){
		alert("密码不能为空");
		return false;
	}
	$("#loginForm").submit();

}

