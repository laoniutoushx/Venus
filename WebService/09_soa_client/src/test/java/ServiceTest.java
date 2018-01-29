import org.junit.Before;
import org.junit.Test;
import sos.haruhi.ws.client.IUserService;
import sos.haruhi.ws.client.User;
import sos.haruhi.ws.client.UserService;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ServiceTest {
    private IUserService port;
    private UserService us;

    @Before
    public void init() throws MalformedURLException {
        URL url = new URL("http://localhost:9999/ws?wsdl");
        QName qName = new QName("http://sos.haruhi.ws/test/", "UserService");
        us = new UserService(url, qName);
        port = us.getUserServicePort();
    }

    @Test
    public void testList(){
        List<User> list = port.list();
        for(User u:list){
            System.out.println(u.getNickname());
        }
    }

    @Test
    public void testAdd(){
        User u = new User();
        u.setUsername("zhangsan");
        u.setPassword("123");
        u.setNickname( "张三");
        port.add(u);
    }
}
