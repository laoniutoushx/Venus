package sos.haruhi.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @ClassName IniRealmTest
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/28 20:42
 * @Version 10032
 **/
public class IniRealmTest {


    @Test
    public void authentication(){
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        IniRealm iniRealm = new IniRealm("classpath:user.ini");
        defaultSecurityManager.setRealm(iniRealm);

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
        subject.checkPermissions("user:add", "user:reset");
    }
}
