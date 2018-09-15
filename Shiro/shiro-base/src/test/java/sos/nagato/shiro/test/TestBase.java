package sos.nagato.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName TestBase
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/15 16:12
 * @Version 10032
 **/

public class TestBase {

    private static final Logger log = LoggerFactory.getLogger(TestBase.class);

    private SecurityManager manager;

    @Before
    public void createSecurityManager(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        manager = factory.getInstance();
    }

    @Test
    public void testBase(){

        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("admin", "123456");
        try {
            subject.login(token);
            PrincipalCollection principals = subject.getPrincipals();
            log.info("认证返回信息：" + principals.asList());
            log.info("认证返回 Realms：" + principals.getRealmNames());
            log.info("认证用户：" + subject.getPrincipal());

        } catch (UnknownAccountException uae) {
            log.info("There is no user with username of " + token.getPrincipal());
        } catch (IncorrectCredentialsException ice) {
            log.info("Password for account " + token.getPrincipal() + " was incorrect!");
        } catch (LockedAccountException lae) {
            log.info("The account for username " + token.getPrincipal() + " is locked.  " +
                    "Please contact your administrator to unlock it.");
        }
        // ... catch more exceptions here (maybe custom ones specific to your application?
        catch (AuthenticationException ae) {
            //unexpected condition?  error?
            log.info("错误：" + ae.getMessage());
        }catch (Exception e){
            log.info("错误：" + e.getMessage());
        }
    }
}
