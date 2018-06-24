package com.cdsoft.mcm.sso.service;

import java.util.HashMap;

/**
 * idap 单点登录服务借口
 */
public interface IUserAuthService {
    /**
     * 单点登陆验证方法
     * @param userId 用户ID
     * @param password 用户密码
     * @return 验证结果
     */
    public HashMap<String, Object> userAuth(String userId, String password);
}
