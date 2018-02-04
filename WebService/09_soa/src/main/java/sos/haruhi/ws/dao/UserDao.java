package sos.haruhi.ws.dao;

import sos.haruhi.ws.pojo.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao {

    public static final Map<String, User> users = new HashMap<String, User>();
    private static UserDao userDao = null;
    public static UserDao newInstance(){
        if(userDao == null){
            userDao = new UserDao();
        }
        return userDao;
    }

    private UserDao(){
        User u = new User();
        u.setUsername("admin");
        u.setPassword("123");
        u.setNickname("管理员");
        users.put("admin", u);
    }

    public void add(User user) throws UserException {
        if(users.containsKey(user.getUsername())){
            throw new UserException("用户已经存在");
        }
        users.put(user.getUsername(), user);
    }
    public void del(String username){
        users.remove(username);
    }
    public List<User> list(){
        return new ArrayList<>(users.values());
    }
    public User login(String username, String password) throws UserException {
        if(!users.containsKey(username)){
            throw new UserException("用户不存在");
        }
        if(!password.equals(users.get(username).getPassword())){
            throw new UserException("用户密码不正确");
        }
        User u = users.get(username);
        return u;
    }
}
