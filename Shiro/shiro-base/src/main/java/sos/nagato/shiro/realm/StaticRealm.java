package sos.nagato.shiro.realm;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import sos.nagato.shiro.permission.MyPermission;

/**
 * @ClassName StaticRealm
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/15 18:34
 * @Version 10032
 **/
public class StaticRealm extends AuthorizingRealm {

    /**
     * @title:  doGetAuthorizationInfo
     * @desc:   用来判断授权
     *         登陆完成之后进行授权  通过 realm 获取相关主体 的 授权信息
     * @param:  [principalCollection]
     * @return: org.apache.shiro.authz.AuthorizationInfo
     * @auther: Suzumiya Haruhi
     * @date:   2018/9/15 18:35
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRole("admin");
        authorizationInfo.addStringPermission("+user+*");
        authorizationInfo.addObjectPermission(new MyPermission("+topic+create"));
        authorizationInfo.addObjectPermission(new MyPermission("+topic+delete+1"));
        return authorizationInfo;
    }

    /**
     * @title:  doGetAuthenticationInfo
     * @desc:   用来判断认证
     * @param:  [authenticationToken]
     * @return: org.apache.shiro.authc.AuthenticationInfo
     * @auther: Suzumiya Haruhi
     * @date:   2018/9/15 18:35
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = authenticationToken.getPrincipal().toString();   // 获取用户名
        String password = new String((char[])authenticationToken.getCredentials());
        System.out.println(username + ", " + password);

        if(!"haruhi".equals(username)){
            throw new UnknownAccountException("用户名异常");
        }
        if(!StringUtils.equals(password, "6656200")){
            throw new IncorrectCredentialsException("用户密码异常");
        }

        AuthenticationInfo authInfo = new SimpleAuthenticationInfo(username, password, getName());
        return authInfo;
    }
}
