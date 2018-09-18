package sos.haruhi.shiro.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import sos.haruhi.shiro.dao.IUserDao;
import sos.haruhi.shiro.kit.ShiroKit;
import sos.haruhi.shiro.model.Res;
import sos.haruhi.shiro.model.User;
import sos.haruhi.shiro.service.IUserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/18 21:34
 * @Version 10032
 **/
@Service
public class UserService implements IUserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Resource
    private IUserDao userDao;

    @Override
    public void add(User user) {
        if(user == null || StringUtils.isBlank(user.getUsername())){
            logger.error("用户名为空");
            throw new RuntimeException("用户名空");
        }
        user.setPassword(ShiroKit.md5(user.getPassword(), user.getUsername()));
        userDao.add(user);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User load(int id) {
        return userDao.load(id);
    }

    @Override
    public User loadByUsername(String username) {
        return userDao.loadByUsername(username);
    }

    @Override
    public User login(String username, String password) {
        User u = userDao.loadByUsername(username);
        if(u == null){
            logger.error("用户信息异常");
            throw new UnknownAccountException("用户信息异常");
        }
        if(StringUtils.isNotBlank(password)){
            if(StringUtils.equals(ShiroKit.md5(password, username), u.getPassword())){
                if(u.getStatus() == -1){
                    logger.error("账户锁定");
                    throw new LockedAccountException("账户锁定");
                }else {
                    return u;
                }
            }else{
                logger.error("用户密码错误");
                throw new IncorrectCredentialsException("用户密码错误");
            }
        }else{
            logger.error("用户密码不能为空");
            throw new IncorrectCredentialsException("用户密码不能为空");
        }
    }

    @Override
    public List<User> list() {
        return userDao.listUser();
    }

    @Override
    public List<User> listUsersByRole(int roleId) {
        return userDao.listUsersByRole(roleId);
    }

    @Override
    public List<Res> listResesByUser(int userId) {
        return userDao.listResesByUser(userId);
    }
}
