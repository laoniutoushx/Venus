package sos.haruhi.ws.service;

import com.sun.xml.ws.api.message.Header;
import com.sun.xml.ws.api.message.HeaderList;
import com.sun.xml.ws.developer.JAXWSProperties;
import org.apache.commons.beanutils.BeanUtils;
import sos.haruhi.ws.dao.UserDao;
import sos.haruhi.ws.dao.UserException;
import sos.haruhi.ws.pojo.User;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import javax.xml.ws.WebServiceContext;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebService(endpointInterface = "sos.haruhi.ws.service.IUserService",
            wsdlLocation = "WEB-INF/user.wsdl",
            targetNamespace = "http://sos.haruhi.ws/test/",
            serviceName = "UserService",
            portName = "UserServicePort")
public class UserServiceImpl implements IUserService {
    private UserDao userDao = UserDao.newInstance();

    @Resource
    private WebServiceContext ctx;

    @Override
    public void add(User user) throws UserException, XMLStreamException {
        checkRegister();
        userDao.add(user);
    }

    @Override
    public void del(String username) {
        userDao.del(username);
    }

    @Override
    public List<User> list() {
        return userDao.list();
    }

    @Override
    public User login(String username, String password) throws UserException {
        return userDao.login(username, password);
    }

    public void checkRegister() throws XMLStreamException, UserException {
        // 从消息头中获取相应的信息，应且进行相应的判断。
        HeaderList headers = (HeaderList) ctx.getMessageContext().get(JAXWSProperties.INBOUND_HEADER_LIST_PROPERTY);
        QName name = new QName("http://sos.haruhi.ws/test/", "license");
        Header header = headers.get(name, true);
        XMLStreamReader xsr =  header.readHeader();

        User u = x2user(xsr);
        if(UserDao.users.containsKey(u.getUsername())){
            throw new UserException("用户已添加");
        }

    }

    private User x2user(XMLStreamReader xsr) throws XMLStreamException {
        User u = new User();
        while(xsr.hasNext()){
            int event = xsr.next();
            if(event == XMLEvent.START_ELEMENT){

                if("username".equals(xsr.getLocalName())) {
                    u.setUsername(xsr.getElementText());
                }
                if("password".equals(xsr.getLocalName())) {
                    u.setPassword(xsr.getElementText());
                }
                if("nickname".equals(xsr.getLocalName())) {
                    u.setNickname(xsr.getElementText());
                }

            }
        }
        return u;
    }
}
