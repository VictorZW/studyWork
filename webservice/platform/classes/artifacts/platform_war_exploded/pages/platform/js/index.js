$(function(){
	$(".da_nav").hide();
	$(".da_btn img").click(function(){
			$(".da_nav").stop().toggle(1000);
	});
	$(".da_tell img").click(function(){
		$(".da_tell").hide(1000);
		});
	$("#loginOut").click(function(){
		$.messager.confirm("退出","您确定要退出吗？",function(r){
			if(r){
				$.ajax({
					url:"web/login/logoutForPC.do",
					success:function(data){
						window.location="<%=basePath%>";
					},
					error:function(){
						window.location="<%=basePath%>";
					}
				});
			}
		});
		
	});
});



