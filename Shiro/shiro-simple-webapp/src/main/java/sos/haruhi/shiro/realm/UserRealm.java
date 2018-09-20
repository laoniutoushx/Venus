package sos.haruhi.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import sos.haruhi.shiro.model.User;
import sos.haruhi.shiro.service.IUserService;
import sos.haruhi.shiro.web.InitServlet;

/**
 * @ClassName UserRealm
 * @Description shiro realm 源配置
 * @Author Suzumiya Haruhi
 * @Date 2018/9/20 21:19
 * @Version 10032
 **/
public class UserRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        IUserService userService = (IUserService) InitServlet.getApplicationContext().getBean("userService");
        String username = token.getPrincipal().toString();
        String passworld = new String((char[])token.getCredentials());

        User user = userService.login(username, passworld);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
        info.setCredentialsSalt(ByteSource.Util.bytes(user.getUsername()));

        return info;
    }
}
