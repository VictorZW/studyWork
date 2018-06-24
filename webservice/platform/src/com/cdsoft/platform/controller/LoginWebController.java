package com.cdsoft.platform.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cdsoft.platform.service.LogService;
import com.cdsoft.platform.service.LoginService;
import com.cdsoft.platform.util.DateUtils;

/**
 * 
 * @author cd_zhaomr
 * @date 2015-11-20 下午4:48:25
 * 
 */
@Scope("prototype")
@Controller
@RequestMapping("/web/login")
public class LoginWebController {
	private static final Logger logger = Logger.getLogger(LoginWebController.class);
	@Resource(name = "loginService")
	private LoginService loginServiceImpl;

	@Resource(name = "logService")
	private LogService logServiceImpl;

	/**
	 * 登陆PC页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "loginForPC")
	public String loginForPC(HttpServletRequest request, HttpServletResponse response, Model model) {
		String error = "";
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
			error = "该用户名不存在.";
		} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
			error = "用户名/密码错误";
		} else if (exceptionClassName != null) {
			error = "其他错误：" + exceptionClassName;
		}
		model.addAttribute("error", error);
		return "platform/jsp/login";

	}

	@RequestMapping("/logoutForPC")
	public void logout(HttpServletRequest req, Model model, HttpServletResponse response) {
		Subject subject = SecurityUtils.getSubject();
		logger.warn(subject+"退出系统"+DateUtils.getDate());
		try {
			subject.logout();
			req.getSession().invalidate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}