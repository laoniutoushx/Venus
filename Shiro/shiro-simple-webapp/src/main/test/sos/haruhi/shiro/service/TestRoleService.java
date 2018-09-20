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
import sos.haruhi.shiro.model.Role;

import javax.annotation.Resource;

/**
 * @ClassName TestRoleService
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/20 20:07
 * @Version 10032
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-core.xml")
public class TestRoleService {
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
    private IRoleService roleService;

    @Test
    public void testAdd(){
        Role r = new Role();
        r.setRolename("管理员");
        r.setSn("ADMIN");
        roleService.add(r);

        r = new Role();
        r.setRolename("普通用户");
        r.setSn("CUSTOMER");
        roleService.add(r);

        r = new Role();
        r.setRolename("来宾");
        r.setSn("GUEST");
        roleService.add(r);
    }

    @Test
    public void testAddUserRole(){
        roleService.addUserRole(1, 2);  // 春日     - 普通用户
        roleService.addUserRole(1, 3);  // 春日     - 来宾
        roleService.addUserRole(2, 1);  // 管理员   - 管理员
        roleService.addUserRole(3, 3);  // 测试人员 - 来宾
    }

}
