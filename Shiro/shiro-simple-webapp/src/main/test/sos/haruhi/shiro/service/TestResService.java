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
import sos.haruhi.shiro.model.Res;

import javax.annotation.Resource;

/**
 * @ClassName TestResService
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/20 20:23
 * @Version 10032
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-core.xml")
public class TestResService {
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
    private IResService resService;

    @Resource
    private IRoleService roleService;

    @Test
    public void testAdd(){
        Res res = new Res();
        res.setResname("系统管理");
        res.setUrl("/admin/*");
        resService.add(res);

        res = new Res();
        res.setResname("用户添加");
        res.setUrl("/admin/user/add");
        resService.add(res);

        res = new Res();
        res.setResname("用户更新");
        res.setUrl("/admin/user/update/*");
        resService.add(res);

        res = new Res();
        res.setResname("用户状态变更");
        res.setUrl("/admin/user/updateStatus/*");
        resService.add(res);

        res = new Res();
        res.setResname("用户删除");
        res.setUrl("/admin/user/delete");
        resService.add(res);

        res = new Res();
        res.setResname("用户管理");
        res.setUrl("/admin/user/*");
        resService.add(res);

        res = new Res();
        res.setResname("角色添加");
        res.setUrl("/admin/role/add");
        resService.add(res);

        res = new Res();
        res.setResname("角色管理");
        res.setUrl("/admin/role/*");
        resService.add(res);

        res = new Res();
        res.setResname("角色修改");
        res.setUrl("/admin/role/update/*");
        resService.add(res);

        res = new Res();
        res.setResname("资源添加");
        res.setUrl("/admin/res/add");
        resService.add(res);

        res = new Res();
        res.setResname("资源管理");
        res.setUrl("/admin/res/*");
        resService.add(res);

        res = new Res();
        res.setResname("资源修改");
        res.setUrl("/admin/res/update/*");
        resService.add(res);
    }

    @Test
    public void testAddRoleRes(){
        roleService.addRoleRes(1, 1);   // 管理员 - 系统管理
        roleService.addRoleRes(1, 2);   // 管理员 - 用户添加
        roleService.addRoleRes(1, 3);   // 管理员 -
        roleService.addRoleRes(1, 4);   // 管理员 -
        roleService.addRoleRes(1, 5);
        roleService.addRoleRes(1, 6);
        roleService.addRoleRes(1, 7);
        roleService.addRoleRes(1, 8);
        roleService.addRoleRes(1, 9);

        roleService.addRoleRes(2, 4);
        roleService.addRoleRes(2, 2);


    }

}
