package sos.haruhi.shiro.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import sos.haruhi.shiro.model.User;

import javax.annotation.Resource;

/**
 * @ClassName TestUserService
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/19 21:10
 * @Version 10032
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-core.xml")
public class TestUserService {

    @Resource
    private SessionFactory sessionFactory;

    @Before
    public void setUp() {
        //此时最好不要使用Spring的Transactional来管理，因为dbunit是通过jdbc来处理connection，再使用spring在一些编辑操作中会造成事务shisu
        Session s = sessionFactory.openSession();
        TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));
        //SystemContext.setRealPath("D:\\teach_source\\class2\\j2EE\\dingan\\cms-da\\src\\main\\webapp");
    }

    @After
    public void tearDown() {
        SessionHolder holder = (SessionHolder) TransactionSynchronizationManager.getResource(sessionFactory);
        Session s = holder.getSession();
        s.flush();
        TransactionSynchronizationManager.unbindResource(sessionFactory);
    }

    @Resource
    private IUserService userService;

    @Test
    public void testAdd(){
//        User u = new User();
//        u.setUsername("haruhi");
//        u.setPassword("6656200");
//        u.setNickname("春日");
//        u.setStatus(1);
//        userService.add(u);
    }

}
