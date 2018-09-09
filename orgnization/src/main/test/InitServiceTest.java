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

    @Test
    public void testInitByXml() {
        initService.initEntityByXml("orgs.xml");
    }

    @Test
    public void testInitByXmlAuth() {
        initService.initEntityByXml("auth.xml");
    }
}
