package sos.nagato.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @ClassName TestBase
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/15 16:12
 * @Version 10032
 **/

public class TestBase {

    private static final Logger logger = LoggerFactory.getLogger(TestBase.class);

    private SecurityManager _manager_authentication;        // 认证
    private SecurityManager _manager_authorization;         // 授权

    @Before
    public void createSecurityManager(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        _manager_authentication = factory.getInstance();

        factory = new IniSecurityManagerFactory("classpath:shiro-role.ini");
        _manager_authorization = factory.getInstance();
    }

    public Subject login(String username, String password){
        SecurityUtils.setSecurityManager(_manager_authorization);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);

        return subject;
    }

    @Test
    public void testBase(){

        SecurityUtils.setSecurityManager(_manager_authentication);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("admin", "000000");
        try {
            subject.login(token);
            PrincipalCollection principals = subject.getPrincipals();
            logger.info("认证返回信息：" + principals.asList());
            logger.info("认证返回 Realms：" + principals.getRealmNames());
            logger.info("认证用户：" + subject.getPrincipal());

        } catch (UnknownAccountException uae) {
            logger.info("There is no user with username of " + token.getPrincipal());
        } catch (IncorrectCredentialsException ice) {
            logger.info("Password for account " + token.getPrincipal() + " was incorrect!");
        } catch (LockedAccountException lae) {
            logger.info("The account for username " + token.getPrincipal() + " is locked.  " +
                    "Please contact your administrator to unlock it.");
        }
        // ... catch more exceptions here (maybe custom ones specific to your application?
        catch (AuthenticationException ae) {
            //unexpected condition?  error?
            logger.info("错误：" + ae.getMessage());
        }catch (Exception e){
            logger.info("错误：" + e.getMessage());
        }
    }

    // 资源 → 角色 → 权限
    @Test
    public void testRole(){
        Subject subject = login("haruhi", "6656200");

        PrincipalCollection principals = subject.getPrincipals();

        logger.info("hasRole：" + subject.hasRole("admin"));
        logger.info("hasAllRoles：" + subject.hasAllRoles(Arrays.asList("admin", "guest")));
        logger.info("hasRoles：" + Arrays.toString(subject.hasRoles(Arrays.asList("admin", "guest", "root"))) + "\n");

        logger.info("认证返回信息：" + principals.asList());
        logger.info("认证返回 Realms：" + principals.getRealmNames());
        logger.info("认证用户：" + subject.getPrincipal());


        subject.checkRole("root");

    }

    // 资源 → 操作 → 实例
    @Test
    public void testPermission(){
        Subject subject = login("haruhi", "6656200");

        logger.info("hasPermited：" + subject.isPermitted("user:create"));

        logger.info("hasPermited：" + subject.isPermitted("topic:create"));
    }

    @Test
    public void testMyPermission(){
        Subject subject = login("haruhi", "6656200");

        logger.info(String.valueOf(subject.isPermitted("+user+create+")));

        logger.info(String.valueOf(subject.isPermitted("+topic+read+4")));

        logger.info(String.valueOf(subject.isPermitted("+topic+delete+1")));

        logger.info(String.valueOf(subject.isPermitted("classroom:add")));
    }
}
