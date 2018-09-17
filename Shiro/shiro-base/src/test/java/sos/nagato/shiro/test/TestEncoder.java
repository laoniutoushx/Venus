package sos.nagato.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName TestEncoder
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/17 20:18
 * @Version 10032
 **/
public class TestEncoder {
    private static final Logger logger = LoggerFactory.getLogger(TestBase.class);

    private SecurityManager _manager_password;              // 密码 realm 测试

    @Before
    public void createSecurityManager(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-password.ini");
        _manager_password = factory.getInstance();
    }

    public Subject login(String username, String password){
        SecurityUtils.setSecurityManager(_manager_password);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);

        return subject;
    }

    @Test
    public void testEnocde(){
        String password = new Md5Hash("123", "admin").toString();
        logger.info(password);
        logger.info(new Md5Hash("123", "admin").toString());
    }

    /**
     * @title:  testPasswordService
     * @desc:   使用 password service 进行密码比较
     * @param:  []
     * @return: void
     * @auther: Suzumiya Haruhi
     * @date:   2018/9/17 21:09
     **/
    @Test
    public void testPasswordService(){
        PasswordService passwordService = new DefaultPasswordService();
        String str = passwordService.encryptPassword("123");
        String str1 = passwordService.encryptPassword("123");
        logger.info(String.valueOf(str.equals(str1)));
        /***
         * 使用 PasswordService 来比较 用户登陆密码的方式
         * 盐值存在于加密字串当中  即 str1 当中
         */
        logger.info(String.valueOf(passwordService.passwordsMatch("123", str1)));
    }

    @Test
    public void testPasswordRealm(){
        login("haruhi", "123");
    }
}
