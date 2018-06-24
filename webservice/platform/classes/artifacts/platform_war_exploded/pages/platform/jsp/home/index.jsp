<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/server.jsp"%>
<!doctype html>
<html>
<head>
<%@ include file="../common/common.jsp"%>
<script type="text/javascript" charset="utf-8">
<%@ include file="../../js/index.js"%></script>
<script type="text/javascript">
	var firstArr = new Array();
	var currPanel = null;
	var tab = $('#mainTab');
	$(function() {
		$('#resetPasswordDialog').dialog('close');
		$.post('web/userController/getUserName.do', {}, function(data) {
			$('#userName').html(data.username);
		}, "JSON");
		initMenu();
		initTab();
		$('#resetPassword').click(function() {
			$('#resetPasswordDialog').dialog('open')
		});
		requirePassword();
		showMessageTab();
	});
	function showMessageTab() {
		$('#message')
				.click(
						function() {
							if (!$('#mainTab').tabs('exists', "消息管理")) {
								$('#mainTab')
										.tabs(
												'add',
												{
													title : "消息管理",
													content : '<iframe src="${pageContext.request.contextPath}/pages/platform/jsp/message/message.jsp'
															+ '" frameborder="0" style="border:0;width:100%;min-height:99%;"></iframe>',
													closable : true,
													id : 8888,
													tools : [ {
														iconCls : 'icon-mini-refresh',
														handler : function() {
															refreshTab("消息管理");
														}
													} ]
												});
							}
						});

	}
	function updatePassword() {
		$('#resetPasswordForm')
				.form(
						'submit',
						{
							url : "web/userController/updatePassword.do",
							onSubmit : function() {
								if (!$(this).form('validate')) {
									return false;
								}
								if ($('#newPassword').val() != $(
										'#confirmPassword').val()) {
									$.messager.alert('系统提示', '新密码和确认新密码不一致',
											'warning');
									return false;
								}
								$('#curentPassword').val(
										$.md5($('#curentPassword').val()).toUpperCase());
								$('#newPassword').val(
										$.md5($('#newPassword').val()).toUpperCase());
								$('#confirmPassword').val(
										$.md5($('#confirmPassword').val()).toUpperCase());
							},
							success : function(result) {
								var result = eval('(' + result + ')');
								if (result.success) {
									$('#resetPasswordDialog').dialog('close');
									$.messager.alert('系统提示', result.massage,
											'warning');
									setTimeout(
											function() {
												$
														.ajax({
															url : "web/login/logoutForPC.do",
															success : function(
																	data) {
																window.location = "<%=basePath%>";
															},
															error : function() {
																window.location = "<%=basePath%>";
															}
														});
											}, 1500);
								} else {
									$.messager.alert('系统提示', result.massage,
											'warning');
								}
							},
						});
	}
	function requirePassword() {
		$("#curentPassword").validatebox({
			required : "true",
			missingMessage : "当前密码不能为空"
		});
		$("#newPassword").validatebox({
			required : "true",
			missingMessage : "新密码不能为空"
		});
		$("#confirmPassword").validatebox({
			required : "true",
			missingMessage : "确认密码不能为空"
		});
	}
	//菜单初始化
	function initMenu() {
		$.post("web/resource/frontList.do", {}, function(data) {
			drawTopNav(data);
		}, "JSON");
	}
	function drawTopNav(data) {
		var html = [];
		$.each(data, function(i, menu) {
			html.push('<li><a class="firstNode" id="firstNode'
					+ menu.ID
					+ '" href="'
					+ (!menu.URL || menu.URL == 'null' ? 'javascript:void(0);'
							: menu.URL) + '"><img src="'+menu.IMG_URL+'"><h2>'
					+ menu.NAME + '</h2></a></li>');
			firstArr[menu.ID] = menu;
		});
		$("#nav").html(html.join(''));
		$(".firstNode").bind("click", firstNodeClicked);
		$(".firstNode").first().click();
	}
	//一级菜单点击事件
	function firstNodeClicked() {
		$('.firstNode').css('background', '');
		$(this).css('background', 'url(pages/platform/images/nav-bgnew2.png)');
		var id = $(this).attr("id");
		id = id.substring("firstNode".length);
		var sArr = firstArr[id].children;
		var html = [];
		var str = '';
		$.each(sArr,function(i, menu) {
					if (i == 0) {
								str = str+ '<li><a style="cursor:pointer" id="thirdNode'+menu.ID+'" class="ta_btn1" url="'+menu.URL+'">'+ menu.NAME + '</a></li>';
							} else {
								str = str+ '<li><a style="cursor:pointer" id="thirdNode'+menu.ID+'" class="ta_btn" url="'+menu.URL+'">'+ menu.NAME + '</a></li>';
							}
							firstArr[menu.ID] = menu;
						});
		html.push(str);
		$("#chibox").html(html.join(''));
		$(".ta_btn,.ta_btn1").bind("click", thirdNodeClicked);
		//点击首页按钮，触发事件
		if (id == 'D6D50A097D2D43E79DB4581F18C5B69E') {
			$('#thirdNode220').css('color', '#0062cc');
			var tab = $('#mainTab').tabs('getTab', '首页');
			if (tab) {
				$('#mainTab').tabs('select', '首页');
				return;
			}
			$('#mainTab')
					.tabs('add',{
								title : '首页',
								content : '<iframe src="${pageContext.request.contextPath}/pages/platform/jsp/home/main.jsp'

										+ '" frameborder="0" style="border:0;width:100%;min-height:99%;"></iframe>',
								closable : true,
								id : id,
								tools : [ {
									iconCls : 'icon-mini-refresh',
									handler : function() {
										refreshTab("首页");
									}
								} ]
							});
		}
	}
	//二级菜单点击事件
	function thirdNodeClicked() {
		$('.ta_btn').css('color', '#171717');
		$('.ta_btn1').css('color', '#171717');
		$(this).css('color', '#0062cc');

		if (currPanel) {
			currPanel.removeClass('cur');
		}
		$(this).addClass("cur");
		currPanel = $(this);

		var url = $(this).attr('url');
		var name = $(this).text();
		var id = this.id.substring("thirdNode".length);
		if (url && url != 'null') {
			addTab(id, name, url);
		}
	}
	function addTab(id, name, url) {
		//	name = name + "<span style=\"display:none\">" + id + "</span>";
		var tab = $('#mainTab').tabs('getTab', name);
		if (tab) {
			$('#mainTab').tabs('select', name);
			return;
		}
		$('#mainTab').tabs('add',{
							title : name,
							content : '<iframe src="${pageContext.request.contextPath}'
									+ url
									+ '" frameborder="0" style="border:0;width:100%;min-height:99%;"></iframe>',
							closable : true,
							id : id,
							tools : [ {
								iconCls : 'icon-mini-refresh',
								handler : function() {
									refreshTab(name);
								}
							} ]
						});

	}
	function refreshTab(title) {
		var tab = $('#mainTab').tabs('getTab', title);
		tab.panel('refresh');
	}

	function initTab() {
		tabsMenu = $('#tabsMenu').menu(
				{
					onClick : function(item) {
						var curTabTitle = $(this).data('tabTitle');
						var type = $(item.target).attr('id');
						if (type === 'refresh') {
							refreshTab(curTabTitle);
							return;
						}

						if (type === 'close') {
							var t = centerTabs.tabs('getTab', curTabTitle);
							if (t.panel('options').closable) {
								centerTabs.tabs('close', curTabTitle);
							}
							return;
						}

						var allTabs = centerTabs.tabs('tabs');
						var closeTabsTitle = [];

						$.each(allTabs, function() {
							var opt = $(this).panel('options');
							//alert(opt.title+"~~~~~"+curTabTitle+"~~~~"+(opt.title != curTabTitle));
							if (opt.closable && opt.title != curTabTitle
									&& type === 'closeOther') {
								closeTabsTitle.push(opt.title);
							} else if (opt.closable && type === 'closeAll') {
								closeTabsTitle.push(opt.title);
							}
						});

						for (var i = 0; i < closeTabsTitle.length; i++) {
							centerTabs.tabs('close', closeTabsTitle[i]);
						}
					}
				});

		centerTabs = $('#mainTab').tabs({
			fit : true,
			border : false,
			onContextMenu : function(e, title) {
				e.preventDefault();
				tabsMenu.menu('show', {
					left : e.pageX,
					top : e.pageY
				}).data('tabTitle', title);
			}
		});
	}
