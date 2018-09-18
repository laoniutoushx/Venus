package sos.haruhi.shiro.dao.impl;

import org.springframework.stereotype.Repository;
import sos.haruhi.shiro.dao.IUserDao;
import sos.haruhi.shiro.model.Res;
import sos.haruhi.shiro.model.User;
import sos.nagato.basedao.BaseDao;

import java.util.List;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/18 20:57
 * @Version 10032
 **/
@Repository
public class UserDao extends BaseDao<User> implements IUserDao {
    @Override
    public List<User> listUser() {
        return super.list("from User");
    }

    @Override
    public User loadByUsername(String username) {
        return (User) super.queryObject("from User u where u.username = ?", username);
    }

    @Override
    public List<User> listUsersByRole(int roleId) {
        return super.list("select u from User u, Role r, UserRole ur " +
                "where u.id = ur.userId and r.id = ur.roleId and r.id = ?", roleId);
    }

    @Override
    public List<Res> listResesByUser(int userId) {
        return super.listObj("select r from Res r, RoleRes rr, UserRole ur " +
                "where r.id = rr.resId and rr.roleId = ur.roleId and ur.userId = ?", userId);
    }


}
