package Venus;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import sos.nagato.ibasedao.IBaseDao;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Unit test for simple App.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/spring-hibernate.xml"})
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=true)
@Transactional
public class AppTest {

    @Resource
    private IBaseDao baseDao;

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue(){

    }
}