</script>

</head>

<body class="easyui-layout">
	<div class="wrap">
		<div class="header">
			<div class="logo">
				<img title="系统首页"
					src="pages/platform/images/logo.png" />
			</div>
			<div class="header-r ">
				<div class="user">
					<a title=""><img src="pages/platform/images/user.png" /><span
						id="userName"></span></a> ，&nbsp;欢迎您! &nbsp;|&nbsp;&nbsp;<a
						style="cursor: pointer" id="resetPassword"> 修改密码&nbsp;&nbsp; </a>
					<i>消息</i> <a style="cursor: pointer;" class="msg"
						style="color: #fff" title="未读消息"><input
						style="cursor: pointer;" class="msg" type="text" id="message"
						value="0"></a>
				</div>
				&nbsp;&nbsp;
				<div class="signout">
					<a id="loginOut" style="cursor: pointer" target="_parent"><img
						style="" src="pages/platform/images/signout.png" />&nbsp;退出</a>
				</div>
			</div>

			<ul id="nav" class="nav">
			</ul>

			<div class="nav_2">
				<ul id="chibox">
				</ul>
			</div>
		</div>
		<div class="middle">
			<div id="mainTab" class="easyui-tabs"></div>
			<div id="tabsMenu" style="width: 120px; display: none;">
				<div id="refresh">刷新</div>
				<div class="menu-sep"></div>
				<div id="close">关闭</div>
				<div id="closeOther">关闭其他</div>
				<div id="closeAll">关闭所有</div>
			</div>
		</div>

		<div id="resetPasswordDialog" class="easyui-dialog" title="修改密码"
			resizable="true" modal="true" close="true"
			style="width: 360px; height: 230px; left: auto; top: auto; line-height: 38px;"
			data-options="iconCls: 'icon-save',buttons: '#dlg-buttons'">
			<form id="resetPasswordForm" method="post">

				<table align="center" border="0" width="80%" id="deviceTable">
					<tr>
						<td width="80px">当前密码：</td>
						<td><input type="password" name="curentPassword"
							class="textbox" maxLength="30" id="curentPassword"
							placeholder="请输入当前密码" />&nbsp;<span>*</span></td>
					</tr>
					<tr>
						<td width="80px">新密码：</td>
						<td><input type="password" name="newPassword" class="textbox"
							id="newPassword" maxLength="30" placeholder="请输入新密码" />&nbsp;<span>*</span><br />
						</td>
					</tr>
					<tr>
						<td width="80px">确认新密码：</td>
						<td><input type="password" class="textbox"
							id="confirmPassword" maxLength="30" placeholder="确认新密码" />&nbsp;<span>*</span>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div id="dlg-buttons">
			<a class="easyui-linkbutton" iconCls="icon-ok"
				onclick="javascript:updatePassword()">保存</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-remove"
				onclick="javascript:$('#resetPasswordDialog').dialog('close')">取消</a>
		</div>
		<div class="footer">技术支持：山东创德软件技术有限公司</div>
	</div>
</body>
</html>
