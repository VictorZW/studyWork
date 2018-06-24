package com.cdsoft.mcm.sso.controller;

import com.cdsoft.mcm.sso.service.IUserAuthService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 单点登陆验证服务控制层，为移动端提供验证
 */

@Controller
@RequestMapping("android/doUserAuthForMobile")
public class UserAuthAction {
    private static final Logger logger = Logger.getLogger(UserAuthAction.class);
    @Resource
    private IUserAuthService userAuthService;


    /**
     * 对用户登录信息进行验证
     *
     * @return 返回验证结果
     */
    @RequestMapping("userAuth")
    @ResponseBody
    public HashMap<String, Object> userAuth(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            String userId = request.getParameter("userId");
            String passWord = request.getParameter("passWord");
            logger.warn("进行用户登录信息验证....");
            //验证移动客户端的登录用户名、密码是否为空
            if (StringUtils.isBlank(userId) || StringUtils.isBlank(passWord)) {
                resultMap.put("STATUS", "error");
                resultMap.put("CONTENT", "用户名或者密码为空!");
                return resultMap;
            } else {
                resultMap = userAuthService.userAuth(userId, passWord);
            }
        } catch (Exception e) {
            logger.error("UserAuthAction.userAuth对用户登录信息进行验证出错！");
            resultMap.put("STATUS", "error");
            resultMap.put("CONTENT", "验证出错!");
            e.printStackTrace();
        }
        return resultMap;
    }
}
