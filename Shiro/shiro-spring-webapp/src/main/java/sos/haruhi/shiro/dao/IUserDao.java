package sos.haruhi.shiro.dao;

import sos.haruhi.shiro.model.Res;
import sos.haruhi.shiro.model.User;
import sos.nagato.ibasedao.IBaseDao;

import java.util.List;

public interface IUserDao extends IBaseDao<User> {
    public List<User> listUser();

    public User loadByUsername(String username);

    public List<User> listUsersByRole(int roleId);

    public List<Res> listResesByUser(int userId);

    public List<String> listRoleSnsByUser(int userId);

}
