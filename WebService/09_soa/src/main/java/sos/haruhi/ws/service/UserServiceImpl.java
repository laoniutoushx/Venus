package sos.haruhi.ws.service;

import com.sun.xml.ws.api.message.Header;
import com.sun.xml.ws.api.message.HeaderList;
import com.sun.xml.ws.developer.JAXWSProperties;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FileUtils;
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
import javax.xml.ws.soap.MTOM;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebService(endpointInterface = "sos.haruhi.ws.service.IUserService",
            wsdlLocation = "WEB-INF/user.wsdl",
            targetNamespace = "http://sos.haruhi.ws/test/",
            serviceName = "UserService",
            portName = "UserServicePort")
@MTOM
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

    @Override
    public void upload(byte[] file) {
        try {
            FileUtils.writeByteArrayToFile(new File("S:/haruhi.jpg"), file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkRegister() throws XMLStreamException, UserException {
        // 基于 JAXWS-RI 的方法获取 headers

        // headers.create(element)  可以把 dom 的 element 转换为 Header 元素

        // 需要引入  jaxws-rt  jaxws-ri

        // 从消息头中获取相应的信息，应且进行相应的判断。
        HeaderList headers = (HeaderList) ctx.getMessageContext().get(JAXWSProperties.INBOUND_HEADER_LIST_PROPERTY);
        QName name = new QName("http://sos.haruhi.ws/test/", "license");
        if(headers == null){
            throw new UserException("该功能需要权限控制");
        }
        Header header = headers.get(name, true);
        if (header == null) {
            throw new UserException("该功能需要权限控制");
        }
        XMLStreamReader xsr =  header.readHeader();

        User u = x2user(xsr);       //  转换 消息头 header 权限用户信息为 User 对象
        System.out.println(u.getUsername());
        if(!UserDao.users.containsKey(u.getUsername())){
            throw new UserException("你所访问的数据的用户不是授权用户");
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
