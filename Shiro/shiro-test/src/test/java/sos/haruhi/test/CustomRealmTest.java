package sos.haruhi.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import sos.haruhi.shiro.CustomRealm;

/**
 * @ClassName CustomRealmTest
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/29 20:53
 * @Version 10032
 **/
public class CustomRealmTest {

    @Test
    public void authentication(){
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        CustomRealm customRealm = new CustomRealm();
        defaultSecurityManager.setRealm(customRealm);

        // 加密
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("md5");
        credentialsMatcher.setHashIterations(1);        // 散列次数
        customRealm.setCredentialsMatcher(credentialsMatcher);


        SecurityUtils.setSecurityManager(defaultSecurityManager);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("admin", "111111");

        try {
            subject.login(usernamePasswordToken);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        subject.isAuthenticated();
        subject.checkRole("admin");
        subject.checkPermission("user:list");
        subject.checkPermissions("user:add", "user:list");
    }
}
