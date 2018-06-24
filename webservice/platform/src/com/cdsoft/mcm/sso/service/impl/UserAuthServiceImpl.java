package com.cdsoft.mcm.sso.service.impl;

import com.cdsoft.mcm.sso.service.IUserAuthService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import java.io.InputStream;
import java.util.*;

/**
 * 单点登陆实现接口
 * 验证逻辑：
 * 1.获取移动端登录时的用户名、密码；
 * 2.
 */
@Service
public class UserAuthServiceImpl implements IUserAuthService {
    private static final Logger logger = Logger.getLogger(UserAuthServiceImpl.class);
    private InputStream fis = null;
    private Properties config = new Properties();

    public UserAuthServiceImpl() {
        super();
        try {
            fis = UserAuthServiceImpl.class.getClassLoader().getResourceAsStream("/ldap.properties");
            config.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public HashMap<String, Object> userAuth(String userId, String password) {
        HashMap<String, Object> resultMap = new HashMap<>();
        String username = "";
        //查询登录的用户名是否存在
        ArrayList<String> userlist = getUserFromLdap(userId);
        if (userlist == null || userlist.size() == 0) {
            logger.debug("移动端登录验证：用户名不存在");
            resultMap.put("STATUS", "error");
            resultMap.put("CONTENT", "用户名不存在");
            return resultMap;
        }

        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.SECURITY_PRINCIPAL, userId);
        env.put(Context.SECURITY_CREDENTIALS, password);
        env.put(Context.INITIAL_CONTEXT_FACTORY, config.get("initial").toString());
        env.put(Context.PROVIDER_URL, config.get("ldapURL").toString());

        try {
            DirContext ctx = new InitialDirContext(env);
            if (ctx != null) {
                SearchControls constraints = new SearchControls();
                constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
                NamingEnumeration en = ctx.search("o=hdpi", "uid=" + userId, constraints);
                if (en != null) {
                    Object obj = null;
                    while (en.hasMoreElements()) {
                        obj = en.next();
                        if (obj instanceof SearchResult) {
                            SearchResult si = (SearchResult) obj;
                            String ouname = si.getName();
                            if (ouname.contains("OU")) {
                                String[] ou = ouname.split("OU=");
                                String dept = ou[ou.length - 1];
                                if (dept.contains("区域")) {
                                    dept = ou[ou.length - 2];
                                }
                                username = ouname.split("CN=")[1].split(",OU=")[0];
                                if (dept.contains(",")) {
                                    dept = dept.split(",")[0];
                                }
                                resultMap.put("DEPT", dept);
                            }
                        }
                    }
                }

                resultMap.put("STATUS", "success");
                resultMap.put("CONTENT", "验证成功");
                resultMap.put("userId", userId);
                resultMap.put("username", username);
                return resultMap;
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
            logger.debug("密码错误" + "验证时间：" + new Date());
            resultMap.put("STATUS", "error");
            resultMap.put("CONTENT", "密码错误");
            return resultMap;
        } catch (NamingException e) {
            e.printStackTrace();
            logger.debug("验证失败" + "验证时间：" + new Date());
            resultMap.put("STATUS", "error");
            resultMap.put("CONTENT", "验证失败");
            return resultMap;
        }

        resultMap.put("STATUS", "error");
        resultMap.put("CONTENT", "验证失败");
        return resultMap;
    }

    /**
     * 根据移动客户端登录的用户名，取ldap查询该用户名是否存在
     *
     * @return
     */
    private ArrayList<String> getUserFromLdap(String userId) {
        ArrayList<String> userlist = new ArrayList<String>();
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, config.get("initial").toString());
        env.put(Context.SECURITY_PRINCIPAL, config.get("ldapUser").toString());
        env.put(Context.SECURITY_CREDENTIALS, config.get("ldapPass").toString());
        env.put(Context.PROVIDER_URL, config.get("ldapURL").toString());
        DirContext ctx;
        try {
            ctx = new InitialDirContext(env);
            SearchControls constraints = new SearchControls();
            constraints.setSearchScope(2);
            for (NamingEnumeration en = ctx.search("", "uid=" + userId, constraints); en != null && en.hasMoreElements(); ) {
                Object obj = en.nextElement();
                if (obj instanceof SearchResult) {

                    SearchResult si = (SearchResult) obj;
                    String ouname = si.getName();
                    userlist.add(ouname);
                }
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return userlist;
    }

}
