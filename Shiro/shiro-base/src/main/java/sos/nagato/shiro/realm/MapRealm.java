package sos.nagato.shiro.realm;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MapRealm
 * @Description Realm 进行用户认证
 * @Author Suzumiya Haruhi
 * @Date 2018/9/15 16:36
 * @Version 10032
 **/
public class MapRealm implements Realm {

    private static Map<String, String> users;

    static {
        users = new HashMap<>();
        users.put("admin", "0");
        users.put("guest", "0");
    }

    @Override
    public String getName() {
        return "mapReals";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    /**
     * @title:  getAuthenticationInfo
     * @desc:   用户信息
     * @param:  [authenticationToken]   用户凭证
     * @return: org.apache.shiro.authc.AuthenticationInfo
     * @auther: Suzumiya Haruhi
     * @date:   2018/9/15 16:47
     **/
    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String username = authenticationToken.getPrincipal().toString();   // 获取用户名
        String password = new String((char[])authenticationToken.getCredentials());
        System.out.println(username + ", " + password);
        if(!users.keySet().contains(username)){
            throw new UnknownAccountException("用户名异常");
        }
        if(!StringUtils.equals(password, users.get(username))){
            throw new IncorrectCredentialsException("用户密码异常");
        }

        AuthenticationInfo authInfo = new SimpleAuthenticationInfo(username, password, getName());
        return authInfo;
    }
}
