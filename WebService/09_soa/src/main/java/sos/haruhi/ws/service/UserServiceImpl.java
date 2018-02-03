package sos.haruhi.ws.service;

import sos.haruhi.ws.dao.UserDao;
import sos.haruhi.ws.dao.UserException;
import sos.haruhi.ws.pojo.User;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "sos.haruhi.ws.service.IUserService",
            wsdlLocation = "WEB-INF/user.wsdl",
            targetNamespace = "http://sos.haruhi.ws/test/",
            serviceName = "UserService",
            portName = "UserServicePort")
public class UserServiceImpl implements IUserService {
    private UserDao userDao = UserDao.newInstance();
    @Override
    public void add(User user) throws UserException {
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
}
