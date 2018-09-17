package sos.nagato.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @ClassName PasswordTestRealm
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/17 20:25
 * @Version 10032
 **/
public class PasswordTestRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        return new SimpleAuthenticationInfo("haruhi",
                "$shiro1$SHA-256$500000$36+E+2QIPtOzFTIvzbURrw==$chlNnMr6DgyeSOJS6MlQ9TKbJq/c+EH8Jz89SO0PuIU=", getName());
    }
}
