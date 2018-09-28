package sos.haruhi.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * @ClassName AuthenticationTest
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/28 19:44
 * @Version 10032
 **/
public class AuthenticationTest {

    // 认证/授权 领域/源/范围
    SimpleAccountRealm realm = new SimpleAccountRealm();

    @Before
    public void addUser(){
        realm.addAccount("admin", "111111", "admin", "user");
    }

    /**
     * @title:  testAuthentication
     * @desc:   认证
     * @param:  []
     * @return: void
     * @auther: Suzumiya Haruhi
     * @date:   2018/9/28 20:17
     **/
    @Test
    public void testAuthentication(){
        // 1. 构建 SecurityManager 环境
        DefaultSecurityManager manager = new DefaultSecurityManager(realm);

        // 2. 主体提交认证请求
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();

        // 3. 提交认证
        UsernamePasswordToken token = new UsernamePasswordToken("admin", "111111");
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        System.out.println("登陆成功");
        System.out.println("是否认证：" + subject.isAuthenticated());

        subject.checkRole("user");

        System.out.println("推出登陆");
        subject.logout();
        System.out.println("是否认证：" + subject.isAuthenticated());


    }
}
