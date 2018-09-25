package sos.haruhi.shiro.service;

import sos.haruhi.shiro.model.Res;
import sos.haruhi.shiro.model.User;

import java.util.List;

public interface IUserService {
    public void add(User user);

    public void add(User user, List<Integer> rids);

    public void delete(int id);

    public void update(User user);

    public void update(User user, List<Integer> rids);

    public User load(int id);

    public User loadByUsername(String username);

    public User login(String username, String password);

    public List<User> list();

    public List<User> listUsersByRole(int roleId);

    public List<Res> listResesByUser(int userId);

    public List<String> listRoleSnsByUser(int userId);

}