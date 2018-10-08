package sos.haruhi.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName CustomRealm
 * @Description 自定义领域
 * @Author Suzumiya Haruhi
 * @Date 2018/9/29 20:45
 * @Version 10032
 **/
public class CustomRealm extends AuthorizingRealm {

    Map<String, String> userMap = new HashMap<>();
    {
        userMap.put("admin", "efd9d1b8bfb00e8e3647990f7d74d1d8");   // 111111 / admin
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取用户凭证
        String username = (String) principals.getPrimaryPrincipal();

        // 获取用户角色
        Set<String> roles = getRolesByUsername(username);

        // 获取用户权限
        Set<String> permissions = getPermissionsByUsername(username);

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(permissions);

        return authorizationInfo;
    }

    private Set<String> getPermissionsByUsername(String username) {
        Set<String> permissions = new HashSet<>();
        permissions.add("user:add");
        permissions.add("user:list");
        return permissions;
    }

    private Set<String> getRolesByUsername(String username) {
        Set<String> roles = new HashSet<>();
        roles.add("admin");
        roles.add("custom");
        return roles;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //  获取用户输入凭证（用户名）
        String username = (String) token.getPrincipal();
        System.out.println("Username:" + username);

        //  通过用户名获取密码（数据库）
        String password = getPasswordByUsername(username);
        System.out.println("Password:" + password);
//        Assert.assertNotNull(password);

        //  返回认证信息
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password, "customRealm");
        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(username));     // 加盐
        return simpleAuthenticationInfo;
    }

    private String getPasswordByUsername(String username){
        return userMap.get(username);
    }

    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("111111", "admin");
        System.out.println(md5Hash.toString());
    }
}
