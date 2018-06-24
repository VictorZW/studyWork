package com.cdsoft.platform.shiro;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import com.cdsoft.platform.entity.Log;
import com.cdsoft.platform.entity.Role;
import com.cdsoft.platform.entity.User;
import com.cdsoft.platform.service.LogService;
import com.cdsoft.platform.service.UserService;

public class UserRealm extends AuthorizingRealm {
	@Resource
	private UserService userService;

	@Resource
	private LogService logService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String userCode = (String) principals.getPrimaryPrincipal();
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		Set<String> sroles = new HashSet<String>();
		Set<String> permissions = new HashSet<String>();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		if (session.getAttribute("stringRoles") == null) {
			List<Role> set = userService.selectRolesByUserCode(userCode);
			if (set != null && set.size() > 0) {
				for (Role role : set) {
					authorizationInfo.addRole(role.getRoleCode());
					sroles.add(String.valueOf(role.getRoleCode()));
				}
			}
			session.setAttribute("stringRoles", sroles.toString());

		} else {
			Set<String> set = new HashSet<String>();
			String str = (String) session.getAttribute("stringRoles");
			set.add(str.substring(1, str.length() - 1));
			authorizationInfo.setRoles(set);
		}

		if (session.getAttribute("stringPermissions") == null) {
			List<com.cdsoft.platform.entity.Resource> setResouce = userService.selectResourceByUserCode(userCode);
			if (setResouce != null && setResouce.size() > 0) {
				for (com.cdsoft.platform.entity.Resource resource : setResouce) {
					authorizationInfo.addStringPermission(resource.getPermission());
					permissions.add(String.valueOf(resource.getPermission()));
				}
				session.setAttribute("stringPermissions", permissions.toString());
			}

		} else {
			Set<String> set = new HashSet<String>();
			String str = (String) session.getAttribute("stringPermissions");
			set.add(str.substring(1, str.length() - 1));
			authorizationInfo.setStringPermissions(set);
		}

		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		Log log = new Log();
		String userCode = (String) token.getPrincipal();
		log.setUserCode(userCode);
		log.setLogIp(token.toString().substring(token.toString().indexOf("(") + 1, token.toString().indexOf(")")));
		log.setLogType("电脑端登陆");
		log.setLogTime(new Date());
		User user = null;
		try {
			user = userService.selectUserByUserCode(userCode.toLowerCase());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (user == null) {
			log.setLogInfo("该用户不存在");
			logService.insertLog(log);
			throw new UnknownAccountException();// 没找到帐号
		}

		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("usercode", user.getUserCode());
		map.put("username", user.getUserName());
		session.setAttribute("user", map);
		log.setLogInfo("用户名密码登陆");
		logService.insertLog(log);
		return new SimpleAuthenticationInfo(user.getUserCode(), user.getPassword(), user.getUserName());
	}
}
