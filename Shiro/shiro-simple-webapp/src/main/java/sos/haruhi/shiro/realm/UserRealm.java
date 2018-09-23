package sos.haruhi.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sos.haruhi.shiro.model.Res;
import sos.haruhi.shiro.model.User;
import sos.haruhi.shiro.service.IUserService;
import sos.haruhi.shiro.web.InitServlet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName UserRealm
 * @Description shiro realm 源配置
 * @Author Suzumiya Haruhi
 * @Date 2018/9/20 21:19
 * @Version 10032
 **/
public class UserRealm extends AuthorizingRealm {
    private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);

    // 设置用户的角色权限信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user = (User) principals.getPrimaryPrincipal();
        int uid = user.getId();
        logger.info(user.toString());

        IUserService userService = (IUserService) InitServlet.getApplicationContext().getBean("userService");

        // I. 获取用户所有角色 sn
        List<String> roleSns = userService.listRoleSnsByUser(uid);

        // II. 获取用户所有权限 permission
        List<Res> reses = userService.listResesByUser(uid);

        Set<String> permissions = new HashSet<String>();
        for(Res res:reses){
            permissions.add(res.getUrl());
        }

        // III. 为用户设置 角色/权限 信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(new HashSet<>(roleSns));
        info.setStringPermissions(new HashSet<>(permissions));

        return info;
    }

    // 进行用户的省份认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        IUserService userService = (IUserService) InitServlet.getApplicationContext().getBean("userService");
        String username = token.getPrincipal().toString();
        String passworld = new String((char[])token.getCredentials());

        User user = userService.login(username, passworld);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
        // 使用 md5 盐值 hash 认证密码规则
        info.setCredentialsSalt(ByteSource.Util.bytes(user.getUsername()));

        return info;
    }
}
