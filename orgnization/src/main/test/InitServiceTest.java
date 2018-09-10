import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import sos.haruhi.auth.iservice.IControllerResService;
import sos.haruhi.sys.iservice.IInitService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-hibernate.xml")
public class InitServiceTest {

    @Resource
    private IInitService initService;

    @Resource
    private IControllerResService controllerResService;

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

    @Test
    public void testInitByXml() {
        initService.initEntityByXml("orgs.xml");
    }

    @Test
    public void testInitByXmlAuth() {
        initService.initEntityByXml("auth.xml");
    }

    @Test
    public void testInitRes(){
        controllerResService.initControllerRes(new String[]{"sos.haruhi.web.controller"});
    }
}
